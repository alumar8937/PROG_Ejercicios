package PedroMarinSanchis.Ejercicio4;

import PedroMarinSanchis.Ejercicio3.*;
import java.io.File;
import java.util.Scanner;

public class MainE4 {
    private static Scanner inputValue = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            System.out.println("Introduce el nombre de la saga (Harry Potter) :");
            GestorSaga.setSaga(LectorXMLBiblioteca.cargarSaga(inputValue.nextLine(), new File("PedroMarinSanchis/Ejercicio3/bibliotecaDigital.xml")));
            GestorSaga.mostrarSaga();
            ExportadorDeSagasXML.exportarSaga(GestorSaga.getSaga(), new File("PedroMarinSanchis/Ejercicio4/"+GestorSaga.getSaga().getTitle()+".xml"));
        } catch (Exception e) {}
        inputValue.close();
    }
}
