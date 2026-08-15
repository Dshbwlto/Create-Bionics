package net.dshbwlto.createbionics.entity.custom;

import com.simibubi.create.AllItems;
import com.simibubi.create.AllSoundEvents;
import com.simibubi.create.content.logistics.packagerLink.WiFiParticle;
import net.dshbwlto.createbionics.Util.BionicsDataComponentTypes;
import net.dshbwlto.createbionics.entity.api.AbstractRobot;
import net.dshbwlto.createbionics.entity.client.seeker.SeekerPickaxe;
import net.dshbwlto.createbionics.entity.client.seeker.SeekerVariant;
import net.dshbwlto.createbionics.item.BionicsItems;
import net.dshbwlto.createbionics.Util.BionicsTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.EventHooks;
import org.jetbrains.annotations.Nullable;

public class SeekerEntity extends AbstractRobot {

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    private int x = -1;
    private int y;
    private int z = -1;
    private int particleCountdown = -1;
    private int invisCountdown = -1;
    private int digCountdown = -1;
    private int itemDropCountdown = -1;
    private int collapseCountdown = -1;
    public boolean scanning = false;
    public boolean invisible = false;
    public boolean isDigging;
    private BlockPos foundBlock;
    public TagKey<Block> target;
    public AnimationState digAnimationState = new AnimationState();
    public AnimationState returnAnimationState = new AnimationState();
    public AnimationState deployAnimationState = new AnimationState();
    public AnimationState collapseAnimationState = new AnimationState();
    public ItemStack foundItem;
    public Player user;
    public ItemStack displayStack;

    public final AnimationState sitDownAnimationState = new AnimationState();
    public final AnimationState sitPoseAnimationState = new AnimationState();
    public final AnimationState sitUpAnimationState = new AnimationState();

    public static final EntityDataAccessor<Integer> PICK_MAP =
            SynchedEntityData.defineId(SeekerEntity.class, EntityDataSerializers.INT);

    public SeekerEntity(EntityType<? extends AbstractRobot> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        this.lookControl = new SmoothSwimmingLookControl(this, 10);
        this.moveControl = new SmoothSwimmingMoveControl(this, 85, 10, 1, 1, true);
        this.goalSelector.addGoal(0, new FloatGoal(this) {
            @Override
            public boolean canUse() {
                return super.canUse() && isFueled();
            }
        });
        this.goalSelector.addGoal(1, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(4, new FollowOwnerGoal(this, 1.0d, 7f, 3f) {
            @Override
            public boolean canUse() {
                return super.canUse() && isFueled() && getCommand() == 0 && !isDigging;
            }
        });
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D) {
            @Override
            public boolean canUse() {
                return super.canUse() && isTame() && isFueled() && !isDigging;
            }
        });
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 4f) {
            @Override
            public boolean canUse() {
                return super.canUse() && isTame() && isFueled() && !isDigging;
            }
        });
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this) {
            @Override
            public boolean canUse() {
                return super.canUse() && isTame() && isFueled() && !isDigging;
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
    protected @Nullable SoundEvent getDeathSound() {
        return SoundEvents.ITEM_BREAK;
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.ANVIL_PLACE;
    }

    @Override
    public @Nullable ItemStack getPickResult() {
        return seekerItem();
    }

    public void aiStep() {
        if (this.level().isClientSide && isFueled() && digCountdown == -1) {
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

        if (x != -1 && z < 101 && scanning) {
            searchArea(x, y, z);
            x += 5;
            if (x == 100) {
                z += 5;
                x = 0;
            }
        } else if (z > 100) {
            if (scanning) {
                failSearch();
            }
        }

        if (particleCountdown > 0) {
            particleCountdown -= 1;
        } else if (particleCountdown == 0) {
            for (int i = 0; i < 100; i++) {
                spawnSprintParticle();
            }
            particleCountdown = -1;
            digCountdown = getPickaxe() == SeekerPickaxe.IRON ? 500 : getPickaxe() == SeekerPickaxe.DIAMOND ? 300 : 100;
        }

        if (invisCountdown > 0) {
            invisCountdown -= 1;
        } else if (invisCountdown == 0) {
            invisible = true;
            spawnAtLocation(displayStack);
            invisCountdown = -1;
        }

        if (digCountdown > 0) {
            digCountdown -= 1;
        } else if (digCountdown == 0) {
            finishDig();
            digCountdown = -1;
            playSound(AllSoundEvents.CONFIRM.getMainEvent());
        }

        if (itemDropCountdown > 0) {
            itemDropCountdown -= 1;
        } else if (itemDropCountdown == 0) {
            spawnAtLocation(foundItem);
            itemDropCountdown = -1;
        }

        if (collapseCountdown > 0) {
            collapseCountdown -= 1;
        } else if (collapseCountdown == 0) {
            spawnAtLocation(seekerItem());
            remove(RemovalReason.DISCARDED);
        }

        if (this.level().isClientSide()) {
            this.setupAnimationStates();
        }

        if (isFueled() && digCountdown == -1) {
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
        if (itemStack.is(BionicsTags.SEEKER_ACCEPTABLE) && !player.isShiftKeyDown()) {
            if (getFuel() > 2000) {
                playSound(AllSoundEvents.CONFIRM.getMainEvent());
                user = player;
                displayStack = new ItemStack(itemStack.getItem());
                beginSearch(itemStack);
                setFuel(getFuel() - 2000);
                if (!level().isClientSide) {
                    itemStack.shrink(1);
                }
            } else {
                player.displayClientMessage(Component.translatable("entity.createbionics.all.fuel_warning2"), true);
                playSound(AllSoundEvents.DENY.getMainEvent());
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
            } else if (itemStack.is(Items.IRON_PICKAXE) || itemStack.is(Items.DIAMOND_PICKAXE) || itemStack.is(Items.NETHERITE_PICKAXE)) {
                spawnAtLocation(getPickaxeItem());
                setTypePickaxe(itemStack);
                player.playSound(SoundEvents.SMITHING_TABLE_USE);
                if (level().isClientSide) {
                    return InteractionResult.CONSUME;
                }
                return InteractionResult.SUCCESS;
            } else if (itemStack.is(AllItems.WRENCH)) {
                if (player.isShiftKeyDown()) {
                    if (getCommand() == 2) {
                        updateCommand(null);
                    } else if (getCommand() == 1) {
                        updateCommand(null);
                        updateCommand(null);
                    }
                    collapseCountdown = 30;
                    collapseAnimationState.start(tickCount);
                } else {
                    dropIngot();
                    setVariant(SeekerVariant.ANDESITE);
                }
                return InteractionResult.SUCCESS;
            } else if (itemStack.is(AllItems.ANDESITE_ALLOY) && getHealth() < getMaxHealth()) {
                setHealth(getHealth() + 2);
                if (!level().isClientSide) {
                    itemStack.shrink(1);
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
            } else {
                if (!isDigging) {
                    updateCommand(player);
                }
                return InteractionResult.SUCCESS;
            }
        }
        return super.mobInteract(player, hand);
    }

    public ItemStack seekerItem() {
        int i = getFuel() >= 0 ? getFuel() : 24001;
        ItemStack item = new ItemStack(BionicsItems.SEEKER.get());
        item.set(BionicsDataComponentTypes.VARIANT, getTypeVariant());
        item.set(BionicsDataComponentTypes.MISC_INT, getTypePickaxe());
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
        builder.define(PICK_MAP, 0);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Pickaxe", this.getTypePickaxe());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.entityData.set(PICK_MAP, compound.getInt("Pickaxe"));
    }

    //VARIANT//

    private void setTypeVariant(ItemStack itemStack) {
        if (itemStack.is(Items.COPPER_INGOT)
                && getVariant() != SeekerVariant.COPPER) {
            setVariant(SeekerVariant.COPPER);
        } else if (itemStack.is(AllItems.BRASS_INGOT)
                && getVariant() != SeekerVariant.BRASS) {
            setVariant(SeekerVariant.BRASS);
        }
    }

    private void setTypePickaxe(ItemStack itemStack) {
        if (itemStack.is(Items.IRON_PICKAXE)) {
            setPickaxe(SeekerPickaxe.IRON);
            if (!level().isClientSide) {
                itemStack.shrink(1);
            }
        } else if (itemStack.is(Items.DIAMOND_PICKAXE)) {
            setPickaxe(SeekerPickaxe.DIAMOND);
            if (!level().isClientSide) {
                itemStack.shrink(1);
            }
        } else if (itemStack.is(Items.NETHERITE_PICKAXE)) {
            setPickaxe(SeekerPickaxe.NETHERITE);
            if (!level().isClientSide) {
                itemStack.shrink(1);
            }
        }
    }

    public int getTypePickaxe() {
        return this.entityData.get(PICK_MAP);
    }

    public ItemStack getPickaxeItem() {
        Item pickaxe;
        if (getPickaxe() == SeekerPickaxe.IRON) {
            pickaxe = Items.IRON_PICKAXE;
        } else if (getPickaxe() == SeekerPickaxe.DIAMOND) {
            pickaxe = Items.DIAMOND_PICKAXE;
        } else {
            pickaxe = Items.NETHERITE_PICKAXE;
        }
        return new ItemStack(pickaxe);
    }

    public SeekerPickaxe getPickaxe() {
        return SeekerPickaxe.byId(this.getTypePickaxe() & 255);
    }

    public void setPickaxe(SeekerPickaxe marking) {
        this.entityData.set(PICK_MAP, marking.getId() & 255);
    }

    public void setPickaxeNumber(int pickaxe) {
        this.entityData.set(PICK_MAP, pickaxe);
    }

    private void dropIngot() {
        if (getVariant() == SeekerVariant.BRASS) {
            spawnAtLocation(new ItemStack(AllItems.BRASS_INGOT.asItem()));
        } else if (getVariant() == SeekerVariant.COPPER) {
            spawnAtLocation(new ItemStack(Items.COPPER_INGOT.asItem()));
        }
    }

    private int getTypeVariant() {
        return this.entityData.get(VARIANT);
    }

    public SeekerVariant getVariant() {
        return SeekerVariant.byId(this.getTypeVariant() & 255);
    }

    public void setVariant(SeekerVariant variant) {
        this.entityData.set(VARIANT, variant.getId() & 255);
    }

    // SEARCHING

    public void beginSearch(ItemStack itemStack) {
        if (getCommand() == 2) {
            updateCommand(null);
        } else if (getCommand() == 1) {
            updateCommand(null);
            updateCommand(null);
        }
        target = getTag(itemStack);
        scanning = true;
        isDigging = true;
        this.x = 0;
        this.z = 0;
    }

    public void searchSuccess(BlockPos blockPos) {
        foundBlock = blockPos;
        playSound(AllSoundEvents.CONFIRM_2.getMainEvent());
        scanning = false;
        x = -1;
        y = -1;
        digAnimationState.start(tickCount);
        idleAnimationTimeout = 40;
        particleCountdown = 27;
        invisCountdown = 30;
    }

    public void failSearch() {
        foundBlock = null;
        playSound(AllSoundEvents.DENY.getMainEvent());
        level().addParticle(ParticleTypes.ANGRY_VILLAGER, this.getX(), this.getY(), this.getZ(), 0, 0.1, 0);
        scanning = false;
        isDigging = false;
        target = null;
        x = -1;
        y = -1;
    }

    public void searchArea(int x, int y, int z) {
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 6; j++) {
                for (int k = 0; k <= 50; k++) {
                    BlockPos blockPos = this.getOnPos().west(50 - i).north(50 - j).above(25-k).east(x).south(z);
                    if (level().getBlockState(blockPos).is(target)) {
                        searchSuccess(blockPos);
                    }
                }
            }
        }
        if (tickCount % 23 == 0) {
            level().addParticle(new WiFiParticle.Data(), getX(), getY() + 0.25, getZ(), 0, 0, 0);
        }
    }

    public void finishDig() {
        BlockPos blockPos = user.getOnPos().above(1);
        moveTo(blockPos, 0, 0);
        invisible = false;
        isDigging = false;
        foundItem = new ItemStack(level().getBlockState(foundBlock).getBlock());
        level().setBlock(foundBlock, Blocks.GRAVEL.defaultBlockState(), 11);
        returnAnimationState.start(tickCount);
        idleAnimationTimeout = 20;
        itemDropCountdown = 20;
    }

    public TagKey<Block> getTag(ItemStack itemStack) {
        return itemStack.is(BionicsTags.SEEKER_COAL) ? BionicsTags.SEEKER_COAL_ACCEPTABLE :
                itemStack.is(BionicsTags.SEEKER_IRON) ? BionicsTags.SEEKER_IRON_ACCEPTABLE :
                itemStack.is(BionicsTags.SEEKER_COPPER) ? BionicsTags.SEEKER_COPPER_ACCEPTABLE :
                itemStack.is(BionicsTags.SEEKER_GOLD) ? BionicsTags.SEEKER_GOLD_ACCEPTABLE :
                itemStack.is(BionicsTags.SEEKER_EMERALD) ? BionicsTags.SEEKER_EMERALD_ACCEPTABLE :
                itemStack.is(BionicsTags.SEEKER_LAPIS) ? BionicsTags.SEEKER_LAPIS_ACCEPTABLE :
                itemStack.is(BionicsTags.SEEKER_DIAMOND) ? BionicsTags.SEEKER_DIAMOND_ACCEPTABLE :
                itemStack.is(BionicsTags.SEEKER_QUARTZ) ? BionicsTags.SEEKER_QUARTZ_ACCEPTABLE :
                itemStack.is(BionicsTags.SEEKER_REDSTONE) ? BionicsTags.SEEKER_REDSTONE_ACCEPTABLE :
                itemStack.is(BionicsTags.SEEKER_ANCIENT_DEBRIS) ? BionicsTags.SEEKER_ANCIENT_DEBRIS_ACCEPTABLE :
                itemStack.is(BionicsTags.SEEKER_ZINC) ? BionicsTags.SEEKER_ZINC_ACCEPTABLE :
                null;
    }

    @Override
    public boolean isInvisible() {
        return invisible;
    }

    @Override
    public boolean canBeCollidedWith() {
        return scanning;
    }
}