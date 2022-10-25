//05_10_2022 Pedro Marín Sanchis

//This program calculates the letter of a NIE.

import java.util.Scanner;

public class Java_Basico_EJ34 {

    public static void main(String[] args) {

        //Declare variables

        String nie = "";
        int dni = 0; //For later formatting into nie equivalent
        String dniLetter = "";
        
        String[] Array;
        Array = new String[23];

        Array[0] = "T";
        Array[1] = "R";
        Array[2] = "W";
        Array[3] = "A";
        Array[4] = "G";
        Array[5] = "M";
        Array[6] = "Y";
        Array[7] = "F";
        Array[8] = "P";
        Array[9] = "D";
        Array[10] = "X";
        Array[11] = "B";
        Array[12] = "N";
        Array[13] = "J";
        Array[14] = "Z";
        Array[15] = "S";
        Array[16] = "Q";
        Array[17] = "V";
        Array[18] = "H";
        Array[19] = "L";
        Array[20] = "C";
        Array[21] = "K";
        Array[22] = "E";

        Scanner inputValue; // Prepare Scanner

        //Ask for NIE [We assume inputs are valid.]

        System.out.print("Enter your NIE: ");

        inputValue = new Scanner(System.in);
        nie = inputValue.nextLine();

        switch (String.valueOf(nie.charAt(0))) {

                case "X": // 0

                    nie = "0" + nie.substring(1);
                    break;

                case "Y": // 1

                    nie = "1" + nie.substring(1);
                    break;

                case "Z": // 2

                    nie = "2" + nie.substring(1);
                    break;


            }

        // Set corrected NIE as DNI for calculation.
        
        dni = Integer.valueOf(nie);

        //Calculate

        dniLetter = Array[(dni % 23)];

        // Display results

        System.out.println("Your NIE letter is: " + dniLetter + "!");
        inputValue.close();
        

    }

}