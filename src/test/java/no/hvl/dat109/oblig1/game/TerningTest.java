package no.hvl.dat109.oblig1.game;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertTrue;

public class TerningTest {
    @org.junit.Test
    @Test
    public void testTrill() {
        Terning terning = new Terning();

        for (int i = 0; i < 100; i++) {
            int tal = terning.trill();
            assertTrue(tal >= 1 && tal <= 6);
        }
    }
}