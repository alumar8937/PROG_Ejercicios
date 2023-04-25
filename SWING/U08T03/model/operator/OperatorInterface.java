package model.operator;

import model.SyntaxErrorException;

public interface OperatorInterface {
    public double operate(double[] operands) throws SyntaxErrorException;
    public boolean isBinary();
}
