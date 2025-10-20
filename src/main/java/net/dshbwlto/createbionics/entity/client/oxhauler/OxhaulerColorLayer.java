package net.dshbwlto.createbionics.entity.client.oxhauler;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.entity.client.ModModelLayers;
import net.dshbwlto.createbionics.entity.client.anole.AnoleModel;
import net.dshbwlto.createbionics.entity.custom.AnoleEntity;
import net.dshbwlto.createbionics.entity.custom.OxhaulerEntity;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public class OxhaulerColorLayer extends RenderLayer<OxhaulerEntity, OxhaulerModel<OxhaulerEntity>> {
    private final OxhaulerModel<OxhaulerEntity> model;
    private Map<Integer, ResourceLocation> COLOR_MAP_1 = Map.of(
            0, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/oxhauler/color/oxhauler_white.png"),
            1, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/oxhauler/color/oxhauler_light_gray.png"),
            2, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/oxhauler/color/oxhauler_gray.png"),
            3, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/oxhauler/color/oxhauler_black.png"),
            4, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/oxhauler/color/oxhauler_brown.png"),
            5, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/oxhauler/color/oxhauler.png"),
            6, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/oxhauler/color/oxhauler_orange.png"),
            7, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/oxhauler/color/oxhauler_yellow.png"),
            8, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/oxhauler/color/oxhauler_lime.png"),
            9, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/oxhauler/color/oxhauler_green.png")
    );
    private Map<Integer, ResourceLocation> COLOR_MAP_2 = Map.of(
            10, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/oxhauler/color/oxhauler_cyan.png"),
            11, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/oxhauler/color/oxhauler_light_blue.png"),
            12, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/oxhauler/color/oxhauler_blue.png"),
            13, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/oxhauler/color/oxhauler_purple.png"),
            14, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/oxhauler/color/oxhauler_magenta.png"),
            15, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/oxhauler/color/oxhauler_pink.png")
    );

    public OxhaulerColorLayer(RenderLayerParent<OxhaulerEntity, OxhaulerModel<OxhaulerEntity>> renderer, EntityModelSet models) {
        super(renderer);
        this.model = new OxhaulerModel<>(models.bakeLayer(ModModelLayers.OXHAULER_COLOR));
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight, OxhaulerEntity livingEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (!(livingEntity.getTypeColor() == 5)) {
            Integer integer = livingEntity.getTypeColor();
            this.getParentModel().copyPropertiesTo(this.model);
            this.model.prepareMobModel(livingEntity, limbSwing, limbSwingAmount, partialTicks);
            this.model.setupAnim(livingEntity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            if (livingEntity.getTypeColor() < 10) {
                VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.entityCutoutNoCull(COLOR_MAP_1.get(integer)));
                this.model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY);
            } else {
                VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.entityCutoutNoCull(COLOR_MAP_2.get(integer)));
                this.model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY);
            }
        }
    }
}
