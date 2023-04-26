package controller;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import model.CalculatorOperator;
import model.CalculatorResult;
import model.RPNEvaluator;
import model.SyntaxErrorException;

public class OperationController {

    public static CalculatorResult evaluateRPNSentence(String sentence) {
        try {
            return new CalculatorResult(sentence, RPNEvaluator.operate(extractOperands(sentence), extractOperators(sentence)));   
        } catch (SyntaxErrorException e) {
            return new CalculatorResult(sentence, e);
        }
    }

    private static Queue<CalculatorOperator> extractOperators(String sentence) {
        Queue<CalculatorOperator> operators = new LinkedList<CalculatorOperator>();
        if (sentence == null || sentence.equalsIgnoreCase("")) {return operators;}
        String[] numberStrings = sentence.replaceAll("[0-9.]", " ").replaceAll(" +", " ").trim().split(" ");
        for (int i = 0; i<numberStrings.length; i++) {
            for (CalculatorOperator c: CalculatorOperator.class.getEnumConstants()) {
                if (numberStrings[i].equalsIgnoreCase(c.getStringExpression())) {
                    operators.add(c);
                }
            }
        }
        return operators;
    }

    private static Deque<Double> extractOperands(String sentence) {
        Deque<Double> operands = new LinkedList<Double>();
        if (sentence == null || sentence.equalsIgnoreCase("")) {return operands;}
        String[] numberStrings = sentence.replaceAll("[^0-9.]", " ").replaceAll(" +", " ").trim().split(" ");
        for (int i = 0; i<numberStrings.length; i++) {
            if (!(numberStrings[i].equalsIgnoreCase(""))) {
                operands.add(Double.parseDouble(numberStrings[i]));
            }
        }
        return operands;
    }

}
