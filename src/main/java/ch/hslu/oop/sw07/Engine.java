package ch.hslu.oop.sw07;

/**
 * Write a description of class Engine here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public final class Engine implements Switchable {

    // instance variables - replace the example below with your own
    private boolean engineOn;

    /**
     * Constructor for objects of class Engine
     */
    public Engine() {
        // initialise instance variables
        engineOn = false;
    }

    @Override
    public void switchOn() {
        engineOn = true;
    }

    @Override
    public void switchOff() {
        engineOn = false;
    }

    @Override
    public boolean isSwitchedOff() {
        return !engineOn;
    }

    @Override
    public boolean isSwitchedOn() {
        return engineOn;

    }
}
