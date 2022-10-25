//03_10_2022 Pedro Marín Sanchis

import java.util.Scanner;

public class Java_Basico_EJ26 {

    public static void main(String[] args) {

        //Declare variables

        int number = 0;
       
        Scanner inputValue; // Prepare Scanner

        //Ask for number

        System.out.print("Enter your number: ");

        inputValue = new Scanner(System.in);
        number = inputValue.nextInt();

        System.out.println("Multipilcation table for the number " + number);

        for (int i = 10; i > -1; i--) { // Do multiplications

            System.out.printf("%d - %d\n", i, (number * i));

        }

        inputValue.close();

    }

}