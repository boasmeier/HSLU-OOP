/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw11;

import ch.hslu.oop.sw10.Plumbum;
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
public class PlumbumTest {

    public PlumbumTest() {
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
        Plumbum plumbum = new Plumbum(1777);
        String output = (plumbum.getAggregatsStateSwitch());
        assertEquals(output, "Plumbum is gas at 1777.0 °C");
    }

    /**
     * Test of getAggregatsState method, of class Nitrogen.
     */
    @Test
    public void testGetAggregatsStateGas() {
        Plumbum plumbum = new Plumbum(1777);
        String output = (plumbum.getAggregatsStateSwitch());
        assertEquals(output, "Plumbum is gas at 1777.0 °C");
    }

    /**
     * Test of getAggregatsStateSwitch method, of class Nitrogen.
     */
    @Test
    public void testGetAggregatsStateSwitchSolid() {
        Plumbum plumbum = new Plumbum(277);
        String output = (plumbum.getAggregatsStateSwitch());
        assertEquals(output, "Plumbum is solid at 277.0 °C");
    }

    /**
     * Test of getAggregatsState method, of class Nitrogen.
     */
    @Test
    public void testGetAggregatsStateSolid() {
        Plumbum plumbum = new Plumbum(277);
        String output = (plumbum.getAggregatsStateSwitch());
        assertEquals(output, "Plumbum is solid at 277.0 °C");
    }

    /**
     * Test of getAggregatsStateSwitch method, of class Nitrogen.
     */
    @Test
    public void testGetAggregatsStateSwitchLiquid() {
        Plumbum plumbum = new Plumbum(427);
        String output = (plumbum.getAggregatsStateSwitch());
        assertEquals(output, "Plumbum is liquid at 427.0 °C");
    }

    /**
     * Test of getAggregatsState method, of class Nitrogen.
     */
    @Test
    public void testGetAggregatsStateLiquid() {
        Plumbum plumbum = new Plumbum(427);
        String output = (plumbum.getAggregatsStateSwitch());
        assertEquals(output, "Plumbum is liquid at 427.0 °C");
    }
}
