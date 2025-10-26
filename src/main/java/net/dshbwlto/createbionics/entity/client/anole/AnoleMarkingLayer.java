package net.dshbwlto.createbionics.entity.client.anole;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.entity.client.BionicsModelLayers;
import net.dshbwlto.createbionics.entity.custom.AnoleEntity;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public class AnoleMarkingLayer extends RenderLayer<AnoleEntity, AnoleModel<AnoleEntity>> {
    private final AnoleModel<AnoleEntity> model;
    private Map<Integer, ResourceLocation> MARKING_MAP = Map.of(
            0, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/anole/anole_redstone.png"),
            1, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/anole/anole_redstone.png"),
            2, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/anole/anole_gold.png"),
            3, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/anole/anole_diamond.png")
    );

    public AnoleMarkingLayer(RenderLayerParent<AnoleEntity, AnoleModel<AnoleEntity>> renderer, EntityModelSet models) {
        super(renderer);
        this.model = new AnoleModel<>(models.bakeLayer(BionicsModelLayers.ANOLE_MARKINGS));
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight, AnoleEntity livingEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (!(livingEntity.getTypeMarkings() == 0)) {
            Integer integer = livingEntity.getTypeMarkings();
            this.getParentModel().copyPropertiesTo(this.model);
            this.model.prepareMobModel(livingEntity, limbSwing, limbSwingAmount, partialTicks);
            this.model.setupAnim(livingEntity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            if (livingEntity.getTypeMarkings() == 1) {
                VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.entityTranslucentEmissive(MARKING_MAP.get(integer)));
                this.model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY);
            } else {
                VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.entityCutoutNoCull(MARKING_MAP.get(integer)));
                this.model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY);
            }
        }
    }
}
