package net.dshbwlto.createbionics.entity.client.anole;

import java.util.Arrays;
import java.util.Comparator;

public enum AnoleMarkings {
    DEFAULT(0),
    REDSTONE(1),
    GOLD(2),
    DIAMOND(3);

    private static final AnoleMarkings[] BY_ID = Arrays.stream(values()).sorted(
            Comparator.comparingInt(AnoleMarkings::getId)).toArray(AnoleMarkings[]::new);
    private final int id;

    AnoleMarkings(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static AnoleMarkings byId(int id) {
        return BY_ID[id % BY_ID.length];
    }


}
