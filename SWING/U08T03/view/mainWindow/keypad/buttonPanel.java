package view.mainWindow.keypad;

import config.Constants;

import java.awt.GridLayout;
import javax.swing.*;

import controller.RPNCalculatorController;
import view.RPNCalculatorView;
import view.mainWindow.CalculatorMainWindow;

public class buttonPanel extends JPanel {

    private JPanel functionButtonPanel = new JPanel();
    private JPanel memoryButtonPanel = new JPanel();

    private JButton equalsButton = new JButton("=");

    public buttonPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        addMemoryButtons();
        addFunctionPanel();
    }

    private void addMemoryButtons() {
        memoryButtonPanel.setLayout(new GridLayout(3,3));
        for (int i = 0; i<Constants.MEMORY_BUTTON_AMMOUNT; i++) {
            memoryButtonPanel.add(new JButton("M"+(i+1)));
        }
        add(memoryButtonPanel);
    }

    private void addFunctionPanel() {
        functionButtonPanel.setLayout(new GridLayout(3,3));
        for (String buttonLabel: RPNCalculatorController.getButtonLabels()) {
            functionButtonPanel.add(new JButton(buttonLabel));
        }

        equalsButton.addActionListener((e) -> {RPNCalculatorController.evaluateRPNSentence(CalculatorMainWindow.getInstance().getDisplayComponent().getText()); e.setSource("EQUALS_BUTTON"); RPNCalculatorView.getInstance().actionPerformed(e);});
        functionButtonPanel.add(equalsButton);
        add(functionButtonPanel);
    }
}
