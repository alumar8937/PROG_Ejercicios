//27_09_2022 Pedro Marín

import java.util.Scanner;

public class Java_Basico_EJ19 {

    public static void main(String[] args){

        //Declare variables
        
        double hoursworked = 0;
        double hourpay = 0;
        double bruteIncome = 0;
        double netIncome = 0;
        double taxesPaid = 0;

        //Reading hourly pay

        System.out.println("Enter your hourly pay in €: ");

        Scanner inputValue;
        inputValue = new Scanner(System.in);
        hourpay = inputValue.nextDouble();

        //Reading hours worked

        System.out.println("Enter how many hours you've worked: ");
        hoursworked = inputValue.nextDouble();

        //Calculate bruteIncome

        bruteIncome = (hoursworked * hourpay);

        if (hoursworked > 35) {

            bruteIncome = bruteIncome + ((hoursworked - 35) * (1.5 * hourpay));

        }

        //Calculate netIncome and taxesPaid

        if (bruteIncome > 900) {

            netIncome = (500 + (400 * 0.75) + ((bruteIncome - 900) * 0.55));
            taxesPaid = ((400 * 0.25) + ((bruteIncome - 900) * 0.45));

        } else if (bruteIncome > 500) {

            netIncome = (500 + ((bruteIncome - 500) * 0.75));
            taxesPaid = ((bruteIncome - 500) * 0.25);

        } else {

            netIncome = bruteIncome;
            taxesPaid = 0;

        }

        //Display results
        System.out.println("Your brute income is: " + bruteIncome + "€");
        System.out.println("Your net income is: " + netIncome + "€");
        System.out.println("The taxes you pay are: " + taxesPaid + "€");
        inputValue.close();

    }


}