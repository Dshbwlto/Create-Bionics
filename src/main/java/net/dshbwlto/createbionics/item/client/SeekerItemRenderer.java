
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

public class SeekerItemRenderer extends CustomRenderedItemModelRenderer {

    @Override
    protected void render(ItemStack stack, CustomRenderedItemModel model, PartialItemModelRenderer renderer, ItemDisplayContext transformType, PoseStack ms, MultiBufferSource buffer, int light, int overlay) {
        int variant = stack.get(BionicsDataComponentTypes.VARIANT.get()) != null ? stack.get(BionicsDataComponentTypes.VARIANT.get()) : 0;
        int pickaxe = stack.get(BionicsDataComponentTypes.MARKING.get()) != null ? stack.get(BionicsDataComponentTypes.MARKING.get()) : 0;

        PartialModel body = PartialModel.of(CreateBionics.asResource("item/seeker_item_" + variant));
        PartialModel body_pickaxe = PartialModel.of(CreateBionics.asResource("item/seeker_pickaxe_item_" + pickaxe));

        renderer.render(body.get(), light);
        renderer.render(body_pickaxe.get(), light);
    }
}
