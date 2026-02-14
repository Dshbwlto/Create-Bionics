package net.dshbwlto.createbionics;

import com.simibubi.create.foundation.item.ItemDescription;
import com.simibubi.create.foundation.item.KineticStats;
import com.simibubi.create.foundation.item.TooltipModifier;
import net.createmod.catnip.lang.FontHelper;
import net.dshbwlto.createbionics.block.BionicsBlocks;
import net.dshbwlto.createbionics.component.BionicsDataComponentTypes;
import net.dshbwlto.createbionics.entity.BionicsEntities;
import net.dshbwlto.createbionics.entity.client.anole.AnoleRenderer;
import net.dshbwlto.createbionics.entity.client.organ.OrganRenderer;
import net.dshbwlto.createbionics.entity.client.oxhauler.OxhaulerRenderer;
import net.dshbwlto.createbionics.entity.client.replete.RepleteRenderer;
import net.dshbwlto.createbionics.entity.client.stalker.StalkerRenderer;
import net.dshbwlto.createbionics.item.BionicsItems;
import net.dshbwlto.createbionics.registry.custom.BionicsRegistrate;
import net.dshbwlto.createbionics.screen.BionicsMenuTypes;
import net.dshbwlto.createbionics.screen.custom.OxhaulerScreen;
import net.dshbwlto.createbionics.sound.BionicsSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(CreateBionics.MOD_ID)
public class CreateBionics {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "createbionics";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final BionicsRegistrate REGISTRATE = (BionicsRegistrate) BionicsRegistrate.create(CreateBionics.MOD_ID)
            .defaultCreativeTab((ResourceKey<CreativeModeTab>) null)
            .setTooltipModifierFactory(item ->
                    new ItemDescription.Modifier(item, FontHelper.Palette.STANDARD_CREATE)
                            .andThen(TooltipModifier.mapNull(KineticStats.create(item))));

    static {
        REGISTRATE.setTooltipModifierFactory(item -> new ItemDescription.Modifier(item, FontHelper.Palette.STANDARD_CREATE)
                .andThen(TooltipModifier.mapNull(KineticStats.create(item))));
    }

    private static final ItemLike[] excludedItemsList = new ItemLike[]{
            BionicsItems.REPLETE_LEG,
            BionicsItems.REPLETE_BODY,
            BionicsItems.OXHAULER_ENGINE,
    };
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAIN_TAB = CREATIVE_MODE_TABS.register(MOD_ID, () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
            .icon(() -> BionicsItems.ANOLE.get().asItem().getDefaultInstance())
            .title(Component.translatable("itemGroup.createbionics.create_bionics_tab"))
            .displayItems((itemDisplayParameters, output) -> REGISTRATE.getAll(Registries.ITEM).forEach((item -> {
                for (ItemLike excluded : excludedItemsList) {
                    if (item.is(excluded.asItem())) {
                        output.accept(item.get(), CreativeModeTab.TabVisibility.SEARCH_TAB_ONLY);
                        return;
                    }
                }
                output.accept(item.get());
            })))
            .build());
    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public CreateBionics(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading

        REGISTRATE.registerEventListeners(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        BionicsItems.register();

        BionicsBlocks.register();

        BionicsSounds.register(modEventBus);

        BionicsEntities.register(modEventBus);

        BionicsMenuTypes.register(modEventBus);

        BionicsDataComponentTypes.register(modEventBus);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (ExampleMod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");

        if (Config.logDirtBlock)
            LOGGER.info("DIRT BLOCK >> {}", BuiltInRegistries.BLOCK.getKey(Blocks.DIRT));

        LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);

        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }
    public static ResourceLocation asResource(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }
    public static BionicsRegistrate registrate() {
        return REGISTRATE;
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MOD_ID, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
            EntityRenderers.register(BionicsEntities.ANOLE.get(), AnoleRenderer::new);
            EntityRenderers.register(BionicsEntities.OXHAULER.get(), OxhaulerRenderer::new);
            EntityRenderers.register(BionicsEntities.REPLETE.get(), RepleteRenderer::new);
            EntityRenderers.register(BionicsEntities.STALKER.get(), StalkerRenderer::new);
            EntityRenderers.register(BionicsEntities.ORGAN.get(), OrganRenderer::new);
        }

        @SubscribeEvent
        public static void registerScreens(RegisterMenuScreensEvent event) {
            event.register(BionicsMenuTypes.OXHAULER_MENU.get(), OxhaulerScreen::new);
        }

        @SubscribeEvent
        public static void onClientExtensions(RegisterClientExtensionsEvent event) {

        }
    }
}

