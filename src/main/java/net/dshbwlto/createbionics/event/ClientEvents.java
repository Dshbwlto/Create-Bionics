package net.dshbwlto.createbionics.event;

import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.Util.RobotGoggleOverlayRenderer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;
import net.neoforged.neoforge.client.gui.VanillaGuiLayers;

@EventBusSubscriber(modid = CreateBionics.MOD_ID, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void registerHUD(RegisterGuiLayersEvent event) {
        event.registerAbove(VanillaGuiLayers.HOTBAR, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "entity_goggle_overlay"),
                (RobotGoggleOverlayRenderer::renderOverlay));
    }
}