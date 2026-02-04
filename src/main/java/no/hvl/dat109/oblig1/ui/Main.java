package no.hvl.dat109.oblig1.ui;
import no.hvl.dat109.oblig1.game.Spill;
import no.hvl.dat109.oblig1.model.Brett;
import no.hvl.dat109.oblig1.model.Spiller;
import no.hvl.dat109.oblig1.data.RuteDAO;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // 1. Hent brettet én gang fra databasen
        RuteDAO ruteDAO = new RuteDAO();
        Brett brett = new Brett(ruteDAO.hentAlleRuter());

        // 2. Opprett spillere
        List<Spiller> spillere = List.of(
                new Spiller("Trude"),
                new Spiller("Malene"),
                new Spiller("Øyvind")
        );

        // 3. Start spillet
        Spill spill = new Spill(brett, spillere);
        spill.start();
    }
}
