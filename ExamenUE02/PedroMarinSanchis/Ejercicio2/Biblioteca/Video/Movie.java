package PedroMarinSanchis.Ejercicio2.Biblioteca.Video;

public class Movie extends Video {
    private String director = "";
    private int order = 1;

    public Movie(String title, int duration, int[] releases, String director, int order) {
        super(title, duration, releases);
        this.director = director;
        this.order = order;
    }

    public String getDirector() {
        return director;
    }

    public int getOrder() {
        return order;
    }

}
