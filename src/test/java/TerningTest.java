import no.hvl.dat109.oblig1.game.Terning;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertTrue;

public class TerningTest {
    @org.junit.Test
    @Test
    public void testTrill() {
        int tall = Terning.trill();
        assertTrue("Tallet " + tall + " er mellom 1 og 6.",tall > 0 && tall < 7 );
    }
}