
package net.dshbwlto.createbionics.entity.custom;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import net.createmod.catnip.animation.AnimationTickHolder;
import net.dshbwlto.createbionics.entity.api.AbstractRobot;
import net.dshbwlto.createbionics.entity.api.MultiPartEntity;
import net.dshbwlto.createbionics.entity.api.MultiPartRobot;
import net.dshbwlto.createbionics.entity.client.organ.layers.OrganGlow;
import net.dshbwlto.createbionics.entity.client.organ.layers.OrganVariant;
import net.dshbwlto.createbionics.item.BionicsItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.event.EventHooks;
import net.neoforged.neoforge.fluids.FluidType;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class OrganEntity extends MultiPartRobot<MultiPartEntity<OrganEntity>> {
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    private boolean isInIdlePose() {
        return idlePoseTimeout > 0;
    }
    private int idlePoseTimeout = 0;
    public float x0;
    public float y0;
    public float z0;
    public final AnimationState sitDownAnimationState = new AnimationState();
    public final AnimationState sitPoseAnimationState = new AnimationState();
    public final AnimationState sitUpAnimationState = new AnimationState();

    public MultiPartEntity<OrganEntity> leftArm;
    public MultiPartEntity<OrganEntity> rightArm;

    public final AnimationState lookAnimationState = new AnimationState();
    public final AnimationState shakeAnimationState = new AnimationState();
    public final AnimationState yawnAnimationState = new AnimationState();

    public static final EntityDataAccessor<Integer> GLOW_COLOR =
            SynchedEntityData.defineId(OrganEntity.class, EntityDataSerializers.INT);

    public OrganEntity(EntityType<MultiPartRobot<?>> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected MultiPartEntity<OrganEntity>[] createParts() {
        this.leftArm = new MultiPartEntity<>(this, 0.8f, 2.1f, 1.2f, 0.4f, 0f);
        this.rightArm = new MultiPartEntity<>(this, 0.8f, 2.1f, -1.2f, 0.4f, 0f);
        return new MultiPartEntity[]{this.leftArm, this.rightArm};
    }

    @Override
    public boolean hurtPart(MultiPartEntity<OrganEntity> part, DamageSource source, float damage) {
        if (part == rightArm) return hurt(source, 100000f);
        return super.hurtPart(part, source, damage);
    }

    public int blinkCountdown = 0;

    @Override
    public boolean canDrownInFluidType(FluidType type) {
        return false;
    }

    @Override
    public void registerGoals() {
        this.goalSelector.addGoal(0, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(3, new FollowOwnerGoal(this, 1d, 15, 10) {
            @Override
            public boolean canUse() {
                return super.canUse() && getCommand() == 0;
            }
        });
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D, 20) {
            @Override
            public boolean canUse() {
                return super.canUse() && getAssembly() >= 20 && isTame();
            }
        });
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
    }

    @Override
    public boolean shouldTryTeleportToOwner() {
        return distanceTo(Objects.requireNonNull(getOwner())) > 40;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 100d)
                .add(Attributes.MOVEMENT_SPEED, 0.25d)
                .add(Attributes.FOLLOW_RANGE, 30)
                .add(Attributes.KNOCKBACK_RESISTANCE, 100d)
                .add(Attributes.ATTACK_DAMAGE, 30)
                .add(Attributes.ENTITY_INTERACTION_RANGE, 40);
    }

    @Override
    public boolean isFood(ItemStack itemStack) {
        return false;
    }

    @Override
    @Nullable
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob otherParent) {
        return null;
    }

    /* ANIMATIONS */

    private void setUpAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 78;
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
        if (random.nextFloat() < 0.005 && getCommand() == 2 && !isInIdlePose()) {
            if (tickCount % 3 == 0) {
                this.shakeAnimationState.start(this.tickCount);
                idlePoseTimeout = 220;
            } else if (tickCount % 3 == 1) {
                this.lookAnimationState.start(this.tickCount);
                idlePoseTimeout = 220;
            } else {
                this.yawnAnimationState.start(this.tickCount);
                idlePoseTimeout = 220;
                blinkCountdown = 90;
            }
        }
    }

    @Override
    public void tick() {
        super.tick();

        resetPartOffsets();

        idlePoseTimeout = idlePoseTimeout - 1;

        if (this.level().isClientSide()) {
            this.setUpAnimationStates();
        }

        playSoundScape(5, 5);

        /* BLINKING */
        if (Math.random() < 0.01f) {
            blinkCountdown = blinkCountdown + 6;
        }
        if (blinkCountdown > 0) {
            blinkCountdown = blinkCountdown - 1;
        }

        /* STEAM EFFECTS */

        if (exhaustProgress > 0) {
            if (exhaustProgress < 21) {
                exhaustProgress = exhaustProgress + 1;
            } else {
                exhaustProgress = 0;
            }
        } else {
            if (random.nextFloat() < 0.001) {
                exhaustProgress = 1;
            }
        }

        /* exhaust */

        /* easter egg*/
        if (canDebugSwapSkins() && AnimationTickHolder.getTicks() % 30 == 0) {
            if (getTypeVariant() < 3) {
                entityData.set(VARIANT, getTypeVariant() + 1);
            } else {
                entityData.set(VARIANT, 0);
            }
        }
    }

    //test

    @Override
    public void aiStep() {
        super.aiStep();
    }

    /* SAVE DATA */

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        ///   Not yet, hotshot
        builder.define(GLOW_COLOR, 0);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Glow_Color", this.entityData.get(GLOW_COLOR));
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        entityData.set(GLOW_COLOR, compound.getInt("Glow_Color"));
    }

    /* INTERACT */

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        /* TAME */
        if (!isTame()) {
            if (getAssembly() > 20) {
                if (this.level().isClientSide()) {
                    return InteractionResult.CONSUME;
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
            super.mobInteract(player, hand);
        }
        if ((itemStack.is(Items.COPPER_INGOT)
                || itemStack.is(AllItems.ANDESITE_ALLOY)
                || itemStack.is(AllItems.BRASS_INGOT)
                || itemStack.is(AllItems.STURDY_SHEET))
                && isOwnedBy(player)) {
            dropIngot();
            setTypeVariant(itemStack);
            if (level().isClientSide) {
                return InteractionResult.SUCCESS;
            } else {
                itemStack.shrink(1);
            }
        } else if (itemStack.is(Items.REDSTONE) || itemStack.is(Items.REDSTONE_BLOCK) || itemStack.is(Items.BRUSH)) {
            dropRedstone(getGlow());
            setTypeGlow(itemStack);
            if (level().isClientSide) {
                return InteractionResult.SUCCESS;
            } else if (!itemStack.is(Items.BRUSH)) {
                itemStack.shrink(1);
            }

        } else if ((itemStack.is(BionicsItems.ROBOT_BUILDER) || (itemStack.is(getPart()))) && getAssembly() < 105) {
            setAssembly(getAssembly() + 1);
            if (!itemStack.is(BionicsItems.ROBOT_BUILDER.get())) {
                itemStack.shrink(1);
            }
            if (getAssembly() <= 21) {
                playSound(SoundEvents.NETHERITE_BLOCK_PLACE);
            } else {
                playSound(SoundEvents.NETHERITE_BLOCK_PLACE, 1, (float) getAssembly() / 50);
            }
            player.displayClientMessage(Component.translatable("entity.createbionics.all.assembly", getPart().getDescription().getString()), true);
            return InteractionResult.SUCCESS;

        } else if (itemStack.is(AllBlocks.RAILWAY_CASING.asItem())) {
            itemStack.shrink(1);
            heal(50);
            playSound(SoundEvents.SMITHING_TABLE_USE);
            return InteractionResult.CONSUME;
        } else if (itemStack.is(AllItems.WRENCH) && (isOwnedBy(player) || getAssembly() < 21)) {
            if (getAssembly() > 0) {
                setAssembly(getAssembly() - 1);
                spawnAtLocation(new ItemStack(getPart()));
                if (getAssembly() <= 21) {
                    playSound(SoundEvents.NETHERITE_BLOCK_PLACE);
                } else {
                    playSound(SoundEvents.NETHERITE_BLOCK_PLACE, 1, (float) getAssembly() / 50);
                }
            } else {
                spawnAtLocation(new ItemStack(BionicsItems.ORGAN_MIDDLE.get()));
                remove(RemovalReason.DISCARDED);
            }
            return InteractionResult.SUCCESS;

        } else {
            if (getAssembly() >= 20 && isOwnedBy(player)) {
                if (!isInPoseTransition()) {
                    updateCommand(player);
                }
            }
            return InteractionResult.SUCCESS;
        }
        return super.mobInteract(player, hand);
    }

    /* VARIANTS */

    private void setGlowColor(int typeColor) {
        this.entityData.set(GLOW_COLOR, typeColor);
    }
    private void setTypeVariant(ItemStack itemStack) {
        if (itemStack.getItem() == Items.COPPER_INGOT && getVariant() != OrganVariant.COPPER) {
            setVariant(OrganVariant.COPPER);
        } else if (itemStack.is(AllItems.ANDESITE_ALLOY)
                && getVariant() != OrganVariant.ANDESITE) {
            setVariant(OrganVariant.ANDESITE);
        } else if (itemStack.is(AllItems.BRASS_INGOT)
                && getVariant() != OrganVariant.BRASS) {
            setVariant(OrganVariant.BRASS);
        } else if (itemStack.is(AllItems.STURDY_SHEET)
                && getVariant() != OrganVariant.STURDY_SHEET) {
            setVariant(OrganVariant.STURDY_SHEET);
        }
    }
    private void setTypeGlow(ItemStack itemStack) {
        if (itemStack.getItem() == Items.BRUSH && getGlow() != OrganGlow.DEFAULT) {
            setGlow(OrganGlow.DEFAULT);
        } else if (itemStack.is(Items.REDSTONE) && getGlow() != OrganGlow.REDSTONE1) {
            setGlow(OrganGlow.REDSTONE1);
        } else if (itemStack.is(Items.REDSTONE_BLOCK) && getGlow() != OrganGlow.REDSTONE2) {
            setGlow(OrganGlow.REDSTONE2);
        }
    }
    private void dropIngot() {
        if (getVariant() == OrganVariant.BRASS) {
            spawnAtLocation(new ItemStack(AllItems.BRASS_INGOT.asItem()));
        } else if (getVariant() == OrganVariant.COPPER) {
            spawnAtLocation(new ItemStack(Items.COPPER_INGOT));
        } else if (getVariant() == OrganVariant.ANDESITE) {
            spawnAtLocation(new ItemStack(AllItems.ANDESITE_ALLOY.asItem()));
        } else if (getVariant() == OrganVariant.STURDY_SHEET) {
            spawnAtLocation(new ItemStack(AllItems.STURDY_SHEET.asItem()));
        }
    }
    private void dropRedstone(OrganGlow glow) {
        if (getGlow() == OrganGlow.REDSTONE1) {
            spawnAtLocation(new ItemStack(Items.REDSTONE));
        } else if (getGlow() == OrganGlow.REDSTONE2) {
            spawnAtLocation(new ItemStack(Items.REDSTONE_BLOCK));
        }
    }
    public int getGlowColor() {
        return this.entityData.get(GLOW_COLOR);
    }
    public int getTypeVariant() {
        return entityData.get(VARIANT);
    }
    public OrganGlow getGlow() {
        return OrganGlow.byId(this.getGlowColor() & 255);
    }
    public OrganVariant getVariant() {
        return OrganVariant.byId(this.getTypeVariant() & 255);
    }
    public void setGlow(OrganGlow glow) {
        this.entityData.set(GLOW_COLOR, glow.getId() & 255);
    }
    public void setVariant(OrganVariant variant) {
        this.entityData.set(VARIANT, variant.getId() & 255);
    }

    /* STEAM */

    public int exhaustProgress = 0;

    /* ASSEMBLY */

    private Item getPart () {
        if (getAssembly() == 0 || getAssembly() == 1) {
            return (AllBlocks.RAILWAY_CASING.asItem());
        } else if (getAssembly() == 2 || getAssembly() == 3) {
            return (AllBlocks.METAL_GIRDER.asItem());
        } else if (getAssembly() == 4 || getAssembly() == 5) {
            return BionicsItems.ORGAN_FOOT.get();
        } else if (getAssembly() == 6) {
            return BionicsItems.ORGAN_TAIL_BASE.get();
        } else if (getAssembly() == 7) {
            return BionicsItems.ORGAN_TAIL_END.get();
        } else if (getAssembly() == 8) {
            return BionicsItems.ORGAN_CHEST.get();
        } else if (getAssembly() == 9 ||
                getAssembly() == 10 ||
                getAssembly() == 11 ||
                getAssembly() == 12 ||
                getAssembly() == 13 ||
                getAssembly() == 14 ||
                getAssembly() == 15 ||
                getAssembly() == 16) {
            return BionicsItems.ORGAN_PISTON.get();
        } else if (getAssembly() == 17 || getAssembly() == 18) {
            return BionicsItems.ORGAN_BELLOWS.get();
        } else if (getAssembly() == 19) {
            return BionicsItems.ORGAN_NECK.get();
        } else if (getAssembly() == 20) {
            return BionicsItems.ORGAN_HEAD.get();
        } else {
            return (AllBlocks.STEAM_WHISTLE.asItem());
        }
    }

    //SITTING//

}
