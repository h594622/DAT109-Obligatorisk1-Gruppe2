package no.hvl.dat109.oblig1.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Representerer spillebrettet.
 * Inneholder alle ruter og gir tilgang til dem via posisjon.
 *
 * @author Gruppe2
 * @version 1.0
 * @since 2026-02-06
 */

public class Brett {

    public final Map<Integer, Rute> ruter = new HashMap<>();

    // Mottar en liste fra RuteDAO og bli omgjort til et map
    public Brett (List<Rute> ruteList) {
        for (Rute r : ruteList) {
            ruter.put(r.id, r);
        }
    }

    // Hent aktuell rute
    public Rute hentRute(int posisjon) {
        return ruter.get(posisjon);
    }
}