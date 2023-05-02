package model;

public class Jugador {
    private Demarcacion demarcacion = null;
    private String nombre = null;
    private int anyoNacimiento = 0;
    private int altura = 0;
    private int dorsal = 0;

    public Jugador(Demarcacion demarcacion, String nombre, int anyoNacimiento, int altura, int dorsal) {
        this.demarcacion = demarcacion;
        this.nombre = nombre;
        this.anyoNacimiento = anyoNacimiento;
        this.altura = altura;
        this.dorsal = dorsal;
    }

    public Demarcacion getDemarcacion() {
        return demarcacion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAnyoNacimiento() {
        return anyoNacimiento;
    }

    public int getAltura() {
        return altura;
    }

    public int getDorsal() {
        return dorsal;
    }

}
