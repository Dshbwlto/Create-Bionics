package net.dshbwlto.createrobotics.item;

import net.dshbwlto.createrobotics.CreateRobotics;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CreateRobotics.MOD_ID);

    public static final DeferredItem<Item> ANOLE_BODY = ITEMS.registerSimpleItem("anole_body");
    public static final DeferredItem<Item> I2_COAL_ENGINE = ITEMS.registerSimpleItem("i2_coal_engine");

    public static void register(IEventBus eventBus) { ITEMS.register(eventBus);
    }
}
