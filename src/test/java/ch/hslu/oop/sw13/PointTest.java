/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw13;

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
public class PointTest {

    public PointTest() {
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
     * Test of setX method, of class Point.
     */
    @Test
    public void testSetX() {
        Point point = new Point();
        point.setX(5);
        assertEquals(5, point.getX());
    }

    /**
     * Test of setY method, of class Point.
     */
    @Test
    public void testSetY() {
        Point point = new Point();
        point.setY(5);
        assertEquals(5, point.getY());
    }

    /**
     * Test of getX method, of class Point.
     */
    @Test
    public void testGetX() {
        Point point = new Point(5, 5);
        assertEquals(5, point.getX());
    }

    /**
     * Test of getY method, of class Point.
     */
    @Test
    public void testGetY() {
        Point point = new Point(5, 5);
        assertEquals(5, point.getY());
    }

    /**
     * Test of getQuadrant method, of class Point.
     */
    @Test
    public void testGetQuadrant1() {
        Point point = new Point(5, 5);
        var output = point.getQuadrant();
        assertEquals(1, output);
    }

    @Test
    public void testGetQuadrant2() {
        Point point = new Point(-5, 5);
        var output = point.getQuadrant();
        assertEquals(2, output);
    }

    @Test
    public void testGetQuadrant3() {
        Point point = new Point(-5, -5);
        var output = point.getQuadrant();
        assertEquals(3, output);
    }

    @Test
    public void testGetQuadrant4() {
        Point point = new Point(5, -5);
        var output = point.getQuadrant();
        assertEquals(4, output);
    }

    @Test
    public void testGetQuadrant0() {
        Point point = new Point(0, 5);
        var output = point.getQuadrant();
        assertEquals(0, output);
    }

    /**
     * Test of equals and hashcode methods, of class Person.
     */
    @Test
    public void testEqualsWithVerifier() {
        EqualsVerifier.forClass(Point.class)
                .withIgnoredFields("quadrant")
                .suppress(Warning.NONFINAL_FIELDS)
                .verify();
    }

}
