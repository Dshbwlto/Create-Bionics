package net.dshbwlto.createbionics.entity.custom;

import com.google.common.collect.UnmodifiableIterator;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.AllSoundEvents;
import com.simibubi.create.foundation.sound.SoundScapes;
import net.createmod.catnip.math.VecHelper;
import net.dshbwlto.createbionics.entity.api.RobotPartEntity;
import net.dshbwlto.createbionics.entity.api.MultiPartRobot;
import net.dshbwlto.createbionics.entity.client.oxhauler.OxhaulerColor;
import net.dshbwlto.createbionics.entity.client.oxhauler.OxhaulerVariant;
import net.dshbwlto.createbionics.item.BionicsItems;
import net.dshbwlto.createbionics.screen.custom.OxhaulerMenu;
import net.dshbwlto.createbionics.sound.BionicsSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.CommonHooks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.fluids.FluidType;
import org.jetbrains.annotations.Nullable;

public class OxhaulerEntity extends MultiPartRobot<RobotPartEntity<OxhaulerEntity>> implements ContainerListener, HasCustomInventoryScreen, OwnableEntity, PlayerRideableJumping, Saddleable {
    public final AnimationState idleAnimationState = new AnimationState();
    private int x0;
    public float y0;
    protected int gallopSoundCounter;
    protected boolean isJumping;
    protected float playerJumpPendingScale;
    protected boolean canGallop = true;

    public final AnimationState idleAnimation1 = new AnimationState();
    public final AnimationState idleAnimation2 = new AnimationState();
    public final AnimationState idleAnimation3 = new AnimationState();
    private int idleAnimationTimeout = 0;

    private static final EntityDataAccessor<Integer> COLOR =
            SynchedEntityData.defineId(OxhaulerEntity.class, EntityDataSerializers.INT);

    protected SimpleContainer inventory;

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

    private static final EntityDataAccessor<Boolean> HARVESTER =
            SynchedEntityData.defineId(OxhaulerEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> PLOUGH =
            SynchedEntityData.defineId(OxhaulerEntity.class, EntityDataSerializers.BOOLEAN);

    public float lastHealth = 0;
    public float currentHealth = 0;

    @Override
    public boolean isSaddleable() {
        return false;
    }

    @Override
    public void equipSaddle(ItemStack itemStack, @Nullable SoundSource soundSource) {

    }

    @Override
    public boolean isSaddled() {
        return true;
    }

    public int pageCount = 1;

    public OxhaulerEntity(EntityType<MultiPartRobot<?>> entityType, Level level) {
        super(entityType, level);
        this.createInventory();
    }

    @Override
    protected RobotPartEntity<OxhaulerEntity>[] createParts() {
        return new RobotPartEntity[0];
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

    public Item healItem() {
        return AllItems.BRASS_INGOT.get();
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
        } else if (itemStack.is(healItem()) && player.isShiftKeyDown() && getHealth() < getMaxHealth()) {
            setHealth(getHealth() + 8);
            playSound(SoundEvents.SMITHING_TABLE_USE);
            if (level().isClientSide) {
                return InteractionResult.CONSUME;
            } else {
                itemStack.shrink(1);
            }
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
        builder.define(COLOR, 5);
        builder.define(HARVESTER, false);
        builder.define(PLOUGH, false);
    }


    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Color", this.getTypeColor());
        compound.putBoolean("Harvester", isHarvester());
        compound.putBoolean("Plough", isPlough());

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

        this.entityData.set(COLOR, compound.getInt("Color"));
        this.entityData.set(HARVESTER, compound.getBoolean("Harvester"));
        this.entityData.set(PLOUGH, compound.getBoolean("Plough"));

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
        if (level().isClientSide) {
            for (int j = 0; j <= height; j++) {
                for (int i = -radius; i <= radius; i++) {
                    SoundScapes.play(SoundScapes.AmbienceGroup.COG, getOnPos().east(i).north(-i).above(j), (float) (1 / radius) * 10);
                    SoundScapes.play(SoundScapes.AmbienceGroup.KINETIC, getOnPos().east(i).north(-i).above(j), (float) (1 / radius) * 10);
                    SoundScapes.play(SoundScapes.AmbienceGroup.COG, getOnPos().north(i).east(-i).above(j), (float) (1 / radius) * 10);
                    SoundScapes.play(SoundScapes.AmbienceGroup.KINETIC, getOnPos().north(i).east(-i).above(j), (float) (1 / radius) * 10);
                }
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

    public Container getInventory() {
        return this.inventory;
    }

    public boolean hasInventoryChanged(Container inventory) {
        return this.inventory != inventory;
    }
    public void onPlayerJump(int jumpPower) {
        if (this.isSaddled()) {
            if (jumpPower < 0) {
                jumpPower = 0;
            }

            if (jumpPower >= 90) {
                this.playerJumpPendingScale = 1.0F;
            } else {
                this.playerJumpPendingScale = 0.4F + 0.4F * (float)jumpPower / 90.0F;
            }
        }

    }

    public boolean canJump() {
        return this.isSaddled();
    }

    public void handleStartJump(int jumpPower) {
    }

    public void handleStopJump() {
    }


    protected void doPlayerRide(Player player) {
        if (!this.level().isClientSide) {
            player.setYRot(this.getYRot());
            player.setXRot(this.getXRot());
            player.startRiding(this);
        }

    }

    protected void tickRidden(Player player, Vec3 travelVector) {
        super.tickRidden(player, travelVector);
        Vec2 vec2 = this.getRiddenRotation(player);
        this.setRot(vec2.y, vec2.x);
        this.yRotO = this.yBodyRot = this.yHeadRot = this.getYRot();
        if (this.isControlledByLocalInstance()) {
            if (travelVector.z <= (double)0.0F) {
                this.gallopSoundCounter = 0;
            }

            if (this.onGround()) {
                this.setIsJumping(false);
                if (this.playerJumpPendingScale > 0.0F && !this.isJumping()) {
                    this.executeRidersJump(this.playerJumpPendingScale, travelVector);
                }

                this.playerJumpPendingScale = 0.0F;
            }
        }

    }

    public void setIsJumping(boolean jumping) {
        this.isJumping = jumping;
    }
    public boolean isJumping() {
        return this.isJumping;
    }

    protected Vec2 getRiddenRotation(LivingEntity entity) {
        return new Vec2(entity.getXRot() * 0.5F, entity.getYRot());
    }

    protected Vec3 getRiddenInput(Player player, Vec3 travelVector) {
        if (this.onGround() && this.playerJumpPendingScale == 0.0F) {
            return Vec3.ZERO;
        } else {
            float f = player.xxa * 0.5F;
            float f1 = player.zza;
            if (f1 <= 0.0F) {
                f1 *= 0.25F;
            }

            return new Vec3((double)f, (double)0.0F, (double)f1);
        }
    }

    protected float getRiddenSpeed(Player player) {
        return (float)this.getAttributeValue(Attributes.MOVEMENT_SPEED);
    }

    protected void executeRidersJump(float playerJumpPendingScale, Vec3 travelVector) {
        double d0 = (double)this.getJumpPower(playerJumpPendingScale);
        Vec3 vec3 = this.getDeltaMovement();
        this.setDeltaMovement(vec3.x, d0, vec3.z);
        this.setIsJumping(true);
        this.hasImpulse = true;
        CommonHooks.onLivingJump(this);
        if (travelVector.z > (double)0.0F) {
            float f = Mth.sin(this.getYRot() * ((float)Math.PI / 180F));
            float f1 = Mth.cos(this.getYRot() * ((float)Math.PI / 180F));
            this.setDeltaMovement(this.getDeltaMovement().add((double)(-0.4F * f * playerJumpPendingScale), (double)0.0F, (double)(0.4F * f1 * playerJumpPendingScale)));
        }

    }

    protected void playStepSound(BlockPos pos, BlockState block) {
        if (!block.liquid()) {
            BlockState blockstate = this.level().getBlockState(pos.above());
            SoundType soundtype = block.getSoundType(this.level(), pos, this);
            if (blockstate.is(Blocks.SNOW)) {
                soundtype = blockstate.getSoundType(this.level(), pos, this);
            }

            if (this.isVehicle() && this.canGallop) {
                ++this.gallopSoundCounter;
                if (this.gallopSoundCounter > 5 && this.gallopSoundCounter % 3 == 0) {
                    this.playGallopSound(soundtype);
                } else if (this.gallopSoundCounter <= 5) {
                    this.playSound(SoundEvents.HORSE_STEP_WOOD, soundtype.getVolume() * 0.15F, soundtype.getPitch());
                }
            } else if (this.isWoodSoundType(soundtype)) {
                this.playSound(SoundEvents.HORSE_STEP_WOOD, soundtype.getVolume() * 0.15F, soundtype.getPitch());
            } else {
                this.playSound(SoundEvents.HORSE_STEP, soundtype.getVolume() * 0.15F, soundtype.getPitch());
            }
        }

    }

    @javax.annotation.Nullable
    public LivingEntity getControllingPassenger() {
        if (this.isSaddled()) {
            Entity entity = this.getFirstPassenger();
            if (entity instanceof Player) {
                return (Player)entity;
            }
        }

        return super.getControllingPassenger();
    }

    @javax.annotation.Nullable
    private Vec3 getDismountLocationInDirection(Vec3 direction, LivingEntity passenger) {
        double d0 = this.getX() + direction.x;
        double d1 = this.getBoundingBox().minY;
        double d2 = this.getZ() + direction.z;
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
        UnmodifiableIterator var10 = passenger.getDismountPoses().iterator();

        while(var10.hasNext()) {
            Pose pose = (Pose)var10.next();
            blockpos$mutableblockpos.set(d0, d1, d2);
            double d3 = this.getBoundingBox().maxY + (double)0.75F;

            while(true) {
                double d4 = this.level().getBlockFloorHeight(blockpos$mutableblockpos);
                if ((double)blockpos$mutableblockpos.getY() + d4 > d3) {
                    break;
                }

                if (DismountHelper.isBlockFloorValid(d4)) {
                    AABB aabb = passenger.getLocalBoundsForPose(pose);
                    Vec3 vec3 = new Vec3(d0, (double)blockpos$mutableblockpos.getY() + d4, d2);
                    if (DismountHelper.canDismountTo(this.level(), passenger, aabb.move(vec3))) {
                        passenger.setPose(pose);
                        return vec3;
                    }
                }

                blockpos$mutableblockpos.move(Direction.UP);
                if ((double)blockpos$mutableblockpos.getY() < d3) {
                    break;
                }
            }
        }

        return null;
    }

    public Vec3 getDismountLocationForPassenger(LivingEntity livingEntity) {
        Vec3 vec3 = getCollisionHorizontalEscapeVector((double)this.getBbWidth(), (double)livingEntity.getBbWidth(), this.getYRot() + (livingEntity.getMainArm() == HumanoidArm.RIGHT ? 90.0F : -90.0F));
        Vec3 vec31 = this.getDismountLocationInDirection(vec3, livingEntity);
        if (vec31 != null) {
            return vec31;
        } else {
            Vec3 vec32 = getCollisionHorizontalEscapeVector((double)this.getBbWidth(), (double)livingEntity.getBbWidth(), this.getYRot() + (livingEntity.getMainArm() == HumanoidArm.LEFT ? 90.0F : -90.0F));
            Vec3 vec33 = this.getDismountLocationInDirection(vec32, livingEntity);
            return vec33 != null ? vec33 : this.position();
        }
    }

    protected void playGallopSound(SoundType soundType) {
        this.playSound(SoundEvents.HORSE_GALLOP, soundType.getVolume() * 0.15F, soundType.getPitch());
    }

    private boolean isWoodSoundType(SoundType soundType) {
        return soundType == SoundType.WOOD || soundType == SoundType.NETHER_WOOD || soundType == SoundType.STEM || soundType == SoundType.CHERRY_WOOD || soundType == SoundType.BAMBOO_WOOD;
    }
}