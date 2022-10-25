//21_09_2022 Pedro Marín Sanchis

import java.util.Scanner;

public class Java_Basico_EJ11 {

    public static void main(String[] args) {
    
        float number1 = 0;
        float number2 = 0;
    
        //Reading first number
    
        System.out.println("Enter the first number:");
        
        Scanner inputValue;
        inputValue = new Scanner(System.in);
        number1 = inputValue.nextFloat();
        
        //Reading second number
    
        System.out.println("Enter the second number:");
        number2 = inputValue.nextFloat();
        
        //Display results
        
        if (number1 > number2) {

        System.out.println("\n" + number2 + "<" + number1);

        }else{

        System.out.println("\n" + number1 + "<" + number2);

        }
        inputValue.close();
    }

}
