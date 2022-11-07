// 06/11/2022 Pedro Marín Sanchis

// This program counts words in a given text.

import java.util.Scanner;

public class Palabras1 {

    public static String[] createWordArray(String string) {

        string = string.replace(".", " ").replace(",", " ").replace(";", " ").replace(":", " "); //Replace . , ; : with spaces

        string = string.trim(); // Remove spaces at the beginning and end
        
        string = string.replaceAll(" +", " "); // Remove additional spaces

        return string.split(" ");

    }

    public static void main(String[] args) {

        // Declare variables

        String userText = "";
        Scanner inputValue = new Scanner(System.in);

        // Ask for user input

        System.out.print("Enter your text: ");
        userText = inputValue.nextLine();

        // Calculate and display results

        System.out.println("The ammount of words in this text is: " + createWordArray(userText).length);

        inputValue.close(); // Close Scanner
        
    }
    
}
