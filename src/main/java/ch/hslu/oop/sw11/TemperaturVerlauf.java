/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 *
 * @author boasm
 */
public class TemperaturVerlauf {

    private double average;
    private double max = 0;
    private double oldMax = 0;
    private double min = 0;
    private double oldMin = 0;

    /**
     *
     * @param temperatur
     * @param history
     */
    public void add(Temperatur temperatur, Set<Temperatur> history) {
        history.add(temperatur);

        //If Construct to fire temperature event if new max or min is added to the Set history
        if (this.getMax(history) > max) {
            oldMax = max;
            max = this.getMax(history);
            min = this.getMin(history);
            final TemperaturEvent tEvent = new TemperaturEvent(this, "newMax", oldMax, max);
            this.fireTemperatureEvent(tEvent);

        } else if (this.getMin(history) < min) {
            oldMin = min;
            min = this.getMin(history);
            max = this.getMax(history);
            final TemperaturEvent tEvent = new TemperaturEvent(this, "newMin", oldMin, min);
            this.fireTemperatureEvent(tEvent);
        } else {

        }
    }

    /**
     *
     * Informs all PropertyChangeListeners about TemperaturEvent.
     *
     * @param pcEvent PropertyChangeEvent.
     */
    private void fireTemperatureEvent(final TemperaturEvent tEvent) {
        for (final TemperaturEventListener listener : this.changeListeners) {
            listener.newMaxOrMin(tEvent);
        }
    }

    /**
     *
     * @param history
     */
    public void clear(Set<Temperatur> history) {
        history.clear();
    }

    /**
     *
     * @param history
     * @return
     */
    public int getCount(Set<Temperatur> history) {
        return history.size();
    }

    /**
     *
     * @param history
     * @return
     */
    public double getMax(Set<Temperatur> history) {
        final TemperaturVerlaufComparator comparator = new TemperaturVerlaufComparator();
        Temperatur maxTemperatur = Collections.max(history, comparator);
        return maxTemperatur.getTempK();
    }

    /**
     *
     * @param history
     * @return
     */
    public double getMin(Set<Temperatur> history) {
        final TemperaturVerlaufComparator comparator = new TemperaturVerlaufComparator();
        Temperatur minTemperatur = Collections.min(history, comparator);
        return minTemperatur.getTempK();
    }

    /**
     *
     * @param history
     * @return
     */
    public double getAverage(Set<Temperatur> history) {
        average = 0;
        var counter = 0;
        Iterator<Temperatur> iterator = history.iterator();
        while (iterator.hasNext()) {
            final Temperatur t = iterator.next();
            average += t.getTempK();
            counter++;
        }
        return (average / counter);
    }

    public String toString(Set<Temperatur> history) {
        return "TemperaturVerlauf{ Count: " + this.getCount(history) + ", Min: " + this.getMin(history) + ", Max " + this.getMax(history) + ", Average : " + this.getAverage(history) + '}';
    }

    // Datastructure to store all the listeners.
    private final List<TemperaturEventListener> changeListeners = new ArrayList<>();

    /**
     * Register a PropertyChangeListener.
     *
     * @param listener PropertyChangeListener.
     */
    public void addTemperaturEventListener(final TemperaturEventListener listener) {
        if (listener != null) {
            this.changeListeners.add(listener);
        } else {

        }
    }

    /**
     * Deregister a PropertyChangeListener.
     *
     * @param listener PropertyChangeListener.
     */
    public void removeTemperaturEventListener(final TemperaturEventListener listener) {
        if (listener != null) {
            this.changeListeners.remove(listener);
        } else {

        }
    }

}
