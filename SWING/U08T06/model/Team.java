package model;

import java.util.ArrayList;

public class Team {
    
    private ArrayList<Player> players = new ArrayList<Player>();

    private String name = null;
    private String country = null;
    private String competitionName = null;
    private String coachName = null;

    public Team(String name, String country, String competitionName, String coachName) {
        this.name = name;
        this.country = country;
        this.competitionName = competitionName;
        this.coachName = coachName;
    }

    public String toString() {
        return name;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
    
    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setName(String nombre) {
        this.name = nombre;
    }

    public void setCompetitionName(String nombreCompeticion) {
        this.competitionName = nombreCompeticion;
    }

    public void setCoachName(String nombreEntrenador) {
        this.coachName = nombreEntrenador;
    }

    public void setCountry(String pais) {
        this.country = pais;
    }

}