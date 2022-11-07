// 02/11/2022 Pedro Marín Sanchis

// This program encrypts texts.

import java.util.Scanner;

public class Encriptar {

    static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    static char[] uppercaseAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    public static String encrypt(String text, int n) {

        String encryptedText = "";
        boolean validCharacterFlag = false;

        for (int i = 0; i < text.length(); i++) {

            validCharacterFlag = false;

            for (int j = 0; j < alphabet.length; j++) {

                // Check for lowercase.

                if (text.charAt(i) == alphabet[j]) {

                    if (j+n >= alphabet.length) { // This is to prevent an out of bounds index.

                        encryptedText = encryptedText + alphabet[j + n - alphabet.length];

                    } else {

                        encryptedText = encryptedText + alphabet[j + n];

                    }

                    validCharacterFlag = true;

                } else if (text.charAt(i) == uppercaseAlphabet[j]) { // Check for uppercase.

                    if (j+n >= uppercaseAlphabet.length) { // This is to prevent an out of bounds index.

                        encryptedText = encryptedText + uppercaseAlphabet[j + n - uppercaseAlphabet.length];

                    } else {

                        encryptedText = encryptedText + uppercaseAlphabet[j + n];

                    }

                    validCharacterFlag = true;

                }

            }

            if (!validCharacterFlag) { // Do not encrypt non contemplated characters.

                encryptedText = encryptedText + text.charAt(i);

            }

        }

        return encryptedText;

    }

    public static void main(String[] args) {

        Scanner inputValue = new Scanner(System.in); // Open Scanner.
        String unencryptedText = "";
        int phase;

        // Ask for user input [We assume inputs are valid].

        System.out.print("Enter your text: ");
        unencryptedText = inputValue.nextLine();

        System.out.print("Enter phase: ");
        phase = inputValue.nextInt();

        System.out.print("The encrypted text is: " + encrypt(unencryptedText, phase));

        inputValue.close();

    }
    
}
