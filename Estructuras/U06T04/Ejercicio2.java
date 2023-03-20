import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;

public class Ejercicio2 {
    public static void main(String[] args) {
        HashSet<Integer> enteros = new HashSet<>(){{
            add(1);
            add(2);
            add(3);
        }};

        enteros = incrementarEnteros(enteros);
        System.out.println(enteros);

    }

    private static HashSet<Integer> incrementarEnteros(HashSet<Integer> enteros) {
        Iterator<Integer> iteradorEnteros = enteros.iterator();
        HashSet<Integer> enterosIncrementados = new HashSet<>();
        while (iteradorEnteros.hasNext()) {
            Integer valorActual = iteradorEnteros.next();
            enterosIncrementados.add(valorActual+1);
        }
        return enterosIncrementados;
    }
}
