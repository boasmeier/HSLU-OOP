package ch.hslu.oop.sw08;

import java.util.Objects;

/**
 * Die Klasse Temperatur, erzeugt Objekte mit 3 Instanzvariablen tempCelsius, tempKelvin und tempFahrenheit. Diesen wird
 * standartmässig den Wert 20°C zugewiesen bzw. in Kelvin und Fahrenheit umgerechnet.
 *
 * @author Boas Meier
 * @version SW04 JDK 12
 */
public final class Temperatur implements Comparable<Temperatur> {

    // instance variables - replace the example below with your own
    private double tempCelsius;
    private double tempKelvin;
    private double tempFahrenheit;
    private String element;
    private String aggregatszustand;
    private double siedepunktKelvin;
    private double schmelzpunktKelvin;

    //Constants
    private static final double KELVIN_OFFSET = 273.15;

    /**
     * Konstruktor
     *
     * @param x - Initialises the value of tempCelsius with the double variable x.
     */
    public Temperatur(double x) {
        tempCelsius = x;
        tempKelvin = convertCelsiusToKelvin(tempCelsius);
        tempFahrenheit = tempCelsius * 1.8 + 32;
    }

    public Temperatur() {
        // initialise instance variables
        tempCelsius = 20;
        tempKelvin = convertCelsiusToKelvin(tempCelsius);
        tempFahrenheit = tempCelsius * 1.8 + 32;
    }

    /**
     * Converts celsius to kelvin.
     *
     * @param celsius
     * @return kelvin
     */
    public final static double convertCelsiusToKelvin(double celsius) {
        return celsius + Temperatur.KELVIN_OFFSET;
    }

    /**
     * Converts kelvin to celsius.
     *
     * @param kelvin
     * @return celsius
     */
    public final static double convertKelvinToCelsius(double kelvin) {
        return kelvin - Temperatur.KELVIN_OFFSET;
    }

    /**
     * Returns a {@code String} which contains the aggregate state of the delivered element.
     *
     * @param x - which contains the element
     * @return String - returns the aggregat state
     */
    public final String getAggregatszustand(String x) {
        element = x;
        if ("N".equals(element)) {
            schmelzpunktKelvin = 63.05;
            siedepunktKelvin = 77.15;
        } else if ("Hg".equals(element)) {
            schmelzpunktKelvin = 234.32;
            siedepunktKelvin = 630.2;
        } else if ("Pb".equals(element)) {
            schmelzpunktKelvin = 600.61;
            siedepunktKelvin = 2017;
        }

        return calcAggregatszustand();
    }

    /**
     * Sets the aggregat state.
     *
     *
     * @return String - returns the aggregat state
     */
    public final String calcAggregatszustand() {
        if (tempKelvin <= schmelzpunktKelvin) {
            aggregatszustand = "fest";
        } else if (tempKelvin >= siedepunktKelvin) {
            aggregatszustand = "gasförmig";
        } else {
            aggregatszustand = "flüssig";
        }
        return aggregatszustand;
    }

    /**
     * Change the Temperature with the {@code double} variable x
     *
     * @param x - value to change the temperature
     *
     */
    public final void changeTemp(double x) {
        tempCelsius += x;
        tempKelvin = convertCelsiusToKelvin(tempCelsius);
        tempFahrenheit = tempCelsius * 1.8 + 32;
    }

    /**
     * Returns the temperature value in fahrenheit
     *
     *
     * @return double - returns the temperature value in fahrenheit
     */
    public final double getTempF() {
        tempFahrenheit = tempCelsius * 1.8 + 32;
        return tempFahrenheit;
    }

    /**
     * Returns the temperature value in kelvin
     *
     *
     * @return double - returns the temperature value in kelvin
     */
    public final double getTempK() {
        tempKelvin = convertCelsiusToKelvin(tempCelsius);
        return tempKelvin;
    }

    /**
     * Sets the temperature value in celsius
     *
     * @param x - value of temperature in celsius
     *
     */
    public final void setTempC(double x) {
        tempCelsius = x;
    }

    /**
     * Returns the temperature value in celsius
     *
     *
     * @return double - returns the temperature value in celsius
     */
    public final double getTempC() {
        return tempCelsius;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(this.getTempK(), this.getTempC(), this.getTempF());
    }

    @Override
    public final boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Temperatur)) {
            return false;
        }
        final Temperatur other = (Temperatur) object;
        return (Double.compare(other.getTempK(), this.getTempK()) == 0) && (Double.compare(other.getTempC(), this.getTempC()) == 0) && (Double.compare(other.getTempF(), this.getTempF()) == 0);
    }

    @Override
    public String toString() {
        return "Temperatur{" + "tempCelsius=" + tempCelsius + ", tempKelvin=" + tempKelvin + ", tempFahrenheit=" + tempFahrenheit + ", element=" + element + ", aggregatszustand=" + aggregatszustand + ", siedepunktKelvin=" + siedepunktKelvin + ", schmelzpunktKelvin=" + schmelzpunktKelvin + '}';
    }

    @Override
    public final int compareTo(Temperatur other) {
        return Double.compare(this.getTempK(), other.getTempK());
    }
}
