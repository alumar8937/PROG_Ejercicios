// 10/01/2023 Pedro Marín Sanchis

public class Rectangulo extends Punto {

    private int alto;
    private int ancho;

    public Rectangulo() {

        super();
        this.alto = 0;
        this.ancho = 0;

    }

    public Rectangulo(Punto origen, int ancho, int alto) {

        super(origen.getX(),origen.getY());
        this.alto = alto;
        this.ancho = ancho;

    }

    public Rectangulo(Punto punto1, Punto punto2) {

        super(punto1.getX(),punto1.getY());
        this.alto = punto2.getY() - super.getY();
        this.ancho = punto2.getX() - super.getX();

    }

    public Rectangulo(Segmento segmento) {

        super(segmento.getP1().getX(),segmento.getP1().getY());
        this.alto = segmento.getP2().getY() - super.getY();
        this.ancho = segmento.getP2().getX() - super.getX();

    }

    public String toString() {    //(x,y) anchura: w altura: h}
        return super.toString() + " anchura: " + ancho + " altura: " +  alto;
    }

    public int getArea() {
        return Math.abs(alto*ancho);
    }

    public Punto getPunto() {
        return getInferiorIzquierdo();
    }

    public Punto getSuperiorIzquierdo() {
        return new Punto(super.getX(),Math.abs(super.getY()+alto));
    }

    public Punto getSuperiorDerecho() {
        return new Punto(Math.abs(super.getX()+ancho),Math.abs(super.getY()+alto));
    }

    public Punto getInferiorIzquierdo() {
        return new Punto(super.getX(), super.getY());
    }

    public Punto getInferiorDerecho() {
        return new Punto(super.getX(),Math.abs(super.getY()+alto));
    }

    public int getAlto() {
        return alto;
    }
    
    public int getAncho() {
        return ancho;
    }

}
