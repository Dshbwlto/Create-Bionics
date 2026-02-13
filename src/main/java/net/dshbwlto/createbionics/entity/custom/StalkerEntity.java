package net.dshbwlto.createbionics.entity.custom;

import net.dshbwlto.createbionics.entity.client.stalker.StalkerVariant;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.*;
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
import net.minecraft.world.level.Level;
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
    private static final EntityDataAccessor<Integer> PAGE_NUMBER =
            SynchedEntityData.defineId(StalkerEntity.class, EntityDataSerializers.INT);

    protected SimpleContainer inventory;

    private int PageNumber() {
        return entityData.get(PAGE_NUMBER);
    }

    public StalkerEntity(EntityType<? extends AbstractRobot> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(2, new FloatGoal(this));

        this.goalSelector.addGoal(3, new LeapAtTargetGoal(this, 0.5F));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, (double)2.0F, true));

        this.goalSelector.addGoal(5, new FollowOwnerGoal(this, 1d, 10f, 5f) {
            @Override
            public boolean canUse() {
                return super.canUse() && getCommand() == 0;
            }
        });

        this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 4f));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(3, (new HurtByTargetGoal(this, new Class[0])).setAlertOthers(new Class[0]));
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
    public void sinkInFluid(FluidType type) {
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 60D)
                .add(Attributes.MOVEMENT_SPEED, 0.35f)
                .add(Attributes.ATTACK_DAMAGE, 5f)
                .add(Attributes.FOLLOW_RANGE, 24D);
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
        this.updateSpeed();
        if (this.level().isClientSide()) {
            this.setupAnimationStates();
        }
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(PAGE_NUMBER, 1);
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
        if (itemstack.is(Items.COPPER_INGOT)
                || itemstack.is(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:andesite_alloy")))
                || itemstack.is(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:brass_ingot")))) {
            setTypeVariant(itemstack);
            dropIngot(getVariant());
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
        } else if (itemStack.is(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:andesite_alloy")))
                && getVariant() != StalkerVariant.ANDESITE) {
            setVariant(StalkerVariant.ANDESITE);
        } else if (itemStack.is(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:brass_ingot")))
                && getVariant() != StalkerVariant.BRASS) {
            setVariant(StalkerVariant.BRASS);
        }
    }
    private void dropIngot(StalkerVariant variant) {
        if (getVariant() == StalkerVariant.BRASS) {
            spawnAtLocation(new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:brass_ingot"))));
        } else if (getVariant() == StalkerVariant.COPPER) {
            spawnAtLocation(new ItemStack(Items.COPPER_INGOT));
        } else if (getVariant() == StalkerVariant.ANDESITE) {
            spawnAtLocation(new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:andesite_alloy"))));
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
