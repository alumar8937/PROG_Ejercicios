package controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import model.Demarcacion;
import model.Equipo;
import model.Equipos;
import model.Jugador;
import programLanguage.LangHandler;
import view.teamView.playerEntry;

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

    public static Queue<playerEntry> getPlayerEntries(Equipo equipo) {
        Queue<playerEntry> teamViewPlayerEntries = new LinkedList<playerEntry>();
        for (Jugador j: equipo.getJugadores()) {
            teamViewPlayerEntries.add(new playerEntry(
                "<b>"+LangHandler.getInstance().getProperty("demarcacion")+":</b> "+j.getDemarcacion()
                +"<b><br>"+LangHandler.getInstance().getProperty("nombre")+":</b> "+j.getNombre()
                +"<b><br>"+LangHandler.getInstance().getProperty("anyoNacimiento")+"</b> "+j.getAnyoNacimiento()
                +"<b><br>"+LangHandler.getInstance().getProperty("altura")+"</b> "+j.getAltura()
                +"<b><br>"+LangHandler.getInstance().getProperty("dorsal")+"</b> "+j.getDorsal()));
        }
        return teamViewPlayerEntries;
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
