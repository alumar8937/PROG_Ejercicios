//03_10_2022 Pedro Marín Sanchis

public class Java_Basico_EJ29 {

    public static void main(String[] args) {

        //Declare variables

        int number = 3;
        boolean isPrime = true;
       
        for (; number < 101; number++) {

            isPrime = true; // Reset

            for (int i = number - 1; i > 1; i--) { // Go trough divisions

                        if (number % i == 0) {isPrime = false;}

            }

            if (isPrime == true) {
                
                System.out.println(number);
                
            }

        }

    }

}