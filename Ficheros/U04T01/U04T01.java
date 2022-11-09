// 09/11/2022 Pedro Marín Sanchis

// This program reads and writes files using bytestreams.

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.Scanner;

public class U04T01 {

    static String inputFile = "Foo.txt";
    static String outputFile = "Bar.txt";

    static Scanner inputValue = new Scanner(System.in); // Instance Scanner

    private static void cls() {

        System.out.print("\n".repeat(100));

    }

    private static void changeFiles() {

        // Ask for file paths [We assume inputs are valid]
        
        System.out.println("[READ] Enter your file path: ");
        inputFile = inputValue.nextLine();

        System.out.println("[WRITE] Enter your file path: ");
        outputFile = inputValue.nextLine();

    }

    public static void main(String[] args) throws IOException {

        boolean exitCondition = false;
        
        while (!exitCondition) {

            System.out.print("Currently selected files:\n[READ]: " + inputFile + "\n[WRITE]: " + outputFile + "\n" + "-".repeat(30) + "\n1-Change selected files.\n2-Read contents of file.\n3-Clone file.\n4-Append to file.\n5-Exit.\nWrite your choice: ");
            
            switch (inputValue.nextLine()) {

                case "1":
                    changeFiles();
                    cls();
                break;

                case "5":
                    exitCondition = true;
                break;

                default:
                    System.out.println("Wrong choice, try again!\n");
                    cls();
                break;

            }

        }
    

        FileInputStream inputStream = new FileInputStream(inputFile); // Instance FileInputStream
        FileOutputStream outputStream = new FileOutputStream(outputFile); // Instance FileOutputStream

        int value = inputStream.read();

        while (value != -1) {

            System.out.print((char) value);

            outputStream.write((char) value);
            value = inputStream.read();

        }

        inputStream.close(); // Close FileInputStream
        outputStream.close(); // Close FileOutputStream

    }

}