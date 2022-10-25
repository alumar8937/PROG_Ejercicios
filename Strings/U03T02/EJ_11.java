// 25_10_2022 Pedro Marín Sanchis

// This program returns if there is at least a word with mathching lenth within a text.

import java.util.Scanner;

public class EJ_11 {

    public static boolean findLenghtMatchingWords(String[] words, Scanner inputValue) { // Finds and returns if there is at least a word with mathching lenth within a text.
        
        int wordLength = 0;
        boolean flag = false;
        
        System.out.print("Enter the word length: "); // Ask for wordLenght [We assume inputs are valid.]
        wordLength = inputValue.nextInt();

        for (String i : words){

            if (i.length() == wordLength) {flag = true;}

        }

        return flag;

    }
    

    public static void main(String[] args) {

        // Declare Variables

        String string = "";
        Scanner inputValue = new Scanner(System.in); // Open Scanner

        // Ask user for string input [We assume inputs are valid.]

        System.out.print("Enter your text: ");
        string = inputValue.nextLine();

        // Calculate and display results

        if (findLenghtMatchingWords(Utilities.divideStringIntoWords(string), inputValue)) {

            System.out.println("There is at least a word that matches.");

        } else {

            System.out.println("There are no matching words.");

        }

        inputValue.close(); // Close Scanner

    }

}