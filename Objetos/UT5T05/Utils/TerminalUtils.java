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

    public static void moveCursorBack(int characters) {
        for (int i = 0; i < characters; i++) {System.out.print("\b");}
    }

    public static void moveCursorToEnd() {
        System.out.print("\033[B".repeat(250));
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
