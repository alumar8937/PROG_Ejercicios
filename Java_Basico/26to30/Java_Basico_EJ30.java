/*
04_10_2022 Pedro Marín Sanchis

This program checks if the user input is a palindrome.
*/

import java.util.Scanner;

public class Java_Basico_EJ30 {

    public static void main(String[] args) {

        //Declare variables

        String input = "";
        boolean isPalindrome = true;
       
        Scanner inputValue; // Prepare Scanner

        //Ask for number [We assume inputs are valid.]

        System.out.print("Enter your number: ");

        inputValue = new Scanner(System.in);
        input = inputValue.nextLine();

        // Check trough indexes and compare
        
        for (int i = input.length(); i > 0; i--) {

                    // System.out.println("\nA " + (i - 1) + "\nB " + (input.length() - i)); // For debug purposes (Shows charAt indexes.)

                    if ( input.charAt(i - 1) != input.charAt(input.length() - i)) {isPalindrome = false;}

        }

        if (isPalindrome == true) {System.out.println("It's a palindrome!");} else {System.out.println("It's not a palindrome!");}
        inputValue.close();
    }

}