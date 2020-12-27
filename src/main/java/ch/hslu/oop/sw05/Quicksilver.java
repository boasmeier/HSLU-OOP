package ch.hslu.oop.sw05;

/**
 * Write a description of class Quicksilver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Quicksilver extends TemperaturState {

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

}
