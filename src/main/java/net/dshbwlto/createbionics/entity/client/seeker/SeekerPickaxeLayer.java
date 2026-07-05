package net.dshbwlto.createbionics.entity.client.seeker;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.entity.client.BionicsModelLayers;
import net.dshbwlto.createbionics.entity.custom.OxhaulerEntity;
import net.dshbwlto.createbionics.entity.custom.SeekerEntity;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public class SeekerPickaxeLayer extends RenderLayer<SeekerEntity, SeekerModel<SeekerEntity>> {
    private final SeekerModel<SeekerEntity> model;
    private Map<Integer, ResourceLocation> PICK_MAP = Map.of(
            0, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/seeker/seeker_iron.png"),
            1, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/seeker/seeker_diamond.png"),
            2, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/seeker/seeker_netherite.png")
    );

    public SeekerPickaxeLayer(RenderLayerParent<SeekerEntity, SeekerModel<SeekerEntity>> renderer, EntityModelSet models) {
        super(renderer);
        this.model = new SeekerModel<>(models.bakeLayer(BionicsModelLayers.SEEKER_PICKAXE));
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight, SeekerEntity livingEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        Integer integer = livingEntity.getTypePickaxe();
        this.getParentModel().copyPropertiesTo(this.model);
        this.model.prepareMobModel(livingEntity, limbSwing, limbSwingAmount, partialTicks);
        this.model.setupAnim(livingEntity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.entityCutoutNoCull(PICK_MAP.get(integer)));
        this.model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY);
    }
}