
package net.dshbwlto.createbionics.entity;

import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.entity.api.GolemEntity;
import net.dshbwlto.createbionics.entity.api.MultiPartRobot;
import net.dshbwlto.createbionics.entity.custom.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BionicsEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(Registries.ENTITY_TYPE, CreateBionics.MOD_ID);

    public static final Supplier<EntityType<AnoleEntity>> ANOLE =
            ENTITIES.register("anole", () -> EntityType.Builder.of(AnoleEntity::new, MobCategory.CREATURE)
                    .sized(0.5f, 0.25f).build("anole"));

    public static final DeferredHolder<EntityType<?>, EntityType<MultiPartRobot<?>>> REPLETE = ENTITIES.register("replete",
            () -> EntityType.Builder.of(RepleteEntity::new, MobCategory.CREATURE)
                    .sized(3f, 2f).build("replete"));

    public static final DeferredHolder<EntityType<?>, EntityType<MultiPartRobot<?>>> OXHAULER = ENTITIES.register("oxhauler",
            () -> EntityType.Builder.of(OxhaulerEntity::new, MobCategory.CREATURE)
                    .sized(2f, 2f).build("oxhauler"));

    public static final DeferredHolder<EntityType<?>, EntityType<MultiPartRobot<?>>> ORGAN = ENTITIES.register("organ",
            () -> EntityType.Builder.of(OrganEntity::new, MobCategory.CREATURE)
                    .sized(4f, 6f).build("organ"));

    public static final Supplier<EntityType<SeekerEntity>> SEEKER =
            ENTITIES.register("seeker", () -> EntityType.Builder.of(SeekerEntity::new, MobCategory.CREATURE)
                    .sized(1f, 0.3f).build("seeker"));

    /// These are for future updates, just pretend they don't exist
    public static final Supplier<EntityType<StalkerEntity>> STALKER =
            ENTITIES.register("stalker", () -> EntityType.Builder.of(StalkerEntity::new, MobCategory.CREATURE)
                    .sized(1.5f, 1f).build("stalker"));

    public static final Supplier<EntityType<StalkerCaptainEntity>> STALKER_CAPTAIN =
            ENTITIES.register("stalker_captain", () -> EntityType.Builder.of(StalkerCaptainEntity::new, MobCategory.CREATURE)
                    .sized(1.5f, 1f).build("stalker_captain"));

    public static final DeferredHolder<EntityType<?>, EntityType<MultiPartRobot<?>>> GOLEM = ENTITIES.register("golem",
            () -> EntityType.Builder.of(GolemEntity::new, MobCategory.CREATURE)
                    .sized(1.25f, 3f).build("golem"));

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }
}
