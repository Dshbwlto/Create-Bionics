package net.dshbwlto.createbionics.entity.api;

import net.dshbwlto.createbionics.entity.custom.OrganEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.entity.PartEntity;

import javax.annotation.Nullable;

public class OrganEntityPart extends PartEntity<OrganEntity> {


    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        // No synched data for part entity
    }

    private final EntityDimensions size;
    public float scale = 1;

    public OrganEntityPart(OrganEntity parent, float sizeX, float sizeY) {
        super(parent);
        this.size = EntityDimensions.scalable(sizeX, sizeY);
        this.refreshDimensions();
    }

    public boolean fireImmune() {
        return true;
    }

    @Override
    public Vec3 getLeashOffset() {
        return new Vec3(0.0D, (double)this.getEyeHeight() * 0.15F, (double)(this.getBbWidth() * 0.1F));
    }

    public void collideWithNearbyEntities() {
    }

    public InteractionResult getEntityInteractionResult(Player player, InteractionHand hand) {
        return this.getParent() == null ? InteractionResult.PASS : this.getParent().mobInteract(player, hand);
    }

    public boolean canBeCollidedWith() {
        return false;
    }

    protected void collideWithEntity(Entity entityIn) {
        if(!(entityIn instanceof OrganEntity)){
            entityIn.push(this);
        }
    }

    public boolean isPickable() {
        return true;
    }


    @Nullable
    public ItemStack getPickResult() {
        Entity parent = this.getParent();
        return parent != null ? parent.getPickResult() : ItemStack.EMPTY;
    }

    public boolean hurt(DamageSource source, float amount) {
        return !this.isInvulnerableTo(source) && this.getParent().attackEntityPartFrom(this, source, amount);
    }

    public boolean is(Entity entityIn) {
        return this == entityIn || this.getParent() == entityIn;
    }

    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        throw new UnsupportedOperationException();
    }

    protected void defineSynchedData() {
    }

    public void tick(){
        super.tick();
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compound) {

    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compound) {

    }
}

