package net.dshbwlto.createrobotics.fluid;

import net.dshbwlto.createrobotics.CreateRobotics;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.joml.Vector3f;

import java.util.function.Supplier;

public class ModFluidTypes {
    public static final ResourceLocation LAVA_STILL_RL = ResourceLocation.parse("block/lava_still");
    public static final ResourceLocation LAVA_FLOWING_RL = ResourceLocation.parse("block/lava_flow");
    public static final ResourceLocation LAVA_OVERLAY_RL = ResourceLocation.parse("block/lava_overlay");

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(NeoForgeRegistries.Keys.FLUID_TYPES, CreateRobotics.MOD_ID);


    public static final Supplier<FluidType> MOLTEN_ANDESITE_ALLOY_FLUID_TYPE = registerFluidType("molten_andesite_alloy_fluid",
            new BaseFluidType(LAVA_STILL_RL, LAVA_FLOWING_RL, LAVA_OVERLAY_RL, 0xA1CAFF00,
                    new Vector3f(1f / 255f, 100f / 255f, 100f / 255f),
                    FluidType.Properties.create().viscosity(100)));


    private static Supplier<FluidType> registerFluidType(String name, FluidType fluidType) {
        return FLUID_TYPES.register(name, () -> fluidType);
    }

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }
}
