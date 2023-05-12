package model;

import java.io.Serializable;

public class Player implements Serializable {

    private static final long serialVersionUID = 2;

    private PlayerPosition playerPosition = null;
    private String name = null;
    private int birthyear = 0;
    private int height = 0;
    private int number = 0;

    public Player(PlayerPosition playerPosition, String name, int birthyear, int height, int number) {
        this.playerPosition = playerPosition;
        this.name = name;
        this.birthyear = birthyear;
        this.height = height;
        this.number = number;
    }

    public String toString() {
        return name;
    }

    public PlayerPosition getPlayerPosition() {
        return playerPosition;
    }

    public String getName() {
        return name;
    }

    public int getBirthyear() {
        return birthyear;
    }

    public int getHeight() {
        return height;
    }

    public int getNumber() {
        return number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthyear(int birthyear) {
        this.birthyear = birthyear;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPlayerPosition(PlayerPosition playerPosition) {
        this.playerPosition = playerPosition;
    }

}
