// 19/11/2022 Pedro Marín Sanchis

// This program checks if a number is a prime number!

import java.util.Scanner;

public class EJ_6 {

    public static boolean IsPrime(int number) {

        if (number == 1) {return false;}

        for (int i = 2; i < number; i++){

            if (number % i == 0) {return false;}

        }

        return true;

    }
    public static void main(String[] args) {

        // Declare variables

        int number = 0;

        Scanner inputValue; // Open Scanner
        inputValue = new Scanner(System.in);

        // Ask for user input of number [We assume inputs are valid]

        System.out.println("Enter your number: ");
        number = inputValue.nextInt();

        // Display results

        if (IsPrime(number) == true) {
            
            System.out.println("Your number is a prime number!");
    
        } else {

            System.out.println("Your number is not a prime number");
        }

        inputValue.close();

    }

}