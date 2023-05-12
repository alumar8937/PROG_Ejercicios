package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.PlayerPosition;
import model.Team;
import model.Teams;
import model.Player;
public class Controller {
    
    public static void addPlayer(Team team, PlayerPosition position, String name, int birthyear, int height, int number) {
        Player player = new Player(position, name, birthyear, height, number);
        team.getPlayers().add(player);
    }

    public static void addTeam(String name, String country, String competitionName, String coachName) {
        Teams.getInstance().getTeams().add(new Team(name, country, competitionName, coachName));
    }

    public static void modifyTeam(Team team, String name, String country, String competitionName, String coachName) {
        team.setName(name);
        team.setCompetitionName(competitionName);
        team.setCoachName(coachName);
        team.setCountry(country);
    }

    public static PlayerPosition[] getPlayerPosition() {
        return PlayerPosition.values();
    }

    public static ArrayList<Team> getTeams() {
        return Teams.getInstance().getTeams();
    }

    public static void imprimirDatosPorConsola() {
        for (Team e: getTeams()) {
            System.out.println("Nombre: "+e.getName());
            System.out.println("País: "+e.getCountry());
            System.out.println("Nombre de la competición: "+e.getCompetitionName());
            System.out.println("Nombre del entrenador: "+e.getCoachName());
            System.out.println("Jugadores: ");
            for (Player j: e.getPlayers()) {
                System.out.println("\tDemarcación: "+j.getPlayerPosition());
                System.out.println("\tNombre: "+j.getName());
                System.out.println("\tAño de nacimiento: "+j.getBirthyear());
                System.out.println("\tAltura: "+j.getHeight());
                System.out.println("\tDorsal: "+j.getNumber());
                System.out.println("");
            }
            System.out.println("");
        }
    }

    public static void saveData() throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream("savedData"+File.separatorChar+"savedData.dat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(Teams.getInstance());
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    public static void loadData() throws Exception {
        FileInputStream fileInputStream = new FileInputStream("savedData"+File.separatorChar+"savedData.dat");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Teams.getInstance().loadData((Teams) objectInputStream.readObject());
        objectInputStream.close(); 
    }

}
