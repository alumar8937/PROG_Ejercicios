// 25_10_2022 Pedro Marín Sanchis

// This program checks if a given text uses parenthesis correctly.

import java.util.Scanner;

public class EJ_15 {

    public static boolean checkParenthesisFormatting(String string) { // Checks for correct parenthesis formatting.
        
        int openingCount = 0;
        int closingCount = 0;

        for (int i = 0; i <= string.length()-1; i++) {

            switch (string.charAt(i)) {

                case '(':
                    openingCount++;
                break;

                case ')':
                    closingCount++;
                break;

            }

        }

        if (openingCount == closingCount) {return true;} else {return false;}

    }


    public static void main(String[] args) {

        // Declare Variables

        String string = "";
        Scanner inputValue = new Scanner(System.in); // Open Scanner

        // Ask user for string input [We assume inputs are valid.]

        System.out.print("Enter your text: ");
        string = inputValue.nextLine();

        // Calculate and display results

        if (checkParenthesisFormatting(string)) {

            System.out.println("The text is correctly formatted.");

        } else {

            System.out.println("The text isn't correctly formatted.");

        }

        inputValue.close(); // Close Scanner

    }

}