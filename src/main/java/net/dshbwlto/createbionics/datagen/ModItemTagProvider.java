package net.dshbwlto.createbionics.datagen;

import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.Util.ModTags;
import net.dshbwlto.createbionics.fluid.ModFluids;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, CreateBionics.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.MOLD_ITEMS)
                .add(ModFluids.MOLTEN_ANDESITE_ALLOY_BUCKET.get())
                .add(ModFluids.MOLTEN_INDUSTRIAL_IRON_BUCKET.get())
                .add(ModFluids.MOLTEN_BRASS_BUCKET.get())
                .add(ModFluids.MOLTEN_NETHERITE_BUCKET.get())
                .add(Items.BRUSH);
    }
}
