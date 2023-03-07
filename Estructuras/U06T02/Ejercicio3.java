import java.util.ArrayList;
import java.util.Iterator;

public class Ejercicio3 {
    public static void main(String[] args) {
        ArrayList<Double> dobles = new ArrayList<>();
        dobles.add(12.3123123);
        dobles.add(12312312.3);
        dobles.add(123123.123);
        dobles.add(1231.23123);

        double[] doblesArray = new double[dobles.size()];
        Iterator<Double> iterador = dobles.iterator();
        int i = 0;
        while (iterador.hasNext()) {
            doblesArray[i] = iterador.next();
            i++;
        }

    }
}
