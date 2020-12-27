/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw07;

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
public class ElementTest {

    public ElementTest() {
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
     * Test of equals and hashcode methods, of class Person.
     */
    @Test
    public void testEqualsWithVerifier() {
        EqualsVerifier.forClass(Element.class)
                .suppress(Warning.NONFINAL_FIELDS)
                .withIgnoredFields("tempFahrenheit", "tempKelvin")
                .verify();
    }

    @Test
    public void testComparableLess() {
        Nitrogen nitrogen1 = new Nitrogen(20);
        Nitrogen nitrogen2 = new Nitrogen(25);
        var output = nitrogen1.compareTo(nitrogen2);
        assertEquals(-1, output);
    }

    @Test
    public void testComparableGreater() {
        Nitrogen nitrogen1 = new Nitrogen(20);
        Nitrogen nitrogen2 = new Nitrogen(25);
        var output = nitrogen2.compareTo(nitrogen1);
        assertEquals(1, output);
    }

    @Test
    public void testComparableEquals() {
        Nitrogen nitrogen1 = new Nitrogen(20);
        Nitrogen nitrogen2 = new Nitrogen(20);
        var output = nitrogen1.compareTo(nitrogen2);
        assertEquals(0, output);
    }
}
