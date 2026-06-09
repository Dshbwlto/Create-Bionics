package net.dshbwlto.createbionics.ponder.registry;

import com.simibubi.create.infrastructure.ponder.AllCreatePonderScenes;
import com.simibubi.create.infrastructure.ponder.AllCreatePonderTags;
import com.tterrag.registrate.util.entry.ItemProviderEntry;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.createmod.ponder.api.level.PonderLevel;
import net.createmod.ponder.api.registration.*;
import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.item.BionicsItems;
import net.dshbwlto.createbionics.ponder.custom.OxhaulerScenes;
import net.minecraft.resources.ResourceLocation;

public class BionicsPonderPlugin implements PonderPlugin {
    @Override
    public String getModId() {
        return CreateBionics.MOD_ID;
    }

    @Override
    public void registerScenes(PonderSceneRegistrationHelper<ResourceLocation> helper) {
        register(helper);
    }

    @Override
    public void registerTags(PonderTagRegistrationHelper<ResourceLocation> helper) {
        register(helper);
    }

    @Override
    public void registerSharedText(SharedTextRegistrationHelper helper) {
        PonderPlugin.super.registerSharedText(helper);
    }

    @Override
    public void onPonderLevelRestore(PonderLevel ponderLevel) {
        PonderPlugin.super.onPonderLevelRestore(ponderLevel);
    }

    @Override
    public void indexExclusions(IndexExclusionHelper helper) {
        PonderPlugin.super.indexExclusions(helper);
    }

    public static void register(PonderSceneRegistrationHelper<ResourceLocation> helper) {
        PonderSceneRegistrationHelper<ItemProviderEntry<?, ?>> SCENE_HELPER = helper.withKeyFunction(RegistryEntry::getId);

        //SCENE_HELPER.forComponents(BionicsItems.OXHAULER_MIDDLE).addStoryBoard("oxhauler", OxhaulerScenes::oxhaulerBuildSequence, AllCreatePonderTags.LOGISTICS);
    }

    public static void register(PonderTagRegistrationHelper<ResourceLocation> helper) {
        PonderTagRegistrationHelper<RegistryEntry<?, ?>> TAG_HELPER = helper.withKeyFunction(RegistryEntry::getId);

        TAG_HELPER.addToTag(AllCreatePonderTags.LOGISTICS)
                .add(BionicsItems.OXHAULER_MIDDLE);
    }
}