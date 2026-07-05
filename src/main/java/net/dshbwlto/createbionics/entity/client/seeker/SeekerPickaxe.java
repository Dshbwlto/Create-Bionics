package net.dshbwlto.createbionics.entity.client.seeker;

import java.util.Arrays;
import java.util.Comparator;

public enum SeekerPickaxe {
    IRON(0),
    DIAMOND(1),
    NETHERITE(2);

    private static final SeekerPickaxe[] BY_ID = Arrays.stream(values()).sorted(
            Comparator.comparingInt(SeekerPickaxe::getId)).toArray(SeekerPickaxe[]::new);
    private final int id;

    SeekerPickaxe(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static SeekerPickaxe byId(int id) {
        return BY_ID[id % BY_ID.length];
    }


}