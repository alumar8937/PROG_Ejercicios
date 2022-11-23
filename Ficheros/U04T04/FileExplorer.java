// 21-11-2022 Pedro Marín Sanchis


// This is a simple file system explorer.

import java.util.Scanner;

import java.io.File;


public class FileExplorer {

    private static Boolean exitCondition = false;
    private static String currentRoute = File.listRoots()[0].getAbsolutePath();


    private static void cls(){ // Clear screen function.

        System.out.println("\n".repeat(100));

    }


    private static void showFilesAndDirectories(){

        File file = new File(currentRoute);

        System.out.println("List of files and directories in directory: " + file.getAbsolutePath() + "\n" + "-".repeat(50) + "\n[0] Parent directory");
       
        if (file.canRead()) {

            System.out.println(FileCharacteristics(file.listFiles()));

        } else {

            System.out.println("[ERROR]: You do not have permission to access this directory.");

        }

    }


    private static String FileCharacteristics(File[] fileArray) {

        StringBuffer buffer = new StringBuffer();
        String[] fileCharacteristicsArray = new String[fileArray.length];

        // Insert numbers

        for (int i = 0; i < fileArray.length; i++) {

            fileCharacteristicsArray[i] = "[" + (i+1) + "]";

        }

        fileCharacteristicsArray = padToSameLength(fileCharacteristicsArray);

        fileCharacteristicsArray = addSpacingToArray(fileCharacteristicsArray, 5);

        // Insert permissions

        for (int i = 0; i < fileArray.length; i++) {

            if (fileArray[i].isDirectory()) {
                
                fileCharacteristicsArray[i] = fileCharacteristicsArray[i] + "d";
            
            } else {

                fileCharacteristicsArray[i] = fileCharacteristicsArray[i] + "-";

            }

            if (fileArray[i].canRead()) {
                
                fileCharacteristicsArray[i] = fileCharacteristicsArray[i] + "r";
            
            } else {

                fileCharacteristicsArray[i] = fileCharacteristicsArray[i] + "-";

            }

            if (fileArray[i].canWrite()) {
                
                fileCharacteristicsArray[i] = fileCharacteristicsArray[i] + "w";
            
            } else {

                fileCharacteristicsArray[i] = fileCharacteristicsArray[i] + "-";

            }

            if (fileArray[i].canExecute()) {
                
                fileCharacteristicsArray[i] = fileCharacteristicsArray[i] + "x";
            
            } else {

                fileCharacteristicsArray[i] = fileCharacteristicsArray[i] + "-";

            }

        }

        fileCharacteristicsArray = addSpacingToArray(fileCharacteristicsArray, 5);

        // Insert file sizes

        for (int i = 0; i < fileArray.length; i++) {

            fileCharacteristicsArray[i] = fileCharacteristicsArray[i] + fileArray[i].length();

        }

        fileCharacteristicsArray = padToSameLength(fileCharacteristicsArray);

        fileCharacteristicsArray = addSpacingToArray(fileCharacteristicsArray, 5);

        // Insert date

        for (int i = 0; i < fileArray.length; i++) {

            fileCharacteristicsArray[i] = fileCharacteristicsArray[i] + fileArray[i].lastModified();

        }

        fileCharacteristicsArray = padToSameLength(fileCharacteristicsArray);

        fileCharacteristicsArray = addSpacingToArray(fileCharacteristicsArray, 5);

        // Insert name

        for (int i = 0; i < fileArray.length; i++) {

            fileCharacteristicsArray[i] = fileCharacteristicsArray[i] + fileArray[i].getName();

        }

        for (String i: fileCharacteristicsArray) {

            buffer.append(i+"\n");

        }

        return buffer.toString();        

    }


    private static String[] padToSameLength(String[] array) {

        String biggestElement = array[0];

        // Find biggest element in array

        for (int i = 1; i < array.length; i++) {

            if (biggestElement.length() < array[i].length()) {

                biggestElement = array[i];

            }

        }

        // Pad elements

        for (int i = 0; i < array.length; i++) {

            array[i] = array[i] + " ".repeat(biggestElement.length() - array[i].length());

        }

        return array;

    }

    
    private static String[] addSpacingToArray(String[] array, int spacing) {

        for (int i = 0; i < array.length; i++) {

            array[i] = array[i] + " ".repeat(spacing);

        }

        return array;

    }
    
    
    private static void menu(Scanner inputValue) {

        boolean correctInputFlag = false;
        int choice;

        File file = new File(currentRoute);

        try {

            while (!correctInputFlag) {

                correctInputFlag = true;

                System.out.println("| -1 : Exit | 0 : Go to parent directory |");
                System.out.print("Write your choice: ");

                choice = inputValue.nextInt();
                inputValue.nextLine();

                switch (choice) {

                    case -1: // Exit
                        correctInputFlag = true;
                    break;

                    case 0:
                        currentRoute = file.getParent();
                    break;

                    default:
                        if (choice > 0) {

                            currentRoute = file.listFiles()[choice-1].getAbsolutePath();

                        } else {

                            System.out.println("[ERROR]: That is not a correct option, try again.\n");

                        }


                }

            }

        } catch (Exception e) {

            e.printStackTrace();
            cls();
            System.out.println("[ERROR]: That is not a correct option, try again.\n");

        }

    }


    public static void main(String[] args) {

        Scanner inputValue = new Scanner(System.in);

        
        while (!exitCondition) {

            cls();
            showFilesAndDirectories();
            menu(inputValue);

        }

    }

}