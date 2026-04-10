
package net.dshbwlto.createbionics.entity.client.replete;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.createmod.catnip.animation.AnimationTickHolder;
import net.createmod.catnip.animation.LerpedFloat;
import net.createmod.catnip.platform.NeoForgeCatnipServices;
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
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;

public class RepleteGlowLayer extends RenderLayer<RepleteEntity, RepleteModel<RepleteEntity>> {
    private final RepleteModel<RepleteEntity> model;

    public RepleteGlowLayer(RenderLayerParent<RepleteEntity, RepleteModel<RepleteEntity>> renderer, EntityModelSet models) {
        super(renderer);
        this.model = new RepleteModel<>(models.bakeLayer(BionicsModelLayers.REPLETE_GLOW));
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight, RepleteEntity livingEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (livingEntity.getFuel() > 0) {
            this.getParentModel().copyPropertiesTo(this.model);
            this.model.prepareMobModel(livingEntity, limbSwing, limbSwingAmount, partialTicks);
            this.model.setupAnim(livingEntity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.entityTranslucentEmissive(
                    ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/replete/replete_glow.png")));
            this.model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY);
        }
    }
}
