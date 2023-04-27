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
    private JPanel numericButtonPanel = new JPanel();

    private JButton equalsButton = new JButton("=");
    private JButton spaceButton = new JButton("␣");
    private JButton clearButton = new JButton("C");
    private JButton backspaceButton = new JButton("<--");

    public buttonPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        addMemoryButtons();
        addFunctionPanel();
        addNumericPanel();
    }

    private void addMemoryButtons() {
        memoryButtonPanel.setLayout(new GridLayout(3,3));
        for (int i = 0; i<Constants.MEMORY_BUTTON_AMMOUNT; i++) {
            memoryButtonPanel.add(new JButton("M"+(i+1)));
        }
        add(memoryButtonPanel);
    }

    private void addFunctionPanel() {
        functionButtonPanel.setLayout(new GridLayout(4,3));
        for (String buttonLabel: RPNCalculatorController.getButtonLabels()) {
            JButton currentButton = new JButton(buttonLabel);
            currentButton.addActionListener((e)->CalculatorMainWindow.getInstance().addToDisplay(buttonLabel));
            functionButtonPanel.add(currentButton);
        }

        equalsButton.addActionListener((e) -> {RPNCalculatorController.evaluateRPNSentence(CalculatorMainWindow.getInstance().getDisplayComponent().getText()); e.setSource("EQUALS_BUTTON"); RPNCalculatorView.getInstance().actionPerformed(e);});
        spaceButton.addActionListener((e) -> CalculatorMainWindow.getInstance().addToDisplay(" "));
        clearButton.addActionListener((e) -> CalculatorMainWindow.getInstance().clearDisplay());
        backspaceButton.addActionListener((e)-> CalculatorMainWindow.getInstance().displayBackspace());
        functionButtonPanel.add(equalsButton);
        functionButtonPanel.add(spaceButton);
        functionButtonPanel.add(backspaceButton);
        functionButtonPanel.add(clearButton);

        add(functionButtonPanel);
    }

    private void addNumericPanel() {
        numericButtonPanel.setLayout(new GridLayout(4,3));
        for (int i = 9; i>-1 ; i--) {
            JButton currentButton = new JButton(i+"");
            currentButton.addActionListener((e)->CalculatorMainWindow.getInstance().addToDisplay(currentButton.getText()));
            numericButtonPanel.add(currentButton);
        }
        add(numericButtonPanel);
    }

}
