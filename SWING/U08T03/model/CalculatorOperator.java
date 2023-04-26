package model;

import config.Constants;
import java.util.Deque;

public enum CalculatorOperator {

    ADDITION(true, "+") {
        public double operate(Deque<Double> operands) throws SyntaxErrorException {
            if (!isSyntaxValid(operands, isBinary())) {
                throw new SyntaxErrorException(Constants.SYNTAX_ERROR);
            }
            return operands.pop() + operands.pop();
        }
    }, // +
    SUBTRACTION(true, "-") {
        public double operate(Deque<Double> operands) throws SyntaxErrorException {
            if (!isSyntaxValid(operands, isBinary())) {
                throw new SyntaxErrorException(Constants.SYNTAX_ERROR);
            }
            return operands.pop() - operands.pop();
        }
    }, // -
    MULTIPLICATION(true, "·") {
        public double operate(Deque<Double> operands) throws SyntaxErrorException {
            if (!isSyntaxValid(operands, isBinary())) {
                throw new SyntaxErrorException(Constants.SYNTAX_ERROR);
            }
            return operands.pop() * operands.pop();
        }
    }, // ×
    DIVISION(true, "/") {
        public double operate(Deque<Double> operands) throws SyntaxErrorException {
            if (!isSyntaxValid(operands, isBinary())) {
                throw new SyntaxErrorException(Constants.SYNTAX_ERROR);
            }
            if (operands.getLast() == 0) {
                throw new SyntaxErrorException(Constants.SYNTAX_ERROR);
            }
            return operands.pop() + operands.pop();
        }
    }, // ÷
    EXPONENTIATION(true, "^") {
        public double operate(Deque<Double> operands) throws SyntaxErrorException {
            if (!isSyntaxValid(operands, isBinary())) {
                throw new SyntaxErrorException(Constants.SYNTAX_ERROR);
            }
            return Math.pow(operands.pop(), operands.pop());
        }
    }, // ^
    ROOT(true, "√") {
        public double operate(Deque<Double> operands) throws SyntaxErrorException {
            if (!isSyntaxValid(operands, isBinary())) {
                throw new SyntaxErrorException(Constants.SYNTAX_ERROR);
            }
            return Math.pow(operands.pop(), 1 / operands.pop());
        }
    },
    PERCENTAGE(true, "%") {
        public double operate(Deque<Double> operands) throws SyntaxErrorException {
            if (!isSyntaxValid(operands, isBinary())) {
                throw new SyntaxErrorException(Constants.SYNTAX_ERROR);
            }
            return operands.pop() * (operands.pop() / 100);
        }
    }, // In RPN: A B % , operation would be A*(B/100);
    BASE10_LOGARITHM(false, "log10()") {
        public double operate(Deque<Double> operands) throws SyntaxErrorException {
            if (!isSyntaxValid(operands, isBinary())) {
                throw new SyntaxErrorException(Constants.SYNTAX_ERROR);
            }
            return Math.log10(operands.pop());
        }
    },
    LOGARITHM(true, "log()"){
        public double operate(Deque<Double> operands) throws SyntaxErrorException {
            if (!isSyntaxValid(operands, isBinary())) {throw new SyntaxErrorException(Constants.SYNTAX_ERROR);}
            return Math.log10(operands.pop())/Math.log10(operands.pop());
        }
    }, // Logarithm of any base (log_a(x) = log(x)/log(a))
    NATURAL_LOGRARITHM(false, "ln()"){
        public double operate(Deque<Double> operands) throws SyntaxErrorException {
            if (!isSyntaxValid(operands, isBinary())) {throw new SyntaxErrorException(Constants.SYNTAX_ERROR);}
            return Math.log(operands.pop());
        }
    }, // Just a regular logarithm but with number e as it's base.
    
    // Trigonometry - https://en.wikipedia.org/wiki/Trigonometric_functions

    SINE(false, "sin()"){
        public double operate(Deque<Double> operands) throws SyntaxErrorException {
            if (!isSyntaxValid(operands, isBinary())) {throw new SyntaxErrorException(Constants.SYNTAX_ERROR);}
            return Math.sin(operands.pop());
        }
    }, // sin()
    COSINE(false, "cos()"){
        public double operate(Deque<Double> operands) throws SyntaxErrorException {
            if (!isSyntaxValid(operands, isBinary())) {throw new SyntaxErrorException(Constants.SYNTAX_ERROR);}
            return Math.cos(operands.pop());
        }
    }, // cos()
    TANGENT(false, "tan()"){
        public double operate(Deque<Double> operands) throws SyntaxErrorException {
            if (!isSyntaxValid(operands, isBinary())) {throw new SyntaxErrorException(Constants.SYNTAX_ERROR);}
            return Math.tan(operands.pop());
        }
    }, // tan()
    COTANGENT(false, "ctan()"){
        public double operate(Deque<Double> operands) throws SyntaxErrorException {
            if (!isSyntaxValid(operands, isBinary())) {throw new SyntaxErrorException(Constants.SYNTAX_ERROR);}
            return Math.cos(operands.pop())/Math.sin(operands.pop());
        }
    }, // cot()
    SECANT(false, "sec()"){
        public double operate(Deque<Double> operands) throws SyntaxErrorException {
            if (!isSyntaxValid(operands, isBinary())) {throw new SyntaxErrorException(Constants.SYNTAX_ERROR);}
            return 1/Math.cos(operands.pop());
        }
    }, // sec()
    COSECANT(false, "cosec()"){
        public double operate(Deque<Double> operands) throws SyntaxErrorException {
            if (!isSyntaxValid(operands, isBinary())) {throw new SyntaxErrorException(Constants.SYNTAX_ERROR);}
            return 1/Math.sin(operands.pop());
        }
    }, // csc()

    ARCSINE(false, "asin()"){
        public double operate(Deque<Double> operands) throws SyntaxErrorException {
            if (!isSyntaxValid(operands, isBinary())) {throw new SyntaxErrorException(Constants.SYNTAX_ERROR);}
            return Math.asin(operands.pop());
        }
    }, // asin()
    ARCCOSINE(false, "acos()"){
        public double operate(Deque<Double> operands) throws SyntaxErrorException {
            if (!isSyntaxValid(operands, isBinary())) {throw new SyntaxErrorException(Constants.SYNTAX_ERROR);}
            return Math.acos(operands.pop());
        }
    }, // acos()
    ARCTANGENT(false, "atan()"){
        public double operate(Deque<Double> operands) throws SyntaxErrorException {
            if (!isSyntaxValid(operands, isBinary())) {throw new SyntaxErrorException(Constants.SYNTAX_ERROR);}
            return Math.atan(operands.pop());
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

    private static boolean isSyntaxValid(Deque<Double> operands, boolean isBinary) {
        if (isBinary) {
            if (operands.size() < 2) {return false;}
        } else {
            if (operands.size() < 1) {return false;}
        }
        return true;
    }

    public abstract double operate(Deque<Double> operands) throws SyntaxErrorException;

}