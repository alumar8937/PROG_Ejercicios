package model.operator;

import model.SyntaxErrorException;

public interface OperatorInterface<T> {
    public double operate(double[] operands, OperatorInterface<T> operator) throws SyntaxErrorException;
    public boolean isBinary();
}
