//21_09_2022 Pedro Marín Sanchis

import java.util.Scanner;

public class Java_Basico_EJ9 {

    public static void main(String[] args) {
    
        int age = 0;
    
        System.out.println("Enter your age:");
        
        //Reading age
        
        Scanner inputValue;
        inputValue = new Scanner(System.in);
        age = inputValue.nextInt();

        if (age >= 18) {

            System.out.println("You are not underaged!");

        }else{

            System.out.println("You are underaged!");

        }
        
        inputValue.close();
    
    }

}
