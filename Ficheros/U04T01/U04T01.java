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
        
        System.out.print("[READ] Enter your file path: ");
        inputFile = inputValue.nextLine();

        System.out.print("[WRITE] Enter your file path: ");
        outputFile = inputValue.nextLine();

    }

    private static String fileContents(String filePath) throws IOException {

        String output = "";

        FileInputStream inputStream = new FileInputStream(filePath); // Instance FileInputStream

        int value = inputStream.read();

        while (value != -1) {

            output = output + (char) value;
            value = inputStream.read();

        }

        inputStream.close(); // Close FileInputStream

        return output;

    }

    private static void copyFileContents(String originalFile, String destinationFile) throws IOException {

        FileInputStream inputStream = new FileInputStream(originalFile); // Instance FileInputStream
        FileOutputStream outputStream = new FileOutputStream(destinationFile); // Instance FileOutputStream

        int value = inputStream.read();

        while (value != -1) {

            outputStream.write((char) value);
            value = inputStream.read();

        }

        inputStream.close(); // Close FileInputStream
        outputStream.close(); // Close FileOutputStream

    }

    private static void appendToFile(String file, char[] append) throws IOException {

        char[] originalContents = fileContents(file).toCharArray(); // Get contents of file as string from fileContents method and convert to a char array.

        FileOutputStream outputStream = new FileOutputStream(file); // Instance FileOutputStream

        for (char i: originalContents) { // Write original content
            outputStream.write(i);
        }

        for (char i: append) { // Write new content
            outputStream.write(i);
        }

        outputStream.close(); // Close FileOutputStream

    }

    public static void main(String[] args) throws IOException {

        boolean exitCondition = false;
        
        while (!exitCondition) {

            System.out.print("Currently selected files:\n[READ]: " + inputFile + "\n[WRITE]: " + outputFile + "\n" + "-".repeat(30) + "\n1-Change selected files.\n2-Read contents of file.\n3-Clone file.\n4-Append to file.\n5-Exit.\nWrite your choice: ");
            
            switch (inputValue.nextLine()) {

                case "1": // Change files
                    changeFiles();
                    cls();
                break;

                case "2": // Read the contents of the input file.
                    cls();
                    System.out.print("The contents of " + inputFile + " are: " + fileContents(inputFile) + "\n");
                break;

                case "3": // Clones file
                    cls();
                    copyFileContents(inputFile, outputFile);
                break;

                case "4": // Appends contents of inputFile to outputFile
                    appendToFile(outputFile, fileContents(inputFile).toCharArray());
                break;

                case "5":
                    exitCondition = true;
                break;

                default:
                    cls();
                    System.out.println("Wrong choice, try again!\n");
                break;

            }

        }

    }

}