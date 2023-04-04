public class Loteria implements Comparable<Loteria>{
    public int numBilletes;
    public int beneficios;
    private static final double DELTA = 0.0001;
    public Loteria(int numBilletes, int beneficios) {
        this.numBilletes = numBilletes;
        this.beneficios = beneficios;
    }

    @Override
    public String toString() {
        return "Billetes:" + this.numBilletes + " Beneficios:" + this.beneficios;
    }

    public double getFairness() {
        return (double) numBilletes / (double) beneficios;
    }
    
    public int compareTo(Loteria l) {
        if (Math.abs(this.getFairness() - l.getFairness()) < DELTA) {
            return 0;
        }
        if (Math.abs(this.getFairness() - l.getFairness()) > DELTA) {
            return 1;
        }
        return -1;
    }
}
