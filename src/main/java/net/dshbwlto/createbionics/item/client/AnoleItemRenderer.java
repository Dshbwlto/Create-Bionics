
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
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

import java.util.Objects;

public class AnoleItemRenderer extends CustomRenderedItemModelRenderer {

    @Override
    protected void render(ItemStack stack, CustomRenderedItemModel model, PartialItemModelRenderer renderer, ItemDisplayContext transformType, PoseStack ms, MultiBufferSource buffer, int light, int overlay) {
        float headYaw = Mth.sin(Mth.cos((AnimationTickHolder.getPartialTicks() + AnimationTickHolder.getTicks()) / 100f) * 1.6f);
        float tailYaw = Mth.sin((AnimationTickHolder.getTicks() + AnimationTickHolder.getPartialTicks()) / 20) / 10;

        int variant = stack.get(BionicsDataComponentTypes.VARIANT.get()) != null ? stack.get(BionicsDataComponentTypes.VARIANT.get()) : 0;
        int marking = stack.get(BionicsDataComponentTypes.MARKING.get()) != null ? stack.get(BionicsDataComponentTypes.MARKING.get()) : 0;
        String s = stack.get(BionicsDataComponentTypes.NAME.get());
        int hat = ("Distinguished Gentleman".equals(s) || "Bill".equals(s)) ? 1
                : "Timmy".equals(s) ? 2
                : "Unicorn".equals(s) ? 3
                : ("Legend".equals(s) || "Techno".equals(s) || "Alex".equals(s)) ? 4
                : "Stampy".equals(s) ? 5
                : ("Doug".equals(s) || "Dimmadome".equals(s) || "Mayor".equals(s)) ? 6
                : "Cat in the Hat".equals(s) ? 7
                : "Sherlock".equals(s) ? 8
                : "Scallywag".equals(s) ? 9 : 0;

        PartialModel body = PartialModel.of(CreateBionics.asResource("item/anole_item_" + variant));
        PartialModel body_marking = PartialModel.of(CreateBionics.asResource("item/anole_marking_" + marking));

        PartialModel chest = PartialModel.of(CreateBionics.asResource("item/anole_item_chest_" + variant));
        PartialModel chest_marking = PartialModel.of(CreateBionics.asResource("item/anole_marking_chest_" + marking));

        PartialModel neck = PartialModel.of(CreateBionics.asResource("item/anole_item_neck_" + variant));

        PartialModel head = PartialModel.of(CreateBionics.asResource("item/anole_item_head_" + variant));
        PartialModel head_marking = PartialModel.of(CreateBionics.asResource("item/anole_marking_head_" + marking));
        PartialModel head_hat = PartialModel.of(CreateBionics.asResource("item/anole_item_hat_" + hat));

        PartialModel tail1 = PartialModel.of(CreateBionics.asResource("item/anole_item_tail1_" + variant));
        PartialModel tail1_marking = PartialModel.of(CreateBionics.asResource("item/anole_marking_tail1_" + marking));

        PartialModel tail2 = PartialModel.of(CreateBionics.asResource("item/anole_item_tail2_" + variant));
        PartialModel tail2_marking = PartialModel.of(CreateBionics.asResource("item/anole_marking_tail2_" + marking));

        renderer.render(body.get(), light);
        if (marking != 0) {
            renderer.render(body_marking.get(), light);
        }

        if (transformType == ItemDisplayContext.THIRD_PERSON_LEFT_HAND || transformType == ItemDisplayContext.THIRD_PERSON_RIGHT_HAND) {
            ms.mulPose(Axis.XP.rotation(Mth.PI / 9));
            ms.mulPose(Axis.YP.rotation(tailYaw));
            renderer.render(tail1.get(), light);
            renderer.render(tail1_marking.get(), light);
            ms.translate(0, 0, 5 / 16f);
            ms.mulPose(Axis.XP.rotation(Mth.PI / 9));
            ms.mulPose(Axis.YP.rotation(tailYaw));
            renderer.render(tail2.get(), light);
            renderer.render(tail2_marking.get(), light);
            ms.mulPose(Axis.YP.rotation(-tailYaw));
            ms.mulPose(Axis.XP.rotation(Mth.PI / -9));
            ms.translate(0, 0, -5 / 16f);
            ms.mulPose(Axis.YP.rotation(-tailYaw));
            ms.mulPose(Axis.XP.rotation(Mth.PI / -9));

            ms.translate(0, 0, -3 / 16f);
            ms.mulPose(Axis.XP.rotation(Mth.PI / -9));
            renderer.render(chest.get(), light);
            renderer.render(chest_marking.get(), light);
            ms.translate(0, 0, -3 / 16f);
            ms.mulPose(Axis.XP.rotation(Mth.PI / -9));
            ms.mulPose(Axis.YP.rotation(headYaw / 5));
            renderer.render(neck.get(), light);
            ms.translate(0, 0, -1 / 8f);
            ms.mulPose(Axis.XP.rotation(Mth.PI / -18));
            ms.mulPose(Axis.YP.rotation(headYaw));
            renderer.render(head.get(), light);
            renderer.render(head_marking.get(), light);
            renderer.render(head_hat.get(), light);
        } else if (transformType != (ItemDisplayContext.FIRST_PERSON_LEFT_HAND)
                && transformType != ItemDisplayContext.FIRST_PERSON_RIGHT_HAND ) {

            ms.mulPose(Axis.YP.rotation(tailYaw - Mth.PI / 4));
            ms.translate(0,0.001f, 0);
            renderer.render(tail1.get(), light);
            renderer.render(tail1_marking.get(), light);
            ms.translate(0, 0.001f, 5 / 16f);
            ms.mulPose(Axis.YP.rotation(tailYaw - Mth.PI / 3.5f));
            renderer.render(tail2.get(), light);
            renderer.render(tail2_marking.get(), light);
            ms.mulPose(Axis.YP.rotation(-tailYaw + Mth.PI /  3.5f));
            ms.translate(0, -0.002f, -5 / 16f);
            ms.mulPose(Axis.YP.rotation(-tailYaw + Mth.PI / 4));

            ms.translate(0, 0, -3 / 16f);
            ms.mulPose(Axis.YP.rotation(Mth.PI / 8));
            renderer.render(chest.get(), light);
            renderer.render(chest_marking.get(), light);
            ms.translate(0, 0, -3 / 16f);
            ms.mulPose(Axis.YP.rotation(Mth.PI / 8));
            renderer.render(neck.get(), light);
            ms.translate(0, 0, -1 / 8f);
            ms.mulPose(Axis.YP.rotation(Mth.PI / 8));
            renderer.render(head.get(), light);
            renderer.render(head_marking.get(), light);
            renderer.render(head_hat.get(), light);
        } else {
            ms.translate(0, 0, -3 / 16f);
            renderer.render(chest.get(), light);
            renderer.render(chest_marking.get(), light);
            ms.translate(0, 0, -3 / 16f);
            ms.mulPose(Axis.XP.rotation(Mth.PI / -4));
            renderer.render(neck.get(), light);
            ms.translate(0, 0, -1 / 8f);
            ms.mulPose(Axis.XP.rotation(Mth.PI / -8));
            renderer.render(head.get(), light);
            renderer.render(head_marking.get(), light);
            renderer.render(head_hat.get(), light);
        }
    }
}
