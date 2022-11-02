// 28_10_22 Pedro Marín Sanchis

// This program checks if a word's letters are alphabetically in order.

import java.util.Scanner;

public class Alfabetica {

    static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray(); // Initialize Array

    public static boolean isAphabeticallyArranged(String string) {

        int count = 0;
        boolean flag = false;

        for (int j = 1; j < string.length(); j++) {

            while (flag == false) { // Go through alphabet, keep count.

                count++;
                if (count == alphabet.length) {return false;}
                if (string.charAt(j) == alphabet[count]) {break;}

            }

        }

        return true;
    }

    public static void main(String[] args) {

        Scanner inputValue = new Scanner(System.in);

        String string = "";

        while (string.equals("0") == false) {

            System.out.print("Enter your word: ");
            string = inputValue.nextLine();
            if (string.equals("0") == false) {

                if (isAphabeticallyArranged(string)) {

                    System.out.println("Your word is alphabetically arranged!");

                } else {

                    System.out.println("Your word is not alphabetically arranged.");

                }

            }

        }

        inputValue.close(); // Close scanner

    }

}