package net.dshbwlto.createbionics.entity.client.matchbox;

import java.util.Arrays;
import java.util.Comparator;

public enum MatchboxVariant {
    COPPER(0),
    BRASS(1),
    ANDESITE(2);

    private static final MatchboxVariant[] BY_ID = Arrays.stream(values()).sorted(
            Comparator.comparingInt(MatchboxVariant::getId)).toArray(MatchboxVariant[]::new);
    private final int id;

    MatchboxVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static MatchboxVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}