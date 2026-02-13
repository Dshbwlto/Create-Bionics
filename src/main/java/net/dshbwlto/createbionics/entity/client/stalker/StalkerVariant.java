package net.dshbwlto.createbionics.entity.client.stalker;

import java.util.Arrays;
import java.util.Comparator;

public enum StalkerVariant {
    COPPER(0),
    BRASS(1),
    ANDESITE(2);

    private static final StalkerVariant[] BY_ID = Arrays.stream(values()).sorted(
            Comparator.comparingInt(StalkerVariant::getId)).toArray(StalkerVariant[]::new);
    private final int id;

    StalkerVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static StalkerVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }


}
