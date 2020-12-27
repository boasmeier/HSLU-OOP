package ch.hslu.oop.sw12;

import ch.hslu.oop.sw10.Calculate;
import ch.hslu.oop.sw10.Calculator;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author boasm
 */
public class TestCalculate {

    @Test
    public void testAdditionBothPositive() {
        Calculate calculate = new Calculator();
        long output = calculate.addition(5, 5);
        assertEquals(10, output);
    }

    @Test
    public void testAdditionBothNegative() {
        Calculate calculate = new Calculator();
        long output = calculate.addition(-5, -5);
        assertEquals(-10, output);
    }

    @Test
    public void testAdditionNegativePositive() {
        Calculate calculate = new Calculator();
        long output = calculate.addition(-5, 10);
        assertEquals(5, output);
    }

    @Test
    public void testAdditionPositiveNegative() {
        Calculate calculate = new Calculator();
        long output = calculate.addition(10, -5);
        assertEquals(5, output);
    }

    @Test
    public void testAdditionBothZero() {
        assertEquals(0L, new Calculator().addition(0, 0));
    }

    @Test
    public void testAdditionMax() {
        assertEquals(2L * Integer.MAX_VALUE, new Calculator().addition(Integer.MAX_VALUE, Integer.MAX_VALUE));

    }

}
