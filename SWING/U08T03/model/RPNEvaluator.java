package model;

import java.util.Deque;
import java.util.Queue;
import config.Constants;

public class RPNEvaluator {

    public static double operate(Deque<Double> operands, Queue<CalculatorOperator> operators) throws SyntaxErrorException {
        
        double result = 0;

        if (!isSyntaxValid(operands, operators)) {
            throw new SyntaxErrorException(Constants.SYNTAX_ERROR);
        }

        if (operators.size() == 0 && operands.size() == 1) {return operands.getFirst();} // Return first operand if there are no operators or other operands.
        if (operators.size() == 1 && operands.size() == 1) {
            if (operators.peek().isBinary()) {
                throw new SyntaxErrorException(Constants.SYNTAX_ERROR);
            } else {
                return operators.poll().operate(operands);
            }
        }

        while (!operators.isEmpty()) {
            if (operators.peek().isBinary()) {
                result = operators.poll().operate(operands);
            } else {
                result = operators.poll().operate(operands);
            }
            operands.addFirst(result);
        }

        return result;
    }

    private static boolean isSyntaxValid(Deque<Double> operands, Queue<CalculatorOperator> operators) {
        
        int operandsNeeded = 1;
        
        if (operators.size() == 0 && operands.size() > 1) {return false;}

        for (CalculatorOperator c: operators) {
            if (c.isBinary()) {
                operandsNeeded++;
            }
        }

        return operandsNeeded==operands.size();

    }

}
