package net.dshbwlto.createbionics.entity;

import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.entity.custom.*;
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
                    .sized(4f, 5f).build("replete"));

    public static final Supplier<EntityType<StalkerEntity>> STALKER =
            ENTITY_TYPES.register("stalker", () -> EntityType.Builder.of(StalkerEntity::new, MobCategory.CREATURE)
                    .sized(1.5f, 1f).build("stalker"));

    public static final Supplier<EntityType<OrganEntity>> ORGAN =
            ENTITY_TYPES.register("organ", () -> EntityType.Builder.of(OrganEntity::new, MobCategory.CREATURE)
                    .sized(7, 7f).build("organ"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
