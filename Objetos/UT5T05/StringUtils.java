// 13/01/2023 - Pedro Marín Sanchis

public class StringUtils {

    public static String surroundWithBox(String[] stringArray) { // Should be fed a String array where each element is a pure string without any newline characters.
        
        stringArray = padToSameLength(replace(stringArray, "\n", ""), ' ');
        String[] boxedStringArray = new String[stringArray.length + 2];

        // TOP AND BOTTOM LINE.

        boxedStringArray[0] = "╭" + "─".repeat(getLongestString(stringArray).length()) + "╮";
        boxedStringArray[boxedStringArray.length-1] = "╰" + "─".repeat(getLongestString(stringArray).length()) + "╯";

        // REST OF LINES.

        for (int i = 0; i < stringArray.length; i++) {
            boxedStringArray[i+1] = "│" + stringArray[i] + "│";
        }

        return stringArrayToString(boxedStringArray);

    }

    public static String stringArrayToString(String[] stringArray) {
        String returnString = "";

        for (int i = 0; i < stringArray.length; i++) {
            returnString = returnString + stringArray[i] + "\n";
        }

        return returnString.substring(0, returnString.length() - 1);
    }

    public static String[] replace(String[] stringArray, String target, String replacement) {
        for (int i = 0; i < stringArray.length; i++) {
            stringArray[i] = stringArray[i].replace(target, replacement);
        }
        return stringArray;
    }

    public static String[] padToSameLength(String[] stringArray, char padding) {
        int biggestLineLength = getLongestString(stringArray).length();
        for (int i = 0; i < stringArray.length; i++) {
            stringArray[i] = stringArray[i] + (padding + "").repeat(biggestLineLength - stringArray[i].length());
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
}
