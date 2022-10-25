public class Utilities {

    static String[] divideStringIntoWords(String string) {

        string = string.trim(); // Remove spaces at the beginning and end

        string = string.replaceAll(" +", " "); // Remove additional spaces

        return string.split(" ");

    }

}