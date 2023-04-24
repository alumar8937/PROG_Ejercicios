package controller;

import model.RPNCalculatorModel;

public class RPNCalculatorController {
    private HistoryController historyController = null;

    public RPNCalculatorController(RPNCalculatorModel model) {
        historyController = new HistoryController(model);
    }

    public HistoryController getHistoryController() {
        return historyController;
    }
}
