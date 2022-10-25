//26_09_2022 Pedro Marín Sanchis

import java.util.Scanner;

public class Java_Basico_EJ17 {

    public static void main(String[] args) {

    //Declare variables

    int month = 0;

    //Reading the month

    System.out.println("Enter the month (using numbers): ");

    Scanner inputValue;
    inputValue = new Scanner(System.in);
    month = inputValue.nextInt();

    //Displaying results

    switch (month) {

        case 1:
        System.out.println("January has 31 days!");
        break;

        case 2:
        System.out.println("February has 28 days, 29 in a leap year!");
        break;
        
        case 3:
        System.out.println("March has 31 days!");
        break;

        case 4:
        System.out.println("April has 30 days!");
        break;

        case 5:
        System.out.println("May has 31 days!");
        break;

        case 6:
        System.out.println("June has 30 days!");
        break;

        case 7:
        System.out.println("July has 31 days!");
        break;

        case 8:
        System.out.println("August has 31 days!");
        break;

        case 9:
        System.out.println("September has days!");
        break;

        case 10:
        System.out.println("October has 31 days!");
        break;

        case 11:
        System.out.println("November has 30 days!");
        break;

        case 12:
        System.out.println("December has 31 days!");
        break;

        default:
        System.out.println("Wrong input!");


    }
    inputValue.close();
    }


}