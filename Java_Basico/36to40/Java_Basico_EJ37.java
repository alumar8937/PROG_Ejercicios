//05_10_2022 Pedro Marín Sanchis

//This program asks for 10 numbers and ouputs the biggest one and the smallest one.

import java.util.Scanner;

public class Java_Basico_EJ37 {

    public static void main(String[] args) {

        //Declare variables (Array is declared later as user input.)

        float biggestNumber = 0;
        float smallestNumber = 0;
        Scanner inputValue; // Prepare Scanner

        // Array that stores the numbers
        
        float[] numberArray;
        numberArray = new float[10];

        //Ask for user to load array [We assume inputs are valid]
        
        for (int i = 0; i <= 9 ; i++) {

            //Ask for number
            System.out.print("Enter number " + (i + 1) + ": ");

            inputValue = new Scanner(System.in);
            numberArray[i] = inputValue.nextFloat();

        }

        //Calculate biggest number

        biggestNumber = numberArray[0];

        for (int i = 1; i <= 9 ; i++) {

            if (numberArray[i] > biggestNumber) {biggestNumber = numberArray[i];}

        }

        smallestNumber = numberArray[0];

        for (int i = 1; i <= 9 ; i++) {

            if (numberArray[i] < smallestNumber) {smallestNumber = numberArray[i];}

        }

        System.out.println("The biggest number is: "+ biggestNumber + "!");
        System.out.println("The smallest number is: "+ smallestNumber + "!");

    }

}