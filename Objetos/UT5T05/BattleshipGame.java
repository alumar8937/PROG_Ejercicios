import java.util.Scanner;
import Utils.*;

// 13/01/2023 - Pedro Marín Sanchis

public class BattleshipGame {

    private static final String MENU_TEXT = "          ┌┐ ┌─┐┌┬┐┌┬┐┬  ┌─┐┌─┐┬ ┬┬┌─┐          \n     ───  ├┴┐├─┤ │  │ │  ├┤ └─┐├─┤│├─┘  ───     \n────────  └─┘┴ ┴ ┴  ┴ ┴─┘└─┘└─┘┴ ┴┴┴    ────────\n            COMMAND-LINE EDITION V.0\n \n \n            Press ENTER to continue:";
    final static private String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static Scanner inputValue = new Scanner(System.in);
    private static final boolean RENDER_COLORS = true;

    public static void main(String[] args) {
        TerminalUtils.hideCursor();
        //playClassic();
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
        StringUtils.revealString("   LEGEND\n███  SHIP \n▓╬▓  HIT  \n X   MISS CELL \n ·   EMPTY\n", 50);
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
            showMenuText();
            switch(inputValue.nextLine()) {
                case "1":
                    showLegend();
                    playClassic();
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

    private static void showMenuText() {
        TerminalUtils.cls();
        System.out.println(StringUtils.stringArrayToString(
            StringUtils.surroundStringWithBox(
                " 1.- Play Classic | 2.- Play Against CPU | 3.- ??? | 4.- Quit Game ")));
        System.out.print(StringUtils.stringArrayToString(
            StringUtils.surroundStringWithBox(
                " ENTER CHOICE:" + " ".repeat(11))));
        TerminalUtils.moveCursorUp(1);
        TerminalUtils.moveCursorBack(11);
    }

    private static void playClassic() { // In classic mode you only see the enemy board. It's implemented in a way that you actually shoot the board you're controlling.

        Player enemy = new Player("ENEMY", RENDER_COLORS);
        if (RENDER_COLORS) {
            if (!askUserForConfirmation("· Use default board color? [Y/N]:")) {
                    enemy.getBoard().setBoardColor(choseColor());
            }
        }

        enemy.getBoard().cells[0][0].setCellType(Cell.CellType.SHIP);
        enemy.getBoard().cells[0][1].setCellType(Cell.CellType.SHIP);
        enemy.getBoard().cells[2][0].setCellType(Cell.CellType.SHIP);
        enemy.getBoard().cells[2][1].setCellType(Cell.CellType.SHIP);
        enemy.getBoard().cells[5][4].setCellType(Cell.CellType.SHIP);

        BoardView enemyView = new BoardView(enemy.getBoard());

        while (true) {
            TerminalUtils.cls();
            printFormattedBoard(enemyView, "ENTER FIRE COORDINATES:");
            if(shoot(enemyView)) {
                TerminalUtils.cls();
                System.out.print("                     ");
                //StringUtils.revealString("HIT!\n\nPress ENTER to continue:", 50);
                inputValue.nextLine();
            } else {
                TerminalUtils.cls();
                System.out.print("                     ");
                //StringUtils.revealString("MISS!\n\nPress ENTER to continue:", 50);
                inputValue.nextLine();
            }
        }

    }

    private static boolean shoot(BoardView board) {
        
        String userInput = "";
        int row = 0;
        int column = 0;

        userInput = inputValue.nextLine();
        if (userInput.length() != 0) {
            column  = ALPHABET.indexOf((userInput.charAt(0)+"").toLowerCase());
            row = Integer.parseInt(userInput.substring(1, userInput.length()));
    
            if (row < board.getRowNumber() && column < board.getColumnNumber()) {
                return board.revealCell(row, column);
            }
        }
        
        return false;

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
