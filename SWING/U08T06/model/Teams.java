package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Teams implements Serializable {

    private static final long serialVersionUID = 0;
    
    private static Teams INSTANCE = null;
    public ArrayList<Team> teams = new ArrayList<Team>();

    private Teams() {
        /* Equipos de Ejemplo.
        Team inazuma = new Team("Inazuma", "Japón", "Football Frontier", "Mark Evans");
        inazuma.getPlayers().add(new Player(PlayerPosition.PORTERO, "Mark Evans", 1995, 156, 2));
        teams.add(inazuma);//*/
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

    public void loadData(Teams teams) {
        INSTANCE = teams;
    }

}
