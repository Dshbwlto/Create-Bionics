package net.dshbwlto.createbionics.item.api;

import com.mojang.blaze3d.vertex.PoseStack;
import com.simibubi.create.foundation.item.render.CustomRenderedItemModel;
import com.simibubi.create.foundation.item.render.CustomRenderedItemModelRenderer;
import com.simibubi.create.foundation.item.render.PartialItemModelRenderer;
import net.dshbwlto.createbionics.CreateBionics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class DevRenderedItemRenderer extends CustomRenderedItemModelRenderer {

    @Override
    protected void render(ItemStack stack, CustomRenderedItemModel model, PartialItemModelRenderer renderer, ItemDisplayContext transformType, PoseStack ms, MultiBufferSource buffer, int light, int overlay) {
        if (Minecraft.getInstance().player == null) {
            return;
        }
        if (CreateBionics.isDevUsername(Minecraft.getInstance().player.getName().getString())) {
            renderer.render(model.getOriginalModel(), light);
        }
    }
}
