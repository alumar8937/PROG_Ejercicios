//28_09_2022 Pedro Marín Sanchis

import java.util.Scanner;

public class Java_Basico_EJ23 {

    public static void main(String[] args) {

        //Declare variables

        int number = 0;
        int count = 0; //Sum of all positive numbers


        Scanner inputValue; // Prepare Scanner

        //Loop until exit condition (number == 0)

        do {
        
            //Ask for number

            System.out.print("Enter your number (0 to exit): ");

            inputValue = new Scanner(System.in);
            number = inputValue.nextInt();

            //Check if number is positive

            if (number >= 0) {

                System.out.println("This number is positive!\n");
                ++count;

            }else {

                System.out.println("This number is negative!\n");

            }

        } while (number != 0);

        System.out.println("The number of positve numbers entered is: " + count + "!\n");
        inputValue.close();
    }

}