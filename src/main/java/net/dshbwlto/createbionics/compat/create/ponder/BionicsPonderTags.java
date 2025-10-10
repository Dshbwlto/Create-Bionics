package net.dshbwlto.createbionics.compat.create.ponder;

import com.simibubi.create.Create;
import net.createmod.ponder.foundation.PonderTag;
import net.dshbwlto.createbionics.block.BionicsBlocks;
import net.dshbwlto.createbionics.item.BionicsItems;

public class BionicsPonderTags {
    public static final PonderTag BIONICS_PONDERS = create("bionics_ponders")
            .item(BionicsBlocks.WAX_BLOCK.get())
            .defaultLang("Bionics", "Bionics blocks")
            .addToIndex();

    private static PonderTag create(String id) {
        return new PonderTag(Create.asResource(id));
    }

    public static void register() {
        PonderRegistry.TAGS.forTag(BIONICS_PONDERS)
                .add(BionicsBlocks.WAX_BLOCK.getId())
    }
}