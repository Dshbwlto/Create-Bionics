
package net.dshbwlto.createbionics;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

@EventBusSubscriber(modid = CreateBionics.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class BionicsClientConfig {
    public static ModConfigSpec.BooleanValue arachnophobia_mode;

    public BionicsClientConfig(final ModConfigSpec.Builder builder) {
        builder.push("visuals");
        arachnophobia_mode = builder.comment("replaces spider-like models with friendlier ones").translation("arachnophobia_mode").define("arachnophobia_mode", false);
    }

    public static boolean arachnophobia;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        arachnophobia = arachnophobia_mode.get();
    }
}
