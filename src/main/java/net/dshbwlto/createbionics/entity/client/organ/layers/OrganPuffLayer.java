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

public class OrganPuffLayer extends RenderLayer<OrganEntity, OrganModel<OrganEntity>> {
    private final OrganModel<OrganEntity> model;
    private Map<Integer, ResourceLocation> EXHAUST_MAP_1 = Map.of(
            0, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/organ/puff/steam0.png"),
            1, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/organ/puff/steam1.png"),
            2, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/organ/puff/steam2.png"),
            3, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/organ/puff/steam3.png"),
            4, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/organ/puff/steam4.png"),
            5, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/organ/puff/steam5.png"),
            6, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/organ/puff/steam6.png"),
            7, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/organ/puff/steam7.png"),
            8, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/organ/puff/steam8.png"),
            9, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/organ/puff/steam9.png")
    );
    private Map<Integer, ResourceLocation> EXHAUST_MAP_2 = Map.of(
            10, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/organ/puff/steam10.png"),
            11, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/organ/puff/steam11.png"),
            12, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/organ/puff/steam12.png"),
            13, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/organ/puff/steam13.png"),
            14, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/organ/puff/steam14.png"),
            15, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/organ/puff/steam15.png"),
            16, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/organ/puff/steam16.png"),
            17, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/organ/puff/steam17.png"),
            18, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/organ/puff/steam18.png"),
            19, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/organ/puff/steam19.png")
    );
    private Map<Integer, ResourceLocation> EXHAUST_MAP_3 = Map.of(
            20, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/organ/puff/steam20.png"),
            21, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/organ/puff/steam21.png")
    );

    public OrganPuffLayer(RenderLayerParent<OrganEntity, OrganModel<OrganEntity>> renderer, EntityModelSet models) {
        super(renderer);
        this.model = new OrganModel<>(models.bakeLayer(BionicsModelLayers.ORGAN_GLOW));
    }
    @Override
    public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight, OrganEntity livingEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        int integer = livingEntity.puff;
            this.getParentModel().copyPropertiesTo(this.model);
            this.model.prepareMobModel(livingEntity, limbSwing, limbSwingAmount, partialTicks);
            this.model.setupAnim(livingEntity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            if (integer < 10) {
                VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.entityCutoutNoCull(EXHAUST_MAP_1.get(integer)));
                this.model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY);
            } else if (integer < 20) {
                VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.entityCutoutNoCull(EXHAUST_MAP_2.get(integer)));
                this.model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY);
            } else {
                VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.entityCutoutNoCull(EXHAUST_MAP_3.get(integer)));
                this.model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY);
            }
    }
}

