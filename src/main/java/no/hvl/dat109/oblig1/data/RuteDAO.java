package no.hvl.dat109.oblig1.data;

import no.hvl.dat109.oblig1.model.Rute;
import no.hvl.dat109.oblig1.model.RuteType;

import java.sql.*;
import java.util.*;

public class RuteDAO {

    private final String url = "jdbc:postgresql://localhost:5432/brettspill";
    private final String user = "postgres";
    private final String password = "1999";

    public List<Rute> hentAlleRuter() {
        List<Rute> ruter = new ArrayList<>();

        String sql = "SELECT id, type, destinasjon FROM rute ORDER BY id";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                RuteType type = RuteType.valueOf(rs.getString("type"));
                Integer destinasjon =
                        rs.getObject("destinasjon", Integer.class);

                ruter.add(new Rute(id, type, destinasjon));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Kunne ikke hente brett", e);
        }

        return ruter;
    }
}
