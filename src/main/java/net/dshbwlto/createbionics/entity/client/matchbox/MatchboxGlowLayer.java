
package net.dshbwlto.createbionics.entity.client.matchbox;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.dshbwlto.createbionics.BionicsClientConfig;
import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.entity.client.BionicsModelLayers;
import net.dshbwlto.createbionics.entity.custom.MatchboxEntity;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class MatchboxGlowLayer extends RenderLayer<MatchboxEntity, MatchboxModel<MatchboxEntity>> {
    private final MatchboxModel<MatchboxEntity> model;

    public MatchboxGlowLayer(RenderLayerParent<MatchboxEntity, MatchboxModel<MatchboxEntity>> renderer, EntityModelSet models) {
        super(renderer);
        this.model = new MatchboxModel<>(models.bakeLayer(BionicsModelLayers.MATCHBOX_GLOW));
    }
    @Override
    public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight, MatchboxEntity livingEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (livingEntity.getFuel() > 0) {
            this.getParentModel().copyPropertiesTo(this.model);
            this.model.prepareMobModel(livingEntity, limbSwing, limbSwingAmount, partialTicks);
            this.model.setupAnim(livingEntity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.entityTranslucentEmissive(
                    BionicsClientConfig.arachnophobia ? ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/organ/exhaust/steam0.png") : ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/matchbox/matchbox_glow.png")));
            this.model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY);
        }
    }
}
