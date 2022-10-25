//16_10_2022 Pedro Marín Sanchis

import java.util.Scanner;

public class Metodos_EJ4 {
    
    static int positives = 0; // Number of positive numbers.

    public static void AddPositives(int number) {

        if (number >= 0) {positives++;}

    }
    public static void main(String[] args){
                
        Scanner inputValue;
        inputValue = new Scanner(System.in);
        
        System.out.println("Write the ammount of numbers you want to input:");

        for (int i = inputValue.nextInt(); i > 0; i--) { //We read the ammont of times the user wants to input a number [We assume inputs are valid]

            System.out.println("Write your number:");
            AddPositives(inputValue.nextInt()); //We read the number and call addPositives method [We assume inputs are valid]

        }

        System.out.println("The ammount of positive numbers is: " + positives + "!");

        inputValue.close();

    }

}
