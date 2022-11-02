// 02/11/2022 Pedro Marín Sanchis

// This program encrypts texts.

import java.util.Scanner;

public class Encriptar {

    static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static String encrypt(String text) {

        String encryptedText = "";

        for (int i = 0; i < text.length(); i++) {

            for (int j = 0; j <= alphabet.length; j++) {

                if (text.charAt(i) == alphabet[j]) {

                    encryptedText = encryptedText + alphabet[j+1]; // Cuidado con el out of bounds!

                }

            }


        }

        return "a";

    }

    public static void main(String[] args) {

        Scanner inputValue = new Scanner(System.in); // Open Scanner.
        String unencryptedText = "";

        // Ask for both numbers [We assume inputs are valid].

        System.out.println("Enter your text: ");
        unencryptedText = inputValue.nextLine();

        System.out.println("The encrypted text is: " + encrypt(unencryptedText));

        inputValue.close();

    }
    
}
