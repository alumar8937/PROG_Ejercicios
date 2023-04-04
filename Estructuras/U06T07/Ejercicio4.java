import java.util.ArrayList;
import java.util.Collections;

public class Ejercicio4 {

    private static ArrayList<ArrayList<Tesoro>> tesoros = new ArrayList<ArrayList<Tesoro>>();
    public static void main(String[] args) {
        introducirValores();
        mostrarTesorosOrdenados(tesoros);
    }

    private static void introducirValores() {
        tesoros.add(new ArrayList<Tesoro>());
        tesoros.get(0).add(new Tesoro("Flecha", 5, 1));
        tesoros.get(0).add(new Tesoro("Sarcofago", 1000, 1000));
        tesoros.get(0).add(new Tesoro("Mascara", 1000, 10));
        tesoros.get(0).add(new Tesoro("Arco", 10, 2));
    }

    private static void mostrarTesorosOrdenados(ArrayList<ArrayList<Tesoro>> tesoros) {
        for (ArrayList<Tesoro> listaTesoros : tesoros) {
            Collections.sort(listaTesoros);
            listaTesoros.stream().forEach(t -> System.out.println(t));
            System.out.println("--------");
        }
    }
}