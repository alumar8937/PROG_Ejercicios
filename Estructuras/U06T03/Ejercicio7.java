import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Ejercicio7 {

    private static HashMap<String, ArrayList<String>> wordMap = new HashMap<String, ArrayList<String>>();
    private static final int minGroupSize = 7;
    public static void main(String[] args) throws IOException {
        cargarPalabras(new FileReader("spanish-dict.txt"));
        mostrarPalabras(minGroupSize);
    }

    private static void cargarPalabras(FileReader file) throws IOException {
        BufferedReader reader = new BufferedReader(file);
	    String word;
	    while ((word = reader.readLine()) != null) {
            ArrayList<String> anagramList = wordMap.get(alfabetizar(word));
            if (anagramList == null) {
                anagramList = new ArrayList<String>();
            }
            if (!anagramList.contains(word)) {
                anagramList.add(word);
            }
	        wordMap.put(alfabetizar(word), anagramList);
	    }
	    reader.close();
    }

    private static String alfabetizar(String word) {
        char[] wordArray = word.toCharArray();
        Arrays.sort(wordArray);
        return new String(wordArray);
    }

    private static void mostrarPalabras(int minGroupSize) {
        for (String key: wordMap.keySet()) {
            if (wordMap.get(key).size() >= minGroupSize) {
                System.out.print("\nPalabra: "+key+" Valores:");
                for (String value: wordMap.get(key)) {
                    System.out.print(" "+value);
                }
            }
        }
        System.out.println();
    }

}
