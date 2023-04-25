package controller;

import config.Constants;
import model.CalculatorResult;

public class OperationController {
    public static CalculatorResult evaluateRPNSentence(String sentence) {
        //TODO: Real implementation lol!
        return new CalculatorResult(sentence, Constants.SYNTAX_ERROR);
    }
}
