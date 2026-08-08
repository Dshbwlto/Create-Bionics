package net.dshbwlto.createbionics.entity.client.matchbox;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.dshbwlto.createbionics.BionicsClientConfig;
import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.entity.client.BionicsModelLayers;
import net.dshbwlto.createbionics.entity.client.seeker.SeekerGlowLayer;
import net.dshbwlto.createbionics.entity.custom.MatchboxEntity;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import java.util.Map;

public class MatchboxRenderer extends MobRenderer<MatchboxEntity, MatchboxModel<MatchboxEntity>> {
    private final Map<MatchboxVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(MatchboxVariant.class),map -> {
                map.put(MatchboxVariant.COPPER,
                        ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/matchbox/matchbox_copper.png"));
                map.put(MatchboxVariant.BRASS,
                        ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/matchbox/matchbox_brass.png"));
                map.put(MatchboxVariant.ANDESITE,
                        ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/matchbox/matchbox_andesite.png"));
            });

    public MatchboxRenderer(EntityRendererProvider.Context context) {
        super(context, new MatchboxModel<>(context.bakeLayer(BionicsModelLayers.MATCHBOX)), 0.25f);
        this.addLayer(new MatchboxGlowLayer(this, context.getModelSet()));
    }

    @Override
    public ResourceLocation getTextureLocation(MatchboxEntity entity) {
        return BionicsClientConfig.arachnophobia ? ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/matchbox/matchbox_alt.png") : LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    @Override
    public void render(MatchboxEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}