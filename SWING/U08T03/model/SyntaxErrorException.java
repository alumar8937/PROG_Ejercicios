package model;

public class SyntaxErrorException extends Exception {
    public SyntaxErrorException(String errorMessage) {
        super(errorMessage);
    }
}