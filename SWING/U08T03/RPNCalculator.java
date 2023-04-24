import controller.RPNCalculatorController;
import model.RPNCalculatorModel;
import view.RPNCalculatorView;

// RPNCalculator - Pedro Marín Sanchis - 24/04/2023
// https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller

public class RPNCalculator {
    public static void main(String[] args) {
        RPNCalculatorModel model = new RPNCalculatorModel();
        RPNCalculatorController controller = new RPNCalculatorController(model);
        RPNCalculatorView view = new RPNCalculatorView(controller);
    }
}