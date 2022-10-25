// 25_10_2022 Pedro Marín Sanchis

// This program returns an inverted text by words.

import java.util.Scanner;

public class EJ_16 {

    public static String invertText(String string) { // Returns an inverted string (by words).
        
       String[] words = Utilities.divideStringIntoWords(string);

       String invertedString = "";

       for (String i : words) {

            invertedString = i + " " + invertedString;

       }

       return invertedString;

    }


    public static void main(String[] args) {

        // Declare Variables

        String string = "";
        Scanner inputValue = new Scanner(System.in); // Open Scanner

        // Ask user for string input [We assume inputs are valid.]

        System.out.print("Enter your text: ");
        string = inputValue.nextLine();

        // Calculate and display results

        System.out.println("The inverted text is: " + invertText(string));

        inputValue.close(); // Close Scanner

    }

}