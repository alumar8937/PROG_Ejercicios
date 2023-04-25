package view.mainWindow;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import config.Constants;
import controller.RPNCalculatorController;
import view.RPNCalculatorView;

public class CalculatorMainWindow extends JFrame {

    private RPNCalculatorController controller = null;
    private RPNCalculatorView view = null;

    private JButton equalsButton = new JButton("=");
    private JTextField input = new JTextField();
    private JPanel panel = new JPanel();

    public CalculatorMainWindow(RPNCalculatorView view, RPNCalculatorController controller) {

        this.controller = controller;
        this.view = view;

        populate();

        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(Constants.PROGRAM_TITLE);
        setVisible(true);
    }

    private void populate() {
        input.setPreferredSize(new Dimension(100, 30));
        panel.add(input);
        equalsButton.addActionListener((e) -> {controller.evaluateRPNSentence(input.getText()); e.setSource("EQUALS_BUTTON"); view.actionPerformed(e);});
        panel.add(equalsButton);
        add(panel);
    }

}
