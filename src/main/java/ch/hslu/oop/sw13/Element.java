package ch.hslu.oop.sw13;

import java.util.Objects;

/**
 * Write a description of class TemperaturState here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Element implements Comparable<Element> {

    // instance variables - replace the example below with your own
    private double tempCelsius;
    private double tempKelvin;
    private double tempFahrenheit;

    /**
     * Konstruktor
     *
     * @param temperatur
     */
    protected Element(double temperatur) {
        tempCelsius = temperatur;
        tempKelvin = tempCelsius + 273.15;
        tempFahrenheit = tempCelsius * 1.8 + 32;
    }

    /**
     *
     */
    protected Element() {
        // initialise instance variables
        tempCelsius = 20;
        tempKelvin = tempCelsius + 273.15;
        tempFahrenheit = tempCelsius * 1.8 + 32;
    }

    /**
     * Sets the temperature value in celsius
     *
     * @param newTemperatur
     */
    public void setTempC(double newTemperatur) {
        this.tempCelsius = newTemperatur;
    }

    /**
     * Returns the temperature value in celsius
     *
     *
     * @return double - returns the temperature value in celsius
     */
    public double getTempC() {
        return tempCelsius;
    }

    /**
     * Returns the temperature value in fahrenheit
     *
     *
     * @return double - returns the temperature value in fahrenheit
     */
    public double getTempF() {
        tempFahrenheit = tempCelsius * 1.8 + 32;
        return tempFahrenheit;
    }

    /**
     * Returns the temperature value in kelvin
     *
     *
     * @return double - returns the temperature value in kelvin
     */
    public double getTempK() {
        tempKelvin = tempCelsius + 273.15;
        return tempKelvin;
    }

    /**
     *
     * @return
     */
    public abstract AggregatStates calcAggregatsState();

    /**
     *
     * @return
     */
    public abstract String getAggregatsStateSwitch();

    /**
     *
     * @return
     */
    public abstract String getAggregatsState();

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Temperatur[Kelvin=" + getTempK() + "]";
    }

    /**
     *
     * @return
     */
    @Override
    public final int hashCode() {
        return Objects.hash(this.getTempK());
    }

    /**
     *
     * @param object
     * @return
     */
    @Override
    public final boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Element)) {
            return false;
        }
        final Element other = (Element) object;
        return (Double.compare(other.getTempK(), this.getTempK()) == 0);
    }

    /**
     *
     * @param other
     * @return
     */
    @Override
    public int compareTo(Element other) {
        return Double.compare(this.getTempK(), other.getTempK());
    }
}
