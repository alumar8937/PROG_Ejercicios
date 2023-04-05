import javax.swing.JFrame;

public class Ejercicio1 {
    
    public static void main(String[] args) {
        JFrame ventana1 = new JFrame();
        ventana1.setTitle("Primera Ventana");
        ventana1.setSize(500, 300);
        ventana1.setVisible(true);
        ventana1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana1.setLocation(0, 330);
        JFrame ventana2 = new JFrame();
        ventana2.setTitle("Segunda Ventana");
        ventana2.setSize(500, 300);
        ventana2.setVisible(true);
        ventana2.setLocation(0, 0);
    }
}