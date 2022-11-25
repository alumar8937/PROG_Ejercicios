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
       
        if (file.canRead() && file.isDirectory()) {

            if (file.listFiles().length != 0) {

                System.out.println(FileCharacteristics(file.listFiles()));

            } else {

                System.out.println("            This directory is empty.");

            }

        } else {

            System.out.println("[ERROR]: You do not have permission to access this directory.");

        }

    }


    private static String FileCharacteristics(File[] fileArray) {

        StringBuffer buffer = new StringBuffer(); // For method return.
        String[] fileCharacteristicsArray = new String[fileArray.length];

        // Insert numbers.

        for (int i = 0; i < fileArray.length; i++) {

            fileCharacteristicsArray[i] = "[" + (i+1) + "]\t";

            // Insert permissions.

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
                
                fileCharacteristicsArray[i] = fileCharacteristicsArray[i] + "x\t";
            
            } else {

                fileCharacteristicsArray[i] = fileCharacteristicsArray[i] + "-\t";

            }

            // Insert file sizes

            fileCharacteristicsArray[i] = fileCharacteristicsArray[i] + fileArray[i].length() + "\t";

            // Insert date

            fileCharacteristicsArray[i] = fileCharacteristicsArray[i] + fileArray[i].lastModified() + "\t";

            // Insert file name
            
            fileCharacteristicsArray[i] = fileCharacteristicsArray[i] + fileArray[i].getName();

        }


        for (String i: fileCharacteristicsArray) {

            buffer.append(i+"\n");

        }

        return buffer.toString();        

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
                        if (currentRoute != File.listRoots()[0].getAbsolutePath()) {

                            currentRoute = file.getParent();

                        }
                    break;

                    default:
                        if (choice > 0 && choice < file.listFiles().length) {

                            currentRoute = file.listFiles()[choice-1].getAbsolutePath();

                        } else {

                            cls();
                            System.out.print("[ERROR]: That is not a correct option, try again.\nPress ENTER to continue.");
                            inputValue.nextLine();

                        }


                }

            }

        } catch (Exception e) {

            cls();
            System.out.print("[ERROR]: That is not a correct option, try again.\nPress ENTER to continue.");
            inputValue.nextLine();

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