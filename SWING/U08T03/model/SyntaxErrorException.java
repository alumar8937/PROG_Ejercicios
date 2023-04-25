package model;

public class SyntaxErrorException extends Exception {
    public SyntaxErrorException(String errorMessage) {
        super(errorMessage);
        System.out.println("Exception RAised");
    }
}