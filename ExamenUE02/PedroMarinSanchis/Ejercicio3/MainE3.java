package PedroMarinSanchis.Ejercicio3;

import java.io.File;
import java.util.Scanner;

public class MainE3 {

    private static Scanner inputValue = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            System.out.println("Introduce el nombre de la saga (Harry Potter) :");
            GestorSaga.setSaga(LectorXMLBiblioteca.cargarSaga(inputValue.nextLine(), new File("PedroMarinSanchis/Ejercicio3/bibliotecaDigital.xml")));
            GestorSaga.mostrarSaga();
        } catch (Exception e) {}
        inputValue.close();
    }

}
