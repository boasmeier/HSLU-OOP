/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw13;

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

    // Datastructure to store all the listeners.
    private final List<TemperaturEventListener> changeListeners = new ArrayList<>();

    //Comparator for temperature implemented with lambda expression
    final Comparator<Temperatur> temperaturComparator = (temperatur0, temperatur1) -> temperatur0.compareTo(temperatur1);

    // Datastructure to store the temperatures
    private final List<Temperatur> history;

    public TemperaturVerlauf() {
        history = new ArrayList<>();
    }

    /**
     *
     * @param temperatur
     */
    public void add(Temperatur temperatur) {
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
     */
    public void clear() {
        history.clear();
    }

    /**
     *
     * @return
     */
    public int getCount() {
        return history.size();
    }

    /**
     *
     * @return
     */
    public int getCountWithStream() { //getCountWithStream is more extensive than the imperative solution.
        return (int) history.stream()
                .count();
    }

    /**
     *
     * @return
     */
    public double getMax() {
        return Collections.max(history, temperaturComparator).getTempK();
    }

    /**
     *
     * @return
     */
    public double getMaxWithStream() {
        return history.stream()
                .mapToDouble(t -> t.getTempK())
                .max()
                .orElse(Double.NaN);
    }

    /**
     *
     * @return
     */
    public Temperatur getMaxObjectWithStream() {
        return history.stream()
                .max(Comparator.comparing(Temperatur::getTempK))
                .orElse(null);
    }

    /**
     *
     * @return
     */
    public double getMin() {
        return Collections.min(history, temperaturComparator).getTempK();
    }

    /**
     *
     * @return
     */
    public double getMinWithStream() {
        return history.stream()
                .mapToDouble(t -> t.getTempK())
                .min()
                .orElse(Double.NaN);
    }

    /**
     *
     * @return
     */
    public Temperatur getMinObjectWithStream() {
        return history.stream()
                .min(Comparator.comparing(Temperatur::getTempK))
                .orElse(null);
    }

    /**
     *
     * @return
     */
    public double getAverage() {
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
     * @return
     */
    public double getAverageWithStream() {
        return history.stream()
                .mapToDouble(t -> t.getTempK())
                .average()
                .getAsDouble();
    }

    /**
     *
     * @return
     */
    public int getAndPrintBetween20And25() {
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
     * @return
     */
    public int getAndPrintBetween20And25WithStream() {
        history.stream()
                .mapToDouble(t -> t.getTempK())
                .filter(f -> (f >= 293.15 && f <= 298.15))
                .forEachOrdered(v -> LOG.info("{}°C", v - 273.15));

        return (int) history.stream()
                .mapToDouble(t -> t.getTempK())
                .filter(f -> (f >= 293.15 && f <= 298.15))
                .count();
    }

    /**
     * Creates a list of all temperatures inside the specific range.
     *
     * @param min
     * @param max
     * @return
     */
    public int getRange(final double min, final double max) {
        history.stream()
                .mapToDouble(t -> t.getTempK())
                .filter(f -> (f >= min + 273.15 && f <= max + 273.15))
                .forEachOrdered(v -> LOG.info("{}°C", v - 273.15));

        return (int) history.stream()
                .mapToDouble(t -> t.getTempK())
                .filter(f -> (f >= min + 273.15 && f <= max + 273.15))
                .count();
    }

    public String toString() {
        return "TemperaturVerlauf{ Count: " + this.getCount() + ", Min: " + Round.round((this.getMin() - 273.15), 4) + ", Max " + Round.round((this.getMax() - 273.15), 4) + ", Average : " + Round.round((this.getAverage() - 273.15), 2) + '}';
    }

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

    public final int getChangeListenerSize() {
        return changeListeners.size();
    }

    public final TemperaturEventListener getChangeListener(final int index) {
        return changeListeners.get(index);
    }
}
