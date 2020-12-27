/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw11;

import java.util.Objects;

/**
 * Class of a Person, with overrided equals(), hashCode() and implements Comparable.
 *
 * @author boasm
 * @version SW08 JDK 12
 */
public class Person implements Comparable<Person> {

    private final long id;
    private final String nachname;
    private final String vorname;

    /**
     * Constructor to create person objects and initialize the attributes.
     *
     * @param id - identification number of person.
     * @param nachname - name of person.
     * @param vorname - forename of person.
     */
    public Person(long id, String nachname, String vorname) {
        this.id = id;
        this.nachname = nachname;
        this.vorname = vorname;
    }

    /**
     *
     * @return id of object.
     */
    public long getId() {
        return this.id;
    }

    /**
     *
     * @return nachname of object.
     */
    public String getNachname() {
        return this.nachname;
    }

    /**
     *
     * @return vorname of object.
     */
    public String getVorname() {
        return this.vorname;
    }

    /**
     * Tests if two objects are identic or have the same values.
     *
     * @param object which is tested if its eaquals with the object that called this method.
     * @return true if equals.
     */
    @Override
    public final boolean equals(final Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Person)) {
            return false;
        }
        final Person other = (Person) object;
        return (other.getId() == this.getId()) && (other.getNachname() == null ? this.getNachname() == null : other.getNachname().equals(this.getNachname())) && (other.getVorname() == null ? this.getVorname() == null : other.getVorname().equals(this.getVorname()));
    }

    /**
     * Generate and Returns a different personal Hash-Code for a Object of type Person. Identic objects return the same
     * Hash-Code.
     *
     * @return Hash-Code
     */
    @Override
    public final int hashCode() {
        return Objects.hash(this.getId(), this.getNachname(), this.getVorname());
    }

    /**
     * Returns a String which contains the values of all mentioned attributes.
     *
     * @return String with attributes of person object.
     */
    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", nachname=" + nachname + ", vorname=" + vorname + '}';
    }

    /**
     * Compares objects of class person based on their Id-Numbers.
     *
     * @param other
     * @return -1 if this less then other, 0 if they are equal, 1 if this greater then other.
     */
    @Override
    public int compareTo(Person other) {
        return Long.compare(this.getId(), other.getId());
    }

}
