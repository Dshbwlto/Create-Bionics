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

    private static final PartialModel WHISTLE_BASE_MIDDLE_LARGE = PartialModel.of(CreateBionics.asResource("item/whistle_base_middle_large"));
    private static final PartialModel WHISTLE_BASE_MIDDLE_MEDIUM = PartialModel.of(CreateBionics.asResource("item/whistle_base_middle_medium"));
    private static final PartialModel WHISTLE_BASE_MIDDLE_SMALL = PartialModel.of(CreateBionics.asResource("item/whistle_base_middle_small"));
    private static final PartialModel WHISTLE_BASE_SIDE_LARGE = PartialModel.of(CreateBionics.asResource("item/whistle_base_side_large"));
    private static final PartialModel WHISTLE_BASE_SIDE_MEDIUM = PartialModel.of(CreateBionics.asResource("item/whistle_base_side_medium"));
    private static final PartialModel WHISTLE_BASE_SIDE_SMALL = PartialModel.of(CreateBionics.asResource("item/whistle_base_side_small"));
    private static final PartialModel WHISTLE_MIDDLE_LARGE = PartialModel.of(CreateBionics.asResource("item/whistle_middle_large"));
    private static final PartialModel WHISTLE_MIDDLE_MEDIUM = PartialModel.of(CreateBionics.asResource("item/whistle_middle_medium"));
    private static final PartialModel WHISTLE_MIDDLE_SMALL = PartialModel.of(CreateBionics.asResource("item/whistle_middle_small"));
    private static final PartialModel WHISTLE_END_LARGE = PartialModel.of(CreateBionics.asResource("item/whistle_end_large"));
    private static final PartialModel WHISTLE_END_MEDIUM = PartialModel.of(CreateBionics.asResource("item/whistle_end_medium"));
    private static final PartialModel WHISTLE_END_SMALL = PartialModel.of(CreateBionics.asResource("item/whistle_end_small"));
    private static final PartialModel WHISTLE_FACE_MIDDLE_LARGE = PartialModel.of(CreateBionics.asResource("item/whistle_face_middle_large"));
    private static final PartialModel WHISTLE_FACE_MIDDLE_MEDIUM = PartialModel.of(CreateBionics.asResource("item/whistle_face_middle_medium"));

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

    public void renderWhistles(OrganEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight,
                               int count, int size, int height, float separation, float xPos, float yPos, float zPos, float angle) {
        float bodyYOffset = (float) Math.sin(((AnimationTickHolder.getTicks() + AnimationTickHolder.getPartialTicks()) / 22)) / -32;

        PartialModel base_middle = size == 1 ? WHISTLE_BASE_MIDDLE_SMALL
                : size == 2 ? WHISTLE_BASE_MIDDLE_MEDIUM
                : WHISTLE_BASE_MIDDLE_LARGE;

        PartialModel base_side = size == 1 ? WHISTLE_BASE_SIDE_SMALL
                : size == 2 ? WHISTLE_BASE_SIDE_MEDIUM
                : WHISTLE_BASE_SIDE_LARGE;

        PartialModel base = xPos < 0 ? base_side : xPos == 0 ? base_middle : base_side;

        PartialModel extension = size == 1 ? WHISTLE_MIDDLE_SMALL
                : size == 2 ? WHISTLE_MIDDLE_MEDIUM
                : WHISTLE_MIDDLE_LARGE;

        PartialModel end = size == 1 ? WHISTLE_BASE_MIDDLE_SMALL
                : size == 2 ? WHISTLE_END_MEDIUM
                : WHISTLE_END_LARGE;

        for ( int i = 0; i < count; i++) {
            CachedBuffers.partial(base, entity.getBlockStateOn())
                    .rotateYDegrees(-entityYaw)
                    .translate(xPos, 7 + bodyYOffset + yPos, zPos + 0.5 - separation * i)
                    .rotate(Direction.Axis.Y, xPos > 0 ? (float) Math.PI : 0)
                    .rotate(Direction.Axis.Z, angle == 0 ? 0 : i * 0.1f + angle)
                    .light(packedLight)
                    .renderInto(poseStack, buffer.getBuffer(RenderType.cutout()));
            CachedBuffers.partial(end, entity.getBlockStateOn())
                    .rotateYDegrees(-entityYaw)
                    .translate(xPos, 7 + bodyYOffset + yPos, zPos + 0.5 - separation * i)
                    .rotate(Direction.Axis.Y, xPos > 0 ? (float) Math.PI : 0)
                    .rotate(Direction.Axis.Z, angle == 0 ? 0 : i * 0.1f + angle)
                    .translate(0, xPos == 0 ? i * 0.5 - 1 + height : i * 0.5 + 0.5 + height, 0)
                    .light(packedLight)
                    .renderInto(poseStack, buffer.getBuffer(RenderType.cutout()));

            for (int j = 0; j < i + height; j ++) {
                CachedBuffers.partial(extension, entity.getBlockStateOn())
                        .rotateYDegrees(-entityYaw)
                        .translate(xPos, 7 + bodyYOffset + yPos, zPos + 0.5 - separation * i)
                        .rotate(Direction.Axis.Z, xPos == 0 ? 0 : xPos > 0 ? -i * 0.1f - angle : i * 0.1f + angle)
                        .translate(0, j * 0.5f + 1, 0)
                        .light(packedLight)
                        .renderInto(poseStack, buffer.getBuffer(RenderType.cutout()));
            }
        }
    }

    public void renderWhistlesTail1(OrganEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight,
                               int count, int size, int height, float separation, float xPos, float yPos, float zPos, float angle) {
        float ySwing = (float) Math.sin((AnimationTickHolder.getTicks() + AnimationTickHolder.getPartialTicks()) / -16) * 3.55f;
        float bodyYOffset = (float) Math.sin(((AnimationTickHolder.getTicks() + AnimationTickHolder.getPartialTicks()) / 22)) / -32;

        PartialModel base_middle = size == 1 ? WHISTLE_BASE_MIDDLE_SMALL
                : size == 2 ? WHISTLE_BASE_MIDDLE_MEDIUM
                : WHISTLE_BASE_MIDDLE_LARGE;

        PartialModel base_side = size == 1 ? WHISTLE_BASE_SIDE_SMALL
                : size == 2 ? WHISTLE_BASE_SIDE_MEDIUM
                : WHISTLE_BASE_SIDE_LARGE;

        PartialModel base = xPos < 0 ? base_side : xPos == 0 ? base_middle : base_side;

        PartialModel extension = size == 1 ? WHISTLE_MIDDLE_SMALL
                : size == 2 ? WHISTLE_MIDDLE_MEDIUM
                : WHISTLE_MIDDLE_LARGE;

        PartialModel end = size == 1 ? WHISTLE_BASE_MIDDLE_SMALL
                : size == 2 ? WHISTLE_END_MEDIUM
                : WHISTLE_END_LARGE;

        for (int i = 0; i < count; i++) {
            CachedBuffers.partial(base, entity.getBlockStateOn())
                    .rotateYDegrees(-entityYaw)
                    .translate(0, 0, -2 - 1 / 8f)
                    .rotateYDegrees(ySwing)
                    .translate(xPos, 7 + bodyYOffset + yPos + i * 0.1, zPos - separation * i)
                    .rotate(Direction.Axis.Z, xPos == 0 ? 0 : xPos > 0 ? i * 0.1f + angle : -i * 0.1f - angle)
                    .rotate(Direction.Axis.Y, xPos > 0 ? (float) Math.PI : 0)
                    .light(packedLight)
                    .renderInto(poseStack, buffer.getBuffer(RenderType.cutout()));

            CachedBuffers.partial(end, entity.getBlockStateOn())
                    .rotateYDegrees(-entityYaw)
                    .translate(0, 0, -2 - 1 / 8f)
                    .rotateYDegrees(ySwing)
                    .translate(xPos, 7 + bodyYOffset + yPos + i * 0.1, zPos - separation * i)
                    .rotate(Direction.Axis.Z, xPos == 0 ? 0 : xPos > 0 ? i * 0.1f + angle : -i * 0.1f - angle)
                    .translate(0, (height/2f) + (i/4f) + 1, 0)
                    .light(packedLight)
                    .renderInto(poseStack, buffer.getBuffer(RenderType.cutout()));
            CachedBuffers.partial(extension, entity.getBlockStateOn())
                    .rotateYDegrees(-entityYaw)
                    .translate(0, 0, -2 - 1 / 8f)
                    .rotateYDegrees(ySwing)
                    .translate(xPos, 7 + bodyYOffset + yPos + i * 0.1, zPos - separation * i)
                    .rotate(Direction.Axis.Z, xPos == 0 ? 0 : xPos > 0 ? i * 0.1f + angle : -i * 0.1f - angle)
                    .translate(0, (height/2f) + (i/4f) + 0.5, 0)
                    .scale(0.999f)
                    .light(packedLight)
                    .renderInto(poseStack, buffer.getBuffer(RenderType.cutout()));

            for (int j = 0; j < i / 2 + height; j++) {
                CachedBuffers.partial(extension, entity.getBlockStateOn())
                        .rotateYDegrees(-entityYaw)
                        .translate(0, 0, -2 - 1 / 8f)
                        .rotateYDegrees(ySwing)
                        .translate(xPos, 7 + bodyYOffset + yPos + i * 0.1, zPos - separation * i)
                        .rotate(Direction.Axis.Z, xPos == 0 ? 0 : xPos > 0 ? i * 0.1f + angle : -i * 0.1f - angle)
                        .translate(0, j * 0.5f + 1, 0)
                        .light(packedLight)
                        .renderInto(poseStack, buffer.getBuffer(RenderType.cutout()));
            }
        }
    }

        @Override
    public void render(OrganEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);

        //back middle
        renderWhistles(entity, entityYaw, partialTicks, poseStack, buffer, packedLight,
                4, 3, 4, 7/8f, 0, 0, 0.5f, 0);

        //back right
        renderWhistles(entity, entityYaw, partialTicks, poseStack, buffer, packedLight,
                4, 3, 1, -7/8f, -1.2f, -0.65f, -2 - 1/8f, -0.1f);
        renderWhistles(entity, entityYaw, partialTicks, poseStack, buffer, packedLight,
                4, 3, 1, -7/8f, -1.6f, -1.45f, -17/8f, 0.3f);

        //back left
        renderWhistles(entity, entityYaw, partialTicks, poseStack, buffer, packedLight,
                4, 3, 1, -7/8f, 1.2f, -0.65f, -2 - 1/8f, -0.1f);
        renderWhistles(entity, entityYaw, partialTicks, poseStack, buffer, packedLight,
                4, 3, 1, -7/8f, 1.6f, -1.45f, -17/8f, 0.3f);

        //tail 1 middle
        renderWhistlesTail1(entity, entityYaw, partialTicks, poseStack, buffer, packedLight,
                6, 2, 6, -12/16f, 0, -1.2f, -4 - 7/16f, 0);

        //tail 1 left
        renderWhistlesTail1(entity, entityYaw, partialTicks, poseStack, buffer, packedLight,
                4, 2, 1, -12/16f, 1.25f, -2.6f, -4 - 4/16f, -0.261799f);
        renderWhistlesTail1(entity, entityYaw, partialTicks, poseStack, buffer, packedLight,
                2, 3, 3, -12/16f, 1.1f, -2.3f, -1 - 4/16f, 0.0872665f);
        renderWhistlesTail1(entity, entityYaw, partialTicks, poseStack, buffer, packedLight,
                2, 2, 1, -12/16f, 1.1f, -3.2f, -1 - 2/16f, -0.349066f);

        //tail 1 right
        renderWhistlesTail1(entity, entityYaw, partialTicks, poseStack, buffer, packedLight,
                4, 2, 1, -12/16f, -1.25f, -2.6f, -4 - 4/16f, -0.261799f);
        renderWhistlesTail1(entity, entityYaw, partialTicks, poseStack, buffer, packedLight,
                2, 3, 3, -12/16f, -1.1f, -2.3f, -1 - 4/16f, 0.0872665f);
        renderWhistlesTail1(entity, entityYaw, partialTicks, poseStack, buffer, packedLight,
                2, 2, 1, -12/16f, -1.1f, -3.2f, -1 - 2/16f, -0.349066f);
    }

    @Override
    public boolean shouldRender(OrganEntity livingEntity, Frustum camera, double camX, double camY, double camZ) {
        return true;
    }
}