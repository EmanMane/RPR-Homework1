package ba.unsa.etf.rpr;

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
        if (args.length % 2 == 0){
            throw new RuntimeException(errorMessage);
        }
        StringBuilder input = new StringBuilder("");
        for(String s : args) {
            operatorChecker(s);
            input.append(s).append(" ");
        }
        double result = evaluate(String.valueOf(input));
        System.out.println("The result using \"Dijkstra's Algorithm for expression evaluation\" is " + result);
    }
}
