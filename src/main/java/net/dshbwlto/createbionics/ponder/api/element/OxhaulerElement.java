package net.dshbwlto.createbionics.ponder.api.element;

import net.createmod.ponder.api.element.AnimatedSceneElement;
import net.createmod.ponder.api.element.ParrotPose;
import net.minecraft.world.phys.Vec3;

public interface OxhaulerElement extends AnimatedSceneElement {
    void setPositionOffset(Vec3 position, boolean immediate);

    void setRotation(Vec3 eulers, boolean immediate);

    Vec3 getPositionOffset();

    Vec3 getRotation();

    void setPose(OxhaulerPose pose);
}
