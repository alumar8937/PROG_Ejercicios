// 16/11/2022 - Pedro Marín Sanchis

// This program let's the user edit text.

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class TextEditor {

    private static String text;
    private static boolean exitCondition = false; // Exit condition.
    private static boolean unsavedChangesFlag = false;

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

        StringBuffer buffer = new StringBuffer();

        //FileReader inputStream;

        try {

            FileReader inputStream = new FileReader(file);

            int value = inputStream.read();

            while (value != -1) {

                buffer.append((char) value);
                value = inputStream.read();

            }

            text = buffer.toString();

            inputStream.close();

        } catch (IOException e) {

            System.out.println("[Error]: There was a problem while loading the file.");
    
        }

    }


    private static String[] textToLineArray(String workingText) {

        StringBuffer buffer = new StringBuffer();

        String[] textArray;

        int lineCount = 1;

        int line = 0; // For writing into the textArray.

        for (int i = 0; i < workingText.length(); i++) { // Count the ammount of lines.

            if (workingText.charAt(i) == '\n') {

                lineCount++;

            }

        }

        textArray = new String[lineCount]; // Create textArray.

        for (int i = 0; i < workingText.length(); i++) { // Load lines into the array.

            if (workingText.charAt(i) != '\n') {

                buffer.append(workingText.charAt(i));

            } else {

                textArray[line] = buffer.toString(); // Print line.
                line++;
                buffer.setLength(0); // Empty out buffer.

            }

        }

        textArray[line] = buffer.toString(); // Load last line.

        return textArray;

    }


    private static void displayText(String workingText) {

        String[] textArray = textToLineArray(workingText);

        if (text.isEmpty()) {

            System.out.println("There are no lines in the file.");

        } else {

            for (int i = 0; i < textArray.length; i++) {

                System.out.println("[" + i + "]: " + textArray[i]);
    
            }

        }

    }


    private static void deleteLine(String workingText, Scanner inputValue) {

        StringBuffer buffer = new StringBuffer();

        String[] textArray = textToLineArray(workingText);

        int lineDeleteIndex = 0;

        boolean correctInputFlag = false;

        while (!correctInputFlag) {

            try {

                System.out.print("Type the line you want to delete: ");
                lineDeleteIndex = inputValue.nextInt();
                inputValue.nextLine();

                if (lineDeleteIndex < textArray.length && lineDeleteIndex >= 0) {

                    for (int i = 0; i < textArray.length; i++) {

                        if (i != lineDeleteIndex) {

                            buffer.append(textArray[i]);

                            if (i != textArray.length-1) {

                                buffer.append("\n");

                            }

                        }

                    }

                    correctInputFlag = true;

                } else {

                    System.out.println("[Error]: That line does not exist!");

                }

            } catch (Exception e) {

                System.out.println("[Error]: Wrong input, try again.");
                inputValue.nextLine(); // To prevent an infinite loop.

            }
        
        }

        if (lineDeleteIndex == textArray.length-1 && !buffer.toString().isEmpty()) {

            text = buffer.toString().substring(0, buffer.toString().lastIndexOf("\n")-1); // Deletes the last character newline character if the deleted line was the last one.

        } else {

            text = buffer.toString();

        }

    }


    private static void insertLine(String workingText, Scanner inputValue) {

        StringBuffer buffer = new StringBuffer();

        String[] textArray = textToLineArray(workingText);
        int insertAt = 0;
        String newLine = "";

        boolean correctInputFlag = false;

        while (!correctInputFlag) {

            try {

                System.out.print("Insert at line number: ");
                insertAt = inputValue.nextInt();
                inputValue.nextLine();
        
                System.out.print("\nType your line: ");
                newLine = inputValue.nextLine();

                if (insertAt < textArray.length && insertAt >= 0) {

                    correctInputFlag = true;

                } else {

                    System.out.println("[Error]: Insertion index is out of bounds!");

                }

            } catch (Exception e) {

                System.out.println("[Error]: Wrong input, try again.");
                inputValue.nextLine(); // To prevent an infinite loop.

            }
        
        }

        if (insertAt != textArray.length -1) {

            for (int i = 0; i < insertAt; i++) {

                buffer.append(textArray[i]+"\n");
    
            }
    
            buffer.append(newLine+"\n");

            for (int i = insertAt; i < textArray.length; i++) {

                buffer.append(textArray[i]);

                if (i != textArray.length-1) {

                    buffer.append("\n");

                }

            }

            text = buffer.toString();

        } else {

            text = text + "\n" + newLine;

        }

    }


    private static boolean save(String workingText, Scanner inputValue) { // Returns true upon successful saving.

        try {

            System.out.print("Enter the path of the save file: ");
            File saveFile = new File(inputValue.nextLine());

            while (true) {

                if(saveFile.exists()) {

                    System.out.print("[Warning]: File alredy exists, do you want to continue? [Y/N]: ");
                    if(!inputValue.nextLine().equalsIgnoreCase("Y")) {

                        return false;

                    }

                }

                break;

            }

            FileWriter writer = new FileWriter(saveFile);
            writer.write(text);
            writer.close();
            return true;

        } catch (IOException e) {

            System.out.println("[ERROR]: Could not save file.");

        }

        return false;

    }


    private static void menu(Scanner inputValue) {

        System.out.print("\nActions:\n| 1 - Open File | 2 - Delete Line | 3 - Insert Line | 4 - Save | 5 - Exit |\nWrite your choice: ");

        switch (inputValue.nextLine()) {

            case "1":

                loadFileData(chooseFile(inputValue));
                unsavedChangesFlag = false;

            break;

            case "2": // Delete line.
                deleteLine(text, inputValue);
                unsavedChangesFlag = true;
            break;

            case "3": // Insert line.
                insertLine(text, inputValue);
                unsavedChangesFlag = true;
            break;

            case "4": // Save.
                if (save(text, inputValue)) {
                    unsavedChangesFlag = false;
                }
            break;

            case "5": // Exit.

                if (unsavedChangesFlag) {

                    System.out.print("[Warning]: There are unsaved changes, are you sure you want to continue? [Y/N]: ");
                    if (inputValue.nextLine().equalsIgnoreCase("Y")) {

                        exitCondition = true;

                    }

                } else {

                    exitCondition = true;

                }

            break;
        }

    }

    public static void main(String[] args) {

        Scanner inputValue = new Scanner(System.in); // Instance Scanner.

        System.out.println("---- TEXT EDITOR ----\n");

        loadFileData(chooseFile(inputValue));

        while (!exitCondition) {

            System.out.println("\n".repeat(100)); // Clear screen.
            displayText(text);
            menu(inputValue);

        }

        inputValue.close();

    }

}