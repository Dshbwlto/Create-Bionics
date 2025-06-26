package net.dshbwlto.createbionics.entity.custom;

import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.Util.BionicsTags;
import net.dshbwlto.createbionics.entity.client.oxhauler.OxhaulerVariant;
import net.dshbwlto.createbionics.item.BionicsItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.fluids.FluidType;

public class OxhaulerEntity extends AbstractHorse implements ContainerListener, HasCustomInventoryScreen {
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    private static final EntityDataAccessor<Integer> VARIANT =
            SynchedEntityData.defineId(OxhaulerEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Long> LAST_POSE_CHANGE_TICK =
            SynchedEntityData.defineId(OxhaulerEntity.class, EntityDataSerializers.LONG);
    public static final EntityDataAccessor<Integer> DYE_STACK =
            SynchedEntityData.defineId(OxhaulerEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> HAS_BACK =
            SynchedEntityData.defineId(OxhaulerEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> HAS_FRONT =
            SynchedEntityData.defineId(OxhaulerEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> HAS_NECK =
            SynchedEntityData.defineId(OxhaulerEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> IS_FUELED =
            SynchedEntityData.defineId(OxhaulerEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> FIRST_FUEL =
            SynchedEntityData.defineId(OxhaulerEntity.class, EntityDataSerializers.BOOLEAN);

    public int fuelTime = 1;

    @Override
    public boolean isSaddled() {
        return true;
    }

    @Override
    public boolean isTamed() {
        return true;
    }

    public OxhaulerEntity(EntityType<? extends AbstractHorse> entityType, Level level) {
        super(entityType, level);
        this.createInventory();
    }

    @Override
    protected void registerGoals() {
        if (isFueled()) {
            this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, Player.class, 4f));
            this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
        }
    }

    @Override
    public boolean fireImmune() {
        return getVariant() == OxhaulerVariant.NETHERITE2;
    }

    @Override
    public boolean canDrownInFluidType(FluidType type) {
        return false;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 50D)
                .add(Attributes.MOVEMENT_SPEED, 0.07)
                .add(Attributes.ATTACK_DAMAGE, 2f)
                .add(Attributes.FOLLOW_RANGE, 24D)
                .add(Attributes.JUMP_STRENGTH, 0.55f)
                .add(Attributes.KNOCKBACK_RESISTANCE, 10f);
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 60;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    @Override
    public void aiStep() {
            if (this.level().isClientSide) {
                for (int i = 0; i < 1; ++i) {
                    if (isFueled()) {
                        if (this.isVehicle()) {
                            Particle particle1 = Minecraft.getInstance().particleEngine.createParticle(ParticleTypes.FLAME, this.getRandomX((double) 0.2F), (this.getY() + 0.85 + random.nextFloat()), this.getRandomZ((double) 0.2F), 0.0D, 0.1D, 0.0D);
                            Particle particle2 = Minecraft.getInstance().particleEngine.createParticle(ParticleTypes.FLAME, this.getRandomX((double) 0.2F), (this.getY() + 0.85 + random.nextFloat()), this.getRandomZ((double) 0.2F), 0.0D, 0.075D, 0.0D);
                            Particle particle3 = Minecraft.getInstance().particleEngine.createParticle(ParticleTypes.FLAME, this.getRandomX((double) 0.2F), (this.getY() + 0.85 + random.nextFloat()), this.getRandomZ((double) 0.2F), 0.0D, 0.05D, 0.0D);
                            Particle particle4 = Minecraft.getInstance().particleEngine.createParticle(ParticleTypes.FLAME, this.getRandomX((double) 0.2F), (this.getY() + 0.85 + random.nextFloat()), this.getRandomZ((double) 0.2F), 0.0D, 0.05D, 0.0D);
                            Particle particle5 = Minecraft.getInstance().particleEngine.createParticle(ParticleTypes.FLAME, this.getRandomX((double) 0.2F), (this.getY() + 0.85 + random.nextFloat()), this.getRandomZ((double) 0.2F), 0.0D, 0.05D, 0.0D);
                            Particle particle6 = Minecraft.getInstance().particleEngine.createParticle(ParticleTypes.FLAME, this.getRandomX((double) 0.2F), (this.getY() + 0.85 + random.nextFloat()), this.getRandomZ((double) 0.2F), 0.0D, 0.05D, 0.0D);
                            Particle particle7 = Minecraft.getInstance().particleEngine.createParticle(ParticleTypes.FLAME, this.getRandomX((double) 0.2F), (this.getY() + 0.85 + random.nextFloat()), this.getRandomZ((double) 0.2F), 0.0D, 0.05D, 0.0D);
                            if (particle1 != null) {
                                particle1.scale(1f + random.nextFloat());
                                particle1.setLifetime(2);
                                particle2.scale(1f + random.nextFloat());
                                particle2.setLifetime(2);
                                particle3.scale(1f + random.nextFloat());
                                particle3.setLifetime(2);
                                particle4.scale(1f + random.nextFloat());
                                particle4.setLifetime(2);
                                particle5.scale(1f + random.nextFloat());
                                particle5.setLifetime(2);
                                particle6.scale(1f + random.nextFloat());
                                particle6.setLifetime(2);
                                particle7.scale(1f + random.nextFloat());
                                particle7.setLifetime(2);
                            }
                        } else {
                            this.level().addParticle(ParticleTypes.FLAME, this.getRandomX((double) 0.1F), this.getY() + 0.8 + random.nextFloat(), this.getRandomZ((double) 0.1F), (double) 0.0F, (double) 0.0F, (double) 0.0F);
                            this.level().addParticle(ParticleTypes.FLAME, this.getRandomX((double) 0.1F), this.getY() + 0.8 + random.nextFloat(), this.getRandomZ((double) 0.1F), (double) 0.0F, (double) 0.0F, (double) 0.0F);
                            this.level().addParticle(ParticleTypes.FLAME, this.getRandomX((double) 0.1F), this.getY() + 0.8 + random.nextFloat(), this.getRandomZ((double) 0.1F), (double) 0.0F, (double) 0.0F, (double) 0.0F);
                        }
                        this.level().addParticle(ParticleTypes.SMOKE, this.getRandomX((double) 0.5F), this.getRandomY(), this.getRandomZ((double) 0.5F), (double) 0.0F, (double) 0.0F, (double) 0.0F);
                    }
                }
            }
        if (isInWater()) {
            this.entityData.set(IS_FUELED, false);
            ejectPassengers();
        }
        super.aiStep();
    }

    public long getPoseTime() {
        return this.level().getGameTime() - Math.abs(this.entityData.get(LAST_POSE_CHANGE_TICK));
    }

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide()) {
            this.setupAnimationStates();
        }
    }

    @Override
    public boolean canUseSlot(EquipmentSlot slot) {
        return true;
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        Item item = itemstack.getItem();

        Item itemForNetherite = Items.NETHERITE_INGOT;
        Item itemForBrass = Items.GOLD_INGOT;
        Item itemForCopper = Items.COPPER_INGOT;

        if (itemstack.isEmpty() && isFueled() && !player.isShiftKeyDown()) {
            doPlayerRide(player);
        }
        if (itemstack.isEmpty() && player.isShiftKeyDown()) {
            return InteractionResult.sidedSuccess(this.level().isClientSide);
        }
        if (item == itemForNetherite && isFueled()) {
            if (getVariant() == OxhaulerVariant.NETHERITE1) {
                if (this.level().isClientSide()) {
                    return InteractionResult.CONSUME;
                } else {
                    if (!player.getAbilities().instabuild) {
                        itemstack.shrink(1);
                    }
                    setVariant(OxhaulerVariant.NETHERITE2);
                    makeSound(SoundEvents.SMITHING_TABLE_USE);
                }
            } else {
                if (getVariant() == OxhaulerVariant.DEFAULT) {
                    if (this.level().isClientSide()) {
                        return InteractionResult.CONSUME;
                    } else {
                        if (!player.getAbilities().instabuild) {
                            itemstack.shrink(1);
                        }
                        setVariant(OxhaulerVariant.NETHERITE1);
                        makeSound(SoundEvents.SMITHING_TABLE_USE);
                    }
                }
            }
            return InteractionResult.SUCCESS;
        }
        if (item == itemForCopper) {
            if (getVariant() == OxhaulerVariant.DEFAULT) {
                if (this.level().isClientSide()) {
                    return InteractionResult.CONSUME;
                } else {
                    if (!player.getAbilities().instabuild) {
                        itemstack.shrink(1);
                    }
                    setVariant(OxhaulerVariant.COPPER);
                    makeSound(SoundEvents.SMITHING_TABLE_USE);
                }
                return InteractionResult.SUCCESS;
            }
        }
        if (item == Items.WHITE_DYE) {
            if (this.level().isClientSide()) {
                return InteractionResult.CONSUME;
            } else {
                if (!player.getAbilities().instabuild) {
                    itemstack.shrink(1);
                }
                entityData.set(DYE_STACK, 1);
                makeSound(SoundEvents.SMITHING_TABLE_USE);
            }
            return InteractionResult.SUCCESS;
        }
        if (itemstack.is(BionicsTags.Items.WRENCH) && this.getHealth() < this.getMaxHealth() && isFueled()) {
            if (this.level().isClientSide()) {
                return InteractionResult.CONSUME;
            } else {
                if (!player.getAbilities().instabuild) {
                    itemstack.shrink(1);
                }
                heal(10);
                makeSound(SoundEvents.SMITHING_TABLE_USE);
            }
            return InteractionResult.SUCCESS;
        }
        if (itemstack.is(BionicsTags.Items.WRENCH) && getVariant() == OxhaulerVariant.NETHERITE1 && !player.isShiftKeyDown()) {
            if (this.level().isClientSide()) {
                return InteractionResult.SUCCESS;
            } else {
                setVariant(OxhaulerVariant.DEFAULT);
                makeSound(SoundEvents.GRINDSTONE_USE);
                this.spawnAtLocation(new ItemStack(Items.NETHERITE_INGOT));
            }
        }
        if (itemstack.is(BionicsTags.Items.WRENCH) && getVariant() == OxhaulerVariant.NETHERITE2 && !player.isShiftKeyDown()) {
            if (this.level().isClientSide()) {
                return InteractionResult.SUCCESS;
            } else {
                setVariant(OxhaulerVariant.DEFAULT);
                makeSound(SoundEvents.GRINDSTONE_USE);
                this.spawnAtLocation(new ItemStack(Items.NETHERITE_INGOT));
                this.spawnAtLocation(new ItemStack(Items.NETHERITE_INGOT));
            }
        }
        if (itemstack.is(BionicsTags.Items.WRENCH) && getVariant() == OxhaulerVariant.COPPER && !player.isShiftKeyDown()) {
            if (this.level().isClientSide()) {
                return InteractionResult.SUCCESS;
            } else {
                setVariant(OxhaulerVariant.DEFAULT);
                makeSound(SoundEvents.GRINDSTONE_USE);
                this.spawnAtLocation(new ItemStack(Items.COPPER_INGOT));
            }
        }
        if (itemstack.is(BionicsTags.Items.WRENCH) && player.isShiftKeyDown()) {
            if (this.level().isClientSide()) {
                return InteractionResult.SUCCESS;
            } else {
                setRemoved(RemovalReason.DISCARDED);
                makeSound(SoundEvents.COPPER_BREAK);
                this.spawnAtLocation(new ItemStack(BionicsItems.OXHAULER_HEAD.get()));
                this.spawnAtLocation(new ItemStack(BionicsItems.OXHAULER_FRONT.get()));
                this.spawnAtLocation(new ItemStack(BionicsItems.OXHAULER_MIDDLE.get()));
                this.spawnAtLocation(new ItemStack(BionicsItems.OXHAULER_REAR.get()));
            }
        }
        if (item == BionicsItems.OXHAULER_REAR.get() && !hasBack()) {
            if (this.level().isClientSide()) {
                return InteractionResult.CONSUME;
            } else {
                if (!player.getAbilities().instabuild) {
                    itemstack.shrink(1);
                }
                this.entityData.set(HAS_BACK, true);
                makeSound(SoundEvents.SMITHING_TABLE_USE);
            }
        }
        if (item == BionicsItems.OXHAULER_FRONT.get() && hasBack() && !hasFront()) {
            if (this.level().isClientSide()) {
                return InteractionResult.CONSUME;
            } else {
                if (!player.getAbilities().instabuild) {
                    itemstack.shrink(1);
                }
                this.entityData.set(HAS_FRONT, true);
                makeSound(SoundEvents.SMITHING_TABLE_USE);
            }
        }
        if (item == BionicsItems.OXHAULER_HEAD.get() && hasBack() && hasFront() && !hasNeck()) {
            if (this.level().isClientSide()) {
                return InteractionResult.CONSUME;
            } else {
                if (!player.getAbilities().instabuild) {
                    itemstack.shrink(1);
                }
                this.entityData.set(HAS_NECK, true);
                makeSound(SoundEvents.SMITHING_TABLE_USE);

            }
        }
        if ((item == Items.COAL || item == Items.CHARCOAL) && hasNeck()) {
            if (this.level().isClientSide()) {
                return InteractionResult.CONSUME;
            } else {
                if (!player.getAbilities().instabuild) {
                    itemstack.shrink(1);
                }
                this.entityData.set(IS_FUELED, true);
                this.fuelTime = 100;
                makeSound(SoundEvents.FIRECHARGE_USE);
                if (!entityData.get(FIRST_FUEL)) {
                    this.entityData.set(FIRST_FUEL, true);
                }
            }
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(LAST_POSE_CHANGE_TICK, 0L);
        builder.define(VARIANT, 0);
        builder.define(DYE_STACK, 0);

        builder.define(HAS_BACK, false);
        builder.define(HAS_FRONT, false);
        builder.define(HAS_NECK, false);
        builder.define(IS_FUELED, false);
        builder.define(FIRST_FUEL, false);
    }


    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putLong("LastPoseTick", this.entityData.get(LAST_POSE_CHANGE_TICK));
        compound.putInt("Variant", this.getTypeVariant());
        compound.putInt("dye", this.entityData.get(DYE_STACK));

        compound.putBoolean("HasBack", hasBack());
        compound.putBoolean("HasFront", hasFront());
        compound.putBoolean("HasNeck", hasNeck());
        compound.putBoolean("IsFueled", isFueled());
        compound.putBoolean("FirstFuel", firstFuel());
        compound.putInt("RefuelTime", this.fuelTime);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        long i = compound.getLong("LastPoseTick");
        if (i < 0L) {
            this.setPose(Pose.SITTING);
        }
        this.entityData.set(VARIANT, compound.getInt("Variant"));
        this.entityData.set(DYE_STACK, compound.getInt("dye"));
        this.entityData.set(HAS_BACK, compound.getBoolean("HasBack"));
        this.entityData.set(HAS_FRONT, compound.getBoolean("HasFront"));
        this.entityData.set(HAS_NECK, compound.getBoolean("HasNeck"));
        this.entityData.set(IS_FUELED, compound.getBoolean("IsFueled"));
        this.entityData.set(FIRST_FUEL, compound.getBoolean("FirstFuel"));
        if (compound.contains("RefuelTime")) {
            this.fuelTime = compound.getInt("RefuelTime");
        }
    }


    @Override
    protected Vec3 getPassengerAttachmentPoint(Entity entity, EntityDimensions dimensions, float partialTick) {
        return super.getPassengerAttachmentPoint(entity, dimensions, partialTick)
                .add(new Vec3(0.0, 0.15 * (double) partialTick, -0.5 * (double) partialTick)
                        .yRot(-this.getYRot() * (float) (Math.PI / 180.0)));
    }

    private void setTypeVariant(int typeVariant) {
        this.entityData.set(VARIANT, typeVariant);
    }

    private int getTypeVariant() {
        return this.entityData.get(VARIANT);
    }

    public int getColor() {
        return this.entityData.get(DYE_STACK);
    }

    public OxhaulerVariant getVariant() {
        return OxhaulerVariant.byId(this.getTypeVariant() & 255);
    }

    public void setVariant(OxhaulerVariant variant) {
        this.entityData.set(VARIANT, variant.getId() & 255);
    }

    public boolean hasBack() {
        return this.entityData.get(HAS_BACK);
    }

    public boolean hasFront() {
        return this.entityData.get(HAS_FRONT);
    }

    public boolean hasNeck() {
        return this.entityData.get(HAS_NECK);
    }

    public boolean isFueled() {
        return this.entityData.get(IS_FUELED);
    }

    public boolean firstFuel() {
        return this.entityData.get(FIRST_FUEL);
    }
    //INVENTORY//

}

