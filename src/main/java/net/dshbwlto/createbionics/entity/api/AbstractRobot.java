
package net.dshbwlto.createbionics.entity.api;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.datafixers.util.Either;
import com.mojang.math.Axis;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.AllParticleTypes;
import com.simibubi.create.AllSoundEvents;
import com.simibubi.create.api.equipment.goggles.IHaveGoggleInformation;
import com.simibubi.create.api.equipment.goggles.IHaveHoveringInformation;
import com.simibubi.create.foundation.sound.SoundScapes;
import net.createmod.catnip.lang.FontHelper;
import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.Util.TimeUtil;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.font.FontSet;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.network.chat.Style;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.ClientHooks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.stream.Collectors;

public class AbstractRobot extends TamableAnimal implements IHaveGoggleInformation, IHaveHoveringInformation {

    public List<Component> tooltipComponent = new ArrayList<Component>();

    public int variantColor(int variant) {
        return variant == 0 ? 11184810
                : variant == 1 ? 0xF1DD79
                : variant == 2 ? 0xC9974C
                : variant == 3 ? 0x4f5656
                : variant == 4 ? 0x6d585d
                : variant == 5 ? 0x937661
                : variant == 6 ? 0x738b55
                : 0x58af92;
    }

    public int fuelColor(int fuel) {
        return getFuel() > 24000 ? 16733695
                : getFuel() > 12000 ? 0x93ebff
                : getFuel() > 0 ? 0xfc9903
                : 5592405;
    }
    public AbstractRobot(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
    }

    public static final EntityDataAccessor<Integer> VARIANT =
            SynchedEntityData.defineId(AbstractRobot.class, EntityDataSerializers.INT);
    public void setVariantNumber(int variant) {
        entityData.set(VARIANT, variant);
    }

    public static final EntityDataAccessor<Integer> FUEL_TIME =
            SynchedEntityData.defineId(AbstractRobot.class, EntityDataSerializers.INT);
    public int getFuel() {
        return entityData.get(FUEL_TIME);
    }
    public void setFuel(int fuel) {
        entityData.set(FUEL_TIME, fuel);
    }
    public boolean isFueled() {
        return getFuel() > 0 || getFuel() == -1;
    }

    public static final EntityDataAccessor<Integer> ASSEMBLY =
            SynchedEntityData.defineId(AbstractRobot.class, EntityDataSerializers.INT);
    public int getAssembly() {
        return isAddedToLevel() ? this.entityData.get(ASSEMBLY) : 1000;
    }
    public void setAssembly(int assembly) {
        this.entityData.set(ASSEMBLY, assembly);
    }

    public static final EntityDataAccessor<Long> LAST_POSE_CHANGE_TICK =
            SynchedEntityData.defineId(AbstractRobot.class, EntityDataSerializers.LONG);
    public void resetLastPoseChangeTick(long lastPoseChangeTick) {
        this.entityData.set(LAST_POSE_CHANGE_TICK, lastPoseChangeTick);
    }

    public long getPoseTime() {
        return this.level().getGameTime() - Math.abs(this.entityData.get(LAST_POSE_CHANGE_TICK));
    }
    public boolean isInPoseTransition() {
        long i = this.getPoseTime();
        return i < (long) (this.isSitting() ? 40 : 52);
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

    /*COMMAND*/

    public static final EntityDataAccessor<Integer> COMMAND =
            SynchedEntityData.defineId(AbstractRobot.class, EntityDataSerializers.INT);
    public int getCommand() {
        return this.entityData.get(COMMAND);
    }

    public void setCommand(int command) {
        this.entityData.set(COMMAND, command);
    }

    public void updateCommand(Player player) {
        if (isFueled()) {
            this.setCommand(this.getCommand() + 1);
            if (this.getCommand() > 2) {
                this.setCommand(0);
            }
            if (player != null) {
                player.displayClientMessage(Component.translatable("entity.createbionics.all.command_" + this.getCommand(), this.getName()), true);
            }
            boolean sit = this.getCommand() == 2;
            if (sit) {
                sitDown(player);
            } else {
                standUp(player);
            }
        } else {
            sendFuelError(player);
        }
    }

    public void sitDown(Player player) {
        if (!this.isSitting()) {
            this.setPose(Pose.SITTING);
            this.gameEvent(GameEvent.ENTITY_ACTION);
            this.resetLastPoseChangeTick(-this.level().getGameTime());
        }
        setOrderedToSit(true);
        setInSittingPose(true);
    }

    public void standUp(Player player) {
        if (this.isSitting()) {
            this.setPose(Pose.STANDING);
            this.gameEvent(GameEvent.ENTITY_ACTION);
            this.resetLastPoseChangeTick(this.level().getGameTime());
        }
        setOrderedToSit(false);
        setInSittingPose(false);
    }

    public boolean isSitting() {
        return this.entityData.get(LAST_POSE_CHANGE_TICK) < 0L;
    }

    public boolean isVisuallySitting() {
        return this.getPoseTime() < 0L != this.isSitting();
    }

    public boolean isVisuallySittingDown() {
        return this.isSitting() && this.getPoseTime() < 40L && this.getPoseTime() >= 0L;
    }

    //MISC

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(LAST_POSE_CHANGE_TICK, 0L);
        builder.define(COMMAND, 0);
        builder.define(ASSEMBLY, 0);
        builder.define(FUEL_TIME, 0);


    }
    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putLong("LastPoseTick", this.entityData.get(LAST_POSE_CHANGE_TICK));
        compound.putInt("Command", this.entityData.get(COMMAND));
        compound.putInt("Assembly", this.entityData.get(ASSEMBLY));
        compound.putInt("Variant", this.entityData.get(VARIANT));
        compound.putInt("RefuelTime", this.getFuel());
    }
    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        long i = compound.getLong("LastPoseTick");
        if (i < 0L) {
            this.setPose(Pose.SITTING);
        }
        this.resetLastPoseChangeTick(i);
        entityData.set(COMMAND, compound.getInt("Command"));
        entityData.set(ASSEMBLY, compound.getInt("Assembly"));
        if (compound.getInt("Variant") == 4) {
            compound.putInt("Variant", 0);
        }
        entityData.set(VARIANT, compound.getInt("Variant"));
        entityData.set(FUEL_TIME, compound.getInt("RefuelTime"));
    }

    public void sendFuelError(Player player) {
        player.displayClientMessage(Component.translatable("entity.createbionics.all.fuel_warning1"), true);
        playSound(AllSoundEvents.DENY.getMainEvent(), 1, 0.2f);

    }

    public Item healItem() {
        return null;
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.COPPER_BREAK;
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

    public void spawnFireParticles (boolean blue, int radius) {
        ParticleOptions particle = blue ? ParticleTypes.SOUL_FIRE_FLAME : ParticleTypes.FLAME;
        for (int i = -2; i <= 2; i++) {
            for (int k = -2; k <= 2; k++) {
                level().addParticle(particle, getX(), getY(), getZ(), i / 50f * radius, random.nextFloat() / 10, k/50f * radius);
            }
        }
    }

    @Override
    public boolean isFood(ItemStack itemStack) {
        return false;
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return null;
    }
}
