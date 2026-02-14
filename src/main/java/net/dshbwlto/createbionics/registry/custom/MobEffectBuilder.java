package net.dshbwlto.createbionics.registry.custom;

import com.tterrag.registrate.builders.AbstractBuilder;
import com.tterrag.registrate.builders.BuilderCallback;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;

import java.util.function.Supplier;

public class MobEffectBuilder<T extends MobEffect, P> extends AbstractBuilder<MobEffect, T, P, MobEffectBuilder<T, P>> {
    private final Supplier<? extends T> factory;

    public MobEffectBuilder(BionicsRegistrate owner, P parent, String name, BuilderCallback callback, Supplier<? extends T> factory) {
        super(owner, parent, name, callback, Registries.MOB_EFFECT);
        this.factory = factory;
    }

    public MobEffectBuilder<T, P> lang(String name) {
        return this.lang(MobEffect::getDescriptionId, name);
    }

    @Override
    protected T createEntry() {
        return factory.get();
    }
}