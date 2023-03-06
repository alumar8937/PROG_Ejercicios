package PedroMarinSanchis.Ejercicio2.Biblioteca.Video;

import PedroMarinSanchis.Ejercicio2.Biblioteca.Ejemplar;;

public abstract class Video extends Ejemplar implements IContainsVideo {
    protected int duration = 0;
    protected int[] releases = null;

    protected Video(String title, int duration, int[] releases) {
        super(title);
        this.duration = duration;
        this.releases = releases;
    }

    public int getDurationInMinutes() {
        return duration;
    }

    public int getRelease() {
        int oldestRelease = releases[0];
        for (int i = 1; i < releases.length; i++) {
            if (oldestRelease > releases[i]) {
                oldestRelease = releases[i];
            }
        }
        return oldestRelease;
    }
}
