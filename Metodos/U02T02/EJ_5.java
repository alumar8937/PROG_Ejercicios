//18_11_2022 Pedro Marín Sanchis

//This program asks for a DNI without the control number and calculates it.

import java.util.Scanner;

public class EJ_5 {

    public static char DNILetter(int dni){

        char[] Array;
        Array = new char[23];

        Array[0] = 'T'; Array[1] = 'R'; Array[2] = 'W'; Array[3] = 'A'; Array[4] = 'G'; Array[5] = 'M'; Array[6] = 'Y';
        Array[7] = 'F'; Array[8] = 'P'; Array[9] = 'D'; Array[10] = 'X'; Array[11] = 'B'; Array[12] = 'N'; Array[13] = 'J';
        Array[14] = 'Z'; Array[15] = 'S'; Array[16] = 'Q'; Array[17] = 'V'; Array[18] = 'H'; Array[19] = 'L'; Array[20] = 'C';
        Array[21] = 'K'; Array[22] = 'E';

        return Array[(dni % 23)];

    }
    public static void main(String[] args) {

        //Declare variables

        int dni = 0;
        char dniLetter;

        Scanner inputValue; // Prepare Scanner

        //Ask for DNI [We assume inputs are valid.]

        System.out.print("Enter your DNI: ");

        inputValue = new Scanner(System.in);
        dni = inputValue.nextInt();

        //Calculate

        dniLetter = DNILetter(dni);

        // Display results

        System.out.println("Your DNI letter is: " + dniLetter + "!");
        inputValue.close();
        

    }

}