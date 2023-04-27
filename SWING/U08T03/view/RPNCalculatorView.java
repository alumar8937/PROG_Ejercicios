package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.history.HistoryWindow;
import view.mainWindow.CalculatorMainWindow;

public class RPNCalculatorView implements ActionListener {

    private static RPNCalculatorView INSTANCE = null;
    private static CalculatorMainWindow calculatorMainWindow = CalculatorMainWindow.getInstance();
    private static HistoryWindow historyWindow = HistoryWindow.getInstance();

    private RPNCalculatorView() {
        FrameUtils.centerWindowOnScreen(calculatorMainWindow);
        FrameUtils.centerWindowOnScreen(historyWindow);
        
        calculatorMainWindow.setVisible(true);
        historyWindow.setLocation(calculatorMainWindow.getX()+calculatorMainWindow.getWidth(), calculatorMainWindow.getY());
        historyWindow.setVisible(true);
    }

    public static RPNCalculatorView getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RPNCalculatorView();
        }
        return INSTANCE;
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
