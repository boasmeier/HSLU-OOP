/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw08;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
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
public class TemperaturTest {

    public TemperaturTest() {
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

    @Test
    public void testConvertCelsiusToKelvin() {
        Temperatur temperatur = new Temperatur(20);
        assertEquals(temperatur.getTempC() + 273.15, temperatur.getTempK());
    }

    @Test
    public void testConvertKelvinToCelsius() {
        Temperatur temperatur = new Temperatur(20);
        assertEquals(temperatur.getTempK() - 273.15, temperatur.getTempC());
    }

    /**
     * Test of equals and hashcode methods, of class Person.
     */
    @Test
    public void testEqualsWithVerifier() {
        EqualsVerifier.forClass(Temperatur.class)
                .suppress(Warning.NONFINAL_FIELDS)
                .withIgnoredFields("tempFahrenheit", "tempKelvin", "element", "siedepunktKelvin", "schmelzpunktKelvin", "aggregatszustand")
                .verify();
    }

    @Test
    public void testComparableLess() {
        Temperatur temperatur1 = new Temperatur(20);
        Temperatur temperatur2 = new Temperatur(25);
        var output = temperatur1.compareTo(temperatur2);
        assertEquals(-1, output);
    }

    @Test
    public void testComparableGreater() {
        Temperatur temperatur1 = new Temperatur(20);
        Temperatur temperatur2 = new Temperatur(25);
        var output = temperatur2.compareTo(temperatur1);
        assertEquals(1, output);
    }

    @Test
    public void testComparableEquals() {
        Temperatur temperatur1 = new Temperatur(20);
        Temperatur temperatur2 = new Temperatur(20);
        var output = temperatur1.compareTo(temperatur2);
        assertEquals(0, output);
    }

}
