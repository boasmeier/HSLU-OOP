package ch.hslu.oop.sw07;

/**
 * Write a description of class Quicksilver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Quicksilver extends Element {

    // instance variables - replace the example below with your own
    private final double siedepunktKelvin;
    private final double schmelzpunktKelvin;
    private String aggregatszustand;

    /**
     * Constructor for objects of class Quicksilver
     *
     * @param tempCelsius
     */
    public Quicksilver(final double tempCelsius) {
        super(tempCelsius);
        schmelzpunktKelvin = 234.32;
        siedepunktKelvin = 630.2;
    }

    public double getSchmelzpunktKelvin() {
        return schmelzpunktKelvin;
    }

    public double getSiedepunktKelvin() {
        return siedepunktKelvin;
    }

    @Override
    public String calcAggregatsState() {
        if (getTempK() <= schmelzpunktKelvin) {
            aggregatszustand = "fest";
        } else if (getTempK() >= siedepunktKelvin) {
            aggregatszustand = "gasförmig";
        } else {
            aggregatszustand = "flüssig";
        }
        return aggregatszustand;
    }

    @Override
    public String toString() {
        return "Temperatur[Kelvin=" + getTempK() + "] Achtung: GIFTIG!";
    }
}
