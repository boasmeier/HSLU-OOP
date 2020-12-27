package ch.hslu.oop.sw05;

/**
 * Write a description of class Engine here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public final class Engine extends Car {

    // instance variables - replace the example below with your own
    private boolean engineState;
    private int rpm;

    /**
     * Constructor for objects of class Engine
     */
    public Engine() {
        // initialise instance variables
        engineState = false;
    }

    @Override
    public void switchOn() {
        engineState = true;
    }

    @Override
    public void switchOff() {
        engineState = false;
    }

    @Override
    public boolean isSwitchedOff() {
        return !engineState;
    }

    @Override
    public boolean isSwitchedOn() {
        return engineState;

    }
}
