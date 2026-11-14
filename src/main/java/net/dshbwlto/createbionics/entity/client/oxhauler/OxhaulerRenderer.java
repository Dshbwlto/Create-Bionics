
package net.dshbwlto.createbionics.entity.client.oxhauler;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.createmod.catnip.render.CachedBuffers;
import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.entity.client.BionicsModelLayers;
import net.dshbwlto.createbionics.entity.custom.OxhaulerEntity;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;

public class OxhaulerRenderer extends MobRenderer {

    public OxhaulerRenderer(EntityRendererProvider.Context context) {
        super(context, new OxhaulerModel<>(context.bakeLayer(BionicsModelLayers.OXHAULER)), 1.6f);
        this.addLayer(new OxhaulerGlowLayer(this, context.getModelSet()));
        this.addLayer(new OxhaulerColorLayer(this, context.getModelSet()));
    }

    @Override
    public ResourceLocation getTextureLocation(Entity entity) {
        OxhaulerEntity oxhauler = (OxhaulerEntity) entity;
        return ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/item/entity/oxhauler/oxhauler_" + oxhauler.getTypeVariant() + ".png");
    }

    @Override
    public void render(LivingEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        OxhaulerEntity oxhauler = (OxhaulerEntity) entity;

        oxhauler.y0 += 0.3f;

        if (entity.isPassenger()) {
            poseStack.translate(0, -6 / 16f, 0);
        }

        if (oxhauler.getFuel() > 0) {
            CachedBuffers.partial(PartialModel.of(oxhauler.getFuel() < 23000
                            ? CreateBionics.asResource("item/oxhauler_fire")
                            : CreateBionics.asResource("item/oxhauler_soul_fire")), entity.getBlockStateOn())
                    .rotate(Direction.Axis.Y, -entityYaw * Mth.PI / 180)
                    .translate(-0.5, 0.75, -0.5)
                    .light(15728880)
                    .renderInto(poseStack, buffer.getBuffer(RenderType.cutout()));
        }
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @Override
    public boolean shouldRender(Entity livingEntity, Frustum camera, double camX, double camY, double camZ) {
        return true;
    }
}
