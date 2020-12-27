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
public class CarTest {

    public CarTest() {
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
    public void testCar() {
        Car car = new Car();
        assertEquals(false, car.isSwitchedOn());
    }

    /**
     * Test of switchOn method, of class Car.
     */
    @Test
    public void testSwitchOn() {
        Car car = new Car();
        car.switchOn();
        assertEquals(true, car.isSwitchedOn());
    }

    /**
     * Test of switchOff method, of class Car.
     */
    @Test
    public void testSwitchOff() {
        Car car = new Car();
        car.switchOn();
        car.switchOff();
        assertEquals(true, car.isSwitchedOff());
    }

    /**
     * Test of isSwitchedOff method, of class Car.
     */
    @Test
    public void testIsSwitchedOff() {
        Car car = new Car();
        assertEquals(true, car.isSwitchedOff());
    }

    /**
     * Test of isSwitchedOn method, of class Car.
     */
    @Test
    public void testIsSwitchedOn() {
        Car car = new Car();
        assertEquals(false, car.isSwitchedOn());
    }

}
