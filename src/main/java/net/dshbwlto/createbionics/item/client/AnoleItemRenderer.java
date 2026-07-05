
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
    private static final PartialModel BODY_0 = PartialModel.of(CreateBionics.asResource("item/anole_item_0"));
    private static final PartialModel BODY_1 = PartialModel.of(CreateBionics.asResource("item/anole_item_1"));
    private static final PartialModel BODY_2 = PartialModel.of(CreateBionics.asResource("item/anole_item_2"));
    private static final PartialModel BODY_3 = PartialModel.of(CreateBionics.asResource("item/anole_item_3"));
    private static final PartialModel BODY_4 = PartialModel.of(CreateBionics.asResource("item/anole_item_4"));
    private static final PartialModel BODY_5 = PartialModel.of(CreateBionics.asResource("item/anole_item_5"));
    private static final PartialModel BODY_6 = PartialModel.of(CreateBionics.asResource("item/anole_item_6"));

    private static final PartialModel MARKING_1 = PartialModel.of(CreateBionics.asResource("item/anole_marking_1"));
    private static final PartialModel MARKING_2 = PartialModel.of(CreateBionics.asResource("item/anole_marking_2"));
    private static final PartialModel MARKING_3 = PartialModel.of(CreateBionics.asResource("item/anole_marking_3"));

    private static final PartialModel CHEST_0 = PartialModel.of(CreateBionics.asResource("item/anole_item_chest_0"));
    private static final PartialModel CHEST_1 = PartialModel.of(CreateBionics.asResource("item/anole_item_chest_1"));
    private static final PartialModel CHEST_2 = PartialModel.of(CreateBionics.asResource("item/anole_item_chest_2"));
    private static final PartialModel CHEST_3 = PartialModel.of(CreateBionics.asResource("item/anole_item_chest_3"));
    private static final PartialModel CHEST_4 = PartialModel.of(CreateBionics.asResource("item/anole_item_chest_4"));
    private static final PartialModel CHEST_5 = PartialModel.of(CreateBionics.asResource("item/anole_item_chest_5"));
    private static final PartialModel CHEST_6 = PartialModel.of(CreateBionics.asResource("item/anole_item_chest_6"));

    private static final PartialModel CHEST_MARKING_0 = PartialModel.of(CreateBionics.asResource("item/anole_marking_chest_0"));
    private static final PartialModel CHEST_MARKING_1 = PartialModel.of(CreateBionics.asResource("item/anole_marking_chest_1"));
    private static final PartialModel CHEST_MARKING_2 = PartialModel.of(CreateBionics.asResource("item/anole_marking_chest_2"));
    private static final PartialModel CHEST_MARKING_3 = PartialModel.of(CreateBionics.asResource("item/anole_marking_chest_3"));

    private static final PartialModel NECK_0 = PartialModel.of(CreateBionics.asResource("item/anole_item_neck_0"));
    private static final PartialModel NECK_1 = PartialModel.of(CreateBionics.asResource("item/anole_item_neck_1"));
    private static final PartialModel NECK_2 = PartialModel.of(CreateBionics.asResource("item/anole_item_neck_2"));
    private static final PartialModel NECK_3 = PartialModel.of(CreateBionics.asResource("item/anole_item_neck_3"));
    private static final PartialModel NECK_4 = PartialModel.of(CreateBionics.asResource("item/anole_item_neck_4"));
    private static final PartialModel NECK_5 = PartialModel.of(CreateBionics.asResource("item/anole_item_neck_5"));
    private static final PartialModel NECK_6 = PartialModel.of(CreateBionics.asResource("item/anole_item_neck_6"));

    private static final PartialModel HEAD_0 = PartialModel.of(CreateBionics.asResource("item/anole_item_head_0"));
    private static final PartialModel HEAD_1 = PartialModel.of(CreateBionics.asResource("item/anole_item_head_1"));
    private static final PartialModel HEAD_2 = PartialModel.of(CreateBionics.asResource("item/anole_item_head_2"));
    private static final PartialModel HEAD_3 = PartialModel.of(CreateBionics.asResource("item/anole_item_head_3"));
    private static final PartialModel HEAD_4 = PartialModel.of(CreateBionics.asResource("item/anole_item_head_4"));
    private static final PartialModel HEAD_5 = PartialModel.of(CreateBionics.asResource("item/anole_item_head_5"));
    private static final PartialModel HEAD_6 = PartialModel.of(CreateBionics.asResource("item/anole_item_head_6"));

    private static final PartialModel HAT_0 = PartialModel.of(CreateBionics.asResource("item/anole_item_hat_0"));
    private static final PartialModel HAT_1 = PartialModel.of(CreateBionics.asResource("item/anole_item_hat_1"));
    private static final PartialModel HAT_2 = PartialModel.of(CreateBionics.asResource("item/anole_item_hat_2"));
    private static final PartialModel HAT_3 = PartialModel.of(CreateBionics.asResource("item/anole_item_hat_3"));
    private static final PartialModel HAT_4 = PartialModel.of(CreateBionics.asResource("item/anole_item_hat_4"));
    private static final PartialModel HAT_5 = PartialModel.of(CreateBionics.asResource("item/anole_item_hat_5"));
    private static final PartialModel HAT_6 = PartialModel.of(CreateBionics.asResource("item/anole_item_hat_6"));
    private static final PartialModel HAT_7 = PartialModel.of(CreateBionics.asResource("item/anole_item_hat_7"));
    private static final PartialModel HAT_8 = PartialModel.of(CreateBionics.asResource("item/anole_item_hat_8"));
    private static final PartialModel HAT_9 = PartialModel.of(CreateBionics.asResource("item/anole_item_hat_9"));

    private static final PartialModel HEAD_MARKING_0 = PartialModel.of(CreateBionics.asResource("item/anole_marking_head_0"));
    private static final PartialModel HEAD_MARKING_1 = PartialModel.of(CreateBionics.asResource("item/anole_marking_head_1"));
    private static final PartialModel HEAD_MARKING_2 = PartialModel.of(CreateBionics.asResource("item/anole_marking_head_2"));
    private static final PartialModel HEAD_MARKING_3 = PartialModel.of(CreateBionics.asResource("item/anole_marking_head_3"));

    private static final PartialModel TAIL1_0 = PartialModel.of(CreateBionics.asResource("item/anole_item_tail1_0"));
    private static final PartialModel TAIL1_1 = PartialModel.of(CreateBionics.asResource("item/anole_item_tail1_1"));
    private static final PartialModel TAIL1_2 = PartialModel.of(CreateBionics.asResource("item/anole_item_tail1_2"));
    private static final PartialModel TAIL1_3 = PartialModel.of(CreateBionics.asResource("item/anole_item_tail1_3"));
    private static final PartialModel TAIL1_4 = PartialModel.of(CreateBionics.asResource("item/anole_item_tail1_4"));
    private static final PartialModel TAIL1_5 = PartialModel.of(CreateBionics.asResource("item/anole_item_tail1_5"));
    private static final PartialModel TAIL1_6 = PartialModel.of(CreateBionics.asResource("item/anole_item_tail1_6"));

    private static final PartialModel TAIL1_MARKING_0 = PartialModel.of(CreateBionics.asResource("item/anole_marking_tail1_0"));
    private static final PartialModel TAIL1_MARKING_1 = PartialModel.of(CreateBionics.asResource("item/anole_marking_tail1_1"));
    private static final PartialModel TAIL1_MARKING_2 = PartialModel.of(CreateBionics.asResource("item/anole_marking_tail1_2"));
    private static final PartialModel TAIL1_MARKING_3 = PartialModel.of(CreateBionics.asResource("item/anole_marking_tail1_3"));

    private static final PartialModel TAIL2_0 = PartialModel.of(CreateBionics.asResource("item/anole_item_tail2_0"));
    private static final PartialModel TAIL2_1 = PartialModel.of(CreateBionics.asResource("item/anole_item_tail2_1"));
    private static final PartialModel TAIL2_2 = PartialModel.of(CreateBionics.asResource("item/anole_item_tail2_2"));
    private static final PartialModel TAIL2_3 = PartialModel.of(CreateBionics.asResource("item/anole_item_tail2_3"));
    private static final PartialModel TAIL2_4 = PartialModel.of(CreateBionics.asResource("item/anole_item_tail2_4"));
    private static final PartialModel TAIL2_5 = PartialModel.of(CreateBionics.asResource("item/anole_item_tail2_5"));
    private static final PartialModel TAIL2_6 = PartialModel.of(CreateBionics.asResource("item/anole_item_tail2_6"));

    private static final PartialModel TAIL2_MARKING_0 = PartialModel.of(CreateBionics.asResource("item/anole_marking_tail2_0"));
    private static final PartialModel TAIL2_MARKING_1 = PartialModel.of(CreateBionics.asResource("item/anole_marking_tail2_1"));
    private static final PartialModel TAIL2_MARKING_2 = PartialModel.of(CreateBionics.asResource("item/anole_marking_tail2_2"));
    private static final PartialModel TAIL2_MARKING_3 = PartialModel.of(CreateBionics.asResource("item/anole_marking_tail2_3"));

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
