//04_10_2022 Pedro Marín Sanchis

//This program asks for 10 int input and then shows them reversed.

import java.util.Scanner;

public class Java_Basico_EJ32 {

    public static void main(String[] args) {

        //Declare variables

        int number = 0;
        
        int[] Array;
        Array = new int[10];

        Scanner inputValue; // Prepare Scanner

        for (int i = 0; i < 10; i++) {

        //Ask for number [We assume inputs are valid.]

        System.out.print(i + " - Enter your number: ");

        inputValue = new Scanner(System.in);
        number = inputValue.nextInt();

        Array[9 - i] = number;

        }

        for (int i = 9; i > -1; i--) { //Print array

            System.out.println("Element on index " + i + ": " + Array[i]);

        }

    }

}