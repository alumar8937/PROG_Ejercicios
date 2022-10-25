// 18/11/2022 Pedro Marín Sanchis

// This program calculates the power of a user inputted number.

import java.util.Scanner;

public class EJ_3 {

    public static double Exponent(double number, double exponent) {
        
        if (exponent != 0) {
    
            return number * Exponent(number, exponent - 1);
        
        } else {

            return 1;

        }

    }

    public static void main(String[] args) {

        // Declare variables

        double number = 0;
        double exponent = 0;

        Scanner inputValue; // Open Scanner
        inputValue = new Scanner(System.in);

        // Ask for user input of number and exponent [We assume inputs are valid]

        System.out.println("Enter your number: ");
        number = inputValue.nextDouble();
        
        System.out.println("Enter the exponent: ");
        exponent = inputValue.nextDouble();

        // Display results

        System.out.println(number + " to the power of " + exponent + " is: " + Exponent(number, exponent) + "!");

        inputValue.close();

    }

}