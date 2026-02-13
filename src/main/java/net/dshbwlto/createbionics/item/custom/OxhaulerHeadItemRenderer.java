package net.dshbwlto.createbionics.item.custom;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.simibubi.create.foundation.item.render.CustomRenderedItemModel;
import com.simibubi.create.foundation.item.render.CustomRenderedItemModelRenderer;
import com.simibubi.create.foundation.item.render.PartialItemModelRenderer;
import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.dshbwlto.createbionics.CreateBionics;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class OxhaulerHeadItemRenderer extends CustomRenderedItemModelRenderer {

    protected static final PartialModel HORNL1 = PartialModel.of(CreateBionics.asResource("item/oxhauler_head_hornl1"));
    protected static final PartialModel HORNR1 = PartialModel.of(CreateBionics.asResource("item/oxhauler_head_hornr1"));
    protected static final PartialModel HORNL2 = PartialModel.of(CreateBionics.asResource("item/oxhauler_head_hornl2"));
    protected static final PartialModel HORNR2 = PartialModel.of(CreateBionics.asResource("item/oxhauler_head_hornr2"));

    @Override
    protected void render(ItemStack stack, CustomRenderedItemModel model, PartialItemModelRenderer renderer, ItemDisplayContext transformType, PoseStack ms, MultiBufferSource buffer, int light, int overlay) {
            renderer.render(model.getOriginalModel(), light);

        ms.mulPose(Axis.ZP.rotationDegrees(-12.5f));
        ms.mulPose(Axis.YP.rotationDegrees(-10f));
        renderer.render(HORNL1.get(), light);
        ms.mulPose(Axis.YP.rotationDegrees(10f));
        ms.mulPose(Axis.ZP.rotationDegrees(12.5f));

        ms.mulPose(Axis.ZP.rotationDegrees(12.5f));
        ms.mulPose(Axis.YP.rotationDegrees(10f));
        renderer.render(HORNR1.get(), light);
        ms.mulPose(Axis.YP.rotationDegrees(-10f));
        ms.mulPose(Axis.ZP.rotationDegrees(-12.5f));

        ms.mulPose(Axis.ZP.rotationDegrees(-27.5f));
        ms.mulPose(Axis.YP.rotationDegrees(-27.5f));
        ms.mulPose(Axis.XP.rotationDegrees(7.5f));
        renderer.render(HORNL2.get(), light);
        ms.mulPose(Axis.XP.rotationDegrees(-7.5f));
        ms.mulPose(Axis.YP.rotationDegrees(27.5f));
        ms.mulPose(Axis.ZP.rotationDegrees(27.5f));


        ms.mulPose(Axis.ZP.rotationDegrees(27.5f));
        ms.mulPose(Axis.YP.rotationDegrees(27.5f));
        ms.mulPose(Axis.XP.rotationDegrees(7.5f));
        renderer.render(HORNR2.get(), light);
        ms.mulPose(Axis.XP.rotationDegrees(-7.5f));
        ms.mulPose(Axis.YP.rotationDegrees(-27.5f));
        ms.mulPose(Axis.ZP.rotationDegrees(-27.5f));

    }
}
