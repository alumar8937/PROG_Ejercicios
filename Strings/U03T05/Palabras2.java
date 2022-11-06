// 06/11/2022 Pedro Marín Sanchis

// This program counts words in a given text without using string methods.

import java.util.Scanner;

public class Palabras2 {

    public static int stringLength(String string) {

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

        String replacedString = string;

        for (char i: chars) { // Shit not working

            for (int j = 0; j < stringLength(replacedString); j++) {

                if (replacedString.charAt(j) == i) {

                    replacedString = replacedString + replace;

                } else {

                    replacedString = replacedString + string.charAt(j);

                }

            }

        }

        return replacedString;

    }


    /*public static String[] createWordArray(String string) {

        string = trimString(string,  ' ');
        string = replaceInString(string, ",.;:".toCharArray(), ' ');
        string = replaceAdditionalInString(string, " ");

        return splitString(string, " ");

    }*/

    public static void main(String[] args) {

        // Declare variables

        String userText = "";
        Scanner inputValue = new Scanner(System.in);

        // Ask for user input

        System.out.print("Enter your text: ");
        userText = inputValue.nextLine();

        // Calculate and display results

        System.out.println(replaceInString(userText, ",.;:".toCharArray(), ' '));

        inputValue.close(); // Close Scanner
        
    }
    
}
