package net.dshbwlto.createrobotics.entity.client.anole;

import java.util.Arrays;
import java.util.Comparator;

public enum AnoleVariant {
    DEFAULT(0),
    BRASS(1),
    NETHERITE(2);

    private static final AnoleVariant[] BY_ID = Arrays.stream(values()).sorted(
            Comparator.comparingInt(AnoleVariant::getId)).toArray(AnoleVariant[]::new);
    private final int id;

    AnoleVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static AnoleVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }


}
