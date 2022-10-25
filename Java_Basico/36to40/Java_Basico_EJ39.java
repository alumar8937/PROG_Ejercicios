//05_10_2022 Pedro Marín Sanchis

//This program shows all divisors of a user inputted number.

import java.util.Scanner;

public class Java_Basico_EJ39 {

    public static void main(String[] args) {

        //Declare variables

        float number = 0;
        Scanner inputValue; // Prepare Scanner
        String divisors = "The divisors are: ";
        
        //Ask for number [We assume inputs are valid.]

        System.out.print("Enter your number: ");

        inputValue = new Scanner(System.in);
        number = inputValue.nextFloat();

        //Calculate

        for (int i = 0; i < number + 1; i++) {

            if (number % i == 0) {divisors = divisors + i + ", ";}

        }

        divisors = divisors.substring(0, divisors.length() - 2) + ".";

        //Display results

        System.out.println(divisors);
        inputValue.close();

    }

}