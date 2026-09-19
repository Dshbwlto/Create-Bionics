package net.dshbwlto.createbionics.ponder.custom;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.foundation.ponder.CreateSceneBuilder;
import net.createmod.catnip.math.Pointing;
import net.createmod.ponder.api.element.ElementLink;
import net.createmod.ponder.api.element.EntityElement;
import net.createmod.ponder.api.element.WorldSectionElement;
import net.createmod.ponder.api.scene.SceneBuilder;
import net.createmod.ponder.api.scene.SceneBuildingUtil;
import net.dshbwlto.createbionics.entity.BionicsEntities;
import net.dshbwlto.createbionics.entity.client.oxhauler.OxhaulerVariant;
import net.dshbwlto.createbionics.entity.custom.OxhaulerEntity;
import net.dshbwlto.createbionics.item.BionicsItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.WalkAnimationState;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.phys.Vec3;

public class OxhaulerScenes {
    public static ElementLink<EntityElement> makeOxhauler(SceneBuilder scene, DyeColor color, Vec3 pos) {
        return scene.world().createEntity(w -> {
            OxhaulerEntity entity = new OxhaulerEntity(BionicsEntities.OXHAULER.get(), w);
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

    public static void oxhaulerBuildSequence(SceneBuilder builder, SceneBuildingUtil util) {
        CreateSceneBuilder scene = new CreateSceneBuilder(builder);
        scene.title("oxhauler_constructing", "Constructing an Oxhauler");
        scene.configureBasePlate(0, 0, 7);
        scene.scaleSceneView(1.0f);
        scene.showBasePlate();

        BlockPos oxhaulerPos = util.grid().at(3, 1, 3);
        BlockPos middle = util.grid().at(3, 3, 3);
        BlockPos rear = util.grid().at(4, 2, 3);
        BlockPos front = util.grid().at(2, 2, 3);
        BlockPos head = util.grid().at(1, 2, 3);

        scene.idle(20);

        ElementLink<EntityElement> oxhauler = makeOxhauler(scene, DyeColor.RED, Vec3.atBottomCenterOf(oxhaulerPos));
        scene.overlay().showControls(util.vector().blockSurface(middle, Direction.UP), Pointing.DOWN, 30)
                .rightClick()
                .withItem(BionicsItems.OXHAULER_MIDDLE.asStack());

        scene.idle(40);

        scene.overlay().showText(50)
                .pointAt(util.vector().topOf(middle))
                .attachKeyFrame()
                .placeNearTarget()
                .text("Robots are constructed with their corresponding item.");

        scene.idle(60);

        scene.world().modifyEntity(oxhauler, entity ->
            ((OxhaulerEntity) entity).showRear = true);
        scene.overlay().showControls(util.vector().blockSurface(rear, Direction.UP), Pointing.DOWN, 30)
                .rightClick()
                .withItem(BionicsItems.OXHAULER_REAR.asStack());

        scene.idle(40);

        scene.world().modifyEntity(oxhauler, entity ->
            ((OxhaulerEntity) entity).showFront = true);
        scene.overlay().showControls(util.vector().blockSurface(front, Direction.UP), Pointing.DOWN, 30)
                .rightClick()
                .withItem(BionicsItems.OXHAULER_FRONT.asStack());

        scene.idle(40);

        scene.world().modifyEntity(oxhauler, entity ->
            ((OxhaulerEntity) entity).showHead = true);
        scene.overlay().showControls(util.vector().blockSurface(head, Direction.UP), Pointing.DOWN, 30)
                .rightClick()
                .withItem(BionicsItems.OXHAULER_HEAD.asStack());

        scene.idle(40);

        scene.overlay().showText(60)
                .pointAt(util.vector().topOf(middle))
                .attachKeyFrame()
                .placeNearTarget()
                .text("Parts must be placed in the correct order to assemble.");

        scene.idle(80);

        scene.world().modifyEntity(oxhauler, entity -> {
                ((OxhaulerEntity) entity).setFuel(10000);
                ((OxhaulerEntity) entity).spawnFireParticles(false, 2);
        });

        scene.overlay().showControls(util.vector().blockSurface(middle, Direction.UP), Pointing.DOWN, 30)
                .rightClick()
                .withItem(new ItemStack(Items.COAL))
                .withItem(new ItemStack(Items.COAL));

        scene.idle(40);
    }

    public static void oxhaulerFarming(SceneBuilder builder, SceneBuildingUtil util) {
        CreateSceneBuilder scene = new CreateSceneBuilder(builder);
        scene.title("oxhauler_farming", "Farming with an Oxhauler");
        scene.configureBasePlate(0, 0, 21);
        scene.scaleSceneView(0.5f);
        scene.showBasePlate();

        BlockPos oxhaulerPos = util.grid().at(10, 1, 10);
        BlockPos middle = util.grid().at(11, 3, 11);
        BlockPos target1 = util.grid().at(4, 3, 11);

        scene.idle(20);

        ElementLink<EntityElement> oxhauler = makeOxhauler(scene, DyeColor.RED, Vec3.atBottomCenterOf(oxhaulerPos));
        scene.world().modifyEntity(oxhauler, entity -> {
            ((OxhaulerEntity) entity).setFuel(10000);
            ((OxhaulerEntity) entity).showRear = true;
            ((OxhaulerEntity) entity).showFront = true;
            ((OxhaulerEntity) entity).showHead = true;
        });

        scene.idle(10);

        scene.addKeyframe();
        scene.overlay().showControls(util.vector().blockSurface(middle, Direction.UP), Pointing.DOWN, 30)
                .rightClick()
                .withItem(AllBlocks.MECHANICAL_HARVESTER.asStack());

        scene.idle(5);

        scene.world().modifyEntity(oxhauler, entity ->
            (entity).getEntityData().set(((OxhaulerEntity) entity).PLOUGH, true));

        scene.idle(40);

        scene.overlay().showText(50)
                .pointAt(util.vector().topOf(middle))
                .attachKeyFrame()
                .placeNearTarget()
                .text("Use a Mechanical Plough to give your Oxhauler a plough attachment.");

        scene.idle(60);
    }
}
