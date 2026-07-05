package net.dshbwlto.createbionics.entity.client.seeker;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.entity.client.BionicsModelLayers;
import net.dshbwlto.createbionics.entity.custom.SeekerEntity;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public class SeekerRenderer extends MobRenderer<SeekerEntity, SeekerModel<SeekerEntity>> {
    private final Map<SeekerVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(SeekerVariant.class),map -> {
                map.put(SeekerVariant.COPPER,
                        ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/seeker/seeker_copper.png"));
                map.put(SeekerVariant.BRASS,
                        ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/seeker/seeker_brass.png"));
                map.put(SeekerVariant.ANDESITE,
                        ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/seeker/seeker_andesite.png"));
            });

    public SeekerRenderer(EntityRendererProvider.Context context) {
        super (context, new SeekerModel<>(context.bakeLayer(BionicsModelLayers.SEEKER)), 0.25f);
        this.addLayer(new SeekerGlowLayer(this, context.getModelSet()));
        this.addLayer(new SeekerPickaxeLayer(this, context.getModelSet()));
    }

    @Override
    public ResourceLocation getTextureLocation(SeekerEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    @Override
    public void render(SeekerEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}