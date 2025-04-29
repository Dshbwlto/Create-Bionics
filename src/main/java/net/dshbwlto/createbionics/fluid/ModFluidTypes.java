package net.dshbwlto.createbionics.fluid;

import net.dshbwlto.createbionics.CreateBionics;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.joml.Vector3f;

import java.util.function.Supplier;

public class ModFluidTypes {
    public static final ResourceLocation ANDESITE_STILL_RL = ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "block/fluid/molten_andesite_alloy_still");
    public static final ResourceLocation ANDESITE_FLOWING_RL = ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "block/fluid/molten_andesite_alloy_flow");
    public static final ResourceLocation LAVA_OVERLAY_RL = ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "block/wax_block");

    public static final ResourceLocation IRON_STILL_RL = ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "block/fluid/molten_industrial_iron_still");
    public static final ResourceLocation IRON_FLOWING_RL = ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "block/fluid/molten_industrial_iron_flow");

    public static final ResourceLocation BRASS_STILL_RL = ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "block/fluid/molten_brass_still");
    public static final ResourceLocation BRASS_FLOWING_RL = ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "block/fluid/molten_brass_flow");

    public static final ResourceLocation NETHERITE_STILL_RL = ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "block/fluid/molten_netherite_still");
    public static final ResourceLocation NETHERITE_FLOWING_RL = ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "block/fluid/molten_netherite_flow");

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(NeoForgeRegistries.Keys.FLUID_TYPES, CreateBionics.MOD_ID);


    public static final Supplier<FluidType> MOLTEN_ANDESITE_ALLOY_FLUID_TYPE = registerFluidType("molten_andesite_alloy_fluid",
            new BaseFluidType(ANDESITE_STILL_RL, ANDESITE_FLOWING_RL, LAVA_OVERLAY_RL, 0xA1FFFFFF,
                    new Vector3f(108f / 255f, 168f / 255f, 212f / 255f),
                    FluidType.Properties.create().viscosity(100).lightLevel(2).temperature(300)));

    public static final Supplier<FluidType> MOLTEN_INDUSTRIAL_IRON_FLUID_TYPE = registerFluidType("molten_industrial_iron_fluid",
            new BaseFluidType(IRON_STILL_RL, IRON_FLOWING_RL, LAVA_OVERLAY_RL, 0xA1FFFFFF,
                    new Vector3f(108f / 255f, 168f / 255f, 212f / 255f),
                    FluidType.Properties.create().viscosity(300).lightLevel(5).temperature(300)));

    public static final Supplier<FluidType> MOLTEN_BRASS_FLUID_TYPE = registerFluidType("molten_brass_fluid",
            new BaseFluidType(BRASS_STILL_RL, BRASS_FLOWING_RL, LAVA_OVERLAY_RL, 0xA1FFFFFF,
                    new Vector3f(108f / 255f, 168f / 255f, 212f / 255f),
                    FluidType.Properties.create().viscosity(400).lightLevel(10).temperature(300)));

    public static final Supplier<FluidType> MOLTEN_NETHERITE_FLUID_TYPE = registerFluidType("molten_netherite_fluid",
            new BaseFluidType(NETHERITE_STILL_RL, NETHERITE_FLOWING_RL, LAVA_OVERLAY_RL, 0xA1FFFFFF,
                    new Vector3f(108f / 255f, 168f / 255f, 212f / 255f),
                    FluidType.Properties.create().viscosity(500).lightLevel(15).temperature(300)));

    private static Supplier<FluidType> registerFluidType(String name, FluidType fluidType) {
        return FLUID_TYPES.register(name, () -> fluidType);
    }

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }
}
