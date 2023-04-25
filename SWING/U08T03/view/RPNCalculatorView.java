package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.RPNCalculatorController;
import view.history.HistoryWindow;
import view.mainWindow.CalculatorMainWindow;

public class RPNCalculatorView implements ActionListener {

    private RPNCalculatorController controller = null;
    private CalculatorMainWindow calculatorMainWindow = null;
    private HistoryWindow historyWindow = null;

    public RPNCalculatorView(RPNCalculatorController controller) {
        this.controller = controller;
        
        calculatorMainWindow = new CalculatorMainWindow(this, controller);
        historyWindow = new HistoryWindow(this, controller);

        FrameUtils.centerWindowOnScreen(calculatorMainWindow);
        FrameUtils.centerWindowOnScreen(historyWindow);
        
        calculatorMainWindow.setVisible(true);
        historyWindow.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getSource()+"") {
            case "EQUALS_BUTTON":
                historyWindow.repaint();
            break;
        default:
            System.out.println("ActionEvent \""+e.getSource()+"\"was not accounted for.");
        }
    }
}
