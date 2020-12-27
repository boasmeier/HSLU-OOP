package ch.hslu.oop.sw07;

/**
 * Write a description of class Nitrogen here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public final class Nitrogen extends Element {

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
        this.schmelzpunktKelvin = 63.05;
        this.siedepunktKelvin = 77.15;
    }

    public double getSiedepunktKelvin() {
        return this.siedepunktKelvin;
    }

    public double getSchmelzpunktKelvin() {
        return this.schmelzpunktKelvin;
    }

    @Override
    public String calcAggregatsState() {
        if (Double.compare(getTempK(), schmelzpunktKelvin) < 0) {
            aggregatszustand = "fest";
        } else if (Double.compare(getTempK(), siedepunktKelvin) >= 0) {
            aggregatszustand = "gasförmig";
        } else {
            aggregatszustand = "flüssig";
        }
        return aggregatszustand;
    }

    @Override
    public String toString() {
        return "Nitrogen{" + "siedepunktKelvin=" + siedepunktKelvin + ", schmelzpunktKelvin=" + schmelzpunktKelvin + ", aggregatszustand=" + aggregatszustand + '}';
    }
}
