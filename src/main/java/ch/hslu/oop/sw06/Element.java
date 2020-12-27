package ch.hslu.oop.sw06;

/**
 * Write a description of class TemperaturState here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Element {

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

    public abstract String calcAggregatsState();

    @Override
    public String toString() {
        return "Temperatur[Kelvin=" + getTempK() + "]";
    }

}
