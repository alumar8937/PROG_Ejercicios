import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
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
        int currentPortal = 0;
        Iterator<Integer> iterador = listaPortales.iterator();

        if (listaPortales.size() == 0) {
            return resultado;
        }

        Collections.sort(listaPortales);
        distancia = Math.abs(listaPortales.get(0) - aterriza);
        
        while (!listaPortales.isEmpty()) {
            while (iterador.hasNext()) {
                currentPortal = iterador.next();
                distancia = Math.abs(currentPortal - aterriza);
                if (distancia <= distancia_anterior) {
                    aterriza = currentPortal;
                    resultado += currentPortal + ", ";
                    iterador.remove();
                }
                distancia_anterior = distancia;
            }
        }

        return resultado.substring(0, resultado.length()-2);
    }

}