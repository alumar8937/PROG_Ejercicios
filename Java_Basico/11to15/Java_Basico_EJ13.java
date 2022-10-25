//22_09_2022 Pedro Marín Sanchis

import java.util.Scanner;

public class Java_Basico_EJ13 {

    public static void main(String[] args) {
    
        float number1 = 0;
        float number2 = 0;
        int orderChoice = 0;
    
        //Reading first number
    
        System.out.println("Enter the first number:");
        
        Scanner inputValue;
        inputValue = new Scanner(System.in);
        number1 = inputValue.nextFloat();
        
        //Reading second number
    
        System.out.println("Enter the second number:");
        number2 = inputValue.nextFloat();
        
        //Reading display preference
    
        while (true) {

            System.out.println("Enter how you want the numbers to be displayed:\n1: Ascending order\n2: Descending order:");

            inputValue = new Scanner(System.in);
            orderChoice = inputValue.nextInt();

            if (orderChoice == 1) {

                //Display ascendiente
        
                 if (number1 > number2) {

                 System.out.println("\n" + number2 + "<" + number1);

                 }else{

                 System.out.println("\n" + number1 + "<" + number2);

                 }

                break;

            }

            if (orderChoice == 2) {

                //Display descendiente

                if (number1 > number2) {

                System.out.println("\n" + number1 + ">" + number2);

                }else{

                System.out.println("\n" + number2 + ">" + number1);

                }

                break;

            }
            
            System.out.println("\nYou have entered a wrong value, try again!\n");

        }
        inputValue.close();
    }

}
