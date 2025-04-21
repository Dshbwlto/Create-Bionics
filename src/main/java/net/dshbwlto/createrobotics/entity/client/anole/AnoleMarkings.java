package net.dshbwlto.createrobotics.entity.client.anole;

import net.minecraft.util.ByIdMap;

import java.util.function.IntFunction;

public enum AnoleMarkings {
    NONE(0),
    REDSTONE(1),
    GOLD(2),
    DIAMOND(3);

    private static final IntFunction<net.dshbwlto.createrobotics.entity.client.anole.AnoleMarkings> BY_ID = ByIdMap.continuous(net.dshbwlto.createrobotics.entity.client.anole.AnoleMarkings::getId, values(), ByIdMap.OutOfBoundsStrategy.WRAP);
    private final int id;

    private AnoleMarkings(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static net.dshbwlto.createrobotics.entity.client.anole.AnoleMarkings byId(int id) {
        return (net.dshbwlto.createrobotics.entity.client.anole.AnoleMarkings)BY_ID.apply(id);
    }
}
