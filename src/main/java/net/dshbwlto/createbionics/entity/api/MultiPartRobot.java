package net.dshbwlto.createbionics.entity.api;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public abstract class MultiPartRobot<T extends MultiPartEntity<?>> extends AbstractRobot {
    public T[] parts; //Must be set in the constructor

    protected MultiPartRobot(EntityType<? extends MultiPartRobot<?>> entityType, Level level) {
        super(entityType, level);
        this.parts = createParts();
        registerParts();
    }

    protected abstract T[] createParts();

    public boolean hurtPart(T part, DamageSource source, float damage) {
        return this.hurt(source, damage);
    }

    public void resetPartOffsets() {
        for (T part : parts) {
            part.offsetFromParent();
        }
    }

    @Override
    public void setId(int id) {
        super.setId(id);
        for (int i = 0; i < this.parts.length; i++)
            this.parts[i].setId(id + i + 1);
    }

    @Override
    public T @NotNull [] getParts() {
        return parts;
    }

    @Override
    public boolean isMultipartEntity() {
        return true;
    }

    private void registerParts() {
        this.setId(ENTITY_COUNTER.getAndAdd(this.parts.length + 1) + 1);
    }
}

