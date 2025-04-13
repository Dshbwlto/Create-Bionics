package net.dshbwlto.createrobotics.entity;

import net.dshbwlto.createrobotics.CreateRobotics;
import net.dshbwlto.createrobotics.entity.custom.AnoleEntity;
import net.dshbwlto.createrobotics.entity.custom.ThrusterEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, CreateRobotics.MOD_ID);

    public static final Supplier<EntityType<AnoleEntity>> ANOLE =
            ENTITY_TYPES.register("anole", () -> EntityType.Builder.of(AnoleEntity::new, MobCategory.CREATURE)
                    .sized(0.5f, 0.25f).build("anole"));
    public static final Supplier<EntityType<ThrusterEntity>> THRUSTER =
            ENTITY_TYPES.register("thruster", () -> EntityType.Builder.of(ThrusterEntity::new, MobCategory.CREATURE)
                    .sized(0.5f, 0.25f).build("thruster"));



    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
