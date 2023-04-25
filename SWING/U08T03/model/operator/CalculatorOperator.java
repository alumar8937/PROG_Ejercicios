package model.operator;

import config.Constants;
import model.SyntaxErrorException;

public enum CalculatorOperator {
            
    ADDITION(true){
        public double operate(double[] operands) throws SyntaxErrorException {
            if (!isSyntaxValid(operands, isBinary())) {throw new SyntaxErrorException(Constants.SYNTAX_ERROR);}
            return operands[0]+operands[1];
        }
    }, // +
    SUBTRACTION(true){
        public double operate(double[] operands) throws SyntaxErrorException {
            if (!isSyntaxValid(operands, isBinary())) {throw new SyntaxErrorException(Constants.SYNTAX_ERROR);}
            return operands[0]-operands[1];
        }
    }, // -
    MULTIPLICATION(true){
        public double operate(double[] operands) throws SyntaxErrorException {
            if (!isSyntaxValid(operands, isBinary())) {throw new SyntaxErrorException(Constants.SYNTAX_ERROR);}
            return operands[0]*operands[1];
        }
    }, // ×
    DIVISION(true){
        public double operate(double[] operands) throws SyntaxErrorException {
            if (!isSyntaxValid(operands, isBinary())) {throw new SyntaxErrorException(Constants.SYNTAX_ERROR);}
            return operands[0]/operands[1];
        }
    }, // ÷
    EXPONENTIATION(true){
        public double operate(double[] operands) throws SyntaxErrorException {
            if (!isSyntaxValid(operands, isBinary())) {throw new SyntaxErrorException(Constants.SYNTAX_ERROR);}
            return Math.pow(operands[0], operands[1]);
        }
    }, // ^
    ROOT(true){
        public double operate(double[] operands) throws SyntaxErrorException {
            if (!isSyntaxValid(operands, isBinary())) {throw new SyntaxErrorException(Constants.SYNTAX_ERROR);}
            return operands[0]+operands[1];
        }
    }, // √
    PERCENTAGE(true){
        public double operate(double[] operands) throws SyntaxErrorException {
            if (!isSyntaxValid(operands, isBinary())) {throw new SyntaxErrorException(Constants.SYNTAX_ERROR);}
            return operands[0]*(operands[1]/100);
        }
    }, // % - In RPN: A B % , operation would be A*(B/100);
    LOGARITHM(true){
        public double operate(double[] operands) throws SyntaxErrorException {
            if (!isSyntaxValid(operands, isBinary())) {throw new SyntaxErrorException(Constants.SYNTAX_ERROR);}
            return operands[0]+operands[1];
        }
    }, // log()
    NATURAL_LOGRARITHM(false){
        public double operate(double[] operands) throws SyntaxErrorException {
            if (!isSyntaxValid(operands, isBinary())) {throw new SyntaxErrorException(Constants.SYNTAX_ERROR);}
            return operands[0]+operands[1];
        }
    }; // ln() - Just a regular logarithm but with number e as it's base.
    
    // Trigonometry - https://en.wikipedia.org/wiki/Trigonometric_functions

    /*SINE(false) // sin()
    COSINE(false), // cos()
    TANGENT(false), // tan()
    COTANGENT(false), // cot()
    SECANT(false), // sec()
    COSECANT(false), // csc()

    ARCSINE(false), // sin()
    ARCCOSINE(false), // cos()
    ARCTANGENT(false); // tan()*/

    private boolean isBinary = true;

    private CalculatorOperator(boolean isBinary) {
        this.isBinary = isBinary;
    }

    public boolean isBinary() {
        return isBinary;
    }

    private static boolean isSyntaxValid(double[] operands, boolean isBinary) {
        if (isBinary) {
            if (operands.length != 2) {return false;}
        } else {
            if (operands.length != 1) {return false;}
        }
        return true;
    }

    public abstract double operate(double[] operands) throws SyntaxErrorException ;

}
