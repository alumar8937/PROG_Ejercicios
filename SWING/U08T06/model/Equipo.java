package model;

import java.util.ArrayList;

public class Equipo {
    
    private ArrayList<Jugador> players = new ArrayList<Jugador>();

    private String nombre = null;
    private String pais = null;
    private String nombreCompeticion = null;
    private String nombreEntrenador = null;

    public Equipo(String nombre, String pais, String nombreCompeticion, String nombreEntrenador) {
        this.nombre = nombre;
        this.pais = pais;
        this.nombreCompeticion = nombreCompeticion;
        this.nombreEntrenador = nombreEntrenador;
    }

    public String toString() {
        return nombre;
    }

    public ArrayList<Jugador> getJugadores() {
        return players;
    }
    
    public String getNombre() {
        return nombre;
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