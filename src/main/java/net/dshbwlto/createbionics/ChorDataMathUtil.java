package net.dshbwlto.createbionics;

import net.minecraft.client.Minecraft;

public class ChorDataMathUtil {

    private static int ticks;
    private static int pausedTicks;

    public static void tick() {
        if (!Minecraft.getInstance()
                .isPaused()) {
            ticks = (ticks + 1) % 1_728_000; // wrap around every 24 hours so we maintain enough floating point precision
        } else {
            pausedTicks = (pausedTicks + 1) % 1_728_000;
        }
    }

    public static float getPartialTicks() {
        Minecraft mc = Minecraft.getInstance();
        return mc.getTimer().getGameTimeDeltaPartialTick(false);
    }

    public static int getTicks() {
        return ticks;
    }

    public static float getTicksAndPartialTicks() {
        return getTicks() + getPartialTicks();
    }

    public static boolean isGamePaused() {
        Minecraft mc = Minecraft.getInstance();
        return mc.isPaused();
    }
}
