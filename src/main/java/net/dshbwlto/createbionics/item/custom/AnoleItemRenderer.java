package net.dshbwlto.createbionics.item.custom;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
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

public class AnoleItemRenderer extends CustomRenderedItemModelRenderer {

    private static final PartialModel CHEST = PartialModel.of(CreateBionics.asResource("item/anole_item_chest"));
    private static final PartialModel NECK = PartialModel.of(CreateBionics.asResource("item/anole_item_neck"));
    private static final PartialModel HEAD = PartialModel.of(CreateBionics.asResource("item/anole_item_head"));
    private static final PartialModel TAIL1 = PartialModel.of(CreateBionics.asResource("item/anole_item_tail1"));
    private static final PartialModel TAIL2 = PartialModel.of(CreateBionics.asResource("item/anole_item_tail2"));

    @Override
    protected void render(ItemStack stack, CustomRenderedItemModel model, PartialItemModelRenderer renderer, ItemDisplayContext transformType, PoseStack ms, MultiBufferSource buffer, int light, int overlay) {
        renderer.render(model.getOriginalModel(), light);
        float headYaw = Mth.sin(Mth.cos((AnimationTickHolder.getPartialTicks() + AnimationTickHolder.getTicks()) / 100f) * 1.6f);
        float tailYaw = Mth.sin((AnimationTickHolder.getTicks() + AnimationTickHolder.getPartialTicks()) / 20) / 10;

        if (transformType == ItemDisplayContext.THIRD_PERSON_LEFT_HAND || transformType == ItemDisplayContext.THIRD_PERSON_RIGHT_HAND) {

            ms.mulPose(Axis.XP.rotation(Mth.PI / 9));
            ms.mulPose(Axis.YP.rotation(tailYaw));
            renderer.render(TAIL1.get(), light);
            ms.translate(0, 0, 5 / 16f);
            ms.mulPose(Axis.XP.rotation(Mth.PI / 9));
            ms.mulPose(Axis.YP.rotation(tailYaw));
            renderer.render(TAIL2.get(), light);
            ms.mulPose(Axis.YP.rotation(-tailYaw));
            ms.mulPose(Axis.XP.rotation(Mth.PI / -9));
            ms.translate(0, 0, -5 / 16f);
            ms.mulPose(Axis.YP.rotation(-tailYaw));
            ms.mulPose(Axis.XP.rotation(Mth.PI / -9));

            ms.translate(0, 0, -3 / 16f);
            ms.mulPose(Axis.XP.rotation(Mth.PI / -9));
            renderer.render(CHEST.get(), light);
            ms.translate(0, 0, -3 / 16f);
            ms.mulPose(Axis.XP.rotation(Mth.PI / -9));
            ms.mulPose(Axis.YP.rotation(headYaw / 5));
            renderer.render(NECK.get(), light);
            ms.translate(0, 0, -1 / 8f);
            ms.mulPose(Axis.XP.rotation(Mth.PI / -18));
            ms.mulPose(Axis.YP.rotation(headYaw));
            renderer.render(HEAD.get(), light);
        } else if (transformType != (ItemDisplayContext.FIRST_PERSON_LEFT_HAND)
                && transformType != ItemDisplayContext.FIRST_PERSON_RIGHT_HAND ){

            ms.mulPose(Axis.YP.rotation(tailYaw - Mth.PI / 4));
            ms.translate(0,0.001f, 0);
            renderer.render(TAIL1.get(), light);
            ms.translate(0, 0.001f, 5 / 16f);
            ms.mulPose(Axis.YP.rotation(tailYaw - Mth.PI / 4));
            renderer.render(TAIL2.get(), light);
            ms.mulPose(Axis.YP.rotation(-tailYaw + Mth.PI /  4));
            ms.translate(0, -0.002f, -5 / 16f);
            ms.mulPose(Axis.YP.rotation(-tailYaw + Mth.PI / 4));

            ms.translate(0, 0, -3 / 16f);
            ms.mulPose(Axis.YP.rotation(Mth.PI / 8));
            renderer.render(CHEST.get(), light);
            ms.translate(0, 0, -3 / 16f);
            ms.mulPose(Axis.YP.rotation(Mth.PI / 8));
            renderer.render(NECK.get(), light);
            ms.translate(0, 0, -1 / 8f);
            ms.mulPose(Axis.YP.rotation(Mth.PI / 8));
            renderer.render(HEAD.get(), light);
        } else {
            ms.translate(0, 0, -3 / 16f);
            renderer.render(CHEST.get(), light);
            ms.translate(0, 0, -3 / 16f);
            ms.mulPose(Axis.XP.rotation(Mth.PI / -4));
            renderer.render(NECK.get(), light);
            ms.translate(0, 0, -1 / 8f);
            ms.mulPose(Axis.XP.rotation(Mth.PI / -8));
            renderer.render(HEAD.get(), light);
        }
    }
}
