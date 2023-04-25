package controller;

import java.util.Queue;

import model.RPNCalculatorModel;
import view.history.HistoryEntry;

public class RPNCalculatorController {
    
    private RPNCalculatorModel model = null;
    private HistoryController historyController = null;

    public RPNCalculatorController(RPNCalculatorModel model) {
        this.model = model;
        historyController = new HistoryController(model);
    }

    public Queue<HistoryEntry> getResultHistory() {
        return historyController.getResultHistory();
    }

    public void evaluateRPNSentence(String sentence) {
        historyController.addResult(OperationController.evaluateRPNSentence(sentence));
    }

}
