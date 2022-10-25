//03_10_2022 Pedro Marín Sanchis

import java.util.Scanner;

public class Java_Basico_EJ24 {

    public static void main(String[] args) {

        //Declare variables

        float median = 0;
        float sum = 0; // Sum of grades
        int i = 0; // Ammount of grades (for division)
        boolean wasTen = false; // Grade of 10 in median flag
        float grade = 0;


        Scanner inputValue; // Prepare Scanner

        //Loop until exit condition (grade == -1)

        while (true) {

            // Ask for grade

            System.out.print("Enter grade (-1 to exit): ");

            inputValue = new Scanner(System.in);
            grade = inputValue.nextFloat();
            
            if (grade != -1) { // Check exit condition
                
                ++i;

                sum = sum + grade;

                if (grade == 10) { wasTen = true; } // Check if there is a 10 in the grades


            } else {

                // Calculate and display median

                if (i != 0) { median = sum / i; }

                System.out.print("The median is: ");
                System.out.printf("%.2f", median);
                System.out.print("\n");

                if (wasTen == true) { System.out.println("There was a 10 in the grades!"); } // Display wasTen

                break;
            }

        }
        inputValue.close();
    }

}