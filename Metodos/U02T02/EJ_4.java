//18_11_2022 Pedro Marín Sanchis

//This program calculates the ammount of positive numbers for a given Array of numbers.

import java.util.Scanner;

public class EJ_4 {

    public static int PositivosEnArray(float[] Array) {

        int count = 0;

        for (float i: Array) {

            if (i >= 0) {count++;}

        }

        return count;
    }

    public static void main(String[] args) {

        //Declare variables (Array is declared later as user input.)

        int i = 0; // Size of array

        Scanner inputValue; // Prepare Scanner

        //Ask for ammount of numbers to be entered

        System.out.print("Enter ammount of numbers you will input: ");

        inputValue = new Scanner(System.in);
        i = inputValue.nextInt();

        // Array that stores the numbers
        
        float[] Array;
        Array = new float[i];

        //Ask for user to load array
        
        for (int j = i; j > 0 ; j--) {

            //Ask for grade
            System.out.print("Enter number " + (i - j + 1) + ": ");
            Array[j-1] = inputValue.nextInt();

        }

        //Calculate ammount of positive numbers and display results

        System.out.println("There are " + PositivosEnArray(Array) + " positive numbers!");

        inputValue.close();

    }

}