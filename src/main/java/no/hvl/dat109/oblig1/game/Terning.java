package no.hvl.dat109.oblig1.game;

import java.util.Random;

/**
 * Representerer terningen som brukes i spillet.
 * Gir et tall mellom 1 og 6.
 *
 * @author Gruppe2
 * @version 1.0
 * @since 2026-02-06
 */
public class Terning {

    public int trill() {
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }
}
