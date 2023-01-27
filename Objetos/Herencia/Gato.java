public class Gato extends Mamifero implements Jugar {
    
    public Gato(String nombre) {
        super(nombre);
    }

    public void comunicarse() {
        System.out.println("Miau");
    }

    public void jugarConOvillos() {
        System.out.println("Me gusta jugar con ovillos");
    }

}
