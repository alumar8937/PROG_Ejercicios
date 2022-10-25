//13_10_2022 Pedro Marín Sanchis

//This program calculates the decimal expression of a binary number.

import java.util.Scanner;

public class Java_Basico_EJ44 {

    public static void main(String[] args) {

        //Declare variables

        int decimalNumber = 0;
        String binaryNumber = "";
        boolean isBinaryNumberValid = true;
        
        Scanner inputValue; //Prepare Scanner
        inputValue = new Scanner(System.in);

        while (true) { // Main Program loop

            //Reset conditions

            decimalNumber = 0;
            isBinaryNumberValid = true;

            //Ask for number

            System.out.print("Enter your binary number (E to exit): ");
            binaryNumber = inputValue.nextLine();

            if (binaryNumber.charAt(0) == 'e' || binaryNumber.charAt(0) == 'E') {break;} // Check exit condition
                
            //Check for erroneous inputs

            for (int i = 0; i < binaryNumber.length(); i++){

                switch (binaryNumber.charAt(binaryNumber.length()-i-1)) { // We do this here because binary is translated right to left!

                    case '0':
                    break;

                    case '1':
                        decimalNumber = decimalNumber + (1* ((int)Math.pow(2, i))); // Calculate decimalNumber (Sum all ones)
                    break;

                    default:
                        isBinaryNumberValid = false;
                    break;

                }

            }
            
            if (isBinaryNumberValid == true) {
                System.out.println("Your binary number in decimal is: " + decimalNumber + "!");
            } else {
                System.out.println("Wrong input! You can only do ones or zeroes!");}

        }

        inputValue.close();

    }

}