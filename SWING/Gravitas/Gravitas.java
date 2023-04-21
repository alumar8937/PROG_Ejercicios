import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

// 18-04-2023 Pedro Marín Sanchis
// This program creates and destroys windows that have gravity and collisions.

public class Gravitas extends JFrame {

    private int screenSizeX = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private int screenSizeY = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

    private boolean simulate = true;
    private int GRAVITY_ACCELERATION = 1; // Pixels*step^2
    private final int SIMULATION_STEP_TIME = 10;
    private SwingWorker<Void,Void> worker = null;

    private Stack<SubWindow> windows = new Stack<SubWindow>();

    private JPanel jPanel = new JPanel();
    private JButton createButton = new JButton("Create window");
    private JButton destroyButton = new JButton("Destroy window");
    private JButton create10Button = new JButton("Create 10 windows");
    private JButton destroyAllButton = new JButton("Destroy all windows");
    private JButton toggleSimulationButton = new JButton("Toggle simulation");
    public static void main(String[] args) {
        Gravitas gravitas = new Gravitas();
        gravitas.destroyWindow(-1);
    }

    public Gravitas() {
        createButton.addActionListener((e) -> {createWindow(1); startSimulation();});
        destroyButton.addActionListener((e) -> {destroyWindow(1);});
        create10Button.addActionListener((e)-> {createWindow(10); startSimulation();});
        destroyAllButton.addActionListener((e) -> {destroyWindow(-1);});
        toggleSimulationButton.addActionListener((e) -> {toggleSimulation();});

        jPanel.add(createButton);
        jPanel.add(destroyButton);
        jPanel.add(create10Button);
        jPanel.add(destroyAllButton);
        jPanel.add(toggleSimulationButton);
        this.add(jPanel);

        
        this.addWindowListener(new WindowAdapter() { // We make sure to close all SubWindows before exit.
            @Override
            public void windowClosing(WindowEvent e) {
                destroyWindow(-1);
            }
        });

        this.setSize(500, 200);
        this.setTitle("Gravitas - ["+screenSizeX+" x "+screenSizeY+"]");
        centerWindow(this);
        this.setVisible(true);

    }

    private void centerWindow(JFrame frame) {
        int frameHeight = frame.getHeight();
        int frameWidth = frame.getWidth();
        int frameXPosition = (screenSizeX/2)-(frameWidth/2);
        int frameYPosition = (screenSizeY/2)-(frameHeight/2);
        frame.setLocation(frameXPosition, frameYPosition);
    }

    private void createWindow(int ammount) {
        for(int i = 0; i < ammount; i++) {
            windows.add(new SubWindow());
        }
    }

    private void destroyWindow(int ammount) {
        if (ammount < 0) {
            while (!windows.empty()) {
                windows.pop().dispose();
            }
            return;
        }

        for(int i = 0; i < ammount; i++) {
            if (!windows.empty()) {
                windows.pop().dispose();
            } else {
                JOptionPane.showMessageDialog(this,"THERE IS NOTHING TO DESTROY ):");
            }
        }
    }

    private void toggleSimulation() {
        if (simulate) {
            simulate = false;
        } else {
            simulate = true;
        }
        startSimulation();
    }

    private void startSimulation() {
        worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                while (true) {
                    if (!simulate) {return null;}
                    simulationStep();
                }
            }
        };
        worker.execute();
    }

    private void simulationStep() {
        for (SubWindow subWindow: windows) {
            subWindow.simulationMove(subWindow.getSpeed().getX(), subWindow.getSpeed().getY() + GRAVITY_ACCELERATION);
        }
        try {
            TimeUnit.MILLISECONDS.sleep(SIMULATION_STEP_TIME);
        } catch (Exception e) {}
    }

    class vector2 {
        private int x, y = 0;

        public vector2(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

    }

    class SubWindow extends JFrame {

        //private int mass = 1;
        private int bounceAbsorption = 10;
        private vector2 speed = new vector2(0,0);
        private JLabel label = new JLabel();

        public SubWindow() {
            super();
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            this.setSize(200,200);
            this.setLocation(windows.size()*15+1,windows.size()*15+1);
            this.setTitle(windows.size()+"");

            this.add(label);
            label.setVisible(true);
            updateLabel();

            this.setVisible(true);
        }

        private void updateLabel() {
            label.setText("<html>Speed -> x:"+speed.getX()+" y:"+speed.getY() + "<br/>Focused:" + hasFocus()+"</html>");
            this.repaint();
        }

        public vector2 getPosition() {
            return new vector2(this.getX(), this.getY());
        }

        public vector2 getSpeed() {
            return this.speed;
        }

        public void setSpeed(int x, int y) {
            speed.setX(x);
            speed.setY(y);
        }

        public void simulationMove(int speedX, int speedY) {
            int xPos = this.getX()+speedX;
            int yPos = this.getY()+speedY;
            if (xPos+this.getWidth() > screenSizeX) {
                xPos = screenSizeX-this.getWidth();
                speedX = -speedX+bounceAbsorption;
            }
            if (xPos < 0) {
                xPos = 1;
                speedX = -speedX-bounceAbsorption;
            }
            if (yPos+this.getHeight() > screenSizeY) {
                yPos = screenSizeY-this.getHeight();
                speedY = -speedY+bounceAbsorption;
            }
            if (yPos < 0) {
                yPos = 1;
                speedY = -speedY;
            }

            if (hasFocus()) {
                updateLabel();
                return;
            }
            this.setLocation(xPos, yPos);
            this.setSpeed(speedX, speedY);
            this.updateLabel();
        }

    }

}