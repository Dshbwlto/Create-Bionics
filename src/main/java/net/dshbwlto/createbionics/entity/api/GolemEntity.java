package net.dshbwlto.createbionics.entity.api;


import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class GolemEntity extends MultiPartRobot<RobotPartEntity<GolemEntity>> {
    public RobotPartEntity<GolemEntity> leftArm;
    public RobotPartEntity<GolemEntity> rightArm;
    public RobotPartEntity<GolemEntity> torso;

    public GolemEntity(EntityType<MultiPartRobot<?>> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected RobotPartEntity<GolemEntity>[] createParts() {
        this.leftArm = new RobotPartEntity<>(this, 0.8f, 2.1f, 1.2f, 0.4f, 0f);
        this.rightArm = new RobotPartEntity<>(this, 0.8f, 2.1f, -1.2f, 0.4f, 0f);
        this.torso = new RobotPartEntity<>(this, 2f, 2f, 0f, 1f, 2f);
        return new RobotPartEntity[]{this.leftArm, this.rightArm, this.torso};
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new RandomStrollGoal(this, 1f));
        this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, Player.class, false));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1f, true));
    }

    @Override
    public boolean hurtPart(RobotPartEntity<GolemEntity> part, DamageSource source, float damage) {
        if (part == rightArm) return hurt(source, 100000f);
        return super.hurtPart(part, source, damage);
    }

    @Override
    public void tick() {
        resetPartOffsets();
        super.tick();
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
