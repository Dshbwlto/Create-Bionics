
package net.dshbwlto.createbionics.entity.custom;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import net.createmod.catnip.animation.AnimationTickHolder;
import net.dshbwlto.createbionics.Util.BionicsEntityDataSerializers;
import net.dshbwlto.createbionics.entity.api.AbstractRobot;
import net.dshbwlto.createbionics.entity.client.replete.RepleteVariant;
import net.dshbwlto.createbionics.item.BionicsItems;
import net.dshbwlto.createbionics.sound.BionicsSounds;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
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
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.event.EventHooks;
import net.neoforged.neoforge.fluids.FluidActionResult;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.FluidUtil;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class RepleteEntity extends AbstractRobot implements MenuProvider{
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public int countdown = 0;
    public float sitOffset = 0;

    public static final EntityDataAccessor<FluidStack> TANK_FLUID =
            SynchedEntityData.defineId(RepleteEntity.class, BionicsEntityDataSerializers.FLUID_STACK.get());
    public int getFuel() {
        return entityData.get(FUEL);
    }
    public void setFuel(int fuel) {
        entityData.set(FUEL, fuel);
    }

    public boolean getWindow() {
        return entityData.get(WINDOW);
    }
    public void toggleWindow() {
        if (getWindow()) {
            entityData.set(WINDOW, false);
        } else {
            entityData.set(WINDOW, true);
        }
    }

    public final AnimationState sitDownAnimationState = new AnimationState();
    public final AnimationState sitPoseAnimationState = new AnimationState();
    public final AnimationState sitUpAnimationState = new AnimationState();

    public static final EntityDataAccessor<Integer> FUEL =
            SynchedEntityData.defineId(RepleteEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Boolean> WINDOW =
            SynchedEntityData.defineId(RepleteEntity.class, EntityDataSerializers.BOOLEAN);

    public RepleteEntity(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(2, new FollowOwnerGoal(this, 1.0d, 15, 7) {
            @Override
            public boolean canUse() {
                return super.canUse() && getCommand() == 0 && getAssembly() == 12 && getFuel() > 0;
            }
        });
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1.0D) {
            @Override
            public boolean canUse() {
                return super.canUse() && getAssembly() == 12 && getFuel() > 0;
            }
        });
    }

    @Override
    public boolean shouldTryTeleportToOwner() {
        if (isTame()) {
            return distanceTo(Objects.requireNonNull(getOwner())) > 30;
        }
        return super.shouldTryTeleportToOwner();
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 50D)
                .add(Attributes.MOVEMENT_SPEED, 0.25)
                .add(Attributes.ATTACK_DAMAGE, 2f)
                .add(Attributes.FOLLOW_RANGE, 50D);
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
        return BionicsSounds.REPLETE_DAMAGE_3.get();
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource damageSource) {
        if (getFuel() > 0) {
            if (random.nextFloat() > 0.6) {
                return BionicsSounds.REPLETE_DAMAGE_1.get();
            } else if (random.nextFloat() > 0.3) {
                return BionicsSounds.REPLETE_DAMAGE_2.get();
            } else {
                return BionicsSounds.REPLETE_DAMAGE_3.get();
            }
        } else {
            return SoundEvents.COPPER_BREAK;
        }
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        if (getFuel() > 0) {
            if (random.nextFloat() > 0.2) {
                return BionicsSounds.REPLETE_IDLE_1.get();
            } else if (random.nextFloat() > 0.4) {
                return BionicsSounds.REPLETE_IDLE_2.get();
            } else if (random.nextFloat() > 0.6) {
                return BionicsSounds.REPLETE_IDLE_3.get();
            } else if (random.nextFloat() > 0.8) {
                return BionicsSounds.REPLETE_IDLE_4.get();
            } else {
                return BionicsSounds.REPLETE_IDLE_5.get();
            }
        } else {
            return null;
        }
    }
    @Override
    protected void dropCustomDeathLoot(ServerLevel level, DamageSource damageSource, boolean recentlyHit) {
        spawnAtLocation(canDrop(getAssembly(), 0, BionicsItems.REPLETE_BODY.get()));
        spawnAtLocation(canDrop(getAssembly(), 1, BionicsItems.REPLETE_LEG.get()));
        spawnAtLocation(canDrop(getAssembly(), 2, BionicsItems.REPLETE_LEG.get()));
        spawnAtLocation(canDrop(getAssembly(), 3, BionicsItems.REPLETE_LEG.get()));
        spawnAtLocation(canDrop(getAssembly(), 4, BionicsItems.REPLETE_LEG.get()));
        spawnAtLocation(canDrop(getAssembly(), 5, BionicsItems.REPLETE_LEG.get()));
        spawnAtLocation(canDrop(getAssembly(), 6, BionicsItems.REPLETE_LEG.get()));
        spawnAtLocation(canDrop(getAssembly(), 7, AllBlocks.MECHANICAL_PUMP.asItem()));
        spawnAtLocation(canDrop(getAssembly(), 8, AllBlocks.FLUID_TANK.asItem()));
        spawnAtLocation(canDrop(getAssembly(), 9, AllBlocks.FLUID_TANK.asItem()));
        spawnAtLocation(canDrop(getAssembly(), 10, AllBlocks.FLUID_TANK.asItem()));
        spawnAtLocation(canDrop(getAssembly(), 11, AllBlocks.FLUID_TANK.asItem()));
        spawnAtLocation(canDrop(getAssembly(), 12, AllBlocks.FLUID_TANK.asItem()));
        if (getVariant() != RepleteVariant.COPPER) {
            dropIngot();
        }
    }

    public void aiStep() {
        if (getFuel() > 0 && getAssembly() == 12 && this.level().isClientSide) {
            for(int i = 0; i < 1; ++i) {
                this.level().addParticle(ParticleTypes.SMOKE, this.getRandomX((double) 0.5F), this.getRandomY(), this.getRandomZ((double) 0.5F), (double) 0.0F, (double) 0.0F, (double) 0.0F);
            }
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

        playSoundScape(2, 6);

        if (isSitting()) {
            if (sitOffset < 1) {
                sitOffset = sitOffset + 0.05f;
            }
        } else {
            if (sitOffset > 0) {
                sitOffset = sitOffset - 0.05f;
            }
            if (getFuel() > 0) {
                setFuel(getFuel() - 1);
            }
        }
        if (countdown > 0) {
            countdown = countdown - 1;
        }

        if (canDebugSwapSkins() && AnimationTickHolder.getTicks() % 30 == 0) {
            if (getTypeVariant() < 2) {
                entityData.set(VARIANT, getTypeVariant() + 1);
            } else {
                entityData.set(VARIANT, 0);
            }
        }
    }

    /* RIGHT CLICKING */
    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        if (!isTame() && itemStack.isEmpty()) {
            if (this.level().isClientSide()) {
                return InteractionResult.SUCCESS;
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
        //
        if(itemStack.getCapability(Capabilities.FluidHandler.ITEM, null) != null) {
            if (hasFluidStackInHand(player, hand) && getFluid().getAmount() < 160000) {
                if (getAssembly() == 12) {
                    transferFluidToTank(player, hand);
                    if (this.level().isClientSide()) {
                        return InteractionResult.SUCCESS;
                    } else {
                        if (!player.getAbilities().instabuild) {
                            itemStack.shrink(1);
                        }
                        return InteractionResult.SUCCESS;
                    }
                } else {
                    player.displayClientMessage(Component.translatable("entity.createbionics.all.construction_warning"), true);
                }
            }
        }
        if (hasFluidHandlerInHand(player, hand) && getFluid().getAmount() > 0 && getAssembly() == 12) {
            if (getAssembly() == 12) {
                transferFluidFromTankToPlayer(player, hand);
                if (this.level().isClientSide()) {
                    return InteractionResult.SUCCESS;
                } else {
                    if (!player.getAbilities().instabuild) {
                        itemStack.shrink(1);
                    }
                    return InteractionResult.SUCCESS;
                }
            } else {
                player.displayClientMessage(Component.translatable("entity.createbionics.all.construction_warning"), true);
            }
        }
        if (itemStack.is(ItemTags.CREEPER_DROP_MUSIC_DISCS)) {
            if (level().isClientSide) {
                return InteractionResult.SUCCESS;
            } else {
                itemStack.shrink(1);
                player.addItem(new ItemStack(BionicsItems.WALTZ_2_MUSIC_DISC.get()));
            }
        } else if ((itemStack.is(BionicsItems.ROBOT_BUILDER) || itemStack.is(getPart())) && getAssembly() < 12) {
            setAssembly(getAssembly() + 1);
            if (!itemStack.is(BionicsItems.ROBOT_BUILDER.get())) {
                itemStack.shrink(1);
            }
            playSound(SoundEvents.NETHERITE_BLOCK_PLACE);
            if (getAssembly() < 12) {
                player.displayClientMessage(Component.translatable("entity.createbionics.all.assembly", getPart().getDescription().getString()), true);
            }
            return InteractionResult.CONSUME;
        } else if (itemStack.is(Items.COPPER_INGOT) && getHealth() < getMaxHealth()) {
            if (level().isClientSide) {
                return InteractionResult.SUCCESS;
            } else {
                if (!player.getAbilities().instabuild) {
                    itemStack.shrink(1);
                }
            }
            heal(10);
            makeSound(SoundEvents.SMITHING_TABLE_USE);
            return InteractionResult.CONSUME;
        } else if (itemStack.is(Items.COPPER_INGOT)
                || itemStack.is(AllItems.BRASS_INGOT)
                || itemStack.is(AllItems.ANDESITE_ALLOY)) {
            dropIngot();
            setTypeVariant(itemStack);
            if (level().isClientSide) {
                return InteractionResult.SUCCESS;
            } else {
                itemStack.shrink(1);
            }
        } else if (itemStack.is(Items.COAL) || itemStack.is(Items.CHARCOAL) || itemStack.is(AllItems.BLAZE_CAKE) && !isInWater()) {
            if (this.level().isClientSide()) {
                return InteractionResult.CONSUME;
            } else {
                if (!player.getAbilities().instabuild) {
                    itemStack.shrink(1);
                }
                if (itemStack.is(AllItems.BLAZE_CAKE)) {
                    setFuel(25000);
                } else {
                    setFuel(10000);
                }
                makeSound(SoundEvents.FIRECHARGE_USE);
            }
        } else if (itemStack.is(AllItems.WRENCH)) {
            if (!player.isShiftKeyDown()) {
                toggleWindow();
            } else {
                if (!level().isClientSide) {
                    if (getFluid().isEmpty() && getFluid().getAmount() == 0) {
                        if (getAssembly() > 0) {
                            spawnAtLocation(new ItemStack(getPart()));
                            setAssembly(getAssembly() - 1);
                            setFuel(0);
                        } else {
                            spawnAtLocation(BionicsItems.REPLETE_BODY);
                            if (getVariant() != RepleteVariant.COPPER) {
                                dropIngot();
                            }
                            remove(RemovalReason.DISCARDED);
                        }
                    } else {
                        player.displayClientMessage(Component.translatable("entity.createbionics.all.empty_warning"), true);
                    }
                }
            }
            return InteractionResult.SUCCESS;
        } else {
            if (getFuel() > 0 && isOwnedBy(player) && !hasFluidHandlerInHand(player, hand) && !hasFluidStackInHand(player, hand)) {
                updateCommand(player);
                if (getCommand() == 0 && random.nextFloat() < 0.001) {
                    playSound(BionicsSounds.GET_STICK_BUGGED.get());
                    countdown = 150;
                }
                return InteractionResult.SUCCESS;
            }
        }
        return super.mobInteract(player, hand);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(FUEL, 0);
        builder.define(TANK_FLUID, FluidStack.EMPTY);
        builder.define(WINDOW, false);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Fuel", this.entityData.get(FUEL));
        compound.putBoolean("Window", this.entityData.get(WINDOW));
        FLUID_TANK.writeToNBT(level().registryAccess(), compound);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        entityData.set(FUEL, compound.getInt("Fuel"));
        entityData.set(WINDOW, compound.getBoolean("Window"));
        FLUID_TANK.readFromNBT(level().registryAccess(), compound);
        entityData.set(TANK_FLUID, FLUID_TANK.getFluid().copy());
    }

    //VARIANT//
    private void setTypeVariant(ItemStack itemStack) {
        if (itemStack.getItem() == Items.COPPER_INGOT && getVariant() != RepleteVariant.COPPER) {
            setVariant(RepleteVariant.COPPER);
        } else if (itemStack.is(AllItems.ANDESITE_ALLOY)
                && getVariant() != RepleteVariant.ANDESITE) {
            setVariant(RepleteVariant.ANDESITE);
        } else if (itemStack.is(AllItems.BRASS_INGOT)
                && getVariant() != RepleteVariant.BRASS) {
            setVariant(RepleteVariant.BRASS);
        }
    }
    private void dropIngot() {
        if (getVariant() == RepleteVariant.BRASS) {
            spawnAtLocation(new ItemStack(AllItems.BRASS_INGOT.asItem()));
        } else if (getVariant() == RepleteVariant.COPPER) {
            spawnAtLocation(new ItemStack(Items.COPPER_INGOT));
        } else if (getVariant() == RepleteVariant.ANDESITE) {
            spawnAtLocation(new ItemStack(AllItems.ANDESITE_ALLOY.asItem()));
        }
    }
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

    /*ASSEMBLY*/

    public Item getPart() {
        if (getAssembly() < 6) {
            return BionicsItems.REPLETE_LEG.get();
        } else if (getAssembly() == 6) {
            return AllBlocks.MECHANICAL_PUMP.asItem();
        } else if (getAssembly() > 6 && getAssembly() <= 12) {
            return AllBlocks.FLUID_TANK.asItem();
        } else {
            return null;
        }
    }

    /*FLUID*/

    public final ItemStackHandler itemHandler = new ItemStackHandler(2) {
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

            @Override
            protected void onContentsChanged() {
                if (!level().isClientSide) {
                    entityData.set(TANK_FLUID, getFluid().copy());
                }
            }
        };

    }

    public FluidStack getSynchedFluid() {
        return entityData.get(TANK_FLUID);
    }

    public FluidStack getFluid() {
        return FLUID_TANK.getFluid();
    }

    public IFluidHandler getTank(@Nullable Direction direction) {
        return FLUID_TANK;
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
            if (!player.getAbilities().instabuild) {
                player.getItemInHand(hand).shrink(1);
                player.addItem(result.result);
            }
        }
    }

    public void transferFluidToTank(Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        FluidActionResult result = FluidUtil.tryEmptyContainer(itemStack, this.FLUID_TANK, Integer.MAX_VALUE, player, true);
        if(result.result != ItemStack.EMPTY) {
            if (!player.getAbilities().instabuild) {
                player.getItemInHand(hand).shrink(1);
                player.addItem(result.result);
            }
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

    @Override
    public @Nullable AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return null;
    }
}
