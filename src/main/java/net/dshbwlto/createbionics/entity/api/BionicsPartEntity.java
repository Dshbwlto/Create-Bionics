package net.dshbwlto.createbionics.entity.api;

import com.simibubi.create.api.equipment.goggles.IHaveGoggleInformation;
import com.simibubi.create.api.equipment.goggles.IHaveHoveringInformation;
import net.dshbwlto.createbionics.Util.TimeUtil;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.syncher.SynchedEntityData;
import net.neoforged.neoforge.entity.PartEntity;

import java.util.List;

public abstract class BionicsPartEntity<T extends Entity> extends PartEntity<T> implements IHaveGoggleInformation, IHaveHoveringInformation {

    public BionicsPartEntity(T parent) {
        super(parent);
        this.blocksBuilding = true;
    }

    @Override
    public boolean fireImmune() {
        return true;
    }

    @Override
    public InteractionResult interact(Player player, InteractionHand hand) {
        Entity parent = this.getParent();
        if (parent == null) {
            return InteractionResult.PASS;
        } else {
            return parent.interact(player, hand);
        }
    }

    @Override
    public boolean save(CompoundTag tag) {
        return false;
    }


    @Override
    public boolean canBeCollidedWith() {
        Entity parent = this.getParent();
        return parent != null && parent.canBeCollidedWith();
    }


    @Override
    public boolean isPickable() {
        Entity parent = this.getParent();
        return parent != null && parent.isPickable();
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        Entity parent = this.getParent();
        parent.hurt(source, amount);
        return false;
    }

    public boolean isPartOf(Entity entityIn) {
        return this == entityIn || this.getParent() == entityIn;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {

    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compound) {

    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compound) {

    }

    public boolean shouldBeSaved() {
        return false;
    }

    @Override
    public boolean addToGoggleTooltip(List<Component> tooltip, boolean isPlayerSneaking) {
        tooltip.add(Component.literal(""));

        tooltip.add(Component.translatable("entity.createbionics.tooltip.variant").append(Component.translatable("entity.createbionics.tooltip.variant_" + 4).setStyle(Style.EMPTY.withColor(16777215))));
        tooltip.add(Component.translatable("entity.createbionics.tooltip.torches").append(Component.literal("" + 16777215).setStyle(Style.EMPTY.withColor(16777215))));

        tooltip.add(Component.translatable("entity.createbionics.tooltip.fuel").append(TimeUtil.ticksToMinutes(565)).setStyle(Style.EMPTY.withColor(16777215)));

        return true;
    }
}