package net.dshbwlto.createbionics.entity.client.oxhauler;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.entity.client.BionicsModelLayers;
import net.dshbwlto.createbionics.entity.custom.OxhaulerEntity;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class OxhaulerGlowLayer extends RenderLayer<OxhaulerEntity, OxhaulerModel<OxhaulerEntity>> {
    private final OxhaulerModel<OxhaulerEntity> model;

    public OxhaulerGlowLayer(RenderLayerParent<OxhaulerEntity, OxhaulerModel<OxhaulerEntity>> renderer, EntityModelSet models) {
        super(renderer);
        this.model = new OxhaulerModel<>(models.bakeLayer(BionicsModelLayers.OXHAULER_GLOW));
    }
    @Override
    public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight, OxhaulerEntity livingEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (livingEntity.getFuel() > 0) {
            this.getParentModel().copyPropertiesTo(this.model);
            this.model.prepareMobModel(livingEntity, limbSwing, limbSwingAmount, partialTicks);
            this.model.setupAnim(livingEntity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
                VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.entityTranslucentEmissive(ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/oxhauler/oxhauler_glow.png")));
                this.model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY);
        }
    }
}

