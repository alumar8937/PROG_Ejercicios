package controller;

import java.util.Queue;

import model.CalculatorOperator;
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

    public static String[] getButtonLabels() {
        CalculatorOperator[] operators = CalculatorOperator.class.getEnumConstants();
        String[] buttonLabels = new String[operators.length];
        for (int i = 0; i < operators.length; i++) {
            buttonLabels[i] = operators[i].getStringExpression();
        }
        return buttonLabels;
    }

}
