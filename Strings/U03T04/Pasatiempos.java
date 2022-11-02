// 02/11/2022 Pedro Marín Sanchis

// This program makes you guess a texts that has had its vocals removed!

import java.util.Scanner;

public class Pasatiempos {

    static String[] divideStringIntoWords(String string) {

        string = string.trim(); // Remove spaces at the beginning and end

        string = string.replaceAll(" +", " "); // Remove additional spaces

        return string.split(" ");

    }

    static String suppressVocals(String string) {

        return string.replaceAll("[aiueo]", "."); // suppress vocals

    }

    public static void main(String[] args) {

        String[] originalText;
        String[] suppressedText;
        boolean guessedAllWords = false;
        String guess = "";

        Scanner inputValue = new Scanner(System.in); // Open Scanner

        System.out.print("Enter your original text: ");
        originalText = divideStringIntoWords(inputValue.nextLine());

        suppressedText = new String[originalText.length];

        for (int i = 0; i < originalText.length; i++) { // Create suppressedText array

            suppressedText[i] = suppressVocals(originalText[i]);

        }

        while (!guessedAllWords) { // Guessing loop.

            for (String i: suppressedText) { // Show suppressedText.

                System.out.print(i + " ");
    
            }

            System.out.print(" - Try to guess a word: ");
            guess = inputValue.nextLine();

            for (int i = 0; i < originalText.length; i++) { // Update words.

                if (guess.equals(originalText[i])) {suppressedText[i] = guess;}

            }

            for (int i = 0; i < originalText.length; i++) { // Check if all words have been guessed.

                guessedAllWords = true;

                if (originalText[i].equals(suppressedText[i]) == false) {

                    guessedAllWords = false; break;

                }

            }

        }

        System.out.println("You guessed all words!");

        inputValue.close(); // Close Scanner

    }

}
