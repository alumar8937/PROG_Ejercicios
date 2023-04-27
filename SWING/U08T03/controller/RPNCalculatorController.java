package controller;

import java.util.Queue;

import model.CalculatorOperator;
import view.history.HistoryEntry;

public class RPNCalculatorController {

    public static Queue<HistoryEntry> getResultHistory() {
        return HistoryController.getResultHistory();
    }

    public static void evaluateRPNSentence(String sentence) {
        HistoryController.addResult(OperationController.evaluateRPNSentence(sentence));
    }

    public static String[] getButtonLabels() {
        CalculatorOperator[] operators = CalculatorOperator.class.getEnumConstants();
        String[] buttonLabels = new String[operators.length];
        for (int i = 0; i < operators.length; i++) {
            buttonLabels[i] = operators[i].getStringExpression();
        }
        return buttonLabels;
    }

    public static String[] getButtonTooltips() {
        CalculatorOperator[] operators = CalculatorOperator.class.getEnumConstants();
        String[] buttonLabels = new String[operators.length];
        for (int i = 0; i < operators.length; i++) {
            buttonLabels[i] = operators[i].toString().replace("CalculatorOperator.", "").toLowerCase();
        }
        return buttonLabels;
    }

}
