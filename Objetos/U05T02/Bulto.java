public class Bulto {

    private int id;

    private int volumen; // m^3x

    private int peso;

    private boolean fragil;

    public Bulto (int id, int volumen, int peso, boolean fragil) {

        this.id = id;
        this.volumen = volumen;
        this.peso = peso;
        this.fragil = fragil;

    }

    public int getId() {
        return id;
    }

    public int getVolumen() {
        return volumen;
    }

    public int getPeso() {
        return peso;
    }

    public boolean getFragil() {
        return fragil;
    }
    
}
