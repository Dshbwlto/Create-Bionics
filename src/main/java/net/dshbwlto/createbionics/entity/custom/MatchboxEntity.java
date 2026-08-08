package net.dshbwlto.createbionics.entity.custom;

import com.simibubi.create.AllItems;
import com.simibubi.create.AllSoundEvents;
import net.dshbwlto.createbionics.component.BionicsDataComponentTypes;
import net.dshbwlto.createbionics.entity.api.AbstractRobot;
import net.dshbwlto.createbionics.entity.client.matchbox.MatchboxVariant;
import net.dshbwlto.createbionics.item.BionicsItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
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
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.EventHooks;
import org.jetbrains.annotations.Nullable;

public class MatchboxEntity extends AbstractRobot {

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    private int collapseCountdown = -1;

    public final AnimationState sitDownAnimationState = new AnimationState();
    public final AnimationState sitPoseAnimationState = new AnimationState();
    public final AnimationState sitUpAnimationState = new AnimationState();

    public AnimationState deployAnimationState = new AnimationState();
    public AnimationState collapseAnimationState = new AnimationState();

    public static final EntityDataAccessor<Boolean> PLACEABLE =
            SynchedEntityData.defineId(MatchboxEntity.class, EntityDataSerializers.BOOLEAN);
    public boolean isPlaceable() {
        return entityData.get(PLACEABLE);
    }
    public void setPlaceable(boolean placeable) {
        entityData.set(PLACEABLE, placeable);
    }
    public void togglePlaceable(Player player) {
        setPlaceable(!isPlaceable());
        if (level().isClientSide) {
            player.displayClientMessage(Component.translatable("entity.createbionics.all.place." + isPlaceable(), this.getDisplayName()), true);
        }
    }

    public MatchboxEntity(EntityType<? extends AbstractRobot> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
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
                .add(Attributes.FOLLOW_RANGE, 7D)
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
        return matchboxItem();
    }

    public void aiStep() {
        if (this.level().isClientSide && isFueled()) {
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
            this.idleAnimationTimeout = 100;
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

        if (collapseCountdown > 0) {
            collapseCountdown -= 1;
        } else if (collapseCountdown == 0) {
            spawnAtLocation(matchboxItem());
            remove(RemovalReason.DISCARDED);
        }

        if (!level().isClientSide && isPlaceable()) {
            if (level().getBrightness(LightLayer.BLOCK, blockPosition()) < 3 && level().getBrightness(LightLayer.SKY, blockPosition()) < 3) {
                if (getBlockStateOn().isCollisionShapeFullBlock(level(), blockPosition().below()) && !getBlockStateOn().isAir()) {
                    BlockPos blockPos = blockPosition();
                    if (level().getBlockState(blockPos.below()).isAir()) {
                        blockPos = blockPos.below();
                    }
                    if (!level().getBlockState(blockPos.below()).isAir()) {
                        level().setBlock(blockPos, Blocks.TORCH.defaultBlockState(), 11);
                    }
                }
            }
        }

        if (this.level().isClientSide()) {
            this.setupAnimationStates();
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
            if (itemStack.is(Items.COPPER_INGOT)
                    || itemStack.is(AllItems.BRASS_INGOT)) {
                dropIngot();
                setTypeVariant(itemStack);
                if (level().isClientSide) {
                    return InteractionResult.SUCCESS;
                } else {
                    itemStack.shrink(1);
                }
            } else if (itemStack.is(AllItems.WRENCH)) {
                if (player.isShiftKeyDown()) {
                    collapseCountdown = 15;
                    collapseAnimationState.start(tickCount);
                } else {
                    dropIngot();
                    setVariant(MatchboxVariant.ANDESITE);
                }
                return InteractionResult.SUCCESS;
            } else if (itemStack.is(AllItems.CREATIVE_BLAZE_CAKE)) {
                if (hasBlazeCake()) {
                    entityData.set(CREATIVE_BLAZE_CAKE, false);
                } else {
                    setFuel(10000);
                    entityData.set(CREATIVE_BLAZE_CAKE, true);
                    playSound(AllSoundEvents.BLAZE_MUNCH.getMainEvent());
                }
                return InteractionResult.SUCCESS;
            } else if (itemStack.is(Items.COAL) || itemStack.is(Items.CHARCOAL)) {
                setFuel(10000);
                playSound(AllSoundEvents.BLAZE_MUNCH.getMainEvent());
                if (!player.getAbilities().instabuild) {
                    itemStack.shrink(1);
                }
                return InteractionResult.CONSUME;
            } else {
                if (player.isShiftKeyDown()) {
                    togglePlaceable(player);
                } else {
                    updateCommand(player);
                }
                return InteractionResult.SUCCESS;
            }
        }

        return super.mobInteract(player, hand);
    }

    public ItemStack matchboxItem() {
        ItemStack item = new ItemStack(BionicsItems.MATCHBOX.get());
        item.set(BionicsDataComponentTypes.VARIANT, getTypeVariant());
        item.set(BionicsDataComponentTypes.FUEL, getFuel());
        return item;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        //builder.define(PLACEABLE, true);
        /// just stop.
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("Placeable", this.isPlaceable());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.entityData.set(PLACEABLE, compound.getBoolean("Placeable"));
    }

    //VARIANT//

    private void setTypeVariant(ItemStack itemStack) {
        if (itemStack.is(Items.COPPER_INGOT)
                && getVariant() != MatchboxVariant.COPPER) {
            setVariant(MatchboxVariant.COPPER);
        } else if (itemStack.is(AllItems.BRASS_INGOT)
                && getVariant() != MatchboxVariant.BRASS) {
            setVariant(MatchboxVariant.BRASS);
        }
    }

    private void dropIngot() {
        if (getVariant() == MatchboxVariant.BRASS) {
            spawnAtLocation(new ItemStack(AllItems.BRASS_INGOT.asItem()));
        } else if (getVariant() == MatchboxVariant.COPPER) {
            spawnAtLocation(new ItemStack(Items.COPPER_INGOT));
        }
    }

    private int getTypeVariant() {
        return this.entityData.get(VARIANT);
    }

    public MatchboxVariant getVariant() {
        return MatchboxVariant.byId(this.getTypeVariant() & 255);
    }

    public void setVariant(MatchboxVariant variant) {
        this.entityData.set(VARIANT, variant.getId() & 255);
    }
}