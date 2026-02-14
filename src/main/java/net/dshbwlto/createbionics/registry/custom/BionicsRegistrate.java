package net.dshbwlto.createbionics.registry.custom;

import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraft.world.effect.MobEffect;

import javax.sound.midi.MidiFileFormat;
import java.util.function.Supplier;

public class BionicsRegistrate extends CreateRegistrate {
    protected BionicsRegistrate(String modid) {
        super(modid);
    }

    public static BionicsRegistrate create(String modid) {
        return new BionicsRegistrate(modid);
    }

    public <T extends MobEffect> MobEffectBuilder<T, BionicsRegistrate> mobEffect(String name, Supplier<? extends T> factory) {
        return mobEffect(this, name, factory);
    }

    public <T extends MobEffect, P> MobEffectBuilder<T, P> mobEffect(P parent, Supplier<? extends T> factory) {
        return mobEffect(parent, currentName(), factory);
    }

    public <T extends MobEffect, P> MobEffectBuilder<T, P> mobEffect(P parent, String name, Supplier<? extends T> factory) {
        return entry(name, callback -> new MobEffectBuilder<>(this, parent, name, callback, factory));
    }

}