package net.dshbwlto.createbionics.event;

import com.mojang.blaze3d.systems.RenderSystem;
import com.simibubi.create.content.equipment.goggles.GoggleOverlayRenderer;
import com.simibubi.create.content.processing.sequenced.SequencedAssemblyRecipe;
import com.simibubi.create.foundation.item.TooltipModifier;
import com.simibubi.create.infrastructure.config.AllConfigs;
import net.createmod.catnip.animation.AnimationTickHolder;
import net.dshbwlto.createbionics.CreateBionics;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderGuiLayerEvent;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

@EventBusSubscriber(modid = CreateBionics.MOD_ID, value = Dist.CLIENT)
public class ClientEvents {

    private void reycast(Player player, Level level) {
        // reycast settings
        double distance = 5;
        Vec3 start = player.getEyePosition(1.0F);
        Vec3 end = start.add(player.getLookAngle().scale(distance));

        // reycast
        EntityHitResult entityHit = ProjectileUtil.getEntityHitResult(
                level, player, start, end,
                new AABB(start, end),
                e -> !e.isSpectator() && e.isPickable()
        );

        if (entityHit != null) {
            Entity target = entityHit.getEntity();
        }
    }

    @SubscribeEvent
    public static void registerOverlay(RenderGuiLayerEvent.Pre event) {
        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;
        Level level = player.level();

        // raycast settings
        double distance = 5;
        Vec3 start = player.getEyePosition(1.0F);
        Vec3 end = start.add(player.getLookAngle().scale(distance));

        // reycast
        EntityHitResult entityHit = ProjectileUtil.getEntityHitResult(
                level, player, start, end,
                new AABB(start, end),
                e -> !e.isSpectator() && e.isPickable()
        );

        if (entityHit != null) {
            Entity target = entityHit.getEntity();
            GoggleOverlayRenderer.renderOverlay(event.getGuiGraphics(), DeltaTracker.ZERO);
        }
        int width = event.getGuiGraphics().guiWidth();
        int height = event.getGuiGraphics().guiHeight() * 5;

        int offset = (int) (AnimationTickHolder.getTicks() / 10) * 253;

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.enableBlend();
        //ResourceLocation OVERLAY = ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/misc/organ_vein_overlay.png");
        //RenderSystem.setShaderColor(1, 1, 1, Mth.sin(AnimationTickHolder.getTicks() / 10f) + 0.5f); // Orange color for the overlay
        //mc.getTextureManager().bindForSetup(OVERLAY);
        //event.getGuiGraphics().blit(OVERLAY, 0, 0, 0, offset, width, height, width, height);

        RenderSystem.disableBlend();
    }

}
