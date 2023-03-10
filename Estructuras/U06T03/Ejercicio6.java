import java.util.HashMap;
import java.util.Scanner;

public class Ejercicio6 {

    private static Scanner inputValue = new Scanner(System.in);
    private static HashMap<String, Integer> palabras = new HashMap<>();
    public static void main(String[] args) {

        while (true) {
            System.out.print("| 1.- Añadir Palabras | 2.- Consultar Frecuencia |\nEscoge una opción: ");
            switch (inputValue.nextLine()) {
                case "1":
                    anyadirPalabras();
                break;
                case "2":
                    consultarPalabras();
                    break;
                default:
                    System.out.println("\nOpción Incorrecta\n");
                break;
            }
        }
    }

    private static void anyadirPalabras() {
        while (true) { // Añadir números
            System.out.print("Introduce las palabras separadas por espacios [-1 para salir]: ");
            String input = inputValue.nextLine();
            if (input.equalsIgnoreCase("-1")) {
                break;
            }

            for (String palabra: input.split(" ")) {
                Integer recuento = palabras.get(palabra);

                if (recuento != null) {
                    palabras.put(palabra, recuento+1);
                } else {
                    palabras.put(palabra, 1);
                }
            }
        }
    }

    private static void consultarPalabras() {
        System.out.println(palabras.toString());
    }

}