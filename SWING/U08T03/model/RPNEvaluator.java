package model;

public class RPNEvaluator {

    public enum Operation {
        
        ADDITION(true), // +
        SUBTRACTION(true), // -
        MULTIPLICATION(true), // ×
        DIVISION(true), // ÷
        EXPONENTIATION(true), // ^
        ROOT(true), // √
        PERCENTAGE(true), // % - In RPN: A B % , operation would be A*(B/100);
        LOGARITHM(true), // log()
        NATURAL_LOGRARITHM(false), // ln() - Just a regular logarithm but with number e as it's base.
        
        // Trigonometry - https://en.wikipedia.org/wiki/Trigonometric_functions

        SINE(false), // sin()
        COSINE(false), // cos()
        TANGENT(false), // tan()
        COTANGENT(false), // cot()
        SECANT(false), // sec()
        COSECANT(false), // csc()

        ARCSINE(false), // sin()
        ARCCOSINE(false), // cos()
        ARCTANGENT(false); // tan()

        private boolean binary = true;

        Operation(boolean binary) {
            this.binary = binary;
        }

        public boolean isBinary() {
            return binary;
        }

    }

    public int evaluateRPNSentence(String sentence) {
        return 0;
    }
}
