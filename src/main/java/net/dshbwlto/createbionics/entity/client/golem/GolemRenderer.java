package net.dshbwlto.createbionics.entity.client.golem;

import com.mojang.blaze3d.vertex.PoseStack;
import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.entity.api.GolemEntity;
import net.dshbwlto.createbionics.entity.client.BionicsModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.intellij.lang.annotations.Identifier;

public class GolemRenderer extends MobRenderer {
    public GolemRenderer(EntityRendererProvider.Context context) {
        super(context,
                new GolemModel<>(context.bakeLayer(BionicsModelLayers.GOLEM)),
                1f);
    }

    @Override
    public ResourceLocation getTextureLocation(Entity entity) {
        return ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/golem.png");
    }
}
