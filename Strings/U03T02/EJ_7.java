// 24_10_2022 Pedro Marín Sanchis

// This program returns the index of a string within another string.

import java.util.Scanner;

public class EJ_7 {

    public static void main(String[] args) {

        // Declare Variables

        String string1 = "";

        String string2 = "";

        Scanner inputValue; // Open Scanner
        inputValue = new Scanner(System.in);

        // Ask user for string input [We assume inputs are valid.]

        System.out.print("Enter your first string: ");
        string1 = inputValue.nextLine();

        System.out.print("Enter your second string (The one you're looking for): ");
        string2 = inputValue.nextLine();

        // Calculate and display results

        System.out.println("The position of the second string within the first one is: " + string1.indexOf(string2));

        inputValue.close(); // Close Scanner
    }

}