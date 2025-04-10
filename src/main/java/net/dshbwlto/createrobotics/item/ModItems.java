package net.dshbwlto.createrobotics.item;

import net.dshbwlto.createrobotics.CreateRobotics;
import net.dshbwlto.createrobotics.entity.ModEntities;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CreateRobotics.MOD_ID);

    public static final DeferredItem<Item> ANOLE_BODY = ITEMS.registerSimpleItem("anole_body");
    public static final DeferredItem<Item> I2_COAL_ENGINE = ITEMS.registerSimpleItem("i2_coal_engine");
    public static final DeferredItem<Item> ANOLE_HEAD = ITEMS.registerSimpleItem("anole_head");
    public static final DeferredItem<Item> ANOLE_LEG = ITEMS.registerSimpleItem("anole_leg");
    public static final DeferredItem<Item> ANOLE_TAIL = ITEMS.registerSimpleItem("anole_tail");
    public static final DeferredItem<Item> WAX_INGOT = ITEMS.registerSimpleItem("wax_ingot");
    public static final DeferredItem<Item> ANOLE = ITEMS.registerSimpleItem("anole");
    public static final DeferredItem<Item> ANOLE_BRASS = ITEMS.registerSimpleItem("anole_brass");

    public static final DeferredItem<Item> ANOLE_SPAWN_EGG = ITEMS.register("anole_spawn_egg",
            () -> new DeferredSpawnEggItem(ModEntities.ANOLE, 0xdebd47, 0xccbfbe,
                    new Item.Properties()));

    public static void register(IEventBus eventBus) { ITEMS.register(eventBus);
    }
}
