//05_10_2022 Pedro Marín Sanchis

//This program calculates the median for a user defined ammount of grades and notifies the user is one of those grades was a 10.

import java.util.Scanner;

public class Java_Basico_EJ35 {

    public static void main(String[] args) {

        //Declare variables (Array is declared later as user input.)

        float median = 0;
        float sum = 0; // Sum of grades
        int i = 0; // Ammount of grades (for division)
        boolean wasTen = false; // Grade of 10 in median flag

        Scanner inputValue; // Prepare Scanner

        //Ask for number of grades to be entered

        System.out.print("Enter number of grades you will input: ");

        inputValue = new Scanner(System.in);
        i = inputValue.nextInt();

        // Array that stores grades
        
        float[] gradeArray;
        gradeArray = new float[i];

        //Ask for user to load array
        
        for (int j = i; j > 0 ; j--) {

            //Ask for grade
            System.out.print("Enter grade " + (i - j + 1) + ": ");

            inputValue = new Scanner(System.in);
            gradeArray[j-1] = inputValue.nextInt();

            if (gradeArray[j-1] == 10) {wasTen = true;}

        }

        //Calculate median

        for (int j = i; j > 0 ; j--) {

            sum = sum + gradeArray[j-1];

        }

        median = sum / i;

        System.out.printf("%nThe median is: %2.2f!%n", median);
        if (wasTen == true) {System.out.print("One of the grades was 10!\n");}
        inputValue.close();

    }

}