package ch.hslu.oop.sw07;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author boasm
 */
public class DemoTest {

    public DemoTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of max1 method, of class Demo.
     */
    @Test
    public void test1Max1() {
        Demo demo = new Demo();
        int output = demo.max1(1, 2, 3);
        assertEquals(3, output);
    }

    @Test
    public void test2Max1() {
        Demo demo = new Demo();
        int output = demo.max1(3, 1, 2);
        assertEquals(3, output);
    }

    @Test
    public void test3Max1() {
        Demo demo = new Demo();
        int output = demo.max1(2, 3, 1);
        assertEquals(3, output);
    }

}
