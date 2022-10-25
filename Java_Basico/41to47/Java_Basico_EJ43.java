//10_10_2022 Pedro Marín Sanchis

//This program calculates the modulus of two numbers using successive subtraction.

import java.util.Scanner;

public class Java_Basico_EJ43 {

    public static void main(String[] args) {

        //Declare variables

        int dividend = 0;
        int divisor = 0;
        int modulus = 0;
        
        Scanner inputValue; // Prepare Scanner

        //Ask for number [We assume inputs are valid.]

        System.out.print("Enter your dividend: ");

        inputValue = new Scanner(System.in);
        dividend = inputValue.nextInt();

        System.out.print("Enter your divisor: ");
        divisor = inputValue.nextInt();

        //Calculate

        for (int i = dividend; i - divisor >= 0;) {
            i = i - divisor;
            modulus = i;
        }

        System.out.println(dividend + " over " + divisor + " has a modulus of: " + modulus + "!");

        inputValue.close();
    }

}