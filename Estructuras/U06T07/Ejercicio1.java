import java.util.ArrayList;
import java.util.Collections;

// Acepta el Reto - Felipe y sus Tareas
// https://www.aceptaelreto.com/problem/statement.php?id=579

public class Ejercicio1 {

    private static ArrayList<ArrayList<Tarea>> tareas = new ArrayList<ArrayList<Tarea>>();
    public static void main(String[] args) {
        introducirValores();
        mostrarTareasOrdenadas(tareas);
    }

    private static void introducirValores() {
        tareas.add(new ArrayList<Tarea>());
        tareas.get(0).add(new Tarea(1, 6));
        tareas.get(0).add(new Tarea(2, 4));
        tareas.get(0).add(new Tarea(3, 5));
        tareas.add(new ArrayList<Tarea>());
        tareas.get(1).add(new Tarea(30, 7));
        tareas.get(1).add(new Tarea(30, 2));
    }

    private static void mostrarTareasOrdenadas(ArrayList<ArrayList<Tarea>> tareas) {
        for (ArrayList<Tarea> listaTareas : tareas) {
            Collections.sort(listaTareas);
            listaTareas.stream().forEach(t -> System.out.println(t));
            System.out.println("--------");
        }
    }
}