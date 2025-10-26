package net.dshbwlto.createbionics.entity.client.oxhauler;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.entity.client.BionicsModelLayers;
import net.dshbwlto.createbionics.entity.custom.OxhaulerEntity;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public class OxhaulerRenderer extends MobRenderer<OxhaulerEntity, OxhaulerModel<OxhaulerEntity>> {
    private static final Map<OxhaulerVariant, ResourceLocation> LOCATION_BY_VARIANT =
        Util.make(Maps.newEnumMap(OxhaulerVariant.class), map -> {
            map.put(OxhaulerVariant.DEFAULT,
                    ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/oxhauler/oxhauler.png"));
            map.put(OxhaulerVariant.COPPER,
                    ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/oxhauler/oxhauler_copper.png"));
            map.put(OxhaulerVariant.NETHERITE1,
                    ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/oxhauler/oxhauler_netherite1.png"));
            map.put(OxhaulerVariant.NETHERITE2,
                    ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/oxhauler/oxhauler_netherite2.png"));
        });

    public OxhaulerRenderer(EntityRendererProvider.Context context) {
        super(context, new OxhaulerModel<>(context.bakeLayer(BionicsModelLayers.OXHAULER)), 1.6f);
        this.addLayer(new OxhaulerGlowLayer(this, context.getModelSet()));
        this.addLayer(new OxhaulerColorLayer(this, context.getModelSet()));
    }

    @Override
    public ResourceLocation getTextureLocation(OxhaulerEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    @Override
    public void render(OxhaulerEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
