package net.dshbwlto.createrobotics.datagen;

import net.dshbwlto.createrobotics.block.ModBlocks;
import net.dshbwlto.createrobotics.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);

    }
    @Override
    protected void generate() {
        dropSelf(ModBlocks.WAX_BLOCK.get());

        dropSelf(ModBlocks.OXHAULER_FRAME_FRONT.get());
        dropSelf(ModBlocks.OXHAULER_FRAME_REAR.get());
        dropSelf(ModBlocks.OXHAULER_FURNACE.get());
        dropSelf(ModBlocks.OXHAULER_ENGINE_BLOCK.get());
        dropSelf(ModBlocks.OXHAULER_FRAME_HEAD.get());
        dropSelf(ModBlocks.OXHAULER_GRATE.get());
        dropSelf(ModBlocks.THRUSTER.get());
        dropSelf(ModBlocks.STALKER_ENGINE.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
