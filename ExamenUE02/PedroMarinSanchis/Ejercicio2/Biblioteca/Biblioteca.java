package PedroMarinSanchis.Ejercicio2.Biblioteca;

public class Biblioteca {
    private Ejemplar[] ejemplares = null;

    public Biblioteca(Ejemplar[] ejemplares) {
        this.ejemplares = ejemplares;
    }

    public Ejemplar getEjemplar(int index) {
        return ejemplares[index];
    }
}
