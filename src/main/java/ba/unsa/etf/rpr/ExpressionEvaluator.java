package ba.unsa.etf.rpr;

import java.util.Stack;

import static java.lang.Double.parseDouble;

/**
 * ExpressionEvaluator class that uses two Stacks to calculate
 * expression in format like ( a + ( b - ( c * ( d / ( sqrt e ) ) ) ) )
 * where a, b, c, d, e are real numbers
 * @author Eman Alibalić
 */
public class ExpressionEvaluator {

    private static final Stack<String> operators = new Stack<String>();

    private static final Stack<Double> operands = new Stack<Double>();;

    /**
     * evaluate method that receives a string and calculates its value using Dijkstra's Algorithm
     */
    public static double evaluate(String s){
        int bracketCheck=0,bracketClosed=0,operatorCounter=0,operatorCache=0;
        operators.removeAllElements();
        operands.removeAllElements();
        String[] arrOfStr = s.split(" ");
        if(arrOfStr.length<4) throw new RuntimeException(errorMessage);
        for(String x : arrOfStr){
            operatorChecker(x);
            if(x.equals("("))         {bracketCheck++; operatorCache=0;}
            else if(x.equals("+"))    {operators.push(x); operatorCounter++; operatorCache++;}
            else if(x.equals("-"))    {operators.push(x); operatorCounter++; operatorCache++;}
            else if(x.equals("x"))    {operators.push(x); operatorCounter++; operatorCache++;}
            else if(x.equals("/"))    {operators.push(x); operatorCounter++; operatorCache++;}
            else if(x.equals("sqrt")) {operators.push(x); operatorCounter++; operatorCache++;}
            else if(x.equals(")")){
                bracketCheck--; bracketClosed++;
                if(operators.size()>operands.size() || operatorCache!=1) throw new RuntimeException(errorMessage);
                String operator = operators.pop();
                double operand = operands.pop();
                if (operator.equals("+")) operand = operands.pop() + operand;
                else if (operator.equals("-")) operand = operands.pop() - operand;
                else if (operator.equals("x")) operand = operands.pop() * operand;
                else if (operator.equals("/")) operand = operands.pop() / operand;
                else if (operator.equals("sqrt")) operand = Math.sqrt(operand);
                operands.push(operand);
            }
            else operands.push(parseDouble(x));
            if(bracketCheck<operators.size()) throw new RuntimeException(errorMessage);
        }
        if(bracketCheck!=0 || operatorCounter!=bracketClosed) throw new RuntimeException(errorMessage);
        return operands.pop();
    }

    /**
     * Checks if the given string is a valid and pre-defined operator or a real number, throws exception if it isn't
     */
    static void operatorChecker(String x) {
        if(!x.equals("(") && !x.equals("+") && !x.equals("-") && !x.equals("sqrt") && !x.equals("x") && !x.equals("/") && !x.equals(")") && !isNumeric(x)){
            throw new RuntimeException(errorMessage);
        }
    }

    /**
     * checks if String is a real number (double)
     * @param string string that is being checked
     * @return true if string is a real number and false if it isn't
     */
    public static boolean isNumeric(String string) {
        double intValue;
        try {
            intValue = Double.parseDouble(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * main error message that ends in output stream if input is not as expected
     */
    public static String errorMessage = "Unsupported format!" +
            "\nNOTE: Please use this reference: ( a + ( b - ( c * ( d / ( sqrt e ) ) ) ) )" +
            "\na, b, c, d, e - real number values" +
            "\nThe order of operators You use in expression is not important but note that n-operators need n-bracket pairs";

}
