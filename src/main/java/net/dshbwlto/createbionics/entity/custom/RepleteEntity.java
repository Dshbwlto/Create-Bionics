package net.dshbwlto.createbionics.entity.custom;

import com.simibubi.create.AllBlockEntityTypes;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.AllSoundEvents;
import com.simibubi.create.api.connectivity.ConnectivityHandler;
import com.simibubi.create.content.fluids.tank.FluidTankBlockEntity;
import com.simibubi.create.content.kinetics.belt.behaviour.BeltProcessingBehaviour;
import com.simibubi.create.foundation.advancement.AllAdvancements;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import com.simibubi.create.foundation.blockEntity.behaviour.fluid.SmartFluidTankBehaviour;
import com.simibubi.create.foundation.fluid.SmartFluidTank;
import net.createmod.catnip.animation.LerpedFloat;
import net.dshbwlto.createbionics.Util.BionicsEntityDataSerializers;
import net.dshbwlto.createbionics.entity.BionicsEntities;
import net.dshbwlto.createbionics.entity.client.replete.RepleteVariant;
import net.dshbwlto.createbionics.item.BionicsItems;
import net.dshbwlto.createbionics.sound.BionicsSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
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
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.event.EventHooks;
import net.neoforged.neoforge.fluids.FluidActionResult;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.fluids.FluidUtil;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;

import java.util.List;

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

    public final AnimationState sitDownAnimationState = new AnimationState();
    public final AnimationState sitPoseAnimationState = new AnimationState();
    public final AnimationState sitUpAnimationState = new AnimationState();

    public static final EntityDataAccessor<Integer> FUEL =
            SynchedEntityData.defineId(RepleteEntity.class, EntityDataSerializers.INT);

    public RepleteEntity(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(2, new FollowOwnerGoal(this, 1.0d, 10f, 5f) {
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
        if (random.nextFloat() > 0.6) {
            return BionicsSounds.REPLETE_DAMAGE_1.get();
        } else if (random.nextFloat() > 0.3) {
            return BionicsSounds.REPLETE_DAMAGE_2.get();
        } else {
            return BionicsSounds.REPLETE_DAMAGE_3.get();
        }
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
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
    }

    @Override
    protected void dropCustomDeathLoot(ServerLevel level, DamageSource damageSource, boolean recentlyHit) {
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
        if(itemStack.getCapability(Capabilities.FluidHandler.ITEM, null) != null) {
            if (hasFluidStackInHand(player, hand) && getFluid().getAmount() < 160000) {
                transferFluidToTank(player, hand);
                if (this.level().isClientSide()) {
                    return InteractionResult.SUCCESS;
                } else {
                    if (!player.getAbilities().instabuild) {
                        itemStack.shrink(1);
                    }
                    return InteractionResult.SUCCESS;
                }
            }
        }
        if (hasFluidHandlerInHand(player, hand) && getFluid().getAmount() > 0) {
            transferFluidFromTankToPlayer(player, hand);
            if (this.level().isClientSide()) {
                return InteractionResult.SUCCESS;
            } else {
                if (!player.getAbilities().instabuild) {
                    itemStack.shrink(1);
                }
                return InteractionResult.SUCCESS;
            }
        }
        if ((itemStack.is(BionicsItems.ROBOT_BUILDER) || itemStack.is(getPart())) && getAssembly() < 12) {
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
        } else if (itemStack.is(AllItems.WRENCH)) {
            if (getFluid().isEmpty()) {
                player.displayClientMessage(Component.translatable("a"), true);
            }
            if (getAssembly() > 0) {
                setAssembly(getAssembly() - 1);
                spawnAtLocation(new ItemStack(getPart()));
                setFuel(0);
            } else {
                spawnAtLocation(new ItemStack((ItemLike) BionicsItems.REPLETE_BODY));
                remove(RemovalReason.DISCARDED);
            }
            playSound(SoundEvents.NETHERITE_BLOCK_PLACE);
            return InteractionResult.SUCCESS;
        } else if ((itemStack.is(Items.COAL) || itemStack.is(Items.CHARCOAL)) && getAssembly() == 12) {
            setFuel(getFuel() + 10000);
            if (getFuel() > 10000) {
                setFuel(10000);
            }
            itemStack.shrink(1);
            return InteractionResult.CONSUME;
        } else {
            if (getAssembly() == 12 && getFuel() > 0) {
                updateCommand(player);
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

    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Fuel", this.entityData.get(FUEL));
        FLUID_TANK.writeToNBT(level().registryAccess(), compound);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        entityData.set(FUEL, compound.getInt("Fuel"));
        FLUID_TANK.readFromNBT(level().registryAccess(), compound);
        entityData.set(TANK_FLUID, FLUID_TANK.getFluid().copy());
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

    @Override
    public Component getDisplayName() {
        return Component.literal("Tank");
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
                player.addItem(result.result);}
        }
    }

    public void transferFluidToTank(Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        FluidActionResult result = FluidUtil.tryEmptyContainer(itemStack, this.FLUID_TANK, Integer.MAX_VALUE, player, true);
        if(result.result != ItemStack.EMPTY) {
            if (!player.getAbilities().instabuild) {
                player.addItem(result.result);
            }
        }
    }

    private void transferFluidFromTankToHandler() {
        FluidActionResult result = FluidUtil.tryFillContainer(itemHandler.getStackInSlot(0), this.FLUID_TANK, Integer.MAX_VALUE, null, true);
        if(result.result != ItemStack.EMPTY) {
            itemHandler.setStackInSlot(0, result.result);
        }
    }

    private void transferFluidToTank() {
        FluidActionResult result = FluidUtil.tryEmptyContainer(itemHandler.getStackInSlot(0), this.FLUID_TANK, Integer.MAX_VALUE, null, true);
        if(result.result != ItemStack.EMPTY) {
            itemHandler.setStackInSlot(0, result.result);
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
