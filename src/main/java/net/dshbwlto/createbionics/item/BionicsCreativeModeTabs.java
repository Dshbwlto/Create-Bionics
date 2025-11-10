package net.dshbwlto.createbionics.item;

import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.block.BionicsBlocks;
import net.dshbwlto.createbionics.fluid.BionicsFluids;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BionicsCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateBionics.MOD_ID);

    public static final Supplier<CreativeModeTab> CREATE_BIONICS_TAB =
            CREATIVE_MODE_TABS.register("create_bionics_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.createbionics.create_bionics_tab"))
                    .icon(() -> new ItemStack(BionicsItems.ANOLE.get()))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(BionicsItems.ANOLE);
                        output.accept(BionicsItems.OXHAULER_MIDDLE);
                        output.accept(BionicsItems.SILENT_PISTON);
                        output.accept(BionicsItems.SHEET_MUSIC);
                        output.accept(BionicsItems.ANOLE_BODY);
                        output.accept(BionicsItems.ANOLE_HEAD);
                        output.accept(BionicsItems.ANOLE_TAIL);
                        output.accept(BionicsItems.ANOLE_LEG);
                        output.accept(BionicsItems.I2_COAL_ENGINE);
                        output.accept(BionicsItems.WAX_INGOT);
                        output.accept(BionicsBlocks.WAX_BLOCK);
                        output.accept(BionicsBlocks.SCRAP_ANDESITE);
                        output.accept(BionicsBlocks.SCRAP_BRASS);
                        output.accept(BionicsBlocks.SCRAP_INDUSTRIAL_IRON);
                        output.accept(BionicsBlocks.SCRAP_NETHERITE);
                        output.accept(BionicsItems.OXHAULER_HEAD);
                        output.accept(BionicsItems.OXHAULER_FRONT);
                        output.accept(BionicsItems.OXHAULER_MIDDLE);
                        output.accept(BionicsItems.OXHAULER_REAR);
                        output.accept(BionicsItems.OXHAULER_ENGINE);
                        output.accept(BionicsItems.OXHAULER_LEG);
                        output.accept(BionicsItems.STALKER_ANTENNA);
                        output.accept(BionicsItems.STALKER_BODY);
                        output.accept(BionicsItems.STALKER_LEG);
                        output.accept(BionicsItems.STALKER_TAIL);
                        output.accept(BionicsItems.STALKER_HEAD);
                        output.accept(BionicsItems.MOLTEN_ANDESITE_ALLOY_CRUCIBLE);
                        output.accept(BionicsItems.MOLTEN_INDUSTRIAL_IRON_CRUCIBLE);
                        output.accept(BionicsItems.MOLTEN_BRASS_CRUCIBLE);
                        output.accept(BionicsItems.MOLTEN_NETHERITE_CRUCIBLE);
                        output.accept(BionicsItems.NETHER_BRICK_CRUCIBLE);
                        output.accept(BionicsFluids.MOLTEN_ANDESITE_ALLOY_BUCKET);
                        output.accept(BionicsFluids.MOLTEN_INDUSTRIAL_IRON_BUCKET);
                        output.accept(BionicsFluids.MOLTEN_BRASS_BUCKET);
                        output.accept(BionicsFluids.MOLTEN_NETHERITE_BUCKET);
                        output.accept(BionicsBlocks.OXHAULER_HEAD);
                        output.accept(BionicsBlocks.OXHAULER_FRONT);
                        output.accept(BionicsBlocks.OXHAULER_REAR);
                        output.accept(BionicsBlocks.OXHAULER_FURNACE);
                        output.accept(BionicsBlocks.OXHAULER_GRATE);
                        output.accept(BionicsBlocks.OXHAULER_ENGINE);
                        output.accept(BionicsBlocks.OXHAULER_HEAD_WAX);
                        output.accept(BionicsBlocks.OXHAULER_FRONT_WAX);
                        output.accept(BionicsBlocks.OXHAULER_REAR_WAX);
                        output.accept(BionicsBlocks.OXHAULER_FURNACE_WAX);
                        output.accept(BionicsBlocks.OXHAULER_GRATE_WAX);
                        output.accept(BionicsBlocks.OXHAULER_ENGINE_WAX);
                        output.accept(BionicsItems.VITTICEPS_MUSIC_DISC);
                    }).build());

    public static void register(IEventBus eventBus) {CREATIVE_MODE_TABS.register(eventBus);}
}

