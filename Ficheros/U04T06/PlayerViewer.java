// 21-11-2022 Pedro Marín Sanchis

// This program shows, combines and sorts player lists.

import java.util.Scanner;
import java.util.ArrayList;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class PlayerViewer {

    private static Boolean exitCondition = false; // Condition to exit the program.
    private static ArrayList<Player> playerList = new ArrayList<Player>(1);
    private static boolean fileLoadedFlag = false; // Check if file has been loaded at the start of the program.


    private static void cls(){ // Clear screen function.

        System.out.println("\n".repeat(100));

    }


    private static void showErrorMessage(String error, Scanner inputValue) { // Error funtion, waits for user input to continue.

        cls();
        System.out.print("[ERROR]: "+ error +"\nPress ENTER to continue: ");
        inputValue.nextLine();
        cls();

    }


    private static void menu(Scanner inputValue) {

        boolean correctInputFlag = false;

        try {

            while (!correctInputFlag) {

                correctInputFlag = true;

                System.out.println("| 0.- Exit | 1.- Load File | 2.- Sort | 3.- Combine with file | 4.- Save File | 5.- XML Menu | 6.- Generate Brazil |");
                System.out.print("Write your choice: ");

                switch (inputValue.nextLine()) {

                    case "0":
                        exitCondition = true;
                    break;

                    case "1":
                        loadPlayerArray(readPlayerFile(inputValue));
                    break;

                    case "2":
                        sortPlayers();
                    break;

                    case "3":
                        appendPlayerArray(readPlayerFile(inputValue));
                    break;

                    case "4":
                        exportToFile(playerList, inputValue);
                    break;

                    case "5":
                        XMLPlayerMenu(inputValue);
                    break;

                    case "6":
                        generateBrazil(inputValue);
                    break;

                    default:
                        correctInputFlag = false;
                        showErrorMessage("Incorrect option, try again.", inputValue);
                    break;

                }

            }

        } catch (Exception e) {
            showErrorMessage("Try again.", inputValue);
        }

    }


    private static void XMLPlayerMenu(Scanner inputValue) {

        boolean correctInputFlag = false;

        try {

            while (!correctInputFlag) {

                correctInputFlag = true;

                cls();

                System.out.println("| 0.- Exit | 1.- Load XML File | 2.- Append XML File | 3.- Export XML File |");
                System.out.print("Write your choice: ");

                switch (inputValue.nextLine()) {

                    case "0": break;

                    case "1":
                        playerList = XMLPlayer.loadXMLFile(selectFile(inputValue, false));
                        fileLoadedFlag = true;
                    break;

                    case "2":
                        playerList = XMLPlayer.appendXMLFile(playerList, selectFile(inputValue, false)); // Players will be appended to playerList argument from an XML file.
                        fileLoadedFlag = true;
                    break;

                    case "3":
                        XMLPlayer.exportXMLFile(playerList, selectFile(inputValue, true));
                    break;

                    default:
                        correctInputFlag = false;
                        showErrorMessage("Incorrect option, try again.", inputValue);
                    break;

                }

            }

        } catch (Exception e) {
            showErrorMessage("Try again.", inputValue);
        }

    }


    private static void showPlayers() { // Reads from playerList class variable.

        if (fileLoadedFlag) {

            if (playerList.size() != 0) {
               
                System.out.printf("%-8s%-8s%-15s%-25s%-8s%-8s%-15s\n\n","" , "ID", "Country", "Name", "Year", "Height", "Club");

                for (int i = 0; i < playerList.size(); i++) {
        
                    System.out.printf("%-8s%-8s%-15s%-25s%-8s%-8s%-15s\n","[" + (i+1) + "]", playerList.get(i).getCountryID(), 
                    playerList.get(i).getCountryName(), playerList.get(i).getPlayerName(), playerList.get(i).getBirthYear(), 
                    playerList.get(i).getPlayerHeight(), playerList.get(i).getClub());
        
                }


            } else {

                System.out.println("\t\t[ There are no players in this file ]\n");

            }

        } else {

            System.out.println("\t\t[ No file loaded yet ]\n");

        }

    }


    private static void loadPlayerArray(ArrayList<Player> list) {

        playerList.clear(); // Clears contents of arrayList.
        appendPlayerArray(list);

    }


    private static void appendPlayerArray(ArrayList<Player> list) {

        for (Player i: list) {

            playerList.add(i);

        }

    }


    private static ArrayList<Player> readPlayerFile(Scanner inputValue) {

        ArrayList<Player> list = new ArrayList<Player>(1);
        DataInputStream inputStream = null;

        try {

            inputStream = new DataInputStream(new FileInputStream(selectFile(inputValue, false)));

            while (inputStream.available() > 0) { // Read and append Player. Order goes as follows: countryID, countryName, playerName, birthYear, playerHeight, club.

                list.add(new Player(inputStream.readInt(), inputStream.readUTF(), inputStream.readUTF(), inputStream.readInt(), inputStream.readFloat(), inputStream.readUTF()));
            
            }

            inputStream.close();

        } catch (Exception e) {
            showErrorMessage("Try again.", inputValue);
        }

        fileLoadedFlag = true;

        return list;

    }


    private static void sortPlayers() {

        Player change; // Change variable for sorting.
        boolean sortedFlag = false;

        while (!sortedFlag) {

            sortedFlag = true;

            for (int i = 1; i < playerList.size(); i++) {

                if (playerList.get(i-1).getBirthYear() < playerList.get(i).getBirthYear()) {

                    sortedFlag = false;
                    change = playerList.get(i-1);
                    playerList.set(i-1, playerList.get(i));
                    playerList.set(i, change);

                }

            }

        }

    }


    private static void exportToFile(ArrayList<Player> list, Scanner inputValue) {

        DataOutputStream outputStream = null;

        if (!playerList.isEmpty()) {

            try {

                outputStream = new DataOutputStream(new FileOutputStream(selectFile(inputValue, true)));
                
                for (Player i: playerList) {

                    outputStream.writeInt(i.getCountryID());
                    outputStream.writeUTF(i.getCountryName());
                    outputStream.writeUTF(i.getPlayerName());
                    outputStream.writeInt(i.getBirthYear());
                    outputStream.writeFloat(i.getPlayerHeight());
                    outputStream.writeUTF(i.getClub());

                }

                outputStream.close();

            } catch (Exception e) {
                showErrorMessage("Try again.", inputValue);
            }

        } else {

            showErrorMessage("There is nothing to write.", inputValue);

        }

    }


    private static File selectFile(Scanner inputValue, boolean warnFileReplace) {

        File file=null;

        boolean correctInputFlag = false;
        
        while (!correctInputFlag) {

            try {

                System.out.print("Enter the path to the file: ");
                file = new File(inputValue.nextLine());

                if (file.exists() && warnFileReplace) {

                    cls();
                    System.out.print("[WARNING]: This action will overwrite the file. Do you wish to continue? [Y/N]: ");
                    switch (inputValue.nextLine()) {

                        case "Y": case "y":

                            correctInputFlag = true;

                        break;

                        case "N": case "n": break;

                        default:

                            correctInputFlag = false;
                            showErrorMessage("Incorrect option, try again.", inputValue);

                        break;

                    }

                } else {

                    correctInputFlag = true;

                }
                
            } catch (Exception e) {
                showErrorMessage("Try again.", inputValue);
            }

        }

        return file;

    }


    private static void generateBrazil(Scanner inputValue) {

        // Hardcode Brazil array

        Player[] brazilArray = new Player[26];

        brazilArray[0] = new Player(9, "Brazil", "Alisson", 1992, (float) 1.93, "Liverpool (ENG)");
        brazilArray[1] = new Player(9, "Brazil", "Weverton", 1987, (float) 1.89, "Palmeiras (BRA)");
        brazilArray[2] = new Player(9, "Brazil", "Ederson", 1993, (float) 1.88, "Manchester City (ENG)");
        brazilArray[3] = new Player(9, "Brazil", "Danilo", 1991, (float) 1.84, "Juventus (ITA)");
        brazilArray[4] = new Player(9, "Brazil", "Thiago Silva", 1984, (float) 1.83, "Chelsea (ENG)");
        brazilArray[5] = new Player(9, "Brazil", "Marquinhos", 1994, (float) 1.83, "PSG (FRA)");
        brazilArray[6] = new Player(9, "Brazil", "Alex Sandro", 1991, (float) 1.80, "Juventus (ITA)");
        brazilArray[7] = new Player(9, "Brazil", "Dani Alves", 1983, (float) 1.72, "UNAM (MEX)");
        brazilArray[8] = new Player(9, "Brazil", "Eder Militao", 1998, (float) 1.86, "Real Madrid CF (SPA)");
        brazilArray[9] = new Player(9, "Brazil", "Alex Telles", 1992, (float) 1.81, "Sevilla FC (SPA)");
        brazilArray[10] = new Player(9, "Brazil", "Bremer", 1997, (float) 1.88, "Juventus (ITA)");
        brazilArray[11] = new Player(9, "Brazil", "Casemiro", 1992, (float) 1.95, "Manchester United (ENG)");
        brazilArray[12] = new Player(9, "Brazil", "Lucas Paqueta", 1997, (float) 1.80, "West Ham United (ENG)");
        brazilArray[13] = new Player(9, "Brazil", "Fred", 1993, (float) 1.69, "Manchester United (ENG)");
        brazilArray[14] = new Player(9, "Brazil", "Fabinho", 1993, (float) 1.88, "Liverpool (ENG)");
        brazilArray[15] = new Player(9, "Brazil", "Bruno Guimaraes", 1997, (float) 1.82, "Newcastle United (ENG)");
        brazilArray[16] = new Player(9, "Brazil", "Everton Ribeiro", 1989, (float) 1.74, "Flamengo (BRA)");
        brazilArray[17] = new Player(9, "Brazil", "Richarlison", 1997, (float) 1.84, "Tottenham Hotspur (ENG)");
        brazilArray[18] = new Player(9, "Brazil", "Neymar Jr.", 1992, (float) 1.75, "PSG (FRA)");
        brazilArray[19] = new Player(9, "Brazil", "Raphinha", 1996, (float) 1.76, "FC Barcelona (SPA)");
        brazilArray[20] = new Player(9, "Brazil", "Gabriel Jesus", 1997, (float) 1.75, "Arsenal (ENG)");
        brazilArray[21] = new Player(9, "Brazil", "Antony", 2000, (float) 1.72, "Manchester United (ENG)");
        brazilArray[22] = new Player(9, "Brazil", "Vinicius Junior", 2000, (float) 1.76, "Real Madrid CF (SPA)");
        brazilArray[23] = new Player(9, "Brazil", "Rodrygo", 2001, (float) 1.74, "Real Madrid CF (SPA)");
        brazilArray[24] = new Player(9, "Brazil", "Pedro", 1997, (float) 1.85, "Flamengo (BRA)");
        brazilArray[25] = new Player(9, "Brazil", "Gabriel Martinelli", 2001, (float) 1.78, "Arsenal (ENG)");

        // "Generate Brazil" Menu

        boolean correctInputFlag = false;

        cls();

        try {

            while (!correctInputFlag) {

                correctInputFlag = true;

                System.out.println("\t--> BRAZIL GENERATOR <--\n");
                System.out.println("| 0.- Export as file | 1.- Load into program |");
                System.out.print("Write your choice: ");

                switch (inputValue.nextLine()) {

                    case "0":

                        ArrayList<Player> list = new ArrayList<Player>(1);

                        for (Player i: brazilArray) {

                            list.add(i);

                        }

                        exportToFile(list, inputValue);

                    break;

                    case "1":

                        cls();
                        System.out.print("[WARNING]: This will overwrite the currently loaded players. Do you wish to continue? [Y/N]: ");
                        switch (inputValue.nextLine()) {

                            case "Y": case "y":

                                fileLoadedFlag = true;
                                playerList.clear();
                                for (Player i: brazilArray) {

                                    playerList.add(i);

                                }

                            break;

                            case "N": case "n": break;

                            default:

                                correctInputFlag = false;
                                showErrorMessage("Incorrect option, try again.", inputValue);
                            
                            break;

                        }

                    break;

                    case "2":



                    break;

                    case "3":

                        generateBrazil(inputValue);

                    break;

                    default:

                        correctInputFlag = false;
                        showErrorMessage("Incorrect option, try again.", inputValue);

                    break;

                }

            }

        } catch (Exception e) {
            showErrorMessage("Incorrect option, try again.", inputValue);
        }

    }


    public static void main(String[] args) {

        Scanner inputValue = new Scanner(System.in);

        while (!exitCondition) {

            cls();
            showPlayers();
            menu(inputValue);

        }

    }

}