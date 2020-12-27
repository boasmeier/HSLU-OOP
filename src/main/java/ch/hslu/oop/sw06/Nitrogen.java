package ch.hslu.oop.sw06;

/**
 * Write a description of class Nitrogen here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Nitrogen extends Element {

    // instance variables - replace the example below with your own
    private final double siedepunktKelvin;
    private final double schmelzpunktKelvin;
    private String aggregatszustand;

    /**
     * Constructor for objects of class Nitrogen
     *
     * @param tempCelsius
     */
    public Nitrogen(final double tempCelsius) {
        super(tempCelsius);
        schmelzpunktKelvin = 63.05;
        siedepunktKelvin = 77.15;
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
