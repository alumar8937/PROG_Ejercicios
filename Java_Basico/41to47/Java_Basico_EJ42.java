//10_10_2022 Pedro Marín Sanchis

//This program calculates the product of two numbers using successive sums.

import java.util.Scanner;

public class Java_Basico_EJ42 {

    public static void main(String[] args) {

        //Declare variables

        int n1 = 0;
        int n2 = 0;
        int mult = 0;
        
        Scanner inputValue; // Prepare Scanner

        //Ask for number [We assume inputs are valid.]

        System.out.print("Enter your first number: ");

        inputValue = new Scanner(System.in);
        n1 = inputValue.nextInt();

        System.out.print("Enter your second number: ");
        n2 = inputValue.nextInt();

        //Calculate

        for (int i = 0; i < n2; i++) {

            mult = mult + n1;

        }

        System.out.println(n1 + " times " + n2 + " is: " + mult + "!");
        inputValue.close();

    }

}