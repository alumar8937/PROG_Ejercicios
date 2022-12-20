// 20/12/2022 Pedro Marín Sanchis

public class Segmento {

    private Punto p1;
    private Punto p2;
    
    public Segmento() {
        this.p1 = new Punto();
        this.p2 = new Punto();
    }

    public Segmento(Punto p1, Punto p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public double longitud() {
        return Math.sqrt((Math.pow(p1.getX() - p2.getX(), 2)+(Math.pow(p1.getY() - p2.getY(), 2))));
    }

    public void desplaza(int despX, int despY) {
        this.p1.desplaza(despX, despY);
        this.p2.desplaza(despX, despY);
    }

    public void desplaza(Punto p) {
        this.p1.desplaza(p.getX(), p.getY());
        this.p2.desplaza(p.getX(), p.getY());
    }

    public String toString() {
        return "(" + p1.getX() + "," + p1.getY() + ")-(" + p2.getX() + "," + p2.getY() + ")";
    }

    public Punto getP1() {
        return p1;
    }

    public Punto getP2() {
        return p2;
    }

    public void setP1(Punto p1) {
        this.p1 = p1;
    }

    public void setP2(Punto p2) {
        this.p2 = p2;
    }
}
