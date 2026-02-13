package net.dshbwlto.createbionics.datagen;

import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.Util.BionicsTags;
import net.dshbwlto.createbionics.item.BionicsItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
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
        tag(BionicsTags.Items.ANDESITE_ALLOY_SINGLE)
               .add(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:andesite_alloy")))
               .add(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:wrench")))
               .add(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:linked_controller")))
               .add(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:potato_cannon")))
               .add(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:extendo_grip")))
               .add(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:gearbox")))
               .add(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:vertical_gearbox")))
               .add(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:clutch")))
               .add(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:gearshift")))
               .add(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:encased_chain_drive")))
               .add(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:adjustable_chain_gearshift")))
               .add(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:chain_conveyor")))
               .add(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:encased_fan")))
               .add(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:nozzle")))
               .add(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:hand_crank")))
               .add(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:cuckoo_clock")))
               .add(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:millstone")))
               .add(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:mechanical_press")))
               .add(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:mechanical_mixer")))
               .add(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:basin")))
               .add(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:depot")))
               .add(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:weighted_ejector")))
               .add(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:speedometer")))
               .add(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:stressometer")))
               .add(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:stressometer")))
               .add(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:copper_valve_handle")))
               .add(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:steam_engine")))
               .add(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:mechanical_piston")))
               .add(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:sticky_mechanical_piston")))
               .add(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:gantry_carriage")))
               .add(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:gantry_carriage")))
               .add(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:mechanical_bearing")))
               .add(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:rope_pulley")))
               .add(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:cart_assembler")))
               .add(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:sticker")))
               .add(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:contraption_controls")))
               .add(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:mechanical_drill")))
               .add(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:deployer")))
               .add(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:portable_storage_interface")))
               .add(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:mechanical_harvester")));

        tag(BionicsTags.Items.ANDESITE_ALLOY_MULTI)
               .add(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:crushing_wheel")));
    }
}
