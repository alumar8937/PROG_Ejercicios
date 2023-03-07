import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Ejercicio2 {

    private static ArrayList<Double> alturas = new ArrayList<>();
    private static Scanner inputValue = new Scanner(System.in);
    public static void main(String[] args) {

        leerAlturas(alturas, numeroAlumnos());
        mostrarResultados(alturas, calcularMedia(alturas));

    }

    private static void leerAlturas(ArrayList<Double> alturas, int numeroAlumnos) {
        while (numeroAlumnos > 0) {
            System.out.print("Introduce la altura del alumno: ");
            Double altura = inputValue.nextDouble();
            inputValue.nextLine();
            alturas.add(altura);
        }
    }

    private static int numeroAlumnos() {
        System.out.print("Introduce el número de alumnos: ");
        int numeroAlumnos = inputValue.nextInt();
        inputValue.nextLine();
        return numeroAlumnos;
    }

    private static double calcularMedia(ArrayList<Double> alturas) {
        Iterator<Double> iterador = alturas.iterator();
        double sum = 0;
        while (iterador.hasNext()) {
            sum += iterador.next();
        }
        return sum/alturas.size();
    }

    private static int calcularAlumnosAlturaSuperior(ArrayList<Double> alturas) {
        double media = calcularMedia(alturas);
        int total = 0;
        Iterator<Double> iterador = alturas.iterator();
        while (iterador.hasNext()) {
            if (iterador.next() > media) {
                total++;
            }
        }
        return total;
    }

    private static int calcularAlumnosAlturaInferior(ArrayList<Double> alturas) {
        double media = calcularMedia(alturas);
        int total = 0;
        Iterator<Double> iterador = alturas.iterator();
        while (iterador.hasNext()) {
            if (iterador.next() < media) {
                total++;
            }
        }
        return total;
    }

    private static void mostrarResultados(ArrayList<Double> alturas, double media) {
        System.out.println("La altura media es: " + media);
        System.out.println("La cantidad de alumnos por encima de la media son: " + calcularAlumnosAlturaSuperior(alturas));
        System.out.println("La cantidad de alumnos por debajo de la media son: " + calcularAlumnosAlturaInferior(alturas));
    }

}
