package controller;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import config.Constants;
import model.CalculatorOperator;
import model.CalculatorResult;
import model.RPNEvaluator;
import model.SyntaxErrorException;

public class OperationController {
    public static CalculatorResult evaluateRPNSentence(String sentence) {
        try {
            return new CalculatorResult(sentence, ""+RPNEvaluator.operate(extractOperands(sentence), extractOperators(sentence)));   
        } catch (SyntaxErrorException e) {
            return new CalculatorResult(sentence, Constants.SYNTAX_ERROR);
        }
    }

    private static Queue<CalculatorOperator> extractOperators(String sentence) {
        String[] numberStrings = sentence.replaceAll("[0-9.]", " ").replaceAll(" +", " ").trim().split(" ");
        Queue<CalculatorOperator> operators = new LinkedList<CalculatorOperator>();
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
        String[] numberStrings = sentence.replaceAll("[^0-9.]", " ").replaceAll(" +", " ").trim().split(" ");
        Deque<Double> operands = new LinkedList<Double>();
        for (int i = 0; i<numberStrings.length; i++) {
            operands.add(Double.parseDouble(numberStrings[i]));
        }
        return operands;
    }

}
