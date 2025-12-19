package net.dshbwlto.createbionics.entity.client.replete;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.entity.client.BionicsModelLayers;
import net.dshbwlto.createbionics.entity.custom.RepleteEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.FluidStack;

public class RepleteGlowLayer extends RenderLayer<RepleteEntity, RepleteModel<RepleteEntity>> {
    private final RepleteModel<RepleteEntity> model;

    public RepleteGlowLayer(RenderLayerParent<RepleteEntity, RepleteModel<RepleteEntity>> renderer, EntityModelSet models) {
        super(renderer);
        this.model = new RepleteModel<>(models.bakeLayer(BionicsModelLayers.REPLETE_GLOW));
    }
    @Override
    public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight, RepleteEntity livingEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getParentModel().copyPropertiesTo(this.model);
        this.model.prepareMobModel(livingEntity, limbSwing, limbSwingAmount, partialTicks);
        this.model.setupAnim(livingEntity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.entityTranslucentEmissive(ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/replete/replete_glow.png")));
        this.model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY);

        FluidStack fluidStack = livingEntity.getFluid();
        if (fluidStack.isEmpty())
            return;

        IClientFluidTypeExtensions fluidTypeExtensions = IClientFluidTypeExtensions.of(fluidStack.getFluid());
        ResourceLocation stillTexture = fluidTypeExtensions.getStillTexture(fluidStack);

        FluidState state = fluidStack.getFluid().defaultFluidState();

        TextureAtlasSprite sprite = Minecraft.getInstance().getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(stillTexture);
        int tintColor = fluidTypeExtensions.getTintColor();

        float height = (float) ((livingEntity.getFluid().getAmount()) / 1100) / 32 + 0.85f;

        VertexConsumer builder = buffer.getBuffer(ItemBlockRenderTypes.getRenderLayer(state));

        // Top Texture
        poseStack.pushPose();
        poseStack.translate(0, 0.1f + livingEntity.fluidLevel, 0.85);
        poseStack.mulPose(Axis.XP.rotationDegrees(167.5f));
        drawQuad(builder, poseStack, 0f, height, 0f, (15f/16f), height, (15f/16f), sprite.getU0(), sprite.getV0(), sprite.getU1(), sprite.getV1(), packedLight, tintColor);
        drawQuad(builder, poseStack, 0f, height, 0f, -(15f/16f), height, -(15f/16f), sprite.getU0(), sprite.getV0(), sprite.getU1(), sprite.getV1(), packedLight, tintColor);
        drawQuad(builder, poseStack, 15f/16f, height, 0f, 0, height, -(15f/16f), sprite.getU0(), sprite.getV0(), sprite.getU1(), sprite.getV1(), packedLight, tintColor);
        drawQuad(builder, poseStack, -(15f/16f), height, 0f, 0, height, (15f/16f), sprite.getU0(), sprite.getV0(), sprite.getU1(), sprite.getV1(), packedLight, tintColor);
        poseStack.popPose();

        poseStack.pushPose();
        poseStack.translate(-1f, -0.5 + livingEntity.fluidLevel, 1.73f);
        poseStack.mulPose(Axis.XP.rotationDegrees(167.5f));

        //back
        drawQuad(builder, poseStack, 0.5f, -0.1f, -0.207f, 1.5f, height - 0.775f, -0.207f, sprite.getU0(), sprite.getV0(), sprite.getU1(), sprite.getV1(), packedLight, tintColor);
        //front
        drawQuad(builder, poseStack, 1.5f, -0.1f, 1.665f, 0.5f, height - 0.775f, 1.665f, sprite.getU0(), sprite.getV0(), sprite.getU1(), sprite.getV1(), packedLight, tintColor);
        poseStack.popPose();

        poseStack.pushPose();
        poseStack.translate(-1f, -0.5 + livingEntity.fluidLevel, 1.73f);
        poseStack.mulPose(Axis.YN.rotationDegrees(90));
        poseStack.mulPose(Axis.ZN.rotationDegrees(-12.5f));
        //left
        drawQuad(builder, poseStack, -0.3f, 0.1f, -1.94f, -1.3f, -height + 0.773f, -1.94f, sprite.getU0(), sprite.getV0(), sprite.getU1(), sprite.getV1(), packedLight, tintColor);
        //right
        drawQuad(builder, poseStack, -1.3f, 0.1f, -0.06f, -0.3f, -height + 0.773f, -0.06f, sprite.getU0(), sprite.getV0(), sprite.getU1(), sprite.getV1(), packedLight, tintColor);
        poseStack.popPose();
    }
    private static void drawVertex(VertexConsumer builder, PoseStack poseStack, float x, float y, float z, float u, float v, int packedLight, int color) {
        builder.addVertex(poseStack.last().pose(), x, y, z)
                .setColor(color)
                .setUv(u, v)
                .setLight(packedLight)
                .setNormal(1, 0, 0);
    }

    private static void drawQuad(VertexConsumer builder, PoseStack poseStack, float x0, float y0, float z0, float x1, float y1, float z1, float u0, float v0, float u1, float v1, int packedLight, int color) {
        drawVertex(builder, poseStack, x0, y0, z0, u0, v0, packedLight, color);
        drawVertex(builder, poseStack, x0, y1, z1, u0, v1, packedLight, color);
        drawVertex(builder, poseStack, x1, y1, z1, u1, v1, packedLight, color);
        drawVertex(builder, poseStack, x1, y0, z0, u1, v0, packedLight, color);
    }
}


