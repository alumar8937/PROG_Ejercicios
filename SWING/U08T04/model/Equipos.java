package model;

import java.util.ArrayList;

public class Equipos {
    
    private static Equipos INSTANCE = null;
    public ArrayList<Equipo> equipos = new ArrayList<Equipo>();

    private Equipos() {}

    public static Equipos getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Equipos();
        }
        return INSTANCE;
    }

}
