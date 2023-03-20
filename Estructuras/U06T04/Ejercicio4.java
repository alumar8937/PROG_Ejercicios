import java.util.HashSet;

public class Ejercicio4 {
    public static void main(String[] args) {
        String[] strings = new String[]{"Hola", "Mundo", "Mundo", "Repetido", "Repetido"};
        imprimirDuplicados(strings);
    }

    private static void imprimirDuplicados(String[] stringArray) {
        HashSet<String> stringSet = new HashSet<String>();
        for (String string: stringArray) { // Populamos el HashSet.
            if (stringSet.add(string) == false) {
                System.out.println(string);
            }
        }
    }
}
