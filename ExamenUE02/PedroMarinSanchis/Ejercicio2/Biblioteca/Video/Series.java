package PedroMarinSanchis.Ejercicio2.Biblioteca.Video;

public class Series {
    private String title;
    public Chapter[] chapters;

    public Series(String tile, Chapter[] chapters) {
        this.title = tile;
        this.chapters = chapters;
    }
    
    public String getTitle() {
        return title;
    }
}
