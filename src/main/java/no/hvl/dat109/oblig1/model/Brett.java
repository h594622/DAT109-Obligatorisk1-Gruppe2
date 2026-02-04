package no.hvl.dat109.oblig1.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Brett {

    public final Map<Integer, Rute> ruter = new HashMap<>();

    public Brett (List<Rute> ruteList) {
        for (Rute r : ruteList) {
            ruter.put(r.id, r);
        }

    }

    public Rute hentRute(int posisjon) {
       return ruter.get(posisjon);
    }
}