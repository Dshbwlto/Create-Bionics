
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

    private static final PartialModel COPPER = PartialModel.of(CreateBionics.asResource("item/seeker_item_0"));
    private static final PartialModel BRASS = PartialModel.of(CreateBionics.asResource("item/seeker_item_1"));
    private static final PartialModel ANDESITE = PartialModel.of(CreateBionics.asResource("item/seeker_item_2"));

    private static final PartialModel IRON = PartialModel.of(CreateBionics.asResource("item/seeker_pickaxe_item_0"));
    private static final PartialModel DIAMOND = PartialModel.of(CreateBionics.asResource("item/seeker_pickaxe_item_1"));
    private static final PartialModel NETHERITE = PartialModel.of(CreateBionics.asResource("item/seeker_pickaxe_item_2"));

    @Override
    protected void render(ItemStack stack, CustomRenderedItemModel model, PartialItemModelRenderer renderer, ItemDisplayContext transformType, PoseStack ms, MultiBufferSource buffer, int light, int overlay) {
        int variant = stack.get(BionicsDataComponentTypes.VARIANT.get()) != null ? stack.get(BionicsDataComponentTypes.VARIANT.get()) : 0;
        int pickaxe = stack.get(BionicsDataComponentTypes.MARKING.get()) != null ? stack.get(BionicsDataComponentTypes.MARKING.get()) : 0;

        PartialModel MODEL = PartialModel.of(CreateBionics.asResource("item/seeker_item_" + variant));
        PartialModel PICKAXE = PartialModel.of(CreateBionics.asResource("item/seeker_pickaxe_item_" + pickaxe));

        renderer.render(MODEL.get(), light);
        renderer.render(PICKAXE.get(), light);
    }
}
