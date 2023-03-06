package PedroMarinSanchis.Ejercicio3;

import PedroMarinSanchis.Ejercicio2.Biblioteca.Video.Movie;
import PedroMarinSanchis.Ejercicio2.Biblioteca.Video.Saga;

public class GestorSaga {

    private static Saga saga = null;

    public static void mostrarSaga() {
        int duracionTotal = 0;
        System.out.println("\nTítulos de la saga: ");
        for(Movie e: saga.getMovies()) {
            System.out.println(e.getTitle());
            duracionTotal = duracionTotal + e.getDurationInMinutes();
        }
        System.out.println("Duración total: "+duracionTotal+" minutos.");
    }

    public static void setSaga(Saga sagaTest) {
        GestorSaga.saga = sagaTest;
    }

    public static Saga getSaga() {
        return saga;
    }

}
