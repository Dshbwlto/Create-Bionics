package net.dshbwlto.createbionics.entity;

import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.entity.custom.AnoleEntity;
import net.dshbwlto.createbionics.entity.custom.OxhaulerEntity;
import net.dshbwlto.createbionics.entity.custom.RepleteEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BionicsEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, CreateBionics.MOD_ID);

    public static final Supplier<EntityType<AnoleEntity>> ANOLE =
            ENTITY_TYPES.register("anole", () -> EntityType.Builder.of(AnoleEntity::new, MobCategory.CREATURE)
                    .sized(0.5f, 0.25f).build("anole"));

    public static final Supplier<EntityType<OxhaulerEntity>> OXHAULER =
            ENTITY_TYPES.register("oxhauler", () -> EntityType.Builder.of(OxhaulerEntity::new, MobCategory.CREATURE)
                    .sized(2f, 2f).build("oxhauler"));

    public static final Supplier<EntityType<RepleteEntity>> REPLETE =
            ENTITY_TYPES.register("replete", () -> EntityType.Builder.of(RepleteEntity::new, MobCategory.CREATURE)
                    .sized(5f, 7f).build("replete"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
