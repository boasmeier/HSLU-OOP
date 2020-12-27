package ch.hslu.oop.sw06;

/**
 * Die Klasse Temperatur, erzeugt Objekte mit 3 Instanzvariablen tempCelsius, tempKelvin und tempFahrenheit. Diesen wird
 * standartmässig den Wert 20°C zugewiesen bzw. in Kelvin und Fahrenheit umgerechnet.
 *
 * @author Boas Meier
 * @version SW04 JDK 12
 */
public final class Temperatur {

    // instance variables - replace the example below with your own
    private double tempCelsius;
    private double tempKelvin;
    private double tempFahrenheit;
    private String element;
    private String aggregatszustand;
    private double siedepunktKelvin;
    private double schmelzpunktKelvin;

    /**
     * Konstruktor
     *
     * @param x - Initialises the value of tempCelsius with the double variable x.
     */
    public Temperatur(double x) {
        tempCelsius = x;
        tempKelvin = tempCelsius + 273.15;
        tempFahrenheit = tempCelsius * 1.8 + 32;
    }

    public Temperatur() {
        // initialise instance variables
        tempCelsius = 20;
        tempKelvin = tempCelsius + 273.15;
        tempFahrenheit = tempCelsius * 1.8 + 32;
    }

    /**
     * Returns a {@code String} which contains the aggregate state of the delivered element.
     *
     * @param x - which contains the element
     * @return String - returns the aggregat state
     */
    public String getAggregatszustand(String x) {
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
    public String calcAggregatszustand() {
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
    public void changeTemp(double x) {
        tempCelsius += x;
        tempKelvin = tempCelsius + 273.15;
        tempFahrenheit = tempCelsius * 1.8 + 32;
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
     * Sets the temperature value in celsius
     *
     * @param x - value of temperature in celsius
     *
     */
    public void setTempC(double x) {
        tempCelsius = x;
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

}
