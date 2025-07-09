package net.dshbwlto.createbionics.entity.custom;

import net.dshbwlto.createbionics.Util.BionicsTags;
import net.dshbwlto.createbionics.entity.BionicsEntities;
import net.dshbwlto.createbionics.entity.client.anole.AnoleVariant;
import net.dshbwlto.createbionics.item.BionicsItems;
import net.dshbwlto.createbionics.sound.BionicsSounds;
import net.minecraft.ChatFormatting;
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
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.PlayerModelPart;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.EventHooks;
import org.jetbrains.annotations.Nullable;

public class AnoleEntity extends TamableAnimal {
    private static final EntityDataAccessor<Integer> VARIANT =
            SynchedEntityData.defineId(AnoleEntity.class, EntityDataSerializers.INT);
    public int fuelTime = 501;
    public boolean climbing = false;

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState sitDownAnimationState = new AnimationState();
    public final AnimationState sitPoseAnimationState = new AnimationState();
    public final AnimationState sitUpAnimationState = new AnimationState();

    public static final EntityDataAccessor<Long> LAST_POSE_CHANGE_TICK =
            SynchedEntityData.defineId(AnoleEntity.class, EntityDataSerializers.LONG);

    private static final EntityDataAccessor<ItemStack> DYE_STACK =
            SynchedEntityData.defineId(AnoleEntity.class, EntityDataSerializers.ITEM_STACK);

    private static final EntityDataAccessor<Boolean> HAT1 =
            SynchedEntityData.defineId(AnoleEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> HAT2 =
            SynchedEntityData.defineId(AnoleEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> HAT3 =
            SynchedEntityData.defineId(AnoleEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> HAT4 =
            SynchedEntityData.defineId(AnoleEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> HAT5 =
            SynchedEntityData.defineId(AnoleEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> HAT6 =
            SynchedEntityData.defineId(AnoleEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> HAT7 =
            SynchedEntityData.defineId(AnoleEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> HAT8 =
            SynchedEntityData.defineId(AnoleEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> HAT9 =
            SynchedEntityData.defineId(AnoleEntity.class, EntityDataSerializers.BOOLEAN);

    public AnoleEntity(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));

        this.goalSelector.addGoal(1, new SitWhenOrderedToGoal(this));

        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.2D, Ingredient.of(BionicsItems.COMMAND_WHISTLE.get()), true));

        this.goalSelector.addGoal(4, new FollowOwnerGoal(this, 1.0d, 10f, 5f));

        if(isTame()) {
            this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        }

        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 4f));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
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
    public boolean isFood(ItemStack stack) {
        return stack.is(Items.BARRIER);
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob otherParent) {
        return BionicsEntities.ANOLE.get().create(level);
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
        if (!this.isSitting() && !this.isPassenger()) {
            if (!this.level().isClientSide && this.isAlive() && --this.fuelTime == 0 && isTame()) {
                this.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
                this.setGlowingTag(true);
                if (!this.isSitting()) {
                    this.toggleSitting();
                }
                getOwner().sendSystemMessage(Component.literal(getOwner().getName().getString() + ", §cyour Anole has run out of fuel!§r"));
            }
        }
        if(this.fuelTime == 500 && isTame()) {
            this.setGlowingTag(true);
            getOwner().sendSystemMessage(Component.literal(getOwner().getName().getString() + ", your Anole is running low on fuel! Top it up with coal or charcoal!"));
        }
        if(this.fuelTime == 100 && isTame()) {
            this.setGlowingTag(true);
            getOwner().sendSystemMessage(Component.literal(getOwner().getName().getString() + ", your Anole is running very low on fuel! Top it up with coal or charcoal immediately!"));
        }
        super.aiStep();
    }

    @Override
    public boolean fireImmune() {
        if(getVariant() == AnoleVariant.NETHERITE) {
            return true;
        }
        return super.fireImmune();
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

        if(horizontalCollision) {
            setPose(Pose.SITTING);
            Vec3 initialVec = getDeltaMovement();
            Vec3 climbVec = new Vec3(initialVec.x, 0.2D, initialVec.z);
            setDeltaMovement(climbVec);
            climbing = true;
        } else {
            climbing = false;
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

        if(item == itemForNetherite && isTame() && !(getVariant() == AnoleVariant.NETHERITE || getVariant() == AnoleVariant.BRASS || getVariant() == AnoleVariant.ANDESITE)) {
            if(this.level().isClientSide()) {
                return InteractionResult.CONSUME;
            } else {
                if (!player.getAbilities().instabuild) {
                    itemstack.shrink(1);
                }
                setVariant(AnoleVariant.NETHERITE);
                makeSound(SoundEvents.SMITHING_TABLE_USE);
            }
        }
        if(itemstack.is(BionicsTags.Items.BRASS_INGOT) && isTame() && !(getVariant() == AnoleVariant.NETHERITE || getVariant() == AnoleVariant.BRASS || getVariant() == AnoleVariant.ANDESITE)) {
            if(this.level().isClientSide()) {
                return InteractionResult.CONSUME;
            } else {
                if (!player.getAbilities().instabuild) {
                    itemstack.shrink(1);
                }
                setVariant(AnoleVariant.BRASS);
                makeSound(SoundEvents.SMITHING_TABLE_USE);
            }
        }
        if(itemstack.is(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:andesite_alloy"))) && isTame() && !(getVariant() == AnoleVariant.NETHERITE || getVariant() == AnoleVariant.BRASS || getVariant() == AnoleVariant.ANDESITE)) {
            if(this.level().isClientSide()) {
                return InteractionResult.CONSUME;
            } else {
                if (!player.getAbilities().instabuild) {
                    itemstack.shrink(1);
                }
                setVariant(AnoleVariant.ANDESITE);
                makeSound(SoundEvents.SMITHING_TABLE_USE);
            }
        }
        if(item == Items.WET_SPONGE && getVariant() == AnoleVariant.WEATHERED) {
            if(this.level().isClientSide()) {
                return InteractionResult.CONSUME;
            } else {
                setVariant(AnoleVariant.OXIDIZED);
                makeSound(SoundEvents.WET_SPONGE_STEP);
            }
        }
        if(item == Items.WET_SPONGE && getVariant() == AnoleVariant.EXPOSED) {
            if(this.level().isClientSide()) {
                return InteractionResult.CONSUME;
            } else {
                setVariant(AnoleVariant.WEATHERED);
                makeSound(SoundEvents.WET_SPONGE_STEP);
            }
        }
        if(item == Items.WET_SPONGE && getVariant() == AnoleVariant.DEFAULT) {
            if(this.level().isClientSide()) {
                return InteractionResult.CONSUME;
            } else {
                setVariant(AnoleVariant.EXPOSED);
                makeSound(SoundEvents.WET_SPONGE_STEP);
            }
        }
        if(item == Items.SPONGE && (getVariant() == AnoleVariant.EXPOSED || getVariant() == AnoleVariant.WEATHERED || getVariant() == AnoleVariant.OXIDIZED)) {
            if(this.level().isClientSide()) {
                return InteractionResult.CONSUME;
            } else {
                setVariant(AnoleVariant.DEFAULT);
                makeSound(SoundEvents.WET_SPONGE_STEP);
            }
        }
        if(itemstack.is(BionicsTags.Items.WRENCH) && isTame() && getVariant() == AnoleVariant.NETHERITE && !player.isShiftKeyDown()) {
            if(this.level().isClientSide()) {
                return InteractionResult.SUCCESS;
            } else {
                this.spawnAtLocation(new ItemStack(Items.NETHERITE_INGOT));
                setVariant(AnoleVariant.DEFAULT);
                makeSound(SoundEvents.GRINDSTONE_USE);
            }
        }
        if(itemstack.is(BionicsTags.Items.WRENCH) && isTame() && getVariant() == AnoleVariant.BRASS && !player.isShiftKeyDown()) {
            if(this.level().isClientSide()) {
                return InteractionResult.SUCCESS;
            } else {
                this.spawnAtLocation(new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:brass_ingot"))));
                setVariant(AnoleVariant.DEFAULT);
                makeSound(SoundEvents.GRINDSTONE_USE);
            }
        }
        if(itemstack.is(BionicsTags.Items.WRENCH) && isTame() && getVariant() == AnoleVariant.ANDESITE && !player.isShiftKeyDown()) {
            if(this.level().isClientSide()) {
                return InteractionResult.SUCCESS;
            } else {
                this.spawnAtLocation(new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:andesite_alloy"))));
                setVariant(AnoleVariant.DEFAULT);
                makeSound(SoundEvents.GRINDSTONE_USE);
            }
        }
        if(itemstack.is(BionicsTags.Items.WRENCH) && isOwnedBy(player) && player.isShiftKeyDown()){
            if(this.level().isClientSide()) {
                return InteractionResult.SUCCESS;
            } else {
                this.spawnAtLocation(new ItemStack(BionicsItems.ANOLE.get()));
                if (getVariant() == AnoleVariant.NETHERITE) {
                    this.spawnAtLocation(new ItemStack(Items.NETHERITE_INGOT));
                }
                if (getVariant() == AnoleVariant.BRASS) {
                    this.spawnAtLocation(new ItemStack(Items.GOLD_INGOT));
                }
                if (isSilent()) {
                    this.spawnAtLocation(new ItemStack(BionicsItems.SILENT_PISTON.get()));
                }
                remove(RemovalReason.DISCARDED);
                makeSound(SoundEvents.ITEM_PICKUP);
            }
        }
        if((item == Items.COAL || item == Items.CHARCOAL) && isOwnedBy(player)){
            if(this.level().isClientSide()) {
                return InteractionResult.CONSUME;
            } else {
                if (!player.getAbilities().instabuild) {
                    itemstack.shrink(1);
                }
                this.fuelTime = 100000;
                makeSound(SoundEvents.FIRECHARGE_USE);
                setGlowingTag(false);
                this.toggleSitting();
                this.level().addParticle(ParticleTypes.POOF, this.getRandomX((double) 0.5F), this.getRandomY(), this.getRandomZ((double) 0.5F), (double) 0.0F, (double) 0.0F, (double) 0.0F);
                return InteractionResult.SUCCESS;
            }
        }
        if(item == Items.COAL_BLOCK && isOwnedBy(player)){
            if(this.level().isClientSide()) {
                return InteractionResult.CONSUME;
            } else {
                if (!player.getAbilities().instabuild) {
                    itemstack.shrink(1);
                }
                this.fuelTime = 900000;
                makeSound(SoundEvents.FIRECHARGE_USE);
                makeSound(SoundEvents.FURNACE_FIRE_CRACKLE);
                setGlowingTag(false);
                return InteractionResult.SUCCESS;
            }
        }
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
        if (!isTame() && getMainHandItem().isEmpty()) {
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

       if (isTame() && !isShiftKeyDown() && !isCurrentlyGlowing() && player.getMainHandItem().isEmpty() && !this.isPassenger()) {
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
        builder.define(DYE_STACK, ItemStack.EMPTY);

        builder.define(HAT1, true);
        builder.define(HAT2, false);
        builder.define(HAT3, false);
        builder.define(HAT4, false);
        builder.define(HAT5, false);
        builder.define(HAT6, false);
        builder.define(HAT7, false);
        builder.define(HAT8, false);
        builder.define(HAT9, false);
    }


    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putLong("LastPoseTick", this.entityData.get(LAST_POSE_CHANGE_TICK));
        compound.putInt("Variant", this.getTypeVariant());
        compound.putInt("RefuelTime", this.fuelTime);

        compound.putBoolean("Hat1", hat1());
        compound.putBoolean("Hat2", hat2());
        compound.putBoolean("Hat3", hat3());
        compound.putBoolean("Hat4", hat4());
        compound.putBoolean("Hat5", hat5());
        compound.putBoolean("Hat6", hat6());
        compound.putBoolean("Hat7", hat7());
        compound.putBoolean("Hat8", hat8());
        compound.putBoolean("Hat9", hat9());
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
        if (compound.contains("RefuelTime")) {
            this.fuelTime = compound.getInt("RefuelTime");
        }
        this.entityData.set(HAT1, compound.getBoolean("Hat1"));
        this.entityData.set(HAT2, compound.getBoolean("Hat2"));
        this.entityData.set(HAT3, compound.getBoolean("Hat3"));
        this.entityData.set(HAT4, compound.getBoolean("Hat4"));
        this.entityData.set(HAT5, compound.getBoolean("Hat5"));
        this.entityData.set(HAT6, compound.getBoolean("Hat6"));
        this.entityData.set(HAT7, compound.getBoolean("Hat7"));
        this.entityData.set(HAT8, compound.getBoolean("Hat8"));
        this.entityData.set(HAT9, compound.getBoolean("Hat9"));
    }

    //VARIANT//

    private void setTypeVariant(int typeVariant) {
        this.entityData.set(VARIANT, typeVariant);
    }

    private int getTypeVariant() {
        return this.entityData.get(VARIANT);
    }

    public AnoleVariant getVariant() {
        return AnoleVariant.byId(this.getTypeVariant() & 255);
    }

    public void setVariant(AnoleVariant variant) {
        this.entityData.set(VARIANT, variant.getId() & 255);
    }
    public boolean hat1() {
        String s = ChatFormatting.stripFormatting(this.getName().getString());
        return ("Distinguished Gentleman".equals(s) || "Bill".equals(s));
    }
    public boolean hat2() {
        String s = ChatFormatting.stripFormatting(this.getName().getString());
        return "Timmy".equals(s);
    }
    public boolean hat3() {
        String s = ChatFormatting.stripFormatting(this.getName().getString());
        return "Unicorn".equals(s);
    }
    public boolean hat4() {
        String s = ChatFormatting.stripFormatting(this.getName().getString());
        return ("Legend".equals(s) || "Techno".equals(s) || "Alex".equals(s));
    }
    public boolean hat5() {
        String s = ChatFormatting.stripFormatting(this.getName().getString());
        return "Stampy".equals(s);
    }
    public boolean hat6() {
        String s = ChatFormatting.stripFormatting(this.getName().getString());
        return ("Doug".equals(s) || "Dimmadome".equals(s) || "Mayor".equals(s));
    }
    public boolean hat7() {
        String s = ChatFormatting.stripFormatting(this.getName().getString());
        return "Cat in the Hat".equals(s);
    }
    public boolean hat8() {
        String s = ChatFormatting.stripFormatting(this.getName().getString());
        return "Sherlock".equals(s);
    }
    public boolean hat9() {
        String s = ChatFormatting.stripFormatting(this.getName().getString());
        return "Scallywag".equals(s);
    }
}

