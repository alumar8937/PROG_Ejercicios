package view.mainWindow.keypad;

import java.awt.GridLayout;
import javax.swing.*;

import controller.RPNCalculatorController;
import view.history.HistoryWindow;
import view.mainWindow.CalculatorMainWindow;

public class buttonPanel extends JPanel {

    private JPanel functionButtonPanel = new JPanel();
    private JPanel numericButtonPanel = new JPanel();

    private JButton equalsButton = new JButton("=");
    private JButton spaceButton = new JButton("␣");
    private JButton clearButton = new JButton("C");
    private JButton backspaceButton = new JButton("<--");

    public buttonPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        addFunctionPanel();
        addNumericPanel();
    }

    private void addFunctionPanel() {
        functionButtonPanel.setLayout(new GridLayout(4,3));
        String[] labels = RPNCalculatorController.getButtonLabels();
        String[] tooltips = RPNCalculatorController.getButtonTooltips();
        for (int i = 0; i < labels.length; i++) {
            JButton currentButton = new JButton(labels[i]);
            currentButton.addActionListener((e)->CalculatorMainWindow.getInstance().addToDisplay(currentButton.getText()));
            currentButton.setToolTipText(tooltips[i]);
            functionButtonPanel.add(currentButton);
        }

        equalsButton.addActionListener((e) -> {RPNCalculatorController.evaluateRPNSentence(CalculatorMainWindow.getInstance().getDisplayComponent().getText()); HistoryWindow.getInstance().repaint();});
        spaceButton.addActionListener((e) -> CalculatorMainWindow.getInstance().addToDisplay(" "));
        clearButton.addActionListener((e) -> CalculatorMainWindow.getInstance().clearDisplay());
        backspaceButton.addActionListener((e) -> CalculatorMainWindow.getInstance().displayBackspace());
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
