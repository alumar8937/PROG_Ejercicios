import java.util.Scanner;
import Utils.*;

// 13/01/2023 - Pedro Marín Sanchis

public class BattleshipGame {

    private static final String MENU_TEXT = "          ┌┐ ┌─┐┌┬┐┌┬┐┬  ┌─┐┌─┐┬ ┬┬┌─┐          \n     ───  ├┴┐├─┤ │  │ │  ├┤ └─┐├─┤│├─┘  ───     \n────────  └─┘┴ ┴ ┴  ┴ ┴─┘└─┘└─┘┴ ┴┴┴    ────────\n            COMMAND-LINE EDITION V.0\n \n \n            Press ENTER to continue:";
    private static Scanner inputValue = new Scanner(System.in);
    private static final boolean RENDER_COLORS = true;

    public static void main(String[] args) {
        TerminalUtils.hideCursor();
        showTitle();
        menu();
    }

    private static void enterToContinue() {
        System.out.print("Press ENTER to continue:");
        inputValue.nextLine();
    }

    private static void showMessage(String message) {
        TerminalUtils.cls();
        System.out.println(message);
        enterToContinue();
    }

    private static String askUserForString(String message) {
        TerminalUtils.cls();
        System.out.print(message);;
        return inputValue.nextLine();
    }

    private static boolean askUserForConfirmation(String message) {
        TerminalUtils.cls();
        System.out.print(message);
        return (inputValue.nextLine().equalsIgnoreCase("Y"));
    }

    private static void showTitle() {
        TerminalUtils.cls();
        StringUtils.revealString(MENU_TEXT, 10);
        TerminalUtils.moveCursorUp(200);
        inputValue.nextLine();
    }

    private static void showLegend() {
        TerminalUtils.cls();
        StringUtils.revealString("   LEGEND\n███  SHIP CELL\n▓╬▓  HIT CELL\n X   MISS CELL\n ·   EMPTY CELL", 50);
        enterToContinue();
    }

    private static void exitMessage() {
        TerminalUtils.cls();
        StringUtils.revealString("\nTHANK YOU FOR PLAYING!", 10);
        StringUtils.revealString("\n \n \n ", 500);
        TerminalUtils.cls();
    }

    private static void menu() {

        while (true) {
            TerminalUtils.cls();
            System.out.println("| 1.- Play Against CPU | 2.- | 3.- | 4.- Quit Game |");
            switch(inputValue.nextLine()) {
                case "1":
                    showLegend();
                    play();
                    break;

                case "2":
                    break;
            
                case "3":
                    break;
            
                case "4":
                    exitMessage();
                    inputValue.close(); // Close Scanner before exiting.
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }

    }

    private static void play() {
        Player player = new Player(askUserForString("Write your name: "), RENDER_COLORS);
        if (RENDER_COLORS) {
            if (!askUserForConfirmation("· Use default board color? [Y/N]:")) {
                    player.getPlayerBoard().setBoardColor(choseColor());
            }
        }
        TerminalUtils.cls();
        player.getPlayerBoard().cells[1][1].setCellType(Cell.CellType.SHIP);
        printFormattedBoard(player.getPlayerBoard(), "ENTER FIRE COORDINATES:");
        inputValue.nextLine();
    }

    private static void printFormattedBoard(Board board, String message) {
        String boardString = board.toString(false);
        int boardStringLength = boardString.split("\n")[0].length();
        int fireStringPadding = boardStringLength - message.length() - 3;
        String fireString = StringUtils.stringArrayToString(StringUtils.surroundStringWithBox(" " + message + " ".repeat(fireStringPadding)));
        boardString = boardString + "\n" + fireString;
        //boardString = StringUtils.stringArrayToString(StringUtils.surroundStringWithBox(StringUtils.padToSameLength(boardString.split("\n"), ' ')));
        
        if (RENDER_COLORS) {
            boardString = board.colorize(board.boardColor + boardString + ConsoleColors.RESET);
        }

        System.out.print(boardString);
        
        TerminalUtils.moveCursorUp(1);
        TerminalUtils.moveCursorBack(fireStringPadding);
    }

    private static String choseColor() {
        while (true) {
            TerminalUtils.cls();
            System.out.println("    COLOR TABLE");
            System.out.println("· 1: " + ConsoleColors.RED + "███" + ConsoleColors.RESET + " Red.");
            System.out.println("· 2: " + ConsoleColors.GREEN + "███" + ConsoleColors.RESET + " Green.");
            System.out.println("· 3: " + ConsoleColors.YELLOW + "███" + ConsoleColors.RESET + " Yellow.");
            System.out.println("· 4: " + ConsoleColors.BLUE + "███" + ConsoleColors.RESET + " Blue.");
            System.out.println("· 5: " + ConsoleColors.PURPLE + "███" + ConsoleColors.RESET + " Purple.");
            System.out.println("· 6: " + ConsoleColors.CYAN + "███" + ConsoleColors.RESET + " Cyan.");
            System.out.println("· 7: " + ConsoleColors.WHITE + "███" + ConsoleColors.RESET + " White.");
            System.out.print("Chose a color: ");

            switch (inputValue.nextLine()) {
                case "1":
                    return ConsoleColors.RED;
                case "2":
                    return ConsoleColors.GREEN;
                case "3":
                    return ConsoleColors.YELLOW; 
                case "4":
                    return ConsoleColors.BLUE;
                case "5":
                    return ConsoleColors.PURPLE;
                case "6":
                    return ConsoleColors.CYAN;
                case "7":
                    return ConsoleColors.WHITE;  

            }

        }
    }

}
