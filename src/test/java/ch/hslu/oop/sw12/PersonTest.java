/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw12;

import ch.hslu.oop.sw10.Person;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author boasm
 */
public class PersonTest {

    public PersonTest() {
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
     * Test if constructor sets id of Person properly.
     */
    @Test
    public void testPersonId() {
        final String nachname = "Meier";
        final String vorname = "Boas";
        Person person = new Person(1, nachname, vorname);
        var output = person.getId();
        assertEquals(1, output);
    }

    /**
     * Test if constructor sets nachname of Person properly.
     */
    @Test
    public void testPersonNachname() {
        final String nachname = "Meier";
        final String vorname = "Boas";
        Person person = new Person(1, nachname, vorname);
        String output = person.getNachname();
        assertEquals("Meier", output);
    }

    /**
     * Test if constructor sets vorname of Person properly.
     */
    @Test
    public void testPersonVorname() {
        final String nachname = "Meier";
        final String vorname = "Boas";
        Person person = new Person(1, nachname, vorname);
        String output = person.getVorname();
        assertEquals("Boas", output);
    }

    /**
     * Test of getId method, of class Person.
     */
    @Test
    public void testGetId() {

    }

    /**
     * Test of getNachname method, of class Person.
     */
    @Test
    public void testGetNachname() {

    }

    /**
     * Test of getVorname method, of class Person.
     */
    @Test
    public void testGetVorname() {

    }

    /**
     * Test of equals and hashcode methods, of class Person.
     */
    @Test
    public void testEqualsWithVerifier() {
        EqualsVerifier.forClass(Person.class).verify();
    }

    /**
     * Test of equals method of class Person in case its true.
     */
    @Test
    public void testEqualsTrue() {
        final String nachname = "Meier";
        final String vorname = "Boas";
        Person person1 = new Person(1, nachname, vorname);
        Person person2 = person1;
        var output = person1.equals(person2);
        assertEquals(true, output);
    }

    /**
     * Test of equals method of class Person in case its false.
     */
    @Test
    public void testEqualsFalse() {
        final String nachname = "Meier";
        final String vorname = "Boas";
        final String nachname1 = "Peter";
        final String vorname1 = "Hans";
        Person person1 = new Person(1, nachname, vorname);
        Person person2 = new Person(2, nachname1, vorname1);
        var output = person1.equals(person2);
        assertEquals(false, output);
    }

    /**
     * Test hashCode() when objects are identic.
     */
    @Test
    public void testHashCodeEntity() {
        final String nachname = "Meier";
        final String vorname = "Boas";
        Person person1 = new Person(1, nachname, vorname);
        Person person2 = person1;
        var output = person1.hashCode();
        var output2 = person2.hashCode();
        assertEquals(output, output2);
    }

    /**
     * Test hashCode() when different objects but similar values.
     */
    @Test
    public void testHashCodeValues() {
        final String nachname = "Meier";
        final String vorname = "Boas";
        Person person1 = new Person(1, nachname, vorname);
        Person person2 = new Person(1, nachname, vorname);
        var output = person1.hashCode();
        var output2 = person2.hashCode();
        assertEquals(output, output2);
    }

    /**
     * Test hashCode() when objects and values are different.
     */
    @Test
    public void testHashCodeFalse() {
        final String nachname = "Meier";
        final String vorname = "Boas";
        final String nachname1 = "Peter";
        final String vorname1 = "Hans";
        Person person1 = new Person(1, nachname, vorname);
        Person person2 = new Person(2, nachname1, vorname1);
        var output1 = person1.hashCode();
        var output2 = person2.hashCode();
        assertNotEquals(output1, output2);
    }

    /**
     * Test compareTo() when this less then other.
     */
    @Test
    public void testComparableLess() {
        final String nachname = "Meier";
        final String vorname = "Boas";
        final String nachname1 = "Peter";
        final String vorname1 = "Hans";
        Person person1 = new Person(1, nachname, vorname);
        Person person2 = new Person(2, nachname1, vorname1);
        var output = person1.compareTo(person2);
        assertEquals(-1, output);
    }

    /**
     * Test compareTo() when this greater then other.
     */
    @Test
    public void testComparableGreater() {
        final String nachname = "Meier";
        final String vorname = "Boas";
        final String nachname1 = "Peter";
        final String vorname1 = "Hans";
        Person person1 = new Person(1, nachname, vorname);
        Person person2 = new Person(2, nachname1, vorname1);
        var output = person2.compareTo(person1);
        assertEquals(1, output);
    }

    /**
     * Test compareTo() when this equals with other.
     */
    @Test
    public void testComparableEquals() {
        final String nachname = "Meier";
        final String vorname = "Boas";
        final String nachname1 = "Peter";
        final String vorname1 = "Hans";
        Person person1 = new Person(1, nachname, vorname);
        Person person2 = new Person(1, nachname1, vorname1);
        var output = person1.compareTo(person2);
        assertEquals(0, output);
    }

}
