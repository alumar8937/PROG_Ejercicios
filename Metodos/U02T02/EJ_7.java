// 19/11/2022 Pedro Marín Sanchis

// This program displays all prime numbers ranging from 3 to 100.

public class EJ_7 {

    public static boolean IsPrime(int number) {

        if (number == 1) {return false;}

        for (int i = 2; i < number; i++){

            if (number % i == 0) {return false;}

        }

        return true;

    }
    public static void main(String[] args) {

        // Declare variables

        String primeNumbers = "Prime numbers from 3 to 100 are: ";

        // Loop through 3 to 100

        for (int i = 3; i <= 100; i++){ 
            
            IsPrime(i);

            // Display results

            if (IsPrime(i) == true) {
                
                primeNumbers = primeNumbers + i +", ";
        
            }

        }

        primeNumbers = primeNumbers.substring(0, primeNumbers.length() - 2) + "."; // Add period at the end

        // Display results

        System.out.println(primeNumbers);

    }

}