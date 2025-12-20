package net.dshbwlto.createbionics.entity.custom;

import net.dshbwlto.createbionics.entity.client.replete.RepleteVariant;
import net.dshbwlto.createbionics.item.BionicsItems;
import net.dshbwlto.createbionics.sound.BionicsSounds;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
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
    private static final EntityDataAccessor<Integer> VARIANT =
            SynchedEntityData.defineId(RepleteEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> FILL =
            SynchedEntityData.defineId(RepleteEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Float> FILL_LEVEL =
            SynchedEntityData.defineId(RepleteEntity.class, EntityDataSerializers.FLOAT);
    public int fuelTime = 501;

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState sitDownAnimationState = new AnimationState();
    public final AnimationState sitPoseAnimationState = new AnimationState();
    public final AnimationState sitUpAnimationState = new AnimationState();

    public static final EntityDataAccessor<Long> LAST_POSE_CHANGE_TICK =
            SynchedEntityData.defineId(RepleteEntity.class, EntityDataSerializers.LONG);

    private static final EntityDataAccessor<ItemStack> DYE_STACK =
            SynchedEntityData.defineId(RepleteEntity.class, EntityDataSerializers.ITEM_STACK);

    private static final EntityDataAccessor<Boolean> LEGL =
            SynchedEntityData.defineId(RepleteEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> LEGR =
            SynchedEntityData.defineId(RepleteEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> LEG2L =
            SynchedEntityData.defineId(RepleteEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> LEG2R =
            SynchedEntityData.defineId(RepleteEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> LEG3L =
            SynchedEntityData.defineId(RepleteEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> LEG3R =
            SynchedEntityData.defineId(RepleteEntity.class, EntityDataSerializers.BOOLEAN);

    public RepleteEntity(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));

        this.goalSelector.addGoal(1, new SitWhenOrderedToGoal(this));

        this.goalSelector.addGoal(2, new FollowOwnerGoal(this, 1.0d, 10f, 5f));

        if(isTame()) {
            this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        }
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 4f));
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

        if (this.level().isClientSide) {
            for(int i = 0; i < 1; ++i) {
                if(!isCurrentlyGlowing()) {
                    this.level().addParticle(ParticleTypes.SMOKE, this.getRandomX((double) 0.5F), this.getRandomY(), this.getRandomZ((double) 0.5F), (double) 0.0F, (double) 0.0F, (double) 0.0F);
                }
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

        if(tickCount % 30 == 0 && !isCurrentlyGlowing() && !isSilent()) {
            this.level().playLocalSound(this.getX() + (double) 0.5F, this.getY() + (double) 0.5F, this.getZ() + (double) 0.5F, BionicsSounds.ENGINE_IDLE.get(), this.getSoundSource(), 0.01F + this.random.nextFloat(), 1.2F, false);
        }

    }

    /* RIGHT CLICKING */
    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        Item item = itemstack.getItem();

        Item itemForNetherite = Items.NETHERITE_INGOT;
        Item itemForRedstone = Items.REDSTONE;
        Item itemForGold = Items.GOLD_INGOT;
        Item itemForDiamond = Items.DIAMOND;
        Item itemForFuel = Items.CHARCOAL;
        int lastFill = entityData.get(FILL);

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
            if(this.level().isClientSide()) {
                return InteractionResult.CONSUME;
            } else {
                if (!player.getAbilities().instabuild) {
                    itemstack.shrink(1);
                }
                this.fuelTime = 100000;
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
                }
            }
        }
        if(!isTame() && getMainHandItem().isEmpty()) {
            if (this.level().isClientSide()) {
                return InteractionResult.SUCCESS;
            } else {
                if (!EventHooks.onAnimalTame(this, player)) {
                    super.tame(player);
                    this.navigation.recomputePath();
                    this.setTarget(null);
                    this.level().broadcastEntityEvent(this, (byte) 7);
                    this.fuelTime = 510;
                }

                return InteractionResult.SUCCESS;
            }
        }
        if(isTame() && isOwnedBy(player) && itemstack.isEmpty()) {
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
        builder.define(FILL, 0);
        builder.define(FILL_LEVEL,0F);
        builder.define(DYE_STACK, ItemStack.EMPTY);

        builder.define(LEGL, false);
        builder.define(LEGR, false);
        builder.define(LEG2L, false);
        builder.define(LEG2R, false);
        builder.define(LEG3L, false);
        builder.define(LEG3R, false);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putLong("LastPoseTick", this.entityData.get(LAST_POSE_CHANGE_TICK));
        compound.putInt("Variant", this.getTypeVariant());
        compound.putInt("RefuelTime", this.fuelTime);

        compound = FLUID_TANK.writeToNBT(registryAccess(), compound);

        compound.putBoolean("LegL", leg_l());
        compound.putBoolean("LegR", leg_r());
        compound.putBoolean("Leg2L", leg2_l());
        compound.putBoolean("Leg2R", leg2_r());
        compound.putBoolean("Hat5", leg3_l());
        compound.putBoolean("Leg3L", leg3_r());
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        long i = compound.getLong("LastPoseTick");
        if (i < 0L) {
            this.setPose(Pose.SITTING);
        }
        this.resetLastPoseChangeTick(i);
        this.entityData.set(VARIANT, compound.getInt("Variant"));
        if (compound.contains("RefuelTime")) {
            this.fuelTime = compound.getInt("RefuelTime");
        }
        this.entityData.set(LEGL, compound.getBoolean("LegL"));
        this.entityData.set(LEGR, compound.getBoolean("LegR"));
        this.entityData.set(LEG2L, compound.getBoolean("Leg2L"));
        this.entityData.set(LEG2R, compound.getBoolean("Leg2R"));
        this.entityData.set(LEG3L, compound.getBoolean("Leg3L"));
        this.entityData.set(LEG3R, compound.getBoolean("Leg3R"));

        FLUID_TANK.readFromNBT(registryAccess(), compound);
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
    public boolean leg_l() {
        return this.entityData.get(LEGL);
    }
    public boolean leg_r() {
        return this.entityData.get(LEGR);
    }
    public boolean leg2_l() {
        return this.entityData.get(LEG2L);
    }
    public boolean leg2_r() {
        return this.entityData.get(LEG2R);
    }
    public boolean leg3_l() {
        return this.entityData.get(LEG3L);
    }
    public boolean leg3_r() {
        return this.entityData.get(LEG3R);
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
