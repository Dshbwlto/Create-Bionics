
package net.dshbwlto.createbionics.item.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.simibubi.create.foundation.item.render.CustomRenderedItemModel;
import com.simibubi.create.foundation.item.render.CustomRenderedItemModelRenderer;
import com.simibubi.create.foundation.item.render.PartialItemModelRenderer;
import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.dshbwlto.createbionics.CreateBionics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class OrganHeadItemRenderer extends CustomRenderedItemModelRenderer {

    protected static final PartialModel CHIMNEY_L = PartialModel.of(CreateBionics.asResource("item/organ_chimney_l"));
    protected static final PartialModel CHIMNEY_R = PartialModel.of(CreateBionics.asResource("item/organ_chimney_r"));

    @Override
    protected void render(ItemStack stack, CustomRenderedItemModel model, PartialItemModelRenderer renderer, ItemDisplayContext transformType, PoseStack ms, MultiBufferSource buffer, int light, int overlay) {
        if (Minecraft.getInstance().player == null) {
            return;
        }
        if (CreateBionics.isDevUsername(Minecraft.getInstance().player.getName().getString())) {
            renderer.render(model.getOriginalModel(), light);

            //ms.translate(0, 3/256f, 10/128f);
            ms.translate(-2.75 / 16f, 1 / 16f, 20 / 16f);
            ms.mulPose(Axis.YP.rotationDegrees(-22.5f));
            renderer.render(CHIMNEY_L.get(), light);
            ms.mulPose(Axis.YP.rotationDegrees(22.5f));
            ms.translate(2.75 / 16f, -1 / 16f, -20 / 16f);

            ms.translate(2.75 / 16f, 1 / 16f, 20 / 16f);
            ms.mulPose(Axis.YP.rotationDegrees(22.5f));
            renderer.render(CHIMNEY_R.get(), light);

        }
    }
}
