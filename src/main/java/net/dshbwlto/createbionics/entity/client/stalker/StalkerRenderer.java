package net.dshbwlto.createbionics.entity.client.stalker;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.entity.client.ModModelLayers;
import net.dshbwlto.createbionics.entity.custom.StalkerEntity;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.monster.Drowned;
import org.joml.Quaternionf;

import java.util.Map;

public class StalkerRenderer extends MobRenderer<StalkerEntity, StalkerModel<StalkerEntity>> {
    private static final Map<StalkerVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(StalkerVariant.class), map -> {
                map.put(StalkerVariant.DEFAULT,
                        ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/stalker/stalker.png"));
                map.put(StalkerVariant.COPPER,
                        ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/stalker/stalker_copper.png"));
                map.put(StalkerVariant.NETHERITE1_COPPER,
                        ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/stalker/stalker_netherite1_copper.png"));
                map.put(StalkerVariant.NETHERITE1,
                        ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/stalker/stalkere_netherite1.png"));
                map.put(StalkerVariant.NETHERITE2,
                        ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/stalker/stalker_netherite2.png"));
                map.put(StalkerVariant.NETHERITE3,
                        ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/stalker/stalker_netherite3.png"));

    });

    public StalkerRenderer(EntityRendererProvider.Context context) {
        super (context, new StalkerModel<>(context.bakeLayer(ModModelLayers.STALKER)), 0.75f);
    }

    @Override
    public ResourceLocation getTextureLocation(StalkerEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    @Override
    public void render(StalkerEntity entity, float entityYaw, float partialTicks,
                       PoseStack poseStack, MultiBufferSource buffer, int pPackedLight) {
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, pPackedLight);
    }
    protected void setupRotations(StalkerEntity entity, PoseStack poseStack, float bob, float yBodyRot, float partialTick, float scale) {
        super.setupRotations(entity, poseStack, bob, yBodyRot, partialTick, scale);
        float f = entity.getSwimAmount(partialTick);
        if (f > 0.0F) {
            float f1 = -10.0F - entity.getXRot();
            float f2 = Mth.lerp(f, 0.0F, f1);
            poseStack.rotateAround(Axis.XP.rotationDegrees(f2), 0.0F, entity.getBbHeight() / 2.0F / scale, 0.0F);
        }
    }
}