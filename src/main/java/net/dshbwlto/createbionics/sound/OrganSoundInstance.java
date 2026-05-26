package net.dshbwlto.createbionics.sound;

import com.simibubi.create.content.decoration.steamWhistle.WhistleBlock;
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.Vec3;

import static com.simibubi.create.AllSoundEvents.*;

public class OrganSoundInstance extends AbstractTickableSoundInstance {

    private boolean active;
    private int keepAlive;
    private int size;

    public OrganSoundInstance(int size, BlockPos pos) {
        super((size == 1 ? WHISTLE_HIGH : size == 2 ? WHISTLE_MEDIUM : WHISTLE_LOW)
                .getMainEvent(), SoundSource.RECORDS, SoundInstance.createUnseededRandom());
        looping = true;
        active = true;
        volume = 0.05f;
        delay = 0;
        keepAlive();
        Vec3 v = Vec3.atCenterOf(pos);
        x = v.x;
        y = v.y;
        z = v.z;
    }

    public int getOctave() {
        return this.size;
    }

    public void fadeOut() {
        this.active = false;
    }

    public void keepAlive() {
        keepAlive = 2;
    }

    public void setPitch(float pitch) {
        this.pitch = pitch;
    }

    @Override
    public void tick() {
        if (active) {
            volume = Math.min(1, volume + .25f);
            keepAlive--;
            if (keepAlive == 0)
                fadeOut();
            return;

        }
        volume = Math.max(0, volume - .25f);
        if (volume == 0)
            stop();
    }

}
