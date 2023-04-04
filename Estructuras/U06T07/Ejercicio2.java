// Acepta el Reto - La justicia de la lotería

// Será justa la lotería si en una comunidad la relación de billetes a beneficios es la misma para esa comunidad.

import java.util.ArrayList;

public class Ejercicio2 {

    private static ArrayList<ArrayList<Loteria>> loterias = new ArrayList<ArrayList<Loteria>>();
    public static void main(String[] args) {
        introducirValores();
        mostrarLoteriasOrdenadas(loterias);
    }

    private static void introducirValores() {
        loterias.add(new ArrayList<Loteria>());
        loterias.get(0).add(new Loteria(9, 4));
        loterias.get(0).add(new Loteria(10, 6));
        loterias.get(0).add(new Loteria(9, 5));
        loterias.get(0).add(new Loteria(1, 3));

        loterias.add(new ArrayList<Loteria>());
        loterias.get(1).add(new Loteria(10, 5));
        loterias.get(1).add(new Loteria(20, 5));
        loterias.get(1).add(new Loteria(30, 5));


    }

    private static void mostrarLoteriasOrdenadas(ArrayList<ArrayList<Loteria>> loterias) {
        for(int i = 0; i < loterias.size(); i++) {
            Boolean fair = true;
            for(int j = 0; j<loterias.get(i).size() - 1; j++) {
                if (loterias.get(i).get(j).compareTo(loterias.get(i).get(j+1)) != 0) {
                    fair = false;
                    break;
                }
            }
            if (fair) {
                System.out.println("Sí");
            } else {
                System.out.println("No");
            }
        }
    }
}