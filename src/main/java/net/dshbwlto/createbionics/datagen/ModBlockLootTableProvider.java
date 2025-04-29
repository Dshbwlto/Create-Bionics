package net.dshbwlto.createbionics.datagen;

import net.dshbwlto.createbionics.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);

    }
    @Override
    protected void generate() {
        dropSelf(ModBlocks.WAX_BLOCK.get());

        dropSelf(ModBlocks.OXHAULER_FRONT.get());
        dropSelf(ModBlocks.OXHAULER_REAR.get());
        dropSelf(ModBlocks.OXHAULER_FURNACE.get());
        dropSelf(ModBlocks.OXHAULER_ENGINE.get());
        dropSelf(ModBlocks.OXHAULER_HEAD.get());
        dropSelf(ModBlocks.OXHAULER_GRATE.get());
        dropSelf(ModBlocks.CHIMERA_THRUSTER.get());
        dropSelf(ModBlocks.STALKER_ENGINE.get());
        dropSelf(ModBlocks.OXHAULER_FRONT_WAX.get());
        dropSelf(ModBlocks.OXHAULER_REAR_WAX.get());
        dropSelf(ModBlocks.OXHAULER_FURNACE_WAX.get());
        dropSelf(ModBlocks.OXHAULER_ENGINE_WAX.get());
        dropSelf(ModBlocks.OXHAULER_HEAD_WAX.get());
        dropSelf(ModBlocks.OXHAULER_GRATE_WAX.get());
        dropSelf(ModBlocks.CHIMERA_THRUSTER_WAX.get());
        dropSelf(ModBlocks.STALKER_ENGINE_WAX.get());
        dropOther(ModBlocks.OXHAULER_FRONT_MOLD.get(), Items.SAND);
        dropOther(ModBlocks.OXHAULER_REAR_MOLD.get(), Items.SAND);
        dropOther(ModBlocks.OXHAULER_HEAD_MOLD.get(), Items.SAND);
        dropOther(ModBlocks.OXHAULER_ENGINE_MOLD.get(), Items.SAND);
        dropOther(ModBlocks.OXHAULER_FURNACE_MOLD.get(), Items.SAND);
        dropOther(ModBlocks.OXHAULER_GRATE_MOLD.get(), Items.SAND);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
