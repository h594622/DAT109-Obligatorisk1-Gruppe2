package no.hvl.dat109.oblig1.game;

import no.hvl.dat109.oblig1.model.Brett;
import no.hvl.dat109.oblig1.model.Spiller;

import java.util.List;
import java.util.Scanner;

/**
 * Styrer gjennomføringen av spillet.
 * Holder orden på spillet, spillere, neste spiller og vinner.
 *
 * @author Gruppe2
 * @version 1.0
 * @since 2026-02-06
 */

public class Spill {

    private Brett brett;
    private List<Spiller> spillere;
    private Terning terning;
    private int aktivSpiller;

    public Spill(Brett brett, List<Spiller> spillere, Terning terning) {
        this.brett = brett;
        this.spillere = spillere;
        this.terning = terning;
        this.aktivSpiller = 0;
    }

    // Metoden starter spillet
    public void start() {

        Scanner sc = new Scanner(System.in);

        while(!erFerdig()) {
            Spiller spiller = spillere.get(aktivSpiller);

            System.out.println(
                    spiller.getNavn()
                            + ": Din tur. Skriv 'trill' eller 'stopp'."
            );

            String valg = sc.nextLine().trim().toLowerCase();

            if (valg.equals("trill")) {

                spillTur();
                nesteSpiller();

            } else if (valg.equals("stopp")) {

                System.out.println("Spillet er avsluttet.");
                break;

            } else {

                System.out.println("Ugyldig valg. Prøv igjen.");
            }
        }

        sc.close();
    }


    public void spillTur() {
        Spiller spiller = spillere.get(aktivSpiller);
        spiller.spillTur(brett, terning);
    }

    // Metoden setter neste spiller
    public void nesteSpiller() {
        aktivSpiller = (aktivSpiller + 1) % spillere.size();
    }

    // Metoden sjekker om spillet er ferdig
    public boolean erFerdig() {
        for (Spiller spiller : spillere) {
            if (spiller.getBrikke().getPosisjon() == 100) {
                System.out.println(spiller.getNavn() + " har vunnet!");
                return true;
            }
        }
        return false;
    }
}