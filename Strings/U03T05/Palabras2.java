// 06/11/2022 Pedro Marín Sanchis

// This program counts words in a given text without using the official Java string methods.

import java.util.Scanner;

public class Palabras2 {

    public static int stringLength(String string) { // Iterates and keeps count of how many characters there are in a String until out of bounds exception is thrown, at which point the method has found the total length.

        int len = 0;

        while (true) {

            try {

                string.charAt(len);
                len++;

            } catch (Exception e) {

                return len;

            }
        
        }

    }

    
    public static String trimString(String string, char trim) {

        int startCount = 0; // Ammount of characters to be trimmed at the start of the string.
        int endCount = 0; // Ammount of characters to be trimmed at the end of the string.
        String trimmedString = "";

        if (string.charAt(0) == trim) { // Count charaters to be trimmed at the start.

            startCount++;

            for (int i = 0; i < stringLength(string) && string.charAt(i) == string.charAt(i+1); i++) {

                startCount++;

            }

        }

        if (string.charAt(stringLength(string) - 1) == trim) { // Count charaters to be trimmed at the end.

            endCount++;

            for (int i = stringLength(string) - 1; i > 0 && string.charAt(i) == string.charAt(i-1); i--) {

                endCount++;

            }

        }

        if (startCount + endCount == 0) {return string;} else { // Create final trimmed string.

            for (int i = 0; i < stringLength(string) - (startCount + endCount); i++) {

                trimmedString = trimmedString + string.charAt(startCount + i);

            }

        }

        return trimmedString;

    }


    public static String replaceInString(String string, char[] chars, char replace) {

        String replacedString = "";

        for (char i: chars) {

            for (int j = 0; j < stringLength(string); j++) {

                if (string.charAt(j) == i) { // Replace character.

                    replacedString = replacedString + replace;

                } else { // Keep writing without replacing character.

                    replacedString = replacedString + string.charAt(j);

                }

            }

            string = replacedString;
            replacedString = "";

        }

        return string;

    }


    public static String removeAdditionalInString(String string, char[] replace) {

        String replacedString = "";
        boolean firstCharacter = true;

        for (char i: replace) {

            for (int j = 0; j < stringLength(string); j++) {

                if (string.charAt(j) == i) { // Replace character.

                    if (firstCharacter) { // Do not replace character if it's the first instance in the current sequence.

                        replacedString = replacedString + i;
                        firstCharacter = false;

                    }

                } else { // Keep writing without replacing character.

                    replacedString = replacedString + string.charAt(j);
                    firstCharacter = true;

                }

            }

            firstCharacter = true;
            string = replacedString;
            replacedString = "";

        }

        return string;

    }


    public static String[] splitString(String string, char split) {

        int words = 0; // Ammount of words. [I know this is redundant for this specific program].
        String word = ""; // Stores each word until the split character is found. When that occurs word is stored into it's appropiate array index.
        int position = 0; // Keeps track of overall position within the string.

        if (stringLength(string) != 0) {
            
            words++;
        
            for (int i = 0; i < stringLength(string); i++) { // Count words to create array.

                if (string.charAt(i) == split) {
    
                    words++;
    
                }
    
            }

        } else {

            String[] wordArray = new String[words];
            return wordArray;

        }

        String[] wordArray = new String[words]; // Create string array

        for (int i = 0; i != words; i++) {

            if (string.charAt(position) == split) {position++;} // Advance one position and do not write word. This is to keep the following code from writing a space into the array.

            while ( position < stringLength(string) && string.charAt(position) != split) {

                word = word + string.charAt(position);
                position++;

            }

            wordArray[i] = word;
            word = "";

        }

        return wordArray;

    }


    public static String[] createWordArray(String string) {

        string = replaceInString(string, ",.;:".toCharArray(), ' '); // Same functionality as String method "replace" but you can pass the method a char array.
        string = trimString(string,  ' '); // Same functionality as String method trim, except you can choose what character to trim.
        string = removeAdditionalInString(string, " ".toCharArray()); // Removes repeated characters, you have to pass the method a char array.

        return splitString(string, ' '); // Same functionality as String method "split".

    }

    public static void main(String[] args) {

        // Declare variables

        String userText = "";
        Scanner inputValue = new Scanner(System.in);

        // Ask for user input [We assume inputs are valid]

        System.out.print("Enter your text: ");
        userText = inputValue.nextLine();

        // Calculate and display results

        System.out.println("The ammount of words within your text is: " + createWordArray(userText).length);

        inputValue.close(); // Close Scanner
        
    }
    
}
