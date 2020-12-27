/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author boasm
 */
public class TemperaturVerlauf {

    private static final Logger LOG = LogManager.getLogger(MainClass.class);
    private double average;
    private double max = -273.15;
    private double oldMax = 0;
    private double min = Double.MAX_VALUE;
    private double oldMin = 0;

    //Comparator for temperature implemented with lambda expression
    final Comparator<Temperatur> temperaturComparator = (temperatur0, temperatur1) -> temperatur0.compareTo(temperatur1);

    /**
     *
     * @param temperatur
     * @param history
     */
    public void add(Temperatur temperatur, ArrayList<Temperatur> history) {
        history.add(temperatur);

        //If Construct to fire temperature event if new max or min is added to the Set history
        if (temperatur.getTempC() > max) {
            oldMax = max;
            max = temperatur.getTempC();
            final TemperaturEvent tEvent = new TemperaturEvent(this, "newMax", oldMax, max);
            this.fireTemperatureEvent(tEvent);
        }
        if (temperatur.getTempC() < min) {
            oldMin = min;
            min = temperatur.getTempC();
            final TemperaturEvent tEvent = new TemperaturEvent(this, "newMin", oldMin, min);
            this.fireTemperatureEvent(tEvent);
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
    public void clear(ArrayList<Temperatur> history) {
        history.clear();
    }

    /**
     *
     * @param history
     * @return
     */
    public int getCount(ArrayList<Temperatur> history) {
        return history.size();
    }

    /**
     *
     * @param history
     * @return
     */
    public int getCountWithStream(ArrayList<Temperatur> history) { //getCountWithStream is more extensive than the imperative solution.
        return (int) history.stream()
                .count();
    }

    /**
     *
     * @param history
     * @return
     */
    public double getMax(ArrayList<Temperatur> history) {
        Temperatur maxTemperatur = Collections.max(history, temperaturComparator);
        return maxTemperatur.getTempK();
    }

    /**
     *
     * @param history
     * @return
     */
    public double getMaxWithStream(ArrayList<Temperatur> history) {
        return history.stream()
                .mapToDouble(t -> t.getTempK())
                .max()
                .getAsDouble();
    }

    /**
     *
     * @param history
     * @return
     */
    public double getMin(ArrayList<Temperatur> history) {
        Temperatur minTemperatur = Collections.min(history, temperaturComparator);
        return minTemperatur.getTempK();
    }

    /**
     *
     * @param history
     * @return
     */
    public double getMinWithStream(ArrayList<Temperatur> history) {
        return history.stream()
                .mapToDouble(t -> t.getTempK())
                .min()
                .getAsDouble();
    }

    /**
     *
     * @param history
     * @return
     */
    public double getAverage(ArrayList<Temperatur> history) {
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

    /**
     *
     * @param history
     * @return
     */
    public double getAverageWithStream(ArrayList<Temperatur> history) {
        return history.stream()
                .mapToDouble(t -> t.getTempK())
                .average()
                .getAsDouble();
    }

    /**
     *
     * @param history
     * @return
     */
    public int getAndPrintBetween20And25(ArrayList<Temperatur> history) {
        var counter = 0;
        final List<Temperatur> selected = new ArrayList<>();
        for (final Temperatur t : history) {
            if (t.getTempK() >= 293.15 && t.getTempK() <= 298.15) {
                selected.add(t);
            }
        }
        Collections.sort(selected);
        for (final Temperatur t : selected) {
            counter++;
            LOG.info("{}°C", t.getTempC());
        }
        return counter;
    }

    /**
     *
     * @param history
     * @return
     */
    public int getAndPrintBetween20And25WithStream(ArrayList<Temperatur> history) {
        history.stream()
                .mapToDouble(t -> t.getTempK())
                .filter(f -> (f >= 293.15 && f <= 298.15))
                .forEachOrdered(v -> LOG.info("{}°C", v - 273.15));

        return (int) history.stream()
                .mapToDouble(t -> t.getTempK())
                .filter(f -> (f >= 293.15 && f <= 298.15))
                .count();
    }

    public String toString(ArrayList<Temperatur> history) {
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
