package net.dshbwlto.createbionics.item;

import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.entity.ModEntities;
import net.dshbwlto.createbionics.item.custom.AnoleItem;
import net.dshbwlto.createbionics.item.custom.CommandWhistleItem;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CreateBionics.MOD_ID);

    public static final DeferredItem<Item> ANOLE_BODY = ITEMS.registerSimpleItem("anole_body");
    public static final DeferredItem<Item> I2_COAL_ENGINE = ITEMS.registerSimpleItem("i2_coal_engine");
    public static final DeferredItem<Item> ANOLE_HEAD = ITEMS.registerSimpleItem("anole_head");
    public static final DeferredItem<Item> ANOLE_LEG = ITEMS.registerSimpleItem("anole_leg");
    public static final DeferredItem<Item> ANOLE_TAIL = ITEMS.registerSimpleItem("anole_tail");
    public static final DeferredItem<Item> WAX_INGOT = ITEMS.registerSimpleItem("wax_ingot");
    public static final DeferredItem<Item> COMMAND_WHISTLE = ITEMS.register("command_whistle",
            () -> new CommandWhistleItem(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> ANOLE = ITEMS.register("anole",
            () -> new AnoleItem(ModEntities.ANOLE.get(), 0xFFFFFF, 0xFFFFFF,
                    new Item.Properties()));

    public static final DeferredItem<Item> THRUSTER = ITEMS.register("thrusteritem",
            () -> new DeferredSpawnEggItem(ModEntities.THRUSTER, 0xFFFFFF, 0xFFFFFF,
                    new Item.Properties()));

    public static void register(IEventBus eventBus) { ITEMS.register(eventBus);
    }
}
