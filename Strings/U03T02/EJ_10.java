// 25_10_2022 Pedro Marín Sanchis

// This program returns the number of length matching words in a text.

import java.util.Scanner;

public class EJ_10 {

    public static int findLenghtMatchingWords(String[] words, Scanner inputValue) { // Finds and returns the number of length matching words in a given String array.
        
        int wordLength = 0;
        int count = 0; // Ammount of length matching words.
        
        System.out.print("Enter the word length: "); // Ask for wordLenght [We assume inputs are valid.]
        wordLength = inputValue.nextInt();

        for (String i : words){

            if (i.length() == wordLength) {count++;}

        }

        return count;

    }
    

    public static void main(String[] args) {

        // Declare Variables

        String string = "";
        Scanner inputValue = new Scanner(System.in); // Open Scanner

        // Ask user for string input [We assume inputs are valid.]

        System.out.print("Enter your text: ");
        string = inputValue.nextLine();

        // Calculate and display results

        System.out.println("The number of length matching words is: " + findLenghtMatchingWords(Utilities.divideStringIntoWords(string), inputValue));

        inputValue.close(); // Close Scanner

    }

}