package view.mainWindow;

import javax.swing.JButton;
import javax.swing.JFrame;

import constants.Constants;
import controller.RPNCalculatorController;
import view.RPNCalculatorView;

public class CalculatorMainWindow extends JFrame {

    private RPNCalculatorController controller = null;
    private RPNCalculatorView view = null;

    private JButton equalsButton = new JButton("=");
    private int count = 0;

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
        equalsButton.addActionListener((e) -> {controller.evaluateRPNSentence(count+""); count++; e.setSource("EQUALS_BUTTON"); view.actionPerformed(e);});
        add(equalsButton);
    }

}
