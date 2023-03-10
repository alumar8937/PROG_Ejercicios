import java.util.HashMap;
import java.util.Scanner;

public class Ejercicio3 {

    private static Scanner inputValue = new Scanner(System.in);
    public static void main(String[] args) {

        HashMap<String, String[]> telefonos = new HashMap<>();

        telefonos.put("Maria Lopez", new String[] {"123-456-7890", "555-1212"});
        telefonos.put("Juan Garcia", new String[] {"555-555-1212", "867-5309", "555-1234"});
        telefonos.put("Sofia Fernandez", new String[] {"867-5309", "58-123-6553-223"});
        telefonos.put("Antonio Perez", new String[] {"555-1234", "123-3433-2326"});
        telefonos.put("Isabella Torres", new String[] {"555-4321", "555-5678"});

        while (true) {
            System.out.print("\nIntroduce el nombre: ");
            String nombre = inputValue.nextLine();
            System.out.println("\nLos teléfonos son: ");
            for (String telefono : telefonos.get(nombre)) {
                System.out.println(telefono);
            }
        }
    }
}