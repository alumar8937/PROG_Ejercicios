// Acepta el Reto - La justicia de la lotería

// Será justa la lotería si en una comunidad la relación de billetes a beneficios es la misma para esa comunidad.

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio2 {

    private static ArrayList<ArrayList<Loteria>> loterias = new ArrayList<ArrayList<Loteria>>();
    public static void main(String[] args) {
        Scanner inputValue = new Scanner(System.in);
        introducirValores(inputValue);
        mostrarTareasOrdenadas(loterias);
    }

    private static void introducirValores(Scanner inputValue) {
        int entrada = 1;
        while (entrada != 0) {
            System.out.print("Introduce el número de loterias que queres añadir a la comunidad: "); // Asumimos que nadie tendrá la paciencia de introducir más de 100.000 valores.
            entrada = inputValue.nextInt();
            inputValue.nextLine();
            ArrayList<Loteria> listaTareas = new ArrayList<Loteria>();
            for (int i = 0; i < entrada; i++) {
                System.out.print("Billetes: ");
                int numBilletes = inputValue.nextInt();
                inputValue.nextLine();

                System.out.print("Beneficios: ");
                int beneficios = inputValue.nextInt();
                inputValue.nextLine();
                System.out.println();

                listaTareas.add(new Loteria(numBilletes, beneficios));
            }
            System.out.println();
            if (entrada != 0) {loterias.add(listaTareas);}
        }
    }

    private static void mostrarTareasOrdenadas(ArrayList<ArrayList<Loteria>> loterias) {
        for(int i = 0; i < loterias.size(); i++) {
            Boolean fair = true;
            for(int j = 0; j<loterias.get(i).size() - 1; j++) {
                if (loterias.get(i).get(j).compareTo(loterias.get(i).get(j+1)) != 0) {
                    fair = false;
                    break;
                }
            }
            System.out.println(fair);
        }
    }
}