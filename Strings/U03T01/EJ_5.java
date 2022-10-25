// 24_10_2022 Pedro Marín Sanchis

// This program checks if a string ends with another one.

import java.util.Scanner;

public class EJ_5 {

    public static void main(String[] args) {

        // Declare Variables

        String string1 = "";

        String string2 = "";

        Scanner inputValue; // Open Scanner
        inputValue = new Scanner(System.in);

        // Ask user for string input [We assume inputs are valid.]

        System.out.print("Enter your first string (Ending): ");
        string1 = inputValue.nextLine();

        System.out.print("Enter your second string: ");
        string2 = inputValue.nextLine();

        // Check if string2 ends with string1

        if (string2.endsWith(string1)) {
            
            System.out.println("The second string ends with the first one!");
        
        } else {
            
            System.out.println("The second string doesn't end with the first one!");
        
        }

        inputValue.close(); // Close Scanner
    }

}