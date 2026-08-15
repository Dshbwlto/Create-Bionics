
package net.dshbwlto.createbionics.item.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.simibubi.create.foundation.item.render.CustomRenderedItemModel;
import com.simibubi.create.foundation.item.render.CustomRenderedItemModelRenderer;
import com.simibubi.create.foundation.item.render.PartialItemModelRenderer;
import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.Util.BionicsDataComponentTypes;
import net.dshbwlto.createbionics.Util.BionicsPartialModels;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class MatchboxItemRenderer extends CustomRenderedItemModelRenderer {

    @Override
    protected void render(ItemStack stack, CustomRenderedItemModel model, PartialItemModelRenderer renderer, ItemDisplayContext transformType, PoseStack ms, MultiBufferSource buffer, int light, int overlay) {
        int variant = stack.get(BionicsDataComponentTypes.VARIANT.get()) != null ? stack.get(BionicsDataComponentTypes.VARIANT.get()) : 2;
        int torches = stack.get(BionicsDataComponentTypes.VARIANT.get()) != null ? stack.get(BionicsDataComponentTypes.MISC_INT.get()) : 0;
        PartialModel body = PartialModel.of(CreateBionics.asResource("item/matchbox_item_" + variant));

        boolean torch1 = torches > 0;
        boolean torch2 = torches >= (256 / 8);
        boolean torch3 = torches >= (256 / 8) * 2;
        boolean torch4 = torches >= (256 / 8) * 3;
        boolean torch5 = torches >= (256 / 8) * 4;
        boolean torch6 = torches >= (256 / 8) * 5;
        boolean torch7 = torches >= (256 / 8) * 6;
        boolean torch8 = torches >= (256 / 8) * 7;

        renderer.render(body.get(), light);

        if (torch1) {
            ms.translate(-3 / 32f, 5 / 32f, 10 / 16f);
            renderer.render(BionicsPartialModels.MATCHBOX_PREVIEW_TORCH.get(), light);
            ms.translate(3 / 32f, -5 / 32f, -10 / 16f);
        }
        if (torch2) {
            ms.translate(3 / 32f, 5 / 32f, 10 / 16f);
            renderer.render(BionicsPartialModels.MATCHBOX_PREVIEW_TORCH.get(), light);
            ms.translate(-3 / 32f, -5 / 32f, -10 / 16f);
        }
        if (torch3) {
            ms.translate(-3 / 32f, 9 / 32f, 10 / 16f);
            renderer.render(BionicsPartialModels.MATCHBOX_PREVIEW_TORCH.get(), light);
            ms.translate(3 / 32f, -9 / 32f, -10 / 16f);
        }
        if (torch4) {
            ms.translate(3 / 32f, 9 / 32f, 10 / 16f);
            renderer.render(BionicsPartialModels.MATCHBOX_PREVIEW_TORCH.get(), light);
            ms.translate(-3 / 32f, -9 / 32f, -10 / 16f);
        }
        if (torch5) {
            ms.translate(-3 / 32f, 13 / 32f, 10 / 16f);
            renderer.render(BionicsPartialModels.MATCHBOX_PREVIEW_TORCH.get(), light);
            ms.translate(3 / 32f, -13 / 32f, -10 / 16f);
        }
        if (torch6) {
            ms.translate(3 / 32f, 13 / 32f, 10 / 16f);
            renderer.render(BionicsPartialModels.MATCHBOX_PREVIEW_TORCH.get(), light);
            ms.translate(-3 / 32f, -13 / 32f, -10 / 16f);
        }
        if (torch7) {
            ms.translate(-3 / 32f, 17 / 32f, 10 / 16f);
            renderer.render(BionicsPartialModels.MATCHBOX_PREVIEW_TORCH.get(), light);
            ms.translate(3 / 32f, -17 / 32f, -10 / 16f);
        }
        if (torch8) {
            ms.translate(3 / 32f, 17 / 32f, 10 / 16f);
            renderer.render(BionicsPartialModels.MATCHBOX_PREVIEW_TORCH.get(), light);
            ms.translate(-3 / 32f, -17 / 32f, -10 / 16f);
        }
    }
}
