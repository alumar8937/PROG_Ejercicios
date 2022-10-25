//16_10_2022 Pedro Marín Sanchis

import java.util.Scanner;

public class Metodos_EJ5 {
    
    static int biggestNumber = 0; // Biggest Number.

    public static void BiggestNumber(int number) {

        if (number > biggestNumber) {biggestNumber = number;}

    }
    public static void main(String[] args){
                
        Scanner inputValue;
        inputValue = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {

            System.out.println((i+1) + "- Write your number:");
            BiggestNumber(inputValue.nextInt()); //We read the number and call addPositives method [We assume inputs are valid]

        }

        System.out.println("The biggest number is: " + biggestNumber + "!");

        inputValue.close();

    }

}
