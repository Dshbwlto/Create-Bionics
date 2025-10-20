package net.dshbwlto.createbionics.entity.custom;

import net.dshbwlto.createbionics.entity.BionicsEntities;
import net.dshbwlto.createbionics.entity.client.replete.RepleteVariant;
import net.dshbwlto.createbionics.item.BionicsItems;
import net.dshbwlto.createbionics.sound.BionicsSounds;
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
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.neoforge.event.EventHooks;
import org.jetbrains.annotations.Nullable;

public class RepleteEntity extends TamableAnimal {
    private static final EntityDataAccessor<Integer> VARIANT =
            SynchedEntityData.defineId(RepleteEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> FILL =
            SynchedEntityData.defineId(RepleteEntity.class, EntityDataSerializers.INT);
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
                .add(Attributes.MAX_HEALTH, 5D)
                .add(Attributes.MOVEMENT_SPEED, 0.4)
                .add(Attributes.ATTACK_DAMAGE, 2f)
                .add(Attributes.FOLLOW_RANGE, 24D)
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
        if (!this.level().isClientSide && this.isAlive() && --this.fuelTime == 0 && isTame()) {
            this.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
            this.setGlowingTag(true);
            if(!this.isSitting()) {
                this.toggleSitting();
            }
            getOwner().sendSystemMessage(Component.literal(getOwner().getName().getString() + ", §cyour Replete has run out of fuel!§r"));
        }
        if(this.fuelTime == 500 && isTame()) {
            this.setGlowingTag(true);
            getOwner().sendSystemMessage(Component.literal(getOwner().getName().getString() + ", your Replete is running low on fuel! Top it up with coal or charcoal!"));
        }
        if(this.fuelTime == 100 && isTame()) {
            this.setGlowingTag(true);
            getOwner().sendSystemMessage(Component.literal(getOwner().getName().getString() + ", your Replete is running very low on fuel! Top it up with coal or charcoal immediately!"));
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
            this.level().playLocalSound(this.getX() + (double) 0.5F, this.getY() + (double) 0.5F, this.getZ() + (double) 0.5F, BionicsSounds.ENGINE.get(), this.getSoundSource(), 0.01F + this.random.nextFloat(), 1.2F, false);
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
                setGlowingTag(false);
                return InteractionResult.SUCCESS;
            }
        }
        if(item == (Items.WATER_BUCKET) && entityData.get(FILL) < 160){
            if(this.level().isClientSide()) {
                return InteractionResult.CONSUME;
            } else {
                if (!player.getAbilities().instabuild) {
                    itemstack.shrink(1);
                    player.addItem(new ItemStack(Items.BUCKET));
                }
                entityData.set(FILL, lastFill + 1);
                return InteractionResult.SUCCESS;
            }
        }
        if(item == (Items.BUCKET) && entityData.get(FILL) > 0){
            if(this.level().isClientSide()) {
                return InteractionResult.CONSUME;
            } else {
                if (!player.getAbilities().instabuild) {
                    itemstack.shrink(1);
                    player.addItem(new ItemStack(Items.WATER_BUCKET));
                }
                entityData.set(FILL, lastFill - 1);
                return InteractionResult.SUCCESS;
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
        compound.putInt("Fill", this.getFillLevel());
        compound.putInt("RefuelTime", this.fuelTime);

        compound.putBoolean("LegL", leg_l());
        compound.putBoolean("LegR", leg_r());
        compound.putBoolean("Leg2L", leg2_l());
        compound.putBoolean("Leg2R", leg2_r());
        compound.putBoolean("Hat5", leg3_l());
        compound.putBoolean("Leg3L", leg3_r());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        long i = compound.getLong("LastPoseTick");
        if (i < 0L) {
            this.setPose(Pose.SITTING);
        }
        this.resetLastPoseChangeTick(i);
        this.entityData.set(VARIANT, compound.getInt("Variant"));
        this.entityData.set(FILL, compound.getInt("Variant"));
        if (compound.contains("RefuelTime")) {
            this.fuelTime = compound.getInt("RefuelTime");
        }
        this.entityData.set(LEGL, compound.getBoolean("LegL"));
        this.entityData.set(LEGR, compound.getBoolean("LegR"));
        this.entityData.set(LEG2L, compound.getBoolean("Leg2L"));
        this.entityData.set(LEG2R, compound.getBoolean("Leg2R"));
        this.entityData.set(LEG3L, compound.getBoolean("Leg3L"));
        this.entityData.set(LEG3R, compound.getBoolean("Leg3R"));
    }

    //VARIANT//

    private void setTypeVariant(int typeVariant) {
        this.entityData.set(VARIANT, typeVariant);
    }

    private int getTypeVariant() {
        return this.entityData.get(VARIANT);
    }
    public int getFillLevel() {
        return this.entityData.get(FILL);
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

}

