package controller;

import java.util.ArrayList;

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

    private static CalculatorOperator[] extractOperators(String sentence) {
        String[] numberStrings = sentence.replaceAll("[0-9.]", " ").trim().split(" ");
        ArrayList<CalculatorOperator> operators = new ArrayList<CalculatorOperator>();
        for (int i = 0; i<numberStrings.length; i++) {
            for (CalculatorOperator c: CalculatorOperator.class.getEnumConstants()) {
                if (numberStrings[i].equalsIgnoreCase(c.getStringExpression())) {
                    operators.add(c);
                }
            }
        }
        CalculatorOperator[] returnArray = new CalculatorOperator[operators.size()];
        for (int i = 0; i < returnArray.length; i++) {
            returnArray[i] = operators.get(i);
        }
        return returnArray;
    }

    private static double[] extractOperands(String sentence) {
        String[] numberStrings = sentence.replaceAll("[^0-9.]", " ").trim().split(" ");
        ArrayList<Double> operands = new ArrayList<Double>();
        for (int i = 0; i<numberStrings.length; i++) {
            operands.add(Double.parseDouble(numberStrings[i]));
        }
        double[] returnArray = new double[operands.size()];
        for (int i = 0; i < returnArray.length; i++) {
            returnArray[i] = operands.get(i);
        }
        return returnArray;
    }

}
