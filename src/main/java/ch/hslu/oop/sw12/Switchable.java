package ch.hslu.oop.sw12;

/**
 * Interface for a simple switch.
 *
 *
 */
public interface Switchable {

    /**
     * Turns switch on.
     */
    void switchOn();

    /**
     * Turns switch off.
     */
    void switchOff();

    /**
     * Returns true if switch is on.
     *
     * @return true if switch is on
     */
    boolean isSwitchedOn();

    /**
     * Returns true if switch is off.
     *
     * @return true if switch is off
     */
    boolean isSwitchedOff();
}
