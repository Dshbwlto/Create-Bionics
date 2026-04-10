
package net.dshbwlto.createbionics.Util;

import net.dshbwlto.createbionics.CreateBionics;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class BionicsEntityDataSerializers {
    public static final DeferredRegister<EntityDataSerializer<?>> SERIALIZERS =
            DeferredRegister.create(NeoForgeRegistries.ENTITY_DATA_SERIALIZERS, CreateBionics.MOD_ID);

    public static final DeferredHolder<EntityDataSerializer<?>, EntityDataSerializer<FluidStack>> FLUID_STACK =
            SERIALIZERS.register("fluid_stack", () -> new EntityDataSerializer<>() {
                @Override
                public StreamCodec<? super RegistryFriendlyByteBuf, FluidStack> codec() {
                    return FluidStack.OPTIONAL_STREAM_CODEC;
                }

                @Override
                public FluidStack copy(FluidStack stack) {
                    return stack.copy();
                }
            });
}
