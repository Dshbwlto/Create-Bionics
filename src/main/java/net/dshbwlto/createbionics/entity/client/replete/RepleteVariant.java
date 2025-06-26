package net.dshbwlto.createbionics.entity.client.replete;

import java.util.Arrays;
import java.util.Comparator;

public enum RepleteVariant {
    DEFAULT(0),
    BRASS(1),
    NETHERITE1_COPPER(2),
    NETHERITE1_BRASS(3),
    NETHERITE2(4),
    NETHERITE3(5);

    private static final RepleteVariant[] BY_ID = Arrays.stream(values()).sorted(
            Comparator.comparingInt(RepleteVariant::getId)).toArray(RepleteVariant[]::new);
    private final int id;

    RepleteVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static RepleteVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }


}
