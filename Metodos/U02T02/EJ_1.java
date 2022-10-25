// 17/11/2022 Pedro Marín Sanchis

// This program shows if two numbers are divisible (If number 1 is divisible by number 2)

import java.util.Scanner;

public class EJ_1 {

    public static boolean Divisible(int number1, int number2) {

        if (number1 % number2 == 0) {return true;} else {return false;}

    }

    public static void main(String[] args) {

        // Declare variables

        int number1 = 0;
        int number2 = 0;

        Scanner inputValue; // Open Scanner
        inputValue = new Scanner(System.in);

        // Ask for user input of number 1 and 2 [We assume inputs are valid]

        System.out.println("Enter number one: ");
        number1 = inputValue.nextInt();
        
        System.out.println("Enter number two: ");
        number2 = inputValue.nextInt();

        // Display results

        if (Divisible(number1, number2) == true) {

            System.out.println(number1 + " is divisible by " + number2 + "!");

        } else {

            System.out.println(number1 + " is not divisible by " + number2 + "!");

        }

        inputValue.close();

    }

}