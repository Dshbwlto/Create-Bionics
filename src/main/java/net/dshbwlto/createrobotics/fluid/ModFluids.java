package net.dshbwlto.createrobotics.fluid;

import net.dshbwlto.createrobotics.CreateRobotics;
import net.dshbwlto.createrobotics.block.ModBlocks;
import net.dshbwlto.createrobotics.item.ModItems;
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
            DeferredRegister.create(BuiltInRegistries.FLUID, CreateRobotics.MOD_ID);

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
            .slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(ModFluids.MOLTEN_ANDESITE_ALLOY_BLOCK).bucket(ModFluids.MOLTEN_ANDESITE_ALLOY_BUCKET);

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
