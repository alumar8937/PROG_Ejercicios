package model;

import java.util.ArrayList;

public class Teams {
    
    private static Teams INSTANCE = null;
    public ArrayList<Team> teams = new ArrayList<Team>();

    private Teams() {
        // Equipos de Ejemplo.
        teams.add(new Team("Inazuma", "Japón", "Football Frontier", "Mark Evans"));
    }

    public static Teams getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Teams();
        }
        return INSTANCE;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

}
