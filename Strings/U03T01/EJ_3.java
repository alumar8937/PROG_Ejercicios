// 24_10_2022 Pedro Marín Sanchis

// This program concatenates two strings.

import java.util.Scanner;

public class EJ_3 {

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

        // Concatenate and show results

        System.out.println("Your concatenated string is: " + string1.concat(string2));

        inputValue.close(); // Close Scanner
    }

}