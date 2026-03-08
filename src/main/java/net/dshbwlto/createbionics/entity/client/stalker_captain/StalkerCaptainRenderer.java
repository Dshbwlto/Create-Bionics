package net.dshbwlto.createbionics.entity.client.stalker_captain;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.entity.client.BionicsModelLayers;
import net.dshbwlto.createbionics.entity.client.stalker.StalkerModel;
import net.dshbwlto.createbionics.entity.client.stalker.StalkerVariant;
import net.dshbwlto.createbionics.entity.custom.StalkerCaptainEntity;
import net.dshbwlto.createbionics.entity.custom.StalkerEntity;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

import java.util.Map;

public class StalkerCaptainRenderer extends MobRenderer<StalkerCaptainEntity, StalkerCaptainModel<StalkerCaptainEntity>> {
    private static final Map<StalkerVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(StalkerVariant.class), map -> {
                map.put(StalkerVariant.COPPER,
                        ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/stalker_captain/stalker_captain_copper.png"));
                map.put(StalkerVariant.BRASS,
                        ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/stalker_captain/stalker_captain_brass.png"));
                map.put(StalkerVariant.ANDESITE,
                        ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/stalker_captain/stalker_captain_andesite.png"));
            });

    public StalkerCaptainRenderer(EntityRendererProvider.Context context) {
        super (context, new StalkerCaptainModel<>(context.bakeLayer(BionicsModelLayers.STALKER_CAPTAIN)), 0.75f);
    }

    @Override
    public ResourceLocation getTextureLocation(StalkerCaptainEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    @Override
    public void render(StalkerCaptainEntity entity, float entityYaw, float partialTicks,
                       PoseStack poseStack, MultiBufferSource buffer, int pPackedLight) {
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, pPackedLight);
    }
    protected void setupRotations(StalkerCaptainEntity entity, PoseStack poseStack, float bob, float yBodyRot, float partialTick, float scale) {
        super.setupRotations(entity, poseStack, bob, yBodyRot, partialTick, scale);
        float f = entity.getSwimAmount(partialTick);
        if (f > 0.0F) {
            float f1 = -10.0F - entity.getXRot();
            float f2 = Mth.lerp(f, 0.0F, f1);
            poseStack.rotateAround(Axis.XP.rotationDegrees(f2), 0.0F, entity.getBbHeight() / 2.0F / scale, 0.0F);
        }
    }
}