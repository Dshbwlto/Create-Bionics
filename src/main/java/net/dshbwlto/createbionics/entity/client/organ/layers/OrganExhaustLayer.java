package net.dshbwlto.createbionics.entity.client.organ.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.createmod.catnip.animation.AnimationTickHolder;
import net.createmod.catnip.render.CachedBuffers;
import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.entity.client.BionicsModelLayers;
import net.dshbwlto.createbionics.entity.client.organ.OrganModel;
import net.dshbwlto.createbionics.entity.custom.OrganEntity;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

import java.util.Map;

public class OrganExhaustLayer<T>extends RenderLayer<OrganEntity, OrganModel<OrganEntity>> {
    private final OrganModel<OrganEntity> model;
    public Map<Integer, ResourceLocation> EXHAUST_MAP_1 = Map.of(
            0, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/organ/exhaust/steam0.png"),
            1, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/organ/exhaust/steam1.png"),
            2, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/organ/exhaust/steam2.png"),
            3, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/organ/exhaust/steam3.png"),
            4, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/organ/exhaust/steam4.png"),
            5, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/organ/exhaust/steam5.png"),
            6, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/organ/exhaust/steam6.png"),
            7, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/organ/exhaust/steam7.png"),
            8, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/organ/exhaust/steam8.png"),
            9, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/organ/exhaust/steam9.png")
    );
    public Map<Integer, ResourceLocation> EXHAUST_MAP_2 = Map.of(
            10, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/organ/exhaust/steam10.png"),
            11, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/organ/exhaust/steam11.png"),
            12, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/organ/exhaust/steam12.png"),
            13, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/organ/exhaust/steam13.png"),
            14, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/organ/exhaust/steam14.png"),
            15, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/organ/exhaust/steam15.png"),
            16, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/organ/exhaust/steam16.png"),
            17, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/organ/exhaust/steam17.png"),
            18, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/organ/exhaust/steam18.png"),
            19, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/organ/exhaust/steam19.png")
    );
    public Map<Integer, ResourceLocation> EXHAUST_MAP_3 = Map.of(
            20, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/organ/exhaust/steam20.png"),
            21, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/organ/exhaust/steam21.png")
    );

    public String variant(OrganEntity entity) {
        if (entity.getVariant() == OrganVariant.BRASS) {
            return "1";
        } else if (entity.getVariant() == OrganVariant.ANDESITE){
            return "2";
        } else if (entity.getVariant() == OrganVariant.COPPER) {
            return "3";
        } else {
            return "4";
        }
    }

    public OrganExhaustLayer(RenderLayerParent<OrganEntity, OrganModel<OrganEntity>> renderer, EntityModelSet models) {
        super(renderer);
        this.model = new OrganModel<>(models.bakeLayer(BionicsModelLayers.ORGAN_EXHAUST));
    }

    private float lerpTo(float delta, float start, float end) {
        return Mth.rotLerp(delta, start, end);
    }

    public void renderWhistles(OrganEntity entity, float netHeadYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight,
                               int count, int size, int height, float separation, float xPos, float yPos, float zPos, float angle, int index) {
        float bodyYOffset = (entity.getAssembly() >= 21 ? (float) Math.sin(((AnimationTickHolder.getTicks() + AnimationTickHolder.getPartialTicks()) / 22)) / -32 : 0) - entity.getSitYOffset() / 16;
        int build = entity.getAssembly() - 22;
        PartialModel base_middle = size == 1 ? (entity.getGlowColor() <2 ? PartialModel.of(CreateBionics.asResource("item/whistle_base_middle_small").withSuffix(variant(entity)))
                : PartialModel.of(CreateBionics.asResource("item/whistle_base_middle_small5")))
                : size == 2 ? (entity.getGlowColor() <2 ? PartialModel.of(CreateBionics.asResource("item/whistle_base_middle_medium").withSuffix(variant(entity)))
                : PartialModel.of(CreateBionics.asResource("item/whistle_base_middle_medium5")))
                : entity.getGlowColor() <2 ? PartialModel.of(CreateBionics.asResource("item/whistle_base_middle_large").withSuffix(variant(entity)))
                : PartialModel.of(CreateBionics.asResource("item/whistle_base_middle_large5"));

        PartialModel base_side = size == 1 ? entity.getGlowColor() <2 ? PartialModel.of(CreateBionics.asResource("item/whistle_base_side_small").withSuffix(variant(entity))) : PartialModel.of(CreateBionics.asResource("item/whistle_base_side_small5"))
                : size == 2 ? entity.getGlowColor() <2 ? PartialModel.of(CreateBionics.asResource("item/whistle_base_side_medium").withSuffix(variant(entity))) : PartialModel.of(CreateBionics.asResource("item/whistle_base_side_medium5"))
                : entity.getGlowColor() <2 ? PartialModel.of(CreateBionics.asResource("item/whistle_base_side_large").withSuffix(variant(entity))) : PartialModel.of(CreateBionics.asResource("item/whistle_base_side_large5"));

        PartialModel base = xPos < 0 ? base_side : xPos == 0 ? base_middle : base_side;

        PartialModel extension = size == 1 ? entity.getGlowColor() <2 ? PartialModel.of(CreateBionics.asResource("item/whistle_middle_small").withSuffix(variant(entity))) : PartialModel.of(CreateBionics.asResource("item/whistle_middle_small5"))
                : size == 2 ? entity.getGlowColor() <2 ? PartialModel.of(CreateBionics.asResource("item/whistle_middle_medium").withSuffix(variant(entity))) : PartialModel.of(CreateBionics.asResource("item/whistle_middle_medium5"))
                : entity.getGlowColor() <2 ? PartialModel.of(CreateBionics.asResource("item/whistle_middle_large").withSuffix(variant(entity))) : PartialModel.of(CreateBionics.asResource("item/whistle_middle_large5"));

        PartialModel end = size == 1 ? entity.getGlowColor() <2 ? PartialModel.of(CreateBionics.asResource("item/whistle_end_small").withSuffix(variant(entity))) : PartialModel.of(CreateBionics.asResource("item/whistle_end_small5"))
                : size == 2 ? entity.getGlowColor() <2 ? PartialModel.of(CreateBionics.asResource("item/whistle_end_medium").withSuffix(variant(entity))) : PartialModel.of(CreateBionics.asResource("item/whistle_end_medium5"))
                : entity.getGlowColor() <2 ? PartialModel.of(CreateBionics.asResource("item/whistle_end_large").withSuffix(variant(entity))) : PartialModel.of(CreateBionics.asResource("item/whistle_end_large5"));

        for ( int i = 0; i < count && index + i <= build; i++) {
            CachedBuffers.partial(base, entity.getBlockStateOn())
                    .rotate(Direction.Axis.X, (float)Math.PI)
                    .translate(xPos, 7 + bodyYOffset + yPos, zPos + 0.5 - separation * i)
                    .rotate(Direction.Axis.Y, xPos > 0 ? (float) Math.PI : 0)
                    .rotate(Direction.Axis.Z, angle == 0 ? 0 : i * 0.1f + angle)
                    .light(entity.getGlowColor() < 2 ? packedLight : 15728880)
                    .renderInto(poseStack, buffer.getBuffer(RenderType.cutout()));
            CachedBuffers.partial(end, entity.getBlockStateOn())
                    .rotate(Direction.Axis.X, (float)Math.PI)
                    .translate(xPos, 7 + bodyYOffset + yPos, zPos + 0.5 - separation * i)
                    .rotate(Direction.Axis.Y, xPos > 0 ? (float) Math.PI : 0)
                    .rotate(Direction.Axis.Z, angle == 0 ? 0 : i * 0.1f + angle)
                    .translate(0, xPos == 0 ? i * 0.5 - 1 + height : i * 0.5 + 0.5 + height, 0)
                    .light(entity.getGlowColor() < 2 ? packedLight : 15728880)
                    .renderInto(poseStack, buffer.getBuffer(RenderType.cutout()));

            for (int j = 0; j < i + height; j ++) {
                CachedBuffers.partial(extension, entity.getBlockStateOn())
                        .rotate(Direction.Axis.X, (float)Math.PI)
                        .translate(xPos, 7 + bodyYOffset + yPos, zPos + 0.5 - separation * i)
                        .rotate(Direction.Axis.Z, xPos == 0 ? 0 : xPos > 0 ? -i * 0.1f - angle : i * 0.1f + angle)
                        .translate(0, j * 0.5f + 1, 0)
                        .light(entity.getGlowColor() < 2 ? packedLight : 15728880)
                        .renderInto(poseStack, buffer.getBuffer(RenderType.cutout()));
            }
        }
    }

    public void renderWhistlesTail1(OrganEntity entity, float netHeadYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight,
                                    int count, int size, int height, float separation, float xPos, float yPos, float zPos, float angle, int index) {
        float ySwing = entity.getAssembly() >= 21 ? (float) Math.sin((AnimationTickHolder.getTicks() + AnimationTickHolder.getPartialTicks()) / -16) * 3.55f : 0;
        float bodyYOffset = (entity.getAssembly() >= 21 ? (float) Math.sin(((AnimationTickHolder.getTicks() + AnimationTickHolder.getPartialTicks()) / 22)) / -32 : 0) - entity.getSitYOffset()/16;
        int build = entity.getAssembly() - 22;
        netHeadYaw = Mth.clamp(netHeadYaw, -60.0F, 60.0F / 2);
        PartialModel base_middle = size == 1 ? (entity.getGlowColor() <2 ? PartialModel.of(CreateBionics.asResource("item/whistle_base_middle_small").withSuffix(variant(entity)))
                : PartialModel.of(CreateBionics.asResource("item/whistle_base_middle_small5")))
                : size == 2 ? (entity.getGlowColor() <2 ? PartialModel.of(CreateBionics.asResource("item/whistle_base_middle_medium").withSuffix(variant(entity)))
                : PartialModel.of(CreateBionics.asResource("item/whistle_base_middle_medium5")))
                : entity.getGlowColor() <2 ? PartialModel.of(CreateBionics.asResource("item/whistle_base_middle_large").withSuffix(variant(entity)))
                : PartialModel.of(CreateBionics.asResource("item/whistle_base_middle_large5"));

        PartialModel base_side = size == 1 ? entity.getGlowColor() <2 ? PartialModel.of(CreateBionics.asResource("item/whistle_base_side_small").withSuffix(variant(entity))) : PartialModel.of(CreateBionics.asResource("item/whistle_base_side_small5"))
                : size == 2 ? entity.getGlowColor() <2 ? PartialModel.of(CreateBionics.asResource("item/whistle_base_side_medium").withSuffix(variant(entity))) : PartialModel.of(CreateBionics.asResource("item/whistle_base_side_medium5"))
                : entity.getGlowColor() <2 ? PartialModel.of(CreateBionics.asResource("item/whistle_base_side_large").withSuffix(variant(entity))) : PartialModel.of(CreateBionics.asResource("item/whistle_base_side_large5"));

        PartialModel base = xPos < 0 ? base_side : xPos == 0 ? base_middle : base_side;

        PartialModel extension = size == 1 ? entity.getGlowColor() <2 ? PartialModel.of(CreateBionics.asResource("item/whistle_middle_small").withSuffix(variant(entity))) : PartialModel.of(CreateBionics.asResource("item/whistle_middle_small5"))
                : size == 2 ? entity.getGlowColor() <2 ? PartialModel.of(CreateBionics.asResource("item/whistle_middle_medium").withSuffix(variant(entity))) : PartialModel.of(CreateBionics.asResource("item/whistle_middle_medium5"))
                : entity.getGlowColor() <2 ? PartialModel.of(CreateBionics.asResource("item/whistle_middle_large").withSuffix(variant(entity))) : PartialModel.of(CreateBionics.asResource("item/whistle_middle_large5"));

        PartialModel end = size == 1 ? entity.getGlowColor() <2 ? PartialModel.of(CreateBionics.asResource("item/whistle_end_small").withSuffix(variant(entity))) : PartialModel.of(CreateBionics.asResource("item/whistle_end_small5"))
                : size == 2 ? entity.getGlowColor() <2 ? PartialModel.of(CreateBionics.asResource("item/whistle_end_medium").withSuffix(variant(entity))) : PartialModel.of(CreateBionics.asResource("item/whistle_end_medium5"))
                : entity.getGlowColor() <2 ? PartialModel.of(CreateBionics.asResource("item/whistle_end_large").withSuffix(variant(entity))) : PartialModel.of(CreateBionics.asResource("item/whistle_end_large5"));

        for (int i = 0; i < count && index + i <= build; i++) {
            CachedBuffers.partial(base, entity.getBlockStateOn())
                    .rotate(Direction.Axis.X, (float)Math.PI)
                    .translate(0, 0, -2 - 1 / 8f)
                    .rotateYDegrees(ySwing + netHeadYaw)
                    .translate(xPos, 7 + bodyYOffset + yPos + i * 0.1, zPos - separation * i)
                    .rotate(Direction.Axis.Z, xPos == 0 ? 0 : xPos > 0 ? i * 0.1f + angle : -i * 0.1f - angle)
                    .rotate(Direction.Axis.Y, xPos > 0 ? (float) Math.PI : 0)
                    .light(entity.getGlowColor() < 2 ? packedLight : 15728880)
                    .renderInto(poseStack, buffer.getBuffer(RenderType.cutout()));

            CachedBuffers.partial(end, entity.getBlockStateOn())
                    .rotate(Direction.Axis.X, (float)Math.PI)
                    .translate(0, 0, -2 - 1 / 8f)
                    .rotateYDegrees(ySwing + netHeadYaw)
                    .translate(xPos, 7 + bodyYOffset + yPos + i * 0.1, zPos - separation * i)
                    .rotate(Direction.Axis.Z, xPos == 0 ? 0 : xPos > 0 ? i * 0.1f + angle : -i * 0.1f - angle)
                    .translate(0, (height/2f) + (i/4f) + 1, 0)
                    .light(entity.getGlowColor() < 2 ? packedLight : 15728880)
                    .renderInto(poseStack, buffer.getBuffer(RenderType.cutout()));
            CachedBuffers.partial(extension, entity.getBlockStateOn())
                    .rotate(Direction.Axis.X, (float)Math.PI)
                    .translate(0, 0, -2 - 1 / 8f)
                    .rotateYDegrees(ySwing + netHeadYaw)
                    .translate(xPos, 7 + bodyYOffset + yPos + i * 0.1, zPos - separation * i)
                    .rotate(Direction.Axis.Z, xPos == 0 ? 0 : xPos > 0 ? i * 0.1f + angle : -i * 0.1f - angle)
                    .translate(0, (height/2f) + (i/4f) + 0.5, 0)
                    .scale(0.999f)
                    .light(entity.getGlowColor() < 2 ? packedLight : 15728880)
                    .renderInto(poseStack, buffer.getBuffer(RenderType.cutout()));

            for (int j = 0; j < i / 2 + height; j++) {
                CachedBuffers.partial(extension, entity.getBlockStateOn())
                        .rotate(Direction.Axis.X, (float)Math.PI)
                        .translate(0, 0, -2 - 1 / 8f)
                        .rotateYDegrees(ySwing + netHeadYaw)
                        .translate(xPos, 7 + bodyYOffset + yPos + i * 0.1, zPos - separation * i)
                        .rotate(Direction.Axis.Z, xPos == 0 ? 0 : xPos > 0 ? i * 0.1f + angle : -i * 0.1f - angle)
                        .translate(0, j * 0.5f + 1, 0)
                        .light(entity.getGlowColor() < 2 ? packedLight : 15728880)
                        .renderInto(poseStack, buffer.getBuffer(RenderType.cutout()));
            }
        }
    }

    public void renderWhistlesChest(OrganEntity entity, float netHeadYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight,
                                    int count, int size, int height, float separation, float xPos, float yPos, float zPos, float angle, int index) {
        float bodyYOffset = (entity.getAssembly() >= 21 ? (float) Math.sin(((AnimationTickHolder.getTicks() + AnimationTickHolder.getPartialTicks()) / 22)) / -32 : 0) - entity.getSitYOffset() / 16;
        int build = entity.getAssembly() - 22;
        netHeadYaw = Mth.clamp(netHeadYaw, -60.0F, 60.0F / 2);
        PartialModel base_middle = size == 1 ? (entity.getGlowColor() <2 ? PartialModel.of(CreateBionics.asResource("item/whistle_base_middle_small").withSuffix(variant(entity)))
                : PartialModel.of(CreateBionics.asResource("item/whistle_base_middle_small5")))
                : size == 2 ? (entity.getGlowColor() <2 ? PartialModel.of(CreateBionics.asResource("item/whistle_base_middle_medium").withSuffix(variant(entity)))
                : PartialModel.of(CreateBionics.asResource("item/whistle_base_middle_medium5")))
                : entity.getGlowColor() <2 ? PartialModel.of(CreateBionics.asResource("item/whistle_base_middle_large").withSuffix(variant(entity)))
                : PartialModel.of(CreateBionics.asResource("item/whistle_base_middle_large5"));

        PartialModel base_side = size == 1 ? entity.getGlowColor() <2 ? PartialModel.of(CreateBionics.asResource("item/whistle_base_side_small").withSuffix(variant(entity))) : PartialModel.of(CreateBionics.asResource("item/whistle_base_side_small5"))
                : size == 2 ? entity.getGlowColor() <2 ? PartialModel.of(CreateBionics.asResource("item/whistle_base_side_medium").withSuffix(variant(entity))) : PartialModel.of(CreateBionics.asResource("item/whistle_base_side_medium5"))
                : entity.getGlowColor() <2 ? PartialModel.of(CreateBionics.asResource("item/whistle_base_side_large").withSuffix(variant(entity))) : PartialModel.of(CreateBionics.asResource("item/whistle_base_side_large5"));

        PartialModel base = xPos < 0 ? base_side : xPos == 0 ? base_middle : base_side;

        PartialModel extension = size == 1 ? entity.getGlowColor() <2 ? PartialModel.of(CreateBionics.asResource("item/whistle_middle_small").withSuffix(variant(entity))) : PartialModel.of(CreateBionics.asResource("item/whistle_middle_small5"))
                : size == 2 ? entity.getGlowColor() <2 ? PartialModel.of(CreateBionics.asResource("item/whistle_middle_medium").withSuffix(variant(entity))) : PartialModel.of(CreateBionics.asResource("item/whistle_middle_medium5"))
                : entity.getGlowColor() <2 ? PartialModel.of(CreateBionics.asResource("item/whistle_middle_large").withSuffix(variant(entity))) : PartialModel.of(CreateBionics.asResource("item/whistle_middle_large5"));

        PartialModel end = size == 1 ? entity.getGlowColor() <2 ? PartialModel.of(CreateBionics.asResource("item/whistle_end_small").withSuffix(variant(entity))) : PartialModel.of(CreateBionics.asResource("item/whistle_end_small5"))
                : size == 2 ? entity.getGlowColor() <2 ? PartialModel.of(CreateBionics.asResource("item/whistle_end_medium").withSuffix(variant(entity))) : PartialModel.of(CreateBionics.asResource("item/whistle_end_medium5"))
                : entity.getGlowColor() <2 ? PartialModel.of(CreateBionics.asResource("item/whistle_end_large").withSuffix(variant(entity))) : PartialModel.of(CreateBionics.asResource("item/whistle_end_large5"));

        for (int i = 0; i < count && index + i <= build; i++) {
            CachedBuffers.partial(base, entity.getBlockStateOn())
                    .rotate(Direction.Axis.X, (float)Math.PI)
                    .translate(0, 0, 1 + 14/16f)
                    .rotateYDegrees(-netHeadYaw)
                    .translate(xPos, 7 + bodyYOffset + yPos + i * 0.2, zPos - separation * i)
                    .rotate(Direction.Axis.Z, xPos == 0 ? 0 : xPos > 0 ? i * 0.1f + angle : -i * 0.1f - angle)
                    .rotate(Direction.Axis.Y, xPos > 0 ? (float) Math.PI : 0)
                    .light(entity.getGlowColor() < 2 ? packedLight : 15728880)
                    .renderInto(poseStack, buffer.getBuffer(RenderType.cutout()));

            CachedBuffers.partial(end, entity.getBlockStateOn())
                    .rotate(Direction.Axis.X, (float)Math.PI)
                    .translate(0, 0, 1 + 14/16f)
                    .rotateYDegrees(-netHeadYaw)
                    .translate(xPos, 7 + bodyYOffset + yPos + i * 0.2, zPos - separation * i)
                    .rotate(Direction.Axis.Z, xPos == 0 ? 0 : xPos > 0 ? i * 0.1f + angle : -i * 0.1f - angle)
                    .translate(0, (height/2f) + (i/4f) + 1, 0)
                    .light(entity.getGlowColor() < 2 ? packedLight : 15728880)
                    .renderInto(poseStack, buffer.getBuffer(RenderType.cutout()));
            CachedBuffers.partial(extension, entity.getBlockStateOn())
                    .rotate(Direction.Axis.X, (float)Math.PI)
                    .translate(0, 0, 1 + 14/16f)
                    .rotateYDegrees(-netHeadYaw)
                    .translate(xPos, 7 + bodyYOffset + yPos + i * 0.2, zPos - separation * i)
                    .rotate(Direction.Axis.Z, xPos == 0 ? 0 : xPos > 0 ? i * 0.1f + angle : -i * 0.1f - angle)
                    .translate(0, (height/2f) + (i/4f) + 0.5, 0)
                    .scale(0.999f)
                    .light(entity.getGlowColor() < 2 ? packedLight : 15728880)
                    .renderInto(poseStack, buffer.getBuffer(RenderType.cutout()));

            for (int j = 0; j < i / 2 + height; j++) {
                CachedBuffers.partial(extension, entity.getBlockStateOn())
                        .rotate(Direction.Axis.X, (float)Math.PI)
                        .translate(0, 0, 1 + 14/16f)
                        .rotateYDegrees(-netHeadYaw)
                        .translate(xPos, 7 + bodyYOffset + yPos + i * 0.2, zPos - separation * i)
                        .rotate(Direction.Axis.Z, xPos == 0 ? 0 : xPos > 0 ? i * 0.1f + angle : -i * 0.1f - angle)
                        .translate(0, j * 0.5f + 1, 0)
                        .light(entity.getGlowColor() < 2 ? packedLight : 15728880)
                        .renderInto(poseStack, buffer.getBuffer(RenderType.cutout()));
            }
        }
    }

    public void renderWhistlesTail2(OrganEntity entity, float netHeadYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight,
                                    int count, int size, int height, float separation, float xPos, float yPos, float zPos, float angle, int index) {
        float ySwing = entity.getAssembly() >= 21 ? (float) Math.sin((AnimationTickHolder.getTicks() + AnimationTickHolder.getPartialTicks()) / -16) * 3.55f : 0;
        float ySwing2 = entity.getAssembly() >= 21 ? (float) Math.sin(((AnimationTickHolder.getTicks() + AnimationTickHolder.getPartialTicks()) / -16) + 2) * 3.55f : 0;
        float bodyYOffset = (entity.getAssembly() >= 21 ? (float) Math.sin(((AnimationTickHolder.getTicks() + AnimationTickHolder.getPartialTicks()) / 22)) / -32 : 0) - entity.getSitYOffset()/16;
        int build = entity.getAssembly() - 22;
        netHeadYaw = Mth.clamp(netHeadYaw, -60.0F, 60.0F) / 2;
        PartialModel base_middle = size == 1 ? (entity.getGlowColor() <2 ? PartialModel.of(CreateBionics.asResource("item/whistle_base_middle_small").withSuffix(variant(entity)))
                : PartialModel.of(CreateBionics.asResource("item/whistle_base_middle_small5")))
                : size == 2 ? (entity.getGlowColor() <2 ? PartialModel.of(CreateBionics.asResource("item/whistle_base_middle_medium").withSuffix(variant(entity)))
                : PartialModel.of(CreateBionics.asResource("item/whistle_base_middle_medium5")))
                : entity.getGlowColor() <2 ? PartialModel.of(CreateBionics.asResource("item/whistle_base_middle_large").withSuffix(variant(entity)))
                : PartialModel.of(CreateBionics.asResource("item/whistle_base_middle_large5"));

        PartialModel base_side = size == 1 ? entity.getGlowColor() <2 ? PartialModel.of(CreateBionics.asResource("item/whistle_base_side_small").withSuffix(variant(entity))) : PartialModel.of(CreateBionics.asResource("item/whistle_base_side_small5"))
                : size == 2 ? entity.getGlowColor() <2 ? PartialModel.of(CreateBionics.asResource("item/whistle_base_side_medium").withSuffix(variant(entity))) : PartialModel.of(CreateBionics.asResource("item/whistle_base_side_medium5"))
                : entity.getGlowColor() <2 ? PartialModel.of(CreateBionics.asResource("item/whistle_base_side_large").withSuffix(variant(entity))) : PartialModel.of(CreateBionics.asResource("item/whistle_base_side_large5"));

        PartialModel base = xPos < 0 ? base_side : xPos == 0 ? base_middle : base_side;

        PartialModel extension = size == 1 ? entity.getGlowColor() <2 ? PartialModel.of(CreateBionics.asResource("item/whistle_middle_small").withSuffix(variant(entity))) : PartialModel.of(CreateBionics.asResource("item/whistle_middle_small5"))
                : size == 2 ? entity.getGlowColor() <2 ? PartialModel.of(CreateBionics.asResource("item/whistle_middle_medium").withSuffix(variant(entity))) : PartialModel.of(CreateBionics.asResource("item/whistle_middle_medium5"))
                : entity.getGlowColor() <2 ? PartialModel.of(CreateBionics.asResource("item/whistle_middle_large").withSuffix(variant(entity))) : PartialModel.of(CreateBionics.asResource("item/whistle_middle_large5"));

        PartialModel end = size == 1 ? entity.getGlowColor() <2 ? PartialModel.of(CreateBionics.asResource("item/whistle_end_small").withSuffix(variant(entity))) : PartialModel.of(CreateBionics.asResource("item/whistle_end_small5"))
                : size == 2 ? entity.getGlowColor() <2 ? PartialModel.of(CreateBionics.asResource("item/whistle_end_medium").withSuffix(variant(entity))) : PartialModel.of(CreateBionics.asResource("item/whistle_end_medium5"))
                : entity.getGlowColor() <2 ? PartialModel.of(CreateBionics.asResource("item/whistle_end_large").withSuffix(variant(entity))) : PartialModel.of(CreateBionics.asResource("item/whistle_end_large5"));

        for (int i = 0; i < count && index + i <= build; i++) {
            CachedBuffers.partial(base, entity.getBlockStateOn())
                    .rotate(Direction.Axis.X, (float)Math.PI)
                    .translate(0, 0, -2 - 1 / 8f)
                    .rotateYDegrees(ySwing + netHeadYaw)
                    .translate(0, 0, -76.5/16f)
                    .rotateYDegrees(ySwing2 + netHeadYaw)
                    .translate(xPos, separation < 0 ? 7 + bodyYOffset + yPos - i * 0.04 : 7 + bodyYOffset + yPos - i * 0.02, zPos - separation * i)
                    .rotate(Direction.Axis.Z, xPos == 0 ? 0 : xPos < 0 ? i * 0.1f + angle : -i * 0.1f - angle)
                    .rotate(Direction.Axis.Y, xPos > 0 ? (float) Math.PI : 0)
                    .light(entity.getGlowColor() < 2 ? packedLight : 15728880)
                    .renderInto(poseStack, buffer.getBuffer(RenderType.cutout()));
            CachedBuffers.partial(extension, entity.getBlockStateOn())
                    .rotate(Direction.Axis.X, (float)Math.PI)
                    .translate(0, 0, -2 - 1 / 8f)
                    .rotateYDegrees(ySwing + netHeadYaw)
                    .translate(0, 0, -76.5/16f)
                    .rotateYDegrees(ySwing2 + netHeadYaw)
                    .translate(xPos, separation < 0 ? 7 + bodyYOffset + yPos - i * 0.04 : 7 + bodyYOffset + yPos - i * 0.02, zPos - separation * i)
                    .rotate(Direction.Axis.Z, xPos == 0 ? 0 : xPos < 0 ? i * 0.1f + angle : -i * 0.1f - angle)
                    .translate(0, (height/2f) + (i/4f) + 0.5, 0)
                    .scale(0.999f)
                    .light(entity.getGlowColor() < 2 ? packedLight : 15728880)
                    .renderInto(poseStack, buffer.getBuffer(RenderType.cutout()));
            CachedBuffers.partial(end, entity.getBlockStateOn())
                    .rotate(Direction.Axis.X, (float)Math.PI)
                    .translate(0, 0, -2 - 1 / 8f)
                    .rotateYDegrees(ySwing + netHeadYaw)
                    .translate(0, 0, -76.5/16f)
                    .rotateYDegrees(ySwing2 + netHeadYaw)
                    .translate(xPos, separation < 0 ? 7 + bodyYOffset + yPos - i * 0.04 : 7 + bodyYOffset + yPos - i * 0.02, zPos - separation * i)
                    .rotate(Direction.Axis.Z, xPos == 0 ? 0 : xPos < 0 ? i * 0.1f + angle : -i * 0.1f - angle)
                    .translate(0, (height/2f) + (i/4f) + 1, 0)
                    .scale(0.999f)
                    .light(entity.getGlowColor() < 2 ? packedLight : 15728880)
                    .renderInto(poseStack, buffer.getBuffer(RenderType.cutout()));

            for (int j = 0; j < i / 2 + height; j++) {
                CachedBuffers.partial(extension, entity.getBlockStateOn())
                        .rotate(Direction.Axis.X, (float)Math.PI)
                        .translate(0, 0, -2 - 1 / 8f)
                        .rotateYDegrees(ySwing + netHeadYaw)
                        .translate(0, 0, -76.5/16f)
                        .rotateYDegrees(ySwing2 + netHeadYaw)
                        .translate(xPos, separation < 0 ? 7 + bodyYOffset + yPos - i * 0.04 : 7 + bodyYOffset + yPos - i * 0.02, zPos - separation * i)
                        .rotate(Direction.Axis.Z, xPos == 0 ? 0 : xPos < 0 ? i * 0.1f + angle : -i * 0.1f - angle)
                        .translate(0, j * 0.5f + 1, 0)
                        .light(entity.getGlowColor() < 2 ? packedLight : 15728880)
                        .renderInto(poseStack, buffer.getBuffer(RenderType.cutout()));
            }
        }
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight, OrganEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        int integer = entity.exhaustProgress;
            this.getParentModel().copyPropertiesTo(this.model);
            this.model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
            this.model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            if (integer < 10) {
                VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.entityTranslucentCull(EXHAUST_MAP_1.get(integer)));
                this.model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY);
            } else if (integer < 20) {
                VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.itemEntityTranslucentCull(EXHAUST_MAP_2.get(integer)));
                this.model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY);
            } else {
                VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.itemEntityTranslucentCull(EXHAUST_MAP_3.get(integer)));
                this.model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY);
            }

        //back middle
        renderWhistles(entity, netHeadYaw, partialTicks, poseStack, buffer, packedLight,
                4, 3, 4, 7/8f, 0, -1.5f, 0.5f, 0, 0);

        //back right
        renderWhistles(entity, netHeadYaw, partialTicks, poseStack, buffer, packedLight,
                4, 3, 1, -7/8f, -1.2f, -2.15f, -2 - 1/8f, -0.1f, 4);
        renderWhistles(entity, netHeadYaw, partialTicks, poseStack, buffer, packedLight,
                4, 3, 1, -7/8f, -1.6f, -2.95f, -17/8f, 0.3f, 8);

        //back left
        renderWhistles(entity, netHeadYaw, partialTicks, poseStack, buffer, packedLight,
                4, 3, 1, -7/8f, 1.2f, -2.15f, -2 - 1/8f, -0.1f, 12);
        renderWhistles(entity, netHeadYaw, partialTicks, poseStack, buffer, packedLight,
                4, 3, 1, -7/8f, 1.6f, -2.95f, -17/8f, 0.3f, 16);

        //chest middle
        renderWhistlesChest(entity, netHeadYaw, partialTicks, poseStack, buffer, packedLight,
                6, 2, 1, 12/16f, 0, -2.5f, 4, 0, 20);

        //tail 1 middle
        renderWhistlesTail1(entity, netHeadYaw, partialTicks, poseStack, buffer, packedLight,
                6, 2, 6, -12/16f, 0, -2.7f, -4 - 7/16f, 0, 26);

        //tail 1 left
        renderWhistlesTail1(entity, netHeadYaw, partialTicks, poseStack, buffer, packedLight,
                4, 2, 1, -12/16f, 1.25f, -4.1f, -4 - 4/16f, -0.261799f, 32);
        renderWhistlesTail1(entity, netHeadYaw, partialTicks, poseStack, buffer, packedLight,
                2, 3, 3, -12/16f, 1.1f, -3.8f, -1 - 4/16f, 0.0872665f, 36);
        renderWhistlesTail1(entity, netHeadYaw, partialTicks, poseStack, buffer, packedLight,
                2, 2, 1, -12/16f, 1.1f, -4.7f, -1 - 2/16f, -0.349066f, 38);

        //tail 1 right
        renderWhistlesTail1(entity, netHeadYaw, partialTicks, poseStack, buffer, packedLight,
                4, 2, 1, -12/16f, -1.25f, -4.1f, -4 - 4/16f, -0.261799f, 40);
        renderWhistlesTail1(entity, netHeadYaw, partialTicks, poseStack, buffer, packedLight,
                2, 3, 3, -12/16f, -1.1f, -3.8f, -1 - 4/16f, 0.0872665f, 44);
        renderWhistlesTail1(entity, netHeadYaw, partialTicks, poseStack, buffer, packedLight,
                2, 2, 1, -12/16f, -1.1f, -4.7f, -1 - 2/16f, -0.349066f, 46);

        //tail 2 middle
        renderWhistlesTail2(entity, netHeadYaw, partialTicks, poseStack, buffer, packedLight,
                8, 1, 2, -10/16f, 0, -2.5f, -4 - 14/16f, 0, 48);

        //tail 2 left
        renderWhistlesTail2(entity, netHeadYaw, partialTicks, poseStack, buffer, packedLight,
                6, 1, 2, 10/16f, 0.7f, -3.4f, -1 - 13/16f, 0.0872665f, 56);
        renderWhistlesTail2(entity, netHeadYaw, partialTicks, poseStack, buffer, packedLight,
                6, 1, 2, 10/16f, -0.7f, -3.4f, -1 - 13/16f, 0.0872665f, 62);

        renderWhistlesTail2(entity, netHeadYaw, partialTicks, poseStack, buffer, packedLight,
                8, 1, 2, 10/16f, 0.7f, -4f - 1/16f, -9/16f, 0.1872665f, 68);
        renderWhistlesTail2(entity, netHeadYaw, partialTicks, poseStack, buffer, packedLight,
                8, 1, 2, 10/16f, -0.7f, -4f - 1/16f, -9/16f, 0.1872665f, 76);
    }
}

