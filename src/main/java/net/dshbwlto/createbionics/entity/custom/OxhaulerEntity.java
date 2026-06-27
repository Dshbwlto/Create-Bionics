package net.dshbwlto.createbionics.entity.custom;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.AllSoundEvents;
import com.simibubi.create.foundation.sound.SoundScapes;
import net.createmod.catnip.animation.AnimationTickHolder;
import net.createmod.catnip.math.VecHelper;
import net.dshbwlto.createbionics.entity.api.AbstractRobot;
import net.dshbwlto.createbionics.entity.client.oxhauler.OxhaulerColor;
import net.dshbwlto.createbionics.entity.client.oxhauler.OxhaulerVariant;
import net.dshbwlto.createbionics.item.BionicsItems;
import net.dshbwlto.createbionics.screen.custom.OxhaulerMenu;
import net.dshbwlto.createbionics.sound.BionicsSounds;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.fluids.FluidType;
import org.jetbrains.annotations.Nullable;

public class OxhaulerEntity extends AbstractHorse {
    public final AnimationState idleAnimationState = new AnimationState();
    private int x0;
    public float y0;

    public final AnimationState idleAnimation1 = new AnimationState();
    public final AnimationState idleAnimation2 = new AnimationState();
    public final AnimationState idleAnimation3 = new AnimationState();
    private int idleAnimationTimeout = 0;
    private static final EntityDataAccessor<Integer> VARIANT =
            SynchedEntityData.defineId(OxhaulerEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> COLOR =
            SynchedEntityData.defineId(OxhaulerEntity.class, EntityDataSerializers.INT);

    public void setColor(Item item) {
        /// Occam’s razor is a problem-solving principle that recommends searching for explanations
        ///constructed with the smallest possible set of elements. It’s also known as the principle
        ///of parsimony or the law of parsimony. Attributed to William of Occam, the 14th century
        ///English philosopher, “Entities must not be multiplied beyond necessity”. This
        ///philosophical razor advocates that when presented with competing hypotheses about the same
        ///prediction, one should prefer the one that requires the fewest assumptions. And that
        ///is not meant to be a way of choosing between hypotheses to make different predictions.

        if (item == Items.WHITE_DYE) {
            entityData.set(COLOR, 0);
        } else if (item == Items.LIGHT_GRAY_DYE) {
            entityData.set(COLOR, 1);
        } else if (item == Items.GRAY_DYE) {
            entityData.set(COLOR, 2);
        } else if (item == Items.BLACK_DYE) {
            entityData.set(COLOR, 3);
        } else if (item == Items.BROWN_DYE) {
            entityData.set(COLOR, 4);
        } else if (item == Items.RED_DYE) {
            entityData.set(COLOR, 5);
        } else if (item == Items.ORANGE_DYE) {
            entityData.set(COLOR, 6);
        } else if (item == Items.YELLOW_DYE) {
            entityData.set(COLOR, 7);
        } else if (item == Items.LIME_DYE) {
            entityData.set(COLOR, 8);
        } else if (item == Items.GREEN_DYE) {
            entityData.set(COLOR, 9);
        } else if (item == Items.CYAN_DYE) {
            entityData.set(COLOR, 10);
        } else if (item == Items.LIGHT_BLUE_DYE) {
            entityData.set(COLOR, 11);
        } else if (item == Items.BLUE_DYE) {
            entityData.set(COLOR, 12);
        } else if (item == Items.PURPLE_DYE) {
            entityData.set(COLOR, 13);
        } else if (item == Items.MAGENTA_DYE) {
            entityData.set(COLOR, 14);
        } else if (item == Items.PINK_DYE) {
            entityData.set(COLOR, 15);
        }
    }

    public static final EntityDataAccessor<Long> LAST_POSE_CHANGE_TICK =
            SynchedEntityData.defineId(OxhaulerEntity.class, EntityDataSerializers.LONG);
    private static final EntityDataAccessor<Boolean> HARVESTER =
            SynchedEntityData.defineId(OxhaulerEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> PLOUGH =
            SynchedEntityData.defineId(OxhaulerEntity.class, EntityDataSerializers.BOOLEAN);

    private static final EntityDataAccessor<Integer> FUEL =
            SynchedEntityData.defineId(OxhaulerEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Boolean> CREATIVE_BLAZE_CAKE =
            SynchedEntityData.defineId(OxhaulerEntity.class, EntityDataSerializers.BOOLEAN);
    public boolean hasBlazeCake() {
        return entityData.get(CREATIVE_BLAZE_CAKE);
    }

    public int getFuel() {
        return entityData.get(FUEL);
    }
    public void setFuel(int fuel) {
        entityData.set(FUEL, fuel);
    }

    public static final EntityDataAccessor<Integer> ASSEMBLY =
            SynchedEntityData.defineId(OxhaulerEntity.class, EntityDataSerializers.INT);
    public int getAssembly() {
        return this.entityData.get(ASSEMBLY);
    }
    public void setAssembly(int assembly) {
        this.entityData.set(ASSEMBLY, assembly);
    }

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

    public int pageCount = 1;

    public OxhaulerEntity(EntityType<? extends AbstractHorse> entityType, Level level) {
        super(entityType, level);
        this.createInventory();
    }

    @Override
    public boolean fireImmune() {
        return true;
    }

    @Override
    public boolean canDrownInFluidType(FluidType type) {
        return false;
    }

    @Override
    protected void registerGoals() {
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        if (getFuel() > 0) {
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
    public boolean canBeCollidedWith() {
        return getFuel() == 0 || isVehicle();
    }

    @Override
    protected void dropCustomDeathLoot(ServerLevel level, DamageSource damageSource, boolean recentlyHit) {
        spawnAtLocation(canDrop(getAssembly(), 0, BionicsItems.OXHAULER_MIDDLE.get()));
        spawnAtLocation(canDrop(getAssembly(), 1, BionicsItems.OXHAULER_REAR.get()));
        spawnAtLocation(canDrop(getAssembly(), 2, BionicsItems.OXHAULER_FRONT.get()));
        spawnAtLocation(canDrop(getAssembly(), 3, BionicsItems.OXHAULER_HEAD.get()));
        if (isPlough()) {
            spawnAtLocation(AllBlocks.MECHANICAL_PLOUGH);
        }
        if (isHarvester()) {
            spawnAtLocation(AllBlocks.MECHANICAL_HARVESTER);
        }
        if (getVariant() != OxhaulerVariant.BRASS) {
            dropIngot();
        }
        spawnAtLocation(randomSalvage());
    }

    public Item canDrop(int assembly, int targetAssembly, Item item) {
        if (assembly >= targetAssembly) {
            if (random.nextBoolean()) {
                return item;
            } else {
                return randomSalvage();
            }
        } else {
            return ItemStack.EMPTY.getItem();
        }
    }

    public Item randomSalvage() {
        if (random.nextBoolean()) {
            return AllItems.ANDESITE_ALLOY.get();
        } else {
            return AllBlocks.SHAFT.asItem();
        }
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
        if (random.nextFloat() < 0.001 && getFuel() > 0) {
            if (tickCount % 3 == 0) {
                this.idleAnimation1.start(this.tickCount);
                idleAnimationTimeout = 220;
            } else if (tickCount % 3 == 1) {
                this.idleAnimation2.start(this.tickCount);
                idleAnimationTimeout = 220;
            } else {
                this.idleAnimation3.start(this.tickCount);
                idleAnimationTimeout = 220;
            }
        }
    }

    public void sendFuelError(Player player) {
        player.displayClientMessage(Component.translatable("entity.createbionics.all.fuel_warning"), true);
        playSound(AllSoundEvents.DENY.getMainEvent(), 1, 0.2f);

    }

    @Override
    public void aiStep() {

        if (isHarvester()) {
            boolean flag = false;
            AABB aabb = this.getBoundingBox().inflate(1.2);

            for (BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
                BlockState blockstate = this.level().getBlockState(blockpos);
                Block block = blockstate.getBlock();
                if (block instanceof CropBlock && ((CropBlock) block).isMaxAge(blockstate)) {
                    flag = this.level().destroyBlock(blockpos, true, this) || flag;
                    flag = this.level().setBlock(blockpos, block.defaultBlockState(), 1) || flag;
                }
            }
        }
        if (isPlough()) {
            AABB aabb = this.getBoundingBox().inflate(0.2);

            for (BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
                BlockState blockstate = this.level().getBlockState(blockpos);
                Block block = blockstate.getBlock();
                if (block.equals(Blocks.DIRT) || block.equals(Blocks.GRASS_BLOCK) || block.equals(Blocks.DIRT_PATH) || block.equals(Blocks.COARSE_DIRT)) {
                    level().setBlock(blockpos, Blocks.FARMLAND.defaultBlockState(), 11);
                    playSound(SoundEvents.HOE_TILL);
                }
            }
        }

        super.aiStep();

        if (getHealth() - x0 == 1) {
            setHealth(getHealth() - 1);
        }
        x0 = (int) getHealth();
    }

    public long getPoseTime() {
        return this.level().getGameTime() - Math.abs(this.entityData.get(LAST_POSE_CHANGE_TICK));
    }

    @Override
    public void tick() {
        super.tick();

        if (isInWater() && getFuel() > 0) {
            setFuel(0);
            playSound(SoundEvents.FIRE_EXTINGUISH);
            ejectPassengers();
        }
        if (getFuel() > 0) {
            playSoundScape(2, 3);
            if (isVehicle() && !hasBlazeCake()) {
                setFuel(getFuel() - 1);
            }
            if (isInWater()) {
                setFuel(0);
                playSound(SoundEvents.FIRE_EXTINGUISH);
                ejectPassengers();
            }
            this.level().addParticle(ParticleTypes.SMOKE, this.getRandomX((double) 0.1F), this.getRandomY(), this.getRandomZ((double) 0.1F), (double) 0.0F, (double) 0.0F, (double) 0.0F);
        } else {
            if (isVehicle()) {
                ejectPassengers();
            }
        }

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
        ItemStack itemStack = player.getItemInHand(hand);
        if (itemStack.is(ItemTags.CREEPER_DROP_MUSIC_DISCS)) {
            if (level().isClientSide) {
                return InteractionResult.SUCCESS;
            } else {
                itemStack.shrink(1);
                player.addItem(new ItemStack(BionicsItems.WALTZ_2_MUSIC_DISC.get()));
            }
        } else if (itemStack.is(AllItems.CREATIVE_BLAZE_CAKE) && getAssembly() == 3) {
            if (hasBlazeCake()) {
                entityData.set(CREATIVE_BLAZE_CAKE, false);
            } else {
                setFuel(10000);
                entityData.set(CREATIVE_BLAZE_CAKE, true);
                playSound(AllSoundEvents.BLAZE_MUNCH.getMainEvent());
            }
        } else if ((itemStack.is(Items.COAL)
                || itemStack.is(Items.CHARCOAL)
                || itemStack.is(AllItems.BLAZE_CAKE))
                && !isInWater() && getAssembly() == 3) {
            if (this.level().isClientSide()) {
                return InteractionResult.CONSUME;
            } else {
                if (!player.getAbilities().instabuild) {
                    itemStack.shrink(1);
                }
                if (itemStack.is(AllItems.BLAZE_CAKE)) {
                    setFuel(25000);
                } else {
                    setFuel(10000);
                }
                makeSound(SoundEvents.FIRECHARGE_USE);
            }
        } else if (itemStack.is(AllBlocks.MECHANICAL_HARVESTER.asItem()) && !isPlough() && !isHarvester()) {
            if (this.level().isClientSide) {
                return InteractionResult.CONSUME;
            }
            itemStack.shrink(1);
            this.entityData.set(HARVESTER, true);
            return InteractionResult.SUCCESS;
        } else if (itemStack.is(AllBlocks.MECHANICAL_PLOUGH.asItem()) && !isPlough() && !isHarvester()) {
            if (this.level().isClientSide) {
                return InteractionResult.CONSUME;
            }
            itemStack.shrink(1);
            this.entityData.set(PLOUGH, true);
            return InteractionResult.SUCCESS;
        } else if ((itemStack.is(BionicsItems.ROBOT_BUILDER) || itemStack.is(getPart())) && getAssembly() < 3) {
            setAssembly(getAssembly() + 1);
            if (!itemStack.is(BionicsItems.ROBOT_BUILDER.get())) {
                itemStack.shrink(1);
            }
            playSound(SoundEvents.NETHERITE_BLOCK_PLACE);
            if (getAssembly() < 7) {
                player.displayClientMessage(Component.translatable("entity.createbionics.all.assembly", getPart().getDescription().getString()), true);
            }
            return InteractionResult.SUCCESS;
        } else if (itemStack.is(AllItems.WRENCH) && player.isShiftKeyDown()) {
            if (isPlough()) {
                entityData.set(PLOUGH, false);
                spawnAtLocation(new ItemStack(AllBlocks.MECHANICAL_PLOUGH));
            } else if (isHarvester()) {
                entityData.set(HARVESTER, false);
                spawnAtLocation(new ItemStack(AllBlocks.MECHANICAL_HARVESTER));
            } else if (getVariant() != OxhaulerVariant.BRASS){
                dropIngot();
                setVariant(OxhaulerVariant.BRASS);
            } else if (getAssembly() > 0) {
                setAssembly(getAssembly() - 1);
                setFuel(0);
                spawnAtLocation(new ItemStack(getPart()));
                playSound(SoundEvents.NETHERITE_BLOCK_PLACE);
            } else {
                if (!level().isClientSide) {
                    if (getInventory().isEmpty()) {
                        spawnAtLocation(new ItemStack(BionicsItems.OXHAULER_MIDDLE.get()));
                        remove(RemovalReason.DISCARDED);
                    } else {
                        player.displayClientMessage(Component.translatable("entity.createbionics.all.empty_warning"), true);
                    }
                }
            }
        } else if (itemStack.is(Tags.Items.DYES)) {
            setColor(itemStack.getItem());
            itemStack.shrink(1);
        } else if (itemStack.is(AllItems.ANDESITE_ALLOY)
                || itemStack.is(Items.COPPER_INGOT)) {
            dropIngot();
            setTypeVariant(itemStack);
            if (level().isClientSide) {
                return InteractionResult.SUCCESS;
            } else {
                itemStack.shrink(1);
            }
        } else if (getFuel() > 0) {
            if (player.isShiftKeyDown()){
                openCustomInventoryScreen(player);
            } else {
                doPlayerRide(player);
            }
        } else {
            sendFuelError(player);
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(LAST_POSE_CHANGE_TICK, 0L);
        builder.define(VARIANT, 0);
        builder.define(COLOR, 5);
        builder.define(ASSEMBLY, 0);

        builder.define(HARVESTER, false);
        builder.define(PLOUGH, false);

        builder.define(FUEL, 0);
        builder.define(CREATIVE_BLAZE_CAKE, false);

    }


    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putLong("LastPoseTick", this.entityData.get(LAST_POSE_CHANGE_TICK));
        compound.putInt("Variant", this.getTypeVariant());
        compound.putInt("Color", this.getTypeColor());
        compound.putInt("Assembly", this.getAssembly());

        compound.putBoolean("Harvester", isHarvester());
        compound.putBoolean("Plough", isPlough());
        compound.putInt("Fuel", getFuel());
        compound.putInt("Variant", this.entityData.get(VARIANT));

        ListTag listtag = new ListTag();
        for (int x = 0; x <= 200; x++) {
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
        this.entityData.set(COLOR, compound.getInt("Color"));
        this.entityData.set(ASSEMBLY, compound.getInt("Assembly"));

        this.entityData.set(HARVESTER, compound.getBoolean("Harvester"));
        this.entityData.set(PLOUGH, compound.getBoolean("Plough"));

        this.entityData.set(FUEL, compound.getInt("Fuel"));
        entityData.set(CREATIVE_BLAZE_CAKE, compound.getBoolean("CreativeCake"));

        this.createInventory();
        ListTag listtag = compound.getList("Items", 10);
        for (int x = 0; x < listtag.size(); x++) {
            CompoundTag compoundtag = listtag.getCompound(x);
            int j = compoundtag.getByte("Slot") & 255;
            if (j < this.inventory.getContainerSize()) {
                this.inventory.setItem(j, ItemStack.parse(this.registryAccess(), compoundtag).orElse(ItemStack.EMPTY));
            }
        }
    }


    @Override
    protected Vec3 getPassengerAttachmentPoint(Entity entity, EntityDimensions dimensions, float partialTick) {
        return super.getPassengerAttachmentPoint(entity, dimensions, partialTick)
                .add(new Vec3(0.0, 0.15 * (double) partialTick, -0.5 * (double) partialTick)
                        .yRot(-this.getYRot() * (float) (Math.PI / 180.0)));
    }

    public void playSoundScape(int radius, int height) {
        for (int j = 0; j <= height; j++) {
            for (int i = -radius; i <= radius; i++) {
                SoundScapes.play(SoundScapes.AmbienceGroup.COG, getOnPos().east(i).north(-i).above(j), (float)(1 / radius) * 10);
                SoundScapes.play(SoundScapes.AmbienceGroup.KINETIC, getOnPos().east(i).north(-i).above(j), (float)(1 / radius) * 10);
                SoundScapes.play(SoundScapes.AmbienceGroup.COG, getOnPos().north(i).east(-i).above(j), (float)(1 / radius) * 10);
                SoundScapes.play(SoundScapes.AmbienceGroup.KINETIC, getOnPos().north(i).east(-i).above(j), (float)(1 / radius) * 10);
            }
        }
    }
    //Variant//

    private void dropIngot() {
        if (getVariant() == OxhaulerVariant.COPPER) {
            spawnAtLocation(new ItemStack(Items.COPPER_INGOT));
        } else if (getVariant() == OxhaulerVariant.ANDESITE) {
            spawnAtLocation(new ItemStack(AllItems.ANDESITE_ALLOY.asItem()));
        }
    }
    private void setTypeVariant(ItemStack itemStack) {
        if (itemStack.getItem() == Items.COPPER_INGOT && getVariant() != OxhaulerVariant.COPPER) {
            setVariant(OxhaulerVariant.COPPER);
        } else if (itemStack.is(AllItems.ANDESITE_ALLOY)
                && getVariant() != OxhaulerVariant.ANDESITE) {
            setVariant(OxhaulerVariant.ANDESITE);
        } else if (itemStack.is(AllItems.BRASS_INGOT)
                && getVariant() != OxhaulerVariant.BRASS) {
            setVariant(OxhaulerVariant.BRASS);
        }
    }
    private int getTypeVariant() {
        return this.entityData.get(VARIANT);
    }
    public int getTypeColor() {
        return this.entityData.get(COLOR);
    }

    public OxhaulerVariant getVariant() {
        return OxhaulerVariant.byId(this.getTypeVariant() & 255);
    }
    public OxhaulerColor getColor() {
        return OxhaulerColor.byId(this.getTypeColor() & 255);
    }

    public void setVariant(OxhaulerVariant variant) {
        this.entityData.set(VARIANT, variant.getId() & 255);
    }
    public void setColor(OxhaulerColor color) {
        this.entityData.set(COLOR, color.getId() & 255);
    }

    public boolean isHarvester() {
        return this.entityData.get(HARVESTER);
    }
    public boolean isPlough() {
        return this.entityData.get(PLOUGH);
    }

    public void spawnParticleBurst(boolean soulFlame) {
        Vec3 c = VecHelper.getCenterOf(getOnPos());
        RandomSource r = level().random;
        for (int i = 0; i < 20; i++) {
            Vec3 offset = VecHelper.offsetRandomly(Vec3.ZERO, r, .5f)
                    .multiply(1, .25f, 1)
                    .normalize();
            Vec3 v = c.add(offset.scale(.5 + r.nextDouble() * .125f))
                    .add(0, .125, 0);
            Vec3 m = offset.scale(1 / 32f);

            level().addParticle(soulFlame ? ParticleTypes.SOUL_FIRE_FLAME : ParticleTypes.FLAME, v.x, v.y, v.z, m.x, m.y,
                    m.z);
        }
    }

    //ASSEMBLY//
    private Item getPart() {
        if (getAssembly() == 0) {
            return BionicsItems.OXHAULER_REAR.get();
        } else if (getAssembly() == 1) {
            return BionicsItems.OXHAULER_FRONT.get();
        } else  {
            return BionicsItems.OXHAULER_HEAD.get();
        }
    }

    //INVENTORY//

    @Override
    public void containerChanged(Container container) {

    }

    @Override
    public void openCustomInventoryScreen(Player player) {
        if (!this.level().isClientSide && (!this.isVehicle() || this.hasPassenger(player))) {
            ServerPlayer serverPlayer = (ServerPlayer) player;
            if (player.containerMenu != player.inventoryMenu) {
                player.closeContainer();
            }

            serverPlayer.openMenu(new SimpleMenuProvider((ix, playerInventory, playerEntityx) ->
                    new OxhaulerMenu(ix, playerInventory, this.inventory, this), this.getDisplayName()), buf -> {
                buf.writeUUID(getUUID());
            });
        }
    }

    @Override
    protected void createInventory() {
        SimpleContainer simplecontainer = this.inventory;
        this.inventory = new SimpleContainer(200);
        if (simplecontainer != null) {
            simplecontainer.removeListener(this);

            for (int j = 0; j < 200; j++) {
                ItemStack itemstack = simplecontainer.getItem(j);
                if (!itemstack.isEmpty()) {
                    this.inventory.setItem(j, itemstack.copy());
                }
            }
        }
        this.inventory.addListener(this);
    }

    @Override
    public Container getInventory() {
        return this.inventory;
    }

    public boolean hasInventoryChanged(Container inventory) {
        return this.inventory != inventory;
    }

}