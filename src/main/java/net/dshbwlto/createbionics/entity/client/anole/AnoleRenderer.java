package net.dshbwlto.createbionics.entity.client.anole;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.entity.client.BionicsModelLayers;
import net.dshbwlto.createbionics.entity.client.RobotVariant;
import net.dshbwlto.createbionics.entity.custom.AnoleEntity;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public class AnoleRenderer extends MobRenderer<AnoleEntity, AnoleModel<AnoleEntity>> {
    private final Map<RobotVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(RobotVariant.class),map -> {
                map.put(RobotVariant.ANDESITE,
                        ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/anole/anole_andesite.png"));
                map.put(RobotVariant.BRASS,
                        ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/anole/anole_brass.png"));
                map.put(RobotVariant.COPPER,
                        ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/anole/anole_copper.png"));
                map.put(RobotVariant.STURDY_SHEET,
                        ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/anole/anole_sturdy_sheet.png"));
                map.put(RobotVariant.NETHERITE,
                        ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/anole/anole_netherite.png"));
                map.put(RobotVariant.EXPOSED,
                        ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/anole/anole_exposed.png"));
                map.put(RobotVariant.WEATHERED,
                        ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/anole/anole_weathered.png"));
                map.put(RobotVariant.OXIDIZED,
                        ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/anole/anole_oxidized.png"));
            });

    public AnoleRenderer(EntityRendererProvider.Context context) {
        super (context, new AnoleModel<>(context.bakeLayer(BionicsModelLayers.ANOLE)), 0.25f);
        this.addLayer(new AnoleMarkingLayer(this, context.getModelSet()));
    }

    @Override
    public ResourceLocation getTextureLocation(AnoleEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    @Override
    public void render(AnoleEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}