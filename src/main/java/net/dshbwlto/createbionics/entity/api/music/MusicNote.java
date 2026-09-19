package net.dshbwlto.createbionics.entity.api.music;

import java.util.logging.Level;

public class MusicNote {
    private int index;
    private int pitch;
    private float volume;
    private float start_time;
    private float duration;
    private boolean vibrato;
    private boolean sustain;

    public MusicNote(int index, int pitch, float volume, float start_time, float duration, boolean vibrato, boolean sustain) {
        this.index = index;
        this.pitch = pitch;
        this.volume = volume;
        this.start_time = start_time;
        this.duration = duration;
        this.vibrato = vibrato;
        this.sustain = sustain;
    }

    public void play(Level level) {

    }
}
