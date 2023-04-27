package view.mainWindow;

import java.awt.Dimension;
import java.awt.Font;

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
        setSize(600, 500);
        populate();
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
        displayComponent.setPreferredSize(new Dimension(this.getWidth()-50, 50));
        displayComponent.setFont(new Font(displayComponent.getFont().getName(), displayComponent.getFont().getStyle(), displayComponent.getFont().getSize()+5));
        panel.add(displayComponent);
        panel.add(new buttonPanel());
        add(panel);
    }

    public JTextField getDisplayComponent() {
        return displayComponent;
    }

    public void addToDisplay(String text) {
        displayComponent.setText(displayComponent.getText()+text);
    }

    public void clearDisplay() {
        displayComponent.setText("");
    }

    public void displayBackspace() {
        displayComponent.setText(displayComponent.getText().substring(0, displayComponent.getText().length()-1));
    }

}
