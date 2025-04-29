package net.dshbwlto.createbionics.datagen;

import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.fluid.ModFluids;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.tags.FluidTags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModFluidTagsProvider extends FluidTagsProvider {
    public ModFluidTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider,
                                @Nullable ExistingFileHelper existingFileHelper) {
        super(output, provider, CreateBionics.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(FluidTags.LAVA)
                .add(ModFluids.SOURCE_MOLTEN_ANDESITE_ALLOY.get())
                .add(ModFluids.FLOWING_MOLTEN_ANDESITE_ALLOY.get())

                .add(ModFluids.SOURCE_MOLTEN_INDUSTRIAL_IRON.get())
                .add(ModFluids.FLOWING_MOLTEN_INDUSTRIAL_IRON.get())

                .add(ModFluids.SOURCE_MOLTEN_BRASS.get())
                .add(ModFluids.FLOWING_MOLTEN_BRASS.get())

                .add(ModFluids.SOURCE_MOLTEN_NETHERITE.get())
                .add(ModFluids.FLOWING_MOLTEN_NETHERITE.get());
    }
}
