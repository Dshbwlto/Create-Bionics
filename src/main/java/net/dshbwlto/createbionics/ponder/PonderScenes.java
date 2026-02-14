package net.dshbwlto.createbionics.ponder;

import com.simibubi.create.foundation.ponder.CreateSceneBuilder;
import net.createmod.catnip.math.Pointing;
import net.createmod.ponder.api.PonderPalette;
import net.createmod.ponder.api.scene.SceneBuilder;
import net.createmod.ponder.api.scene.SceneBuildingUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class PonderScenes {
    public static void oxhaulerMiddle(SceneBuilder builder, SceneBuildingUtil util) {
        CreateSceneBuilder scene = new CreateSceneBuilder(builder);
        scene.title("electric_motor", "Generating Rotational Force using Electric Motors");
        scene.configureBasePlate(0, 0, 5);
        scene.world().showSection(util.select().layer(0), Direction.UP);

        BlockPos motor = util.grid().at(3, 1, 2);

        for (int i = 0; i < 3; i++) {
            scene.idle(5);
            scene.world().showSection(util.select().position(1 + i, 1, 2), Direction.DOWN);
        }

        scene.idle(10);
        scene.effects().rotationDirectionIndicator(motor);
        scene.overlay().showText(50)
                .text("Electric Motors are a compact and configurable source of Rotational Force")
                .placeNearTarget()
                .pointAt(util.vector().topOf(motor));
        scene.idle(50);


        scene.rotateCameraY(90);
        scene.idle(20);

        Vec3 blockSurface = util.vector().blockSurface(motor, Direction.EAST);
        AABB point = new AABB(blockSurface, blockSurface);
        AABB expanded = point.inflate(1 / 16f, 1 / 5f, 1 / 5f);

        scene.overlay().chaseBoundingBoxOutline(PonderPalette.WHITE, blockSurface, point, 1);
        scene.idle(1);
        scene.overlay().chaseBoundingBoxOutline(PonderPalette.WHITE, blockSurface, expanded, 60);
        scene.overlay().showControls(blockSurface, Pointing.DOWN, 60).scroll();
        scene.idle(20);

        scene.addKeyframe();
        scene.overlay().showText(70)
                .text("Scrolling on the back panel changes the RPM of the motors' rotational output")
                .placeNearTarget()
                .pointAt(blockSurface);
        scene.idle(10);
        scene.world().modifyKineticSpeed(util.select().fromTo(1, 1, 2, 3, 1, 2), f -> (4 * f));
        scene.effects().rotationSpeedIndicator(motor);
        scene.idle(70);

        scene.addKeyframe();
        scene.overlay().showText(70)
                .text("The Electric Motor requires a source of energy (fe)")
                .placeNearTarget()
                .pointAt(blockSurface);
        scene.idle(80);

        scene.overlay().showText(70)
                .text("The motors' energy consumption is determined by the set RPM")
                .placeNearTarget()
                .pointAt(blockSurface);
        scene.idle(80);
        scene.markAsFinished();


        scene.rotateCameraY(-90);
    }
}
