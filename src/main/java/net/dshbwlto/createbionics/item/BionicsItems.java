package net.dshbwlto.createbionics.item;

import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.entity.BionicsEntities;
import net.dshbwlto.createbionics.item.custom.*;
import net.dshbwlto.createbionics.sound.BionicsSounds;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BionicsItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CreateBionics.MOD_ID);

    public static final DeferredItem<Item> ANOLE_BODY = ITEMS.registerSimpleItem("anole_body_item");
    public static final DeferredItem<Item> I2_COAL_ENGINE = ITEMS.registerSimpleItem("i2_coal_engine");
    public static final DeferredItem<Item> ANOLE_HEAD = ITEMS.registerSimpleItem("anole_head_item");
    public static final DeferredItem<Item> ANOLE_LEG = ITEMS.registerSimpleItem("anole_leg_item");
    public static final DeferredItem<Item> ANOLE_TAIL = ITEMS.registerSimpleItem("anole_tail_item");

    public static final DeferredItem<Item> OXHAULER_FRONT = ITEMS.registerSimpleItem("oxhauler_front_item");
    public static final DeferredItem<Item> OXHAULER_REAR = ITEMS.registerSimpleItem("oxhauler_rear_item");
    public static final DeferredItem<Item> OXHAULER_ENGINE = ITEMS.registerSimpleItem("oxhauler_engine_item");
    public static final DeferredItem<Item> OXHAULER_LEG = ITEMS.registerSimpleItem("oxhauler_leg_item");
    public static final DeferredItem<Item> OXHAULER_HEAD = ITEMS.register("oxhauler_head_item",
            () -> new OxhaulerHeadItem(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> STALKER_HEAD = ITEMS.registerSimpleItem("stalker_head_item");
    public static final DeferredItem<Item> STALKER_LEG = ITEMS.registerSimpleItem("stalker_leg_item");
    public static final DeferredItem<Item> STALKER_TAIL = ITEMS.registerSimpleItem("stalker_tail_item");
    public static final DeferredItem<Item> STALKER_ANTENNA = ITEMS.registerSimpleItem("stalker_antenna_item");

    public static final DeferredItem<Item> REPLETE_LEG = ITEMS.registerSimpleItem("replete_leg_item");
    public static final DeferredItem<Item> REPLETE_BODY = ITEMS.registerSimpleItem("replete_body_item");

    public static final DeferredItem<Item> ORGAN_FOOT = ITEMS.register("organ_foot_item",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> ORGAN_TAIL_BASE = ITEMS.register("organ_tail_base_item",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> ORGAN_TAIL_END = ITEMS.register("organ_tail_end_item",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> ORGAN_CHEST = ITEMS.register("organ_chest_item",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> ORGAN_PISTON = ITEMS.register("organ_piston_item",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ORGAN_BELLOWS = ITEMS.register("organ_bellows_item",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> ORGAN_NECK = ITEMS.register("organ_neck_item",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> ORGAN_HEAD = ITEMS.register("organ_head_item",
            () -> new OrganHeadItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> ORGAN_CHIMNEY = ITEMS.register("organ_chimney_item",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> SHEET_MUSIC = ITEMS.register("sheet_music",
            () -> new SheetMusicItem(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> ROBOT_BUILDER = ITEMS.register("robot_builder",
            () -> new RobotBuilderItem(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> SILENT_PISTON = ITEMS.register("silent_piston",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ANOLE = ITEMS.register("anole",
            () -> new SpawnEggItem(BionicsEntities.ANOLE.get(), 0xFFFFFF, 0xFFFFFF,
                    new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> OXHAULER_MIDDLE = ITEMS.register("oxhauler_middle_item",
            () -> new SpawnEggItem(BionicsEntities.OXHAULER.get(), 0xFFFFFF, 0xFFFFFF,
                    new Item.Properties().stacksTo(1)));

   public static final DeferredItem<Item> STALKER_BODY = ITEMS.register("stalker_body_item",
            () -> new SpawnEggItem(BionicsEntities.STALKER.get(), 0xFFFFFF, 0xFFFFFF,
                    new Item.Properties().stacksTo(1)));

   public static final DeferredItem<Item> ORGAN_MIDDLE = ITEMS.register("organ_middle_item",
            () -> new SpawnEggItem(BionicsEntities.ORGAN.get(), 0xFFFFFF, 0xFFFFFF,
                    new Item.Properties().stacksTo(1)));

   public static final DeferredItem<Item> REPLETE_SPAWNER = ITEMS.register("replete_spawner",
            () -> new SpawnEggItem(BionicsEntities.REPLETE.get(), 0xFFFFFF, 0xFFFFFF,
                    new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> VITTICEPS_MUSIC_DISC = ITEMS.registerItem("vitticeps_music_disc",
            properties -> new Item(properties.jukeboxPlayable(BionicsSounds.VITTICEPS_KEY)));

    public static void register(IEventBus eventBus) { ITEMS.register(eventBus);
    }
}
