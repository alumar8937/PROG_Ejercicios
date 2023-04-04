import java.util.ArrayList;
import java.util.Collections;

public class Ejercicio3 {

    private static ArrayList<ArrayList<Chaval>> chavales = new ArrayList<ArrayList<Chaval>>();
    public static void main(String[] args) {
        introducirValores();
        mostrarChavalesOrdenados(chavales);
    }

    private static void introducirValores() {
        chavales.add(new ArrayList<Chaval>());
        chavales.get(0).add(new Chaval(80, 2));
        chavales.get(0).add(new Chaval(100, 12));
        chavales.get(0).add(new Chaval(100, 1));
        chavales.add(new ArrayList<Chaval>());
        chavales.get(1).add(new Chaval(1, 1));
        chavales.get(1).add(new Chaval(1, 1));
    }

    private static void mostrarChavalesOrdenados(ArrayList<ArrayList<Chaval>> chavales) {
        for (ArrayList<Chaval> listaChavales : chavales) {
            Collections.sort(listaChavales);
            listaChavales.stream().forEach(t -> System.out.println(t));
            System.out.println("--------");
        }
    }
}