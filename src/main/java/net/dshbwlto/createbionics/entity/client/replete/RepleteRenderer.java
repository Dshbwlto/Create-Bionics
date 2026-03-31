package net.dshbwlto.createbionics.entity.client.replete;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.createmod.catnip.platform.NeoForgeCatnipServices;
import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.entity.client.BionicsModelLayers;

import net.dshbwlto.createbionics.entity.custom.RepleteEntity;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.FluidStack;

import java.util.Map;

public class RepleteRenderer extends MobRenderer<RepleteEntity, RepleteModel<RepleteEntity>> {

    private static final Map<RepleteVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(RepleteVariant.class), map -> {
                map.put(RepleteVariant.COPPER,
                        ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/replete/replete_copper.png"));
                map.put(RepleteVariant.BRASS,
                        ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/replete/replete_brass.png"));
                map.put(RepleteVariant.ANDESITE,
                        ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/replete/replete_andesite.png"));
            });

    public RepleteRenderer(EntityRendererProvider.Context context) {
        super (context, new RepleteModel<>(context.bakeLayer(BionicsModelLayers.REPLETE)), 2.5f);
        this.addLayer(new RepleteGlowLayer(this, context.getModelSet()));
    }

    @Override
    public ResourceLocation getTextureLocation(RepleteEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    @Override
    public void render(RepleteEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
        FluidStack fluidStack = entity.getSynchedFluid();

        if (fluidStack.isEmpty())
            return;
        if (entity.getHealth() == 0) {
            return;
        }
        float height = (fluidStack.getAmount() / 160000f) * -4.5f;

        poseStack.pushPose();
        poseStack.mulPose(Axis.YN.rotation(entityYaw * (Mth.PI / 180)));
        poseStack.translate(0, 38/16f - height - entity.sitOffset, -7/8f);
        NeoForgeCatnipServices.FLUID_RENDERER.renderFluidBox(fluidStack, -15/16f, height, -15/16f, 15/16f, 0, 15/16f, buffer,
                poseStack, packedLight, false, true);
        poseStack.popPose();
    }
}