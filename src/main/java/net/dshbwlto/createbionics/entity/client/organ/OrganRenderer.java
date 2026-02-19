package net.dshbwlto.createbionics.entity.client.organ;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.createmod.catnip.animation.AnimationTickHolder;
import net.createmod.catnip.math.AngleHelper;
import net.createmod.catnip.render.CachedBuffers;
import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.entity.client.BionicsModelLayers;
import net.dshbwlto.createbionics.entity.client.organ.layers.*;
import net.dshbwlto.createbionics.entity.custom.OrganEntity;
import net.minecraft.Util;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.WorldData;
import net.neoforged.neoforge.client.entity.animation.AnimationKeyframeTarget;

import java.util.Map;

public class OrganRenderer extends MobRenderer<OrganEntity, OrganModel<OrganEntity>> {
    private final Map<OrganVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(OrganVariant.class),map -> {
                map.put(OrganVariant.BRASS,
                        ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/organ/organ_brass.png"));
                map.put(OrganVariant.ANDESITE,
                        ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/organ/organ_andesite.png"));
                map.put(OrganVariant.COPPER,
                        ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/organ/organ_copper.png"));
                map.put(OrganVariant.STURDY_SHEET,
                        ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/organ/organ_sturdy_sheet.png"));
    });

    public OrganRenderer(EntityRendererProvider.Context context) {
        super (context, new OrganModel<>(context.bakeLayer(BionicsModelLayers.ORGAN)), 4);
        this.addLayer(new OrganGlowLayer(this, context.getModelSet()));
        //this.addLayer(new OrganExhaustLayer(this, context.getModelSet()));
        //this.addLayer(new OrganExhaustLayer2(this, context.getModelSet()));
    }

    @Override
    public ResourceLocation getTextureLocation(OrganEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    protected static final PartialModel WHISTLE_MIDDLE_LARGE = PartialModel.of(CreateBionics.asResource("item/whistle_middle_large"));

    @Override
    public void render(OrganEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        Integer integer = entity.getTypeVariant();
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);

        for (int i = 0; i < 4; ++i) {
            CachedBuffers.partial(WHISTLE_MIDDLE_LARGE, entity.getBlockStateOn())
                    .rotateYDegrees(-entityYaw)
                    .translate(-1 / 2f, 7, 1/2f - (7/8f * i))
                    .light(packedLight)
                    .renderInto(poseStack, buffer.getBuffer(RenderType.cutout()));

        }
        CachedBuffers.partial(WHISTLE_MIDDLE_LARGE, entity.getBlockStateOn())
                .rotateYDegrees(-entityYaw)
                .translate(-1 / 2f, 7, 1/2f - (7/8f))
                .light(packedLight)
                .renderInto(poseStack, buffer.getBuffer(RenderType.cutout()));
    }

    @Override
    public boolean shouldRender(OrganEntity livingEntity, Frustum camera, double camX, double camY, double camZ) {
        return true;
    }
}