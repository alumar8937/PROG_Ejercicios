public class Poligono {

    private Punto[] puntos;

    public Poligono(Punto[] puntos) {
        this.puntos = puntos;
    }

    public Poligono(Segmento[] segmentos) {
        Punto[] puntos = new Punto[segmentos.length*2];
        for (int i = 0; i < segmentos.length; i++) {
            puntos[i] = segmentos[i].getP1();
            puntos[i+1] = segmentos[i].getP2();
        }
        this.puntos = puntos;
    }

    public String toString() {
        String string = "";
        for (Punto i: puntos){
            string = string + i.toString() + "-";
        }
        return string.substring(0, string.length()-1);
    }

    public void desplaza(int despX, int despY) {

        for (Punto i: puntos) {
            i.desplaza(despX, despY);
        }

    }

    public void desplaza(Punto desp) {

        int despX = desp.getX();
        int despY = desp.getY();

        for (Punto i: puntos) {
            i.desplaza(despX, despY);
        }

    }

    public double obtenerPerimetro() {
        double p = 0;
        if (this.puntos.length > 2) {
            for (int i = 0; i < puntos.length - 1; i++) {
                Segmento seg = new Segmento(puntos[i], puntos[i+1]);
                p = p + seg.longitud();
            }
        }
        Segmento seg = new Segmento(puntos[0], puntos[puntos.length-1]);
        p = p + seg.longitud();
        return p;
    }
    
}
