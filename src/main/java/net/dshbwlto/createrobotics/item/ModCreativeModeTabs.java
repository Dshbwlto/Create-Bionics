package net.dshbwlto.createrobotics.item;

import net.dshbwlto.createrobotics.CreateRobotics;
import net.dshbwlto.createrobotics.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateRobotics.MOD_ID);

    public static final Supplier<CreativeModeTab> CREATE_ROBOTICS_TAB =
            CREATIVE_MODE_TABS.register("create_robotics_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.createrobotics.create_robotics_tab"))
                    .icon(() -> new ItemStack(ModItems.ANOLE.get()))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.ANOLE);
                        output.accept(ModItems.ANOLE_BRASS);
                        output.accept(ModItems.ANOLE_BODY);
                        output.accept(ModItems.ANOLE_HEAD);
                        output.accept(ModItems.ANOLE_TAIL);
                        output.accept(ModItems.ANOLE_LEG);
                        output.accept(ModItems.I2_COAL_ENGINE);
                        output.accept(ModBlocks.WAX_BLOCK);
                        output.accept(ModItems.WAX_INGOT);
                        output.accept(ModBlocks.OXHAULER_FRAME_FRONT);
                        output.accept(ModBlocks.OXHAULER_FRAME_REAR);
                        output.accept(ModBlocks.OXHAULER_FRAME_HEAD);
                        output.accept(ModBlocks.OXHAULER_FURNACE);
                        output.accept(ModBlocks.OXHAULER_GRATE);
                        output.accept(ModBlocks.OXHAULER_ENGINE_BLOCK);



                    }).build());

    public static void register(IEventBus eventBus) {CREATIVE_MODE_TABS.register(eventBus);}
}

