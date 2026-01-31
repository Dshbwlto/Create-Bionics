package net.dshbwlto.createbionics.entity.custom;

import net.dshbwlto.createbionics.entity.ai.AnimalFollowOwnerGoal;
import net.dshbwlto.createbionics.entity.client.organ.layers.OrganGlow;
import net.dshbwlto.createbionics.entity.client.organ.layers.OrganVariant;
import net.dshbwlto.createbionics.item.BionicsItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.neoforge.event.EventHooks;
import net.neoforged.neoforge.fluids.FluidType;
import org.jetbrains.annotations.Nullable;

public class OrganEntity extends TamableAnimal {
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public boolean exhaustLoop() {
        return false;
    }

    public final AnimationState sitDownAnimationState = new AnimationState();
    public final AnimationState sitPoseAnimationState = new AnimationState();
    public final AnimationState sitUpAnimationState = new AnimationState();

    public static final EntityDataAccessor<Long> LAST_POSE_CHANGE_TICK =
            SynchedEntityData.defineId(OrganEntity.class, EntityDataSerializers.LONG);

    public static final EntityDataAccessor<Integer> GLOW_COLOR =
            SynchedEntityData.defineId(OrganEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> VARIANT =
            SynchedEntityData.defineId(OrganEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> COMMAND =
            SynchedEntityData.defineId(OrganEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> ASSEMBLY =
            SynchedEntityData.defineId(OrganEntity.class, EntityDataSerializers.INT);

    public OrganEntity(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
    }

    public int blinkCountdown = 0;

    @Override
    public boolean canDrownInFluidType(FluidType type) {
        return false;
    }

    @Override
    public void registerGoals() {
        this.goalSelector.addGoal(0, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(3, new AnimalFollowOwnerGoal(this, 1d, 20f, 10f, false) {
            @Override
            public boolean shouldFollow() {
                return getCommand() == 0;
            }
        });
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D, 50));
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
    }

    @Override
    public boolean shouldTryTeleportToOwner() {
        return false;
    }


    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 100d)
                .add(Attributes.MOVEMENT_SPEED, 0.25d)
                .add(Attributes.FOLLOW_RANGE, 30)
                .add(Attributes.KNOCKBACK_RESISTANCE, 100d)
                .add(Attributes.ATTACK_DAMAGE, 30)
                .add(Attributes.ENTITY_INTERACTION_RANGE, 40);
    }

    @Override
    public boolean isFood(ItemStack itemStack) {
        return false;
    }

    @Override
    @Nullable
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob otherParent) {
        return null;
    }

    /* ANIMATIONS */

    private void setUpAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 78;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }
        if (this.isVisuallySitting()) {
            this.sitUpAnimationState.stop();
            if (this.isVisuallySittingDown()) {
                this.sitDownAnimationState.startIfStopped(this.tickCount);
                this.sitPoseAnimationState.stop();
            } else {
                this.sitDownAnimationState.stop();
                this.sitPoseAnimationState.startIfStopped(this.tickCount);
            }
        } else {
            this.sitDownAnimationState.stop();
            this.sitPoseAnimationState.stop();
            this.sitUpAnimationState.animateWhen(this.inPoseTransition() && this.getPoseTime() >= 0L, this.tickCount);
        }
    }

    public boolean inPoseTransition() {
        long i = this.getPoseTime();
        return i < (long) (this.isSitting() ? 50 : 52);
    }

    public void resetLastPoseChangeTick(long lastPoseChangeTick) {
        this.entityData.set(LAST_POSE_CHANGE_TICK, lastPoseChangeTick);
    }

    public void resetLastPoseChangeTickToFullStand(long lastPoseChangeTick) {
        this.resetLastPoseChangeTick(Math.max(0L, lastPoseChangeTick - 52L - 1L));
    }

    public long getPoseTime() {
        return this.level().getGameTime() - Math.abs(this.entityData.get(LAST_POSE_CHANGE_TICK));
    }

    /* SITTING */

    public boolean isVisuallySitting() {
        return this.getPoseTime() < 0L != this.isSitting();
    }

    private boolean isVisuallySittingDown() {
        return this.isSitting() && this.getPoseTime() < 40L && this.getPoseTime() >= 0L;
    }

    public boolean isSitting() {
        return this.entityData.get(LAST_POSE_CHANGE_TICK) < 0L;
    }

    //player.displayClientMessage(Component.translatable("entity.createbionics.message.organ_follow"), true);

    public void sitDown(Player player) {
        if (!this.isSitting()) {
            this.setPose(Pose.SITTING);
            this.gameEvent(GameEvent.ENTITY_ACTION);
            this.resetLastPoseChangeTick(-this.level().getGameTime());
        }
        setOrderedToSit(true);
        setInSittingPose(true);
    }

    public void standUp(Player player) {
        if (this.isSitting()) {
            this.setPose(Pose.STANDING);
            this.gameEvent(GameEvent.ENTITY_ACTION);
            this.resetLastPoseChangeTick(this.level().getGameTime());
        }
        setOrderedToSit(false);
        setInSittingPose(false);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide()) {
            this.setUpAnimationStates();
        }

        /* BLINKING */
        if (Math.random() < 0.01f) {
            blinkCountdown = 6;
        }
        if (blinkCountdown > 0) {
            blinkCountdown = blinkCountdown - 1;
        }

        /* STEAM EFFECTS */

        /* exhaust */
        if (exhaustLoop()) {

            if (exhaust1 < 13) {
                exhaust1 = exhaust1 + 1;
            } else {
                exhaust1 = 8;
            }

            if (exhaust2 < 4) {
                exhaust2 = exhaust2 + 1;
            } else {
                exhaust2 = 2;
            }
        } else {
            if (exhaust1 == 21) {
                exhaust1 = 0;
            } else if (exhaust1 > 0) {
                exhaust1 = exhaust1 + 1;
            }

            if (exhaust2 == 21) {
                exhaust2 = 0;
            } else if (exhaust2 > 0) {
                exhaust2 = exhaust2 + 1;
            }
        }
    }

    /* SAVE DATA */

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(LAST_POSE_CHANGE_TICK, 0L);
        builder.define(GLOW_COLOR, 0);
        builder.define(VARIANT, 0);
        builder.define(COMMAND, 0);
        builder.define(ASSEMBLY, 0);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putLong("LastPoseTick", this.entityData.get(LAST_POSE_CHANGE_TICK));
        compound.putInt("Glow_Color", this.entityData.get(GLOW_COLOR));
        compound.putInt("Variant", this.entityData.get(VARIANT));
        compound.putInt("Command", this.entityData.get(COMMAND));
        compound.putInt("Assembly", this.entityData.get(ASSEMBLY));
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        long i = compound.getLong("LastPoseTick");
        if (i < 0L) {
            this.setPose(Pose.SITTING);
        }
        this.resetLastPoseChangeTick(i);
        entityData.set(GLOW_COLOR, compound.getInt("Glow_Color"));
        entityData.set(VARIANT, compound.getInt("Variant"));
        entityData.set(COMMAND, compound.getInt("Command"));
        entityData.set(ASSEMBLY, compound.getInt("Assembly"));
    }

    /* INTERACT */

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        /* TAME */
        if (!isTame()) {
            if (this.level().isClientSide()) {
                return InteractionResult.CONSUME;
            } else {
                if (!EventHooks.onAnimalTame(this, player)) {
                    super.tame(player);
                    this.navigation.recomputePath();
                    this.setTarget(null);
                    this.level().broadcastEntityEvent(this, (byte) 7);
                }
                return InteractionResult.SUCCESS;
            }
        } else {
            if (isOwnedBy(player)) {
                if (itemStack.is(Items.COPPER_INGOT)
                        || itemStack.is(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:andesite_alloy")))
                        || itemStack.is(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:brass_ingot")))
                        || itemStack.is(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:sturdy_sheet")))) {
                    dropIngot(getVariant());
                    setTypeVariant(itemStack);
                    if (level().isClientSide) {
                        return InteractionResult.SUCCESS;
                    } else {
                        itemStack.shrink(1);
                    }

                } else if (itemStack.is(Items.REDSTONE) || itemStack.is(Items.REDSTONE_BLOCK) || itemStack.is(Items.BRUSH)) {
                    dropRedstone(getGlow());
                    setTypeGlow(itemStack);
                    if (level().isClientSide) {
                        return InteractionResult.SUCCESS;
                    } else if (!itemStack.is(Items.BRUSH)) {
                        itemStack.shrink(1);
                    }

                } else if (itemStack.is(BionicsItems.ROBOT_BUILDER) && getAssembly() < 105) {
                    setAssembly(getAssembly() + 1);
                    player.displayClientMessage(Component.translatable("entity.createbionics.all.command_" + getAssembly()), true);
                    return InteractionResult.SUCCESS;

                } else if (itemStack.is(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:wrench"))) && getAssembly() > 0) {
                    setAssembly(getAssembly() - 1);
                    player.displayClientMessage(Component.translatable("entity.createbionics.all.command_" + getAssembly()), true);
                    return InteractionResult.SUCCESS;

                } else {
                    this.setCommand(this.getCommand() + 1);
                    if (this.getCommand() > 2) {
                        this.setCommand(0);
                    }
                    player.displayClientMessage(Component.translatable("entity.createbionics.all.command_" + this.getCommand(), this.getName()), true);
                    boolean sit = this.getCommand() == 2;
                    if (sit) {
                        sitDown(player);
                    } else {
                        standUp(player);
                    }
                    return InteractionResult.SUCCESS;
                }
            }
        }
        return super.mobInteract(player, hand);
    }

    /* VARIANTS */

    private void setGlowColor(int typeColor) {
        this.entityData.set(GLOW_COLOR, typeColor);
    }
    private void setTypeVariant(ItemStack itemStack) {
        if (itemStack.getItem() == Items.COPPER_INGOT && getVariant() != OrganVariant.COPPER) {
            setVariant(OrganVariant.COPPER);
        } else if (itemStack.is(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:andesite_alloy")))
                && getVariant() != OrganVariant.ANDESITE) {
            setVariant(OrganVariant.ANDESITE);
        } else if (itemStack.is(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:brass_ingot")))
                && getVariant() != OrganVariant.DEFAULT) {
            setVariant(OrganVariant.DEFAULT);
        } else if (itemStack.is(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:sturdy_sheet")))
                && getVariant() != OrganVariant.STURDY_SHEET) {
            setVariant(OrganVariant.STURDY_SHEET);
        }
    }
    private void setTypeGlow(ItemStack itemStack) {
        if (itemStack.getItem() == Items.BRUSH && getGlow() != OrganGlow.DEFAULT) {
            setGlow(OrganGlow.DEFAULT);
        } else if (itemStack.is(Items.REDSTONE) && getGlow() != OrganGlow.REDSTONE1) {
            setGlow(OrganGlow.REDSTONE1);
        } else if (itemStack.is(Items.REDSTONE_BLOCK) && getGlow() != OrganGlow.REDSTONE2) {
            setGlow(OrganGlow.REDSTONE2);
        }
    }
    private void dropIngot(OrganVariant variant) {
        if (getVariant() == OrganVariant.DEFAULT) {
            spawnAtLocation(new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:brass_ingot"))));
        } else if (getVariant() == OrganVariant.COPPER) {
            spawnAtLocation(new ItemStack(Items.COPPER_INGOT));
        } else if (getVariant() == OrganVariant.ANDESITE) {
            spawnAtLocation(new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:andesite_alloy"))));
        } else if (getVariant() == OrganVariant.STURDY_SHEET) {
            spawnAtLocation(new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:sturdy_sheet"))));
        }
    }
    private void dropRedstone(OrganGlow glow) {
        if (getGlow() == OrganGlow.REDSTONE1) {
            spawnAtLocation(new ItemStack(Items.REDSTONE));
        } else if (getGlow() == OrganGlow.REDSTONE2) {
            spawnAtLocation(new ItemStack(Items.REDSTONE_BLOCK));
        }
    }

    public int getGlowColor() {
        return this.entityData.get(GLOW_COLOR);
    }
    public int getTypeVariant() {
        return this.entityData.get(VARIANT);
    }
    public OrganGlow getGlow() {
        return OrganGlow.byId(this.getGlowColor() & 255);
    }
    public OrganVariant getVariant() {
        return OrganVariant.byId(this.getTypeVariant() & 255);
    }
    public void setGlow(OrganGlow glow) {
        this.entityData.set(GLOW_COLOR, glow.getId() & 255);
    }
    public void setVariant(OrganVariant variant) {
        this.entityData.set(VARIANT, variant.getId() & 255);
    }

    /*COMMAND*/

    public int getCommand() {
        return this.entityData.get(COMMAND);
    }

    public void setCommand(int command) {
        this.entityData.set(COMMAND, command);
    }


    /* STEAM */

    public int sustain = 0;
    public int exhaust1 = 0;
    public int exhaust2 = 0;

    public void startExhaust() {
    }


    /* ASSEMBLY */

    public int getAssembly() {
        return this.entityData.get(ASSEMBLY);
    }

    public void setAssembly(int assembly) {
        this.entityData.set(ASSEMBLY, assembly);
    }

}
