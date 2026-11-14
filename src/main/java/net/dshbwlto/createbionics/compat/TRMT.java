package net.dshbwlto.createbionics.compat;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.fml.ModList;

public final class TRMT {

    private static final String NAMESPACE = "trmt";

    public static boolean isLoaded() {
        return ModList.get().isLoaded(NAMESPACE);
    }

    private static Block getTRMTBlock(String path) {
        if (!isLoaded()) return null;
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(NAMESPACE, path);
        return BuiltInRegistries.BLOCK.get(id);
    }

    public static Block eroded_grass_block() {
        return getTRMTBlock("eroded_grass_block");
    }
    public static Block eroded_dirt() {
        return getTRMTBlock("eroded_dirt");
    }
    public static Block eroded_coarse_dirt() {
        return getTRMTBlock("eroded_coarse_dirt");
    }
}
