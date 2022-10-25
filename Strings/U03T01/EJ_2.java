// 24_10_2022 Pedro Marín Sanchis

// This program compares two strings and ignores casing.

import java.util.Scanner;

public class EJ_2 {

    public static void main(String[] args) {

        // Declare Variables

        String string1 = "";

        String string2 = "";

        Scanner inputValue; // Open Scanner
        inputValue = new Scanner(System.in);

        // Ask user for string input [We assume inputs are valid.]

        System.out.print("Enter your first string: ");
        string1 = inputValue.nextLine();

        System.out.print("Enter your second string: ");
        string2 = inputValue.nextLine();

        // Check if strings match and show results

        if (string1.compareToIgnoreCase(string2) == 0) {System.out.println("The argument strings are equal.");}
        else if (string1.compareToIgnoreCase(string2) > 0) {System.out.println("The first string is lexicographically bigger than the second.");}
        else if (string1.compareToIgnoreCase(string2) < 0) {System.out.println("The first string is lexicographically smaller than the second.");}

        inputValue.close(); // Close Scanner
    }

}