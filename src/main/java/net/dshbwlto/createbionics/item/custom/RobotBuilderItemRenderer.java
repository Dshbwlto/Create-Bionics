package net.dshbwlto.createbionics.item.custom;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.simibubi.create.Create;
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

    //Idk why but the organ whistle parts only work if they're defined here first.
    //W Mojang and their highly skilled software developers.

    private final PartialModel WHISTLE_BASE_MIDDLE_LARGE = PartialModel.of(CreateBionics.asResource("item/whistle_base_middle_large1"));
    private final PartialModel WHISTLE_BASE_MIDDLE_MEDIUM = PartialModel.of(CreateBionics.asResource("item/whistle_base_middle_medium1"));
    private final PartialModel WHISTLE_BASE_MIDDLE_SMALL = PartialModel.of(CreateBionics.asResource("item/whistle_base_middle_small1"));
    private final PartialModel WHISTLE_BASE_SIDE_LARGE = PartialModel.of(CreateBionics.asResource("item/whistle_base_side_large1"));
    private final PartialModel WHISTLE_BASE_SIDE_MEDIUM = PartialModel.of(CreateBionics.asResource("item/whistle_base_side_medium1"));
    private final PartialModel WHISTLE_BASE_SIDE_SMALL = PartialModel.of(CreateBionics.asResource("item/whistle_base_side_small1"));
    private final PartialModel WHISTLE_MIDDLE_LARGE = PartialModel.of(CreateBionics.asResource("item/whistle_middle_large1"));
    private final PartialModel WHISTLE_MIDDLE_MEDIUM = PartialModel.of(CreateBionics.asResource("item/whistle_middle_medium1"));
    private static final PartialModel WHISTLE_MIDDLE_SMALL = PartialModel.of(CreateBionics.asResource("item/whistle_middle_small1"));
    private final PartialModel WHISTLE_END_LARGE = PartialModel.of(CreateBionics.asResource("item/whistle_end_large1"));
    private final PartialModel WHISTLE_END_MEDIUM = PartialModel.of(CreateBionics.asResource("item/whistle_end_medium1"));
    private final PartialModel WHISTLE_END_SMALL = PartialModel.of(CreateBionics.asResource("item/whistle_end_small1"));
    private final PartialModel WHISTLE_FACE_MIDDLE_LARGE = PartialModel.of(CreateBionics.asResource("item/whistle_face_middle_large1"));
    private final PartialModel WHISTLE_FACE_MIDDLE_MEDIUM = PartialModel.of(CreateBionics.asResource("item/whistle_face_middle_medium1"));

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
