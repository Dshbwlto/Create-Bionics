package net.dshbwlto.createbionics.entity.client.anole;

import com.mojang.blaze3d.vertex.PoseStack;
import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.entity.client.BionicsModelLayers;
import net.dshbwlto.createbionics.entity.custom.AnoleEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class AnoleRenderer extends MobRenderer<AnoleEntity, AnoleModel<AnoleEntity>> {

    public AnoleRenderer(EntityRendererProvider.Context context) {
        super (context, new AnoleModel<>(context.bakeLayer(BionicsModelLayers.ANOLE)), 0.25f);
        this.addLayer(new AnoleMarkingLayer(this, context.getModelSet()));
    }

    @Override
    public ResourceLocation getTextureLocation(AnoleEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/item/entity/anole/anole_" + entity.getTypeVariant() + ".png");
    }

    @Override
    public void render(AnoleEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}