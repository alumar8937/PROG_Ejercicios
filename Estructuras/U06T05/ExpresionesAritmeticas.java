import java.util.Stack;

// Pedro Marín Sanchis 21/03/2023

public class ExpresionesAritmeticas {

    private static final char CARACTER_SEPARADOR = ' ';
    public static void main(String[] args) {

        System.out.println(evaluarExpresionPila("2 4 6 3 / * +")); // 10
        System.out.println(evaluarExpresionPila("6")); // 6
        System.out.println(evaluarExpresionPila("3 5 4 + *")); // 27
        System.out.println(evaluarExpresionPila("8 1 1 - /")); // ERROR
        System.out.println(evaluarExpresionPila("1 1 - 8 /")); // 0
        System.out.println(evaluarExpresionPila("0 0 /")); // ERROR
        /*System.out.println(evaluarExpresionCola("2 4 6 3 / * +")); // 6
        System.out.println(evaluarExpresionCola("6")); // 6
        System.out.println(evaluarExpresionCola("3 5 4 + *")); // 32
        System.out.println(evaluarExpresionCola("8 1 1 - /")); // 7
        System.out.println(evaluarExpresionCola("1 1 - 8 /")); // ERROR
        System.out.println(evaluarExpresionCola("0 0 /")); // ERROR*/

    }

    private static String evaluarExpresionPila(String entrada) {
        Double resultado = 0.0;
        Stack<Double> numeros = obtenerStackNumeros(entrada);
        Stack<Character> operadores = obtenerStackOperadores(entrada);
        if (numeros.size() == 1) {return numeros.pop()+"";}
        if (numeros.size() < 1) {return "ERROR";}
        if (operadores.size() < numeros.size() - 1) {return "ERROR";}
        try {
            resultado = numeros.pop();
            while (!numeros.empty()) {
                resultado = operar(numeros.pop(), resultado, operadores.pop());
            }
        } catch (Exception e) {
            return "ERROR";
        }
        return resultado+"";
    }

    public static Stack<Double> obtenerStackNumeros(String entrada) {
        entrada = entrada.replaceAll("[^0-9]", " ").replaceAll(" +", " ").trim();
        Stack<Double> numeros = new Stack<Double>();
        for (String s: entrada.split(CARACTER_SEPARADOR+"")) {
            numeros.add(Double.parseDouble(s));
        }
        return numeros;
    }

    private static Stack<Character> obtenerStackOperadores(String entrada) {
        entrada = entrada.replaceAll("[0-9]", " ").replaceAll(" ", "");
        Stack<Character> operadores = new Stack<Character>();
        for (Character c: entrada.toCharArray()) {
            operadores.add(c); //HAY QUE PONERLOS DEL REVÉS!
        }
        return operadores;
    }

    private static Double operar(Double a, Double b, char operador) throws Exception{
        switch (operador) {
            case '*':
                return a*b;
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '/':
                return a/b;
            default:
                throw new Exception();
        }
    }

}