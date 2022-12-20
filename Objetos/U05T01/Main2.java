// 20/12/2022 Pedro Marín Sanchis

public class Main2 {

    public static void main(String[] args) {

        Punto p1 = new Punto(4, 5);
        Punto p2 = new Punto(6, 8);

        p1.desplaza(3, 1);
        p2.desplaza(3, 1);

        System.out.println(p1.toString());
        System.out.println(p2.toString());
        
    }
    
}
