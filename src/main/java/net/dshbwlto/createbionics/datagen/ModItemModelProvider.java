package net.dshbwlto.createbionics.datagen;

import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.fluid.BionicsFluids;
import net.dshbwlto.createbionics.item.BionicsItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;


public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CreateBionics.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(BionicsItems.ANOLE_BODY.get());
        basicItem(BionicsItems.SILENT_PISTON.get());
        basicItem(BionicsItems.I2_COAL_ENGINE.get());
        basicItem(BionicsItems.ANOLE_HEAD.get());
        basicItem(BionicsItems.ANOLE_TAIL.get());
        basicItem(BionicsItems.ANOLE_LEG.get());
        basicItem(BionicsItems.ANOLE.get());
        basicItem(BionicsItems.WAX_INGOT.get());
        basicItem(BionicsItems.MOLTEN_ANDESITE_ALLOY_CRUCIBLE.get());
        basicItem(BionicsItems.MOLTEN_INDUSTRIAL_IRON_CRUCIBLE.get());
        basicItem(BionicsItems.MOLTEN_BRASS_CRUCIBLE.get());
        basicItem(BionicsItems.MOLTEN_NETHERITE_CRUCIBLE.get());
        basicItem(BionicsItems.NETHER_BRICK_CRUCIBLE.get());
        basicItem(BionicsItems.OXHAULER_HEAD.get());
        basicItem(BionicsItems.OXHAULER_FRONT.get());
        basicItem(BionicsItems.OXHAULER_MIDDLE.get());
        basicItem(BionicsItems.OXHAULER_REAR.get());
        basicItem(BionicsItems.OXHAULER_ENGINE.get());
        basicItem(BionicsItems.OXHAULER_LEG.get());
        basicItem(BionicsItems.OXHAULER_MIDDLE.get());
        basicItem(BionicsItems.STALKER_ANTENNA.get());
        basicItem(BionicsItems.STALKER_BODY.get());
        basicItem(BionicsItems.STALKER_TAIL.get());
        basicItem(BionicsItems.STALKER_LEG.get());
        basicItem(BionicsItems.STALKER_HEAD.get());
        basicItem(BionicsItems.ROSE_QUARTZ_NUGGET.get());
        basicItem(BionicsItems.MINI_ELECTRON_TUBE.get());
        basicItem(BionicsItems.VITTICEPS_MUSIC_DISC.get());
        basicItem(BionicsFluids.MOLTEN_ANDESITE_ALLOY_BUCKET.get());
        basicItem(BionicsFluids.MOLTEN_INDUSTRIAL_IRON_BUCKET.get());
        basicItem(BionicsFluids.MOLTEN_BRASS_BUCKET.get());
        basicItem(BionicsFluids.MOLTEN_NETHERITE_BUCKET.get());
    }
}
