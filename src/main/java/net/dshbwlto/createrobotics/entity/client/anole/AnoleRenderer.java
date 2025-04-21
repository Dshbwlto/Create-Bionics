package net.dshbwlto.createrobotics.entity.client.anole;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.dshbwlto.createrobotics.CreateRobotics;
import net.dshbwlto.createrobotics.entity.client.ModModelLayers;
import net.dshbwlto.createrobotics.entity.custom.AnoleEntity;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.HorseMarkingLayer;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public class AnoleRenderer extends MobRenderer<AnoleEntity, AnoleModel<AnoleEntity>> {
    private static final Map<AnoleVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(AnoleVariant.class),map -> {
                map.put(AnoleVariant.DEFAULT,
                        ResourceLocation.fromNamespaceAndPath(CreateRobotics.MOD_ID, "textures/entity/anole/anole.png"));
                map.put(AnoleVariant.BRASS,
                        ResourceLocation.fromNamespaceAndPath(CreateRobotics.MOD_ID, "textures/entity/anole/anole_brass.png"));
                map.put(AnoleVariant.NETHERITE,
                        ResourceLocation.fromNamespaceAndPath(CreateRobotics.MOD_ID, "textures/entity/anole/anole_netherite.png"));
    });

    public AnoleRenderer(EntityRendererProvider.Context context) {
        super (context, new AnoleModel<>(context.bakeLayer(ModModelLayers.ANOLE)), 0.25f);
        //this.addLayer(new AnoleMarkingLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(AnoleEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    @Override
    public void render(AnoleEntity entity, float entityYaw, float partialTicks,
                       PoseStack poseStack, MultiBufferSource buffer, int pPackedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.45f, 0.45f, 0.45f);
        }

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, pPackedLight);
    }
}