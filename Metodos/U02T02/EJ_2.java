// 17/11/2022 Pedro Marín Sanchis

// This program takes three user inputted lengths and shows if they can be arranged into a triangle.

import java.util.Scanner;

public class EJ_2 {

    public static boolean EsTriangulo(double number1, double number2, double number3) {

        if (number1 > number2 + number3 || number2 > number3 + number1 || number3 > number1 + number2 ) {return false;} else {return true;}

    }

    public static void main(String[] args) {

        // Declare variables

        double number1 = 0;
        double number2 = 0;
        double number3 = 0;

        Scanner inputValue; // Open Scanner
        inputValue = new Scanner(System.in);

        // Ask for user input of number 1 and 2 [We assume inputs are valid]

        System.out.println("Enter length number one: ");
        number1 = inputValue.nextInt();
        
        System.out.println("Enter length number two: ");
        number2 = inputValue.nextInt();

        System.out.println("Enter length number three: ");
        number3 = inputValue.nextInt();

        // Display results

        if (EsTriangulo(number1, number2, number3) == true) {

            System.out.println("The lengths can form a triangle!");

        } else {

            System.out.println("The lengths can't form a triangle!");

        }

        inputValue.close();

    }

}