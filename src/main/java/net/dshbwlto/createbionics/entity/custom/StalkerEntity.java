package net.dshbwlto.createbionics.entity.custom;

import com.simibubi.create.AllItems;
import net.dshbwlto.createbionics.entity.api.AbstractRobot;
import net.dshbwlto.createbionics.entity.client.stalker.StalkerVariant;
import net.dshbwlto.createbionics.item.BionicsItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.EventHooks;
import net.neoforged.neoforge.fluids.FluidType;
import org.jetbrains.annotations.Nullable;

public class StalkerEntity extends AbstractRobot {
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    private static final float MOVEMENT_SPEED_WHEN_FIGHTING = 10F;

    public final AnimationState sitDownAnimationState = new AnimationState();
    public final AnimationState sitPoseAnimationState = new AnimationState();
    public final AnimationState sitUpAnimationState = new AnimationState();

    protected SimpleContainer inventory;

    public StalkerEntity(EntityType<? extends AbstractRobot> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(2, new FloatGoal(this));
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, (double)2.0F, true));
        this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, 0.5F));
        this.goalSelector.addGoal(6, new FollowOwnerGoal(this, 1d, 10f, 5f) {
            @Override
            public boolean canUse() {
                return super.canUse() && getCommand() == 0;
            }
        });
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 4f));
        this.goalSelector.addGoal(9, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
    }

    @Override
    public boolean fireImmune() {
        return true;
    }

    private void updateSpeed() {
        if (this.isAggressive()) {
                this.setDeltaMovement(this.getDeltaMovement().add(0.0, 0.005, 0.0));
                this.setSpeed(Math.max(this.getSpeed() / 2.0F, 0.08F));
        } else {
            this.setSpeed(Math.max(this.getSpeed() / 2.0F, 0.06F));
        }
    }

    @Override
    public boolean canDrownInFluidType(FluidType type) {
        return false;
    }

    @Override
    protected void dropCustomDeathLoot(ServerLevel level, DamageSource damageSource, boolean recentlyHit) {
        super.dropCustomDeathLoot(level, damageSource, recentlyHit);
        if (random.nextFloat() < 0.2) {
            spawnAtLocation(new ItemStack((ItemLike) BionicsItems.STALKER_BODY));
        }
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 60D)
                .add(Attributes.MOVEMENT_SPEED, 0.35f)
                .add(Attributes.ATTACK_DAMAGE, 7)
                .add(Attributes.FOLLOW_RANGE, 24D)
                .add(Attributes.WATER_MOVEMENT_EFFICIENCY, 0.8);
    }

    @Override
    public boolean isFood(ItemStack itemStack) {
        return false;
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return null;
    }

    /* ANIMATIONS */
    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 60;
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
    public boolean shouldTryTeleportToOwner() {
        LivingEntity livingEntity = this.getOwner();
        return livingEntity != null && this.distanceToSqr(this.getOwner()) >= 300 && !this.isAggressive();
    }

    @Override
    public void tick() {
        super.tick();
        playSoundScape(2, 2);
        if(this.horizontalCollision) {
            Vec3 initialVec = this.getDeltaMovement();
            Vec3 climbVec = new Vec3(initialVec.x, 0.2D, initialVec.z);
            this.setDeltaMovement(climbVec.scale(0.96D));
        }
        this.updateSpeed();
        if (this.level().isClientSide()) {
            this.setupAnimationStates();
        }
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        ///Not this one either
        //super.defineSynchedData(builder);
    }


    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);

    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        Item item = itemstack.getItem();
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
        }
        if (itemstack.is (Items.COPPER_INGOT) && getHealth() != getMaxHealth()) {
            itemstack.shrink(1);
            heal(100);
            playSound(SoundEvents.SMITHING_TABLE_USE);
            return InteractionResult.CONSUME;
        } else if ((itemstack.is(Items.COPPER_INGOT))
                || itemstack.is(AllItems.ANDESITE_ALLOY)
                || itemstack.is(AllItems.BRASS_INGOT)) {
            dropIngot(getVariant());
            setTypeVariant(itemstack);
            if (level().isClientSide) {
                return InteractionResult.SUCCESS;
            } else {
                itemstack.shrink(1);
            }
        } else if (hand == InteractionHand.MAIN_HAND && !player.isShiftKeyDown()) {
            updateCommand(player);
            return InteractionResult.SUCCESS;
        }

        return super.mobInteract(player, hand);
    }

    //VARIANT
    private void setTypeVariant(ItemStack itemStack) {
        if (itemStack.getItem() == Items.COPPER_INGOT && getVariant() != StalkerVariant.COPPER) {
            setVariant(StalkerVariant.COPPER);
        } else if (itemStack.is(AllItems.ANDESITE_ALLOY)
                && getVariant() != StalkerVariant.ANDESITE) {
            setVariant(StalkerVariant.ANDESITE);
        } else if (itemStack.is(AllItems.BRASS_INGOT)
                && getVariant() != StalkerVariant.BRASS) {
            setVariant(StalkerVariant.BRASS);
        }
    }
    private void dropIngot(StalkerVariant variant) {
        if (getVariant() == StalkerVariant.BRASS) {
            spawnAtLocation(new ItemStack(AllItems.BRASS_INGOT.asItem()));
        } else if (getVariant() == StalkerVariant.COPPER) {
            spawnAtLocation(new ItemStack(Items.COPPER_INGOT));
        } else if (getVariant() == StalkerVariant.ANDESITE) {
            spawnAtLocation(new ItemStack(AllItems.ANDESITE_ALLOY.asItem()));
        }
    }
    public StalkerVariant getVariant() {
        return StalkerVariant.byId(this.getTypeVariant() & 255);
    }
    public int getTypeVariant() {
        return entityData.get(VARIANT);
    }
    public void setVariant(StalkerVariant variant) {
        this.entityData.set(VARIANT, variant.getId() & 255);
    }
}
