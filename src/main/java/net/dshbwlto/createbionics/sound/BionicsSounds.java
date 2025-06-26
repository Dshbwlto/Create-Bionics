package net.dshbwlto.createbionics.sound;

import net.dshbwlto.createbionics.CreateBionics;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BionicsSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, CreateBionics.MOD_ID);

    public static final Supplier<SoundEvent> ENGINE = registerSoundEvent("engine");
    public static final Supplier<SoundEvent> THRUSTER = registerSoundEvent("thruster");
    public static final Supplier<SoundEvent> COMMAND_WHISTLE = registerSoundEvent("command_whistle");

    private static Supplier<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {
      SOUND_EVENTS.register(eventBus);
    }
}
