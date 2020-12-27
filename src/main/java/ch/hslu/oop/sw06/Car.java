package ch.hslu.oop.sw06;

/**
 * Simple car class which contains the interface Switchable
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Car implements Switchable {

    // instance variables - replace the example below with your own
    private boolean carOn;
    private final Engine engine;
    private final Light light;

    /**
     * Constructor for objects of class Car
     */
    public Car() {
        // initialise instance variables
        carOn = false;
        light = new Light();
        engine = new Engine();
    }

    @Override
    public void switchOn() {
        carOn = true;
        light.switchOn();
        engine.switchOn();
    }

    @Override
    public void switchOff() {
        carOn = false;
        light.switchOff();
        engine.switchOff();
    }

    @Override
    public boolean isSwitchedOff() {
        return !carOn;
    }

    @Override
    public boolean isSwitchedOn() {
        return carOn;
    }
}
