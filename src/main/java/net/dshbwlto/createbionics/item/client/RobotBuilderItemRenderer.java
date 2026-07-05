package net.dshbwlto.createbionics.item.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.simibubi.create.foundation.blockEntity.behaviour.scrollValue.ScrollValueHandler;
import com.simibubi.create.foundation.item.render.CustomRenderedItemModel;
import com.simibubi.create.foundation.item.render.CustomRenderedItemModelRenderer;
import com.simibubi.create.foundation.item.render.PartialItemModelRenderer;
import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.createmod.catnip.animation.AnimationTickHolder;
import net.dshbwlto.createbionics.CreateBionics;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class RobotBuilderItemRenderer extends CustomRenderedItemModelRenderer {

    private static final PartialModel GEAR = PartialModel.of(CreateBionics.asResource("item/robot_builder_gear"));

    //Idk why but partial models only work if they're defined here first.
    //W Mojang and their highly skilled software developers.

    private final PartialModel OXHAULER_FIRE = PartialModel.of(CreateBionics.asResource("item/oxhauler_fire"));
    private final PartialModel OXHAULER_SOUL_FIRE = PartialModel.of(CreateBionics.asResource("item/oxhauler_soul_fire"));

    private final PartialModel WHISTLE_BASE_MIDDLE_LARGE1 = PartialModel.of(CreateBionics.asResource("item/whistle_base_middle_large1"));
    private final PartialModel WHISTLE_BASE_MIDDLE_MEDIUM1 = PartialModel.of(CreateBionics.asResource("item/whistle_base_middle_medium1"));
    private final PartialModel WHISTLE_BASE_MIDDLE_SMALL1 = PartialModel.of(CreateBionics.asResource("item/whistle_base_middle_small1"));
    private final PartialModel WHISTLE_BASE_SIDE_LARGE1 = PartialModel.of(CreateBionics.asResource("item/whistle_base_side_large1"));
    private final PartialModel WHISTLE_BASE_SIDE_MEDIUM1 = PartialModel.of(CreateBionics.asResource("item/whistle_base_side_medium1"));
    private final PartialModel WHISTLE_BASE_SIDE_SMALL1 = PartialModel.of(CreateBionics.asResource("item/whistle_base_side_small1"));
    private final PartialModel WHISTLE_MIDDLE_LARGE1 = PartialModel.of(CreateBionics.asResource("item/whistle_middle_large1"));
    private final PartialModel WHISTLE_MIDDLE_MEDIUM1 = PartialModel.of(CreateBionics.asResource("item/whistle_middle_medium1"));
    private final PartialModel WHISTLE_MIDDLE_SMALL1 = PartialModel.of(CreateBionics.asResource("item/whistle_middle_small1"));
    private final PartialModel WHISTLE_END_LARGE1 = PartialModel.of(CreateBionics.asResource("item/whistle_end_large1"));
    private final PartialModel WHISTLE_END_MEDIUM1 = PartialModel.of(CreateBionics.asResource("item/whistle_end_medium1"));
    private final PartialModel WHISTLE_END_SMALL1 = PartialModel.of(CreateBionics.asResource("item/whistle_end_small1"));
    private final PartialModel WHISTLE_FACE_MIDDLE_LARGE1 = PartialModel.of(CreateBionics.asResource("item/whistle_face_middle_large1"));
    private final PartialModel WHISTLE_FACE_MIDDLE_MEDIUM1 = PartialModel.of(CreateBionics.asResource("item/whistle_face_middle_medium1"));

    private final PartialModel WHISTLE_BASE_MIDDLE_LARGE2 = PartialModel.of(CreateBionics.asResource("item/whistle_base_middle_large2"));
    private final PartialModel WHISTLE_BASE_MIDDLE_MEDIUM2 = PartialModel.of(CreateBionics.asResource("item/whistle_base_middle_medium2"));
    private final PartialModel WHISTLE_BASE_MIDDLE_SMALL2 = PartialModel.of(CreateBionics.asResource("item/whistle_base_middle_small2"));
    private final PartialModel WHISTLE_BASE_SIDE_LARGE2 = PartialModel.of(CreateBionics.asResource("item/whistle_base_side_large2"));
    private final PartialModel WHISTLE_BASE_SIDE_MEDIUM2 = PartialModel.of(CreateBionics.asResource("item/whistle_base_side_medium2"));
    private final PartialModel WHISTLE_BASE_SIDE_SMALL2 = PartialModel.of(CreateBionics.asResource("item/whistle_base_side_small2"));
    private final PartialModel WHISTLE_MIDDLE_LARGE2 = PartialModel.of(CreateBionics.asResource("item/whistle_middle_large2"));
    private final PartialModel WHISTLE_MIDDLE_MEDIUM2 = PartialModel.of(CreateBionics.asResource("item/whistle_middle_medium2"));
    private final PartialModel WHISTLE_MIDDLE_SMALL2 = PartialModel.of(CreateBionics.asResource("item/whistle_middle_small2"));
    private final PartialModel WHISTLE_END_LARGE2 = PartialModel.of(CreateBionics.asResource("item/whistle_end_large2"));
    private final PartialModel WHISTLE_END_MEDIUM2 = PartialModel.of(CreateBionics.asResource("item/whistle_end_medium2"));
    private final PartialModel WHISTLE_END_SMALL2 = PartialModel.of(CreateBionics.asResource("item/whistle_end_small2"));
    private final PartialModel WHISTLE_FACE_MIDDLE_LARGE2 = PartialModel.of(CreateBionics.asResource("item/whistle_face_middle_large2"));
    private final PartialModel WHISTLE_FACE_MIDDLE_MEDIUM2 = PartialModel.of(CreateBionics.asResource("item/whistle_face_middle_medium2"));

    private final PartialModel WHISTLE_BASE_MIDDLE_LARGE3 = PartialModel.of(CreateBionics.asResource("item/whistle_base_middle_large3"));
    private final PartialModel WHISTLE_BASE_MIDDLE_MEDIUM3 = PartialModel.of(CreateBionics.asResource("item/whistle_base_middle_medium3"));
    private final PartialModel WHISTLE_BASE_MIDDLE_SMALL3 = PartialModel.of(CreateBionics.asResource("item/whistle_base_middle_small3"));
    private final PartialModel WHISTLE_BASE_SIDE_LARGE3 = PartialModel.of(CreateBionics.asResource("item/whistle_base_side_large3"));
    private final PartialModel WHISTLE_BASE_SIDE_MEDIUM3 = PartialModel.of(CreateBionics.asResource("item/whistle_base_side_medium3"));
    private final PartialModel WHISTLE_BASE_SIDE_SMALL3 = PartialModel.of(CreateBionics.asResource("item/whistle_base_side_small3"));
    private final PartialModel WHISTLE_MIDDLE_LARGE3 = PartialModel.of(CreateBionics.asResource("item/whistle_middle_large3"));
    private final PartialModel WHISTLE_MIDDLE_MEDIUM3 = PartialModel.of(CreateBionics.asResource("item/whistle_middle_medium3"));
    private final PartialModel WHISTLE_MIDDLE_SMALL3 = PartialModel.of(CreateBionics.asResource("item/whistle_middle_small3"));
    private final PartialModel WHISTLE_END_LARGE3 = PartialModel.of(CreateBionics.asResource("item/whistle_end_large3"));
    private final PartialModel WHISTLE_END_MEDIUM3 = PartialModel.of(CreateBionics.asResource("item/whistle_end_medium3"));
    private final PartialModel WHISTLE_END_SMALL3 = PartialModel.of(CreateBionics.asResource("item/whistle_end_small3"));
    private final PartialModel WHISTLE_FACE_MIDDLE_LARGE3 = PartialModel.of(CreateBionics.asResource("item/whistle_face_middle_large3"));
    private final PartialModel WHISTLE_FACE_MIDDLE_MEDIUM3 = PartialModel.of(CreateBionics.asResource("item/whistle_face_middle_medium3"));

    private final PartialModel WHISTLE_BASE_MIDDLE_LARGE4 = PartialModel.of(CreateBionics.asResource("item/whistle_base_middle_large4"));
    private final PartialModel WHISTLE_BASE_MIDDLE_MEDIUM4 = PartialModel.of(CreateBionics.asResource("item/whistle_base_middle_medium4"));
    private final PartialModel WHISTLE_BASE_MIDDLE_SMALL4 = PartialModel.of(CreateBionics.asResource("item/whistle_base_middle_small4"));
    private final PartialModel WHISTLE_BASE_SIDE_LARGE4 = PartialModel.of(CreateBionics.asResource("item/whistle_base_side_large4"));
    private final PartialModel WHISTLE_BASE_SIDE_MEDIUM4 = PartialModel.of(CreateBionics.asResource("item/whistle_base_side_medium4"));
    private final PartialModel WHISTLE_BASE_SIDE_SMALL4 = PartialModel.of(CreateBionics.asResource("item/whistle_base_side_small4"));
    private final PartialModel WHISTLE_MIDDLE_LARGE4 = PartialModel.of(CreateBionics.asResource("item/whistle_middle_large4"));
    private final PartialModel WHISTLE_MIDDLE_MEDIUM4 = PartialModel.of(CreateBionics.asResource("item/whistle_middle_medium4"));
    private final PartialModel WHISTLE_MIDDLE_SMALL4 = PartialModel.of(CreateBionics.asResource("item/whistle_middle_small4"));
    private final PartialModel WHISTLE_END_LARGE4 = PartialModel.of(CreateBionics.asResource("item/whistle_end_large4"));
    private final PartialModel WHISTLE_END_MEDIUM4 = PartialModel.of(CreateBionics.asResource("item/whistle_end_medium4"));
    private final PartialModel WHISTLE_END_SMALL4 = PartialModel.of(CreateBionics.asResource("item/whistle_end_small4"));
    private final PartialModel WHISTLE_FACE_MIDDLE_LARGE4 = PartialModel.of(CreateBionics.asResource("item/whistle_face_middle_large4"));
    private final PartialModel WHISTLE_FACE_MIDDLE_MEDIUM4 = PartialModel.of(CreateBionics.asResource("item/whistle_face_middle_medium4"));

    private final PartialModel WHISTLE_BASE_MIDDLE_LARGE5 = PartialModel.of(CreateBionics.asResource("item/whistle_base_middle_large5"));
    private final PartialModel WHISTLE_BASE_MIDDLE_MEDIUM5 = PartialModel.of(CreateBionics.asResource("item/whistle_base_middle_medium5"));
    private final PartialModel WHISTLE_BASE_MIDDLE_SMALL5 = PartialModel.of(CreateBionics.asResource("item/whistle_base_middle_small5"));
    private final PartialModel WHISTLE_BASE_SIDE_LARGE5 = PartialModel.of(CreateBionics.asResource("item/whistle_base_side_large5"));
    private final PartialModel WHISTLE_BASE_SIDE_MEDIUM5 = PartialModel.of(CreateBionics.asResource("item/whistle_base_side_medium5"));
    private final PartialModel WHISTLE_BASE_SIDE_SMALL5 = PartialModel.of(CreateBionics.asResource("item/whistle_base_side_small5"));
    private final PartialModel WHISTLE_MIDDLE_LARGE5 = PartialModel.of(CreateBionics.asResource("item/whistle_middle_large5"));
    private final PartialModel WHISTLE_MIDDLE_MEDIUM5 = PartialModel.of(CreateBionics.asResource("item/whistle_middle_medium5"));
    private final PartialModel WHISTLE_MIDDLE_SMALL5 = PartialModel.of(CreateBionics.asResource("item/whistle_middle_small5"));
    private final PartialModel WHISTLE_END_LARGE5 = PartialModel.of(CreateBionics.asResource("item/whistle_end_large5"));
    private final PartialModel WHISTLE_END_MEDIUM5 = PartialModel.of(CreateBionics.asResource("item/whistle_end_medium5"));
    private final PartialModel WHISTLE_END_SMALL5 = PartialModel.of(CreateBionics.asResource("item/whistle_end_small5"));
    private final PartialModel WHISTLE_FACE_MIDDLE_LARGE5 = PartialModel.of(CreateBionics.asResource("item/whistle_face_middle_large5"));
    private final PartialModel WHISTLE_FACE_MIDDLE_MEDIUM5 = PartialModel.of(CreateBionics.asResource("item/whistle_face_middle_medium5"));

    private final PartialModel DEBUG_ARROW = PartialModel.of(CreateBionics.asResource("item/debug_arrow"));

    @Override
    protected void render(ItemStack stack, CustomRenderedItemModel model, PartialItemModelRenderer renderer, ItemDisplayContext transformType, PoseStack ms, MultiBufferSource buffer, int light, int overlay) {
            renderer.render(model.getOriginalModel(), light);

            float xOffset = -1/16f;
        ms.translate(-xOffset, 0, 0);
        ms.mulPose(Axis.YP.rotationDegrees(ScrollValueHandler.getScroll(AnimationTickHolder.getPartialTicks())));
        ms.translate(xOffset, 0, 0);

        renderer.render(GEAR.get(), light);
    }
}
