/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 *
 * @author boasm
 */
public class MeasurePointVerlauf {

    private double average;
    private double max = -273.15;
    private double oldMax = 0;
    private double min = Double.MAX_VALUE;
    private double oldMin = 0;

    /**
     *
     * @param mp
     * @param history
     */
    public void add(MeasurePoint mp, Set<MeasurePoint> history) {
        history.add(mp);

        //If construct to fire temperature event if new max or min is added to the Set history
        if (mp.getTemperaturCelsius() > max) {
            oldMax = max;
            max = mp.getTemperaturCelsius();
            final TemperaturEvent tEvent = new TemperaturEvent(this, "newMax", oldMax, max);
            this.fireTemperatureEvent(tEvent);

        } else if (mp.getTemperaturCelsius() < min) {
            oldMin = min;
            min = mp.getTemperaturCelsius();
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
        this.changeListeners.forEach((listener) -> {
            listener.newMaxOrMin(tEvent);
        });
    }

    /**
     *
     * @param history
     */
    public void clear(Set<MeasurePoint> history) {
        history.clear();
    }

    /**
     *
     * @param history
     * @return
     */
    public int getCount(Set<MeasurePoint> history) {
        return history.size();
    }

    /**
     *
     * @param history
     * @return
     */
    public double getMax(Set<MeasurePoint> history) {
        final MeasurePointVerlaufComparator comparator = new MeasurePointVerlaufComparator();
        MeasurePoint mpWithMaxTemperatur = Collections.max(history, comparator);
        return mpWithMaxTemperatur.getTemperaturCelsius();
    }

    public String getTimeOfMax(Set<MeasurePoint> history) {
        final MeasurePointVerlaufComparator comparator = new MeasurePointVerlaufComparator();
        MeasurePoint mpWithMaxTemperatur = Collections.max(history, comparator);
        return mpWithMaxTemperatur.getTimestampAsString();
    }

    public MeasurePoint getMeasurePointOfMax(Set<MeasurePoint> history) {
        final MeasurePointVerlaufComparator comparator = new MeasurePointVerlaufComparator();
        MeasurePoint mpWithMaxTemperatur = Collections.max(history, comparator);
        return mpWithMaxTemperatur;
    }

    /**
     *
     * @param history
     * @return
     */
    public double getMin(Set<MeasurePoint> history) {
        final MeasurePointVerlaufComparator comparator = new MeasurePointVerlaufComparator();
        MeasurePoint mpWithMinTemperatur = Collections.min(history, comparator);
        return mpWithMinTemperatur.getTemperaturCelsius();
    }

    public String getTimeOfMin(Set<MeasurePoint> history) {
        final MeasurePointVerlaufComparator comparator = new MeasurePointVerlaufComparator();
        MeasurePoint mpWithMinTemperatur = Collections.min(history, comparator);
        return mpWithMinTemperatur.getTimestampAsString();
    }

    public MeasurePoint getMeasurePointOfMin(Set<MeasurePoint> history) {
        final MeasurePointVerlaufComparator comparator = new MeasurePointVerlaufComparator();
        MeasurePoint mpWithMinTemperatur = Collections.min(history, comparator);
        return mpWithMinTemperatur;
    }

    /**
     *
     * @param history
     * @return
     */
    public double getAverage(Set<MeasurePoint> history) {
        average = 0;
        var counter = 0;
        Iterator<MeasurePoint> iterator = history.iterator();
        while (iterator.hasNext()) {
            final MeasurePoint mp = iterator.next();
            average += mp.getTemperaturCelsius();
            counter++;
        }
        return (average / counter);
    }

    public String toString(Set<MeasurePoint> history) {
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
