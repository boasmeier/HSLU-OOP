package ch.hslu.oop.sw09;

/**
 * Write a description of class Light here.
 *
 * @author Boas Meier
 * @version SW04 JDK12
 */
public class Light implements Switchable {

    // instance variables - replace the example below with your own
    private boolean lightOn;

    /**
     * Constructor for objects of class Car
     */
    public Light() {
        // initialise instance variables
        lightOn = false;
    }

    /**
     *
     */
    @Override
    public void switchOn() {
        lightOn = true;
    }

    /**
     *
     */
    @Override
    public void switchOff() {
        lightOn = false;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isSwitchedOff() {
        return !lightOn;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isSwitchedOn() {
        return lightOn;
    }
}
