// 24_10_2022 Pedro Marín Sanchis

// This program returns the index of the last occurence of a string within another string.

import java.util.Scanner;

public class EJ_9 {


    public static void printSubstringOf(String string, Scanner inputValue) {

        int index1;
        int index2;
        
        while (true) { // Check if index 1 is smaller than index 2

            System.out.print("Enter your first index: ");
            index1 = inputValue.nextInt();
            System.out.print("Enter your second index: ");
            index2 = inputValue.nextInt();
    
            if (index1 < index2 && index1 >= 0 && index2 <= (string.length())) {break;} else {System.out.println("Wrong input, try again!");}

        }

        System.out.println("From index " + index1 + " to index " + index2 + " the resulting string is: " + string.substring(index1, index2));

    }
    

    public static void main(String[] args) {

        // Declare Variables

        String string = "";
        Scanner inputValue = new Scanner(System.in); // Open Scanner

        // Ask user for string input [We assume inputs are valid.]

        System.out.print("Enter your first string: ");
        string = inputValue.nextLine();

        // Calculate and display results

        printSubstringOf(string, inputValue);

        inputValue.close(); // Close Scanner

    }

}