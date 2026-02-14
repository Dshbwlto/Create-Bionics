package net.dshbwlto.createbionics.ponder;

import net.createmod.ponder.api.registration.*;
import net.dshbwlto.createbionics.CreateBionics;
import net.minecraft.resources.ResourceLocation;

public class BionicsPonderPlugin implements PonderPlugin {
    @Override
    public String getModId() {
        return CreateBionics.MOD_ID;
    }

    @Override
    public void registerScenes(PonderSceneRegistrationHelper<ResourceLocation> helper) {
        BionicsPonders.registerScenes(helper);
    }

    @Override
    public void registerTags(PonderTagRegistrationHelper<ResourceLocation> helper) {
        BionicsPonders.registerTags(helper);
    }

    @Override
    public void registerSharedText(SharedTextRegistrationHelper helper) {
        // helper.registerSharedText("rpm8", "8 RPM");
    }

    @Override
    public void indexExclusions(IndexExclusionHelper helper) {
        // helper.excludeBlockVariants(ValveHandleBlock.class, AllBlocks.COPPER_VALVE_HANDLE.get());
    }
}
