package net.dshbwlto.createbionics.ponder.custom;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.foundation.ponder.CreateSceneBuilder;
import net.createmod.catnip.math.Pointing;
import net.createmod.ponder.api.element.ElementLink;
import net.createmod.ponder.api.element.EntityElement;
import net.createmod.ponder.api.scene.SceneBuilder;
import net.createmod.ponder.api.scene.SceneBuildingUtil;
import net.dshbwlto.createbionics.entity.BionicsEntities;
import net.dshbwlto.createbionics.entity.custom.OxhaulerEntity;
import net.dshbwlto.createbionics.entity.custom.RepleteEntity;
import net.dshbwlto.createbionics.item.BionicsItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.WalkAnimationState;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.phys.Vec3;

public class RepleteScenes {
    public static ElementLink<EntityElement> makeReplete(SceneBuilder scene, Vec3 pos) {
        return scene.world().createEntity(w -> {
            RepleteEntity entity = new RepleteEntity(BionicsEntities.REPLETE.get(), w);
            entity.setPos(pos.x, pos.y, pos.z);
            entity.xo = pos.x;
            entity.yo = pos.y;
            entity.zo = pos.z;
            WalkAnimationState animation = entity.walkAnimation;
            animation.update(-animation.position(), 1);
            animation.setSpeed(1);
            entity.yRotO = 90;
            entity.yBodyRot = 90;
            entity.yBodyRotO = 90;
            entity.setYRot(90);
            entity.yHeadRotO = 90;
            entity.yHeadRot = 90;
            entity.isInPonderScene = true;
            return entity;
        });
    }

    public static void repleteBuildSequence(SceneBuilder builder, SceneBuildingUtil util) {
        CreateSceneBuilder scene = new CreateSceneBuilder(builder);
        scene.title("replete_constructing", "Constructing a Replete");
        scene.configureBasePlate(0, 0, 7);
        scene.scaleSceneView(0.6f);
        scene.showBasePlate();

        BlockPos repletePos = util.grid().at(4, 1, 3);
        BlockPos middle = util.grid().at(2, 2, 3);
        BlockPos rear = util.grid().at(4, 2, 3);
        BlockPos front = util.grid().at(2, 2, 3);
        BlockPos head = util.grid().at(1, 2, 3);

        scene.idle(20);

        ElementLink<EntityElement> replete = makeReplete(scene, Vec3.atBottomCenterOf(repletePos));
        scene.overlay().showControls(util.vector().blockSurface(middle, Direction.UP), Pointing.DOWN, 30)
                .rightClick()
                .withItem(BionicsItems.REPLETE_BODY.asStack());

        scene.idle(40);

        scene.overlay().showText(40)
                .pointAt(util.vector().topOf(middle))
                .attachKeyFrame()
                .placeNearTarget()
                .text("Robots are constructed with their corresponding item.");

        scene.idle(60);

        scene.overlay().showControls(util.vector().blockSurface(middle, Direction.UP), Pointing.DOWN, 30)
                .rightClick()
                .withItem(BionicsItems.REPLETE_LEG.asStack().copyWithCount(6));
        scene.world().modifyEntity(replete, entity ->
            ((RepleteEntity) entity).showleg1L = true);
        scene.idle(2);

        scene.world().modifyEntity(replete, entity ->
            ((RepleteEntity) entity).showleg1R = true);
        scene.idle(2);

        scene.world().modifyEntity(replete, entity ->
            ((RepleteEntity) entity).showleg2L = true);
        scene.idle(2);

        scene.world().modifyEntity(replete, entity ->
            ((RepleteEntity) entity).showleg2R = true);
        scene.idle(2);

        scene.world().modifyEntity(replete, entity ->
            ((RepleteEntity) entity).showleg3L = true);
        scene.idle(2);

        scene.world().modifyEntity(replete, entity ->
            ((RepleteEntity) entity).showleg3R = true);
        scene.idle(40);

        scene.overlay().showControls(util.vector().blockSurface(rear, Direction.UP), Pointing.DOWN, 40)
                .rightClick()
                .withItem(AllBlocks.MECHANICAL_PUMP.asStack());
        scene.world().modifyEntity(replete, entity ->
            ((RepleteEntity) entity).showPump = true);
        scene.idle(60);

        scene.overlay().showControls(util.vector().blockSurface(rear, Direction.UP), Pointing.DOWN, 40)
                .rightClick()
                .withItem(AllBlocks.FLUID_TANK.asStack());
        scene.world().modifyEntity(replete, entity -> {
                    ((RepleteEntity) entity).showTank = true;
                    ((RepleteEntity) entity).showTankSingle = true;
                    ((RepleteEntity) entity).ponderTankOffset = -20;
                });
        scene.idle(5);

        scene.world().modifyEntity(replete, entity -> {
                    ((RepleteEntity) entity).showTankSingle = false;
                    ((RepleteEntity) entity).showTankBottom = true;
                    ((RepleteEntity) entity).showTankTop = true;
                    ((RepleteEntity) entity).ponderTankOffset = -32;
        });
        scene.idle(5);

        scene.world().modifyEntity(replete, entity -> {
                    ((RepleteEntity) entity).showTank3 = true;
                    ((RepleteEntity) entity).ponderTankOffset = -48;
                });
        scene.idle(5);

        scene.world().modifyEntity(replete, entity -> {
                    ((RepleteEntity) entity).showTank4 = true;
                    ((RepleteEntity) entity).ponderTankOffset = -64;
                });
        scene.idle(5);

        scene.world().modifyEntity(replete, entity -> {
                    ((RepleteEntity) entity).showTank5 = true;
                    ((RepleteEntity) entity).ponderTankOffset = -80;
                });
        scene.idle(40);

        scene.overlay().showText(40)
                .pointAt(util.vector().topOf(middle))
                .attachKeyFrame()
                .placeNearTarget()
                .text("Parts must be placed in the correct order.");
        scene.idle(60);

        scene.world().modifyEntity(replete, entity -> {
                ((RepleteEntity) entity).setFuel(10000);
                ((RepleteEntity) entity).spawnFireParticles(false, 2);
        });

        scene.overlay().showControls(util.vector().blockSurface(middle, Direction.UP), Pointing.DOWN, 30)
                .rightClick()
                .withItem(new ItemStack(Items.COAL));

        scene.idle(40);
    }
}
