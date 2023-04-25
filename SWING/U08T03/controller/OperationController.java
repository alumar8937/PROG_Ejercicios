package controller;

import constants.Constants;
import model.CalculatorResult;

public class OperationController {
    public static CalculatorResult evaluateRPNSentence(String sentence) {
        return new CalculatorResult(sentence, Constants.SYNTAX_ERROR);
    }
}
