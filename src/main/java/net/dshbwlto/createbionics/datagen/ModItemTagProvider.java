package net.dshbwlto.createbionics.datagen;

import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.Util.BionicsTags;
import net.dshbwlto.createbionics.item.BionicsItems;
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
        tag(BionicsTags.Items.MOLD_ITEMS)
                .add(BionicsItems.MOLTEN_ANDESITE_ALLOY_CRUCIBLE.get())
                .add(BionicsItems.MOLTEN_INDUSTRIAL_IRON_CRUCIBLE.get())
                .add(BionicsItems.MOLTEN_BRASS_CRUCIBLE.get())
                .add(BionicsItems.MOLTEN_INDUSTRIAL_IRON_CRUCIBLE.get())
                .add(Items.BRUSH);
        tag(BionicsTags.Items.BRASS_INGOT)
               .add(Items.GOLD_INGOT);
        tag(BionicsTags.Items.WRENCH)
               .add(Items.GOLD_INGOT);
    }
}
