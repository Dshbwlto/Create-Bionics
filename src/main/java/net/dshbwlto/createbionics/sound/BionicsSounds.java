
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

    public static final Supplier<SoundEvent> OXHAULER_BELLOW_1 = registerSoundEvent("oxhauler_bellow_1");
    public static final Supplier<SoundEvent> OXHAULER_BELLOW_2 = registerSoundEvent("oxhauler_bellow_2");
    public static final Supplier<SoundEvent> OXHAULER_BELLOW_3 = registerSoundEvent("oxhauler_bellow_3");
    public static final Supplier<SoundEvent> OXHAULER_RELEASE_1 = registerSoundEvent("oxhauler_release_1");

    public static final Supplier<SoundEvent> REPLETE_DAMAGE_1 = registerSoundEvent("replete_damage_1");
    public static final Supplier<SoundEvent> REPLETE_DAMAGE_2 = registerSoundEvent("replete_damage_2");
    public static final Supplier<SoundEvent> REPLETE_DAMAGE_3 = registerSoundEvent("replete_damage_3");
    public static final Supplier<SoundEvent> REPLETE_IDLE_1 = registerSoundEvent("replete_idle_1");
    public static final Supplier<SoundEvent> REPLETE_IDLE_2 = registerSoundEvent("replete_idle_2");
    public static final Supplier<SoundEvent> REPLETE_IDLE_3 = registerSoundEvent("replete_idle_3");
    public static final Supplier<SoundEvent> REPLETE_IDLE_4 = registerSoundEvent("replete_idle_4");
    public static final Supplier<SoundEvent> REPLETE_IDLE_5 = registerSoundEvent("replete_idle_5");

    public static final Supplier<SoundEvent> GET_STICK_BUGGED = registerSoundEvent("get_stick_bugged");

    public static final Supplier<SoundEvent> WALTZ_2 = registerSoundEvent("waltz_2");
    public static final ResourceKey<JukeboxSong> WALTZ_2_KEY = createSong("waltz_2");

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
