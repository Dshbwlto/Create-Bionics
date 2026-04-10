
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
        basicItem(BionicsItems.I2_COAL_ENGINE.get());
        basicItem(BionicsItems.ANOLE.get());
        basicItem(BionicsItems.WALTZ_2_MUSIC_DISC.get());
    }
}
