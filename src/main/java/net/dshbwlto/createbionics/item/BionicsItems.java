package net.dshbwlto.createbionics.item;

import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.entity.BionicsEntities;
import net.dshbwlto.createbionics.item.custom.*;
import net.dshbwlto.createbionics.sound.BionicsSounds;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BionicsItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CreateBionics.MOD_ID);

    public static final DeferredItem<Item> ANOLE_BODY = ITEMS.registerSimpleItem("anole_body");
    public static final DeferredItem<Item> I2_COAL_ENGINE = ITEMS.registerSimpleItem("i2_coal_engine");
    public static final DeferredItem<Item> ANOLE_HEAD = ITEMS.registerSimpleItem("anole_head");
    public static final DeferredItem<Item> ANOLE_LEG = ITEMS.registerSimpleItem("anole_leg");
    public static final DeferredItem<Item> ANOLE_TAIL = ITEMS.registerSimpleItem("anole_tail");
    public static final DeferredItem<Item> WAX_INGOT = ITEMS.registerSimpleItem("wax_ingot");

    public static final DeferredItem<Item> OXHAULER_HEAD = ITEMS.registerSimpleItem("oxhauler_head_item");
    public static final DeferredItem<Item> OXHAULER_FRONT = ITEMS.registerSimpleItem("oxhauler_front_item");
    public static final DeferredItem<Item> OXHAULER_REAR = ITEMS.registerSimpleItem("oxhauler_rear_item");
    public static final DeferredItem<Item> OXHAULER_ENGINE = ITEMS.registerSimpleItem("oxhauler_engine_item");
    public static final DeferredItem<Item> OXHAULER_LEG = ITEMS.registerSimpleItem("oxhauler_leg_item");

    public static final DeferredItem<Item> STALKER_HEAD = ITEMS.registerSimpleItem("stalker_head_item");
    public static final DeferredItem<Item> STALKER_LEG = ITEMS.registerSimpleItem("stalker_leg_item");
    public static final DeferredItem<Item> STALKER_TAIL = ITEMS.registerSimpleItem("stalker_tail_item");
    public static final DeferredItem<Item> STALKER_ANTENNA = ITEMS.registerSimpleItem("stalker_antenna_item");

    public static final DeferredItem<Item> NETHER_BRICK_CRUCIBLE = ITEMS.registerSimpleItem("nether_brick_crucible");

    public static final DeferredItem<Item> ROSE_QUARTZ_NUGGET = ITEMS.registerSimpleItem("rose_quartz_nugget");
    public static final DeferredItem<Item> MINI_ELECTRON_TUBE = ITEMS.registerSimpleItem("mini_electron_tube");
    public static final DeferredItem<Item> COMPOUND_EYE = ITEMS.registerSimpleItem("compound_eye");
    public static final DeferredItem<Item> REPLETE_LEG = ITEMS.registerSimpleItem("replete_leg");
    public static final DeferredItem<Item> REPLETE_REAR_LEG = ITEMS.registerSimpleItem("replete_rear_leg");
    public static final DeferredItem<Item> REPLETE_BODY = ITEMS.registerSimpleItem("replete_body");

    public static final DeferredItem<Item> COMMAND_WHISTLE = ITEMS.register("command_whistle",
            () -> new CommandWhistleItem(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> SHEET_MUSIC = ITEMS.register("sheet_music",
            () -> new SheetMusicItem(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> MOLTEN_ANDESITE_ALLOY_CRUCIBLE = ITEMS.register("molten_andesite_alloy_crucible",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> MOLTEN_INDUSTRIAL_IRON_CRUCIBLE = ITEMS.register("molten_industrial_iron_crucible",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> MOLTEN_BRASS_CRUCIBLE = ITEMS.register("molten_brass_crucible",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> MOLTEN_NETHERITE_CRUCIBLE = ITEMS.register("molten_netherite_crucible",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> SILENT_PISTON = ITEMS.register("silent_piston",
            () -> new SilentPistonItem(new Item.Properties()));

    public static final DeferredItem<Item> ANOLE = ITEMS.register("anole",
            () -> new AnoleItem(BionicsEntities.ANOLE.get(), 0xFFFFFF, 0xFFFFFF,
                    new Item.Properties().rarity(Rarity.UNCOMMON)));

    public static final DeferredItem<Item> OXHAULER_MIDDLE = ITEMS.register("oxhauler_middle_item",
            () -> new OxhaulerSpawnerItem(BionicsEntities.OXHAULER.get(), 0xFFFFFF, 0xFFFFFF,
                    new Item.Properties().rarity(Rarity.UNCOMMON)));

   public static final DeferredItem<Item> STALKER_BODY = ITEMS.register("stalker_body_item",
            () -> new StalkerSpawnerItem(BionicsEntities.STALKER.get(), 0xFFFFFF, 0xFFFFFF,
                    new Item.Properties().rarity(Rarity.UNCOMMON)));

    public static final DeferredItem<Item> REPLETE_SPAWNER = ITEMS.register("replete_spawner",
            () -> new SpawnEggItem(BionicsEntities.REPLETE.get(), 0xFFFFFF, 0xFFFFFF,
                    new Item.Properties()));

    public static final DeferredItem<Item> VITTICEPS_MUSIC_DISC = ITEMS.registerItem("vitticeps_music_disc",
            properties -> new Item(properties.jukeboxPlayable(BionicsSounds.VITTICEPS_KEY)));

    public static void register(IEventBus eventBus) { ITEMS.register(eventBus);
    }
}
