//21_09_2022 Pedro Marín Sanchis

import java.util.Scanner;

public class Java_Basico_EJ5 {

    public static void main(String[] args) {
    
        int number1 = 0;
        int number2 = 0;
    
        //Reading radius
    
        System.out.println("Enter number one:");
        
        Scanner inputValue;
        inputValue = new Scanner(System.in);
        number1 = inputValue.nextInt();
        
        //Reading number 2
    
        System.out.println("Enter number one:");
        number2 = inputValue.nextInt();
        
        //Display results
        
        System.out.println("\nThe sum is: " + (number1 + number2));
        System.out.println("The subtraction is: " + (number1 - number2));
        System.out.println("The product is: " + (number1 * number2));
        System.out.println("The division is: " + (number1 / number2));
        inputValue.close();
        
    }

}
