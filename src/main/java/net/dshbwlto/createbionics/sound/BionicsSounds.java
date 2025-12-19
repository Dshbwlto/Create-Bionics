package net.dshbwlto.createbionics.sound;

import net.dshbwlto.createbionics.CreateBionics;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.util.DeferredSoundType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BionicsSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, CreateBionics.MOD_ID);

    public static final Supplier<SoundEvent> ENGINE_START = registerSoundEvent("engine_start");
    public static final Supplier<SoundEvent> ENGINE_IDLE = registerSoundEvent("engine_idle");
    public static final Supplier<SoundEvent> THRUSTER = registerSoundEvent("thruster");
    public static final Supplier<SoundEvent> COMMAND_WHISTLE = registerSoundEvent("command_whistle");

    public static final Supplier<SoundEvent> OXHAULER_BELLOW_1 = registerSoundEvent("oxhauler_bellow_1");
    public static final Supplier<SoundEvent> OXHAULER_BELLOW_2 = registerSoundEvent("oxhauler_bellow_2");
    public static final Supplier<SoundEvent> OXHAULER_BELLOW_3 = registerSoundEvent("oxhauler_bellow_3");
    public static final Supplier<SoundEvent> OXHAULER_RELEASE_1 = registerSoundEvent("oxhauler_release_1");

    public static final Supplier<SoundEvent> VITTICEPS = registerSoundEvent("vitticeps");
    public static final ResourceKey<JukeboxSong> VITTICEPS_KEY = createSong("vitticeps");

    private static ResourceKey<JukeboxSong> createSong(String name) {
        return ResourceKey.create(Registries.JUKEBOX_SONG, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, name));
    }

    private static Supplier<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {
      SOUND_EVENTS.register(eventBus);
    }
}
