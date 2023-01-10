public class Camion {

    private int capacidadVolumen; //m^3

    private int capacidadPeso; // kg

    private String matricula;

    public Camion (int capacidadVolumen, int capacidadPeso, String matricula) {

        this.capacidadVolumen = capacidadVolumen;
        this.capacidadPeso = capacidadPeso;
        this.matricula = matricula;

    }

    public int getCapacidadVolumen() {
        return capacidadVolumen;
    }
    
    public int getCapacidadPeso() {
        return capacidadPeso;
    }
    
    public String getMatricula() {
        return matricula;
    }

    public boolean cabeBulto(Bulto bulto) {

        return (capacidadVolumen <= bulto.getVolumen() && capacidadPeso <= bulto.getPeso());

    }
    
}
