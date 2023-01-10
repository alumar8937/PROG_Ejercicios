import java.util.ArrayList;

public class Mudanza {

    final private static double precioKilometro = 2; // €
    final private static double precioKilogramo = 1; // €
    final private static double precioKilogramoFragil = 4; // €

    private int id;
    private Camion camion;
    private int distancia; // km
    private ArrayList<Bulto> bultos = new ArrayList<>();

    public Mudanza (int id, Camion camion, int distancia) {

        this.id = id;
        this.camion = camion;
        this.distancia = distancia;

    }

    public int calcularPesoTotal() {

        int pesoTotal = 0;

        for (Bulto i: bultos) {
            pesoTotal = pesoTotal + i.getPeso();
        }

        return pesoTotal;

    }

    public int calcularVolumenTotal() {
        
        int volumenTotal = 0;

        for (Bulto i: bultos) {
            volumenTotal = volumenTotal + i.getVolumen();
        }

        return volumenTotal;

    }

    public boolean agregarBulto(Bulto bulto) { // Devuelve TRUE si se ha agregado el bulto.

        if (camion.getCapacidadPeso() >= (calcularPesoTotal() + bulto.getPeso()) && camion.getCapacidadVolumen() >= (calcularVolumenTotal() + bulto.getVolumen())) {
            bultos.add(new Bulto(bulto.getId(), bulto.getVolumen(), bulto.getPeso(), bulto.getFragil()));
            return true;
        } else {
            return false;
        }

    }

    public double getCoste() {

        double coste = 0;

        coste = distancia*precioKilometro;
        for (Bulto i: bultos) {
            if (i.getFragil()) {
                coste = coste + i.getPeso()*precioKilogramoFragil;
            } else {
                coste = coste + i.getPeso()*precioKilogramo;
            }
        }

        return coste;

    }

    public int getId() {
        return id;
    }

    public int getDistancia() {
        return distancia;
    }

    public ArrayList<Bulto> getBultos() {
        return bultos;
    }

    public int getCapacidadPeso() {
        return camion.getCapacidadPeso();
    }

    public int getCapacidadVolumen() {
        return camion.getCapacidadVolumen();
    }

    public String getMatriculaCamion() {
        return camion.getMatricula();
    }
    
}
