public class Tesoro implements Comparable<Tesoro>{
    public String nombre = "";
    public int valor = 1; // Bueno del 1 al 100
    public int peso = 1; // Peso de los regalos del 1 al 1000

    public Tesoro(String nombre, int valorHistorico, int peso) {
        if (valorHistorico < 1) {valorHistorico = 1;}
        if (valorHistorico > 100) {valorHistorico = 100;}
        if (peso < 1) {peso = 1;}
        if (peso > 1000) {peso = 1000;}
        if (nombre.length() > 9) {
            nombre = "MuyLargo";
        }
        this.nombre = nombre;
        valor = valorHistorico;
        this.peso = peso;
    }

    @Override
    public String toString() {
        return nombre+":\n   Valor: "+valor+"\tPeso: "+peso;
    }

    public int compareTo(Tesoro t) {
        if (this.valor < t.valor) {
            return 1;
        }
        if (this.valor == t.valor) {
            if (this.peso > t.peso) {
                return 1;
            }
            if (this.peso == t.peso) {
                return 0;
            }
        }
        return -1;
    }
}
