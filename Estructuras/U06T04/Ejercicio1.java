import java.util.HashSet;

public class Ejercicio1 {
    public static void main(String[] args) {
        HashSet<String> hash = new HashSet<String>(){{
            add("Hola");
            add("Mundo");
        }};
        System.out.println(hash); // Resultado: [Mundo, Hola]
        hash.add("Mundo"); // No se permiten duplicados
        System.out.println(hash); // Resultado: [Mundo, Hola]
    }
}