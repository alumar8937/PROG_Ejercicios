import java.util.Scanner;
import java.util.ArrayList;

public class Ejercicio4 {

    private static Scanner inputValue = new Scanner(System.in);
    private static ArrayList<String> inputStrings = new ArrayList<String>();
    public static void main(String[] args) {
        while (true) {
            System.out.print("Enter the next string: ");
            String input = inputValue.nextLine();
            if (input.equals("")) {break;}
            inputStrings.add(input);
        }
        inputStrings.stream()
                    .forEach( i -> System.out.println(i));
        
    }
}
