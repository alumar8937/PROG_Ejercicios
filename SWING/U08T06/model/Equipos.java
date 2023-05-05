package model;

import java.util.ArrayList;

public class Equipos {
    
    private static Equipos INSTANCE = null;
    public ArrayList<Equipo> equipos = new ArrayList<Equipo>();

    private Equipos() {
        // Equipos de Ejemplo.
        equipos.add(new Equipo("Inazuma", "Japón", "Football Frontier", "Mark Evans"));
    }

    public static Equipos getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Equipos();
        }
        return INSTANCE;
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

}
