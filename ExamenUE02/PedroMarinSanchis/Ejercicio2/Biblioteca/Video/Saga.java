package PedroMarinSanchis.Ejercicio2.Biblioteca.Video;

public class Saga {
    private String title;
    private Movie[] movies;

    public Saga(String tile, Movie[] movies) {
        this.title = tile;
        this.movies = movies;
    }

    public Movie[] getMovies() {
        return movies;
    }

    public String getTitle() {
        return title;
    }
}
