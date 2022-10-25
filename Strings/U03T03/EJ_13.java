// 25_10_2022 Pedro Marín Sanchis

// This program returns the ammount of digits in a text.

import java.util.Scanner;

public class EJ_13 {

    public static int addUpDigits(String string) { // Returns the ammount of digits in a string.
        
        int count = 0;

        for (int i = 0; i <= string.length()-1; i++) {

            switch (string.charAt(i)) {

                case '0': case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9': 
                    count++;
                break;

            }

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

        System.out.println("The number of digits within the text is: " + addUpDigits(string));

        inputValue.close(); // Close Scanner

    }

}