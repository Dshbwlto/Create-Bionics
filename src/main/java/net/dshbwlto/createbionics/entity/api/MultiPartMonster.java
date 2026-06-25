package net.dshbwlto.createbionics.entity.api;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public abstract class MultiPartMonster<T extends MultiPartEntity<?>> extends Monster {
    public T[] parts; //Must be set in the constructor

    /**
     * Basic constructor for a Monster
     * @param entityType Type of entity that this class corresponds to
     * @param level Game world
     */
    protected MultiPartMonster(EntityType<? extends MultiPartMonster<?>> entityType, Level level) {
        super(entityType, level);
        this.parts = createParts();
        registerParts();
    }

    /**
     * Use this method to create all the parts and potentially assigning them to class properties if you wish to use them for damage amplifiers
     * @return Array of all the parts this entity uses
     */
    protected abstract T[] createParts();

    /**
     * Called when a part is hit, can be used to apply damage multipliers
     * @param part The part that was hit
     * @param source The source of the damage
     * @param damage the amount of damage dealt
     * @return true if damage was taken, false otherwise
     */
    public boolean hurtPart(T part, DamageSource source, float damage) {
        return this.hurt(source, damage);
    }

    /**
     * Call in tick method to keep the parts at the correct offsets while the mob moves
     */
    public void resetPartOffsets() {
        for (T part : parts) {
            part.offsetFromParent();
        }
    }

    /**
     * Gives each part a unique ID to differentiate them.
     * @param id the id to assign the mob itself, parts are automatically assigned ids using this.
     */
    @Override
    public void setId(int id) {
        super.setId(id);
        for (int i = 0; i < this.parts.length; i++)
            this.parts[i].setId(id + i + 1);
    }

    /**
     * Gets the full list of parts
     * @return array of parts for this mob
     */
    @Override
    public T @NotNull [] getParts() {
        return parts;
    }

    /**
     * Specifies that this mob is multipart
     * @return true if multipart, false otherwise.
     */
    @Override
    public boolean isMultipartEntity() {
        return true;
    }

    /**
     * Called after creating the parts array so that all the parts are assigned IDs
     */
    private void registerParts() {
        this.setId(ENTITY_COUNTER.getAndAdd(this.parts.length + 1) + 1);
    }
}