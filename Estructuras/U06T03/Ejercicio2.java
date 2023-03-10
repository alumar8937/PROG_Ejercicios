import java.util.HashMap;
import java.util.Scanner;

public class Ejercicio2 {

    private static Scanner inputValue = new Scanner(System.in);
    public static void main(String[] args) {

        HashMap<String, String> telefonos = new HashMap<>();

        telefonos.put("Maria Lopez", "123-456-7890");
        telefonos.put("Juan Garcia", "555-555-1212");
        telefonos.put("Sofia Fernandez", "867-5309");
        telefonos.put("Antonio Perez", "555-1234");
        telefonos.put("Isabella Torres", "555-4321");

        while (true) {
            System.out.print("Introduce el nombre: ");
            System.out.println("El teléfono es: " + telefonos.get(inputValue.nextLine()));
        }
    }
}