//03_10_2022 Pedro Marín Sanchis

import java.util.Scanner;

public class Java_Basico_EJ27 {

    public static void main(String[] args) {

        //Declare variables

        int number = 0;
       
        Scanner inputValue; // Prepare Scanner

        //Ask for number

        System.out.print("Enter your number: ");

        inputValue = new Scanner(System.in);
        number = inputValue.nextInt();

        for (int i = 0; i <= number; i++) {

            for (int j = 1; j != i + 1; j++) {
                System.out.print(j + " ");
            }

            System.out.print("\n");

        }

        inputValue.close();

    }

}