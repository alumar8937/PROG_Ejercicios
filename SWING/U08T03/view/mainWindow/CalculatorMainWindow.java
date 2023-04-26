package view.mainWindow;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import config.Constants;
import view.mainWindow.keypad.buttonPanel;

public class CalculatorMainWindow extends JFrame {

    private static CalculatorMainWindow INSTANCE = null;

    private JTextField displayComponent = new JTextField();
    private JPanel panel = new JPanel();

    private CalculatorMainWindow() {
        populate();
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(Constants.PROGRAM_TITLE);
        setVisible(true);
    }

    public static CalculatorMainWindow getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CalculatorMainWindow();
        }
        return INSTANCE;
    }

    private void populate() {
        displayComponent.setPreferredSize(new Dimension(500, 30));
        panel.add(displayComponent);
        panel.add(new buttonPanel());
        add(panel);
    }

    public JTextField getDisplayComponent() {
        return displayComponent;
    }

}
