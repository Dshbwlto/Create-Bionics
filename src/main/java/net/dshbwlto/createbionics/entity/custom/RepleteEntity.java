package net.dshbwlto.createbionics.entity.custom;

import net.dshbwlto.createbionics.entity.client.replete.RepleteVariant;
import net.dshbwlto.createbionics.item.BionicsItems;
import net.dshbwlto.createbionics.sound.BionicsSounds;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.event.EventHooks;
import net.neoforged.neoforge.fluids.FluidActionResult;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.FluidUtil;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;

public class RepleteEntity extends TamableAnimal implements MenuProvider {

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public int countdown = 0;
    public float fluidLevel = 0;

    public int fuel() {
        return entityData.get(FUEL);
    }
    public int buildProgress() {
        return entityData.get(BUILD_PROGRESS);
    }

    public final AnimationState sitDownAnimationState = new AnimationState();
    public final AnimationState sitPoseAnimationState = new AnimationState();
    public final AnimationState sitUpAnimationState = new AnimationState();

    public static final EntityDataAccessor<Long> LAST_POSE_CHANGE_TICK =
            SynchedEntityData.defineId(RepleteEntity.class, EntityDataSerializers.LONG);
    public static final EntityDataAccessor<Integer> VARIANT =
            SynchedEntityData.defineId(RepleteEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> FUEL =
            SynchedEntityData.defineId(RepleteEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Float> FILL_LEVEL =
            SynchedEntityData.defineId(RepleteEntity.class, EntityDataSerializers.FLOAT);
    public static final EntityDataAccessor<Integer> BUILD_PROGRESS =
            SynchedEntityData.defineId(RepleteEntity.class, EntityDataSerializers.INT);


    public RepleteEntity(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        if (entityData.get(FUEL) > 0) {
            this.goalSelector.addGoal(0, new FloatGoal(this));

            this.goalSelector.addGoal(1, new SitWhenOrderedToGoal(this));

            this.goalSelector.addGoal(2, new FollowOwnerGoal(this, 1.0d, 10f, 5f));

            if (isTame()) {
                this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1.0D));
            }
            this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 4f));
        }
    }


    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 50D)
                .add(Attributes.MOVEMENT_SPEED, 0.25)
                .add(Attributes.ATTACK_DAMAGE, 2f)
                .add(Attributes.FOLLOW_RANGE, 50D)
                .add(Attributes.SAFE_FALL_DISTANCE, 200D)
                .add(Attributes.WATER_MOVEMENT_EFFICIENCY, 200f);
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return false;
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob otherParent) {
        return null;
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return SoundEvents.ITEM_BREAK;
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.ANVIL_PLACE;
    }

    public void aiStep() {

        if (entityData.get(FUEL) > 0 && this.level().isClientSide) {
            for(int i = 0; i < 1; ++i) {
                this.level().addParticle(ParticleTypes.SMOKE, this.getRandomX((double) 0.5F), this.getRandomY(), this.getRandomZ((double) 0.5F), (double) 0.0F, (double) 0.0F, (double) 0.0F);
            }
        }
        super.aiStep();
    }

    @Override
    public boolean fireImmune() {
        if(getVariant() == RepleteVariant.NETHERITE3) {
            return true;
        }
        return super.fireImmune();
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

    public boolean isInPoseTransition() {
        long i = this.getPoseTime();
        return i < (long) (this.isSitting() ? 40 : 52);
    }

    public boolean isVisuallySitting() {
        return this.getPoseTime() < 0L != this.isSitting();
    }

    private boolean isVisuallySittingDown() {
        return this.isSitting() && this.getPoseTime() < 40L && this.getPoseTime() >= 0L;
    }

    public void resetLastPoseChangeTick(long lastPoseChangeTick) {
        this.entityData.set(LAST_POSE_CHANGE_TICK, lastPoseChangeTick);
    }

    public long getPoseTime() {
        return this.level().getGameTime() - Math.abs(this.entityData.get(LAST_POSE_CHANGE_TICK));
    }

    private void resetLastPoseChangeTickToFullStand(long lastPoseChangedTick) {
        this.resetLastPoseChangeTick(Math.max(0L, lastPoseChangedTick - 52L - 1L));
    }

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide()) {
            this.setupAnimationStates();
        }

        if(tickCount % 120 == 0 && !isCurrentlyGlowing() && !isSilent()) {
            this.level().playLocalSound(this.getX() + (double) 0.5F, this.getY() + (double) 0.5F, this.getZ() + (double) 0.5F, BionicsSounds.ENGINE_IDLE.get(), this.getSoundSource(), 0.01f, 1.2F, false);
        }

        if (isSitting()) {
            if (fluidLevel < 1) {
                fluidLevel = fluidLevel + 0.05f;
            }
        } else {
            if (fluidLevel > 0) {
                fluidLevel = fluidLevel - 0.05f;
            }
        }
        if (entityData.get(FUEL) > 0) {
            entityData.set(FUEL, entityData.get(FUEL) - 1);
        }
        if (countdown > 0) {
            countdown = countdown - 1;
        }
    }

    /* RIGHT CLICKING */
    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        Item item = itemstack.getItem();

        if(item == BionicsItems.SILENT_PISTON.get() && isOwnedBy(player) && !isSilent()){
            if(this.level().isClientSide()) {
                return InteractionResult.CONSUME;
            } else {
                if (!player.getAbilities().instabuild) {
                    itemstack.shrink(1);
                }
                setSilent(true);
                return InteractionResult.SUCCESS;
            }
        }
        if(item == (Items.COAL) || item == (Items.CHARCOAL)){
            if(!isTame() && getMainHandItem().isEmpty()) {
                if (this.level().isClientSide()) {
                    return InteractionResult.SUCCESS;
                } else {
                    if (!EventHooks.onAnimalTame(this, player)) {
                        super.tame(player);
                        this.navigation.recomputePath();
                        this.setTarget(null);
                        this.level().broadcastEntityEvent(this, (byte) 7);
                        this.entityData.set(FUEL, 1000);
                    }

                    return InteractionResult.SUCCESS;
                }
            }
            if(this.level().isClientSide()) {
                return InteractionResult.CONSUME;
            } else {
                if (!player.getAbilities().instabuild) {
                    itemstack.shrink(1);
                }
                this.entityData.set(FUEL, 1000);
                makeSound(SoundEvents.FIRECHARGE_USE);
                return InteractionResult.SUCCESS;
            }
        }
        if (((item == (BionicsItems.REPLETE_LEG.get()) && entityData.get(BUILD_PROGRESS) < 6) || (((item == (BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:fluid_tank"))) && entityData.get(BUILD_PROGRESS) > 5 )) && entityData.get(BUILD_PROGRESS) < 12)) || ((item == (BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:mechanical_pump"))) && entityData.get(BUILD_PROGRESS) == 6 ))) {
            if(this.level().isClientSide()) {
                return InteractionResult.CONSUME;
            } else {
                if (!player.getAbilities().instabuild) {
                    itemstack.shrink(1);
                }
                entityData.set(BUILD_PROGRESS, entityData.get(BUILD_PROGRESS) + 1);
                return InteractionResult.SUCCESS;
            }
        }
        if (entityData.get(BUILD_PROGRESS) > 0 && item == (BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:wrench"))) && player.isShiftKeyDown()) {
            if(this.level().isClientSide()) {
                return InteractionResult.CONSUME;
            } else {
                entityData.set(BUILD_PROGRESS, entityData.get(BUILD_PROGRESS) - 1);
                return InteractionResult.SUCCESS;
            }
        }
        if(itemstack.getCapability(Capabilities.FluidHandler.ITEM, null) != null) {
            if(hasFluidStackInHand(player, hand)) {
                transferFluidToTank(player, hand);
                if(this.level().isClientSide()) {
                    return InteractionResult.SUCCESS;
                } else {
                    if (!player.getAbilities().instabuild) {
                        itemstack.shrink(1);
                    }
                    return InteractionResult.SUCCESS;
                }
            }
            if(hasFluidHandlerInHand(player, hand)) {
                transferFluidFromTankToPlayer(player, hand);
                if(this.level().isClientSide()) {
                    return InteractionResult.SUCCESS;
                } else {
                    if (!player.getAbilities().instabuild) {
                        itemstack.shrink(1);
                    }
                    return InteractionResult.SUCCESS;
                }
            }
        }
        if(isTame() && isOwnedBy(player) && entityData.get(FUEL) > 0) {
            toggleSitting();
            return InteractionResult.SUCCESS;
        }

       return super.mobInteract(player, hand);
    }

    /* SITTING */
    public boolean isSitting() {
        return this.entityData.get(LAST_POSE_CHANGE_TICK) < 0L;
    }

    public void toggleSitting() {
        if (this.isSitting()) {
            standUp();
        } else {
            if (random.nextFloat() > 0.995) {
                countdown = 150;
                this.level().playLocalSound(this.getX() + (double) 0.5F, this.getY() + (double) 0.5F, this.getZ() + (double) 0.5F, BionicsSounds.GET_STICK_BUGGED.get(), this.getSoundSource(), 1f, 1f, false);
            }
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
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(LAST_POSE_CHANGE_TICK, 0L);
        builder.define(VARIANT, 0);
        builder.define(FUEL, 0);
        builder.define(FILL_LEVEL,0F);
        builder.define(BUILD_PROGRESS, 0);

    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putLong("LastPoseTick", this.entityData.get(LAST_POSE_CHANGE_TICK));
        compound.putInt("Variant", this.getTypeVariant());
        compound.putInt("RefuelTime", this.entityData.get(FUEL));
        compound.putInt("Build_Progress", this.entityData.get(BUILD_PROGRESS));
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        long i = compound.getLong("LastPoseTick");
        if (i < 0L) {
            this.setPose(Pose.SITTING);
        }
        this.resetLastPoseChangeTick(i);
        this.entityData.set(VARIANT, compound.getInt("Variant"));
        entityData.set(FUEL, compound.getInt("RefuelTime"));
        entityData.set(BUILD_PROGRESS, compound.getInt("Build_Progress"));
    }

    //VARIANT//

    private void setTypeVariant(int typeVariant) {
        this.entityData.set(VARIANT, typeVariant);
    }

    private int getTypeVariant() {
        return this.entityData.get(VARIANT);
    }

    public RepleteVariant getVariant() {
        return RepleteVariant.byId(this.getTypeVariant() & 255);
    }

    public void setVariant(RepleteVariant variant) {
        this.entityData.set(VARIANT, variant.getId() & 255);
    }

    /*FLUID*/

    @Override
    public @Nullable AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return null;
    }

    private final ItemStackHandler itemHandler = new ItemStackHandler(1) {
        @Override
        public int getSlotLimit(int slot) {
            return slot == 1 ? 1 : super.getSlotLimit(slot);
        }
    };

    private final FluidTank FLUID_TANK = createFluidTank();
    private FluidTank createFluidTank() {
        return new FluidTank(160000) {
            @Override
            public boolean isFluidValid(FluidStack stack) {
                return true;
            }
        };
    }
    public FluidStack getFluid() {
        return FLUID_TANK.getFluid();
    }

    public IFluidHandler getTank(@Nullable Direction direction) {
        return FLUID_TANK;
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Replete");
    }

    @Nullable
    public AbstractContainerMenu createMenu(int containerId, Inventory playerInventory) {
        return null;
    }

    private boolean hasFluidStackInHand(Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        return !itemStack.isEmpty()
                && itemStack.getCapability(Capabilities.FluidHandler.ITEM, null) != null
                && !itemStack.getCapability(Capabilities.FluidHandler.ITEM, null).getFluidInTank(0).isEmpty();
    }

    private void transferFluidFromTankToPlayer(Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        FluidActionResult result = FluidUtil.tryFillContainer(itemStack, this.FLUID_TANK, Integer.MAX_VALUE, player, true);
        if (result.result != ItemStack.EMPTY) {
            player.addItem(result.result);
        }
    }

    public void transferFluidToTank(Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        FluidActionResult result = FluidUtil.tryEmptyContainer(itemStack, this.FLUID_TANK, Integer.MAX_VALUE, player, true);
        if(result.result != ItemStack.EMPTY) {
            player.addItem(result.result);
        }
    }
    private boolean hasFluidHandlerInHand(Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        return !itemStack.isEmpty()
                && itemStack.getCapability(Capabilities.FluidHandler.ITEM, null) != null
                && (itemStack.getCapability(Capabilities.FluidHandler.ITEM, null).getFluidInTank(0).isEmpty() ||
                FluidUtil.tryFluidTransfer(itemStack.getCapability(Capabilities.FluidHandler.ITEM, null),
                        FLUID_TANK, Integer.MAX_VALUE, false) != FluidStack.EMPTY);
    }
}
