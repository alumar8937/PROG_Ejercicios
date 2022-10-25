//03_10_2022 Pedro Marín Sanchis

import java.util.Scanner;

public class Java_Basico_EJ28 {

    public static void main(String[] args) {

        //Declare variables

        int number = 0;
        boolean isPrime = true;
       
        Scanner inputValue; // Prepare Scanner

        //Ask for number

        System.out.print("Enter your number: ");

        inputValue = new Scanner(System.in);
        number = inputValue.nextInt();

        if (number == 1) { // Prime numbers have to be > 1

            isPrime = false;

        } else {

            for (int i = number - 1; i > 1; i--) { // Go trough divisions

                    if (number % i == 0) {isPrime = false;}

            }

        }

        // Display results

        if (isPrime == true) {
            
            System.out.println("Your number is a prime number!");
            
        } else {

            System.out.println("Your number is not a prime number!");

        }

        inputValue.close();

    }

}