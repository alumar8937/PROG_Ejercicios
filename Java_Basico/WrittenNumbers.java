//22_09_2022 Pedro Marín Sanchis

import java.util.Scanner;

public class WrittenNumbers {

    public static void main(String[] args) {

        int number = 0;
        String stringNumber = ""; // For future conversion of int number
        int stringNumberLen = 0; //Lenght of number
        //String writtenNumber = ""; //Result

        //Ask for number

        System.out.println("Enter your number:");
        
        Scanner inputValue;
        inputValue = new Scanner(System.in);
        number = inputValue.nextInt();

        stringNumber = String.valueOf(number);
        stringNumberLen = (stringNumber.length() - 1);

        //Turn to Written Number

        for (int position = stringNumberLen; position >= 0; --position) {

            System.out.println("pos " + position + " corresponds: " + stringNumber.charAt(position));
            
            switch (Character.toString(stringNumber.charAt(position))) {

                case "1":
                    System.out.println("el wiwi");
                break;

            }

        }

        inputValue.close();

    }

}