package net.dshbwlto.createbionics.event;

import com.mojang.blaze3d.systems.RenderSystem;
import net.createmod.catnip.animation.AnimationTickHolder;
import net.dshbwlto.createbionics.CreateBionics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderGuiLayerEvent;

@EventBusSubscriber(modid = CreateBionics.MOD_ID, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void registerOverlay(RenderGuiLayerEvent.Pre event) {
        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;

        if (player != null) {
            int width = event.getGuiGraphics().guiWidth();
            int height = event.getGuiGraphics().guiHeight() * 5;

            int offset = (int)(AnimationTickHolder.getTicks() / 10) * 253;

            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            RenderSystem.enableBlend();
            //ResourceLocation OVERLAY = ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/misc/organ_vein_overlay.png");
            //RenderSystem.setShaderColor(1, 1, 1, Mth.sin(AnimationTickHolder.getTicks() / 10f) + 0.5f); // Orange color for the overlay
            //mc.getTextureManager().bindForSetup(OVERLAY);
            //event.getGuiGraphics().blit(OVERLAY, 0, 0, 0, offset, width, height, width, height);

            RenderSystem.disableBlend();

        }
    }
}
