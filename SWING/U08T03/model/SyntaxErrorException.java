package model;

public class SyntaxErrorException extends Exception {
    public SyntaxErrorException(String errorMessage, CalculatorOperation operation) {
        super(errorMessage, operation);
    }
}