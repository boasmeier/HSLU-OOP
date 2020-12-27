package ch.hslu.oop.sw12;

/**
 * Write a description of class Quicksilver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public final class Quicksilver extends Element {

    // instance variables - replace the example below with your own
    private final double siedepunktKelvin;
    private final double schmelzpunktKelvin;
    private AggregatStates aggregatszustand;
    private String x;

    /**
     * Constructor for objects of class Quicksilver
     *
     * @param tempCelsius
     */
    public Quicksilver(double tempCelsius) {
        super(tempCelsius);
        schmelzpunktKelvin = 234.32;
        siedepunktKelvin = 630.2;
        calcAggregatsState();
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
    public String getAggregatsStateSwitch() {
        calcAggregatsState();
        switch (aggregatszustand) {

            case SOLID:
                x = "Quicksilver is solid at " + getTempC() + " °C";
                break;
            case LIQUID:
                x = "Quicksilver is liquid at " + getTempC() + " °C";
                break;
            case GAS:
                x = "Quicksilver is gas at " + getTempC() + " °C";
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
        return "Quicksilver is" + aggregatszustand.getState() + " at " + getTempC() + " °C";
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Temperatur[Kelvin=" + getTempK() + "] Achtung: GIFTIG!";
    }
}
