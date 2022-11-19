package ba.unsa.etf.rpr;

import java.util.Stack;

import static java.lang.Double.parseDouble;

/**
 * ExpressionEvaluator class that uses two Stacks to calculate
 * expression in format like ( a + ( b - ( c * ( d / sqrt ( e ) ) ) ) )
 * where a, b, c, d, e are real numbers, can be inputted in format sqrt ( a )
 * @author Eman Alibalić
 */
public class ExpressionEvaluator {

    private static final Stack<String> operators = new Stack<String>();

    private static final Stack<Double> operands = new Stack<Double>();;

    /**
     * evaluate method that receives a string and calculates its value using Dijkstra's Algorithm
     */
    public static double evaluate(String s){
        int bracketOpen=0,bracketClosed=0,bracketCheck=0,sqrtCheck=0,operatorCounter=0,operandCounter=0,operatorCache=0;
        operators.removeAllElements();
        operands.removeAllElements();
        String[] arrOfStr = s.split(" ");
        if(arrOfStr.length<4) throw new RuntimeException(errorMessage);
        for(String x : arrOfStr){
            operatorChecker(x);
            if(x.equals("(")){
                if(operatorCache>2) throw new RuntimeException(errorMessage);
                if(sqrtCheck==1) sqrtCheck++;
                bracketCheck++; operatorCache=0; bracketOpen++;
            }
            else if(x.equals("+")){
                if(sqrtCheck>0) throw new RuntimeException(errorMessage);
                operators.push(x); operatorCounter++; operatorCache++;
            }
            else if(x.equals("-")){
                if(sqrtCheck>0) throw new RuntimeException(errorMessage);
                operators.push(x); operatorCounter++; operatorCache++;
            }
            else if(x.equals("*")){
                if(sqrtCheck>0) throw new RuntimeException(errorMessage);
                operators.push(x); operatorCounter++; operatorCache++;
            }
            else if(x.equals("/")){
                if(sqrtCheck>0) throw new RuntimeException(errorMessage);
                operators.push(x); operatorCounter++; operatorCache++;
            }
            else if(x.equals("sqrt")){
                if(sqrtCheck>0) throw new RuntimeException(errorMessage);
                operators.push(x); sqrtCheck++;
            }
            else if(x.equals(")")){
                if(operatorCache>1 || ( sqrtCheck>0 && sqrtCheck!=3 ) || operators.isEmpty()) throw new RuntimeException(errorMessage);
                sqrtCheck=0; bracketClosed++;
                String operator = operators.pop();
                double operand = operands.pop();
                if (operator.equals("+")) operand = operands.pop() + operand;
                else if (operator.equals("-")) operand = operands.pop() - operand;
                else if (operator.equals("*")) operand = operands.pop() * operand;
                else if (operator.equals("/")) operand = operands.pop() / operand;
                else if (operator.equals("sqrt")) operand = Math.sqrt(operand);
                operands.push(operand);
            }
            else {
                operands.push(parseDouble(x));
                if(sqrtCheck==2) sqrtCheck++; operandCounter++;
            }
            if(bracketCheck<operatorCounter) throw new RuntimeException(errorMessage);
        }
        if(operatorCounter!=operandCounter-1 || bracketOpen!=bracketClosed) throw new RuntimeException(errorMessage);
        return operands.pop();
    }

    /**
     * Checks if the given string is a valid and pre-defined operator or a real number, throws exception if it isn't
     */
    static void operatorChecker(String x) {
        if(!x.equals("(") && !x.equals("+") && !x.equals("-") && !x.equals("sqrt") && !x.equals("*") && !x.equals("/") && !x.equals(")") && !isNumeric(x)){
            throw new RuntimeException(errorMessage);
        }
    }

    /**
     * checks if String is a real number (double)
     * @param string string that is being checked
     * @return true if string is a real number and false if it isn't
     */
    public static boolean isNumeric(String string) {
        try {
            double intValue = Double.parseDouble(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * main error message that ends in output stream if input is not as expected
     */
    public static String errorMessage = """
            Unsupported format!
            NOTE: Please use this reference: ( a + ( b - ( c * ( d / e ) ) ) )
            a, b, c, d, e - real number values, can be represented as a = sqrt ( 4 )
            The order of operators You use in expression is not important but note that n-operators need n-bracket pairs
            Root of a negative number is NaN""";

}
