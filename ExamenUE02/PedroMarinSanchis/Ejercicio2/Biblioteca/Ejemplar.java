package PedroMarinSanchis.Ejercicio2.Biblioteca;

public abstract class Ejemplar {
    protected String title;
    
    protected Ejemplar(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
