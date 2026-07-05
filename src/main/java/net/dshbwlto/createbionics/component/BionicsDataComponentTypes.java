package net.dshbwlto.createbionics.component;

import com.mojang.serialization.Codec;
import net.dshbwlto.createbionics.CreateBionics;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.ExtraCodecs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.UnaryOperator;

public class BionicsDataComponentTypes {
    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPES =
            DeferredRegister.create(BuiltInRegistries.DATA_COMPONENT_TYPE, CreateBionics.MOD_ID);

    public static DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> VARIANT = register("variant",
            buider -> buider.persistent(ExtraCodecs.NON_NEGATIVE_INT));

    public static DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> MARKING = register("marking",
            buider -> buider.persistent(ExtraCodecs.NON_NEGATIVE_INT));

    public static DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> FUEL = register("fuel",
            buider -> buider.persistent(ExtraCodecs.NON_NEGATIVE_INT));

    public static DeferredHolder<DataComponentType<?>, DataComponentType<String>> NAME = register("name",
            buider -> buider.persistent(ExtraCodecs.NON_EMPTY_STRING));

    private static <T>DeferredHolder<DataComponentType<?>, DataComponentType<T>> register(String name, UnaryOperator<DataComponentType.Builder<T>> builderOperator) {
        return DATA_COMPONENT_TYPES.register(name, () -> builderOperator.apply(DataComponentType.builder()).build());
    }

    public static void register(IEventBus eventBus) {
        DATA_COMPONENT_TYPES.register(eventBus);
    }
}