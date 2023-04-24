package model;

public class CalculatorResult {

    private String sentence = "";
    private String result = "";

    public CalculatorResult(String sentence, String result) {
        this.sentence = sentence;
        this.result = result;
    }

    public String getSentence() {
        return sentence;
    }

    public String getResult() {
        return result;
    }

}
