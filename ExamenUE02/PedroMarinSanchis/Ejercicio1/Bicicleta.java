package PedroMarinSanchis.Ejercicio1;

public class Bicicleta {

    final private double MIN_VELOCIDAD = 0;
    final private double MAX_VELOCIDAD = 40;
    final private int MIN_PLATO = 1;
    final private int MAX_PLATO = 3;
    final private int MIN_PINYON = 1;
    final private int MAX_PINYON = 7;

    private String modelo = "";
    private double velocidad = 0;
    private int plato = 1;
    private int pinyon = 1;

    public Bicicleta(String modelo, double velocidad, int plato, int pinyon) {
        this.modelo = modelo;
        this.velocidad = obtenerEnRango(velocidad, MIN_VELOCIDAD, MAX_VELOCIDAD);
        this.plato = obtenerEnRango(plato, MIN_PLATO, MAX_PLATO);
        this.pinyon = obtenerEnRango(pinyon, MIN_PINYON, MAX_PINYON);
    }

    private double obtenerEnRango(double valor, double min, double max) {
        if (valor < min) {
            return min;
        }
        if (valor > max) {
            return max;
        }
        return valor;
    }

    private int obtenerEnRango(int valor, int min, int max) {
        if (valor < min) {
            return min;
        }
        if (valor > max) {
            return max;
        }
        return valor;
    }

    private boolean esAdyacente(int valor, int valor2) {
        if (valor+1 == valor2 || valor-1 == valor2) {
            return true;
        }
        return false;
    }

    public void acelerar() {
        this.velocidad = obtenerEnRango(this.velocidad+5, MIN_VELOCIDAD, MAX_VELOCIDAD);
    }

    public void parar() {
        this.velocidad = 0;
    }

    public boolean cambiarPlato(int plato) {
        if (esAdyacente(plato, this.plato)) {
            this.plato = obtenerEnRango(plato, MIN_PLATO, MAX_PLATO);
            return true;
        }
        return false;
    }

    public boolean cambiarPinyon(int pinyon) {
        if (esAdyacente(pinyon, this.pinyon)) {
            this.pinyon = obtenerEnRango(pinyon, MIN_PINYON, MAX_PINYON);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Bicicleta: "+this.modelo+", velocidad: "+this.velocidad+"km/h, Plato: "+this.plato+", Piñon: "+this.pinyon;
    }

}
