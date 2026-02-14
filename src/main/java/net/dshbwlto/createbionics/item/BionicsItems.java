package net.dshbwlto.createbionics.item;

import com.simibubi.create.foundation.item.ItemDescription;
import com.simibubi.create.foundation.item.KineticStats;
import com.simibubi.create.foundation.item.TooltipModifier;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.createmod.catnip.lang.FontHelper;
import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.entity.BionicsEntities;
import net.dshbwlto.createbionics.entity.custom.RepleteEntity;
import net.dshbwlto.createbionics.item.custom.*;
import net.dshbwlto.createbionics.registry.custom.BionicsRegistrate;
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
    public static final BionicsRegistrate REGISTRATE = CreateBionics.registrate();

    static {
        REGISTRATE.setTooltipModifierFactory(item ->
                new ItemDescription.Modifier(item, FontHelper.Palette.STANDARD_CREATE)
                        .andThen(TooltipModifier.mapNull(KineticStats.create(item)))
        );
    }


    public static final ItemEntry<RobotBuilderItem> ROBOT_BUILDER = REGISTRATE.item("robot_builder", RobotBuilderItem::new)
            .properties(properties -> properties.stacksTo(1)).register();

    public static final ItemEntry<SpawnEggItem> ANOLE = REGISTRATE.item("anole",
            properties -> new SpawnEggItem(BionicsEntities.ANOLE.get(), 0xFFFFFF, 0xFFFFFF, properties.stacksTo(1))).register();
    public static final ItemEntry<Item> ANOLE_BODY = REGISTRATE.item("anole_body_item", Item::new).register();
    public static final ItemEntry<Item> ANOLE_HEAD = REGISTRATE.item("anole_head_item", Item::new).register();
    public static final ItemEntry<Item> ANOLE_LEG = REGISTRATE.item("anole_leg_item", Item::new).register();
    public static final ItemEntry<Item> ANOLE_TAIL = REGISTRATE.item("anole_tail_item", Item::new).register();
    public static final ItemEntry<Item> I2_COAL_ENGINE = REGISTRATE.item("i2_coal_engine", Item::new).register();

    public static final ItemEntry<SpawnEggItem> OXHAULER_MIDDLE = REGISTRATE.item("oxhauler_middle_item",
            properties -> new SpawnEggItem(BionicsEntities.OXHAULER.get(), 0xFFFFFF, 0xFFFFFF, properties.stacksTo(1))).register();
    public static final ItemEntry<Item> OXHAULER_FRONT = REGISTRATE.item("oxhauler_front_item",
            Item::new).properties(properties -> properties.stacksTo(1)).register();
    public static final ItemEntry<Item> OXHAULER_REAR = REGISTRATE.item("oxhauler_rear_item",
            Item::new).properties(properties -> properties.stacksTo(1)).register();
    public static final ItemEntry<Item> OXHAULER_ENGINE = REGISTRATE.item("oxhauler_engine_item",
            Item::new).properties(properties -> properties.stacksTo(1)).register();
    public static final ItemEntry<Item> OXHAULER_LEG = REGISTRATE.item("oxhauler_leg_item",
            Item::new).properties(properties -> properties.stacksTo(1)).register();
    public static final ItemEntry<OxhaulerHeadItem> OXHAULER_HEAD = REGISTRATE.item("oxhauler_head_item",
            OxhaulerHeadItem::new).properties(properties -> properties.stacksTo(1)).register();

    public static final ItemEntry<SpawnEggItem> REPLETE_BODY = REGISTRATE.item("replete_body_item",
            properties -> new SpawnEggItem(BionicsEntities.REPLETE.get(), 0xFFFFFF, 0xFFFFFF, properties.stacksTo(1))).register();
    public static final ItemEntry<Item> REPLETE_LEG = REGISTRATE.item("replete_leg_item",
            Item::new).properties(properties -> properties.stacksTo(16)).register();

    public static final ItemEntry<SpawnEggItem> STALKER_BODY = REGISTRATE.item("stalker_body_item",
            properties -> new SpawnEggItem(BionicsEntities.STALKER.get(), 0xFFFFFF, 0xFFFFFF, properties.stacksTo(1))).register();
    public static final ItemEntry<Item> STALKER_LEG = REGISTRATE.item("stalker_leg_item",
            Item::new).properties(properties -> properties.stacksTo(1)).register();
    public static final ItemEntry<Item> STALKER_TAIL = REGISTRATE.item("stalker_tail_item",
            Item::new).properties(properties -> properties.stacksTo(1)).register();
    public static final ItemEntry<Item> STALKER_ANTENNA = REGISTRATE.item("stalker_antenna_item",
            Item::new).properties(properties -> properties.stacksTo(1)).register();
    public static final ItemEntry<Item> STALKER_HEAD = REGISTRATE.item("stalker_head_item",
            Item::new).properties(properties -> properties.stacksTo(1)).register();

    public static final ItemEntry<SpawnEggItem> ORGAN_MIDDLE = REGISTRATE.item("organ_middle_item",
            properties -> new SpawnEggItem(BionicsEntities.ORGAN.get(), 0xFFFFFF, 0xFFFFFF, properties.stacksTo(1))).register();
    public static final ItemEntry<Item> ORGAN_FOOT = REGISTRATE.item("organ_foot_item", Item::new)
            .properties(properties -> properties.stacksTo(1)).register();
    public static final ItemEntry<Item> ORGAN_TAIL_BASE = REGISTRATE.item("organ_tail_base_item", Item::new)
            .properties(properties -> properties.stacksTo(1)).register();
    public static final ItemEntry<Item> ORGAN_TAIL_END = REGISTRATE.item("organ_tail_end_item", Item::new)
            .properties(properties -> properties.stacksTo(1)).register();
    public static final ItemEntry<Item> ORGAN_CHEST = REGISTRATE.item("organ_chest_item", Item::new)
            .properties(properties -> properties.stacksTo(1)).register();
    public static final ItemEntry<Item> ORGAN_PISTON = REGISTRATE.item("organ_piston_item", Item::new)
            .properties(properties -> properties.stacksTo(1)).register();
    public static final ItemEntry<Item> ORGAN_BELLOWS = REGISTRATE.item("organ_bellows_item", Item::new)
            .properties(properties -> properties.stacksTo(1)).register();
    public static final ItemEntry<Item> ORGAN_NECK = REGISTRATE.item("organ_neck_item", Item::new)
            .properties(properties -> properties.stacksTo(1)).register();
    public static final ItemEntry<OrganHeadItem> ORGAN_HEAD = REGISTRATE.item("organ_head_item", OrganHeadItem::new)
            .properties(properties -> properties.stacksTo(1)).register();
    public static final ItemEntry<Item> ORGAN_CHIMNEY = REGISTRATE.item("organ_chimney_item", Item::new)
            .properties(properties -> properties.stacksTo(1)).register();

    public static final ItemEntry<Item> VITTICEPS_MUSIC_DISC = REGISTRATE.item("vitticeps_music_disc", Item::new)
            .properties(properties -> properties.jukeboxPlayable(BionicsSounds.VITTICEPS_KEY)).register();

    public static void register() {}
}
