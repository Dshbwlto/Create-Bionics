package net.dshbwlto.createbionics.entity.custom;

import com.simibubi.create.AllItems;
import com.simibubi.create.AllSoundEvents;
import net.dshbwlto.createbionics.Util.BionicsDataComponentTypes;
import net.dshbwlto.createbionics.entity.api.AbstractRobot;
import net.dshbwlto.createbionics.entity.client.anole.AnoleMarkings;
import net.dshbwlto.createbionics.entity.client.anole.AnoleVariant;
import net.dshbwlto.createbionics.item.BionicsItems;
import net.minecraft.ChatFormatting;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
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
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.entity.monster.CaveSpider;
import net.minecraft.world.entity.monster.Silverfish;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.EventHooks;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import org.jetbrains.annotations.Nullable;

@EventBusSubscriber
public class AnoleEntity extends AbstractRobot {
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState sitDownAnimationState = new AnimationState();
    public final AnimationState sitPoseAnimationState = new AnimationState();
    public final AnimationState sitUpAnimationState = new AnimationState();

    public static final EntityDataAccessor<Integer> MARKING_MAP =
            SynchedEntityData.defineId(AnoleEntity.class, EntityDataSerializers.INT);

    public AnoleEntity(EntityType<? extends AbstractRobot> entityType, Level level) {
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

    @SubscribeEvent
    public static void scareEntity(EntityJoinLevelEvent event) {
        if (event.getEntity() instanceof Spider spider) {
            spider.goalSelector.addGoal(1, new AvoidEntityGoal(spider, AnoleEntity.class, 6.0F, (double)1.0F, 1.2));
        }
        if (event.getEntity() instanceof CaveSpider caveSpider) {
            caveSpider.goalSelector.addGoal(1, new AvoidEntityGoal(caveSpider, AnoleEntity.class, 6.0F, (double)1.0F, 1.2));
        }
        if (event.getEntity() instanceof Silverfish silverfish) {
            silverfish.goalSelector.addGoal(1, new AvoidEntityGoal(silverfish, AnoleEntity.class, 6.0F, (double)1.0F, 1.2));
        }
        if (event.getEntity() instanceof Bee bee) {
            bee.goalSelector.addGoal(1, new AvoidEntityGoal(bee, AnoleEntity.class, 6.0F, (double)1.0F, 1.2));;
        }
    }

    protected PathNavigation createNavigation(Level level) {
        return new WallClimberNavigation(this, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 10D)
                .add(Attributes.FALL_DAMAGE_MULTIPLIER, 0)
                .add(Attributes.MOVEMENT_SPEED, 0.4)
                .add(Attributes.ATTACK_DAMAGE, 2f)
                .add(Attributes.FOLLOW_RANGE, 24D)
                .add(Attributes.WATER_MOVEMENT_EFFICIENCY, 200f);
    }

    @Override
    protected void dropCustomDeathLoot(ServerLevel level, DamageSource damageSource, boolean recentlyHit) {
        super.dropCustomDeathLoot(level, damageSource, recentlyHit);
        if (getVariant() != AnoleVariant.COPPER) {
            dropIngot(getVariant());
        }
        if (getMarkings() != AnoleMarkings.DEFAULT) {
            dropMaterial(getMarkings());
        }
    }

    @Override
    public @Nullable ItemStack getPickResult() {
        return anoleItem();
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
    public Item healItem() {
        return Items.COPPER_INGOT;
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

        if (isFueled()) {
            playSoundScape(1, 1);
        }

        if (!isSitting() && !isPassenger() && getFuel() > 0) {
            setFuel(getFuel() - 1);
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

        if (isTame() && isOwnedBy(player)) {
            if (itemStack.is(healItem()) && player.isShiftKeyDown() && getHealth() < getMaxHealth()) {
                setHealth(getHealth() + 2);
                if (!level().isClientSide && !player.getAbilities().instabuild) {
                    itemStack.shrink(1);
                }
                return InteractionResult.SUCCESS;
            } else if (itemStack.is(AllItems.ANDESITE_ALLOY)
                    || itemStack.is(AllItems.BRASS_INGOT)
                    || itemStack.is(Items.NETHERITE_INGOT)) {
                dropIngot(getVariant());
                setTypeVariant(itemStack);
                if (level().isClientSide) {
                    return InteractionResult.CONSUME;
                } else {
                    itemStack.shrink(1);
                }
                return InteractionResult.SUCCESS;
            } else if (itemStack.is(Items.SPONGE) || itemStack.is(Items.WET_SPONGE)) {
                setTypeVariant(itemStack);
                return InteractionResult.SUCCESS;
            } else if (itemStack.is(Items.REDSTONE)
                    || itemStack.is(Items.GOLD_INGOT)
                    || itemStack.is(Items.DIAMOND)
                    || itemStack.is(Items.BRUSH)) {
                dropMaterial(getMarkings());
                setTypeMarking(itemStack);
                if (!itemStack.is(Items.BRUSH)) {
                    itemStack.shrink(1);
                }
                return InteractionResult.CONSUME;
            } else if (itemStack.is(AllItems.WRENCH)) {
                if (player.isShiftKeyDown()) {
                    spawnAtLocation(anoleItem());
                    remove(RemovalReason.DISCARDED);
                    return InteractionResult.SUCCESS;
                } else {
                    dropIngot(getVariant());
                    dropMaterial(getMarkings());
                    setVariant(AnoleVariant.COPPER);
                    setMarking(AnoleMarkings.DEFAULT);
                    return InteractionResult.SUCCESS;
                }
            } else if (itemStack.is(Items.COAL) || itemStack.is(Items.CHARCOAL)) {
                setFuel(12000);
                if (!player.getAbilities().instabuild) {
                    itemStack.shrink(1);
                }
                playSound(AllSoundEvents.BLAZE_MUNCH.getMainEvent());
                spawnFireParticles(false, 1);
                return InteractionResult.CONSUME;
            } else if (itemStack.is(AllItems.BLAZE_CAKE)) {
                setFuel(24000);
                if (!player.getAbilities().instabuild) {
                    itemStack.shrink(1);
                }
                playSound(AllSoundEvents.BLAZE_MUNCH.getMainEvent());
                spawnFireParticles(true, 1);
                return InteractionResult.CONSUME;
            } else if (itemStack.is(AllItems.CREATIVE_BLAZE_CAKE)) {
                setFuel(getFuel() == -1 ? 24000 : -1);
                playSound(AllSoundEvents.BLAZE_MUNCH.getMainEvent());
                spawnFireParticles(true, 3);
                return InteractionResult.SUCCESS;
            } else {
                updateCommand(player);
                return InteractionResult.SUCCESS;
            }
        }

        return super.mobInteract(player, hand);
    }

    public ItemStack anoleItem() {
        int i = getFuel() >= 0 ? getFuel() : 24001;
        ItemStack item = new ItemStack(BionicsItems.ANOLE.get());
        item.set(BionicsDataComponentTypes.VARIANT, getTypeVariant());
        item.set(BionicsDataComponentTypes.MISC_INT, getTypeMarkings());
        item.set(BionicsDataComponentTypes.FUEL, i);
        if (hasCustomName()) {
            item.set(BionicsDataComponentTypes.NAME, getDisplayName().getString());
        }
        return item;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(MARKING_MAP, 0);

    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Marking", this.getTypeMarkings());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.entityData.set(MARKING_MAP, compound.getInt("Marking"));
    }

    //VARIANT//

    private void setTypeVariant(ItemStack itemStack) {
        if (itemStack.getItem() == Items.COPPER_INGOT &&
                getVariant() != AnoleVariant.COPPER &&
                getVariant() != AnoleVariant.EXPOSED &&
                getVariant() != AnoleVariant.WEATHERED &&
                getVariant() != AnoleVariant.OXIDIZED) {
            setVariant(AnoleVariant.COPPER);
        } else if (itemStack.is(AllItems.ANDESITE_ALLOY)
                && getVariant() != AnoleVariant.ANDESITE) {
            setVariant(AnoleVariant.ANDESITE);
        } else if (itemStack.is(AllItems.BRASS_INGOT)
                && getVariant() != AnoleVariant.BRASS) {
            setVariant(AnoleVariant.BRASS);
        } else if (itemStack.is(Items.NETHERITE_INGOT)
                && getVariant() != AnoleVariant.NETHERITE) {
            setVariant(AnoleVariant.NETHERITE);
        } else if (itemStack.is(Items.WET_SPONGE)) {
            if (getVariant() == AnoleVariant.COPPER) {
                setVariant(AnoleVariant.EXPOSED);
            } else if (getVariant() == AnoleVariant.EXPOSED) {
                setVariant(AnoleVariant.WEATHERED);
            } else if (getVariant() == AnoleVariant.WEATHERED) {
                setVariant(AnoleVariant.OXIDIZED);
            }
        } else if (itemStack.is(Items.SPONGE) && (getVariant() == AnoleVariant.EXPOSED
                || getVariant() == AnoleVariant.WEATHERED
                || getVariant() == AnoleVariant.OXIDIZED)) {
            setVariant(AnoleVariant.COPPER);
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

    public void setMarkingNumber(int marking) {
        entityData.set(MARKING_MAP, marking);
    }

    private void dropIngot(AnoleVariant variant) {
        if (getVariant() == AnoleVariant.BRASS) {
            spawnAtLocation(new ItemStack(AllItems.BRASS_INGOT.asItem()));
        } else if (getVariant() == AnoleVariant.ANDESITE) {
            spawnAtLocation(new ItemStack(AllItems.ANDESITE_ALLOY.asItem()));
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

    //Hats//

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