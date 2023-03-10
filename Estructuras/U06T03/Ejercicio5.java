import java.util.HashMap;

public class Ejercicio5 {
    public static void main(String[] args) {
        System.out.println(repartir(2, 10, 20, 50, 200, 500));
        System.out.println(repartir(3, 50, 20, 100, 200, 500, 10, 50));
    }
    public static String repartir(int participantes, int ... billetes){
        HashMap<Integer, String> reparto = new HashMap<Integer, String>();
        int turno = 0;
        for (int i = 0; i < billetes.length; i++) {
            String billetesRepartidos = reparto.get(turno);
            if (billetesRepartidos !=  null){
                reparto.put(turno, billetesRepartidos + " " + billetes[i]);
            }else{
                reparto.put(turno, billetes[i] + " ");
            }
            //Calcular turno -- Equivalente a "i % participantes"
            if (turno == participantes-1) {
                turno = 0;
            } else {
                turno++;
            }
        }
        return reparto.toString();
    }
}