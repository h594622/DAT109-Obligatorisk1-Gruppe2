package no.hvl.dat109.oblig1.game;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tester funksjonaliteten til Terning.
 * Inneholder enhetstester for trill terning.
 *
 *  * @author Gruppe2
 *  * @version 1.0
 *  * @since 2026-02-06
 *  */
public class TerningTest {

    @Test
    public void testTrill() {
        Terning terning = new Terning();

        for (int i = 0; i < 100; i++) {
            int tal = terning.trill();
            assertTrue(tal >= 1 && tal <= 6);
        }
    }
}