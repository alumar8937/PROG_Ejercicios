package model;

public class Player {
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

}
