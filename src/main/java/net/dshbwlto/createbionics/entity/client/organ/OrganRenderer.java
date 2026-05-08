package net.dshbwlto.createbionics.entity.client.organ;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.createmod.catnip.render.CachedBuffers;
import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.entity.client.BionicsModelLayers;
import net.dshbwlto.createbionics.entity.client.organ.layers.*;
import net.dshbwlto.createbionics.entity.custom.OrganEntity;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

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
        this.addLayer(new OrganExhaustLayer<>(this, context.getModelSet()));
    }

    @Override
    public ResourceLocation getTextureLocation(OrganEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    @Override
    public void render(OrganEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        CachedBuffers.partial(PartialModel.of(CreateBionics.asResource("item/debug_arrow")), entity.getBlockStateOn())
                .translate(0, 18, 0)
                .rotate(Direction.Axis.Y, (-entity.getPreciseBodyRotation(partialTicks) * Mth.PI / 180) + Mth.PI)
                .scale(10)
                .light(15728880)
                .renderInto(poseStack, buffer.getBuffer(RenderType.cutout()));
        poseStack.mulPose(Axis.YN.rotation(-entity.getPreciseBodyRotation(partialTicks) * Mth.PI / 180));
        float d = entity.x0 - entity.getPreciseBodyRotation(partialTicks);
        float a = Mth.abs(d);

        boolean b = entity.y0 <= 2;

        if (a < 10) {
            entity.y0 -= 0.01f;
        }

        if (a > 2) {
            if (d > 0) {
                entity.x0 -= entity.y0 * 0.5f;
                if (b) entity.y0 += 0.01f;
            } else {
                entity.x0 += entity.y0 * 0.5f;
                if (b) entity.y0 += 0.01f;
            }
        } else {
            entity.y0 = 0;
        }

        poseStack.mulPose(Axis.YN.rotation(entity.x0 * Mth.PI / 180));
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @Override
    public boolean shouldRender(OrganEntity livingEntity, Frustum camera, double camX, double camY, double camZ) {
        return true;
    }
}