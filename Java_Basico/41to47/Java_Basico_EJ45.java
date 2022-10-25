//13_10_2022 Pedro Marín Sanchis

//This program calculates the binary expression of a decimal number.

import java.util.Scanner;

public class Java_Basico_EJ45 {

    public static void main(String[] args) {

        //Declare variables

        String binaryNumber = "";
        String decimalNumber = "";
        int integerDecimalNumber = 0;
        boolean isDecimalNumberValid = true;
        
        Scanner inputValue; //Prepare Scanner
        inputValue = new Scanner(System.in);

        while (true) { // Main Program loop

            //Reset conditions
            binaryNumber = "";
            decimalNumber = "";
            isDecimalNumberValid = true;

            //Ask for number

            System.out.print("Enter your decimal number (E to exit): ");
            decimalNumber = inputValue.nextLine();

            if (decimalNumber.charAt(0) == 'e' || decimalNumber.charAt(0) == 'E') {break;} // Check exit condition
                
            //Check for erroneous inputs

            for (int i = 0; i < decimalNumber.length(); i++){

                switch (decimalNumber.charAt(decimalNumber.length()-i-1)) {

                    case '0': break;

                    case '1':
                    integerDecimalNumber = integerDecimalNumber + 1*((int)Math.pow(10, i));
                    break;

                    case '2':
                    integerDecimalNumber = integerDecimalNumber + 2*((int)Math.pow(10, i));
                    break;

                    case '3':
                    integerDecimalNumber = integerDecimalNumber + 3*((int)Math.pow(10, i));
                    break;

                    case '4':
                    integerDecimalNumber = integerDecimalNumber + 4*((int)Math.pow(10, i));
                    break;

                    case '5':
                    integerDecimalNumber = integerDecimalNumber + 5*((int)Math.pow(10, i));
                    break;

                    case '6':
                    integerDecimalNumber = integerDecimalNumber + 6*((int)Math.pow(10, i));
                    break;

                    case '7':
                    integerDecimalNumber = integerDecimalNumber + 7*((int)Math.pow(10, i));
                    break;

                    case '8':
                    integerDecimalNumber = integerDecimalNumber + 8*((int)Math.pow(10, i));
                    break;

                    case '9':
                    integerDecimalNumber = integerDecimalNumber + 9*((int)Math.pow(10, i));
                    break;

                    default:
                        isDecimalNumberValid = false;
                    break;

                }

            }

            // Calculate number of bits necessary

            int position = 0;

            while ((int)Math.pow(2, position) < integerDecimalNumber){
                position++;
            } 

            // Calculate binary

            while (integerDecimalNumber != 0 & position >= 0){
                
                if (integerDecimalNumber - (int)Math.pow(2, position) >= 0){

                    binaryNumber = binaryNumber + "1";
                    integerDecimalNumber = integerDecimalNumber - (int)Math.pow(2, position);
                    position--;

                } else {

                    binaryNumber = binaryNumber + "0";
                    position--;

                }

            }

            // Add missing zeroes, if any.

            while (position >= 0) {
                binaryNumber = binaryNumber + "0";
                position--;
            }

            // Print Results
            
            if (isDecimalNumberValid == true) {
                System.out.println("Your decimal number in binary is: " + binaryNumber + "!");
            } else {
                System.out.println("Wrong input! You can only do ones or zeroes!");}

        }

        inputValue.close();

    }

}