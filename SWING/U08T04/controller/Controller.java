package controller;

import java.util.ArrayList;

import model.Demarcacion;
import model.Equipo;
import model.Equipos;
import model.Jugador;

public class Controller {
    
    public static void addJugador(Equipo equipo, Demarcacion demarcacion, String nombre, int anyoNacimiento, int altura, int dorsal) {
        Jugador jugador = new Jugador(demarcacion, nombre, anyoNacimiento, altura, dorsal);
        equipo.getJugadores().add(jugador);
    }

    public static void addEquipo(String nombre, String pais, String nombreCompeticion, String nombreEntrenador) {
        Equipos.getInstance().getEquipos().add(new Equipo(nombre, pais, nombreCompeticion, nombreEntrenador));
    }

    public static Demarcacion[] getDemarcaciones() {
        return Demarcacion.values();
    }

    public static ArrayList<Equipo> getEquipos() {
        return Equipos.getInstance().getEquipos();
    }

    public static void imprimirDatosPorConsola() {
        for (Equipo e: getEquipos()) {
            System.out.println("Nombre: "+e.getNombre());
            System.out.println("País: "+e.getPais());
            System.out.println("Nombre de la competición: "+e.getNombreCompeticion());
            System.out.println("Nombre del entrenador: "+e.getNombreEntrenador());
            System.out.println("Jugadores: ");
            for (Jugador j: e.getJugadores()) {
                System.out.println("\tDemarcación: "+j.getDemarcacion());
                System.out.println("\tNombre: "+j.getNombre());
                System.out.println("\tAño de nacimiento: "+j.getAnyoNacimiento());
                System.out.println("\tAltura: "+j.getAltura());
                System.out.println("\tDorsal: "+j.getDorsal());
                System.out.println("");
            }
            System.out.println("");
        }
    }

}
