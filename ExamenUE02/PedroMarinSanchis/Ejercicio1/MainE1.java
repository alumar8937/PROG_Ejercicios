package PedroMarinSanchis.Ejercicio1;

public class MainE1 {
    public static void main(String[] args) {
        Bicicleta bici = new Bicicleta("BH Gacela", 10, 2, 4);
        System.out.println(bici.toString());
        bici.cambiarPinyon(5);
        bici.cambiarPinyon(7);
        bici.cambiarPlato(3);
        bici.cambiarPlato(7);
        System.out.println(bici.toString());
        bici.acelerar();
        System.out.println(bici.toString());
        bici.parar();
        System.out.println(bici.toString());
    }
}
