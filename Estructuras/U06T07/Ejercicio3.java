import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ejercicio3 {

    private static ArrayList<ArrayList<Chaval>> tareas = new ArrayList<ArrayList<Chaval>>();
    public static void main(String[] args) {
        Scanner inputValue = new Scanner(System.in);
        introducirValores(inputValue);
        mostrarTareasOrdenadas(tareas);
    }

    private static void introducirValores(Scanner inputValue) {
        int entrada = 1;
        while (entrada != 0) {
            System.out.print("Introduce el número de chavales que queres añadir: ");
            entrada = inputValue.nextInt();
            inputValue.nextLine();
            ArrayList<Chaval> listaTareas = new ArrayList<Chaval>();
            for (int i = 0; i < entrada; i++) {
                System.out.print("Puntuación [1-100]: "); // Asumimos que el usuario leerá el texto.
                int bueno = inputValue.nextInt();
                inputValue.nextLine();

                System.out.print("Peso de los regalos [1-100]: "); // Asumimos que el usuario leerá el texto.
                int pesoRegalos = inputValue.nextInt();
                inputValue.nextLine();
                System.out.println();

                listaTareas.add(new Chaval(bueno, pesoRegalos));
            }
            System.out.println();
            if (entrada != 0) {tareas.add(listaTareas);}
        }
    }

    private static void mostrarTareasOrdenadas(ArrayList<ArrayList<Chaval>> chavales) {
        for (ArrayList<Chaval> listaTareas : chavales) {
            Collections.sort(listaTareas);
            listaTareas.stream().forEach(t -> System.out.println(t));
            System.out.println("--------");
        }
    }
}