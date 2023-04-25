package model;

import config.Constants;

public class RPNEvaluator {

    public static double operate(double[] operands, CalculatorOperator[] operators) throws SyntaxErrorException {
        
        double result = 0;
        int operandPosition = 0;
        int operatorPosition = 0;

        if (!isSyntaxValid(operands, operators)) {
            throw new SyntaxErrorException(Constants.SYNTAX_ERROR);
        }

        if (operators.length == 0 && operands.length == 1) {return operands[0];}
        if (operators.length == 1 && operands.length == 1) {
            if (operators[0].isBinary()) {
                throw new SyntaxErrorException(Constants.SYNTAX_ERROR);
            } else {
                return operators[0].operate(operands);
            }
        } // Good until here

        if (operators[0].isBinary()) {
            result = operators[operatorPosition].operate(new double[]{operands[operandPosition],operands[operandPosition+1]});
        } else {
            result = operators[operatorPosition].operate(new double[]{operands[operandPosition]});
        }
        operandPosition++;
        operatorPosition++;

        for (int i = operatorPosition; i < operators.length; operatorPosition++) {
            if (operators[0].isBinary()) {
                result = operators[operatorPosition].operate(new double[]{result,operands[operandPosition]});
                operandPosition++;
            } else {
                result = operators[operatorPosition].operate(new double[]{result});
            }
        }

        return result;
    }

    private static boolean isSyntaxValid(double[] operands, CalculatorOperator[] operators) {
        
        int operandsNeeded = 1;
        
        if (operators.length == 0 && operands.length > 1) {return false;}

        for (CalculatorOperator c: operators) {
            if (c.isBinary()) {
                operandsNeeded++;
            }
        }

        return operandsNeeded==operands.length;

    }

}
