package net.dshbwlto.createbionics.item;

import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.block.ModBlocks;
import net.dshbwlto.createbionics.fluid.ModFluids;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateBionics.MOD_ID);

    public static final Supplier<CreativeModeTab> CREATE_BIONICS_TAB =
            CREATIVE_MODE_TABS.register("create_bionics_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.createbionics.create_bionics_tab"))
                    .icon(() -> new ItemStack(ModItems.ANOLE.get()))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.ANOLE);
                        output.accept(ModItems.ANOLE_BODY);
                        output.accept(ModItems.ANOLE_HEAD);
                        output.accept(ModItems.ANOLE_TAIL);
                        output.accept(ModItems.ANOLE_LEG);
                        output.accept(ModItems.I2_COAL_ENGINE);
                        output.accept(ModItems.COMMAND_WHISTLE);
                        output.accept(ModFluids.MOLTEN_ANDESITE_ALLOY_BUCKET);
                        output.accept(ModFluids.MOLTEN_INDUSTRIAL_IRON_BUCKET);
                        output.accept(ModFluids.MOLTEN_BRASS_BUCKET);
                        output.accept(ModFluids.MOLTEN_NETHERITE_BUCKET);
                        output.accept(ModBlocks.OXHAULER_FRONT);
                        output.accept(ModBlocks.OXHAULER_FRONT_WAX);
                        output.accept(ModBlocks.OXHAULER_REAR);
                        output.accept(ModBlocks.OXHAULER_REAR_WAX);
                        output.accept(ModBlocks.OXHAULER_HEAD);
                        output.accept(ModBlocks.OXHAULER_HEAD_WAX);
                        output.accept(ModBlocks.OXHAULER_FURNACE);
                        output.accept(ModBlocks.OXHAULER_FURNACE_WAX);
                        output.accept(ModBlocks.OXHAULER_GRATE);
                        output.accept(ModBlocks.OXHAULER_GRATE_WAX);
                        output.accept(ModBlocks.OXHAULER_ENGINE);
                        output.accept(ModBlocks.OXHAULER_ENGINE_WAX);


                    }).build());

    public static void register(IEventBus eventBus) {CREATIVE_MODE_TABS.register(eventBus);}
}

