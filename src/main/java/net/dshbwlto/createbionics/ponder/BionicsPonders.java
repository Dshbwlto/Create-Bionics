package net.dshbwlto.createbionics.ponder;

import com.simibubi.create.AllItems;
import com.simibubi.create.infrastructure.ponder.AllCreatePonderTags;
import com.tterrag.registrate.util.entry.ItemProviderEntry;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.createmod.ponder.api.registration.PonderSceneRegistrationHelper;
import net.createmod.ponder.api.registration.PonderTagRegistrationHelper;
import net.createmod.ponder.foundation.content.DebugScenes;
import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.item.BionicsItems;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.data.loading.DatagenModLoader;

public class BionicsPonders {

    public static final ResourceLocation ROBOTS = CreateBionics.asResource("robots");

    public static void registerTags(PonderTagRegistrationHelper<ResourceLocation> helper) {
        PonderTagRegistrationHelper<RegistryEntry<?,?>> HELPER = helper.withKeyFunction(RegistryEntry::getId);

        HELPER.registerTag(ROBOTS)
                .addToIndex()
                .item(BionicsItems.OXHAULER_MIDDLE.get(), true, false)
                .title("Robot Construction")
                .description("How to construct a robot")
                .register();
    }

    public static void registerScenes(PonderSceneRegistrationHelper<ResourceLocation> helper) {
        PonderSceneRegistrationHelper<ItemProviderEntry<?,?>> HELPER = helper.withKeyFunction(RegistryEntry::getId);

        HELPER.addStoryBoard(BionicsItems.OXHAULER_MIDDLE, "oxhauler_middle", PonderScenes::oxhaulerMiddle, ROBOTS);

    }
}
