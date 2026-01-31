package net.dshbwlto.createbionics.item.custom;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.simibubi.create.foundation.blockEntity.behaviour.scrollValue.ScrollValueHandler;
import com.simibubi.create.foundation.item.render.CustomRenderedItemModel;
import com.simibubi.create.foundation.item.render.CustomRenderedItemModelRenderer;
import com.simibubi.create.foundation.item.render.PartialItemModelRenderer;
import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.createmod.catnip.animation.AnimationTickHolder;
import net.dshbwlto.createbionics.CreateBionics;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.joml.Quaternionf;

public class OrganHeadItemRenderer extends CustomRenderedItemModelRenderer {

    protected static final PartialModel SNOUT = PartialModel.of(CreateBionics.asResource("item/organ_head_snout"));

    @Override
    protected void render(ItemStack stack, CustomRenderedItemModel model, PartialItemModelRenderer renderer, ItemDisplayContext transformType, PoseStack ms, MultiBufferSource buffer, int light, int overlay) {
            renderer.render(model.getOriginalModel(), light);

        ms.translate(0, 3/256f, 10/128f);
        ms.mulPose(Axis.XP.rotationDegrees(-15));

            renderer.render(SNOUT.get(), light);
    }
}
