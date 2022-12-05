public class Player {

    private int countryID;
    private String countryName;
    private String playerName;
    private int birthYear;
    private float playerHeight;
    private String club;

    public Player(int countryID, String countryName, String playerName, int birthYear, float playerHeight, String club) {

        this.countryID = countryID;
        this.countryName = countryName;
        this.playerName = playerName;
        this.birthYear = birthYear;
        this.playerHeight = playerHeight;
        this.club = club;

    }


    public int getCountryID() {

        return countryID;

    }


    public String getCountryName() {

        return countryName;

    }


    public String getPlayerName() {

        return playerName;

    }


    public int getBirthYear() {

        return birthYear;

    }


    public float getPlayerHeight() {

        return playerHeight;

    }


    public String getClub() {

        return club;

    }

}