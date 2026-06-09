package net.dshbwlto.createbionics.ponder.api.element;

import net.createmod.ponder.Ponder;
import net.createmod.ponder.api.level.PonderLevel;
import net.createmod.ponder.foundation.PonderScene;
import net.dshbwlto.createbionics.entity.BionicsEntities;
import net.dshbwlto.createbionics.entity.client.oxhauler.OxhaulerVariant;
import net.dshbwlto.createbionics.entity.custom.OxhaulerEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Parrot;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.phys.Vec3;

public abstract class OxhaulerPose {

    public abstract void tick(PonderScene scene, OxhaulerEntity entity, Vec3 location);

    public OxhaulerEntity create(PonderLevel world) {
        OxhaulerEntity entity = new OxhaulerEntity(BionicsEntities.OXHAULER.get(), world);
        entity.setVariant(OxhaulerVariant.BRASS);
        return entity;
    }
}
