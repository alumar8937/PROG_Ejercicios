package PedroMarinSanchis.Ejercicio2.Biblioteca.Video;

public class Chapter extends Video {
    private String director = "";
    private int season = 0;
    private int number = 0;

    public Chapter(String title, int duration, int[] releases, String director, int season, int number) {
        super(title, duration, releases);
        this.director = director;
        this.season = season;
        this.number = number;
    }

    public String getDirector() {
        return director;
    }

    public int getSeason() {
        return season;
    }

    public int getNumber() {
        return number;
    }

}
