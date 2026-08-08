package net.dshbwlto.createbionics.entity.client.replete;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.createmod.catnip.animation.AnimationTickHolder;
import net.createmod.catnip.platform.NeoForgeCatnipServices;
import net.createmod.catnip.render.CachedBuffers;
import net.dshbwlto.createbionics.BionicsClientConfig;
import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.entity.client.BionicsModelLayers;

import net.dshbwlto.createbionics.entity.custom.RepleteEntity;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.fluids.FluidStack;

import java.util.Map;

public class RepleteRenderer extends MobRenderer {

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
    public ResourceLocation getTextureLocation(Entity entity) {
        RepleteEntity replete = (RepleteEntity) entity;
        return !BionicsClientConfig.arachnophobia ? LOCATION_BY_VARIANT.get(replete.getVariant()) : ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/replete/replete_alt.png");
    }

    @Override
    public void render(LivingEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
        RepleteEntity replete = (RepleteEntity) entity;
        FluidStack fluidStack = replete.getSynchedFluid();

        PartialModel arrow = (PartialModel.of(CreateBionics.asResource("item/debug_cube")));
        /*
        CachedBuffers.partial(arrow, entity.getBlockStateOn())
                .translate(-entity.getX(), -entity.getY(), -entity.getZ())
                .translate(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())
                .light(1000)
                .renderInto(poseStack, buffer.getBuffer(RenderType.cutout()));
         */

        if (!replete.isSitting()) {
            if (replete.getYOffs() > 0) {
                replete.setYOffs((replete.getYOffs() - 0.03f * partialTicks));
            }
        } else {
            if (replete.getYOffs() < 1) {
                replete.setYOffs(replete.getYOffs() + 0.03f * partialTicks);
            }
        }

        if (fluidStack.isEmpty())
            return;
        if (replete.getHealth() == 0) {
            return;
        }

        float height = (fluidStack.getAmount() / 160000f) * -4.5f;

        if (AnimationTickHolder.getTicks() == 20 && replete.isSitting()) {
            replete.setYOffs(1);
        }

        poseStack.pushPose();
        poseStack.mulPose(Axis.YN.rotation(replete.getPreciseBodyRotation(partialTicks) * (Mth.PI / 180)));
        poseStack.translate(0, 38/16f - height - replete.getYOffs(), -7/8f);
        NeoForgeCatnipServices.FLUID_RENDERER.renderFluidBox(fluidStack, -15/16f, height, -15/16f, 15/16f, 0, 15/16f, buffer,
                poseStack, packedLight, false, true);
        poseStack.popPose();
    }

    @Override
    public boolean shouldRender(Entity livingEntity, Frustum camera, double camX, double camY, double camZ) {
        return true;
    }
}