package no.hvl.dat109.oblig1.model;

import no.hvl.dat109.oblig1.game.Terning;

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
        int gammelPos = brikke.getPosisjon();
        int antallSeksere = 0;

        do {
            steg = terning.trill();
            brikke.flytt(steg, brett);

            System.out.println(
                    navn + " trillet " + steg +
                            " og flyttet fra " + gammelPos +
                            " til " + brikke.getPosisjon()
            );
            if (steg == 6) {
                antallSeksere++;
            }
        } while (steg == 6 && antallSeksere < 3);
    }

}
