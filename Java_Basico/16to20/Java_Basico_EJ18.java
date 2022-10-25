//26_09_2022 Pedro Marín Sanchis

import java.util.Scanner;

public class Java_Basico_EJ18 {

    public static void main(String[] args){

        //Declaring variables

        int hours = 0;
        int minutes = 0;
        int seconds = 0;

        //Reading variables

        System.out.println("Enter the ammount of hours: ");

        Scanner inputValue;
        inputValue = new Scanner(System.in);
        hours = inputValue.nextInt();

        System.out.println("Enter the ammount of minutes: ");
        minutes = inputValue.nextInt();

        System.out.println("Enter the ammount of seconds: ");
        seconds = inputValue.nextInt();

        //Calculate results

        /* Solution with for loops

        for (++seconds; seconds >= 60; seconds = (seconds - 60)) {

            ++minutes;

        }

        for (; minutes >= 60; minutes = (minutes - 60)) {

            ++hours;

        }

        for (; hours >= 24; hours = (hours - 24)) {}

        */

        ++seconds;

        if (seconds >= 60) {

            seconds = seconds - 60;
            ++minutes;

        }

        if (minutes >= 60) {

            minutes = minutes - 60;
            ++hours;

        }

        if (hours >= 24) {

            hours = hours - 24;

        }

        //Display results

        System.out.println("The time is: " + hours + ":" + minutes + ":" + seconds);
        inputValue.close();
    }

}