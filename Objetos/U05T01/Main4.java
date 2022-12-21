// 21/12/2022 Pedro Marín Sanchis

public class Main4 {
    public static void main(String[] args) {
        Poligono p = new Poligono(new Punto[]{new Punto(2, 0),new Punto(0, 4),new Punto(-2, 0)});
        System.out.println(p.toString());
        System.out.println(p.obtenerPerimetro());
        p.desplaza(1, 2);
        System.out.println(p.toString());
        System.out.println(p.obtenerPerimetro());
    }
}
