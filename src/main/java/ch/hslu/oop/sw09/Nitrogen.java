package ch.hslu.oop.sw09;

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
    private AggregatStates aggregatszustand;
    private String x;

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

    /**
     *
     * @return
     */
    public double getSiedepunktKelvin() {
        return this.siedepunktKelvin;
    }

    /**
     *
     * @return
     */
    public double getSchmelzpunktKelvin() {
        return this.schmelzpunktKelvin;
    }

    /**
     *
     * @return
     */
    @Override
    public AggregatStates calcAggregatsState() {
        if (Double.compare(getTempK(), schmelzpunktKelvin) < 0) {
            aggregatszustand = AggregatStates.SOLID;
        } else if (Double.compare(getTempK(), siedepunktKelvin) >= 0) {
            aggregatszustand = AggregatStates.GAS;
        } else {
            aggregatszustand = AggregatStates.LIQUID;
        }
        return aggregatszustand;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Nitrogen{" + "siedepunktKelvin=" + siedepunktKelvin + ", schmelzpunktKelvin=" + schmelzpunktKelvin + ", aggregatszustand=" + aggregatszustand + '}';
    }

    /**
     *
     * @return
     */
    @Override
    public String getAggregatsStateSwitch() {
        calcAggregatsState();
        switch (aggregatszustand) {

            case SOLID:
                x = "Nitrogen is solid at " + getTempC() + " °C";
                break;
            case LIQUID:
                x = "Nitrogen is liquid at " + getTempC() + " °C";
                break;
            case GAS:
                x = "Nitrogen is gas at " + getTempC() + " °C";
                break;
        }
        return x;
    }

    /**
     *
     * @return
     */
    @Override
    public String getAggregatsState() {
        calcAggregatsState();
        return "Nitrogen is " + aggregatszustand.getState() + " at " + getTempC() + " °C";
    }
}
