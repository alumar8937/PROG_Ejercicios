//21_09_2022 Pedro Marín Sanchis

import java.util.Scanner;

public class Java_Basico_EJ6 {

    public static void main(String[] args) {
    
        final double PI = 3.14159;
        double radius = 0;
    
        //Reading radius
    
        System.out.println("Enter radius:");
        
        Scanner inputValue;
        inputValue = new Scanner(System.in);
        radius = inputValue.nextDouble();
        
        //Display results
        
        System.out.println("\nThe circumference is: " + (2 * PI * radius));
        System.out.println("The area is: " + (PI * radius * radius));
        inputValue.close();
    }

}
