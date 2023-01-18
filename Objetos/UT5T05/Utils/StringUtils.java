// 13/01/2023 - Pedro Marín Sanchis

package Utils;

import java.util.concurrent.TimeUnit;

public class StringUtils {

    public static String[] surroundStringArrayWithBox(String[] stringArray) { // Should be fed a String array where each element is a pure string without any newline characters.
        
        stringArray = padToSameLength(replaceInStringArray(stringArray, "\n", ""), ' ');
        String[] boxedStringArray = new String[stringArray.length + 2];

        // TOP AND BOTTOM LINE.

        boxedStringArray[0] = "┌" + "─".repeat(getLongestString(stringArray).length()) + "┐";
        boxedStringArray[boxedStringArray.length-1] = "└" + "─".repeat(getLongestString(stringArray).length()) + "┘";

        // REST OF LINES.

        for (int i = 0; i < stringArray.length; i++) {
            boxedStringArray[i+1] = "│" + stringArray[i] + "│";
        }

        return boxedStringArray;

    }

    public static String[] surroundStringArrayWithBox(String string) {
        return surroundStringArrayWithBox(new String[]{string});
    }

    public static String surroundStringWithBox(String string) {
        return stringArrayToString(surroundStringArrayWithBox(new String[]{string}));
    }

    public static String stringArrayToString(String[] stringArray) {
        String returnString = "";

        for (int i = 0; i < stringArray.length; i++) {
            returnString = returnString + stringArray[i] + "\n";
        }

        return returnString.substring(0, returnString.length() - 1);
    }

    public static String[] replaceInStringArray(String[] stringArray, String target, String replacement) {
        for (int i = 0; i < stringArray.length; i++) {
            stringArray[i] = stringArray[i].replace(target, replacement);
        }
        return stringArray;
    }

    public static String[] padToSameLength(String[] stringArray, char padding) {
        int biggestLineLength = getLongestString(stringArray).length();
        int paddingAmmount;

        for (int i = 0; i < stringArray.length; i++) {
            if (biggestLineLength - stringArray[i].length() <= 0) {paddingAmmount = 0;} else {paddingAmmount = biggestLineLength - stringArray[i].length();}
            stringArray[i] = stringArray[i] + (padding + "").repeat(paddingAmmount);
        }
        return stringArray;
    }

    public static String[] appendToStringArray(String[] stringArray, String append) {
        for (int i = 0; i < stringArray.length; i++) {
            stringArray[i] = stringArray[i] + append;
        }
        return stringArray;
    }

    public static String getLongestString(String[] stringArray) {
        String biggestString = stringArray[0];

        for (int i = 1; i < stringArray.length; i++) {

            if (stringArray[i - 1].length() < stringArray[i].length()){biggestString = stringArray[i];}

        }

        return biggestString;
    }

    public static void revealString(String string, int speed_ms) {
        for (int j = 0; j < string.length(); j++){
            try {
                TimeUnit.MILLISECONDS.sleep(speed_ms);
                System.out.print(string.charAt(j));
            } catch (InterruptedException e) {}
        }
    }

    public static String removeNonNumbers(String string) {
        return string.replaceAll("[^0-9]", "");
    }

    public static String removeNonLetters(String string) {
        return string.replaceAll("[^A-Za-z]", "");
    }

}
