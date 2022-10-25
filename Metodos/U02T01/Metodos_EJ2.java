//16_10_2022 Pedro Marín Sanchis

import java.util.Scanner;

public class Metodos_EJ2 {


    public static void AscendingOrder(float number1, float number2) {

        if (number1 > number2) {

            System.out.println("\n" + number2 + "<" + number1);
    
            }else{
    
            System.out.println("\n" + number1 + "<" + number2);
    
            }

    }

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

        AscendingOrder(number1, number2);
        inputValue.close();

    }

}
