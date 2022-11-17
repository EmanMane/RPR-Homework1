package ba.unsa.etf.rpr;

import java.util.Objects;

import static ba.unsa.etf.rpr.ExpressionEvaluator.*;

/**
 * Entry point to our Dijkstra's Algorithm program
 * @author Eman Alibalic
 * @version 1.0
 */
public class App 
{
    /**
     * Main method of our App
     * @param args array of strings in format ( a + ( b - ( c * ( d / ( sqrt e ) ) ) ) )
     */
    public static void main(String[] args){
        try {
            if (args.length < 4 || !Objects.equals(args[0], "(")) {
                throw new RuntimeException(errorMessage);
            }
            StringBuilder input = new StringBuilder("");
            for (String s : args) {
                operatorChecker(s);
                input.append(s).append(" ");
            }
            double result = evaluate(String.valueOf(input));
            if(Objects.equals(result,Double.POSITIVE_INFINITY) || Objects.equals(result,Double.NEGATIVE_INFINITY)) throw new RuntimeException("Zero is not dividable!");
            System.out.println("The result using \"Dijkstra's Algorithm for expression evaluation\" is " + result);
        }catch(Exception e) {
            System.out.println(e);
        }
    }
}
