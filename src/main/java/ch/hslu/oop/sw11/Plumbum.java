package ch.hslu.oop.sw11;

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
    private AggregatStates aggregatszustand;
    private String x;

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

    /**
     *
     * @return
     */
    public double getSchmelzpunktKelvin() {
        return schmelzpunktKelvin;
    }

    /**
     *
     * @return
     */
    public double getSiedepunktKelvin() {
        return siedepunktKelvin;
    }

    /**
     *
     * @return
     */
    @Override
    public AggregatStates calcAggregatsState() {
        if (getTempK() <= schmelzpunktKelvin) {
            aggregatszustand = AggregatStates.SOLID;
        } else if (getTempK() >= siedepunktKelvin) {
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
        return "Plumbum{" + "siedepunktKelvin=" + siedepunktKelvin + ", schmelzpunktKelvin=" + schmelzpunktKelvin + ", aggregatszustand=" + aggregatszustand + '}';
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
                x = "Plumbum is solid at " + getTempC() + " °C";
                break;
            case LIQUID:
                x = "Plumbum is liquid at " + getTempC() + " °C";
                break;
            case GAS:
                x = "Plumbum is gas at " + getTempC() + " °C";
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
        return "Plumbum is" + aggregatszustand.getState() + " at " + getTempC() + " °C";
    }
}
