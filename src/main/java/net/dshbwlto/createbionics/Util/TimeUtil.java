package net.dshbwlto.createbionics.Util;

public class TimeUtil {

    public static String ticksToMinutes(int ticks) {
        int second;
        int minute;
        int hour;
        second = ticks / 20;
        minute = second / 60;
        second -= minute * 60;
        hour = minute / 60;
        minute -= hour * 60;

        String x = second < 10 ? "0" : "";
        String y = minute < 10 ? "0" : "";
        String z = hour < 10 ? "0" : "";

        String h = hour == 0 ? "" : z + hour + ":";
        String m = minute == 0 && hour == 0 ? "" : y + minute + ":";
        String s = second == 0 && minute == 0 ? "" : x + second;

        return h +  m + s;
    }
}
