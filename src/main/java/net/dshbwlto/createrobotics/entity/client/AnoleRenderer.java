package net.dshbwlto.createrobotics.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.dshbwlto.createrobotics.CreateRobotics;
import net.dshbwlto.createrobotics.entity.custom.AnoleEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class AnoleRenderer extends MobRenderer<AnoleEntity, AnoleModel<AnoleEntity>> {
    public AnoleRenderer(EntityRendererProvider.Context context) {
        super(context, new AnoleModel<>(context.bakeLayer(ModModelLayers.ANOLE)), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(AnoleEntity anoleEntity) {
        return ResourceLocation.fromNamespaceAndPath(CreateRobotics.MOD_ID, "textures/entity/anole/anole.png");
    }

    @Override
    public void render(AnoleEntity entity, float entityYaw, float partialTicks,
                       PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.45f, 0.45f, 0.45f);
        }
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
