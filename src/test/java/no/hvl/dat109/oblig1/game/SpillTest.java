package no.hvl.dat109.oblig1.game;

import no.hvl.dat109.oblig1.model.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;


/**
 * Tester funksjonaliteten til klassen Spill.
 * Inneholder enhetstester for spillflyt og vinnerlogikk.
 *
 *  * @author Gruppe2
 *  * @version 1.0
 *  * @since 2026-02-06
 *  */

class SpillTest {

    // Lager standard brett
    private Brett lagStandardBrett() {

        List<Rute> ruter = new ArrayList<>();

        for (int i = 1; i <= 100; i++) {
            ruter.add(new Rute(i, RuteType.NORMAL, 0));
        }

        return new Brett(ruter);
    }

    // Fake terning (alltid samme verdi)
    static class FakeTerning extends Terning {

        private final int verdi;

        FakeTerning(int verdi) {
            this.verdi = verdi;
        }

        @Override
        public int trill() {
            return verdi;
        }
    }

    @Test
    void spillStopperSpillerVinner() {

        Brett brett = lagStandardBrett();

        // Spiller nær mål
        Spiller spiller = new Spiller("Ola");
        spiller.getBrikke().setPosisjon(97);

        List<Spiller> spillere = List.of(spiller);

        // Terning gir alltid 3
        Terning terning = new FakeTerning(3);

        Spill spill = new Spill(brett, spillere, terning);

        spill.start();

        assertEquals(100, spiller.getBrikke().getPosisjon());
    }


    @Test
    void spillBytterSpiller() {

        Brett brett = lagStandardBrett();

        Spiller s1 = new Spiller("A");
        Spiller s2 = new Spiller("B");

        List<Spiller> spillere = List.of(s1, s2);

        Terning terning = new FakeTerning(1);

        Spill spill = new Spill(brett, spillere, terning);

        // Spill én tur
        spill.spillTur();
        spill.nesteSpiller();
        spill.spillTur();

        assertEquals(2, s1.getBrikke().getPosisjon());
        assertEquals(2, s2.getBrikke().getPosisjon());
    }


    @Test
    void erFerdigReturnererTrueVedVinner() {

        List<Rute> ruter = new ArrayList<>();

        // Lag ruter 1–100
        for (int i = 1; i <= 100; i++) {
            ruter.add(new Rute(i, RuteType.NORMAL, 0));
        }

        Brett brett = new Brett(ruter);

        Terning terning = new Terning();
        Spiller spiller = new Spiller("Vinner");
        spiller.getBrikke().setPosisjon(100);

        List<Spiller> spillere = List.of(spiller);

        Spill spill = new Spill(brett, spillere, terning);

        assertTrue(spill.erFerdig());
    }
}