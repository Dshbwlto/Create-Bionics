package net.dshbwlto.createbionics.datagen;

import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.Util.BionicsTags;
import net.dshbwlto.createbionics.fluid.BionicsFluids;
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
                .add(BionicsFluids.SOURCE_MOLTEN_ANDESITE_ALLOY.get())
                .add(BionicsFluids.FLOWING_MOLTEN_ANDESITE_ALLOY.get())

                .add(BionicsFluids.SOURCE_MOLTEN_INDUSTRIAL_IRON.get())
                .add(BionicsFluids.FLOWING_MOLTEN_INDUSTRIAL_IRON.get())

                .add(BionicsFluids.SOURCE_MOLTEN_BRASS.get())
                .add(BionicsFluids.FLOWING_MOLTEN_BRASS.get())

                .add(BionicsFluids.SOURCE_MOLTEN_NETHERITE.get())
                .add(BionicsFluids.FLOWING_MOLTEN_NETHERITE.get());
        tag(BionicsTags.Fluids.ANDESITE_ALLOY)
                .add(BionicsFluids.SOURCE_MOLTEN_ANDESITE_ALLOY.get())
                .add(BionicsFluids.FLOWING_MOLTEN_ANDESITE_ALLOY.get());
    }
}
