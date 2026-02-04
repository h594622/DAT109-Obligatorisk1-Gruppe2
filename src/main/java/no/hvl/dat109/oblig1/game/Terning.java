package no.hvl.dat109.oblig1.game;

import java.util.Random;

public class Terning {

    public static int trill() {
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }
}
