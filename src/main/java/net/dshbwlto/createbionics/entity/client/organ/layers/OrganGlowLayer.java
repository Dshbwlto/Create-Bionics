package net.dshbwlto.createbionics.entity.client.organ.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.entity.client.BionicsModelLayers;
import net.dshbwlto.createbionics.entity.client.organ.OrganModel;
import net.dshbwlto.createbionics.entity.custom.OrganEntity;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public class OrganGlowLayer extends RenderLayer<OrganEntity, OrganModel<OrganEntity>> {
    private final OrganModel<OrganEntity> model;
    private Map<Integer, ResourceLocation> GLOW_MAP = Map.of(
            0, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/organ/organ_emit.png"),
            1, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/organ/organ_redstone1.png"),
            2, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/organ/organ_redstone2.png")
    );

    public OrganGlowLayer(RenderLayerParent<OrganEntity, OrganModel<OrganEntity>> renderer, EntityModelSet models) {
        super(renderer);
        this.model = new OrganModel<>(models.bakeLayer(BionicsModelLayers.ORGAN_GLOW));
    }
    @Override
    public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight, OrganEntity livingEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        //if (livingEntity.isFueled()) {
        Integer integer = livingEntity.getGlowColor();
            this.getParentModel().copyPropertiesTo(this.model);
            this.model.prepareMobModel(livingEntity, limbSwing, limbSwingAmount, partialTicks);
            this.model.setupAnim(livingEntity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
                VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.entityTranslucentEmissive(GLOW_MAP.get(integer)));
                this.model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY);
        //}
    }
}

