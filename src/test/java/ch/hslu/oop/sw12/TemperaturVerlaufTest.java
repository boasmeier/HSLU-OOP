/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw12;

import java.util.ArrayList;
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
        final ArrayList<Temperatur> history = new ArrayList<>();
        verlauf.add(temperatur, history);
        var output = history.contains(temperatur);
        assertEquals(true, output);
    }

    /**
     * Test of clear method, of class TemperaturVerlauf.
     */
    @Test
    public void testClear() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        Temperatur temperatur = Temperatur.createFromCelsius(20);
        final ArrayList<Temperatur> history = new ArrayList<>();
        verlauf.add(temperatur, history);
        verlauf.clear(history);
        var output = history.contains(temperatur);
        assertEquals(false, output);
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
        final ArrayList<Temperatur> history = new ArrayList<>();
        verlauf.add(temperatur, history);
        verlauf.add(temperatur1, history);
        verlauf.add(temperatur2, history);
        var output = verlauf.getCount(history);
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
        final ArrayList<Temperatur> history = new ArrayList<>();
        verlauf.add(temperatur, history);
        verlauf.add(temperatur1, history);
        verlauf.add(temperatur2, history);
        var output = verlauf.getCountWithStream(history);
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
        final ArrayList<Temperatur> history = new ArrayList<>();
        verlauf.add(temperatur, history);
        verlauf.add(temperatur1, history);
        verlauf.add(temperatur2, history);
        var output = verlauf.getMax(history);
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
        final ArrayList<Temperatur> history = new ArrayList<>();
        verlauf.add(temperatur, history);
        verlauf.add(temperatur1, history);
        verlauf.add(temperatur2, history);
        var output = verlauf.getMaxWithStream(history);
        assertEquals(30 + 273.15, output);
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
        final ArrayList<Temperatur> history = new ArrayList<>();
        verlauf.add(temperatur, history);
        verlauf.add(temperatur1, history);
        verlauf.add(temperatur2, history);
        var output = verlauf.getMin(history);
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
        final ArrayList<Temperatur> history = new ArrayList<>();
        verlauf.add(temperatur, history);
        verlauf.add(temperatur1, history);
        verlauf.add(temperatur2, history);
        var output = verlauf.getMinWithStream(history);
        assertEquals(20 + 273.15, output);
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
        final ArrayList<Temperatur> history = new ArrayList<>();
        verlauf.add(temperatur, history);
        verlauf.add(temperatur1, history);
        verlauf.add(temperatur2, history);
        var output = verlauf.getAverage(history);
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
        final ArrayList<Temperatur> history = new ArrayList<>();
        verlauf.add(temperatur, history);
        verlauf.add(temperatur1, history);
        verlauf.add(temperatur2, history);
        var output = verlauf.getAverageWithStream(history);
        assertEquals(298.15, output);
    }

    /**
     * Test of getAndPrintBetween20And25 method, of class TemperaturVerlauf.
     */
    @Test
    public void getAndPrintBetween20And25() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        Temperatur temperatur = Temperatur.createFromCelsius(19.99);
        Temperatur temperatur1 = Temperatur.createFromCelsius(20);
        Temperatur temperatur2 = Temperatur.createFromCelsius(25);
        Temperatur temperatur3 = Temperatur.createFromCelsius(25.0001);
        Temperatur temperatur4 = Temperatur.createFromCelsius(30);
        final ArrayList<Temperatur> history = new ArrayList<>();
        verlauf.add(temperatur, history);
        verlauf.add(temperatur1, history);
        verlauf.add(temperatur2, history);
        verlauf.add(temperatur3, history);
        verlauf.add(temperatur4, history);
        var output = verlauf.getAndPrintBetween20And25(history);
        assertEquals(2, output);
    }

    /**
     * Test of getAndPrintBetween20And25 method, of class TemperaturVerlauf.
     */
    @Test
    public void getAndPrintBetween20And25WithStream() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        Temperatur temperatur = Temperatur.createFromCelsius(19.99);
        Temperatur temperatur1 = Temperatur.createFromCelsius(20);
        Temperatur temperatur2 = Temperatur.createFromCelsius(25);
        Temperatur temperatur3 = Temperatur.createFromCelsius(25.0001);
        Temperatur temperatur4 = Temperatur.createFromCelsius(30);
        final ArrayList<Temperatur> history = new ArrayList<>();
        verlauf.add(temperatur, history);
        verlauf.add(temperatur1, history);
        verlauf.add(temperatur2, history);
        verlauf.add(temperatur3, history);
        verlauf.add(temperatur4, history);
        var output = verlauf.getAndPrintBetween20And25WithStream(history);
        assertEquals(2, output);
    }

}
