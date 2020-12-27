package ch.hslu.oop.sw07;

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
        int output = calculate.addition(5, 5);
        assertEquals(10, output);
    }

    @Test
    public void testAdditionBothNegative() {
        Calculate calculate = new Calculator();
        int output = calculate.addition(-5, -5);
        assertEquals(-10, output);
    }

    @Test
    public void testAdditionNegativePositive() {
        Calculate calculate = new Calculator();
        int output = calculate.addition(-5, 10);
        assertEquals(5, output);
    }

    @Test
    public void testAdditionPositiveNegative() {
        Calculate calculate = new Calculator();
        int output = calculate.addition(10, -5);
        assertEquals(5, output);
    }

    @Test
    public void testAdditionBothZero() {
        Calculate calculate = new Calculator();
        int output = calculate.addition(0, 0);
        assertEquals(0, output);
    }

}
