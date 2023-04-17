import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

// Pedro Marín Sanchis - 05/04/2023

public class Ejercicio3 {

    private static Toolkit toolkit = Toolkit.getDefaultToolkit();
    private JLabel mainWindowJLabel = new JLabel();
    private JFrame mainWindow = createMainWindow();
    public static void main(String[] args) {
        Ejercicio3 ejercicio3 = new Ejercicio3();
    }

    public Ejercicio3() {
        int xPos = 0;
        int yPos = 0;
        boolean goingUp = false;
        boolean goingLeft = false;
        mainWindowJLabel.setText("[DVD]");
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(20);
                if (xPos > mainWindow.getWidth()-mainWindowJLabel.getWidth()-15) {goingLeft = true;}
                if (yPos > mainWindow.getHeight()-mainWindowJLabel.getHeight()-37) {goingUp = true;}
                if (xPos < 0) {goingLeft = false;}
                if (yPos < 0) {goingUp = false;}
                if (goingLeft) {xPos--;} else {xPos++;}
                if (goingUp) {yPos--;} else {yPos++;}
                mainWindowJLabel.setLocation(xPos, yPos);
                    mainWindow.setTitle("Window Dimensions -> [x:"+mainWindow.getWidth()+" y:"+mainWindow.getHeight()+"]    Text Location -> [x:"+xPos+" y:"+yPos+"]");
                mainWindow.update(mainWindow.getGraphics());
            } catch (Exception e) {
                //TODO: Handle Exception Properly.
            }
        }
    }

    private JFrame createMainWindow() {
        JFrame mainWindow = new JFrame();
        JPanel mainWindowJPanel = new JPanel();
        int frameHeight = 200;
        int frameWidth = 800;

        mainWindow.setLayout(null);
        mainWindow.setTitle("[x:"+frameWidth+" y:"+frameHeight+"]");
        mainWindow.setSize(frameWidth, frameHeight);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        centerWindow(mainWindow);

        mainWindowJPanel.setSize(frameWidth, frameHeight);

        mainWindow.add(mainWindowJPanel);
        mainWindowJPanel.add(mainWindowJLabel);

        mainWindowJPanel.setVisible(true);
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
