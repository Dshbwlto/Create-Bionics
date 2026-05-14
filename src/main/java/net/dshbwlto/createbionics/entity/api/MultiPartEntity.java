package net.dshbwlto.createbionics.entity.api;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.entity.PartEntity;
import org.jetbrains.annotations.NotNull;

public class MultiPartEntity<T extends MultiPartRobot> extends PartEntity<T> {
    public EntityDimensions size;
    public Vec3 parentOffset;

    public MultiPartEntity(@NotNull T parent, float width, float height, double xOffset, double yOffset, double zOffset) {
        super(parent);
        this.size = EntityDimensions.scalable(width, height);
        this.parentOffset = new Vec3(xOffset, yOffset, zOffset);
        this.refreshDimensions();
        this.offsetFromParent();
    }

    public void setDimensions(float width, float height) {
        this.size = EntityDimensions.scalable(width, height);
        refreshDimensions();
    }

    public void offsetFromParent() {
        offsetFromParent(parentOffset.x, parentOffset.y, parentOffset.z);
    }

    public void offsetFromParentAndUpdate(double x, double y, double z) {
        this.parentOffset = new Vec3(x, y, z);
        offsetFromParent();
    }

    public void offsetFromParent(double x, double y, double z) {
        double rot = Math.toRadians(getParent().getYRot());
        double newX = x * Math.cos(rot) - z * Math.sin(rot);
        double newZ = z * Math.cos(rot) + x * Math.sin(rot);

        setPos(getParent().getX() + newX, getParent().getY() + y, getParent().getZ() + newZ);
    }

    @Override
    public void setPos(double x, double y, double z) {
        super.setPos(x, y, z);
        this.xo = x;
        this.yo = y;
        this.zo = z;
        this.xOld = x;
        this.yOld = y;
        this.zOld = z;
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        return !getParent().isInvulnerableTo(source) && getParent().hurtPart(this, source, amount);
    }

    @Override
    public boolean isPickable() {
        return true;
    }

    @Override
    public ItemStack getPickResult() {
        return this.getParent().getPickResult();
    }

    @Override
    public boolean is(Entity entity) {
        return entity == this || entity == getParent();
    }

    @Override
    public EntityDimensions getDimensions(Pose pose) {
        return size;
    }

    @Override
    public boolean shouldBeSaved() {
        return  false;
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
}
