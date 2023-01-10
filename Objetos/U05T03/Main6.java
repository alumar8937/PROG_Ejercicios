// 10/01/2023 Pedro Marín Sanchis

public class Main6 {
    public static void main(String[] args) {
        Rectangulo[] rectangulos = new Rectangulo[10];
        Rectangulo r = new Rectangulo(new Segmento(new Punto(2, 2), new Punto(5,8)));
        System.out.println(r.toString());
        for (int i = 0; i < 10; i++) {
            rectangulos[i] = new Rectangulo(new Punto(i,i), new Punto(i+3,i+2));
            System.out.println("Array en posición [" + i + "]: " + rectangulos[i].toString());
        }
    }
}
