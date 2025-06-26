package net.dshbwlto.createbionics.entity.client.oxhauler;

import java.util.Arrays;
import java.util.Comparator;

public enum OxhaulerVariant {
    DEFAULT(0),
    COPPER(1),
    NETHERITE1(2),
    NETHERITE2(3);

    private static final OxhaulerVariant[] BY_ID = Arrays.stream(values()).sorted(
            Comparator.comparingInt(OxhaulerVariant::getId)).toArray(OxhaulerVariant[]::new);
    private final int id;

    OxhaulerVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static OxhaulerVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }


}
