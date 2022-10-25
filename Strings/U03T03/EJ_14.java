// 25_10_2022 Pedro Marín Sanchis

// This program returns the ammount of numbers in a text.

import java.util.Scanner;

public class EJ_14 {

    public static int addUpNumbers(String[] words) { // Returns the ammount of digits in a string.
        
        int count = 0;
        boolean flag = true; // Used to validate if a word is a number.

        for (String j : words) {

            flag = true;

            for (int i = 0; i <= j.length()-1; i++) {

                switch (j.charAt(i)) {

                    case '0': case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9': 
                    break;

                    default:
                        flag = false;
                    break;

                }

            }

            if (flag) {count++;}

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

        System.out.println("The number of numbers within the text is: " + addUpNumbers(Utilities.divideStringIntoWords(string)));

        inputValue.close(); // Close Scanner

    }

}