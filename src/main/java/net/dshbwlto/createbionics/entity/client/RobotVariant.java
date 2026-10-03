package net.dshbwlto.createbionics.entity.client;

import java.util.Arrays;
import java.util.Comparator;

public enum RobotVariant {
    ANDESITE(0),
    BRASS(1),
    COPPER(2),
    STURDY_SHEET(3),
    NETHERITE(4),
    EXPOSED(5),
    WEATHERED(6),
    OXIDIZED(7);

    private static final RobotVariant[] BY_ID = Arrays.stream(values()).sorted(
            Comparator.comparingInt(RobotVariant::getId)).toArray(RobotVariant[]::new);
    private final int id;

    RobotVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static RobotVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }

}