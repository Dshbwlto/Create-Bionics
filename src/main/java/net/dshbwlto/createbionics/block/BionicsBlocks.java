package net.dshbwlto.createbionics.block;

import com.simibubi.create.AllTags;
import com.simibubi.create.content.decoration.steamWhistle.WhistleExtenderBlock;
import com.simibubi.create.foundation.data.BlockStateGen;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.block.custom.DepthBellBlock;
import net.dshbwlto.createbionics.block.custom.DepthBellExtenderBlock;
import net.dshbwlto.createbionics.block.custom.DepthBellGenerator;
import net.dshbwlto.createbionics.registry.custom.BionicsRegistrate;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.common.Tags;

import static com.simibubi.create.foundation.data.BlockStateGen.simpleCubeAll;
import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;
import static com.simibubi.create.foundation.data.TagGen.tagBlockAndItem;

public class BionicsBlocks {
    private static final BionicsRegistrate REGISTRATE = CreateBionics.registrate();

    public static final BlockEntry<DepthBellBlock> DEPTH_BELL_BLOCK = REGISTRATE.block("depth_bell", DepthBellBlock::new)
            .initialProperties(() -> Blocks.ANDESITE)
            .properties(p -> p.mapColor(MapColor.STONE)
                    .requiresCorrectToolForDrops()
                    .noOcclusion())
            .transform(pickaxeOnly())
            .blockstate(new DepthBellGenerator()::generate)
            .tag(Tags.Blocks.STORAGE_BLOCKS)
            .transform(tagBlockAndItem(AllTags.AllBlockTags.ANDESITE_ALLOY_STORAGE_BLOCKS.tag, AllTags.AllItemTags.ANDESITE_ALLOY_STORAGE_BLOCKS.tag))
            .tag(Tags.Items.STORAGE_BLOCKS)
            .build()
            .lang("Depth Bell")
            .register();
    public static final BlockEntry<DepthBellExtenderBlock> DEPTH_BELL_EXTENSION =
            REGISTRATE.block("depth_bell_extension", DepthBellExtenderBlock::new)
                    .initialProperties(SharedProperties::copperMetal)
                    .properties(p -> p.mapColor(MapColor.TERRACOTTA_ORANGE)
                            .forceSolidOn())
                    .transform(pickaxeOnly())
                    .register();

    public static void register() {}
}