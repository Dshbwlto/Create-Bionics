
package net.dshbwlto.createbionics.entity.custom;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.api.equipment.goggles.IHaveGoggleInformation;
import com.simibubi.create.api.equipment.goggles.IHaveHoveringInformation;
import com.simibubi.create.foundation.sound.SoundScapes;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.Nullable;

public class AbstractRobot extends TamableAnimal implements IHaveGoggleInformation, IHaveHoveringInformation {
    protected AbstractRobot(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
    }

    public static final EntityDataAccessor<Integer> VARIANT =
            SynchedEntityData.defineId(AbstractRobot.class, EntityDataSerializers.INT);

    public static final EntityDataAccessor<Integer> ASSEMBLY =
            SynchedEntityData.defineId(AbstractRobot.class, EntityDataSerializers.INT);
    public int getAssembly() {
        return this.entityData.get(ASSEMBLY);
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
        if (random.nextBoolean() && assembly >= targetAssembly) {
            return item;
        } else if (random.nextBoolean()) {
            return randomSalvage();
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
        this.setCommand(this.getCommand() + 1);
        if (this.getCommand() > 2) {
            this.setCommand(0);
        }
        player.displayClientMessage(Component.translatable("entity.createbionics.all.command_" + this.getCommand(), this.getName()), true);
        boolean sit = this.getCommand() == 2;
        if (sit) {
            sitDown(player);
        } else {
            standUp(player);
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
        builder.define(VARIANT, 0);
    }
    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putLong("LastPoseTick", this.entityData.get(LAST_POSE_CHANGE_TICK));
        compound.putInt("Command", this.entityData.get(COMMAND));
        compound.putInt("Assembly", this.entityData.get(ASSEMBLY));
        compound.putInt("Variant", this.entityData.get(VARIANT));
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
        entityData.set(VARIANT, compound.getInt("Variant"));
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.COPPER_BREAK;
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

    public boolean canDebugSwapSkins() {
        if (isTame() && getOwner() instanceof Player player) {
            String s = ChatFormatting.stripFormatting(this.getName().getString());
            String d = ChatFormatting.stripFormatting(player.getName().getString());
            return "ωωωω".equals(s) && ("Dshbwlto".equals(d) || "ilikefrogs31".equals(d) || "Dev".equals(d));
        } else {
            return false;
        }
    }

    //HOVER//

    @Override
    public boolean isFood(ItemStack itemStack) {
        return false;
    }
    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return null;
    }
}
