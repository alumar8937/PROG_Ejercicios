package view.mainWindow.keypad;

import config.Constants;

import java.awt.GridLayout;
import javax.swing.*;

import controller.RPNCalculatorController;

public class keypadPanel extends JPanel {

    private JPanel functionButtonPanel = new JPanel();
    private JPanel memoryButtonPanel = new JPanel();

    public keypadPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        addMemoryButtons();
        addFunctionPanel();
    }

    private void addMemoryButtons() {
        memoryButtonPanel.setLayout(new GridLayout(3,3));
        for (int i = 0; i<Constants.MEMORY_BUTTON_AMMOUNT; i++) {
            memoryButtonPanel.add(new JButton("M"+i));
        }
        add(memoryButtonPanel);
    }

    private void addFunctionPanel() {
        functionButtonPanel.setLayout(new GridLayout(3,3));
        for (String buttonLabel: RPNCalculatorController.getButtonLabels()) {
            functionButtonPanel.add(new JButton(buttonLabel));
        }
        functionButtonPanel.add(new JButton("="));
        add(functionButtonPanel);
    }
}
