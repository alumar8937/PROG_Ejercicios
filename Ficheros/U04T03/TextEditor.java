// 16/11/2022 - Pedro Marín Sanchis

// This program let's the user edit text.

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class TextEditor {

    private static String[] text;
    private static boolean exitCondition = false; // Exit condition.

    private static File chooseFile(Scanner choice) {
        
        File file;

        while (true) {

            try {

                System.out.print("Enter your filepath: ");

                file = new File(choice.nextLine());

                if (file.exists()) {

                    System.out.println("File exists.");

                    break;

                } else {

                    System.out.println("[Error]: File does not exist, try again.");

                }


            } catch (java.util.InputMismatchException e) {

                System.out.println("[Error]: Input error, try again.");

            }

        }

        return file;

    }

    private static void loadFileData(File file) {

        try {

            FileReader inputStream = new FileReader(file);

            // Por aquí me he quedado.

        } catch (IOException e) {

            System.out.println("[Error]: There was a problem while loading the file.");
    
        }

    }

    private static void displayText(String[] text) {

        for (int i = 0; i < text.length; i++) {

            System.out.println("[" + (i+1) + "]: " + text[i]);

        }

    }

    private static void menu(Scanner choice) {

        System.out.print("Menu");

        switch (choice.nextLine()) {

            case "1": // Delete line.

            break;

            case "2": // Insert line.

            break;

            case "3": // Save.

            break;

            case "4": // Exit.

                exitCondition = true;

            break;
        }

    }

    public static void main(String[] args) {

        Scanner inputValue = new Scanner(System.in); // Instance Scanner.

        loadFileData(chooseFile(inputValue));

        while (!exitCondition) {

            displayText(text);
            menu(inputValue);

        }

        inputValue.close();

    }

}