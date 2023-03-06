import java.util.ArrayList;

public class Ejercicio5 {
    public static void main(String[] args) {
        ArrayList<Double> dobles = new ArrayList<>();
        dobles.add(12.3123123);
        dobles.add(12312312.3);
        dobles.add(123123.123);
        dobles.add(1231.23123);
        ArrayList<Double> dobles2 = new ArrayList<>();
        dobles2.add(12.3123123);
        dobles2.add(12312312.3);
        dobles2.add(123123.123);
        dobles2.add(1231.23123);

        dobles.addAll(dobles2);

    }
}
