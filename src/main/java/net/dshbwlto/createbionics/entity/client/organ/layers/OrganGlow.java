package net.dshbwlto.createbionics.entity.client.organ.layers;

import java.util.Arrays;
import java.util.Comparator;

public enum OrganGlow {
    DEFAULT(0),
    REDSTONE1(1),
    REDSTONE2(2);

    private static final OrganGlow[] BY_ID = Arrays.stream(values()).sorted(
            Comparator.comparingInt(OrganGlow::getId)).toArray(OrganGlow[]::new);
    private final int id;

    OrganGlow(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static OrganGlow byId(int id) {
        return BY_ID[id % BY_ID.length];
    }


}
