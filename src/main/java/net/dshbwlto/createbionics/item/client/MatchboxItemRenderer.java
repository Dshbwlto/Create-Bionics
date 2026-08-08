
package net.dshbwlto.createbionics.item.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.simibubi.create.foundation.item.render.CustomRenderedItemModel;
import com.simibubi.create.foundation.item.render.CustomRenderedItemModelRenderer;
import com.simibubi.create.foundation.item.render.PartialItemModelRenderer;
import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.component.BionicsDataComponentTypes;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class MatchboxItemRenderer extends CustomRenderedItemModelRenderer {

    @Override
    protected void render(ItemStack stack, CustomRenderedItemModel model, PartialItemModelRenderer renderer, ItemDisplayContext transformType, PoseStack ms, MultiBufferSource buffer, int light, int overlay) {
        int variant = stack.get(BionicsDataComponentTypes.VARIANT.get()) != null ? stack.get(BionicsDataComponentTypes.VARIANT.get()) : 2;

        PartialModel body = PartialModel.of(CreateBionics.asResource("item/matchbox_item_" + variant));

        renderer.render(body.get(), light);
    }
}
