import java.util.HashMap;
import java.util.Scanner;

public class Ejercicio4 {

    private static Scanner inputValue = new Scanner(System.in);
    private static HashMap<Integer, Integer> terminaciones = new HashMap<>();
    public static void main(String[] args) {
        
        terminaciones.put(8, 2);
        terminaciones.put(9, 1);
        terminaciones.put(5, 2);
        terminaciones.put(6, 3);
        terminaciones.put(2, 5);
        terminaciones.put(3, 6);
        terminaciones.put(7, 1);
        terminaciones.put(0, 2);
        terminaciones.put(1, 3);
        terminaciones.put(4, 3);

        while (true) {
            System.out.print("| 1.- Añadir Números | 2.- Consultar Números |\nEscoge una opción: ");
            switch (inputValue.nextLine()) {
                case "1":
                    anyadirNumeros();
                break;
                case "2":
                    consultarNumeros();
                    break;
                default:
                    System.out.println("\nOpción Incorrecta\n");
                break;
            }
        }
    }

    private static void anyadirNumeros() {
        while (true) { // Añadir números
            System.out.print("Introduce el numero a añadir [-1 para salir]: ");
            String input = inputValue.nextLine();
            if (input.equalsIgnoreCase("-1")) {
                break;
            }

            Integer terminacion = Integer.parseInt(input.charAt(input.length()-1)+"");
            Integer valorActual = terminaciones.get(terminacion);

            if (valorActual != null) {
                terminaciones.put(terminacion, valorActual+1);
            } else {
                terminaciones.put(terminacion, 1);
            }
        }
    }

    private static void consultarNumeros() {
        while (true) { // Consultar números
            System.out.print("Introduce el numero a consultar [-1 para salir]: ");
            String input = inputValue.nextLine();
            if (input.equalsIgnoreCase("-1")) {
                break;
            }
            System.out.println("El número de ocurrencias es: " + terminaciones.get(Integer.parseInt(input)));
        }
    }

}