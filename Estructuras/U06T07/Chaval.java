public class Chaval implements Comparable<Chaval>{
    public int b = 1; // Bueno del 1 al 100
    public int p = 1; // Peso de los regalos del 1 al 1000

    public Chaval(int bueno, int pesoRegalos) {
        if (bueno < 1) {bueno = 1;}
        if (bueno > 100) {bueno = 100;}
        if (pesoRegalos < 1) {pesoRegalos = 1;}
        if (pesoRegalos > 1000) {pesoRegalos = 1000;}
        b = bueno;
        p = pesoRegalos;
    }

    @Override
    public String toString() {
        return "Bueno: "+b+"\tPeso Regalos: "+p;
    }

    public int compareTo(Chaval o) {
        if (this.b < o.b) {
            return 1;
        }
        if (this.b == o.b) {
            if (this.p > o.p) {
                return 1;
            }
            if (this.p == o.p) {
                return 0;
            }
        }
        return -1;
    }
}
