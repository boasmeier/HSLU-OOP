/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw11;

import java.util.HashSet;
import java.util.Set;
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
public class MeasurePointVerlaufTest {

    public MeasurePointVerlaufTest() {
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
     * Test of add method, of class MeasurePointVerlauf.
     */
    @Test
    public void testAdd() {
        MeasurePointVerlauf verlauf = new MeasurePointVerlauf();
        MeasurePoint mp = new MeasurePoint('"' + "2018/01/27 00:04:03" + '"', "-10.789");
        final Set<MeasurePoint> history = new HashSet<>();
        verlauf.add(mp, history);
        var output = history.contains(mp);
        assertEquals(true, output);
    }

    /**
     * Test of clear method, of class MeasurePointVerlauf.
     */
    @Test
    public void testClear() {
        MeasurePointVerlauf verlauf = new MeasurePointVerlauf();
        MeasurePoint mp = new MeasurePoint('"' + "2018/01/27 00:04:03" + '"', "-10.789");
        final Set<MeasurePoint> history = new HashSet<>();
        verlauf.add(mp, history);
        verlauf.clear(history);
        var output = history.contains(mp);
        assertEquals(false, output);
    }

    /**
     * Test of getCount method, of class MeasurePointVerlauf.
     */
    @Test
    public void testGetCount() {
        MeasurePointVerlauf verlauf = new MeasurePointVerlauf();
        MeasurePoint mp0 = new MeasurePoint('"' + "2018/01/27 00:04:03" + '"', "-10.789");
        MeasurePoint mp1 = new MeasurePoint('"' + "2018/01/27 00:04:03" + '"', "-10.789");
        MeasurePoint mp2 = new MeasurePoint('"' + "2018/01/27 00:04:03" + '"', "-10.789");
        final Set<MeasurePoint> history = new HashSet<>();
        verlauf.add(mp0, history);
        verlauf.add(mp1, history);
        verlauf.add(mp2, history);
        var output = verlauf.getCount(history);
        assertEquals(3, output);
    }

    /**
     * Test of getMax method, of class MeasurePointVerlauf.
     */
    @Test
    public void testGetMax() {
        MeasurePointVerlauf verlauf = new MeasurePointVerlauf();
        MeasurePoint mp0 = new MeasurePoint('"' + "2018/01/27 00:04:03" + '"', "-10.789");
        MeasurePoint mp1 = new MeasurePoint('"' + "2018/01/27 00:04:03" + '"', "-5.789");
        MeasurePoint mp2 = new MeasurePoint('"' + "2018/01/27 00:04:03" + '"', "-3.789");
        final Set<MeasurePoint> history = new HashSet<>();
        verlauf.add(mp0, history);
        verlauf.add(mp1, history);
        verlauf.add(mp2, history);
        var output = verlauf.getMax(history);
        assertEquals(-3.789, output);
    }

    /**
     * Test of getMax method, of class MeasurePointVerlauf.
     */
    @Test
    public void testGetTimeOfMax() {
        MeasurePointVerlauf verlauf = new MeasurePointVerlauf();
        MeasurePoint mp0 = new MeasurePoint('"' + "2018/01/27 00:04:01" + '"', "-10.789");
        MeasurePoint mp1 = new MeasurePoint('"' + "2018/01/27 00:04:02" + '"', "-5.789");
        MeasurePoint mp2 = new MeasurePoint('"' + "2018/01/27 00:04:03" + '"', "-3.789");
        final Set<MeasurePoint> history = new HashSet<>();
        verlauf.add(mp0, history);
        verlauf.add(mp1, history);
        verlauf.add(mp2, history);
        String output = verlauf.getTimeOfMax(history);
        assertEquals("2018-01-27T00:04:03", output);
    }

    /**
     * Test of getMin method, of class MeasurePointVerlauf.
     */
    @Test
    public void testGetMin() {
        MeasurePointVerlauf verlauf = new MeasurePointVerlauf();
        MeasurePoint mp0 = new MeasurePoint('"' + "2018/01/27 00:04:03" + '"', "-10.789");
        MeasurePoint mp1 = new MeasurePoint('"' + "2018/01/27 00:04:03" + '"', "-5.789");
        MeasurePoint mp2 = new MeasurePoint('"' + "2018/01/27 00:04:03" + '"', "-3.789");
        final Set<MeasurePoint> history = new HashSet<>();
        verlauf.add(mp0, history);
        verlauf.add(mp1, history);
        verlauf.add(mp2, history);
        var output = verlauf.getMin(history);
        assertEquals(-10.789, output);
    }

    /**
     * Test of getMax method, of class MeasurePointVerlauf.
     */
    @Test
    public void testGetTimeOfMin() {
        MeasurePointVerlauf verlauf = new MeasurePointVerlauf();
        MeasurePoint mp0 = new MeasurePoint('"' + "2018/01/27 00:04:01" + '"', "-10.789");
        MeasurePoint mp1 = new MeasurePoint('"' + "2018/01/27 00:04:02" + '"', "-5.789");
        MeasurePoint mp2 = new MeasurePoint('"' + "2018/01/27 00:04:03" + '"', "-3.789");
        final Set<MeasurePoint> history = new HashSet<>();
        verlauf.add(mp0, history);
        verlauf.add(mp1, history);
        verlauf.add(mp2, history);
        String output = verlauf.getTimeOfMin(history);
        assertEquals("2018-01-27T00:04:01", output);
    }

    private static final double DELTA = 1e-15;

    /**
     * Test of getAverage method, of class MeasurePointVerlauf.
     */
    @Test
    public void testGetAverage() {
        MeasurePointVerlauf verlauf = new MeasurePointVerlauf();
        MeasurePoint mp0 = new MeasurePoint('"' + "2018/01/27 00:04:03" + '"', "-10.789");
        MeasurePoint mp1 = new MeasurePoint('"' + "2018/01/27 00:04:03" + '"', "-5.789");
        MeasurePoint mp2 = new MeasurePoint('"' + "2018/01/27 00:04:03" + '"', "-3.789");
        final Set<MeasurePoint> history = new HashSet<>();
        verlauf.add(mp0, history);
        verlauf.add(mp1, history);
        verlauf.add(mp2, history);
        var output = verlauf.getAverage(history);
        assertEquals(-6.789, output, DELTA);
    }
}
