package no.hvl.dat109.oblig1.game;

import no.hvl.dat109.oblig1.model.Brett;
import no.hvl.dat109.oblig1.model.Spiller;

import java.util.List;

public class Spill {

    private Brett brett;
    private List<Spiller> spillere;
    private Terning terning;
    private int aktivSpiller;

    public Spill(Brett brett, List<Spiller> spillere) {
        this.brett = brett;
        this.spillere = spillere;
        this.terning = new Terning();
        this.aktivSpiller = 0;
    }

    // Metoden starter spillet
    public void start() {
        while(!erFerdig()) {
            spillTur();
        }
    }

    public void spillTur() {
        spillere.get(aktivSpiller).spillTur(brett, terning);
        nesteSpiller();
    }

    // Metoden setter neste spiller
    public void nesteSpiller() {
        aktivSpiller = (aktivSpiller + 1) % spillere.size();
    }

    // Metoden sjekker om spillet er ferdig
    public boolean erFerdig() {
        if (spillere.get(aktivSpiller).getBrikke().posisjon == 100) {
            System.out.println(spillere.get(aktivSpiller).getNavn() + " har vunnet spillet! Gratulerer!");
            return true;
        }
        return false;
    }
}