package view;

import javax.swing.JFrame;

import controller.RPNCalculatorController;
import view.history.HistoryWindow;

public class RPNCalculatorView extends JFrame {

    private RPNCalculatorController controller = null;

    public RPNCalculatorView(RPNCalculatorController controller) {
        this.controller = controller;
        HistoryWindow historyWindow = new HistoryWindow(controller);
        FrameUtils.centerWindowOnScreen(historyWindow);
        historyWindow.setVisible(true);
        historyWindow.repaint();
    }
}
