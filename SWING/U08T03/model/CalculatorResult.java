package model;

public class CalculatorResult {

    private String sentence = "";
    private double result = 0;
    private SyntaxErrorException exception = null;

    public CalculatorResult(String sentence, double result) {
        this.sentence = sentence;
        this.result = result;
    }

    public CalculatorResult(String sentence, SyntaxErrorException exception) {
        this.sentence = sentence;
        this.exception = exception;
    }

    public String getSentence() {
        return sentence;
    }

    public double getResult() {
        return result;
    }

    public boolean wasSyntaxError() {
        return exception == null;
    }

}
