package net.dshbwlto.createbionics.entity.custom;

import com.simibubi.create.AllSoundEvents;
import com.simibubi.create.api.equipment.goggles.IHaveGoggleInformation;
import com.simibubi.create.api.equipment.goggles.IHaveHoveringInformation;
import com.simibubi.create.content.kinetics.base.IRotate;
import com.simibubi.create.foundation.item.TooltipHelper;
import com.simibubi.create.foundation.sound.SoundScapes;
import com.simibubi.create.foundation.utility.CreateLang;
import com.simibubi.create.infrastructure.config.AllConfigs;
import net.createmod.catnip.animation.AnimationTickHolder;
import net.createmod.catnip.lang.FontHelper;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.HoverEvent;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import org.jetbrains.annotations.Nullable;

import java.util.List;

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
