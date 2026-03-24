package net.dshbwlto.createbionics.item.custom;

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
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class RepleteBodyItemRenderer extends CustomRenderedItemModelRenderer {

    private static final PartialModel REAR = PartialModel.of(CreateBionics.asResource("item/replete_body_item_rear"));
    private static final PartialModel CARAPACE_FRONT_L = PartialModel.of(CreateBionics.asResource("item/replete_body_item_carapace_front_l"));
    private static final PartialModel CARAPACE_FRONT_R = PartialModel.of(CreateBionics.asResource("item/replete_body_item_carapace_front_r"));
    private static final PartialModel CARAPACE_REAR_L = PartialModel.of(CreateBionics.asResource("item/replete_body_item_carapace_rear_l"));
    private static final PartialModel CARAPACE_REAR_R = PartialModel.of(CreateBionics.asResource("item/replete_body_item_carapace_rear_r"));
    private static final PartialModel JOINTS = PartialModel.of(CreateBionics.asResource("item/replete_body_joints"));

    //Idk why but the organ whistle parts only work if they're defined here first.
    //W Mojang and their highly skilled software developers.

    @Override
    protected void render(ItemStack stack, CustomRenderedItemModel model, PartialItemModelRenderer renderer, ItemDisplayContext transformType, PoseStack ms, MultiBufferSource buffer, int light, int overlay) {
        renderer.render(model.getOriginalModel(), light);
        float xOffset = -1 / 16f;

        ms.translate(0, 0, 2);
        renderer.render(REAR.get(), light);
        ms.translate(0, 0, -2);

        ms.mulPose(Axis.ZN.rotation(Mth.PI / -18));
        renderer.render(CARAPACE_FRONT_L.get(), light);
        ms.translate(0, 0, 1);
        renderer.render(CARAPACE_REAR_L.get(), light);
        ms.translate(0, 0, -1);
        ms.mulPose(Axis.ZN.rotation(Mth.PI / 18));

        ms.mulPose(Axis.ZN.rotation(Mth.PI / 18));
        renderer.render(CARAPACE_FRONT_R.get(), light);
        ms.translate(0, 0, 1);
        renderer.render(CARAPACE_REAR_R.get(), light);
        ms.translate(0, 0, -1);
        ms.mulPose(Axis.ZN.rotation(Mth.PI / -18));

        ms.translate(0,0,1);
        ms.mulPose(Axis.XN.rotation(Mth.PI / -14.4f));
        renderer.render(JOINTS.get(), light);
    }
}
