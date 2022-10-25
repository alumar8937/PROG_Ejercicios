//27_09_2022 Pedro Marín

import java.util.Scanner;

public class Java_Basico_EJ20 {

    public static void main(String[] args){

        //Declare variables
        
        double itemPrice = 0;
        double finalPrice = 0;

        //Reading itemPrice

        System.out.println("Enter the price of the item in €: ");

        Scanner inputValue;
        inputValue = new Scanner(System.in);
        itemPrice = inputValue.nextDouble();

        //Calculate final price

        if (itemPrice >= 60) {

            finalPrice = (itemPrice * 0.9);

        } else if (itemPrice >= 6) {

            finalPrice = (itemPrice * 0.95);

        } else {

            finalPrice = itemPrice;

        }

        //Display results
        System.out.print("The final price is: ");
        System.out.printf("%.2f", finalPrice);
        System.out.print("€\n");
        inputValue.close();

    }


}