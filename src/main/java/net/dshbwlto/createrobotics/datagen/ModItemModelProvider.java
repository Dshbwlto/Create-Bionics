package net.dshbwlto.createrobotics.datagen;

import net.dshbwlto.createrobotics.CreateRobotics;
import net.dshbwlto.createrobotics.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;


public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CreateRobotics.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.ANOLE_BODY.get());
        basicItem(ModItems.I2_COAL_ENGINE.get());
        basicItem(ModItems.ANOLE_HEAD.get());
        basicItem(ModItems.ANOLE_TAIL.get());
        basicItem(ModItems.ANOLE_LEG.get());
        basicItem(ModItems.ANOLE.get());
        basicItem(ModItems.WAX_INGOT.get());

    }
}
