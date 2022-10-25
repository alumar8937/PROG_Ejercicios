//04_10_2022 Pedro Marín Sanchis

// This program prints an array using a for loop.

public class Java_Basico_EJ31 {

    public static void main(String[] args) {


        // Declares an array of integers
        int[] anArray;
        // Allocates memory for 10 integers
        anArray = new int[10];
        // Initialize first element
        anArray[0] = 100;
        // Initialize second element
        anArray[1] = 200;
        // And so forth
        anArray[2] = 300;
        anArray[3] = 400;
        anArray[4] = 500;
        anArray[5] = 600;
        anArray[6] = 700;
        anArray[7] = 800;
        anArray[8] = 900;
        anArray[9] = 1000;

        for (int i = 9; i > -1; i--) { //Print array

            System.out.println("Element on index " + i + ": " + anArray[i]);

        }

    }

}