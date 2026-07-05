package net.dshbwlto.createbionics.entity.custom;

import com.simibubi.create.AllItems;
import com.simibubi.create.AllSoundEvents;
import net.dshbwlto.createbionics.component.BionicsDataComponentTypes;
import net.dshbwlto.createbionics.entity.api.AbstractRobot;
import net.dshbwlto.createbionics.entity.client.seeker.SeekerPickaxe;
import net.dshbwlto.createbionics.entity.client.seeker.SeekerVariant;
import net.dshbwlto.createbionics.item.BionicsItems;
import net.dshbwlto.createbionics.item.custom.SeekerItem;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.EventHooks;
import org.jetbrains.annotations.Nullable;

public class SeekerEntity extends AbstractRobot {

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState sitDownAnimationState = new AnimationState();
    public final AnimationState sitPoseAnimationState = new AnimationState();
    public final AnimationState sitUpAnimationState = new AnimationState();

    public static final EntityDataAccessor<Integer> PICK_MAP =
            SynchedEntityData.defineId(SeekerEntity.class, EntityDataSerializers.INT);

    public SeekerEntity(EntityType<? extends AbstractRobot> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        this.lookControl = new SmoothSwimmingLookControl(this, 10);
        this.moveControl = new SmoothSwimmingMoveControl(this, 85, 10, 1, 1, true);

        this.goalSelector.addGoal(0, new FloatGoal(this) {
            @Override
            public boolean canUse() {
                return super.canUse() && isFueled();
            }
        });

        this.goalSelector.addGoal(1, new SitWhenOrderedToGoal(this));

        this.goalSelector.addGoal(4, new FollowOwnerGoal(this, 1.0d, 10f, 5f) {
            @Override
            public boolean canUse() {
                return super.canUse() && isFueled() && getCommand() == 0;
            }
        });
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D) {
            @Override
            public boolean canUse() {
                return super.canUse() && isTame() && isFueled();
            }
        });

        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 4f) {
            @Override
            public boolean canUse() {
                return super.canUse() && isTame() && isFueled();
            }
        });
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this) {
            @Override
            public boolean canUse() {
                return super.canUse() && isTame() && isFueled();
            }
        });
    }
    protected PathNavigation createNavigation(Level level) {
        return new WallClimberNavigation(this, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 5D)
                .add(Attributes.MOVEMENT_SPEED, 0.4)
                .add(Attributes.ATTACK_DAMAGE, 2f)
                .add(Attributes.FOLLOW_RANGE, 24D)
                .add(Attributes.SAFE_FALL_DISTANCE, 200D)
                .add(Attributes.WATER_MOVEMENT_EFFICIENCY, 200f);
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return SoundEvents.ITEM_BREAK;
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.ANVIL_PLACE;
    }


    @Override
    public @Nullable ItemStack getPickResult() {
        return seekerItem();
    }

    public void aiStep() {
        if (this.level().isClientSide && isFueled() && getFuel() > 0) {
            this.level().addParticle(ParticleTypes.SMOKE, this.getRandomX(0.5F), this.getRandomY(), this.getRandomZ(0.5F), 0.0F, 0.0F, 0.0F);
        }
        super.aiStep();
    }

    @Override
    public boolean fireImmune() {
        return true;
    }

    /* ANIMATIONS */
    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 40;
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
            this.setupAnimationStates();
        }

        if (isFueled()) {
            playSoundScape(1, 1);
        }

        if (!isSitting() && !isPassenger() && !hasBlazeCake()) {
            if (getFuel() > 0) {
                setFuel(getFuel() - 1);
            }
        }

        if (this.horizontalCollision) {
            Vec3 initialVec = this.getDeltaMovement();
            Vec3 climbVec = new Vec3(initialVec.x, 0.2D, initialVec.z);
            this.setDeltaMovement(climbVec.scale(0.96D));
        }
    }

    /* RIGHT CLICKING */
    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (!isTame() && getMainHandItem().isEmpty()) {
            if (!this.level().isClientSide()) {
                if (!EventHooks.onAnimalTame(this, player)) {
                    super.tame(player);
                    this.navigation.recomputePath();
                    this.setTarget(null);
                    this.level().broadcastEntityEvent(this, (byte) 7);
                }
            }
            return InteractionResult.SUCCESS;
        }

        if (isTame() && isOwnedBy(player)) {
            if (itemStack.is(AllItems.ANDESITE_ALLOY)
                    || itemStack.is(AllItems.BRASS_INGOT)) {
                dropIngot();
                setTypeVariant(itemStack);
                if (level().isClientSide) {
                    return InteractionResult.SUCCESS;
                } else {
                    itemStack.shrink(1);
                }
            } else if ((itemStack.is(Items.DIAMOND_PICKAXE) && getPickaxe() == SeekerPickaxe.IRON) ||
                    (itemStack.is(Items.NETHERITE_INGOT) && getPickaxe() == SeekerPickaxe.DIAMOND)) {
                setTypePickaxe(itemStack);
                player.playSound(SoundEvents.SMITHING_TABLE_USE);
                if (level().isClientSide) {
                    return InteractionResult.SUCCESS;
                }
            } else if (itemStack.is(AllItems.WRENCH)) {
                spawnAtLocation(seekerItem());
                remove(RemovalReason.DISCARDED);
            } else if (itemStack.is(AllItems.CREATIVE_BLAZE_CAKE)) {
                if (hasBlazeCake()) {
                    entityData.set(CREATIVE_BLAZE_CAKE, false);
                } else {
                    setFuel(10000);
                    entityData.set(CREATIVE_BLAZE_CAKE, true);
                    playSound(AllSoundEvents.BLAZE_MUNCH.getMainEvent());
                }
            } else if (itemStack.is(Items.COAL) || itemStack.is(Items.CHARCOAL)) {
                setFuel(10000);
                playSound(AllSoundEvents.BLAZE_MUNCH.getMainEvent());
            } else {
                updateCommand(player);
                return InteractionResult.SUCCESS;
            }
        }

        return super.mobInteract(player, hand);
    }

    public ItemStack seekerItem() {
        ItemStack item = new ItemStack(BionicsItems.SEEKER.get());
        item.set(BionicsDataComponentTypes.VARIANT, getTypeVariant());
        item.set(BionicsDataComponentTypes.MARKING, getTypePickaxe());
        item.set(BionicsDataComponentTypes.FUEL, getFuel());
        return item;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        /// just stop.
        //builder.define(PICK_MAP, 0);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Pickaxe", this.getTypePickaxe());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.entityData.set(PICK_MAP, compound.getInt("Pickaxe"));
    }

    //VARIANT//

    private void setTypeVariant(ItemStack itemStack) {
        if (itemStack.is(AllItems.ANDESITE_ALLOY)
                && getVariant() != SeekerVariant.ANDESITE) {
            setVariant(SeekerVariant.ANDESITE);
        } else if (itemStack.is(AllItems.BRASS_INGOT)
                && getVariant() != SeekerVariant.BRASS) {
            setVariant(SeekerVariant.BRASS);
        }
    }

    private void setTypePickaxe(ItemStack itemStack) {
        if (itemStack.is(Items.DIAMOND_PICKAXE) && getPickaxe() == SeekerPickaxe.IRON) {
            setPickaxe(SeekerPickaxe.DIAMOND);
            if (!level().isClientSide) {
                itemStack.shrink(1);
            }
        } else if (itemStack.is(Items.NETHERITE_INGOT) && getPickaxe() == SeekerPickaxe.DIAMOND) {
            setPickaxe(SeekerPickaxe.NETHERITE);
            if (!level().isClientSide) {
                itemStack.shrink(1);
            }
        }
    }

    public int getTypePickaxe() {
        return this.entityData.get(PICK_MAP);
    }

    public SeekerPickaxe getPickaxe() {
        return SeekerPickaxe.byId(this.getTypePickaxe() & 255);
    }

    public void setPickaxe(SeekerPickaxe marking) {
        this.entityData.set(PICK_MAP, marking.getId() & 255);
    }

    public void setPickaxeNumber(int pickaxe) {
        this.entityData.set(PICK_MAP, pickaxe);
    }

    private void dropIngot() {
        if (getVariant() == SeekerVariant.BRASS) {
            spawnAtLocation(new ItemStack(AllItems.BRASS_INGOT.asItem()));
        } else if (getVariant() == SeekerVariant.ANDESITE) {
            spawnAtLocation(new ItemStack(AllItems.ANDESITE_ALLOY.asItem()));
        }
    }

    private int getTypeVariant() {
        return this.entityData.get(VARIANT);
    }

    public SeekerVariant getVariant() {
        return SeekerVariant.byId(this.getTypeVariant() & 255);
    }

    public void setVariant(SeekerVariant variant) {
        this.entityData.set(VARIANT, variant.getId() & 255);
    }

}