import java.util.HashSet;

public class Ejercicio3 {
    public static void main(String[] args) {
        String[] strings = new String[]{"Hola", "Mundo", "Mundo"};
        strings = eliminarDuplicados(strings);
        for (String string: strings) {
            System.out.println(string);
        }
    }

    private static String[] eliminarDuplicados(String[] stringArray) {
        HashSet<String> stringSet = new HashSet<String>();
        for (String string: stringArray) { // Populamos el HashSet.
            stringSet.add(string);
        }
        String[] returnArray = new String[stringSet.size()];
        int contador = 0;
        for (String string: stringSet) { // Populamos el Array de Strings.
            returnArray[contador] = string;
            contador++;
        }
        return returnArray;
    }
}
