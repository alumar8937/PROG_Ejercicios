import model.operator.CalculatorOperator;

// RPNCalculator - Pedro Marín Sanchis - 24/04/2023
// https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller

public class RPNCalculator {
    public static void main(String[] args) {
        /*RPNCalculatorModel model = new RPNCalculatorModel();
        RPNCalculatorController controller = new RPNCalculatorController(model);
        RPNCalculatorView view = new RPNCalculatorView(controller);*/

        try {
            System.out.println(CalculatorOperator.ADDITION.operate(new double[]{1,2}));   
            System.out.println(CalculatorOperator.SUBTRACTION.operate(new double[]{1,2})); 
            System.out.println(CalculatorOperator.MULTIPLICATION.operate(new double[]{1,2})); 
            System.out.println(CalculatorOperator.DIVISION.operate(new double[]{1,2})); 
            System.out.println(CalculatorOperator.EXPONENTIATION.operate(new double[]{2,4})); 
        } catch (Exception e) {
            System.out.println("JEfe ha petao");
        }

    }
}