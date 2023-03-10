import java.util.HashMap;
import java.util.Scanner;

public class Ejercicio1 {

    private static Scanner inputValue = new Scanner(System.in);
    public static void main(String[] args) {
        HashMap<String, String> capitals = new HashMap<>();

        capitals.put("Germany", "Berlin");
        capitals.put("France", "Paris");
        capitals.put("Spain", "Madrid");
        capitals.put("Italy", "Rome");
        capitals.put("United Kingdom", "London");
        capitals.put("Netherlands", "Amsterdam");
        capitals.put("Belgium", "Brussels");
        capitals.put("Austria", "Vienna");
        capitals.put("Switzerland", "Bern");
        capitals.put("Sweden", "Stockholm");

        while (true) {
            System.out.print("Enter the country name: ");
            System.out.println("The capital is: " + capitals.get(inputValue.nextLine()));
        }
    }
}