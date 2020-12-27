package ch.hslu.oop.sw05;

/**
 * Interface for a simple switch.
 *
 * switchOn(); turns switch on switchOff(); turns switch off isSwitchedOn(); returns true if switch is on
 * isSwitchedOff(); returns true if switch is off
 *
 *
 */
public interface Switchable {

    /**
     * Turns switch on
     */
    void switchOn();

    /**
     * Turns switch off
     */
    void switchOff();

    /**
     * Returns true if switch is on
     *
     * @return boolean - true if switch is on
     */
    boolean isSwitchedOn();

    /**
     * Returns true if switch is off
     *
     * @return boolean - true if switch is off
     */
    boolean isSwitchedOff();
}
