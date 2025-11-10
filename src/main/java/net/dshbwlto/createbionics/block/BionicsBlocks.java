package net.dshbwlto.createbionics.block;

import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.block.custom.cassowalker.*;
import net.dshbwlto.createbionics.block.custom.oxhauler.*;
import net.dshbwlto.createbionics.block.custom.stalker.StalkerEngineMoldBlock;
import net.dshbwlto.createbionics.block.custom.stalker.StalkerEngineWaxBlock;
import net.dshbwlto.createbionics.block.custom.stalker.StalkerHeadMoldBlock;
import net.dshbwlto.createbionics.block.custom.stalker.StalkerHeadWaxBlock;
import net.dshbwlto.createbionics.item.BionicsItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BionicsBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(CreateBionics.MOD_ID);

    public static final DeferredBlock<Block> WAX_BLOCK = registerBlock("wax_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(1f).sound(SoundType.CANDLE)));
    public static final DeferredBlock<Block> SCRAP_ANDESITE = registerBlock("scrap_andesite",
            () -> new Block(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.STONE).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> SCRAP_BRASS = registerBlock("scrap_brass",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).sound(SoundType.STONE).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> SCRAP_INDUSTRIAL_IRON = registerBlock("scrap_industrial_iron",
            () -> new Block(BlockBehaviour.Properties.of().strength(3f).sound(SoundType.STONE).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> SCRAP_NETHERITE = registerBlock("scrap_netherite",
            () -> new Block(BlockBehaviour.Properties.of().strength(6f).sound(SoundType.STONE).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> OXHAULER_FRONT = registerBlock("oxhauler_front",
            () -> new Block(BlockBehaviour.Properties.of().strength(1f).sound(SoundType.STONE).noOcclusion()));
    public static final DeferredBlock<Block> OXHAULER_REAR = registerBlock("oxhauler_rear",
            () -> new Block(BlockBehaviour.Properties.of().strength(1f).sound(SoundType.STONE).noOcclusion()));
    public static final DeferredBlock<Block> OXHAULER_HEAD = registerBlock("oxhauler_head",
            () -> new Block(BlockBehaviour.Properties.of().strength(1f).sound(SoundType.STONE).noOcclusion()));
    public static final DeferredBlock<Block> OXHAULER_FURNACE = registerBlock("oxhauler_furnace",
            () -> new Block(BlockBehaviour.Properties.of().strength(1f).sound(SoundType.STONE).noOcclusion()));
    public static final DeferredBlock<Block> OXHAULER_ENGINE = registerBlock("oxhauler_engine",
            () -> new Block(BlockBehaviour.Properties.of().strength(1f).sound(SoundType.STONE).noOcclusion()));
    public static final DeferredBlock<Block> OXHAULER_GRATE = registerBlock("oxhauler_grate",
            () -> new Block(BlockBehaviour.Properties.of().strength(1f).sound(SoundType.STONE).noOcclusion()));

    public static final DeferredBlock<Block> CASSOWALKER_FRAME = registerBlock("cassowalker_frame",
            () -> new Block(BlockBehaviour.Properties.of().strength(1f).sound(SoundType.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CASSOWALKER_KEEL = registerBlock("cassowalker_keel",
            () -> new Block(BlockBehaviour.Properties.of().strength(1f).sound(SoundType.STONE).noOcclusion()));
    public static final DeferredBlock<Block> CASSOWALKER_EXHAUST = registerBlock("cassowalker_exhaust",
            () -> new Block(BlockBehaviour.Properties.of().strength(1f).sound(SoundType.STONE).noOcclusion()));

    public static final DeferredBlock<Block> STALKER_ENGINE = registerBlock("stalker_engine",
            () -> new Block(BlockBehaviour.Properties.of().strength(1f).sound(SoundType.STONE).noOcclusion()));
    public static final DeferredBlock<Block> STALKER_HEAD = registerBlock("stalker_head",
            () -> new Block(BlockBehaviour.Properties.of().strength(1f).sound(SoundType.STONE).noOcclusion()));

    public static final DeferredBlock<Block> CHIMERA_THRUSTER = registerBlock("chimera_thruster",
            () -> new Block(BlockBehaviour.Properties.of().strength(1f).sound(SoundType.NETHERITE_BLOCK).noOcclusion()));


    public static final DeferredBlock<Block> OXHAULER_FRONT_WAX = registerBlock("oxhauler_front_wax",
            () -> new OxhaulerFrontWaxBlock(BlockBehaviour.Properties.of().strength(1f).sound(SoundType.CANDLE).noOcclusion()));
    public static final DeferredBlock<Block> OXHAULER_REAR_WAX = registerBlock("oxhauler_rear_wax",
            () -> new OxhaulerRearWaxBlock(BlockBehaviour.Properties.of().strength(1f).sound(SoundType.CANDLE).noOcclusion()));
    public static final DeferredBlock<Block> OXHAULER_HEAD_WAX = registerBlock("oxhauler_head_wax",
            () -> new OxhaulerHeadWaxBlock(BlockBehaviour.Properties.of().strength(1f).sound(SoundType.CANDLE).noOcclusion()));
    public static final DeferredBlock<Block> OXHAULER_FURNACE_WAX = registerBlock("oxhauler_furnace_wax",
            () -> new OxhaulerFurnaceWaxBlock(BlockBehaviour.Properties.of().strength(1f).sound(SoundType.CANDLE).noOcclusion()));
    public static final DeferredBlock<Block> OXHAULER_ENGINE_WAX = registerBlock("oxhauler_engine_wax",
            () -> new OxhaulerEngineWaxBlock(BlockBehaviour.Properties.of().strength(1f).sound(SoundType.CANDLE).noOcclusion()));
    public static final DeferredBlock<Block> OXHAULER_GRATE_WAX = registerBlock("oxhauler_grate_wax",
            () -> new OxhaulerGrateWaxBlock(BlockBehaviour.Properties.of().strength(1f).sound(SoundType.CANDLE).noOcclusion()));

    public static final DeferredBlock<Block> CASSOWALKER_FRAME_WAX = registerBlock("cassowalker_frame_wax",
            () -> new CassowalkerFrameWaxBlock(BlockBehaviour.Properties.of().strength(1f).sound(SoundType.CANDLE).noOcclusion()));
    public static final DeferredBlock<Block> CASSOWALKER_KEEL_WAX = registerBlock("cassowalker_keel_wax",
            () -> new CassowalkerKeelWaxBlock(BlockBehaviour.Properties.of().strength(1f).sound(SoundType.CANDLE).noOcclusion()));
    public static final DeferredBlock<Block> CASSOWALKER_EXHAUST_WAX = registerBlock("cassowalker_exhaust_wax",
            () -> new CassowalkerExhaustWaxBlock(BlockBehaviour.Properties.of().strength(1f).sound(SoundType.CANDLE).noOcclusion()));

    public static final DeferredBlock<Block> STALKER_ENGINE_WAX = registerBlock("stalker_engine_wax",
            () -> new StalkerEngineWaxBlock(BlockBehaviour.Properties.of().strength(1f).sound(SoundType.CANDLE).noOcclusion()));
    public static final DeferredBlock<Block> STALKER_HEAD_WAX = registerBlock("stalker_head_wax",
            () -> new StalkerHeadWaxBlock(BlockBehaviour.Properties.of().strength(1f).sound(SoundType.CANDLE).noOcclusion()));

    public static final DeferredBlock<Block> CHIMERA_THRUSTER_WAX = registerBlock("chimera_thruster_wax",
            () -> new Block(BlockBehaviour.Properties.of().strength(1f).sound(SoundType.CANDLE).noOcclusion()));


    public static final DeferredBlock<Block> OXHAULER_FRONT_MOLD = registerBlock("oxhauler_front_mold",
            () -> new OxhaulerFrontMoldBlock(BlockBehaviour.Properties.of().strength(1f).sound(SoundType.SAND).noOcclusion()));
    public static final DeferredBlock<Block> OXHAULER_REAR_MOLD = registerBlock("oxhauler_rear_mold",
            () -> new OxhaulerRearMoldBlock(BlockBehaviour.Properties.of().strength(1f).sound(SoundType.SAND).noOcclusion()));
    public static final DeferredBlock<Block> OXHAULER_HEAD_MOLD = registerBlock("oxhauler_head_mold",
            () -> new OxhaulerHeadMoldBlock(BlockBehaviour.Properties.of().strength(1f).sound(SoundType.SAND).noOcclusion()));
    public static final DeferredBlock<Block> OXHAULER_FURNACE_MOLD = registerBlock("oxhauler_furnace_mold",
            () -> new OxhaulerFurnaceMoldBlock(BlockBehaviour.Properties.of().strength(1f).sound(SoundType.SAND).noOcclusion()));
    public static final DeferredBlock<Block> OXHAULER_ENGINE_MOLD = registerBlock("oxhauler_engine_mold",
            () -> new OxhaulerEngineMoldBlock(BlockBehaviour.Properties.of().strength(1f).sound(SoundType.SAND).noOcclusion()));
    public static final DeferredBlock<Block> OXHAULER_GRATE_MOLD = registerBlock("oxhauler_grate_mold",
            () -> new OxhaulerGrateMoldBlock(BlockBehaviour.Properties.of().strength(1f).sound(SoundType.SAND).noOcclusion()));

    public static final DeferredBlock<Block> CASSOWALKER_FRAME_MOLD = registerBlock("cassowalker_frame_mold",
            () -> new CassowalkerFrameMoldBlock(BlockBehaviour.Properties.of().strength(1f).sound(SoundType.SAND).noOcclusion()));
    public static final DeferredBlock<Block> CASSOWALKER_KEEL_MOLD = registerBlock("cassowalker_keel_mold",
            () -> new CassowalkerKeelMoldBlock(BlockBehaviour.Properties.of().strength(1f).sound(SoundType.SAND).noOcclusion()));
    public static final DeferredBlock<Block> CASSOWALKER_EXHAUST_MOLD = registerBlock("cassowalker_exhaust_mold",
            () -> new CassowalkerExhaustMoldBlock(BlockBehaviour.Properties.of().strength(1f).sound(SoundType.SAND).noOcclusion()));

    public static final DeferredBlock<Block> STALKER_ENGINE_MOLD = registerBlock("stalker_engine_mold",
            () -> new StalkerEngineMoldBlock(BlockBehaviour.Properties.of().strength(1f).sound(SoundType.SAND).noOcclusion()));
    public static final DeferredBlock<Block> STALKER_HEAD_MOLD = registerBlock("stalker_head_mold",
            () -> new StalkerHeadMoldBlock(BlockBehaviour.Properties.of().strength(1f).sound(SoundType.SAND).noOcclusion()));





    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        BionicsItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
