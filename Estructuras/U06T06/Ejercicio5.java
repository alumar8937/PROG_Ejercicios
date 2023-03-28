import java.util.Scanner;
import java.util.ArrayList;

public class Ejercicio5 {

    private static Scanner inputValue = new Scanner(System.in);
    private static ArrayList<Integer> inputStrings = new ArrayList<Integer>();
    public static void main(String[] args) {
        while (true) {
            System.out.print("Enter the next integer: ");
            int input = inputValue.nextInt();
            inputValue.nextLine();
            if (input < 0) {break;}
            inputStrings.add(input);
        }
        inputStrings.stream()
                    .filter(i -> i>=1 && i<= 5)
                    .forEach( i -> System.out.println(i));
        
    }
}
