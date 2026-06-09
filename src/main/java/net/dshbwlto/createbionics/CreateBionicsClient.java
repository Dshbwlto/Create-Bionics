package net.dshbwlto.createbionics;

import net.createmod.ponder.foundation.PonderIndex;
import net.dshbwlto.createbionics.ponder.registry.BionicsPonderPlugin;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@Mod(value = CreateBionics.MOD_ID, dist = Dist.CLIENT)
public class CreateBionicsClient {
    public CreateBionicsClient(IEventBus modEventBus) {
        modEventBus.addListener(CreateBionicsClient::init);
    }

    public static void init(final FMLClientSetupEvent event) {
        PonderIndex.addPlugin(new BionicsPonderPlugin());
    }
}

