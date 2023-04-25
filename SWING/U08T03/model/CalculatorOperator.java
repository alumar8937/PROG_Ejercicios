package model;

import config.Constants;

public enum CalculatorOperator {
            
    ADDITION(true, "+"){
        public double operate(double[] operands) throws SyntaxErrorException {
            if (!isSyntaxValid(operands, isBinary())) {throw new SyntaxErrorException(Constants.SYNTAX_ERROR);}
            return operands[0]+operands[1];
        }
    }, // +
    SUBTRACTION(true, "-"){
        public double operate(double[] operands) throws SyntaxErrorException {
            if (!isSyntaxValid(operands, isBinary())) {throw new SyntaxErrorException(Constants.SYNTAX_ERROR);}
            return operands[0]-operands[1];
        }
    }, // -
    MULTIPLICATION(true, "·"){
        public double operate(double[] operands) throws SyntaxErrorException {
            if (!isSyntaxValid(operands, isBinary())) {throw new SyntaxErrorException(Constants.SYNTAX_ERROR);}
            return operands[0]*operands[1];
        }
    }, // ×
    DIVISION(true, "/"){
        public double operate(double[] operands) throws SyntaxErrorException {
            if (!isSyntaxValid(operands, isBinary())) {throw new SyntaxErrorException(Constants.SYNTAX_ERROR);}
            if (operands[1] == 0) {throw new SyntaxErrorException(Constants.SYNTAX_ERROR);}
            return operands[0]/operands[1];
        }
    }, // ÷
    EXPONENTIATION(true, "^"){
        public double operate(double[] operands) throws SyntaxErrorException {
            if (!isSyntaxValid(operands, isBinary())) {throw new SyntaxErrorException(Constants.SYNTAX_ERROR);}
            return Math.pow(operands[0], operands[1]);
        }
    }, // ^
    ROOT(true, "√"){
        public double operate(double[] operands) throws SyntaxErrorException {
            if (!isSyntaxValid(operands, isBinary())) {throw new SyntaxErrorException(Constants.SYNTAX_ERROR);}
            return operands[0]+operands[1];
        }
    },
    PERCENTAGE(true, "%"){
        public double operate(double[] operands) throws SyntaxErrorException {
            if (!isSyntaxValid(operands, isBinary())) {throw new SyntaxErrorException(Constants.SYNTAX_ERROR);}
            return operands[0]*(operands[1]/100);
        }
    }, // In RPN: A B % , operation would be A*(B/100);
    BASE10_LOGARITHM(false, "log10()"){
        public double operate(double[] operands) throws SyntaxErrorException {
            if (!isSyntaxValid(operands, isBinary())) {throw new SyntaxErrorException(Constants.SYNTAX_ERROR);}
            return Math.log10(operands[0]);
        }
    },
    LOGARITHM(true, "log()"){
        public double operate(double[] operands) throws SyntaxErrorException {
            if (!isSyntaxValid(operands, isBinary())) {throw new SyntaxErrorException(Constants.SYNTAX_ERROR);}
            return Math.log10(operands[0])/Math.log10(operands[1]);
        }
    }, // Logarithm of any base (log_a(x) = log(x)/log(a))
    NATURAL_LOGRARITHM(false, "ln()"){
        public double operate(double[] operands) throws SyntaxErrorException {
            if (!isSyntaxValid(operands, isBinary())) {throw new SyntaxErrorException(Constants.SYNTAX_ERROR);}
            return Math.log(operands[0]);
        }
    }, // Just a regular logarithm but with number e as it's base.
    
    // Trigonometry - https://en.wikipedia.org/wiki/Trigonometric_functions

    SINE(false, "sin()"){
        public double operate(double[] operands) throws SyntaxErrorException {
            if (!isSyntaxValid(operands, isBinary())) {throw new SyntaxErrorException(Constants.SYNTAX_ERROR);}
            return Math.sin(operands[0]);
        }
    }, // sin()
    COSINE(false, "cos()"){
        public double operate(double[] operands) throws SyntaxErrorException {
            if (!isSyntaxValid(operands, isBinary())) {throw new SyntaxErrorException(Constants.SYNTAX_ERROR);}
            return Math.cos(operands[0]);
        }
    }, // cos()
    TANGENT(false, "tan()"){
        public double operate(double[] operands) throws SyntaxErrorException {
            if (!isSyntaxValid(operands, isBinary())) {throw new SyntaxErrorException(Constants.SYNTAX_ERROR);}
            return Math.tan(operands[0]);
        }
    }, // tan()
    COTANGENT(false, "ctan()"){
        public double operate(double[] operands) throws SyntaxErrorException {
            if (!isSyntaxValid(operands, isBinary())) {throw new SyntaxErrorException(Constants.SYNTAX_ERROR);}
            return Math.cos(operands[0])/Math.sin(operands[0]);
        }
    }, // cot()
    SECANT(false, "sec()"){
        public double operate(double[] operands) throws SyntaxErrorException {
            if (!isSyntaxValid(operands, isBinary())) {throw new SyntaxErrorException(Constants.SYNTAX_ERROR);}
            return 1/Math.cos(operands[0]);
        }
    }, // sec()
    COSECANT(false, "cosec()"){
        public double operate(double[] operands) throws SyntaxErrorException {
            if (!isSyntaxValid(operands, isBinary())) {throw new SyntaxErrorException(Constants.SYNTAX_ERROR);}
            return 1/Math.sin(operands[0]);
        }
    }, // csc()

    ARCSINE(false, "asin()"){
        public double operate(double[] operands) throws SyntaxErrorException {
            if (!isSyntaxValid(operands, isBinary())) {throw new SyntaxErrorException(Constants.SYNTAX_ERROR);}
            return Math.asin(operands[0]);
        }
    }, // asin()
    ARCCOSINE(false, "acos()"){
        public double operate(double[] operands) throws SyntaxErrorException {
            if (!isSyntaxValid(operands, isBinary())) {throw new SyntaxErrorException(Constants.SYNTAX_ERROR);}
            return Math.acos(operands[0]);
        }
    }, // acos()
    ARCTANGENT(false, "atan()"){
        public double operate(double[] operands) throws SyntaxErrorException {
            if (!isSyntaxValid(operands, isBinary())) {throw new SyntaxErrorException(Constants.SYNTAX_ERROR);}
            return Math.atan(operands[0]);
        }
    }; // atan()

    private boolean isBinary = true;
    private String stringExpression = "";

    private CalculatorOperator(boolean isBinary, String stringExpression) {
        this.isBinary = isBinary;
        this.stringExpression = stringExpression;
    }

    public String getStringExpression() {
        return stringExpression;
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

    public abstract double operate(double[] operands) throws SyntaxErrorException;

}