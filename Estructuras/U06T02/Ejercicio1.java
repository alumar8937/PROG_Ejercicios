import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Ejercicio1 {

    private static ArrayList<Coche> coches = new ArrayList<>();
    private static Scanner inputValue = new Scanner(System.in);
    private static boolean salir = false;
    public static void main(String[] args) {

        pedirCoches();
        mostrarCoches();

    }

    private static void pedirCoches() {
        while (!salir) {
            System.out.print("Introduce el nombre del coche: ");
            String nombre = inputValue.nextLine();

            if (nombre.equalsIgnoreCase("")) {
                salir = true;
            } else {
                coches.add(new Coche(nombre));
            }

        }
    }

    private static void mostrarCoches() {
        Iterator<Coche> iterador = coches.iterator();
        while (iterador.hasNext()) {
            System.out.println(iterador.next());
        }
    }

}
