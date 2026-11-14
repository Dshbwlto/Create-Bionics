package net.dshbwlto.createbionics.entity.client.matchbox;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.createmod.catnip.render.CachedBuffers;
import net.dshbwlto.createbionics.BionicsClientConfig;
import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.Util.BionicsPartialModels;
import net.dshbwlto.createbionics.entity.client.BionicsModelLayers;
import net.dshbwlto.createbionics.entity.client.RobotVariant;
import net.dshbwlto.createbionics.entity.client.seeker.SeekerGlowLayer;
import net.dshbwlto.createbionics.entity.custom.MatchboxEntity;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import java.util.Map;

public class MatchboxRenderer extends MobRenderer<MatchboxEntity, MatchboxModel<MatchboxEntity>> {
    private final Map<RobotVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(RobotVariant.class),map -> {
                map.put(RobotVariant.COPPER,
                        ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/item/entity/matchbox/matchbox_2.png"));
                map.put(RobotVariant.BRASS,
                        ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/item/entity/matchbox/matchbox_1.png"));
                map.put(RobotVariant.ANDESITE,
                        ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/item/entity/matchbox/matchbox_0.png"));
            });

    public MatchboxRenderer(EntityRendererProvider.Context context) {
        super(context, new MatchboxModel<>(context.bakeLayer(BionicsModelLayers.MATCHBOX)), 0.25f);
        this.addLayer(new MatchboxGlowLayer(this, context.getModelSet()));
    }

    @Override
    public ResourceLocation getTextureLocation(MatchboxEntity entity) {
        return BionicsClientConfig.arachnophobia ? ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/item/entity/matchbox/matchbox_alt.png")
                : ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/item/entity/matchbox/matchbox_" + entity.getTypeVariant() + ".png");
    }

    @Override
    public void render(MatchboxEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}