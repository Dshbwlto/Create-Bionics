package net.dshbwlto.createbionics.entity.client.oxhauler;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.createmod.catnip.animation.AnimationTickHolder;
import net.createmod.catnip.render.CachedBuffers;
import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.entity.client.BionicsModelLayers;
import net.dshbwlto.createbionics.entity.custom.OxhaulerEntity;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.Material;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.entity.BannerBlockEntity;
import net.minecraft.world.level.block.entity.BannerPatternLayers;

import java.util.Map;

public class OxhaulerRenderer extends MobRenderer<OxhaulerEntity, OxhaulerModel<OxhaulerEntity>> {
    private static final Map<OxhaulerVariant, ResourceLocation> LOCATION_BY_VARIANT =
        Util.make(Maps.newEnumMap(OxhaulerVariant.class), map -> {
            map.put(OxhaulerVariant.BRASS,
                    ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/oxhauler/oxhauler_brass.png"));
            map.put(OxhaulerVariant.COPPER,
                    ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/oxhauler/oxhauler_copper.png"));
            map.put(OxhaulerVariant.ANDESITE,
                    ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/oxhauler/oxhauler_andesite.png"));
        });

    public static final String FLAG = "flag";
    private static final String POLE = "pole";
    private static final String BAR = "bar";
    private final ModelPart flag;

    public OxhaulerRenderer(EntityRendererProvider.Context context) {
        super(context, new OxhaulerModel<>(context.bakeLayer(BionicsModelLayers.OXHAULER)), 1.6f);
        this.addLayer(new OxhaulerGlowLayer(this, context.getModelSet()));
        this.addLayer(new OxhaulerColorLayer(this, context.getModelSet()));

        ModelPart modelpart = context.bakeLayer(ModelLayers.BANNER);
        this.flag = modelpart.getChild("flag");
    }

    @Override
    public ResourceLocation getTextureLocation(OxhaulerEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        partdefinition.addOrReplaceChild("flag", CubeListBuilder.create().texOffs(0, 0).addBox(-10.0F, 0.0F, -2.0F, 20.0F, 40.0F, 1.0F), PartPose.ZERO);
        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void render(OxhaulerEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
        CachedBuffers.partial(PartialModel.of(CreateBionics.asResource("item/oxhauler_fire")), entity.getBlockStateOn())
                .rotate(Direction.Axis.Y, -entityYaw * Mth.PI / 180)
                .translate(-0.5, 0.75, -0.5)
                .light(15728880)
                .renderInto(poseStack, buffer.getBuffer(RenderType.cutout()));

        if (entity.getInventory().getItem(1).getItem() instanceof BannerItem bannerItem) {

            poseStack.pushPose();
            poseStack.scale(0.6666667F, -0.6666667F, -0.6666667F);
            VertexConsumer vertexconsumer = ModelBakery.BANNER_BASE.buffer(buffer, RenderType::entitySolid);
            BlockPos blockpos = entity.getOnPos();
            float f2 = ((float) Math.floorMod((long) (blockpos.getX() * 7L + blockpos.getY() * 9L + blockpos.getZ() * 13L), 100L) + AnimationTickHolder.getPartialTicks()) / 100.0F;
            this.flag.xRot = (-0.0125F + 0.01F * Mth.cos(((float) Math.PI * 2F) * f2)) * (float) Math.PI;
            this.flag.y = -32.0F;
            //renderPatterns(poseStack, buffer, packedLight, packedLight, this.flag, ModelBakery.BANNER_BASE, true, (color), (pattern));
            poseStack.popPose();
            poseStack.popPose();
        }
    }

    public static void renderPatterns(PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay, ModelPart flagPart, Material flagMaterial, boolean banner, DyeColor baseColor, BannerPatternLayers patterns) {
        renderPatterns(poseStack, buffer, packedLight, packedOverlay, flagPart, flagMaterial, banner, baseColor, patterns, false);
    }

    public static void renderPatterns(PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay, ModelPart flagPart, Material flagMaterial, boolean banner, DyeColor baseColor, BannerPatternLayers patterns, boolean glint) {
        flagPart.render(poseStack, flagMaterial.buffer(buffer, RenderType::entitySolid, glint), packedLight, packedOverlay);
        renderPatternLayer(poseStack, buffer, packedLight, packedOverlay, flagPart, banner ? Sheets.BANNER_BASE : Sheets.SHIELD_BASE, baseColor);

        for(int i = 0; i < 16 && i < patterns.layers().size(); ++i) {
            BannerPatternLayers.Layer bannerpatternlayers$layer = (BannerPatternLayers.Layer)patterns.layers().get(i);
            Material material = banner ? Sheets.getBannerMaterial(bannerpatternlayers$layer.pattern()) : Sheets.getShieldMaterial(bannerpatternlayers$layer.pattern());
            renderPatternLayer(poseStack, buffer, packedLight, packedOverlay, flagPart, material, bannerpatternlayers$layer.color());
        }

    }

    private static void renderPatternLayer(PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay, ModelPart flagPart, Material material, DyeColor color) {
        int i = color.getTextureDiffuseColor();
        flagPart.render(poseStack, material.buffer(buffer, RenderType::entityNoOutline), packedLight, packedOverlay, i);
    }

    @Override
    public boolean shouldRender(OxhaulerEntity livingEntity, Frustum camera, double camX, double camY, double camZ) {
        return true;
    }
}
