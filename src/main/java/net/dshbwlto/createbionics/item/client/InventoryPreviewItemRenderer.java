package net.dshbwlto.createbionics.item.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.simibubi.create.foundation.item.render.CustomRenderedItemModel;
import com.simibubi.create.foundation.item.render.CustomRenderedItemModelRenderer;
import com.simibubi.create.foundation.item.render.PartialItemModelRenderer;
import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.createmod.catnip.animation.AnimationTickHolder;
import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.component.BionicsDataComponentTypes;
import net.dshbwlto.createbionics.item.custom.InventoryPreviewItem;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

import java.util.Random;

public class InventoryPreviewItemRenderer extends CustomRenderedItemModelRenderer {

    @Override
    protected void render(ItemStack stack, CustomRenderedItemModel model, PartialItemModelRenderer renderer, ItemDisplayContext transformType, PoseStack ms, MultiBufferSource buffer, int light, int overlay) {
        InventoryPreviewItem item = (InventoryPreviewItem) stack.getItem();
        float tailYaw = Mth.sin((AnimationTickHolder.getTicks() + AnimationTickHolder.getPartialTicks()) / 20) / 10;

        if (((int) (AnimationTickHolder.getTicks() + AnimationTickHolder.getPartialTicks())) * 20 % 1200 == 0) {
            item.advanceRobot();
        }

        ms.mulPose(Axis.XN.rotation(-30 * Mth.PI / 180));
        ms.mulPose(Axis.YN.rotation(-135 * Mth.PI / 180));
        ms.translate(1.75f / 16, 0, 0);
        PartialModel body = PartialModel.of(CreateBionics.asResource("item/anole_item_" + item.variant));
        PartialModel body_marking = PartialModel.of(CreateBionics.asResource("item/anole_marking_" + item.marking));
        PartialModel chest = PartialModel.of(CreateBionics.asResource("item/anole_item_chest_" + item.variant));
        PartialModel chest_marking = PartialModel.of(CreateBionics.asResource("item/anole_marking_chest_" + item.marking));

        PartialModel neck = PartialModel.of(CreateBionics.asResource("item/anole_item_neck_" + item.variant));

        PartialModel head = PartialModel.of(CreateBionics.asResource("item/anole_item_head_" + item.variant));
        PartialModel head_marking = PartialModel.of(CreateBionics.asResource("item/anole_marking_head_" + item.marking));

        PartialModel tail1 = PartialModel.of(CreateBionics.asResource("item/anole_item_tail1_" + item.variant));
        PartialModel tail1_marking = PartialModel.of(CreateBionics.asResource("item/anole_marking_tail1_" + item.marking));

        PartialModel tail2 = PartialModel.of(CreateBionics.asResource("item/anole_item_tail2_" + item.variant));
        PartialModel tail2_marking = PartialModel.of(CreateBionics.asResource("item/anole_marking_tail2_" + item.marking));

        renderer.render(body.get(), light);
        ms.mulPose(Axis.YP.rotation(tailYaw - Mth.PI / 4));
        ms.translate(0,0.001f, 0);
        renderer.render(tail1.get(), light);
        ms.translate(0, 0.001f, 5 / 16f);
        ms.mulPose(Axis.YP.rotation(tailYaw - Mth.PI / 3.5f));
        renderer.render(tail2.get(), light);
        ms.mulPose(Axis.YP.rotation(-tailYaw + Mth.PI /  3.5f));
        ms.translate(0, -0.002f, -5 / 16f);
        ms.mulPose(Axis.YP.rotation(-tailYaw + Mth.PI / 4));
        ms.translate(0, 0, -3 / 16f);
        ms.mulPose(Axis.YP.rotation(Mth.PI / 8));
        renderer.render(chest.get(), light);
        ms.translate(0, 0, -3 / 16f);
        ms.mulPose(Axis.YP.rotation(Mth.PI / 8));
        renderer.render(neck.get(), light);
        ms.translate(0, 0, -1 / 8f);
        ms.mulPose(Axis.YP.rotation(Mth.PI / 8));
        renderer.render(head.get(), light);
    }
}
