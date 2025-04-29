package net.dshbwlto.createbionics.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.entity.custom.ThrusterEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ThrusterRenderer extends MobRenderer<ThrusterEntity, ThrusterModel<ThrusterEntity>> {
    public ThrusterRenderer(EntityRendererProvider.Context context) {
        super (context, new ThrusterModel<>(context.bakeLayer(ModModelLayers.THRUSTER)), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(ThrusterEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/thruster/thruster_tall.png");
    }

    @Override
    public void render(ThrusterEntity entity, float entityYaw, float partialTicks,
                       PoseStack poseStack, MultiBufferSource buffer, int pPackedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.45f, 0.45f, 0.45f);
        }

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, pPackedLight);
    }

}