// 25_10_2022 Pedro Marín Sanchis

// This program returns if there are short or long words in a text.

import java.util.Scanner;

public class EJ_12 {

    public static void checkLenghtMatchingWords(String[] words, Scanner inputValue) { // Finds and returns if there are short or long words in a text.
        
        int wordLength = 0;
        boolean shortFlag = false;
        boolean longFlag = false;
        
        System.out.print("Enter the word length: "); // Ask for wordLenght [We assume inputs are valid.]
        wordLength = inputValue.nextInt();

        for (String i : words){

            if (i.length() < wordLength) {shortFlag = true;}
            if (i.length() > wordLength) {longFlag = true;}

        }

        if (shortFlag) {System.out.println("There is at least a short word within the text.");}
        if (longFlag) {System.out.println("There is at least a long word within the text.");}

    }
    

    public static void main(String[] args) {

        // Declare Variables

        String string = "";
        Scanner inputValue = new Scanner(System.in); // Open Scanner

        // Ask user for string input [We assume inputs are valid.]

        System.out.print("Enter your text: ");
        string = inputValue.nextLine();

        // Calculate and display results

        checkLenghtMatchingWords(Utilities.divideStringIntoWords(string), inputValue);

        inputValue.close(); // Close Scanner

    }

}