// 24_10_2022 Pedro Marín Sanchis

// This program checks if a string contains another one.

import java.util.Scanner;

public class EJ_4 {

    public static void main(String[] args) {

        // Declare Variables

        String string1 = "";

        String string2 = "";

        Scanner inputValue; // Open Scanner
        inputValue = new Scanner(System.in);

        // Ask user for string input [We assume inputs are valid.]

        System.out.print("Enter your first string: ");
        string1 = inputValue.nextLine();

        System.out.print("Enter your second string: ");
        string2 = inputValue.nextLine();

        // Check if string2 ends with string1

        if (string2.contains(string1)) {
            
            System.out.println("The second string contains the first one!");
        
        } else {
            
            System.out.println("The second string doesn't contain the first one!");
        
        }

        inputValue.close(); // Close Scanner
    }

}