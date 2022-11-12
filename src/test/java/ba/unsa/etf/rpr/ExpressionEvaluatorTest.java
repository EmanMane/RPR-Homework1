package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static ba.unsa.etf.rpr.ExpressionEvaluator.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * class that tests our evaluator algorithm, mostly the correct input and the logic of algorithm itself
 */
class ExpressionEvaluatorTest {

    @Test
    void testEvaluate1() {
        double x = ExpressionEvaluator.evaluate("( 1 + ( 3 x 2 ) )");
        assertEquals(7,x);
    }

    @Test
    void testEvaluate2() {
        double x = ExpressionEvaluator.evaluate("( 1 + ( 3 x ( 2 - ( 3 / ( 1 + ( sqrt 4 ) ) ) ) ) )");
        assertEquals(4,x);
    }

    @Test
    void testEvaluate3() {
        assertThrows(RuntimeException.class, () -> {
            double x = ExpressionEvaluator.evaluate("( 1 + ( 3 x 2 ) }");
        },errorMessage);
    }

    @Test
    void testEvaluate4() {
        assertThrows(RuntimeException.class, () -> {
            double x = ExpressionEvaluator.evaluate("( 1 + ( 3 x 2 ))");
        },errorMessage);
    }

    @Test
    void testIsNumeric() {
        assertEquals(isNumeric("8.2993"),true);
    }

    @Test
    void testOperatorChecker() {
        assertThrows(RuntimeException.class, () -> operatorChecker("{"),errorMessage);
    }

}