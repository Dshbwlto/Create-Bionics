package net.dshbwlto.createbionics.entity.client.seeker;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.simibubi.create.content.logistics.depot.DepotRenderer;
import dev.engine_room.flywheel.lib.transform.TransformStack;
import net.createmod.catnip.animation.AnimationTickHolder;
import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.entity.client.BionicsModelLayers;
import net.dshbwlto.createbionics.entity.custom.SeekerEntity;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.phys.Vec3;

import java.util.Map;

public class SeekerRenderer extends MobRenderer<SeekerEntity, SeekerModel<SeekerEntity>> {
    private final Map<SeekerVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(SeekerVariant.class),map -> {
                map.put(SeekerVariant.COPPER,
                        ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/seeker/seeker_copper.png"));
                map.put(SeekerVariant.BRASS,
                        ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/seeker/seeker_brass.png"));
                map.put(SeekerVariant.ANDESITE,
                        ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/seeker/seeker_andesite.png"));
            });

    public SeekerRenderer(EntityRendererProvider.Context context) {
        super(context, new SeekerModel<>(context.bakeLayer(BionicsModelLayers.SEEKER)), 0.25f);
        this.addLayer(new SeekerGlowLayer(this, context.getModelSet()));
        this.addLayer(new SeekerPickaxeLayer(this, context.getModelSet()));
    }

    @Override
    public ResourceLocation getTextureLocation(SeekerEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    @Override
    public void render(SeekerEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        if (entity.invisible) {
            poseStack.scale(0, 0, 0);
        }
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        ItemStack stack = entity.displayStack;

        poseStack.pushPose();
        poseStack.translate(0, 0.75 + Math.sin((AnimationTickHolder.getTicks() + AnimationTickHolder.getPartialTicks()) / 12) / 16, 0);
        poseStack.scale(0.5f, 0.5f, 0.5f);
        poseStack.mulPose(Axis.YP.rotationDegrees(AnimationTickHolder.getTicks() + AnimationTickHolder.getPartialTicks()));

        if (stack != null && entity.scanning) {
            itemRenderer.renderStatic(stack, ItemDisplayContext.FIXED, packedLight,
                    OverlayTexture.NO_OVERLAY, poseStack, buffer, entity.level(), 1);
        }
        poseStack.popPose();

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}