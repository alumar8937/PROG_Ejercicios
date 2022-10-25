//26_09_2022 Pedro Marín Sanchis

import java.util.Scanner;

public class Java_Basico_EJ16 {

    public static void main(String[] args) {

        //Declare variables

        int number1 = 0;
        int number2 = 0;
        float result = 0;
        String operand = "";

        //Reading the first number
    
        System.out.println("Enter the first number:");
        
        Scanner inputValue;
        inputValue = new Scanner(System.in);
        number1 = inputValue.nextInt();

        //Reading the second number
        
        System.out.println("Enter the second number:");

        number2 = inputValue.nextInt();

        //Reading the operand choice

        System.out.println("Enter the operand (+, -, *, /):");
        operand = inputValue.next();

        //Calculating result

        switch (operand){

            case "+":
                result = (number1 + number2);
            break;

            case "-":
                result = (number1 - number2);
            break;

            case "*":
                result = (number1 * number2);
            break;

            case "/":
                result = (number1 / number2);
            break;

        }

        //Displaying result

        System.out.println(number1 + " " + operand + " " + number2 + " is: " + result + "!\n");
        inputValue.close();

    }

}