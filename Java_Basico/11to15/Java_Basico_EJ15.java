//22_09_2022 Pedro Marín Sanchis

import java.util.Scanner;

public class Java_Basico_EJ15 {

    public static void main(String[] args) {

        int number = 0;

        //Reading the number
    
        System.out.println("Enter your number:");
        
        Scanner inputValue;
        inputValue = new Scanner(System.in);
        number = inputValue.nextInt();

        //Display results
        
        switch (number) {

        case 1:

            System.out.println("One!");

            break;
        
        case 2:

            System.out.println("Two!");

            break;
        
        case 3:

            System.out.println("Three!");

            break;

        case 4:

            System.out.println("Four!");

            break;

        case 5:

            System.out.println("Five!");

            break;

        case 6:

            System.out.println("Six!");

            break;

        case 7:

            System.out.println("Seven!");

            break;

        case 8:

            System.out.println("Eight!");

            break;

        case 9:

            System.out.println("Nine!");

            break;

        case 10:

            System.out.println("Ten!");

            break;

        }
        
        inputValue.close();
    }

}