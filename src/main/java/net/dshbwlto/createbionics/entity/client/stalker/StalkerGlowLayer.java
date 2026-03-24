package net.dshbwlto.createbionics.entity.client.stalker;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.entity.client.BionicsModelLayers;
import net.dshbwlto.createbionics.entity.client.organ.OrganModel;
import net.dshbwlto.createbionics.entity.custom.OrganEntity;
import net.dshbwlto.createbionics.entity.custom.StalkerEntity;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public class StalkerGlowLayer extends RenderLayer<StalkerEntity, StalkerModel<StalkerEntity>> {
    private final StalkerModel<StalkerEntity> model;

    public StalkerGlowLayer(RenderLayerParent<StalkerEntity, StalkerModel<StalkerEntity>> renderer, EntityModelSet models) {
        super(renderer);
        this.model = new StalkerModel<>(models.bakeLayer(BionicsModelLayers.STALKER_GLOW));
    }
    @Override
    public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight, StalkerEntity livingEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        //if (livingEntity.isFueled()) {
            this.getParentModel().copyPropertiesTo(this.model);
            this.model.prepareMobModel(livingEntity, limbSwing, limbSwingAmount, partialTicks);
            this.model.setupAnim(livingEntity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        VertexConsumer vertexConsumer = buffer.getBuffer(livingEntity.isAggressive()
                ? RenderType.entityTranslucentEmissive(ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/stalker/stalker_aggro.png"))
                : RenderType.entityTranslucentEmissive(ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/stalker/stalker_neutral.png")));

        this.model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY);
        //}
    }
}

