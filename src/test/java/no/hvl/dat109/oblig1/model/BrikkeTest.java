package no.hvl.dat109.oblig1.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Tester funksjonaliteten til Brikke.
 * Inneholder enhetstester for om brikken flytter seg normal, ikke beveger seg forbi 100 og om brikken flytter seg ved stige.
 *
 *  * @author Gruppe2
 *  * @version 1.0
 *  * @since 2026-02-06
 *  */
class BrikkeTest {

    @Test
    void brikkeFlytterNormalt() {

        List<Rute> ruter = new ArrayList<>();

        // Lag ruter 1–100
        for (int i = 1; i <= 100; i++) {
            ruter.add(new Rute(i, RuteType.NORMAL, 0));
        }

        Brett brett = new Brett(ruter);

        Brikke brikke = new Brikke(1);

        brikke.flytt(4, brett);

        assertEquals(5, brikke.getPosisjon());
    }


    @Test
    void brikkeStoppHundre() {

        List<Rute> ruter = new ArrayList<>();
        Brett brett = new Brett(ruter);

        Brikke brikke = new Brikke(1);

        brikke.flytt(105, brett);

        assertEquals(1, brikke.getPosisjon());
    }


    @Test
    void brikkeFlyttesViaStige() {

        List<Rute> ruter = new ArrayList<>();

        // Rute 3 er stige til 22
        ruter.add(new Rute(3, RuteType.STIGE, 22));

        Brett brett = new Brett(ruter);

        Brikke brikke = new Brikke(0);

        brikke.flytt(3, brett);

        assertEquals(22, brikke.getPosisjon());
    }
}