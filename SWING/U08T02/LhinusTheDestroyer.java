import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

// 18-04-2023 Pedro Marín Sanchis
// This program creates and destroys windows.

public class LhinusTheDestroyer extends JFrame {

    private Stack<SubWindow> windows = new Stack<SubWindow>();

    private JPanel jPanel = new JPanel();
    private JButton createButton = new JButton("CREATE WINDOW!");
    private JButton destroyButton = new JButton("DESTROY WINDOW!");
    private JButton create10Button = new JButton("CREATE 10 WINDOWS!");
    private JButton destroyAllButton = new JButton("DESTROY ALL WINDOWS!");
    private JButton makeEmDanceButton = new JButton("MAKE 'EM DANCE!");
    public static void main(String[] args) {
        LhinusTheDestroyer destroyer = new LhinusTheDestroyer();
        destroyer.destroyWindow(-1);
    }

    public LhinusTheDestroyer() {
        createButton.addActionListener((e) -> {createWindow(1);});
        destroyButton.addActionListener((e) -> {destroyWindow(1);});
        create10Button.addActionListener((e)-> {createWindow(10);});
        destroyAllButton.addActionListener((e) -> {destroyWindow(-1);});
        makeEmDanceButton.addActionListener((e) -> {makeWindowsDance();});

        jPanel.add(createButton);
        jPanel.add(destroyButton);
        jPanel.add(create10Button);
        jPanel.add(destroyAllButton);
        jPanel.add(makeEmDanceButton);
        this.add(jPanel);

        
        this.addWindowListener(new WindowAdapter() { // We make sure to close all SubWindows before exit.
            @Override
            public void windowClosing(WindowEvent e) {
                destroyWindow(-1);
            }
        });

        this.setSize(300, 200);
        this.setTitle("Lhinus the Destroyer");
        this.setVisible(true);
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

    private void makeWindowsDance() {
        for (SubWindow subWindow: windows) { // Instance a SwingWorker for every SubWindow there is.
            SwingWorker<Void,Void> worker = new SwingWorker<Void, Void>() {
                @Override
                protected Void doInBackground() throws Exception {
                    subWindow.dance();
                    return null;
                }
            };
            worker.execute(); // Start the worker thread
        }
    }

    class SubWindow extends JFrame {
        public SubWindow() {
            super();
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            this.setSize(150,150);
            this.setLocation(windows.size()*15,windows.size()*15);
            this.setTitle(windows.size()+"");
            this.setVisible(true);
        }

        public void dance() {
            for (int i = 0; i < 100; i++){
                int x = this.getX();
                int y = this.getY();
                int randX = (int)(Math.random()*10);
                int randY = (int)(Math.random()*10);
                setLocation(x+randX, y+randY);
                try {
                    TimeUnit.MILLISECONDS.sleep(50);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this,"DANCING WAS INTERRUPTED! ):");
                }
            }
        }

    }

}