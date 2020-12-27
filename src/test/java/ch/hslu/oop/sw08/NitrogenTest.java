/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw08;

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
public class NitrogenTest {

    public NitrogenTest() {
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
     * Test of getAggregatsStateSwitch method, of class Nitrogen.
     */
    @Test
    public void testGetAggregatsStateSwitchGas() {
        Nitrogen nitrogen = new Nitrogen(0);
        String output = (nitrogen.getAggregatsStateSwitch());
        assertEquals(output, "Nitrogen is gas at 0.0 °C");
    }

    /**
     * Test of getAggregatsState method, of class Nitrogen.
     */
    @Test
    public void testGetAggregatsStateGas() {
        Nitrogen nitrogen = new Nitrogen(0);
        String output = (nitrogen.getAggregatsStateSwitch());
        assertEquals(output, "Nitrogen is gas at 0.0 °C");
    }

    /**
     * Test of getAggregatsStateSwitch method, of class Nitrogen.
     */
    @Test
    public void testGetAggregatsStateSwitchSolid() {
        Nitrogen nitrogen = new Nitrogen(-223);
        String output = (nitrogen.getAggregatsStateSwitch());
        assertEquals(output, "Nitrogen is solid at -223.0 °C");
    }

    /**
     * Test of getAggregatsState method, of class Nitrogen.
     */
    @Test
    public void testGetAggregatsStateSolid() {
        Nitrogen nitrogen = new Nitrogen(-223);
        String output = (nitrogen.getAggregatsStateSwitch());
        assertEquals(output, "Nitrogen is solid at -223.0 °C");
    }

    /**
     * Test of getAggregatsStateSwitch method, of class Nitrogen.
     */
    @Test
    public void testGetAggregatsStateSwitchLiquid() {
        Nitrogen nitrogen = new Nitrogen(-207);
        String output = (nitrogen.getAggregatsStateSwitch());
        assertEquals(output, "Nitrogen is liquid at -207.0 °C");
    }

    /**
     * Test of getAggregatsState method, of class Nitrogen.
     */
    @Test
    public void testGetAggregatsStateLiquid() {
        Nitrogen nitrogen = new Nitrogen(-207);
        String output = (nitrogen.getAggregatsStateSwitch());
        assertEquals(output, "Nitrogen is liquid at -207.0 °C");
    }
}
