//28_09_2022 Pedro Marín Sanchis

import java.util.Scanner;

public class Java_Basico_EJ22 {

    public static void main(String[] args) {

        //Declare variables

        int number = 0;
       
        Scanner inputValue; // Prepare Scanner

        //Repeat 10 times

        for (int i = 1; i <= 10; ++i){
        
        //Ask for number

        System.out.print(i + " - Enter your number: ");

        inputValue = new Scanner(System.in);
        number = inputValue.nextInt();

        //Check if number is even or odd

        if (number % 2 == 0) {

            System.out.println("This number is even!\n");

        }else {

            System.out.println("This number is odd!\n");

        }

        }

    }

}