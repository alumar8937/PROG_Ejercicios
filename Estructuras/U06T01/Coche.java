public class Coche {
    private String nombre = "";

    public Coche(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

}