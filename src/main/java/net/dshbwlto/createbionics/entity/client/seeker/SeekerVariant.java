package net.dshbwlto.createbionics.entity.client.seeker;

import java.util.Arrays;
import java.util.Comparator;

public enum SeekerVariant {
    COPPER(0),
    BRASS(1),
    ANDESITE(2);

    private static final SeekerVariant[] BY_ID = Arrays.stream(values()).sorted(
            Comparator.comparingInt(SeekerVariant::getId)).toArray(SeekerVariant[]::new);
    private final int id;

    SeekerVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static SeekerVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }


}