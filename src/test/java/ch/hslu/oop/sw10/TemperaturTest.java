/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw10;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
        Temperatur temperatur = Temperatur.createFromCelsius(20);
        assertEquals(temperatur.getTempC() + 273.15, temperatur.getTempK());
    }

    @Test
    public void testConvertKelvinToCelsius() {
        Temperatur temperatur = Temperatur.createFromCelsius(20);
        assertEquals(temperatur.getTempK() - 273.15, temperatur.getTempC());
    }

    @Test
    public void testCreateFromCelsius() {
        Temperatur temperatur = Temperatur.createFromCelsius(30);
        assertEquals(30, temperatur.getTempC());
    }

    @Test
    public void testCreateFromKelvin() {
        Temperatur temperatur = Temperatur.createFromKelvin(273.15);
        assertEquals(0, temperatur.getTempC());
    }

    @Test
    void testIllegalArgumentExceptionCelsius() {
        final Exception e
                = assertThrows(IllegalArgumentException.class, () -> {
                    Temperatur.createFromCelsius(-273.16);
                });
        assertEquals("The entered celsius value is less than -273.15", e.getMessage());
    }

    @Test
    void testIllegalArgumentExceptionKelvin() {
        final Exception e
                = assertThrows(IllegalArgumentException.class, () -> {
                    Temperatur.createFromKelvin(-0.1);
                });
        assertEquals("The entered kelvin value is less than 0", e.getMessage());
    }

    /**
     * Test of equals and hashcode methods, of class Person.
     */
    @Test
    public void testEqualsWithVerifier() {
        EqualsVerifier.forClass(Temperatur.class)
                .suppress(Warning.NONFINAL_FIELDS)
                .withIgnoredFields("element", "siedepunktKelvin", "schmelzpunktKelvin", "aggregatszustand")
                .verify();
    }

    @Test
    public void testComparableLess() {
        Temperatur temperatur1 = Temperatur.createFromCelsius(20);
        Temperatur temperatur2 = Temperatur.createFromCelsius(25);
        var output = temperatur1.compareTo(temperatur2);
        assertEquals(-1, output);
    }

    @Test
    public void testComparableGreater() {
        Temperatur temperatur1 = Temperatur.createFromCelsius(20);
        Temperatur temperatur2 = Temperatur.createFromCelsius(25);
        var output = temperatur2.compareTo(temperatur1);
        assertEquals(1, output);
    }

    @Test
    public void testComparableEquals() {
        Temperatur temperatur1 = Temperatur.createFromCelsius(20);
        Temperatur temperatur2 = Temperatur.createFromCelsius(20);
        var output = temperatur1.compareTo(temperatur2);
        assertEquals(0, output);
    }

}
