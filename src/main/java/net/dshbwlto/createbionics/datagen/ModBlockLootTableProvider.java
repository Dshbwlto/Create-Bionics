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
        dropSelf(BionicsBlocks.WAX_BLOCK.get());
        dropSelf(BionicsBlocks.SCRAP_ANDESITE.get());
        dropSelf(BionicsBlocks.SCRAP_BRASS.get());
        dropSelf(BionicsBlocks.SCRAP_INDUSTRIAL_IRON.get());
        dropSelf(BionicsBlocks.SCRAP_NETHERITE.get());

        dropSelf(BionicsBlocks.OXHAULER_FRONT.get());
        dropSelf(BionicsBlocks.OXHAULER_REAR.get());
        dropSelf(BionicsBlocks.OXHAULER_FURNACE.get());
        dropSelf(BionicsBlocks.OXHAULER_ENGINE.get());
        dropSelf(BionicsBlocks.OXHAULER_HEAD.get());
        dropSelf(BionicsBlocks.OXHAULER_GRATE.get());
        dropSelf(BionicsBlocks.CASSOWALKER_FRAME.get());
        dropSelf(BionicsBlocks.CASSOWALKER_KEEL.get());
        dropSelf(BionicsBlocks.CASSOWALKER_EXHAUST.get());
        dropSelf(BionicsBlocks.CHIMERA_THRUSTER.get());
        dropSelf(BionicsBlocks.STALKER_ENGINE.get());
        dropSelf(BionicsBlocks.STALKER_HEAD.get());
        dropSelf(BionicsBlocks.OXHAULER_FRONT_WAX.get());
        dropSelf(BionicsBlocks.OXHAULER_REAR_WAX.get());
        dropSelf(BionicsBlocks.OXHAULER_FURNACE_WAX.get());
        dropSelf(BionicsBlocks.OXHAULER_ENGINE_WAX.get());
        dropSelf(BionicsBlocks.OXHAULER_HEAD_WAX.get());
        dropSelf(BionicsBlocks.OXHAULER_GRATE_WAX.get());
        dropSelf(BionicsBlocks.CASSOWALKER_FRAME_WAX.get());
        dropSelf(BionicsBlocks.CASSOWALKER_KEEL_WAX.get());
        dropSelf(BionicsBlocks.CASSOWALKER_EXHAUST_WAX.get());
        dropSelf(BionicsBlocks.CHIMERA_THRUSTER_WAX.get());
        dropSelf(BionicsBlocks.STALKER_ENGINE_WAX.get());
        dropSelf(BionicsBlocks.STALKER_HEAD_WAX.get());
        dropOther(BionicsBlocks.OXHAULER_FRONT_MOLD.get(), Items.SAND);
        dropOther(BionicsBlocks.OXHAULER_REAR_MOLD.get(), Items.SAND);
        dropOther(BionicsBlocks.OXHAULER_HEAD_MOLD.get(), Items.SAND);
        dropOther(BionicsBlocks.OXHAULER_ENGINE_MOLD.get(), Items.SAND);
        dropOther(BionicsBlocks.OXHAULER_FURNACE_MOLD.get(), Items.SAND);
        dropOther(BionicsBlocks.OXHAULER_GRATE_MOLD.get(), Items.SAND);
        dropOther(BionicsBlocks.CASSOWALKER_FRAME_MOLD.get(), Items.SAND);
        dropOther(BionicsBlocks.CASSOWALKER_KEEL_MOLD.get(), Items.SAND);
        dropOther(BionicsBlocks.CASSOWALKER_EXHAUST_MOLD.get(), Items.SAND);
        dropOther(BionicsBlocks.STALKER_ENGINE_MOLD.get(), Items.SAND);
        dropOther(BionicsBlocks.STALKER_HEAD_MOLD.get(), Items.SAND);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BionicsBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
