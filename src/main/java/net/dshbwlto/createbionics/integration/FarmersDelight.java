package net.dshbwlto.createbionics.integration;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.fml.ModList;

public final class FarmersDelight {

    private static final String NAMESPACE = "farmersdelight";

    public static boolean isLoaded() {
        return ModList.get().isLoaded(NAMESPACE);
    }

    private static Block getFarmersDelightBlock(String path) {
        if (!isLoaded()) return null;
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(NAMESPACE, path);
        return BuiltInRegistries.BLOCK.get(id);
    }

    public static Block richSoil() {
        return getFarmersDelightBlock("rich_soil");
    }

    public static Block richSoilFarmland() {
        return getFarmersDelightBlock("rich_soil_farmland");
    }
}
