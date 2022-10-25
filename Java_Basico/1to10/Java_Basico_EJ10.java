//21_09_2022 Pedro Marín Sanchis

import java.util.Scanner;

public class Java_Basico_EJ10 {

    public static void main(String[] args) {
    
        double number = 0;
    
        System.out.println("Enter the number:");
        
        //Reading number
        
        Scanner inputValue;
        inputValue = new Scanner(System.in);
        number = inputValue.nextDouble();

        //Positive or negative algorithm
        
        if (number >= 0){

            System.out.println("Your number is positive!");

        }else{

            System.out.println("Your number is negative!");

        }
        
        inputValue.close();
    
    }

}
