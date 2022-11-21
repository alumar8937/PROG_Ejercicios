// 21-11-2022 Pedro Marín Sanchis


// This is a simple file system explorer.

import java.util.Scanner;

public class CLASSNAME {

    private static Boolean exitCondition = false;


    private static void cls(){ // Clear screen function.

        System.out.println("\n".repeat(100));

    }


    private static void menu(Scanner inputValue) {

        boolean correctInputFlag = false;

        try {

            while (!correctInputFlag) {

                correctInputFlag = true;

                System.out.println("MenuMenu");
                System.out.print("Write your choice: ");

                switch (inputValue.nextLine()) {

                    case "1":

                    break;

                    case "0":

                    break;

                    default:

                        correctInputFlag = false;
                        cls();
                        System.out.println("[ERROR]: That is not a correct option, try again.\n");

                }

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }


    public static void main(String[] args) {

        Scanner inputValue = new Scanner(System.in);

        while (!exitCondition) {

            cls();
            menu(inputValue);

        }

    }

}