//16_10_2022 Pedro Marín Sanchis

import java.util.Scanner;

public class Metodos_EJ1 {

    public static void main(String[] args) {
    
        int age = 0;
    
        System.out.println("Enter your age:");
        
        //Reading age
        
        Scanner inputValue;
        inputValue = new Scanner(System.in);
        age = inputValue.nextInt();
        IsLegalAge(age);
        inputValue.close();
    
    }

    public static void IsLegalAge(int age){

        if (age >= 18) {

            System.out.println("You are not underaged!");        

        } else {

            System.out.println("You are underaged!");

        }
    
    }

}