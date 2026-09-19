
package net.dshbwlto.createbionics.entity.custom;

import net.createmod.catnip.animation.AnimationTickHolder;
import net.dshbwlto.createbionics.entity.api.MultiPartRobot;
import net.dshbwlto.createbionics.entity.part.RobotPartEntity;
import net.dshbwlto.createbionics.item.BionicsItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.fluids.FluidType;
import org.jetbrains.annotations.Nullable;

public class SharkEntity extends MultiPartRobot<RobotPartEntity> {

    public boolean turning_y;
    public float yRot0 = 0;
    public float yDir0 = 0;
    public float tail1Y;
    public float tail2Y;
    public float tail3Y;
    public float tail4Y;
    public float tail5Y;

    public boolean turning_x;
    public float xRot0 = 0;
    public float xDir0 = 0;
    public float tail1X;
    public float tail2X;
    public float tail3X;
    public float tail4X;
    public float tail5X;

    public SharkEntity(EntityType<MultiPartRobot<?>> entityType, Level level) {
        super(entityType, level);
        this.moveControl = new SmoothSwimmingMoveControl(this, 85, 2, 0.02F, 0.1F, false);
        this.lookControl = new SmoothSwimmingLookControl(this, 2);
        this.setPathfindingMalus(PathType.WATER, 0.0F);
    }

    @Override
    protected RobotPartEntity[] createParts() {
        return new RobotPartEntity[]{};
    }

    @Override
    public boolean canDrownInFluidType(FluidType type) {
        return false;
    }

    @Override
    public void registerGoals() {
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, (double)1.2F, true));
        this.goalSelector.addGoal(2, new RandomSwimmingGoal(this, (double)1, 100){
            @Override
            public boolean canUse() {
                if (this.mob.hasControllingPassenger()) {
                    return false;
                } else {
                    if (random.nextFloat() < 0.1) {
                        Vec3 vec3 = this.getPosition();
                        if (vec3 == null) {
                            return false;
                        } else {
                            this.wantedX = vec3.x;
                            this.wantedY = vec3.y;
                            this.wantedZ = vec3.z;
                            this.forceTrigger = false;
                            return true;
                        }
                    } else {
                        return true;
                    }
                }
            }
        });
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, PathfinderMob.class, false));
    }

    @Override
    public void travel(Vec3 travelVector) {
        if (this.isControlledByLocalInstance() && this.isInWater()) {
            this.moveRelative(0.1F, travelVector);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.9));
        } else {
            super.travel(travelVector);
        }
    }

    protected PathNavigation createNavigation(Level level) {
        return new WaterBoundPathNavigation(this, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 1)
                .add(Attributes.MOVEMENT_SPEED, 0.25d)
                .add(Attributes.FOLLOW_RANGE, 30)
                .add(Attributes.KNOCKBACK_RESISTANCE, 100d)
                .add(Attributes.ATTACK_DAMAGE, 30)
                .add(Attributes.ENTITY_INTERACTION_RANGE, 40);
    }

    @Override
    public boolean isFood(ItemStack itemStack) {
        return false;
    }

    @Override
    @Nullable
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob otherParent) {
        return null;
    }

    @Override
    public @Nullable ItemStack getPickResult() {
        return BionicsItems.ANOLE.asStack();
    }

    /* ANIMATIONS */

    @Override
    public void tick() {
        super.tick();

        turning_y = yRot0 != yBodyRot;
        yDir0 = yBodyRot - yRot0 > 0 ? 1 : -1;
        yRot0 = yBodyRot;

        turning_x = xRot0 != getXRot();
        xDir0 = getXRot() - xRot0 > 0 ? 1 : -1;
        xRot0 = getXRot();
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        //super.defineSynchedData(builder);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
    }

    /* INTERACT */

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        return super.mobInteract(player, hand);
    }
}
