package no.hvl.dat109.oblig1.model;

public class Brikke {

    public int posisjon;

    public Brikke(int startPosisjon) { this.posisjon = startPosisjon;
    }

    public int getPosisjon() { return posisjon;
    }

    /**
     * Utførere flytte-prosessen av brikken.
     *
     * Spiller-klassen bestemmer når denne metoden utføres:
     * 1. Flytter brikken etter tall på terningkast.
     * 2. Sjekker at den nye posisjonen ikke passerer rute 100.
     * 3. Sjekker om den nye posisjonen medfører ekstra flytt pga SLANGE/STIGE.
     *
     * @param steg antall steg gitt fra trill av terning
     * @param brett brettet som spilles på
     */
    public void flytt(int steg, Brett brett) {

        int nyPosisjon = steg + posisjon;

        if (nyPosisjon > 100) {
            return;
        }

        Rute rute = brett.hentRute(nyPosisjon);

        if (rute.getType() == RuteType.SLANGE || rute.getType() == RuteType.STIGE) {
            posisjon = rute.destinasjon;
        } else {
            posisjon = nyPosisjon;
        }
    }
}

