/*
 *
 *
 */
package ch.hslu.oop.sw08;

import java.util.Comparator;

/**
 *
 * @author boasm
 */
public class PersonNameComparator implements Comparator<Person> {

    @Override
    public int compare(Person person1, Person person2) {
        int compare = person1.getNachname().compareTo(person2.getNachname());
        if (compare == 0) {
            compare = person1.getVorname().compareTo(person2.getVorname());
        } else {
        }
        return compare;
    }
}
