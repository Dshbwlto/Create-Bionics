package net.dshbwlto.createbionics.entity.custom;

import net.dshbwlto.createbionics.entity.BionicsEntities;
import net.dshbwlto.createbionics.entity.client.anole.AnoleMarkings;
import net.dshbwlto.createbionics.entity.client.anole.AnoleVariant;
import net.dshbwlto.createbionics.item.BionicsItems;
import net.dshbwlto.createbionics.sound.BionicsSounds;
import net.minecraft.ChatFormatting;
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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.EventHooks;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class AnoleEntity extends AbstractRobot {
    public int getFuel() {
        return entityData.get(FUEL_TIME);
    }
    private void setFuel(int fuel) {
        entityData.set(FUEL_TIME, fuel);
    }
    public boolean climbing = false;

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState sitDownAnimationState = new AnimationState();
    public final AnimationState sitPoseAnimationState = new AnimationState();
    public final AnimationState sitUpAnimationState = new AnimationState();

    public static final EntityDataAccessor<Integer> MARKING_MAP =
            SynchedEntityData.defineId(AnoleEntity.class, EntityDataSerializers.INT);

    public static final EntityDataAccessor<Integer> FUEL_TIME =
            SynchedEntityData.defineId(AnoleEntity.class, EntityDataSerializers.INT);

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

    public AnoleEntity(EntityType<? extends AbstractRobot> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));

        this.goalSelector.addGoal(1, new SitWhenOrderedToGoal(this));

        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));

        this.goalSelector.addGoal(4, new FollowOwnerGoal(this, 1.0d, 10f, 5f));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));

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

        if(this.getFuel() == 500 && isTame()) {
            this.setGlowingTag(true);
            Objects.requireNonNull(getOwner()).sendSystemMessage(Component.literal(getOwner().getName().getString() + ", your Anole is running low on fuel! Top it up with coal or charcoal!"));
        }
        if(this.getFuel() == 100 && isTame()) {
            this.setGlowingTag(true);
            Objects.requireNonNull(getOwner()).sendSystemMessage(Component.literal(getOwner().getName().getString() + ", your Anole is running very low on fuel! Top it up with coal or charcoal immediately!"));
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

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide()) {
            this.setupAnimationStates();
        }
        if(tickCount % 50 == 0 && !isCurrentlyGlowing() && !isSilent()) {
            this.level().playLocalSound(this.getX() + (double) 0.5F, this.getY() + (double) 0.5F, this.getZ() + (double) 0.5F, BionicsSounds.ENGINE_IDLE.get(), this.getSoundSource(), 0.1F, 1.2F, false);
        }
        if(this.horizontalCollision) {
            Vec3 initialVec = this.getDeltaMovement();
            Vec3 climbVec = new Vec3(initialVec.x, 0.2D, initialVec.z);
            this.setDeltaMovement(climbVec.scale(0.96D));
        }

    }

    @Override
    protected void dropCustomDeathLoot(ServerLevel level, DamageSource damageSource, boolean recentlyHit) {

        super.dropCustomDeathLoot(level, damageSource, recentlyHit);
    }

    /* RIGHT CLICKING */
    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (!isTame() && getMainHandItem().isEmpty()) {
            if (this.level().isClientSide()) {
                return InteractionResult.SUCCESS;
            } else {
                if (!EventHooks.onAnimalTame(this, player)) {
                    super.tame(player);
                    this.navigation.recomputePath();
                    this.setTarget(null);
                    this.level().broadcastEntityEvent(this, (byte) 7);
                    this.setFuel(510);
                }
                return InteractionResult.SUCCESS;
            }
        }

       if (isTame() && isOwnedBy(player)) {
            if (itemStack.is(Items.COPPER_INGOT)
                   || itemStack.is(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:andesite_alloy")))
                   || itemStack.is(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:brass_ingot")))
                   || itemStack.is(Items.NETHERITE_INGOT)
                   || itemStack.is(Items.SPONGE)
                   || itemStack.is(Items.WET_SPONGE)) {
               if (!itemStack.is(Items.SPONGE) && !itemStack.is(Items.WET_SPONGE)) {
                   dropIngot(getVariant());
               }
               setTypeVariant(itemStack);
               if (level().isClientSide) {
                   return InteractionResult.SUCCESS;
               } else if (!itemStack.is(Items.SPONGE) && !itemStack.is(Items.WET_SPONGE)){
                   itemStack.shrink(1);
               }
           } else if (itemStack.is(Items.REDSTONE)
                   || itemStack.is(Items.GOLD_INGOT)
                   || itemStack.is(Items.DIAMOND)
                   || itemStack.is(Items.BRUSH)) {
               dropMaterial(getMarkings());
               setTypeMarking(itemStack);
               if (!itemStack.is(Items.BRUSH)) {
                   itemStack.shrink(1);
               }
           } else if (itemStack.is(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create_wrench")))) {
                dropIngot(getVariant());
                dropMaterial(getMarkings());
                spawnAtLocation(BionicsItems.ANOLE);
           } else {
               updateCommand(player);
               return InteractionResult.SUCCESS;
           }
       }

       return super.mobInteract(player, hand);
    }
    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(MARKING_MAP, 0);
        builder.define(FUEL_TIME, 0);

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
        compound.putInt("Marking", this.getTypeMarkings());
        compound.putInt("RefuelTime", this.getFuel());

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
        this.entityData.set(MARKING_MAP, compound.getInt("Marking"));
        this.entityData.set(FUEL_TIME, compound.getInt("RefuelTime"));

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

    private void setTypeVariant(ItemStack itemStack) {
        if (itemStack.getItem() == Items.COPPER_INGOT &&
                getVariant() != AnoleVariant.COPPPER &&
                getVariant() != AnoleVariant.EXPOSED &&
                getVariant() != AnoleVariant.WEATHERED &&
                getVariant() != AnoleVariant.OXIDIZED) {
            setVariant(AnoleVariant.COPPPER);
        } else if (itemStack.is(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:andesite_alloy")))
                && getVariant() != AnoleVariant.ANDESITE) {
            setVariant(AnoleVariant.ANDESITE);
        } else if (itemStack.is(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:brass_ingot")))
                && getVariant() != AnoleVariant.BRASS) {
            setVariant(AnoleVariant.BRASS);
        } else if (itemStack.is(Items.NETHERITE_INGOT)
                && getVariant() != AnoleVariant.NETHERITE) {
            setVariant(AnoleVariant.NETHERITE);
        } else if (itemStack.is(Items.WET_SPONGE)) {
            if (getVariant() == AnoleVariant.COPPPER) {
                setVariant(AnoleVariant.EXPOSED);
            } else if (getVariant() == AnoleVariant.EXPOSED) {
                setVariant(AnoleVariant.WEATHERED);
            } else if (getVariant() == AnoleVariant.WEATHERED) {
                setVariant(AnoleVariant.OXIDIZED);
            }
        } else if (itemStack.is(Items.SPONGE) && (getVariant() == AnoleVariant.EXPOSED
                || getVariant() == AnoleVariant.WEATHERED
                || getVariant() == AnoleVariant.OXIDIZED)) {
            setVariant(AnoleVariant.COPPPER);
        }
    }

    private void setTypeMarking(ItemStack itemStack) {
        if (itemStack.is(Items.REDSTONE)
                && getMarkings() != AnoleMarkings.REDSTONE) {
            setMarking(AnoleMarkings.REDSTONE);
        } else if (itemStack.is(Items.GOLD_INGOT) && getMarkings() != AnoleMarkings.GOLD) {
            setMarking(AnoleMarkings.GOLD);
        } else if (itemStack.is(Items.DIAMOND) && getMarkings() != AnoleMarkings.DIAMOND) {
            setMarking(AnoleMarkings.DIAMOND);
        } else if (itemStack.is(Items.BRUSH) && getMarkings() != AnoleMarkings.DEFAULT) {
            setMarking(AnoleMarkings.DEFAULT);
        }
    }

    private void dropIngot(AnoleVariant variant) {
        if (getVariant() == AnoleVariant.BRASS) {
            spawnAtLocation(new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:brass_ingot"))));
        } else if (getVariant() == AnoleVariant.COPPPER
                || getVariant() == AnoleVariant.EXPOSED
                || getVariant() == AnoleVariant.WEATHERED
                || getVariant() == AnoleVariant.OXIDIZED) {
            spawnAtLocation(new ItemStack(Items.COPPER_INGOT));
        } else if (getVariant() == AnoleVariant.ANDESITE) {
            spawnAtLocation(new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:andesite_alloy"))));
        } else if (getVariant() == AnoleVariant.NETHERITE) {
            spawnAtLocation(new ItemStack(Items.NETHERITE_INGOT));
        }
    }

    private void dropMaterial(AnoleMarkings markings) {
        if (getMarkings() == AnoleMarkings.GOLD) {
            spawnAtLocation(new ItemStack(Items.GOLD_INGOT));
        } else if (getMarkings() == AnoleMarkings.REDSTONE) {
            spawnAtLocation(new ItemStack(Items.REDSTONE));
        } else if (getMarkings() == AnoleMarkings.DIAMOND) {
            spawnAtLocation(new ItemStack(Items.DIAMOND));
        }
    }

    private int getTypeVariant() {
        return this.entityData.get(VARIANT);
    }

    public int getTypeMarkings() {
        return this.entityData.get(MARKING_MAP);
    }

    public AnoleVariant getVariant() {
        return AnoleVariant.byId(this.getTypeVariant() & 255);
    }

    public AnoleMarkings getMarkings() {
        return AnoleMarkings.byId(this.getTypeMarkings() & 255);
    }

    public void setVariant(AnoleVariant variant) {
        this.entityData.set(VARIANT, variant.getId() & 255);
    }
    public void setMarking(AnoleMarkings marking) {
        this.entityData.set(MARKING_MAP, marking.getId() & 255);
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

