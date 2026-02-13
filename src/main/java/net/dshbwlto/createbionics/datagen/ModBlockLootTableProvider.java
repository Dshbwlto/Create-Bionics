package net.dshbwlto.createbionics.datagen;

import net.dshbwlto.createbionics.block.BionicsBlocks;
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

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BionicsBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
