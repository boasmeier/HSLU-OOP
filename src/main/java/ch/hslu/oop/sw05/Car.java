package ch.hslu.oop.sw05;

/**
 * Simple car class which contains the interface Switchable
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Car implements Switchable {

    // instance variables - replace the example below with your own
    private boolean carState;

    public static void main(String[] args) {
        Engine engine = new Engine();
        Light light = new Light();
        engine.switchOn();
        light.switchOn();
        System.out.println(light.isSwitchedOn());
        System.out.println(engine.isSwitchedOn());
    }

    /**
     * Constructor for objects of class Car
     */
    public Car() {
        // initialise instance variables
        carState = false;
    }

    @Override
    public void switchOn() {
        carState = true;
    }

    @Override
    public void switchOff() {
        carState = false;
    }

    @Override
    public boolean isSwitchedOff() {
        return !carState;
    }

    @Override
    public boolean isSwitchedOn() {
        return carState;
    }
}
