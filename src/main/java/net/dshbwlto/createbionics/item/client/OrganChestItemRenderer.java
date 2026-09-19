
package net.dshbwlto.createbionics.item.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.simibubi.create.foundation.item.render.CustomRenderedItemModel;
import com.simibubi.create.foundation.item.render.CustomRenderedItemModelRenderer;
import com.simibubi.create.foundation.item.render.PartialItemModelRenderer;
import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.createmod.catnip.animation.AnimationTickHolder;
import net.dshbwlto.createbionics.CreateBionics;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class OrganChestItemRenderer extends CustomRenderedItemModelRenderer {

    protected static final PartialModel BELLOWS = PartialModel.of(CreateBionics.asResource("item/organ_bellows_item"));

    @Override
    protected void render(ItemStack stack, CustomRenderedItemModel model, PartialItemModelRenderer renderer, ItemDisplayContext transformType, PoseStack ms, MultiBufferSource buffer, int light, int overlay) {
        renderer.render(model.getOriginalModel(), light);

        //ms.translate(0, 3/256f, 10/128f);
        ms.mulPose(Axis.ZP.rotationDegrees(-22.5f));
        ms.translate(0f, 27/16f, -3.25/16f);
        renderer.render(BELLOWS.get(), light);
        ms.translate(0f, -27/16f, 3.25/16f);
        ms.mulPose(Axis.ZP.rotationDegrees(22.5f));

        ms.mulPose(Axis.ZP.rotationDegrees(22.5f));
        ms.translate(3.5/16f, 27/16f, -3.25/16f);
        renderer.render(BELLOWS.get(), light);
        ms.clear();
    }
}
