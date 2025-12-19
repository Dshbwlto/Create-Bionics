package net.dshbwlto.createbionics.entity.custom;

import net.dshbwlto.createbionics.entity.client.organ.layers.OrganGlow;
import net.dshbwlto.createbionics.entity.client.organ.layers.OrganVariant;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.neoforge.event.EventHooks;
import org.jetbrains.annotations.Nullable;

public class OrganEntity extends TamableAnimal {
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public boolean canGlow = level().getDayTime() > 1200;

    public int assembly = entityData.get(ASSEMBLY);

    public boolean exhaustLoop() {
        return false;
    };

    public final AnimationState sitDownAnimationState = new AnimationState();
    public final AnimationState sitPoseAnimationState = new AnimationState();
    public final AnimationState sitUpAnimationState = new AnimationState();

    public static final EntityDataAccessor<Long> LAST_POSE_CHANGE_TICK =
            SynchedEntityData.defineId(OrganEntity.class, EntityDataSerializers.LONG);

    public static final EntityDataAccessor<Integer> GLOW_COLOR =
            SynchedEntityData.defineId(OrganEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> VARIANT =
            SynchedEntityData.defineId(OrganEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> ASSEMBLY =
            SynchedEntityData.defineId(OrganEntity.class, EntityDataSerializers.INT);

    public OrganEntity(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
    }

    public int blinkCountdown = 0;

    @Override
    public void registerGoals() {
        this.goalSelector.addGoal(0, new SitWhenOrderedToGoal(this));


    }

    @Override
    public boolean shouldTryTeleportToOwner() {
        LivingEntity livingEntity = this.getOwner();
        return livingEntity != null && this.distanceToSqr(this.getOwner()) >= 300;
    }


    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 100d)
                .add(Attributes.MOVEMENT_SPEED, 0.25d)
                .add(Attributes.FOLLOW_RANGE, 30)
                .add(Attributes.KNOCKBACK_RESISTANCE, 100d);
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
        return i < (long)(this.isSitting() ? 50 : 52);
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

    public void toggleSitting() {
        if (this.isSitting()) {
            standUp();
        } else {
            sitDown();
        }
    }

    public void sitDown() {
        if (!this.isSitting()) {
            this.setPose(Pose.SITTING);
            this.gameEvent(GameEvent.ENTITY_ACTION);
            this.resetLastPoseChangeTick(-this.level().getGameTime());
        }
        setOrderedToSit(true);
        setInSittingPose(true);
    }

    public void standUp() {
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
        builder.define(ASSEMBLY, 0);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putLong("LastPoseTick", this.entityData.get(LAST_POSE_CHANGE_TICK));
        compound.putInt("Glow_Color", this.entityData.get(GLOW_COLOR));
        compound.putInt("Variant", this.entityData.get(VARIANT));
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
        entityData.set(ASSEMBLY, compound.getInt("Assembly"));
    }

    /* INTERACT */

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        Item item = itemStack.getItem();

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
            if (hand == InteractionHand.MAIN_HAND && !player.isSecondaryUseActive() && itemStack.isEmpty()) {
                toggleSitting();
            }
            /* REDSTONE */
            if (item == Items.BRUSH && getGlow() != OrganGlow.DEFAULT) {
                if (getGlow() == OrganGlow.REDSTONE2) {
                    this.spawnAtLocation(new ItemStack(Items.REDSTONE_BLOCK));
                }
                setGlow(OrganGlow.DEFAULT);
                this.spawnAtLocation(new ItemStack(Items.REDSTONE_BLOCK));

            }

            /* VARIANTS */
            if (getVariant() == OrganVariant.DEFAULT) {
                if (itemStack.is(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:andesite_alloy")))) {
                    if (this.level().isClientSide()) {
                        return InteractionResult.CONSUME;
                    } else {
                        if (!player.getAbilities().instabuild) {
                            itemStack.shrink(1);
                        }
                        setVariant(OrganVariant.ANDESITE);
                    }
                } else if (itemStack.is(Items.COPPER_INGOT)) {
                    if (this.level().isClientSide()) {
                        return InteractionResult.CONSUME;
                    } else {
                        if (!player.getAbilities().instabuild) {
                            itemStack.shrink(1);
                        }
                        setVariant(OrganVariant.COPPER);
                    }
                }
            } else if (itemStack.is(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:wrench")))) {
                if (!player.isShiftKeyDown()) {
                    if (getVariant() != OrganVariant.DEFAULT) {
                        if (this.level().isClientSide()) {
                            return InteractionResult.CONSUME;
                        } else {
                            if (!player.getAbilities().instabuild) {
                                itemStack.shrink(1);
                            }
                            setVariant(OrganVariant.DEFAULT);
                        }
                    }
                }
            }

            if (itemStack.is(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:wrench"))) && !player.isShiftKeyDown()) {
                entityData.set(ASSEMBLY, 1);
            }

            if (itemStack.is(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:railway_casing")))) {
                if (this.level().isClientSide()) {
                    return InteractionResult.CONSUME;
                } else {
                    if (!player.getAbilities().instabuild) {
                        itemStack.shrink(1);
                    }
                    entityData.set(ASSEMBLY, 0);
                    makeSound(SoundEvents.ANVIL_PLACE);
                }
            }
        }

        return super.mobInteract(player, hand);
    }

    /* VARIANTS */

    private void setGlowColor(int typeColor) {
        this.entityData.set(GLOW_COLOR, typeColor);
    }
    private void setTypeVariant(int typeColor) {
        this.entityData.set(VARIANT, typeColor);
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

    /* STEAM */

    public int sustain = 0;
    public int exhaust1 = 0;
    public int exhaust2 = 0;

    public void startExhaust() {
    }


    /* ASSEMBLY */

}
