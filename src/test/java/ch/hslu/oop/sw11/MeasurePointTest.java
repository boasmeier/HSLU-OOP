/*
 * Copyright (C) 2019 Hochschule Luzern - Informatik
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package ch.hslu.oop.sw11;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
public class MeasurePointTest {

    private static final double DELTA = 1e-15;

    public MeasurePointTest() {
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
     * Test of getFormattedTimestamp method, of class MeasurePoint.
     */
    @Test
    public void testGetFormattedTimestamp() {
        MeasurePoint mp = new MeasurePoint('"' + "2018/01/27 00:04:03" + '"', "-10.789");
        LocalDateTime t = LocalDateTime.parse('"' + "2018/01/27 00:04:03" + '"', DateTimeFormatter.ofPattern("\"yyyy/MM/dd HH:mm:ss\""));
        assertEquals(t, mp.getTimestamp());
    }

    /**
     * Test of getFormattedTimestamp method, of class MeasurePoint.
     */
    @Test
    public void testGetTimestampAsString() {
        MeasurePoint mp = new MeasurePoint('"' + "2018/01/27 00:04:03" + '"', "-10.789");
        assertEquals("2018-01-27T00:04:03", mp.getTimestampAsString());
    }

    /**
     * Test of getFormattedTemperatur method, of class MeasurePoint.
     */
    @Test
    public void testGetFormattedTemperatur() {
        MeasurePoint mp = new MeasurePoint('"' + "2018/01/27 00:04:03" + '"', "-10.789");
        assertEquals(-10.789, mp.getTemperaturCelsius(), DELTA);
    }
}
