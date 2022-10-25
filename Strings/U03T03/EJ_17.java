// 25_10_2022 Pedro Marín Sanchis

// This program returns the acronym of a user given text.

import java.util.Scanner;

public class EJ_17 {

    public static String acronym(String string) { // Returns an acronym of a string.
        
       String[] words = Utilities.divideStringIntoWords(string);

       String acronym = "";

       for (String i : words) {

            acronym = acronym + i.replaceAll("[a-z]", "");

       }

       return acronym;

    }


    public static void main(String[] args) {

        // Declare Variables

        String string = "";
        Scanner inputValue = new Scanner(System.in); // Open Scanner

        // Ask user for string input [We assume inputs are valid.]

        System.out.print("Enter your text: ");
        string = inputValue.nextLine();

        // Calculate and display results

        System.out.println("The acronym of the given text is: " + acronym(string));

        inputValue.close(); // Close Scanner

    }

}