//28_09_2022 Pedro Marín Sanchis

import java.util.Scanner;

public class Java_Basico_EJ21 {

    public static void main(String[] args) {

        //Declare variables

        int year = 0;

        //Ask for year

        System.out.println("Enter the year: ");

        Scanner inputValue;
        inputValue = new Scanner(System.in);
        year = inputValue.nextInt();

        //Validate leap year and display results

        if (year % 4 == 0) {

            if (year % 100 == 0 && year % 400 != 0) {

                System.out.println(year + " is not a leap year!");

            } else {

                System.out.println(year + " is a leap year!");

            }

        } else {

            System.out.println(year + " is not a leap year!");

        }
        inputValue.close();
    }

}