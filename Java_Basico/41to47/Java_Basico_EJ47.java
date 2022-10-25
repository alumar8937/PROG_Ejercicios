//11_10_2022 Pedro Marín Sanchis

//This program puts a marquee over user inputted words!

import java.util.Scanner;

public class Java_Basico_EJ47 {

    public static void main(String[] args) {

        //Declare variables
        String biggestLine = "";

        Scanner inputValue; // Prepare Scanner

        //Ask for array length [We assume inputs are valid.]

        System.out.print("Enter the ammount of lines you want: ");

        inputValue = new Scanner(System.in);
        String [] array = new String[inputValue.nextInt()]; // Size array to user input.

        //Fill array

        for (int i = 0; i < array.length; i++) {
        
            //Ask for string chains [We assume inputs are valid.]

            System.out.print("Enter line " + (i + 1) + ": ");
            inputValue = new Scanner(System.in);
            array[i] = inputValue.nextLine();
        }

        // Find biggest word

        biggestLine = array[0];

        for (int i = 1; i < array.length; i++) {

            if (array[i - 1].length() < array[i].length()){biggestLine = array[i];}

        }

        System.out.println("Biggest line is: " + biggestLine);

        //Format spaces
        for (int i = 0; i < array.length; i++){

            while (array[i].length() != biggestLine.length()){

                array[i] = array[i] + " ";

            }

            System.out.println(array[i]);

        }

        //Print asterisks for marquee

        for (int i = 0; i < biggestLine.length() + 4; i++) { // First Line

            System.out.print("*");

        }

        System.out.print("\n");

        for (String i: array) { // Print Array

            System.out.println("* " + i + " *");

        }

        for (int i = 0; i < biggestLine.length() + 4; i++) { // Last Line

            System.out.print("*");

        }

        inputValue.close();

    }

}