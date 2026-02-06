package no.hvl.dat109.oblig1.model;

import no.hvl.dat109.oblig1.game.Terning;

/**
 * Representerer en spiller av spillet.
 * Inneholder navn og brikke. Og har ansvar for å spille sin tur.
 *
 * @author Gruppe2
 * @version 1.0
 * @since 2026-02-06
 */

public class Spiller {

    private String navn;
    private Brikke brikke;

    public Spiller(String navn) {
        this.navn = navn;
        this.brikke = new Brikke(1); // start på rute 1
    }

    public String getNavn() {
        return navn;
    }

    public Brikke getBrikke() {
        return brikke;
    }

    /**
     * Utfører én spilltur for spilleren.
     * Spill-klassen bestemmer når denne metoden kalles.
     * Om spiller triller 6, får den trille på nytt. Om den har trillet 6'er tre ganger går turen videre.
     * @param brett brettet som spilles på
     * @param terning terningen som trilles
     */
    public void spillTur(Brett brett, Terning terning) {

        int steg;
        int antallSeksere = 0;

        do {

            int gammelPos = brikke.getPosisjon();

            steg = terning.trill();

            int nyPos = gammelPos + steg;

            // Hvis man går over 100 → ikke flytt
            if (nyPos > 100) {

                System.out.println(
                        navn + " trillet " + steg +
                                ", men kan ikke gå over 100."
                );

            } else {

                Rute rute = brett.hentRute(nyPos);

                brikke.flytt(steg, brett);

                String type = rute.getType().toString().toLowerCase();

                System.out.println(
                        navn + " trillet " + steg +
                                " og landet på " + type +
                                ". Flytter fra " + gammelPos +
                                " til " + brikke.getPosisjon() + "."
                );
            }

            if (steg == 6) {
                antallSeksere++;
            }

        } while (steg == 6 && antallSeksere < 3);
    }

}
