package net.dshbwlto.createbionics.entity.part;

import net.dshbwlto.createbionics.entity.api.MultiPartRobot;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.entity.PartEntity;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class RobotPartEntity extends PartEntity<MultiPartRobot> {
    private final Entity connectedTo;
    public EntityDimensions size;
    public Vec3 parentOffset;
    public Item pickResult;
    public Boolean collision;

    //Adapted code from Duck-XYZ
    //Repo: https://github.com/Duck-XYZ/ducky_lib.git

    /**
     * Creates a new part for an entity to use, does not need to be registered as an entity type
     * @param parent the MultiPartMob that this part belongs to
     * @param width the width of this part
     * @param height the height of this part
     * @param xOffset the offset from parent along x-axis
     * @param yOffset the offset from parent along y-axis
     * @param zOffset the offset from parent along z-axis
     * @apiNote Where ever offset is used it assumes that the mob is facing the default direction when spawned. Mob rotating is handled by api.
     */

    public RobotPartEntity(MultiPartRobot parent, Entity connectedTo, float width, float height, double xOffset, double yOffset, double zOffset, Item pickResult, boolean canCollide) {
        super(parent);
        this.size = EntityDimensions.scalable(width, height);
        this.parentOffset = new Vec3(xOffset, yOffset, zOffset);
        this.pickResult = pickResult;
        this.collision = canCollide;
        this.connectedTo = connectedTo;
        this.refreshDimensions();
        this.offsetFromParent();
    }

    /**
     * Sets the dimensions of the hitbox being used.
     * @param width the width of the hitbox
     * @param height the height of the hitbox
     */
    public void setDimensions(float width, float height) {
        this.size = EntityDimensions.scalable(width, height);
        refreshDimensions();
    }
    /**
     * Offsets this entity from its parent by the currently saved offset
     */
    public void offsetFromParent() {
        offsetFromParent(parentOffset.x, parentOffset.y, parentOffset.z);
    }

    @Override
    public boolean canBeCollidedWith() {
        return collision;
    }

    /**
     * Offsets the entity from parent by given offset and saves the offset to be used by offsetFromParent()
     * @param x the offset along x-axis
     * @param y the offset along y-axis
     * @param z the offset along z-axis
     */
    public void offsetFromParentAndUpdate(double x, double y, double z) {
        this.parentOffset = new Vec3(x, y, z);
        offsetFromParent();
    }

    /**
     * Offsets the entity from parent by given offset but does not save the offset being used.
     * @param x the offset along x-axis
     * @param y the offset along y-axis
     * @param z the offset along z-axis
     * @see RobotPartEntity#offsetFromParentAndUpdate(double, double, double)
     */
    public void offsetFromParent(double x, double y, double z) {
        double rot = Math.toRadians(getParent().getYRot());
        double newX = x * Math.cos(rot) - z * Math.sin(rot);
        double newZ = z * Math.cos(rot) + x * Math.sin(rot);

        setPos(getParent().getX() + newX, getParent().getY() + y, getParent().getZ() + newZ);
    }

    /**
     * Set the position of the entity using world coordinates. Recommended to use offset helper methods instead.
     * @param x x coordinate in the world
     * @param y y coordinate in the world
     * @param z z coordinate in the world
     * @see RobotPartEntity#offsetFromParent()
     * @see RobotPartEntity#offsetFromParent(double, double, double)
     * @see RobotPartEntity#offsetFromParentAndUpdate(double, double, double)
     */
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

    /**
     * Checks if this entity can take damage, for handling damage to the entity use the hurtPart method
     * @param source The source of the damage
     * @param amount The amount of damage being dealt
     * @return true if entity could be hurt, false otherwise.
     * @see MultiPartRobot#hurtPart(RobotPartEntity, DamageSource, float)
     */
    @Override
    public boolean hurt(DamageSource source, float amount) {
        return !getParent().isInvulnerableTo(source) && getParent().hurtPart(this, source, amount);
    }

    /**
     * If players can get a pick result from middle-clicking this entity in creative.
     * @return true if pick result is obtainable, false otherwise
     */
    @Override
    public boolean isPickable() {
        return true;
    }

    /**
     * The ItemStack that the player is given when middle-clicking this entity in creative
     * @return The stack the player gets from middle-clicking, typically a spawn egg of the parent.
     */
    @Nullable
    @Override
    public ItemStack getPickResult() {
        return new ItemStack(this.pickResult);
    }

    /**
     * Checks if a given entity is part of its self
     * @param entity The entity if it matches
     * @return true if the given entity is part of the same MultiPartMob, false otherwise.
     */
    @Override
    public boolean is(Entity entity) {
        return entity == this || entity == getParent();
    }

    /**
     * Gets the size of this entity parts hitbox
     * @param pose the pose the entity is in
     * @return the dimensions of the hitbox
     */
    @Override
    public EntityDimensions getDimensions(Pose pose) {
        return size;
    }

    @Override
    public InteractionResult interact(Player player, InteractionHand hand) {
        return getParent().mobInteract(player, hand);
    }

    public float calculateAnimationAngle(float partialTicks, boolean pitch) {
        MultiPartRobot parent = this.getParent();
        float parentRot = parent == null ? 0 : (parent.yBodyRotO + (parent.yBodyRot - parent.yBodyRotO) * partialTicks);
        Vec3 connection = connectedTo.getPosition(partialTicks).add(0, connectedTo.getBbHeight() * 0.5F, 0);
        Vec3 center = centeredPosition(partialTicks);
        Vec3 offset = connection.subtract(center).normalize();
        Vec3 back = center.add(offset.scale(-1 * this.getBbWidth()));
        double d0 = connection.x - back.x;
        double d1 = connection.y - back.y;
        double d2 = connection.z - back.z;
        if (pitch) {
            double d3 = Mth.sqrt((float) (d0 * d0 + d2 * d2));
            return Mth.wrapDegrees((float) (-(Mth.atan2(d1, d3) * 180.0F / (float) Math.PI))) * 0.35F;
        } else {
            return (float) (Mth.atan2(d2, d0) * 57.2957763671875D) - 90.0F - parentRot;
        }
    }

    public Vec3 centeredPosition() {
        return this.position().add(0, this.getBbHeight() * 0.5F, 0);
    }

    public Vec3 centeredPosition(float partialTicks) {
        return this.getPosition(partialTicks).add(0, this.getBbHeight() * 0.5F, 0);
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