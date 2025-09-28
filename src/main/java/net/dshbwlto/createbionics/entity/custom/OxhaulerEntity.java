package net.dshbwlto.createbionics.entity.custom;

import net.dshbwlto.createbionics.Util.BionicsTags;
import net.dshbwlto.createbionics.entity.client.oxhauler.OxhaulerVariant;
import net.dshbwlto.createbionics.item.BionicsItems;
import net.dshbwlto.createbionics.sound.BionicsSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.*;
import net.minecraft.world.damagesource.DamageSource;
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
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.fluids.FluidType;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OxhaulerEntity extends AbstractHorse{
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    private static final EntityDataAccessor<Integer> VARIANT =
            SynchedEntityData.defineId(OxhaulerEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Long> LAST_POSE_CHANGE_TICK =
            SynchedEntityData.defineId(OxhaulerEntity.class, EntityDataSerializers.LONG);
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
    private static final EntityDataAccessor<Boolean> SILENCED =
            SynchedEntityData.defineId(OxhaulerEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> DEAD =
            SynchedEntityData.defineId(OxhaulerEntity.class, EntityDataSerializers.BOOLEAN);

    private static final EntityDataAccessor<Boolean> WHITE =
            SynchedEntityData.defineId(OxhaulerEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> LIGHT_GRAY =
            SynchedEntityData.defineId(OxhaulerEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> GRAY =
            SynchedEntityData.defineId(OxhaulerEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> BLACK =
            SynchedEntityData.defineId(OxhaulerEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> BROWN =
            SynchedEntityData.defineId(OxhaulerEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> RED =
            SynchedEntityData.defineId(OxhaulerEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> ORANGE =
            SynchedEntityData.defineId(OxhaulerEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> YELLOW =
            SynchedEntityData.defineId(OxhaulerEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> LIME =
            SynchedEntityData.defineId(OxhaulerEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> GREEN =
            SynchedEntityData.defineId(OxhaulerEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> CYAN =
            SynchedEntityData.defineId(OxhaulerEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> LIGHT_BLUE =
            SynchedEntityData.defineId(OxhaulerEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> BLUE =
            SynchedEntityData.defineId(OxhaulerEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> MAGENTA =
            SynchedEntityData.defineId(OxhaulerEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> PURPLE =
            SynchedEntityData.defineId(OxhaulerEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> PINK =
            SynchedEntityData.defineId(OxhaulerEntity.class, EntityDataSerializers.BOOLEAN);

    private static final EntityDataAccessor<Boolean> HAS_TIER_1_CHEST =
            SynchedEntityData.defineId(OxhaulerEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> HAS_TIER_2_CHEST =
            SynchedEntityData.defineId(OxhaulerEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> HAS_TIER_3_CHEST =
            SynchedEntityData.defineId(OxhaulerEntity.class, EntityDataSerializers.BOOLEAN);


    private static final EntityDataAccessor<Boolean> HARVESTER =
            SynchedEntityData.defineId(OxhaulerEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> PLOUGH =
            SynchedEntityData.defineId(OxhaulerEntity.class, EntityDataSerializers.BOOLEAN);

    public boolean silenced() {
        return this.entityData.get(SILENCED);
    };
    public boolean dead() {
        return this.entityData.get(DEAD);
    };

    public int fuelTime = 1;

    public float lastHealth = 0;
    public float currentHealth = 0;

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

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        if (isFueled()) {
            if (tickCount % 2 == 0) {
                if (tickCount % 4 == 0) {
                    return BionicsSounds.OXHAULER_BELLOW_1.get();
                } else {
                    return BionicsSounds.OXHAULER_BELLOW_2.get();
                }
            } else {
                if (tickCount % 3 == 0) {
                    return BionicsSounds.OXHAULER_BELLOW_3.get();
                } else {
                    return BionicsSounds.OXHAULER_RELEASE_1.get();
                }
            }
        } else {
            return null;
        }
    }

    @Override
    public int getAmbientSoundInterval() {
        return 400;
    }

    @Override
    protected void dropCustomDeathLoot(ServerLevel level, DamageSource damageSource, boolean recentlyHit) {
        super.dropCustomDeathLoot(level, damageSource, recentlyHit);
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
                    if (isFueled() && !(getVariant() == OxhaulerVariant.NETHERITE2)) {
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
        if (this.isVehicle() && !this.isPassenger()) {
            if (!this.level().isClientSide && this.isAlive() && --this.fuelTime == 0) {
                this.ejectPassengers();
                this.setGlowingTag(true);
                this.entityData.set(IS_FUELED, false);
            }
        }
        if (isInWater()) {
            if (entityData.get(IS_FUELED)) {
                this.level().addParticle(ParticleTypes.LAVA, this.getRandomX((double) 0.1F), this.getY() + 0.8 + random.nextFloat(), this.getRandomZ((double) 0.1F), (double) 0.0F, (double) 0.0F, (double) 0.0F);
                this.level().addParticle(ParticleTypes.LAVA, this.getRandomX((double) 0.1F), this.getY() + 0.8 + random.nextFloat(), this.getRandomZ((double) 0.1F), (double) 0.0F, (double) 0.0F, (double) 0.0F);
                this.level().addParticle(ParticleTypes.LAVA, this.getRandomX((double) 0.1F), this.getY() + 0.8 + random.nextFloat(), this.getRandomZ((double) 0.1F), (double) 0.0F, (double) 0.0F, (double) 0.0F);
                this.level().addParticle(ParticleTypes.LAVA, this.getRandomX((double) 0.1F), this.getY() + 0.8 + random.nextFloat(), this.getRandomZ((double) 0.1F), (double) 0.0F, (double) 0.0F, (double) 0.0F);
                if (this.entityData.get(HARVESTER)) {
                    this.spawnAtLocation(new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:mechanical_harvester"))));
                    entityData.set(HARVESTER, false);
                }
                if (this.entityData.get(PLOUGH)) {
                    this.spawnAtLocation(new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:mechanical_plough"))));
                    entityData.set(PLOUGH, false);
                }
            }
            this.entityData.set(IS_FUELED, false);
            this.fuelTime = 0;
            ejectPassengers();
        };
        if (this.getHealth() == 0 && !this.entityData.get(DEAD)) {
            this.entityData.set(DEAD, true);
            if (!this.hasBack()) {
                this.spawnAtLocation(new ItemStack(BionicsItems.OXHAULER_MIDDLE.get()));
            }
            if (this.hasBack() && !this.hasFront()) {
                this.spawnAtLocation(new ItemStack(BionicsItems.OXHAULER_MIDDLE.get()));
                this.spawnAtLocation(new ItemStack(BionicsItems.OXHAULER_REAR.get()));
            }
            if (this.hasFront() && !this.hasNeck()) {
                this.spawnAtLocation(new ItemStack(BionicsItems.OXHAULER_MIDDLE.get()));
                this.spawnAtLocation(new ItemStack(BionicsItems.OXHAULER_REAR.get()));
                this.spawnAtLocation(new ItemStack(BionicsItems.OXHAULER_FRONT.get()));
            }
            if (this.hasNeck()) {
                this.spawnAtLocation(new ItemStack(BionicsItems.OXHAULER_MIDDLE.get()));
                this.spawnAtLocation(new ItemStack(BionicsItems.OXHAULER_REAR.get()));
                this.spawnAtLocation(new ItemStack(BionicsItems.OXHAULER_FRONT.get()));
                this.spawnAtLocation(new ItemStack(BionicsItems.OXHAULER_HEAD.get()));
            }
            if (this.getVariant() == OxhaulerVariant.COPPER) {
                this.spawnAtLocation(new ItemStack(Items.COPPER_INGOT));
            }
           if (this.getVariant() == OxhaulerVariant.NETHERITE1) {
                this.spawnAtLocation(new ItemStack(Items.NETHERITE_INGOT));
            }
           if (this.getVariant() == OxhaulerVariant.NETHERITE2) {
                this.spawnAtLocation(new ItemStack(Items.NETHERITE_INGOT));
                this.spawnAtLocation(new ItemStack(Items.NETHERITE_INGOT));
            }
           if (this.entityData.get(SILENCED)) {
               this.spawnAtLocation(new ItemStack(BionicsItems.SILENT_PISTON.get()));
           }
        }
        if (isVehicle() && isPlough() && getPassengers() instanceof ServerPlayer serverPlayer) {
            if (HARVESTED_BLOCKS.contains(getOnPos())) {
                return;
            }

            for(BlockPos pos : getBlocksToBeDestroyed(2, getOnPos(), serverPlayer)) {
                if (!getBlockStateOn().is(Blocks.DIRT) || !getBlockStateOn().is(Blocks.GRASS_BLOCK) || !getBlockStateOn().is(Blocks.DIRT_PATH)) {
                    continue;
                }

                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
            }
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
            if (tickCount % 30 == 0 && isFueled() && !this.entityData.get(SILENCED)) {
                this.level().playLocalSound(this.getX() + (double) 0.5F, this.getY() + (double) 0.5F, this.getZ() + (double) 0.5F, BionicsSounds.ENGINE.get(), this.getSoundSource(), 1F + this.random.nextFloat(), 0.1F + random.nextFloat(), false);
            }
        }
    }

    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

    public static List<BlockPos> getBlocksToBeDestroyed(int range, BlockPos initialBlockPos, ServerPlayer serverPlayer) {
        List<BlockPos> positions = new ArrayList<>();

        for(int x = -range; x <= range; x++) {
            for(int y = -range; y <= range; y++) {
                positions.add(new BlockPos(initialBlockPos.getX() + x, initialBlockPos.getY(), initialBlockPos.getZ() + y));
            }
        }
        return positions;
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
            this.openCustomInventoryScreen(player);
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
        if (itemstack.is(BionicsTags.Items.BRASS_INGOT) && this.getHealth() < this.getMaxHealth() && isFueled()) {
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
        if (itemstack.is(BionicsTags.Items.WRENCH) && getVariant() == OxhaulerVariant.NETHERITE1 && !player.isShiftKeyDown() && !entityData.get(HARVESTER) && !entityData.get(PLOUGH)) {
            if (this.level().isClientSide()) {
                return InteractionResult.SUCCESS;
            } else {
                setVariant(OxhaulerVariant.DEFAULT);
                makeSound(SoundEvents.GRINDSTONE_USE);
                this.spawnAtLocation(new ItemStack(Items.NETHERITE_INGOT));
            }
        }
        if (itemstack.is(BionicsTags.Items.WRENCH) && getVariant() == OxhaulerVariant.NETHERITE2 && !player.isShiftKeyDown() && !entityData.get(HARVESTER) && !entityData.get(PLOUGH)) {
            if (this.level().isClientSide()) {
                return InteractionResult.SUCCESS;
            } else {
                setVariant(OxhaulerVariant.DEFAULT);
                makeSound(SoundEvents.GRINDSTONE_USE);
                this.spawnAtLocation(new ItemStack(Items.NETHERITE_INGOT));
                this.spawnAtLocation(new ItemStack(Items.NETHERITE_INGOT));
            }
        }
        if (itemstack.is(BionicsTags.Items.WRENCH) && getVariant() == OxhaulerVariant.COPPER && !player.isShiftKeyDown() && !entityData.get(HARVESTER) && !entityData.get(PLOUGH)) {
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
                if (!this.hasBack()) {
                    this.spawnAtLocation(new ItemStack(BionicsItems.OXHAULER_MIDDLE.get()));
                }
                if (this.hasBack() && !this.hasFront()) {
                    this.spawnAtLocation(new ItemStack(BionicsItems.OXHAULER_MIDDLE.get()));
                    this.spawnAtLocation(new ItemStack(BionicsItems.OXHAULER_REAR.get()));
                }
                if (this.hasFront() && !this.hasNeck()) {
                    this.spawnAtLocation(new ItemStack(BionicsItems.OXHAULER_MIDDLE.get()));
                    this.spawnAtLocation(new ItemStack(BionicsItems.OXHAULER_REAR.get()));
                    this.spawnAtLocation(new ItemStack(BionicsItems.OXHAULER_FRONT.get()));
                }
                if (this.hasNeck()) {
                    this.spawnAtLocation(new ItemStack(BionicsItems.OXHAULER_MIDDLE.get()));
                    this.spawnAtLocation(new ItemStack(BionicsItems.OXHAULER_REAR.get()));
                    this.spawnAtLocation(new ItemStack(BionicsItems.OXHAULER_FRONT.get()));
                    this.spawnAtLocation(new ItemStack(BionicsItems.OXHAULER_HEAD.get()));
                }
            }
        }
        if (itemstack.is(BionicsTags.Items.WRENCH) && entityData.get(HARVESTER) && !entityData.get(PLOUGH)) {
            if (this.level().isClientSide()) {
                return InteractionResult.SUCCESS;
            } else {
                entityData.set(HARVESTER, false);
                makeSound(SoundEvents.COPPER_BREAK);
                this.spawnAtLocation(new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:mechanical_harvester"))));
            }
        }
        if (itemstack.is(BionicsTags.Items.WRENCH) && entityData.get(PLOUGH) && !entityData.get(HARVESTER)) {
            if (this.level().isClientSide()) {
                return InteractionResult.SUCCESS;
            } else {
                entityData.set(PLOUGH, false);
                makeSound(SoundEvents.COPPER_BREAK);
                this.spawnAtLocation(new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:mechanical_plough"))));
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
        if (item == BionicsItems.SILENT_PISTON.get()) {
            if (this.level().isClientSide()) {
                return InteractionResult.CONSUME;
            } else {
                if (!this.entityData.get(SILENCED)) {
                    if (!player.getAbilities().instabuild) {
                        itemstack.shrink(1);
                    }
                    this.entityData.set(SILENCED, true);
                } else {
                    if (!player.getAbilities().instabuild) {
                        itemstack.grow(1);
                    }
                    this.entityData.set(SILENCED, false);
                }
            }
        }
        if ((item == Items.COAL || item == Items.CHARCOAL) && hasNeck() && !isInWater()) {
            if (this.level().isClientSide()) {
                return InteractionResult.CONSUME;
            } else {
                if (!player.getAbilities().instabuild) {
                    itemstack.shrink(1);
                }
                this.entityData.set(IS_FUELED, true);
                this.fuelTime = 100000;
                makeSound(SoundEvents.FIRECHARGE_USE);
                if (!entityData.get(FIRST_FUEL)) {
                    this.entityData.set(FIRST_FUEL, true);
                }
                this.setGlowingTag(false);
            }
        }
        if (item == Items.WHITE_DYE) {
            if (this.level().isClientSide()) {
                return InteractionResult.CONSUME;
            } else {
                itemstack.shrink(1);
                this.entityData.set(WHITE, true);
                this.entityData.set(LIGHT_GRAY, false);
                this.entityData.set(GRAY, false);
                this.entityData.set(BLACK, false);
                this.entityData.set(BROWN, false);
                this.entityData.set(RED, false);
                this.entityData.set(ORANGE, false);
                this.entityData.set(YELLOW, false);
                this.entityData.set(LIME, false);
                this.entityData.set(GREEN, false);
                this.entityData.set(CYAN, false);
                this.entityData.set(LIGHT_BLUE, false);
                this.entityData.set(BLUE, false);
                this.entityData.set(MAGENTA, false);
                this.entityData.set(PURPLE, false);
                this.entityData.set(PINK, false);
            }
        }
        if (item == Items.LIGHT_GRAY_DYE) {
            if (this.level().isClientSide()) {
                return InteractionResult.CONSUME;
            } else {
                itemstack.shrink(1);
                this.entityData.set(WHITE, false);
                this.entityData.set(LIGHT_GRAY, true);
                this.entityData.set(GRAY, false);
                this.entityData.set(BLACK, false);
                this.entityData.set(BROWN, false);
                this.entityData.set(RED, false);
                this.entityData.set(ORANGE, false);
                this.entityData.set(YELLOW, false);
                this.entityData.set(LIME, false);
                this.entityData.set(GREEN, false);
                this.entityData.set(CYAN, false);
                this.entityData.set(LIGHT_BLUE, false);
                this.entityData.set(BLUE, false);
                this.entityData.set(MAGENTA, false);
                this.entityData.set(PURPLE, false);
                this.entityData.set(PINK, false);
            }
        }
        if (item == Items.GRAY_DYE) {
            if (this.level().isClientSide()) {
                return InteractionResult.CONSUME;
            } else {
                itemstack.shrink(1);
                this.entityData.set(WHITE, false);
                this.entityData.set(LIGHT_GRAY, false);
                this.entityData.set(GRAY, true);
                this.entityData.set(BLACK, false);
                this.entityData.set(BROWN, false);
                this.entityData.set(RED, false);
                this.entityData.set(ORANGE, false);
                this.entityData.set(YELLOW, false);
                this.entityData.set(LIME, false);
                this.entityData.set(GREEN, false);
                this.entityData.set(CYAN, false);
                this.entityData.set(LIGHT_BLUE, false);
                this.entityData.set(BLUE, false);
                this.entityData.set(MAGENTA, false);
                this.entityData.set(PURPLE, false);
                this.entityData.set(PINK, false);
            }
        }
        if (item == Items.BLACK_DYE) {
            if (this.level().isClientSide()) {
                return InteractionResult.CONSUME;
            } else {
                itemstack.shrink(1);
                this.entityData.set(WHITE, false);
                this.entityData.set(LIGHT_GRAY, false);
                this.entityData.set(GRAY, false);
                this.entityData.set(BLACK, true);
                this.entityData.set(BROWN, false);
                this.entityData.set(RED, false);
                this.entityData.set(ORANGE, false);
                this.entityData.set(YELLOW, false);
                this.entityData.set(LIME, false);
                this.entityData.set(GREEN, false);
                this.entityData.set(CYAN, false);
                this.entityData.set(LIGHT_BLUE, false);
                this.entityData.set(BLUE, false);
                this.entityData.set(MAGENTA, false);
                this.entityData.set(PURPLE, false);
                this.entityData.set(PINK, false);
            }
        }
        if (item == Items.BROWN_DYE) {
            if (this.level().isClientSide()) {
                return InteractionResult.CONSUME;
            } else {
                itemstack.shrink(1);
                this.entityData.set(WHITE, false);
                this.entityData.set(LIGHT_GRAY, false);
                this.entityData.set(GRAY, false);
                this.entityData.set(BLACK, false);
                this.entityData.set(BROWN, true);
                this.entityData.set(RED, false);
                this.entityData.set(ORANGE, false);
                this.entityData.set(YELLOW, false);
                this.entityData.set(LIME, false);
                this.entityData.set(GREEN, false);
                this.entityData.set(CYAN, false);
                this.entityData.set(LIGHT_BLUE, false);
                this.entityData.set(BLUE, false);
                this.entityData.set(MAGENTA, false);
                this.entityData.set(PURPLE, false);
                this.entityData.set(PINK, false);
            }
        }
        if (item == Items.RED_DYE) {
            if (this.level().isClientSide()) {
                return InteractionResult.CONSUME;
            } else {
                itemstack.shrink(1);
                this.entityData.set(WHITE, false);
                this.entityData.set(LIGHT_GRAY, false);
                this.entityData.set(GRAY, false);
                this.entityData.set(BLACK, false);
                this.entityData.set(BROWN, false);
                this.entityData.set(RED, true);
                this.entityData.set(ORANGE, false);
                this.entityData.set(YELLOW, false);
                this.entityData.set(LIME, false);
                this.entityData.set(GREEN, false);
                this.entityData.set(CYAN, false);
                this.entityData.set(LIGHT_BLUE, false);
                this.entityData.set(BLUE, false);
                this.entityData.set(MAGENTA, false);
                this.entityData.set(PURPLE, false);
                this.entityData.set(PINK, false);
            }
        }
        if (item == Items.ORANGE_DYE) {
            if (this.level().isClientSide()) {
                return InteractionResult.CONSUME;
            } else {
                itemstack.shrink(1);
                this.entityData.set(WHITE, false);
                this.entityData.set(LIGHT_GRAY, false);
                this.entityData.set(GRAY, false);
                this.entityData.set(BLACK, false);
                this.entityData.set(BROWN, false);
                this.entityData.set(RED, false);
                this.entityData.set(ORANGE, true);
                this.entityData.set(YELLOW, false);
                this.entityData.set(LIME, false);
                this.entityData.set(GREEN, false);
                this.entityData.set(CYAN, false);
                this.entityData.set(LIGHT_BLUE, false);
                this.entityData.set(BLUE, false);
                this.entityData.set(MAGENTA, false);
                this.entityData.set(PURPLE, false);
                this.entityData.set(PINK, false);
            }
        }
        if (item == Items.YELLOW_DYE) {
            if (this.level().isClientSide()) {
                return InteractionResult.CONSUME;
            } else {
                itemstack.shrink(1);
                this.entityData.set(WHITE, false);
                this.entityData.set(LIGHT_GRAY, false);
                this.entityData.set(GRAY, false);
                this.entityData.set(BLACK, false);
                this.entityData.set(BROWN, false);
                this.entityData.set(RED, false);
                this.entityData.set(ORANGE, false);
                this.entityData.set(YELLOW, true);
                this.entityData.set(LIME, false);
                this.entityData.set(GREEN, false);
                this.entityData.set(CYAN, false);
                this.entityData.set(LIGHT_BLUE, false);
                this.entityData.set(BLUE, false);
                this.entityData.set(MAGENTA, false);
                this.entityData.set(PURPLE, false);
                this.entityData.set(PINK, false);
            }
        }
        if (item == Items.LIME_DYE) {
            if (this.level().isClientSide()) {
                return InteractionResult.CONSUME;
            } else {
                itemstack.shrink(1);
                this.entityData.set(WHITE, false);
                this.entityData.set(LIGHT_GRAY, false);
                this.entityData.set(GRAY, false);
                this.entityData.set(BLACK, false);
                this.entityData.set(BROWN, false);
                this.entityData.set(RED, false);
                this.entityData.set(ORANGE, false);
                this.entityData.set(YELLOW, false);
                this.entityData.set(LIME, true);
                this.entityData.set(GREEN, false);
                this.entityData.set(CYAN, false);
                this.entityData.set(LIGHT_BLUE, false);
                this.entityData.set(BLUE, false);
                this.entityData.set(MAGENTA, false);
                this.entityData.set(PURPLE, false);
                this.entityData.set(PINK, false);
            }
        }
        if (item == Items.GREEN_DYE) {
            if (this.level().isClientSide()) {
                return InteractionResult.CONSUME;
            } else {
                itemstack.shrink(1);
                this.entityData.set(WHITE, false);
                this.entityData.set(LIGHT_GRAY, false);
                this.entityData.set(GRAY, false);
                this.entityData.set(BLACK, false);
                this.entityData.set(BROWN, false);
                this.entityData.set(RED, false);
                this.entityData.set(ORANGE, false);
                this.entityData.set(YELLOW, false);
                this.entityData.set(LIME, false);
                this.entityData.set(GREEN, true);
                this.entityData.set(CYAN, false);
                this.entityData.set(LIGHT_BLUE, false);
                this.entityData.set(BLUE, false);
                this.entityData.set(MAGENTA, false);
                this.entityData.set(PURPLE, false);
                this.entityData.set(PINK, false);
            }
        }
        if (item == Items.CYAN_DYE) {
            if (this.level().isClientSide()) {
                return InteractionResult.CONSUME;
            } else {
                itemstack.shrink(1);
                this.entityData.set(WHITE, false);
                this.entityData.set(LIGHT_GRAY, false);
                this.entityData.set(GRAY, false);
                this.entityData.set(BLACK, false);
                this.entityData.set(BROWN, false);
                this.entityData.set(RED, false);
                this.entityData.set(ORANGE, false);
                this.entityData.set(YELLOW, false);
                this.entityData.set(LIME, false);
                this.entityData.set(GREEN, false);
                this.entityData.set(CYAN, true);
                this.entityData.set(LIGHT_BLUE, false);
                this.entityData.set(BLUE, false);
                this.entityData.set(MAGENTA, false);
                this.entityData.set(PURPLE, false);
                this.entityData.set(PINK, false);
            }
        }
        if (item == Items.LIGHT_BLUE_DYE) {
            if (this.level().isClientSide()) {
                return InteractionResult.CONSUME;
            } else {
                itemstack.shrink(1);
                this.entityData.set(WHITE, false);
                this.entityData.set(LIGHT_GRAY, false);
                this.entityData.set(GRAY, false);
                this.entityData.set(BLACK, false);
                this.entityData.set(BROWN, false);
                this.entityData.set(RED, false);
                this.entityData.set(ORANGE, false);
                this.entityData.set(YELLOW, false);
                this.entityData.set(LIME, false);
                this.entityData.set(GREEN, false);
                this.entityData.set(CYAN, false);
                this.entityData.set(LIGHT_BLUE, true);
                this.entityData.set(BLUE, false);
                this.entityData.set(MAGENTA, false);
                this.entityData.set(PURPLE, false);
                this.entityData.set(PINK, false);
            }
        }
        if (item == Items.BLUE_DYE) {
            if (this.level().isClientSide()) {
                return InteractionResult.CONSUME;
            } else {
                itemstack.shrink(1);
                this.entityData.set(WHITE, false);
                this.entityData.set(LIGHT_GRAY, false);
                this.entityData.set(GRAY, false);
                this.entityData.set(BLACK, false);
                this.entityData.set(BROWN, false);
                this.entityData.set(RED, false);
                this.entityData.set(ORANGE, false);
                this.entityData.set(YELLOW, false);
                this.entityData.set(LIME, false);
                this.entityData.set(GREEN, false);
                this.entityData.set(CYAN, false);
                this.entityData.set(LIGHT_BLUE, false);
                this.entityData.set(BLUE, true);
                this.entityData.set(MAGENTA, false);
                this.entityData.set(PURPLE, false);
                this.entityData.set(PINK, false);
            }
        }
        if (item == Items.MAGENTA_DYE) {
            if (this.level().isClientSide()) {
                return InteractionResult.CONSUME;
            } else {
                itemstack.shrink(1);
                this.entityData.set(WHITE, false);
                this.entityData.set(LIGHT_GRAY, false);
                this.entityData.set(GRAY, false);
                this.entityData.set(BLACK, false);
                this.entityData.set(BROWN, false);
                this.entityData.set(RED, false);
                this.entityData.set(ORANGE, false);
                this.entityData.set(YELLOW, false);
                this.entityData.set(LIME, false);
                this.entityData.set(GREEN, false);
                this.entityData.set(CYAN, false);
                this.entityData.set(LIGHT_BLUE, false);
                this.entityData.set(BLUE, false);
                this.entityData.set(MAGENTA, true);
                this.entityData.set(PURPLE, false);
                this.entityData.set(PINK, false);
            }
        }
        if (item == Items.PURPLE_DYE) {
            if (this.level().isClientSide()) {
                return InteractionResult.CONSUME;
            } else {
                itemstack.shrink(1);
                this.entityData.set(WHITE, false);
                this.entityData.set(LIGHT_GRAY, false);
                this.entityData.set(GRAY, false);
                this.entityData.set(BLACK, false);
                this.entityData.set(BROWN, false);
                this.entityData.set(RED, false);
                this.entityData.set(ORANGE, false);
                this.entityData.set(YELLOW, false);
                this.entityData.set(LIME, false);
                this.entityData.set(GREEN, false);
                this.entityData.set(CYAN, false);
                this.entityData.set(LIGHT_BLUE, false);
                this.entityData.set(BLUE, false);
                this.entityData.set(MAGENTA, false);
                this.entityData.set(PURPLE, true);
                this.entityData.set(PINK, false);
            }
        }
        if (item == Items.PINK_DYE) {
            if (this.level().isClientSide()) {
                return InteractionResult.CONSUME;
            } else {
                itemstack.shrink(1);
                this.entityData.set(WHITE, false);
                this.entityData.set(LIGHT_GRAY, false);
                this.entityData.set(GRAY, false);
                this.entityData.set(BLACK, false);
                this.entityData.set(BROWN, false);
                this.entityData.set(RED, false);
                this.entityData.set(ORANGE, false);
                this.entityData.set(YELLOW, false);
                this.entityData.set(LIME, false);
                this.entityData.set(GREEN, false);
                this.entityData.set(CYAN, false);
                this.entityData.set(LIGHT_BLUE, false);
                this.entityData.set(BLUE, false);
                this.entityData.set(MAGENTA, false);
                this.entityData.set(PURPLE, false);
                this.entityData.set(PINK, true);
            }
        }
        if(itemstack.is(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:mechanical_harvester"))) && !entityData.get(PLOUGH) && isFueled()) {
            if (this.level().isClientSide) {
                return InteractionResult.CONSUME;
            }
            itemstack.shrink(1);
            this.entityData.set(HARVESTER, true);
        }
        if(itemstack.is(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:mechanical_plough"))) && !entityData.get(HARVESTER) && isFueled()) {
            if (this.level().isClientSide) {
                return InteractionResult.CONSUME;
            }
            itemstack.shrink(1);
            this.entityData.set(PLOUGH, true);
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(LAST_POSE_CHANGE_TICK, 0L);
        builder.define(VARIANT, 0);
        builder.define(HAS_BACK, false);
        builder.define(HAS_FRONT, false);
        builder.define(HAS_NECK, false);
        builder.define(IS_FUELED, false);
        builder.define(FIRST_FUEL, false);
        builder.define(SILENCED, false);
        builder.define(DEAD, false);

        builder.define(WHITE, false);
        builder.define(LIGHT_GRAY, false);
        builder.define(GRAY, false);
        builder.define(BLACK, false);
        builder.define(BROWN, false);
        builder.define(RED, true);
        builder.define(ORANGE, false);
        builder.define(YELLOW, false);
        builder.define(LIME, false);
        builder.define(GREEN, false);
        builder.define(CYAN, false);
        builder.define(LIGHT_BLUE, false);
        builder.define(BLUE, false);
        builder.define(MAGENTA, false);
        builder.define(PURPLE, false);
        builder.define(PINK, false);
        builder.define(HARVESTER, false);
        builder.define(PLOUGH, false);

    }


    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putLong("LastPoseTick", this.entityData.get(LAST_POSE_CHANGE_TICK));
        compound.putInt("Variant", this.getTypeVariant());

        compound.putBoolean("HasBack", hasBack());
        compound.putBoolean("HasFront", hasFront());
        compound.putBoolean("HasNeck", hasNeck());
        compound.putBoolean("IsFueled", isFueled());
        compound.putBoolean("FirstFuel", firstFuel());
        compound.putBoolean("Silenced", silenced());
        compound.putBoolean("Dead", dead());

        compound.putBoolean("WhiteFlag", whiteFlag());
        compound.putBoolean("LightGrayFlag", lightGrayFlag());
        compound.putBoolean("GrayFlag", grayFlag());
        compound.putBoolean("BlackFlag", blackFlag());
        compound.putBoolean("BrownFlag", brownFlag());
        compound.putBoolean("RedFlag", redFlag());
        compound.putBoolean("OrangeFlag", orangeFlag());
        compound.putBoolean("YellowFlag", yellowFlag());
        compound.putBoolean("LimeFlag", limeFlag());
        compound.putBoolean("GreenFlag", greenFlag());
        compound.putBoolean("CyanFlag", cyanFlag());
        compound.putBoolean("LightBlueFlag", lightBlueFlag());
        compound.putBoolean("BlueFlag", blueFlag());
        compound.putBoolean("MagentaFlag", magentaFlag());
        compound.putBoolean("PurpleFlag", purpleFlag());
        compound.putBoolean("MagentaFlag", magentaFlag());
        compound.putBoolean("PinkFlag", pinkFlag());

        compound.putBoolean("Harvester", isHarvester());
        compound.putBoolean("Plough", isPlough());

        compound.putInt("RefuelTime", this.fuelTime);
        compound.putFloat("LastHealth", this.lastHealth);
        compound.putFloat("CurrentHealth", this.currentHealth);

        ListTag listtag = new ListTag();
        for (int x = 0; x < this.inventory.getContainerSize(); x++) {
            ItemStack itemstack = this.inventory.getItem(x);
            if (!itemstack.isEmpty()) {
                CompoundTag compoundtag = new CompoundTag();
                compoundtag.putByte("Slot", (byte)(x));
                listtag.add(itemstack.save(this.registryAccess(), compoundtag));
            }
        }
        compound.put("Items", listtag);

    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        long i = compound.getLong("LastPoseTick");
        if (i < 0L) {
            this.setPose(Pose.SITTING);
        }
        this.entityData.set(VARIANT, compound.getInt("Variant"));
        this.entityData.set(HAS_BACK, compound.getBoolean("HasBack"));
        this.entityData.set(HAS_FRONT, compound.getBoolean("HasFront"));
        this.entityData.set(HAS_NECK, compound.getBoolean("HasNeck"));
        this.entityData.set(IS_FUELED, compound.getBoolean("IsFueled"));
        this.entityData.set(FIRST_FUEL, compound.getBoolean("FirstFuel"));
        this.entityData.set(SILENCED, compound.getBoolean("Silenced"));

        this.entityData.set(WHITE, compound.getBoolean("WhiteFlag"));
        this.entityData.set(LIGHT_GRAY, compound.getBoolean("LightGrayFlag"));
        this.entityData.set(GRAY, compound.getBoolean("GrayFlag"));
        this.entityData.set(BLACK, compound.getBoolean("BlackFlag"));
        this.entityData.set(BROWN, compound.getBoolean("BrownFlag"));
        this.entityData.set(RED, compound.getBoolean("RedFlag"));
        this.entityData.set(ORANGE, compound.getBoolean("OrangeFlag"));
        this.entityData.set(YELLOW, compound.getBoolean("YellowFlag"));
        this.entityData.set(LIME, compound.getBoolean("LimeFlag"));
        this.entityData.set(GREEN, compound.getBoolean("GreenFlag"));
        this.entityData.set(CYAN, compound.getBoolean("CyanFlag"));
        this.entityData.set(LIGHT_BLUE, compound.getBoolean("LightBlueFlag"));
        this.entityData.set(BLUE, compound.getBoolean("BlueFlag"));
        this.entityData.set(MAGENTA, compound.getBoolean("MagentaFlag"));
        this.entityData.set(PURPLE, compound.getBoolean("PurpleFlag"));
        this.entityData.set(PINK, compound.getBoolean("PinkFlag"));

        this.entityData.set(HARVESTER, compound.getBoolean("Harvester"));
        this.entityData.set(PLOUGH, compound.getBoolean("Plough"));

        this.entityData.set(DEAD, compound.getBoolean("Dead"));
        if (compound.contains("RefuelTime")) {
            this.fuelTime = compound.getInt("RefuelTime");
        }
        if (compound.contains("LastHealth")) {
            this.lastHealth = compound.getFloat("LastHealth");
        }
        if (compound.contains("CurrentHealth")) {
            this.currentHealth = compound.getFloat("CurrentHealth");
        }
        this.createInventory();
        ListTag listtag = compound.getList("Items", 10);
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

    public boolean whiteFlag() {
        return this.entityData.get(WHITE);
    }
    public boolean lightGrayFlag() {
        return this.entityData.get(LIGHT_GRAY);
    }
    public boolean grayFlag() {
        return this.entityData.get(GRAY);
    }
    public boolean blackFlag() {
        return this.entityData.get(BLACK);
    }
    public boolean brownFlag() {
        return this.entityData.get(BROWN);
    }
    public boolean redFlag() {
        return this.entityData.get(RED);
    }
    public boolean orangeFlag() {
        return this.entityData.get(ORANGE);
    }
    public boolean yellowFlag() {
        return this.entityData.get(YELLOW);
    }
    public boolean limeFlag() {
        return this.entityData.get(LIME);
    }
    public boolean greenFlag() {
        return this.entityData.get(GREEN);
    }
    public boolean cyanFlag() {
        return this.entityData.get(CYAN);
    }
    public boolean lightBlueFlag() {
        return this.entityData.get(LIGHT_BLUE);
    }
    public boolean blueFlag() {
        return this.entityData.get(BLUE);
    }
    public boolean magentaFlag() {
        return this.entityData.get(MAGENTA);
    }
    public boolean purpleFlag() {
        return this.entityData.get(PURPLE);
    }
    public boolean pinkFlag() {
        return this.entityData.get(PINK);
    }

    public boolean isHarvester() {
        return this.entityData.get(HARVESTER);
    }
    public boolean isPlough() {
        return this.entityData.get(PLOUGH);
    }

    //INVENTORY//
}

