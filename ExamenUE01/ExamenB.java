// -- 07/11/2022 -- Pedro Marín Sanchis -- Examen UE01 Programación (Modelo B)

import java.util.Scanner;

public class ExamenB {

    private static String textDeTreball = "Text de treball"; //  Text de treball predeterminat.

    // Arrays de caracters permesos dintre del String "textDeTreball".

    private static char[] caractersPermesos = "abcdefghijklmnopqrstuvwxyzçÇABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ".toCharArray();
    private static char[] vocalsArray = "aiueoAIUEO".toCharArray();
    private static char[] numerosArray = "0123456789".toCharArray();


    private static void ordenarParaules() {

        String[] paraules = textDeTreball.toLowerCase().trim().replaceAll(" +", " ").split(" "); // Crear array de paraules.

        String pase = ""; // Per a moure de lloc les paraules en l'Array.

        boolean paraulesOrdenades = false;

        while (!paraulesOrdenades) {

            for (int i = 0; i < paraules.length - 1; i++) {

                paraulesOrdenades = true;

                if (paraules[i].length() > paraules[i+1].length()) {

                    // Intercanvi entre les dues paraules.
                    
                    pase = paraules[i];
                    paraules[i] = paraules[i+1];
                    paraules[i+1] = pase;

                    paraulesOrdenades = false;

                }

            }

        }

        // Escribim resultat al String textDeTreball.

        textDeTreball = "";

        for (String i: paraules) {

            textDeTreball = textDeTreball + i + " ";

        }

        textDeTreball = textDeTreball.trim(); // Per a eliminar l'espai sobrant al final del text.

    }


    private static void eliminarParaula(String paraula) {

        textDeTreball = textDeTreball.replaceAll(paraula, "").replaceAll(" +", " ");

    }


    private static void mostrarEstadistiques() {

        // Declaracio de variables

        int paraules = 0;
        int vocals = 0;
        int consonants = 0;
        int numeros = 0;
        double percentatge = 0;

        // Numero de vocals, consonants y numeros.
       
        for (int i = 0; i < textDeTreball.length(); i++) {

            for (char j: vocalsArray) {

                if (textDeTreball.charAt(i) == j) {

                    vocals++;

                }

            }

            for (char j: numerosArray) {

                if (textDeTreball.charAt(i) == j) {

                    numeros++;

                }

            }

        }

        // Cuantitat de paraules.

        if (textDeTreball.length() != 0) { // Si la longitud del text de treball es 0 els valors predeterminats son vertaders.

            paraules = textDeTreball.trim().replaceAll(" +", " ").length() - textDeTreball.replace(" ", "").length() + 1; // Trobem la cuantitat de paraules en la cuantitat d'espais + 1
            consonants = textDeTreball.replace(" ", "").length() - vocals - numeros; //  Calcular consonants.
            percentatge = (double) numeros / textDeTreball.length() * 100; // Calcular percentatge de numeros.

        }

        // Mostra resultats.

        System.out.print("\n--- ESTADISTIQUES ---\n");
        System.out.println("Cuantitat de paraules: " + paraules);
        System.out.println("Cuantitat de vocals: " + vocals);
        System.out.println("Cuantitat de consonants: " + consonants);
        System.out.println("Percentatge de numeros en el text: " + percentatge + "%");

    }


    private static void corregirText(String text) { // Elimina els caracters no permesos al String textDeTreball.

        textDeTreball = ""; // Eliminem el contingut [Encara existeix en el agrument "text" de la funcio].

        boolean caracterCorrecte = false;

        for (int i = 0; i < text.length(); i++) {

            caracterCorrecte = false;

            for (char j: caractersPermesos) {

                if (text.charAt(i) == j) {caracterCorrecte = true;}

            }

            if (caracterCorrecte) {

                textDeTreball = textDeTreball + text.charAt(i);

            }

        }

    }
    

    public static void main(String[] args) {

        Scanner inputValue = new Scanner(System.in); // Inicialitzem l'escaner.
        boolean finalizarPrograma = false; // Condicio d'eixida.

        // Bucle principal del programa.
        
        while (!finalizarPrograma) {

            System.out.print("\n-1 Introduir nou text.\n-2 Mostrar Estadístiques.\n-3 Eliminar paraula.\n-4 Ordenar paraules.\n-5 Finalitzar el programa.\nText actual:" + '"' + textDeTreball + '"' + "\nLa teva opció de treball (1-5):");
            
            switch (inputValue.nextLine()) {

                case "1":
                    System.out.print("\nInrodueix el nou text:");
                    corregirText(inputValue.nextLine());
                break;

                case "2":
                    mostrarEstadistiques();
                break;

                case "3":
                    System.out.print("\nInrodueix la paraula a eliminar:"); // [Asumim que la entrada es valida].
                    eliminarParaula(inputValue.nextLine());
                break;

                case "4":
                    ordenarParaules();
                break;

                case "5":
                    finalizarPrograma = true;
                break;

                default:
                    System.out.println("\n¡Error! Intentalo de nuevo.");
                break;

            }

        }

        inputValue.close(); // Tanquem l'escaner.

    }

}