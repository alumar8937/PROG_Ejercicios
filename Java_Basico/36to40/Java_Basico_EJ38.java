//05_10_2022 Pedro Marín Sanchis

//This program counts the ammount of vocals in a user inputted string.

import java.util.Scanner;

public class Java_Basico_EJ38 {

    public static void main(String[] args) {

        //Declare variables

        String userString = "";
        int vocalNumber = 0;
        Scanner inputValue; // Prepare Scanner
        
        //Ask for string [We assume inputs are valid.]

        System.out.print("Enter your text: ");

        inputValue = new Scanner(System.in);
        userString = inputValue.nextLine().toUpperCase();

        //Calculate ammount of vocals

        for (int i = 0; i < userString.length() - 1; i++) {

            switch (String.valueOf(userString.charAt(i))) {

                case "A": case "E": case "I": case "O": case "U":
                    vocalNumber++;
                    break;

            }

        }

        //Display results

        System.out.println("The ammount of vocals is: " + vocalNumber + "!");
        inputValue.close();

    }

}