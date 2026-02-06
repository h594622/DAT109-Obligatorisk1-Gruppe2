package no.hvl.dat109.oblig1.model;

/**
 * Representerer en rute på brettet.
 * Ruten kan være normal, stige eller slange.
 *
 * @author Gruppe2
 * @version 1.0
 * @since 2026-02-06
 */

public class Rute {

    public final int id;
    public final RuteType type;
    public final Integer destinasjon;

    public Rute(int id, RuteType type, Integer destinasjon) {
        this.id = id;
        this.type = type;
        this.destinasjon = destinasjon;
    }

    public int getId() {
        return id;
    }

    public RuteType getType() {
        return type;
    }

    public int getDestinasjon() {
        return destinasjon;
    }
}
