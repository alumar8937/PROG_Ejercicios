// 20/12/2022 Pedro Marín Sanchis

public class Main3 {

    public static void main(String[] args) {

        Segmento s1 = new Segmento(new Punto(4, 5), new Punto(6,8));
        System.out.println(s1.toString());
        System.out.println("Longitud: " + s1.longitud());
        s1.desplaza(4, 3);
        System.out.println(s1.toString());
        System.out.println("Longitud: " + s1.longitud());

    }
    
}
