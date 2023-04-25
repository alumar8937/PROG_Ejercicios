package model;

import config.Constants;
import model.operator.CalculatorOperator;

public class CalculatorOperation extends Throwable {
    
    private CalculatorOperator operator = null;
    private double[] operands = null;
    
    public CalculatorOperation(double[] operands, CalculatorOperator operator) throws SyntaxErrorException {
        this.operands = operands;
        this.operator = operator;
        if (operands.length != 1 && operator.isBinary()) {throw new SyntaxErrorException(Constants.SYNTAX_ERROR, this);}
        if (operands.length != 2 && !operator.isBinary()) {throw new SyntaxErrorException(Constants.SYNTAX_ERROR, this);}
    }

    public double operate() throws SyntaxErrorException {
        return operator.operate(operands, operator);
    }

}
