//21_09_2022 Pedro Marín Sanchis

import java.util.Scanner;

public class Java_Basico_EJ7 {

    public static void main(String[] args) {
    
        float originalPrice = 0;
        float discountedPrice = 0;
    
        //Reading original price
    
        System.out.println("Enter original price:");
        
        Scanner inputValue;
        inputValue = new Scanner(System.in);
        originalPrice = inputValue.nextFloat();
        
        //Reading discounted price
    
        System.out.println("Enter discounted price:");
        discountedPrice = inputValue.nextFloat();
        
        //Display results
        
        System.out.println("\nThe discount is: " + ( ((originalPrice - discountedPrice)/originalPrice) * 100) + "%");
        inputValue.close();
    }

}
