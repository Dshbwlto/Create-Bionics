package net.dshbwlto.createbionics.entity.custom;

import com.simibubi.create.AllItems;
import com.simibubi.create.AllSoundEvents;
import net.dshbwlto.createbionics.Util.BionicsDataComponentTypes;
import net.dshbwlto.createbionics.entity.api.AbstractRobot;
import net.dshbwlto.createbionics.entity.client.matchbox.MatchboxVariant;
import net.dshbwlto.createbionics.item.BionicsItems;
import net.dshbwlto.createbionics.sound.BionicsSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
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
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.level.pathfinder.WalkNodeEvaluator;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.EventHooks;
import org.jetbrains.annotations.Nullable;

public class MatchboxEntity extends AbstractRobot {

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    private int collapseCountdown = -1;
    public int maxCount = 256;

    public final AnimationState sitDownAnimationState = new AnimationState();
    public final AnimationState sitPoseAnimationState = new AnimationState();
    public final AnimationState sitUpAnimationState = new AnimationState();

    public AnimationState deployAnimationState = new AnimationState();
    public AnimationState collapseAnimationState = new AnimationState();

    public static final EntityDataAccessor<Integer> PLACEABLE =
            SynchedEntityData.defineId(MatchboxEntity.class, EntityDataSerializers.INT);
    public boolean isPlaceable() {
        return entityData.get(PLACEABLE) != 0;
    }
    public void togglePlaceable(Player player) {
        if (entityData.get(PLACEABLE) != 2) {
            entityData.set(PLACEABLE, entityData.get(PLACEABLE) + 1);
        } else {
            entityData.set(PLACEABLE, 0);
        }
        player.displayClientMessage(Component.translatable("entity.createbionics.all.place.tooltip")
                .append(Component.translatable("entity.createbionics.all.place." + entityData.get(PLACEABLE))), true);
    }

    public static final EntityDataAccessor<Integer> TORCHES =
            SynchedEntityData.defineId(MatchboxEntity.class, EntityDataSerializers.INT);
    public int torchCount() {
        return entityData.get(TORCHES);
    }
    public void setTorchCount(int count) {
        entityData.set(TORCHES, count);
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
                .add(Attributes.MAX_HEALTH, 10D)
                .add(Attributes.MOVEMENT_SPEED, 0.4)
                .add(Attributes.ATTACK_DAMAGE, 2f)
                .add(Attributes.FOLLOW_RANGE, 7D)
                .add(Attributes.SAFE_FALL_DISTANCE, 200D)
                .add(Attributes.WATER_MOVEMENT_EFFICIENCY, 200f);
    }

    @Override
    protected void dropCustomDeathLoot(ServerLevel level, DamageSource damageSource, boolean recentlyHit) {
        super.dropCustomDeathLoot(level, damageSource, recentlyHit);
        if (getVariant() != MatchboxVariant.ANDESITE) {
            dropIngot();
        }
        for (int i = 0; i < torchCount(); i++) {
            if (random.nextFloat() > 0.7f) {
                spawnAtLocation(new ItemStack(Items.TORCH.asItem()));
            }
        }
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return BionicsSounds.MATCHBOX_IDLE_4.get();
    }
    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        int i = Mth.clamp(random.nextInt(), 1, 4);
        return (i == 1 ? BionicsSounds.MATCHBOX_IDLE_1
                : i == 2 ? BionicsSounds.MATCHBOX_IDLE_2
                : i == 3 ? BionicsSounds.MATCHBOX_IDLE_3
                : BionicsSounds.MATCHBOX_IDLE_4).get();
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource damageSource) {
        return BionicsSounds.MATCHBOX_DAMAGE.get();
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
    public void makeStuckInBlock(BlockState state, Vec3 motionMultiplier) {
    }

    @Override
    public void tryToTeleportToOwner() {
        LivingEntity livingentity = this.getOwner();
        if (livingentity != null) {
            this.teleportToAroundBlockPos(livingentity.blockPosition());
        }

    }
    @Override
    public boolean shouldTryTeleportToOwner() {
        LivingEntity livingentity = this.getOwner();
        return livingentity != null && this.distanceToSqr(this.getOwner()) >= (double)144.0F;
    }

    private void teleportToAroundBlockPos(BlockPos pos) {
        for(int i = 0; i < 10; ++i) {
            int j = this.random.nextIntBetweenInclusive(-3, 3);
            int k = this.random.nextIntBetweenInclusive(-3, 3);
            if (Math.abs(j) >= 2 || Math.abs(k) >= 2) {
                int l = this.random.nextIntBetweenInclusive(-1, 1);
                if (this.maybeTeleportTo(pos.getX() + j, pos.getY() + l, pos.getZ() + k)) {
                    return;
                }
            }
        }

    }

    private boolean maybeTeleportTo(int x, int y, int z) {
        if (!this.canTeleportTo(new BlockPos(x, y, z))) {
            return false;
        } else if (level().getBlockState(new BlockPos(x, y, z)).isAir()){
            this.moveTo((double)x + (double)0.5F, (double)y, (double)z + (double)0.5F, this.getYRot(), this.getXRot());
            this.navigation.stop();
            return true;
        } else {
            return false;
        }
    }

    private boolean canTeleportTo(BlockPos pos) {
        PathType pathtype = WalkNodeEvaluator.getPathTypeStatic(this, pos);
        if (pathtype != PathType.WALKABLE) {
            return false;
        } else {
            BlockState blockstate = this.level().getBlockState(pos.below());
            if (!this.canFlyToOwner() && blockstate.getBlock() instanceof LeavesBlock) {
                return false;
            } else {
                BlockPos blockpos = pos.subtract(this.blockPosition());
                return this.level().noCollision(this, this.getBoundingBox().move(blockpos));
            }
        }
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

        if (isTame() && getBrightness(getOwner().getOnPos()) < 2 && getCommand() != 2) {
            this.navigation.createPath(getOwner().getOnPos(), 0);
        }

        if (!level().isClientSide && torchCount() > 0 && getBrightness(getOnPos()) < 3 && isFueled()) {
            placeTorch();
        }

        if (collapseCountdown > 0) {
            collapseCountdown -= 1;
        } else if (collapseCountdown == 0) {
            spawnAtLocation(matchboxItem());
            remove(RemovalReason.DISCARDED);
        }

        if (this.level().isClientSide()) {
            this.setupAnimationStates();
        }

        if (!isSitting() && !isPassenger() && getFuel() > 0) {
            setFuel(getFuel() - 1);
        }

        if (this.horizontalCollision && navigation.getPath() != null && !navigation.getPath().canReach()) {
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
                    if (getCommand() == 2) {
                        updateCommand(null);
                    } else if (getCommand() == 1) {
                        updateCommand(null);
                        updateCommand(null);
                    }
                } else {
                    dropIngot();
                    setVariant(MatchboxVariant.ANDESITE);
                }
                return InteractionResult.SUCCESS;
            } else if (itemStack.is(Items.COAL) || itemStack.is(Items.CHARCOAL)) {
                setFuel(12000);
                if (!player.getAbilities().instabuild) {
                    itemStack.shrink(1);
                }
                playSound(AllSoundEvents.BLAZE_MUNCH.getMainEvent());
                spawnFireParticles(false, 3);
                return InteractionResult.CONSUME;
            } else if (itemStack.is(AllItems.BLAZE_CAKE)) {
                setFuel(24000);
                if (!player.getAbilities().instabuild) {
                    itemStack.shrink(1);
                }
                playSound(AllSoundEvents.BLAZE_MUNCH.getMainEvent());
                spawnFireParticles(true, 3);
                return InteractionResult.CONSUME;
            } else if (itemStack.is(AllItems.CREATIVE_BLAZE_CAKE)) {
                setFuel(getFuel() == -1 ? 24000 : -1);
                playSound(AllSoundEvents.BLAZE_MUNCH.getMainEvent());
                spawnFireParticles(true, 3);
                return InteractionResult.SUCCESS;
            } else if (itemStack.is(Items.TORCH)) {
                int size = itemStack.getCount();
                int space = maxCount - torchCount();
                if (space < size) {
                    size = space;
                }
                if (space != 0) {
                    setTorchCount(torchCount() + size);
                    if (!player.getAbilities().instabuild) {
                        itemStack.shrink(size);
                    }
                    int color = torchCount() == maxCount ? 5635925 : 16777215;
                    player.displayClientMessage(Component.translatable("entity.createbionics.all.torch").setStyle(Style.EMPTY.withColor(color))
                            .append("" + torchCount()).setStyle(Style.EMPTY.withColor(color)), true);
                    if (torchCount() == maxCount) {
                        playSound(AllSoundEvents.CONFIRM.getMainEvent());
                    }
                    return InteractionResult.SUCCESS;
                } else {
                    player.displayClientMessage(Component.translatable("entity.createbionics.all.torch_full"), true);
                    playSound(AllSoundEvents.DENY.getMainEvent());
                    return InteractionResult.SUCCESS;
                }
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
        int i = getFuel() >= 0 ? getFuel() : 24001;
        ItemStack item = new ItemStack(BionicsItems.MATCHBOX.get());
        item.set(BionicsDataComponentTypes.VARIANT, getTypeVariant());
        item.set(BionicsDataComponentTypes.MISC_INT, torchCount());
        item.set(BionicsDataComponentTypes.FUEL, i);
        if (hasCustomName()) {
            item.set(BionicsDataComponentTypes.NAME, getDisplayName().getString());
        }
        return item;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        /// just stop.
        builder.define(PLACEABLE, 1);
        builder.define(TORCHES, 0);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Placeable", this.entityData.get(PLACEABLE));
        compound.putInt("Torches", this.torchCount());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.entityData.set(PLACEABLE, compound.getInt("Placeable"));
        this.entityData.set(TORCHES, compound.getInt("Torches"));
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

    // Torches //

    public int getBrightness (BlockPos pos) {
        int x = entityData.get(PLACEABLE);
        int sky = level().getBrightness(LightLayer.SKY, pos.above());
        int block = level().getBrightness(LightLayer.BLOCK, pos.above());
        if (x == 0) {
            return 15;
        } else if (x == 1) {
            return block;
        } else {
            return Math.max(block, sky);
        }
    }


    public void placeTorch() {
        if (!level().getBlockState(blockPosition()).isAir()) {
            return;
        }
        if (level().getBlockState(blockPosition().below()).isAir() || !level().getBlockState(blockPosition().below()).isCollisionShapeFullBlock(level(), blockPosition().below())) {
            return;
        } else {
            level().setBlock(blockPosition(), Blocks.TORCH.defaultBlockState(), 11);
            setTorchCount(torchCount() - 1);
        }
    }
}