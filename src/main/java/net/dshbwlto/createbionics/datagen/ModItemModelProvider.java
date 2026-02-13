package net.dshbwlto.createbionics.datagen;

import net.dshbwlto.createbionics.CreateBionics;
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
        basicItem(BionicsItems.I2_COAL_ENGINE.get());
        basicItem(BionicsItems.SHEET_MUSIC.get());
        basicItem(BionicsItems.ANOLE_HEAD.get());
        basicItem(BionicsItems.ANOLE_TAIL.get());
        basicItem(BionicsItems.ANOLE_LEG.get());
        basicItem(BionicsItems.ANOLE.get());
        basicItem(BionicsItems.OXHAULER_HEAD.get());
        basicItem(BionicsItems.OXHAULER_FRONT.get());
        basicItem(BionicsItems.OXHAULER_MIDDLE.get());
        basicItem(BionicsItems.OXHAULER_REAR.get());
        basicItem(BionicsItems.OXHAULER_ENGINE.get());
        basicItem(BionicsItems.OXHAULER_LEG.get());
        basicItem(BionicsItems.OXHAULER_MIDDLE.get());
         basicItem(BionicsItems.REPLETE_BODY.get());
        basicItem(BionicsItems.REPLETE_LEG.get());
        basicItem(BionicsItems.VITTICEPS_MUSIC_DISC.get());
    }
}
