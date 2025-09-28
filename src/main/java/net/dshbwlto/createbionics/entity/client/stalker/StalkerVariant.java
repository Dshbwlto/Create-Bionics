package net.dshbwlto.createbionics.entity.client.stalker;

import java.util.Arrays;
import java.util.Comparator;

public enum StalkerVariant {
    DEFAULT(0),
    COPPER(1),
    NETHERITE1_COPPER(2),
    NETHERITE1(3),
    NETHERITE2(4),
    NETHERITE3(5);

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
