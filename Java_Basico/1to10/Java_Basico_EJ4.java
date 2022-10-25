//21_09_2022 Pedro Marín Sanchis

import java.util.Scanner;

public class Java_Basico_EJ4 {

    public static void main(String[] args) {
    
        float side = 0;
        float squareArea = 0;
    
        System.out.println("Enter the side:");
        
        //Reading the square's side value
        
        Scanner inputValue;
        inputValue = new Scanner(System.in);
        side = inputValue.nextFloat();
        
        squareArea = (side * side);
        
        System.out.println("The square's area is: " + squareArea + " units.");
        inputValue.close();
    
    }

}
