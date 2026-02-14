package net.dshbwlto.createbionics.entity.custom;

import com.simibubi.create.AllSoundEvents;
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
import net.minecraft.sounds.SoundEvents;
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
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.neoforge.event.EventHooks;
import net.neoforged.neoforge.fluids.FluidType;
import org.jetbrains.annotations.Nullable;

public class OrganEntity extends AbstractRobot {
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public boolean exhaustLoop() {
        return false;
    }

    public final AnimationState sitDownAnimationState = new AnimationState();
    public final AnimationState sitPoseAnimationState = new AnimationState();
    public final AnimationState sitUpAnimationState = new AnimationState();

    public static final EntityDataAccessor<Integer> GLOW_COLOR =
            SynchedEntityData.defineId(OrganEntity.class, EntityDataSerializers.INT);

    public static final EntityDataAccessor<Integer> SIT_ORIENTATION =
            SynchedEntityData.defineId(OrganEntity.class, EntityDataSerializers.INT);

    public OrganEntity(EntityType<? extends AbstractRobot> entityType, Level level) {
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
        this.goalSelector.addGoal(3, new FollowOwnerGoal(this, 1d, 20f, 10f) {
            @Override
            public boolean canUse() {
                return super.canUse() && getCommand() == 0;
            }
        });
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D, 50) {
            @Override
            public boolean canUse() {
                return super.canUse() && getAssembly() >= 20 && isTame();
            }
        });
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
            this.sitUpAnimationState.animateWhen(this.isInPoseTransition() && this.getPoseTime() >= 0L, this.tickCount);
        }
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
        builder.define(GLOW_COLOR, 0);
        builder.define(SIT_ORIENTATION, 0);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Glow_Color", this.entityData.get(GLOW_COLOR));
        compound.putInt("Sit_Orientation", this.entityData.get(SIT_ORIENTATION));
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        entityData.set(GLOW_COLOR, compound.getInt("Glow_Color"));
        entityData.set(SIT_ORIENTATION, compound.getInt("Sit_Orientation"));
    }

    /* INTERACT */

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        /* TAME */
        if (!isTame()) {
            if (getAssembly() > 20) {
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
            }
            super.mobInteract(player, hand);
        }
        if ((itemStack.is(Items.COPPER_INGOT)
                || itemStack.is(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:andesite_alloy")))
                || itemStack.is(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:brass_ingot")))
                || itemStack.is(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:sturdy_sheet"))))
                && isOwnedBy(player)) {
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

        } else if ((itemStack.is(BionicsItems.ROBOT_BUILDER) || (itemStack.is(getPart()))) && getAssembly() < 105) {
            setAssembly(getAssembly() + 1);
            if (!itemStack.is(BionicsItems.ROBOT_BUILDER.get())) {
                itemStack.shrink(1);
            }
            if (getAssembly() <= 21) {
                playSound(SoundEvents.NETHERITE_BLOCK_PLACE);
            } else {
                playSound(SoundEvents.NETHERITE_BLOCK_PLACE, 1, (float) getAssembly() / 50);
            }
            player.displayClientMessage(Component.translatable("entity.createbionics.all.assembly", getPart().getDescription().getString()), true);
            return InteractionResult.SUCCESS;

        } else if (itemStack.is(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:wrench"))) && (isOwnedBy(player) || getAssembly() < 21)) {
            if (getAssembly() > 0) {
                setAssembly(getAssembly() - 1);
                spawnAtLocation(new ItemStack(getPart()));
                if (getAssembly() <= 21) {
                    playSound(SoundEvents.NETHERITE_BLOCK_PLACE);
                } else {
                    playSound(SoundEvents.NETHERITE_BLOCK_PLACE, 1, (float) getAssembly() / 50);
                }
            } else {
                spawnAtLocation(new ItemStack(BionicsItems.ORGAN_MIDDLE.get()));
                remove(RemovalReason.DISCARDED);
            }
            return InteractionResult.SUCCESS;

        } else {
            if (getAssembly() >= 20 && isOwnedBy(player)) {
                if (player.isShiftKeyDown() && getCommand() == 2) {
                    changeSitOrientation();
                    AllSoundEvents.CONFIRM.play(getCommandSenderWorld(), player, this.blockPosition());
                    if (getSitOrientation() == 0) {
                        player.displayClientMessage(Component.translatable("entity.createbionics.organ.left", this.getName().getString()), true);
                    } else  if (getSitOrientation() == 1){
                        player.displayClientMessage(Component.translatable("entity.createbionics.organ.right", this.getName().getString()), true);
                    } else {
                        player.displayClientMessage(Component.translatable("entity.createbionics.organ.center", this.getName().getString()), true);
                    }
                } else {
                    updateCommand(player);
                }
            }
            return InteractionResult.SUCCESS;
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
                && getVariant() != OrganVariant.BRASS) {
            setVariant(OrganVariant.BRASS);
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
        if (getVariant() == OrganVariant.BRASS) {
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
        return entityData.get(VARIANT);
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

    private Item getPart () {
        if (getAssembly() == 0 || getAssembly() == 1) {
            return (BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:railway_casing")));
        } else if (getAssembly() == 2 || getAssembly() == 3) {
            return (BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:metal_girder")));
        } else if (getAssembly() == 4 || getAssembly() == 5) {
            return BionicsItems.ORGAN_FOOT.get();
        } else if (getAssembly() == 6) {
            return BionicsItems.ORGAN_TAIL_BASE.get();
        } else if (getAssembly() == 7) {
            return BionicsItems.ORGAN_TAIL_END.get();
        } else if (getAssembly() == 8) {
            return BionicsItems.ORGAN_CHEST.get();
        } else if (getAssembly() == 9 ||
                getAssembly() == 10 ||
                getAssembly() == 11 ||
                getAssembly() == 12 ||
                getAssembly() == 13 ||
                getAssembly() == 14 ||
                getAssembly() == 15 ||
                getAssembly() == 16) {
            return BionicsItems.ORGAN_PISTON.get();
        } else if (getAssembly() == 17 || getAssembly() == 18) {
            return BionicsItems.ORGAN_BELLOWS.get();
        } else if (getAssembly() == 19) {
            return BionicsItems.ORGAN_NECK.get();
        } else if (getAssembly() == 20) {
            return BionicsItems.ORGAN_HEAD.get();
        } else {
            return (BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:steam_whistle")));
        }
    }

    //SITTING//

    public int getSitOrientation() {
        return entityData.get(SIT_ORIENTATION);
    }
    public void changeSitOrientation() {
        if (getSitOrientation() == 0) {
            entityData.set(SIT_ORIENTATION, 1);
        } else if (getSitOrientation() == 1){
            entityData.set(SIT_ORIENTATION, 2);
        } else {
            entityData.set(SIT_ORIENTATION, 0);
        }
    }

}
