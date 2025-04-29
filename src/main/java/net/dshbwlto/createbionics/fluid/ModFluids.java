package net.dshbwlto.createbionics.fluid;

import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.block.ModBlocks;
import net.dshbwlto.createbionics.item.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(BuiltInRegistries.FLUID, CreateBionics.MOD_ID);

    //ANDESITE ALLOY//

    public static final Supplier<FlowingFluid> SOURCE_MOLTEN_ANDESITE_ALLOY = FLUIDS.register("source_molten_andesite_alloy",
            () -> new BaseFlowingFluid.Source(ModFluids.MOLTEN_ANDESITE_ALLOY_PROPERTIES));
    public static final Supplier<FlowingFluid> FLOWING_MOLTEN_ANDESITE_ALLOY = FLUIDS.register("flowing_molten_andesite_alloy",
            () -> new BaseFlowingFluid.Flowing(ModFluids.MOLTEN_ANDESITE_ALLOY_PROPERTIES));

    public static final DeferredBlock<LiquidBlock> MOLTEN_ANDESITE_ALLOY_BLOCK = ModBlocks.BLOCKS.register("molten_andesite_alloy_block",
            () -> new LiquidBlock(ModFluids.SOURCE_MOLTEN_ANDESITE_ALLOY.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.LAVA).noLootTable()));
    public static final DeferredItem<Item> MOLTEN_ANDESITE_ALLOY_BUCKET = ModItems.ITEMS.registerItem("molten_andesite_alloy_bucket",
            properties -> new BucketItem(ModFluids.SOURCE_MOLTEN_ANDESITE_ALLOY.get(), properties.craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final BaseFlowingFluid.Properties MOLTEN_ANDESITE_ALLOY_PROPERTIES = new BaseFlowingFluid.Properties(
            ModFluidTypes.MOLTEN_ANDESITE_ALLOY_FLUID_TYPE, SOURCE_MOLTEN_ANDESITE_ALLOY, FLOWING_MOLTEN_ANDESITE_ALLOY)
            .slopeFindDistance(2).levelDecreasePerBlock(1)
            .block(ModFluids.MOLTEN_ANDESITE_ALLOY_BLOCK).bucket(ModFluids.MOLTEN_ANDESITE_ALLOY_BUCKET);

    //INDUSTRIAL IRON//

    public static final Supplier<FlowingFluid> SOURCE_MOLTEN_INDUSTRIAL_IRON = FLUIDS.register("source_molten_industrial_iron",
            () -> new BaseFlowingFluid.Source(ModFluids.MOLTEN_INDUSTRIAL_IRON_PROPERTIES));
    public static final Supplier<FlowingFluid> FLOWING_MOLTEN_INDUSTRIAL_IRON = FLUIDS.register("flowing_molten_industrial_iron",
            () -> new BaseFlowingFluid.Flowing(ModFluids.MOLTEN_INDUSTRIAL_IRON_PROPERTIES));

    public static final DeferredBlock<LiquidBlock> MOLTEN_INDUSTRIAL_IRON_BLOCK = ModBlocks.BLOCKS.register("molten_industrial_iron_block",
            () -> new LiquidBlock(ModFluids.SOURCE_MOLTEN_INDUSTRIAL_IRON.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.LAVA).noLootTable()));
    public static final DeferredItem<Item> MOLTEN_INDUSTRIAL_IRON_BUCKET = ModItems.ITEMS.registerItem("molten_industrial_iron_bucket",
            properties -> new BucketItem(ModFluids.SOURCE_MOLTEN_INDUSTRIAL_IRON.get(), properties.craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final BaseFlowingFluid.Properties MOLTEN_INDUSTRIAL_IRON_PROPERTIES = new BaseFlowingFluid.Properties(
            ModFluidTypes.MOLTEN_INDUSTRIAL_IRON_FLUID_TYPE, SOURCE_MOLTEN_INDUSTRIAL_IRON, FLOWING_MOLTEN_INDUSTRIAL_IRON)
            .slopeFindDistance(2).levelDecreasePerBlock(1)
            .block(ModFluids.MOLTEN_INDUSTRIAL_IRON_BLOCK).bucket(ModFluids.MOLTEN_INDUSTRIAL_IRON_BUCKET);

    //BRASS//

    public static final Supplier<FlowingFluid> SOURCE_MOLTEN_BRASS = FLUIDS.register("source_molten_brass",
            () -> new BaseFlowingFluid.Source(ModFluids.MOLTEN_BRASS_PROPERTIES));
    public static final Supplier<FlowingFluid> FLOWING_MOLTEN_BRASS = FLUIDS.register("flowing_molten_brass",
            () -> new BaseFlowingFluid.Flowing(ModFluids.MOLTEN_BRASS_PROPERTIES));

    public static final DeferredBlock<LiquidBlock> MOLTEN_BRASS_BLOCK = ModBlocks.BLOCKS.register("molten_brass_block",
            () -> new LiquidBlock(ModFluids.SOURCE_MOLTEN_BRASS.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.LAVA).noLootTable()));
    public static final DeferredItem<Item> MOLTEN_BRASS_BUCKET = ModItems.ITEMS.registerItem("molten_brass_bucket",
            properties -> new BucketItem(ModFluids.SOURCE_MOLTEN_BRASS.get(), properties.craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final BaseFlowingFluid.Properties MOLTEN_BRASS_PROPERTIES = new BaseFlowingFluid.Properties(
            ModFluidTypes.MOLTEN_BRASS_FLUID_TYPE, SOURCE_MOLTEN_BRASS, FLOWING_MOLTEN_BRASS)
            .slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(ModFluids.MOLTEN_BRASS_BLOCK).bucket(ModFluids.MOLTEN_BRASS_BUCKET);

    //NETHERITE//

    public static final Supplier<FlowingFluid> SOURCE_MOLTEN_NETHERITE = FLUIDS.register("source_molten_netherite",
            () -> new BaseFlowingFluid.Source(ModFluids.MOLTEN_NETHERITE_PROPERTIES));
    public static final Supplier<FlowingFluid> FLOWING_MOLTEN_NETHERITE = FLUIDS.register("flowing_molten_netherite",
            () -> new BaseFlowingFluid.Flowing(ModFluids.MOLTEN_NETHERITE_PROPERTIES));

    public static final DeferredBlock<LiquidBlock> MOLTEN_NETHERITE_BLOCK = ModBlocks.BLOCKS.register("molten_netherite_block",
            () -> new LiquidBlock(ModFluids.SOURCE_MOLTEN_NETHERITE.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.LAVA).noLootTable()));
    public static final DeferredItem<Item> MOLTEN_NETHERITE_BUCKET = ModItems.ITEMS.registerItem("molten_netherite_bucket",
            properties -> new BucketItem(ModFluids.SOURCE_MOLTEN_NETHERITE.get(), properties.craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final BaseFlowingFluid.Properties MOLTEN_NETHERITE_PROPERTIES = new BaseFlowingFluid.Properties(
            ModFluidTypes.MOLTEN_NETHERITE_FLUID_TYPE, SOURCE_MOLTEN_NETHERITE, FLOWING_MOLTEN_NETHERITE)
            .slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(ModFluids.MOLTEN_NETHERITE_BLOCK).bucket(ModFluids.MOLTEN_NETHERITE_BUCKET);




    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
