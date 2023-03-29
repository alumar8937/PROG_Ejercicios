import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// Acepta el Reto - Felipe y sus Tareas
// https://www.aceptaelreto.com/problem/statement.php?id=579

public class Ejercicio1 {

    private static ArrayList<ArrayList<Tarea>> tareas = new ArrayList<ArrayList<Tarea>>();
    public static void main(String[] args) {
        Scanner inputValue = new Scanner(System.in);
        introducirValores(inputValue);
        mostrarTareasOrdenadas(tareas);
    }

    private static void introducirValores(Scanner inputValue) {
        int entrada = 1;
        while (entrada != 0) {
            System.out.print("Introduce el número de tareas que queres añadir: ");
            entrada = inputValue.nextInt();
            inputValue.nextLine();
            ArrayList<Tarea> listaTareas = new ArrayList<Tarea>();
            for (int i = 0; i < entrada; i++) {
                System.out.print("Prioridad: ");
                int prioridad = inputValue.nextInt();
                inputValue.nextLine();

                System.out.print("Duración: ");
                int duracion = inputValue.nextInt();
                inputValue.nextLine();
                System.out.println();

                listaTareas.add(new Tarea(prioridad, duracion));
            }
            System.out.println();
            if (entrada != 0) {tareas.add(listaTareas);}
        }
    }

    private static void mostrarTareasOrdenadas(ArrayList<ArrayList<Tarea>> tareas) {
        for (ArrayList<Tarea> listaTareas : tareas) {
            Collections.sort(listaTareas);
            listaTareas.stream().forEach(t -> System.out.println(t));
            System.out.println("--------");
        }
    }
}