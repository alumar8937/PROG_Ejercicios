import java.util.ArrayList;

public class Ejercicio4 {
    public static void main(String[] args) {
        ArrayList<Double> dobles = new ArrayList<>();
        dobles.add(12.3123123);
        dobles.add(12312312.3);
        dobles.add(123123.123);
        dobles.add(1231.23123);

        if (existe(dobles, 1231.23123)) {
            System.out.println("Se ha encontrado " + 1231.23123 + "en la lista!");
        } else {
            System.out.println("No se ha encontrado " + 1231.23123 + "en la lista ):");
        }

    }

    private static boolean existe(ArrayList<Double> dobles, double doble) {
        return dobles.contains(doble);
    }

}
