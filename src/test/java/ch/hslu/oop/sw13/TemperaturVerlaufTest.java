/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw13;

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
public class TemperaturVerlaufTest {

    public TemperaturVerlaufTest() {
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
     * Test of add method, of class TemperaturVerlauf.
     */
    @Test
    public void testAdd() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        Temperatur temperatur = Temperatur.createFromCelsius(20);
        verlauf.add(temperatur);
        var output = verlauf.getCount();
        assertEquals(1, output);
    }

    /**
     * Test of clear method, of class TemperaturVerlauf.
     */
    @Test
    public void testClear() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        Temperatur temperatur = Temperatur.createFromCelsius(20);
        verlauf.add(temperatur);
        verlauf.clear();
        var output = verlauf.getCount();
        assertEquals(0, output);
    }

    /**
     * Test of getCount method, of class TemperaturVerlauf.
     */
    @Test
    public void testGetCount() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        Temperatur temperatur = Temperatur.createFromCelsius(20);
        Temperatur temperatur1 = Temperatur.createFromCelsius(25);
        Temperatur temperatur2 = Temperatur.createFromCelsius(30);
        verlauf.add(temperatur);
        verlauf.add(temperatur1);
        verlauf.add(temperatur2);
        var output = verlauf.getCount();
        assertEquals(3, output);
    }

    /**
     * Test of getCount method, of class TemperaturVerlauf.
     */
    @Test
    public void testGetCountWithStream() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        Temperatur temperatur = Temperatur.createFromCelsius(20);
        Temperatur temperatur1 = Temperatur.createFromCelsius(25);
        Temperatur temperatur2 = Temperatur.createFromCelsius(30);
        verlauf.add(temperatur);
        verlauf.add(temperatur1);
        verlauf.add(temperatur2);
        var output = verlauf.getCountWithStream();
        assertEquals(3, output);
    }

    /**
     * Test of getMax method, of class TemperaturVerlauf.
     */
    @Test
    public void testGetMax() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        Temperatur temperatur = Temperatur.createFromCelsius(20);
        Temperatur temperatur1 = Temperatur.createFromCelsius(25);
        Temperatur temperatur2 = Temperatur.createFromCelsius(30);
        verlauf.add(temperatur);
        verlauf.add(temperatur1);
        verlauf.add(temperatur2);
        var output = verlauf.getMax();
        assertEquals(30 + 273.15, output);
    }

    /**
     * Test of getMax method, of class TemperaturVerlauf.
     */
    @Test
    public void testGetMaxWithStream() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        Temperatur temperatur = Temperatur.createFromCelsius(20);
        Temperatur temperatur1 = Temperatur.createFromCelsius(25);
        Temperatur temperatur2 = Temperatur.createFromCelsius(30);
        verlauf.add(temperatur);
        verlauf.add(temperatur1);
        verlauf.add(temperatur2);
        var output = verlauf.getMaxWithStream();
        assertEquals(30 + 273.15, output);
    }

    /**
     * Test of getMaxObjectWithStream method, of class TemperaturVerlauf.
     */
    @Test
    public void testGetMaxObjectWithStream() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        Temperatur temperatur = Temperatur.createFromCelsius(20);
        Temperatur temperatur1 = Temperatur.createFromCelsius(25);
        Temperatur temperatur2 = Temperatur.createFromCelsius(30);
        verlauf.add(temperatur);
        verlauf.add(temperatur1);
        verlauf.add(temperatur2);
        Temperatur output = verlauf.getMaxObjectWithStream();
        assertEquals(temperatur2, output);
    }

    /**
     * Test of getMin method, of class TemperaturVerlauf.
     */
    @Test
    public void testGetMin() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        Temperatur temperatur = Temperatur.createFromCelsius(20);
        Temperatur temperatur1 = Temperatur.createFromCelsius(25);
        Temperatur temperatur2 = Temperatur.createFromCelsius(30);
        verlauf.add(temperatur);
        verlauf.add(temperatur1);
        verlauf.add(temperatur2);
        var output = verlauf.getMin();
        assertEquals(20 + 273.15, output);
    }

    /**
     * Test of getMin method, of class TemperaturVerlauf.
     */
    @Test
    public void testGetMinWithStream() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        Temperatur temperatur = Temperatur.createFromCelsius(20);
        Temperatur temperatur1 = Temperatur.createFromCelsius(25);
        Temperatur temperatur2 = Temperatur.createFromCelsius(30);
        verlauf.add(temperatur);
        verlauf.add(temperatur1);
        verlauf.add(temperatur2);
        var output = verlauf.getMinWithStream();
        assertEquals(20 + 273.15, output);
    }

    /**
     * Test of getMinObjectWithStream method, of class TemperaturVerlauf.
     */
    @Test
    public void testGetMinObjectWithStream() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        Temperatur temperatur = Temperatur.createFromCelsius(20);
        Temperatur temperatur1 = Temperatur.createFromCelsius(25);
        Temperatur temperatur2 = Temperatur.createFromCelsius(30);
        verlauf.add(temperatur);
        verlauf.add(temperatur1);
        verlauf.add(temperatur2);
        Temperatur output = verlauf.getMinObjectWithStream();
        assertEquals(temperatur, output);
    }

    /**
     * Test of getAverage method, of class TemperaturVerlauf.
     */
    @Test
    public void testGetAverage() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        Temperatur temperatur = Temperatur.createFromCelsius(20);
        Temperatur temperatur1 = Temperatur.createFromCelsius(25);
        Temperatur temperatur2 = Temperatur.createFromCelsius(30);
        verlauf.add(temperatur);
        verlauf.add(temperatur1);
        verlauf.add(temperatur2);
        var output = verlauf.getAverage();
        assertEquals(298.15, output);
    }

    /**
     * Test of getAverage method, of class TemperaturVerlauf.
     */
    @Test
    public void testGetAverageWithStream() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        Temperatur temperatur = Temperatur.createFromCelsius(20);
        Temperatur temperatur1 = Temperatur.createFromCelsius(25);
        Temperatur temperatur2 = Temperatur.createFromCelsius(30);
        verlauf.add(temperatur);
        verlauf.add(temperatur1);
        verlauf.add(temperatur2);
        var output = verlauf.getAverageWithStream();
        assertEquals(298.15, output);
    }

    /**
     * Test of getAndPrintBetween20And25 method, of class TemperaturVerlauf.
     */
    @Test
    public void testGetAndPrintBetween20And25() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        Temperatur temperatur = Temperatur.createFromCelsius(19.99);
        Temperatur temperatur1 = Temperatur.createFromCelsius(20);
        Temperatur temperatur2 = Temperatur.createFromCelsius(25);
        Temperatur temperatur3 = Temperatur.createFromCelsius(25.0001);
        Temperatur temperatur4 = Temperatur.createFromCelsius(30);
        verlauf.add(temperatur);
        verlauf.add(temperatur1);
        verlauf.add(temperatur2);
        verlauf.add(temperatur3);
        verlauf.add(temperatur4);
        var output = verlauf.getAndPrintBetween20And25();
        assertEquals(2, output);
    }

    /**
     * Test of getAndPrintBetween20And25 method, of class TemperaturVerlauf.
     */
    @Test
    public void testGetAndPrintBetween20And25WithStream() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        Temperatur temperatur = Temperatur.createFromCelsius(19.99);
        Temperatur temperatur1 = Temperatur.createFromCelsius(20);
        Temperatur temperatur2 = Temperatur.createFromCelsius(25);
        Temperatur temperatur3 = Temperatur.createFromCelsius(25.0001);
        Temperatur temperatur4 = Temperatur.createFromCelsius(30);
        verlauf.add(temperatur);
        verlauf.add(temperatur1);
        verlauf.add(temperatur2);
        verlauf.add(temperatur3);
        verlauf.add(temperatur4);
        var output = verlauf.getAndPrintBetween20And25WithStream();
        assertEquals(2, output);
    }

    /**
     * Test of getRange method, of class TemperaturVerlauf.
     */
    @Test
    public void testGetRange() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        Temperatur temperatur5 = Temperatur.createFromCelsius(18.99);
        Temperatur temperatur = Temperatur.createFromCelsius(19.99);
        Temperatur temperatur1 = Temperatur.createFromCelsius(20);
        Temperatur temperatur2 = Temperatur.createFromCelsius(25);
        Temperatur temperatur3 = Temperatur.createFromCelsius(25.0001);
        Temperatur temperatur4 = Temperatur.createFromCelsius(30);
        verlauf.add(temperatur);
        verlauf.add(temperatur1);
        verlauf.add(temperatur2);
        verlauf.add(temperatur3);
        verlauf.add(temperatur4);
        verlauf.add(temperatur5);
        var output = verlauf.getRange(19.0, 21.0);
        assertEquals(2, output);
    }

    /**
     * Test of toString method, of class TemperaturVerlauf.
     */
    @Test
    public void testToString() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        Temperatur temperatur1 = Temperatur.createFromCelsius(20);
        Temperatur temperatur2 = Temperatur.createFromCelsius(25.0001);
        verlauf.add(temperatur1);
        verlauf.add(temperatur2);
        assertEquals("TemperaturVerlauf{ Count: 2, Min: 20.0, Max 25.0001, Average : 22.5}", verlauf.toString());
    }

    /**
     * Test of addTemperaturEventListener method, of class TemperaturVerlauf.
     */
    @Test
    public void testAddTemperaturEventListener() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        TemperaturEventListener lambda = (tEvent) -> System.out.println("");;
        verlauf.addTemperaturEventListener(lambda);
        var output = verlauf.getChangeListener(0);
        assertEquals(lambda, output);
    }

    /**
     * Test of getChangeListener method, of class TemperaturVerlauf.
     */
    @Test
    public void testGetChangeListner() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        TemperaturEventListener lambda = (tEvent) -> System.out.println("");
        verlauf.addTemperaturEventListener(lambda);
        var output = verlauf.getChangeListener(0);
        assertEquals(lambda, output);
    }

    /**
     * Test of getChangeListenerSize method, of class TemperaturVerlauf.
     */
    @Test
    public void testGetChangeListnerSize() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        verlauf.addTemperaturEventListener((tEvent) -> System.out.println(""));
        var output = verlauf.getChangeListenerSize();
        assertEquals(1, output);
    }

    /**
     * Test of removeTemperaturEventListener method, of class TemperaturVerlauf.
     */
    @Test
    public void testRemoveTemperaturEventListener() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        TemperaturEventListener lambda = (tEvent) -> System.out.println("");;
        verlauf.addTemperaturEventListener(lambda);
        var output = verlauf.getChangeListener(0);
        assertEquals(lambda, output);
        verlauf.removeTemperaturEventListener(lambda);
        assertEquals(0, verlauf.getChangeListenerSize());
    }
}
