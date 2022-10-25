//03_10_2022 Pedro Marín Sanchis

import java.util.Scanner;

public class Java_Basico_EJ25 {

    public static void main(String[] args) {

        //Declare variables

        int number = 0;
        int factorial = 1;
       
        Scanner inputValue; // Prepare Scanner

        //Ask for number

        System.out.print("Enter your number: ");

        inputValue = new Scanner(System.in);
        number = inputValue.nextInt();

        for (int i = number; i > 0; i--) { // Do factorial

            factorial = factorial * i;

        }

        System.out.println("The factorial of " + number + " is: " + factorial); // Display results
        inputValue.close();
        
    }

}