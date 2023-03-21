import java.util.Stack;

// Pedro Marín Sanchis 21/03/2023

public class Parentesis {

    private static final String APERTURAS_ACEPTADAS = "([{";
    private static final String TERMINACIONES_ACEPTADAS = ")]}";

    public static void main(String[] args) {
        System.out.println(evaluarParentesis("([{}])}")); //true
        System.out.println(evaluarParentesis("{uno}{otro}])([])}")); //true
        System.out.println(evaluarParentesis("{dos}}])([])}")); //false
        System.out.println(evaluarParentesis("{}{}])[])}")); //false
    }

    public static boolean evaluarParentesis(String expresion) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expresion.length(); i++) {
            for (int j = 0; j < APERTURAS_ACEPTADAS.length(); j++){
                if (expresion.charAt(i) == APERTURAS_ACEPTADAS.charAt(j)) {
                    stack.add(APERTURAS_ACEPTADAS.charAt(j));
                }
            }
            for (int j = 0; j < TERMINACIONES_ACEPTADAS.length(); j++){
                if (expresion.charAt(i) == TERMINACIONES_ACEPTADAS.charAt(j)) {
                    if (APERTURAS_ACEPTADAS.charAt(j) != stack.peek()){
                        return false;
                    } else {
                        stack.pop();
                    }
                }
            }
        }

        return stack.empty();

    }

}