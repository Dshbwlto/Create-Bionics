package net.dshbwlto.createbionics.block;

import com.tterrag.registrate.util.entry.BlockEntityEntry;
import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.block.client.DepthBellRenderer;
import net.dshbwlto.createbionics.block.custom.DepthBellBlockEntity;
import net.dshbwlto.createbionics.registry.custom.BionicsRegistrate;

public class BionicsBlockEntityTypes {
    private static final BionicsRegistrate REGISTRATE = CreateBionics.registrate();
/*
    public static final BlockEntityEntry<DepthBellBlockEntity> DEPTH_BELL = REGISTRATE
            .blockEntity("depth_bell", DepthBellBlockEntity::new)
            .validBlocks(BionicsBlocks.DEPTH_BELL_BLOCK)
            .renderer(() -> DepthBellRenderer::new)
            .register();
*/
    public static void register() {
    }
}
