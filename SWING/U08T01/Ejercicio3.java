import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

// Pedro Marín Sanchis - 05/04/2023

public class Ejercicio3 {

    private static Toolkit toolkit = Toolkit.getDefaultToolkit();
    private JLabel mainWindowJLabel = new JLabel();
    private JFrame mainWindow = createMainWindow();
    private static final String END_CODE = "fin";
    public static void main(String[] args) {
        Ejercicio2 ejercicio2 = new Ejercicio2();
    }

    public Ejercicio3() {
        String userInput = "";
        while (true) {
            mainWindowJLabel.set
        }
    }

    private JFrame createMainWindow() {
        JFrame mainWindow = new JFrame();
        JPanel mainWindowJPanel = new JPanel();
        int frameHeight = 200;
        int frameWidth = 400;

        mainWindow.setTitle("Ventana Principal");
        mainWindow.setSize(frameWidth, frameHeight);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        centerWindow(mainWindow);

        mainWindow.add(mainWindowJPanel);
        mainWindowJPanel.add(mainWindowJLabel);

        mainWindow.setVisible(true);
        return mainWindow;
    }

    private static void centerWindow(JFrame frame) {
        Dimension screenDimension = toolkit.getScreenSize();
        int frameHeight = frame.getHeight();
        int frameWidth = frame.getWidth();
        int frameXPosition = (screenDimension.width/2)-(frameWidth/2);
        int frameYPosition = (screenDimension.height/2)-(frameHeight/2);
        frame.setLocation(frameXPosition, frameYPosition);
    }

}
