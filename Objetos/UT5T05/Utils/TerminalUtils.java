// 13/01/2023 - Pedro Marín Sanchis

// ASCII Control Characters for Terminal Output Formatting

package Utils;

public class TerminalUtils {

    public static void showCursor() {
        System.out.print("\033[?25h");
    }

    public static void hideCursor() {
        System.out.print("\033[?25l");
    }

    public static void moveCursorUp(int lines) {
        System.out.print("\033[A".repeat(lines));
    }

    public static void moveCursorDown(int lines) {
        System.out.print("\033[B".repeat(lines));
    }

    public static void moveCursorForward(int characters) {
        System.out.print("\033[C".repeat(characters));
    }

    public static void moveCursorBack(int characters) {
        System.out.print("\b".repeat(characters));
    }

    public static void moveCursorToEnd() {
        moveCursorDown(250);
        moveCursorForward(250);        
    }

    public static void cls() {
        System.out.print("\033[2J");
    }

    public static void clsFromCursorToEnd() {
        System.out.print("\033[0J");
    }

    public static void clsFromCursorToBeginning() {
        System.out.print("\033[1J");
    }
    
}
