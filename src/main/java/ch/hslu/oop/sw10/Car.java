package ch.hslu.oop.sw10;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Simple car class which contains the interface Switchable
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Car implements Switchable, PropertyChangeListener {

    // instance variables - replace the example below with your own
    private boolean carOn;
    private final Engine engine;
    private final Light frontLightLeft;
    private final Light frontLightRight;
    private static final Logger LOG = LogManager.getLogger(Car.class);

    /**
     * Constructor for objects of class Car
     */
    public Car() {
        // initialise instance variables
        carOn = false;
        frontLightLeft = new Light();
        frontLightRight = new Light();
        engine = new Engine();
        engine.addPropertyChangeListener(this);
        frontLightLeft.switchOff();
        frontLightRight.switchOff();
        engine.switchOff();
    }

    /**
     *
     */
    @Override
    public void switchOn() {
        carOn = true;
        frontLightLeft.switchOn();
        frontLightRight.switchOn();
        engine.switchOn();
    }

    /**
     *
     */
    @Override
    public void switchOff() {
        carOn = false;
        frontLightLeft.switchOff();
        frontLightRight.switchOff();
        engine.switchOff();
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isSwitchedOff() {
        return !carOn;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isSwitchedOn() {
        return carOn;
    }

    @Override
    public void propertyChange(final PropertyChangeEvent event) {
        if (event.getSource() == this.engine) {
            //this.handleMotorEvent("Motor", event);
            LOG.info("Engine State changed from " + event.getOldValue() + " to " + event.getNewValue());
        }
        if (event.getSource() == this.frontLightLeft) {
            //this.handleLightEvent("Schweinwerfer Links", event);
            LOG.info("Front-light-left State changed from " + event.getOldValue() + " to " + event.getNewValue());
        }
        if (event.getSource() == this.frontLightRight) {
            //this.handleLightEvent("Schweinwerfer Rechts", event);
            LOG.info("Front-light-right State changed from " + event.getOldValue() + " to " + event.getNewValue());;
        }
    }
}
