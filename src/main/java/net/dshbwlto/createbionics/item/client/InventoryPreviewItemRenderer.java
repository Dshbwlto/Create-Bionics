package net.dshbwlto.createbionics.item.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.simibubi.create.foundation.item.render.CustomRenderedItemModel;
import com.simibubi.create.foundation.item.render.CustomRenderedItemModelRenderer;
import com.simibubi.create.foundation.item.render.PartialItemModelRenderer;
import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.createmod.catnip.animation.AnimationTickHolder;
import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.item.custom.InventoryPreviewItem;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class InventoryPreviewItemRenderer extends CustomRenderedItemModelRenderer {

    public void transformAnole(PoseStack ms) {
        ms.mulPose(Axis.XP.rotationDegrees(30));
        ms.mulPose(Axis.YP.rotationDegrees(135));
        ms.translate(1.5/16f, 0, 0);
    }
    public void transformSeeker(PoseStack ms) {
        ms.mulPose(Axis.XP.rotationDegrees(30));
        ms.mulPose(Axis.YP.rotationDegrees(135));
        ms.translate(0, 5/16f, 0);
        //ms.scale(0.73f, 0.73f, 0.73f);
    }
    public void transformMatchbox(PoseStack ms) {
        ms.mulPose(Axis.XP.rotationDegrees(30));
        ms.mulPose(Axis.YP.rotationDegrees(135));
        ms.translate(1.5/16f, 0, 0);
        ms.scale(0.73f, 0.73f, 0.73f);
    }
    public void transformOxhauler(PoseStack ms) {
        ms.mulPose(Axis.XP.rotationDegrees(30));
        ms.mulPose(Axis.YP.rotationDegrees(135));
        ms.translate(-0.2, 0, 0);
        ms.scale(0.5f, 0.5f, 0.5f);
    }
    public void transformReplete(PoseStack ms) {
        ms.mulPose(Axis.XP.rotationDegrees(30));
        ms.mulPose(Axis.YP.rotationDegrees(135));
        ms.translate(0.1, -0.2, 0);
        ms.scale(0.3f, 0.3f, 0.3f);
    }

    @Override
    protected void render(ItemStack stack, CustomRenderedItemModel model, PartialItemModelRenderer renderer, ItemDisplayContext transformType, PoseStack ms, MultiBufferSource buffer, int light, int overlay) {
        InventoryPreviewItem item = (InventoryPreviewItem) stack.getItem();
        AnoleItemRenderer anoleItemRenderer = new AnoleItemRenderer();
        MatchboxItemRenderer matchboxItemRenderer = new MatchboxItemRenderer();
        SeekerItemRenderer seekerItemRenderer = new SeekerItemRenderer();
        RepleteBodyItemRenderer repleteBodyItemRenderer = new RepleteBodyItemRenderer();
        OxhaulerHeadItemRenderer oxhaulerHeadItemRenderer = new OxhaulerHeadItemRenderer();

        int i = AnimationTickHolder.getTicks() % 200 < 40 ? 1 : AnimationTickHolder.getTicks() % 200 < 80 ? 2 : AnimationTickHolder.getTicks() % 200 < 120 ? 3 : AnimationTickHolder.getTicks() % 200 < 160 ? 4 : 5;

        if (i == 1) {
            transformAnole(ms);
            anoleItemRenderer.render(stack, model, renderer, transformType, ms, buffer, light, overlay);
        } else if (i == 2) {
            transformSeeker(ms);
            seekerItemRenderer.render(stack, model, renderer, transformType, ms, buffer, light, overlay);
        } else if (i == 3) {
            transformMatchbox(ms);
            matchboxItemRenderer.render(stack, model, renderer, transformType, ms, buffer, light, overlay);
        } else if (i == 4) {
            transformOxhauler(ms);
            oxhaulerHeadItemRenderer.render(stack, model, renderer, transformType, ms, buffer, light, overlay);
        } else {
            transformReplete(ms);
            repleteBodyItemRenderer.render(stack, model, renderer, transformType, ms, buffer, light, overlay);
        }
    }
}
