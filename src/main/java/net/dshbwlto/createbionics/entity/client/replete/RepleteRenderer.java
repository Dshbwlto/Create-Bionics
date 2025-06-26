package net.dshbwlto.createbionics.entity.client.replete;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.entity.client.ModModelLayers;

import net.dshbwlto.createbionics.entity.custom.RepleteEntity;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public class RepleteRenderer extends MobRenderer<RepleteEntity, RepleteModel<RepleteEntity>> {
    private static final Map<RepleteVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(net.dshbwlto.createbionics.entity.client.replete.RepleteVariant.class), map -> {
                map.put(RepleteVariant.DEFAULT,
                        ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/replete/chocolate.png"));
                map.put(RepleteVariant.BRASS,
                        ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/replete/replete_brass.png"));
                map.put(RepleteVariant.NETHERITE1_COPPER,
                        ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/replete/replete_netherite1_copper.png"));
                map.put(RepleteVariant.NETHERITE1_BRASS,
                        ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/replete/replete_netherite1_brass.png"));
                map.put(RepleteVariant.NETHERITE2,
                        ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/replete/replete_netherite2.png"));
                map.put(RepleteVariant.NETHERITE3,
                        ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/replete/replete_netherite3.png"));

    });

    public RepleteRenderer(EntityRendererProvider.Context context) {
        super (context, new RepleteModel<>(context.bakeLayer(ModModelLayers.REPLETE)), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(RepleteEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    @Override
    public void render(RepleteEntity entity, float entityYaw, float partialTicks,
                       PoseStack poseStack, MultiBufferSource buffer, int pPackedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.45f, 0.45f, 0.45f);
        }

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, pPackedLight);
    }
}