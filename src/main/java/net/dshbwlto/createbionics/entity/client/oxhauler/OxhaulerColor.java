package net.dshbwlto.createbionics.entity.client.oxhauler;

import java.util.Arrays;
import java.util.Comparator;

public enum OxhaulerColor {
    WHITE(0),
    LIGHT_GRAY(1),
    GRAY(2),
    BLACK(3),
    BROWN(4),
    RED(5),
    ORANGE(6),
    YELLOW(7),
    LIME(8),
    GREEN(9),
    CYAN(10),
    LIGHT_BLUE(11),
    BLUE(12),
    PURPLE(13),
    MAGENTA(14),
    PINK(15);

    private static final OxhaulerColor[] BY_ID = Arrays.stream(values()).sorted(
            Comparator.comparingInt(OxhaulerColor::getId)).toArray(OxhaulerColor[]::new);
    private final int id;

    OxhaulerColor(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static OxhaulerColor byId(int id) {
        return BY_ID[id % BY_ID.length];
    }


}
