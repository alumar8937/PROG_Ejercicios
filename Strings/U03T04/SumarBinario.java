// 02/11/2022 Pedro Marín Sanchis

// This program adds up biary numbers.

import java.util.Scanner;

public class SumarBinario {

    public static int sumarBinario(int number1, int number2) {

        boolean flag = false;
        int binaryNumberSum = number1 + number2;

        while (!flag) {

            flag = true;

            for (int i = 0; i < String.valueOf(binaryNumberSum).length(); i++){

                if (String.valueOf(binaryNumberSum).charAt(i) == '2') {

                    flag = false;

                    // La suma directa de los números [Pongamos de ejemplo 111 y 100] da 211. Restamos 200 y sumamos 1000.

                    //                                                  Restamos 2*10^(Posición)                                                Sumamos 1*10^(Posición + 1)
                    binaryNumberSum = binaryNumberSum - (2 * (int) Math.pow(10, String.valueOf(binaryNumberSum).length() - i - 1)) + (1 * (int) Math.pow(10, String.valueOf(binaryNumberSum).length() - i));

                }

            }
        
        }
        

        return binaryNumberSum;

    }

    public static void main(String[] args) {

        Scanner inputValue = new Scanner(System.in); // Open Scanner.
        int number1 = 0;
        int number2 = 0;

        // Ask for both numbers [We assume inputs are valid].

        System.out.print("Enter your first binary number: ");
        number1 = inputValue.nextInt();
        System.out.print("Enter your second binary number: ");
        number2 = inputValue.nextInt();

        System.out.println(sumarBinario(number1, number2));

        inputValue.close();

    }
    
}
