package ch.hslu.oop.sw12;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple Engine Class which implements Switchable interface.
 *
 * @author Boas Meier
 * @version JDK 12.0.2
 */
public final class Engine implements Switchable {

    // instance variables - replace the example below with your own
    private EngineState engineState;

    /**
     * Constructor for objects of class Engine
     */
    public Engine() {
        // initialise instance variables
        engineState = EngineState.OFF;
    }

    /**
     *
     */
    @Override
    public void switchOn() {
        if (this.isSwitchedOff()) {
            this.engineState = EngineState.ON;
            final PropertyChangeEvent pcEvent = new PropertyChangeEvent(this, engineState.getState(), EngineState.OFF, EngineState.ON);
            this.firePropertyChangeEvent(pcEvent);
        } else {

        }
    }

    /**
     *
     * Informs all PropertyChangeListeners about PropertyChangeEvent.
     *
     * @param pcEvent PropertyChangeEvent.
     */
    private void firePropertyChangeEvent(final PropertyChangeEvent pcEvent) {
        for (final PropertyChangeListener listener : this.changeListeners) {
            listener.propertyChange(pcEvent);
        }
    }

    /**
     *
     */
    @Override
    public void switchOff() {
        if (this.isSwitchedOn()) {
            this.engineState = EngineState.OFF;
            final PropertyChangeEvent pcEvent = new PropertyChangeEvent(this, engineState.getState(), EngineState.ON, EngineState.OFF);
            this.firePropertyChangeEvent(pcEvent);
        } else {

        }
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isSwitchedOff() {
        return engineState.getState().equals("off");
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isSwitchedOn() {
        return engineState.getState().equals("on");
    }

    // Datastructure to store all the listeners.
    private final List<PropertyChangeListener> changeListeners = new ArrayList<>();

    /**
     * Register a PropertyChangeListener.
     *
     * @param listener PropertyChangeListener.
     */
    public void addPropertyChangeListener(final PropertyChangeListener listener) {
        if (!listener.equals(null)) {
            this.changeListeners.add(listener);
        } else {
            throw new NullPointerException("Listener mustn't be null");
        }
    }

    /**
     * Deregister a PropertyChangeListener.
     *
     * @param listener PropertyChangeListener.
     */
    public void removePropertyChangeListener(final PropertyChangeListener listener) {
        if (!listener.equals(null)) {
            this.changeListeners.remove(listener);
        } else {
            throw new NullPointerException("Listener mustn't be null");
        }
    }

}
