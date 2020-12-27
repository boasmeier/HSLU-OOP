package ch.hslu.oop.sw05;

/**
 * Write a description of class Light here.
 *
 * @author Boas Meier
 * @version SW04 JDK12
 */
public class Light extends Car {

    // instance variables - replace the example below with your own
    private boolean lightState;

    /**
     * Constructor for objects of class Car
     */
    public Light() {
        // initialise instance variables
        lightState = false;
    }

    @Override
    public void switchOn() {
        lightState = true;
    }

    @Override
    public void switchOff() {
        lightState = false;
    }

    @Override
    public boolean isSwitchedOff() {
        return !lightState;
    }

    @Override
    public boolean isSwitchedOn() {
        return lightState;
    }
}
