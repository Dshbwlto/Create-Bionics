package net.dshbwlto.createbionics.entity.client.oxhauler;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.entity.client.ModModelLayers;
import net.dshbwlto.createbionics.entity.custom.OxhaulerEntity;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import java.util.Map;

public class OxhaulerColorLayer extends RenderLayer<OxhaulerEntity, OxhaulerModel<OxhaulerEntity>> {
    private final OxhaulerModel<OxhaulerEntity> model;
    private Map<Integer, ResourceLocation> COLOR_MAP = Map.of(
            1, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/oxhauler/oxhauler_white.png"),
            2, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/oxhauler/oxhauler_light_gray.png"),
            3, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/oxhauler/oxhauler_gray.png"),
            4, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/oxhauler/oxhauler_black.png"),
            5, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/oxhauler/oxhauler_brown.png"),
            6, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/oxhauler/oxhauler_orange.png"),
            7, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/oxhauler/oxhauler_yellow.png"),
            8, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/oxhauler/oxhauler_lime.png"),
            9, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/oxhauler/oxhauler_green.png"),
            10, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/oxhauler/oxhauler_cyan.png")
    );


    public OxhaulerColorLayer(RenderLayerParent<OxhaulerEntity, OxhaulerModel<OxhaulerEntity>> renderer, EntityModelSet models) {
        super(renderer);
        model = new OxhaulerModel<>(models.bakeLayer(ModModelLayers.OXHAULER_COLOR));
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, OxhaulerEntity livingEntity,
                       float limbSwing, float limbSwingAmount, float partialTick, float ageInTicks, float netHeadYaw, float headPitch) {
    }
}
