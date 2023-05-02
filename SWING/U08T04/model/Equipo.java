package model;

import java.util.ArrayList;

public class Equipo {
    
    private ArrayList<Jugador> players = null;

    private String pais = null;
    private String nombreCompeticion = null;
    private String nombreEntrenador = null;

    public Equipo(String pais, String nombreCompeticion, String nombreEntrenador) {
        this.pais = pais;
        this.nombreCompeticion = nombreCompeticion;
        this.nombreEntrenador = nombreEntrenador;
    }

    public ArrayList<Jugador> getPlayers() {
        return players;
    }

    public String getPais() {
        return pais;
    }

    public String getNombreCompeticion() {
        return nombreCompeticion;
    }

    public String getNombreEntrenador() {
        return nombreEntrenador;
    }

}