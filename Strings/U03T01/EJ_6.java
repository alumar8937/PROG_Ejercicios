// 24_10_2022 Pedro Marín Sanchis

// This program replaces all ocurrences of a character in a string with another one.

import java.util.Scanner;

public class EJ_6 {

    public static void main(String[] args) {

        // Declare Variables

        String string1 = "";

        char character = ' ';
        char oldCharacter = ' ';

        Scanner inputValue; // Open Scanner
        inputValue = new Scanner(System.in);

        // Ask user for input [We assume inputs are valid.]

        System.out.print("Enter your string : ");
        string1 = inputValue.nextLine();

        System.out.print("Enter the character your want to replace: ");
        oldCharacter = inputValue.nextLine().charAt(0);

        System.out.print("Enter the character your want to replace it with: ");
        character = inputValue.nextLine().charAt(0);

        // Calculate

        System.out.println("The resulting string is: " + string1.replace(oldCharacter, character));

        inputValue.close(); // Close Scanner
    }

}