// 21-11-2022 Pedro Marín Sanchis


// This program shows, combines and sorts player lists.

import java.util.Scanner;
import java.util.ArrayList;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.security.spec.ECFieldF2m;
import java.text.FieldPosition;

public class PlayerViewer {

    private static Boolean exitCondition = false;
    private static ArrayList<Player> playerList = new ArrayList<Player>(1);
    private static boolean fileLoadedFlag = false;


    private static void cls(){ // Clear screen function.

        System.out.println("\n".repeat(100));

    }


    private static void menu(Scanner inputValue) {

        boolean correctInputFlag = false;

        try {

            while (!correctInputFlag) {

                correctInputFlag = true;

                System.out.println("| 0.- Exit | 1.- Load File | 2.- Sort | 3.- Combine with file | 4.- Save File | 5.- Generate Brazil |");
                System.out.print("Write your choice: ");

                switch (inputValue.nextLine()) {

                    case "0":

                        exitCondition = true;

                    break;

                    case "1":

                        loadPlayerArray(readPlayerFile(inputValue));

                    break;

                    case "2":

                        //sort();

                    break;

                    case "3":

                        appendPlayerArray(readPlayerFile(inputValue));

                    break;

                    case "4":

                        exportToFile(playerList, inputValue);

                    break;

                    case "5":

                        generateBrazil(inputValue);

                    break;

                    default:

                        correctInputFlag = false;
                        cls();
                        System.out.print("[ERROR]: That is not a correct option, try again.\nPress ENTER to continue: ");
                        inputValue.nextLine();
                        cls();

                    break;

                }

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }


    private static void showPlayers() {

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


    private static void loadPlayerArray(ArrayList<Player> playerList) {

        playerList.clear();
        appendPlayerArray(playerList);

    }


    private static void appendPlayerArray(ArrayList<Player> list) {

        for (Player i: list) {

            playerList.add(i);

        }

    }


    private static ArrayList<Player> readPlayerFile(Scanner inputValue) {

        ArrayList<Player> list = new ArrayList<Player>(1);
        File file;
        DataInputStream inputStream;

        boolean correctInputFlag = false;

        try {
            inputStream = new DataInputStream(new FileInputStream(selectFile(inputValue)));
            while (inputStream.available() > 0) {

                inputStream.readInt();
                inputStream.readUTF();
                inputStream.readUTF(); // Por aqui me he quedado.
            
            }
        } catch (Exception e) {
            
        }

        fileLoadedFlag = true;



        return list;

    }


    private static void exportToFile(ArrayList<Player> list, Scanner inputValue) {

        DataOutputStream outputStream;

            try {

                outputStream = new DataOutputStream(new FileOutputStream(selectFile(inputValue)));
                
                for (Player i: playerList) {

                    outputStream.writeInt(i.getCountryID());
                    outputStream.writeUTF(i.getCountryName());
                    outputStream.writeUTF(i.getPlayerName());
                    outputStream.writeInt(i.getBirthYear());
                    outputStream.writeFloat(i.getPlayerHeight());
                    outputStream.writeUTF(i.getClub());

                }
            } catch (Exception e) {
                cls();
                System.out.print("[ERROR]: Try Again.\nPress ENTER to continue: ");
                inputValue.nextLine();
                cls();
            }

    }


    private static File selectFile(Scanner inputValue) {

        File file=null;

        boolean correctInputFlag = false;
        
        while (!correctInputFlag) {

            try {

                System.out.println("Enter the path to the file: ");
                file = new File(inputValue.nextLine());

                if (file.exists()) {

                    cls();
                    System.out.print("[WARNING]: File alredy exists. Do you wish to continue? [Y/N]: ");
                    switch (inputValue.nextLine()) {

                        case "Y": case "y":

                            correctInputFlag = true;

                        break;

                        case "N": case "n": break;

                        default:

                            correctInputFlag = false;
                            cls();
                            System.out.print("[ERROR]: That is not a correct option, try again.\nPress ENTER to continue: ");
                            inputValue.nextLine();
                            cls();

                        break;

                    }

                } else {

                    correctInputFlag = true;

                }
                
            } catch (Exception e) {
                cls();
                System.out.print("[ERROR]: Try Again.\nPress ENTER to continue: ");
                inputValue.nextLine();
                cls();
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
                                cls();
                                System.out.print("[ERROR]: That is not a correct option, try again.\nPress ENTER to continue: ");
                                inputValue.nextLine();
                                cls();
                            
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
                        cls();
                        System.out.print("[ERROR]: That is not a correct option, try again.\nPress ENTER to continue: ");
                        inputValue.nextLine();
                        cls();

                    break;

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
            showPlayers();
            menu(inputValue);

        }

    }

}