package ch.hslu.oop.sw06;

/**
 * Write a description of class Plumbum here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Plumbum extends Element {

    // instance variables - replace the example below with your own
    private final double siedepunktKelvin;
    private final double schmelzpunktKelvin;
    private String aggregatszustand;

    /**
     * Constructor for objects of class Plumbum
     *
     * @param tempCelsius
     */
    public Plumbum(final double tempCelsius) {
        // initialise instance variables
        super(tempCelsius);
        schmelzpunktKelvin = 600.61;
        siedepunktKelvin = 2017;
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
