import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ejercicio6 {

    public static void main(String[] args) {

        System.out.println(repartir(0, new ArrayList<>(List.of(2, 4)))); // 2, 4
        System.out.println(repartir(3, new ArrayList<>(List.of(2, 5, 1)))); // 2, 1, 5
        System.out.println(repartir(3, new ArrayList<>(List.of(2, 4, 7)))); // 4, 2, 7
       
    }

    public static String repartir(int aterriza, ArrayList<Integer> listaPortales) {
        String resultado = "El orden de visita es: ";
        int distancia = 0;
        int distancia_anterior = 0;

        if (listaPortales.size() == 0) {
            return resultado;
        }

        Collections.sort(listaPortales);
        distancia = Math.abs(listaPortales.get(0) - aterriza);
        
        while (!listaPortales.isEmpty()) {
            for (int i = 0; i < listaPortales.size(); i++) {
                distancia = Math.abs(listaPortales.get(i) - aterriza);
                if (distancia <= distancia_anterior) {
                    aterriza = listaPortales.get(i);
                    resultado += listaPortales.get(i) + ", ";
                    listaPortales.remove(i);
                }
                distancia_anterior = distancia;
            }
        }

        return resultado.substring(0, resultado.length()-2);
    }

}