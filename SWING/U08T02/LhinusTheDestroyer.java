import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.Stack;

// 18-04-2023 Pedro Marín Sanchis
// This program creates and destroys windows.

public class LhinusTheDestroyer extends JFrame{

    private Stack<JFrame> windows = new Stack<JFrame>();

    private JPanel jPanel = new JPanel();
    private JButton createButton = new JButton("CREATE WINDOW!");
    private JButton destroyButton = new JButton("DESTROY WINDOW!");
    public static void main(String[] args) {
        LhinusTheDestroyer lhinus = new LhinusTheDestroyer();
    }

    public LhinusTheDestroyer() {
        createButton.addActionListener((e) -> {createWindow();});
        destroyButton.addActionListener((e) -> {destroyWindow();});

        jPanel.add(createButton);
        jPanel.add(destroyButton);
        this.add(jPanel);

        this.setSize(300, 300);
        this.setTitle("Lhinus the Destroyer");
        this.setVisible(true);
    }

    private void createWindow() {
        JFrame newWindow = new JFrame();
        newWindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        newWindow.setSize(150,150);
        newWindow.setLocation(windows.size()*10,windows.size()*10);
        newWindow.setTitle(windows.size()+"");
        newWindow.setVisible(true);
        windows.add(newWindow);
    }

    private void destroyWindow() {
        if (!windows.empty()) {
            windows.pop().dispose();
        } else {
            JOptionPane.showMessageDialog(this,"THERE IS NOTHING TO DESTROY ):");
        }
    }

}