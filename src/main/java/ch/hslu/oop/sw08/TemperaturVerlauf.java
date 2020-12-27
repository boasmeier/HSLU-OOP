/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw08;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author boasm
 */
public class TemperaturVerlauf {

    private double average;

    public void add(Temperatur temperatur, Set<Temperatur> history) {
        history.add(temperatur);
    }

    public void clear(Set<Temperatur> history) {
        history.clear();
    }

    public int getCount(Set<Temperatur> history) {
        return history.size();
    }

    public double getMax(Set<Temperatur> history) {
        final TemperaturVerlaufComparator comparator = new TemperaturVerlaufComparator();
        Temperatur maxTemperatur = Collections.max(history, comparator);
        return maxTemperatur.getTempK();
    }

    public double getMin(Set<Temperatur> history) {
        final TemperaturVerlaufComparator comparator = new TemperaturVerlaufComparator();
        Temperatur minTemperatur = Collections.min(history, comparator);
        return minTemperatur.getTempK();
    }

    public double getAverage(Set<Temperatur> history) {
        var counter = 0;
        Iterator<Temperatur> iterator = history.iterator();
        while (iterator.hasNext()) {
            final Temperatur t = iterator.next();
            average += t.getTempK();
            counter++;
        }
        return average / counter;
    }
}
