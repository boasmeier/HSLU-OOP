/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw13;

import ch.hslu.oop.sw10.Quicksilver;
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
public class QuicksilverTest {

    public QuicksilverTest() {
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
        Quicksilver quicksilver = new Quicksilver(630);
        String output = (quicksilver.getAggregatsStateSwitch());
        assertEquals(output, "Quicksilver is gas at 630.0 °C");
    }

    /**
     * Test of getAggregatsState method, of class Nitrogen.
     */
    @Test
    public void testGetAggregatsStateGas() {
        Quicksilver quicksilver = new Quicksilver(630);
        String output = (quicksilver.getAggregatsStateSwitch());
        assertEquals(output, "Quicksilver is gas at 630.0 °C");
    }

    /**
     * Test of getAggregatsStateSwitch method, of class Nitrogen.
     */
    @Test
    public void testGetAggregatsStateSwitchSolid() {
        Quicksilver quicksilver = new Quicksilver(-73);
        String output = (quicksilver.getAggregatsStateSwitch());
        assertEquals(output, "Quicksilver is solid at -73.0 °C");
    }

    /**
     * Test of getAggregatsState method, of class Nitrogen.
     */
    @Test
    public void testGetAggregatsStateSolid() {
        Quicksilver quicksilver = new Quicksilver(-73);
        String output = (quicksilver.getAggregatsStateSwitch());
        assertEquals(output, "Quicksilver is solid at -73.0 °C");
    }

    /**
     * Test of getAggregatsStateSwitch method, of class Nitrogen.
     */
    @Test
    public void testGetAggregatsStateSwitchLiquid() {
        Quicksilver quicksilver = new Quicksilver(150);
        String output = (quicksilver.getAggregatsStateSwitch());
        assertEquals(output, "Quicksilver is liquid at 150.0 °C");
    }

    /**
     * Test of getAggregatsState method, of class Nitrogen.
     */
    @Test
    public void testGetAggregatsStateLiquid() {
        Quicksilver quicksilver = new Quicksilver(150);
        String output = (quicksilver.getAggregatsStateSwitch());
        assertEquals(output, "Quicksilver is liquid at 150.0 °C");
    }
}
