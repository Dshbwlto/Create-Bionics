package net.dshbwlto.createbionics.entity.client.organ.layers;

import java.util.Arrays;
import java.util.Comparator;

public enum OrganVariant {
    BRASS(0),
    ANDESITE(1),
    COPPER(2),
    STURDY_SHEET(3);

    private static final OrganVariant[] BY_ID = Arrays.stream(values()).sorted(
            Comparator.comparingInt(OrganVariant::getId)).toArray(OrganVariant[]::new);
    private final int id;

    OrganVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static OrganVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }


}
