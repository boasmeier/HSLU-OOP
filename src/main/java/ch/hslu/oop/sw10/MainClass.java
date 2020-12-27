package ch.hslu.oop.sw10;

import java.util.HashSet;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author boasm
 */
public class MainClass implements TemperaturEventListener {

    private static final Logger LOG = LogManager.getLogger(MainClass.class);

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        TemperaturEventListener main = new MainClass();

        // Datastructure to store all the temperatures.
        Set<Temperatur> temperaturen = new HashSet<>();

        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        verlauf.addTemperaturEventListener(main);

        Temperatur temperatur1 = Temperatur.createFromCelsius(ScannerTemperatur.setTempCWithScanner());
        verlauf.add(temperatur1, temperaturen);
        LOG.info(verlauf.toString(temperaturen));
        Temperatur temperatur2 = Temperatur.createFromCelsius(ScannerTemperatur.setTempCWithScanner());
        verlauf.add(temperatur2, temperaturen);
        LOG.info(verlauf.toString(temperaturen));
        Temperatur temperatur3 = Temperatur.createFromCelsius(ScannerTemperatur.setTempCWithScanner());
        verlauf.add(temperatur3, temperaturen);
        LOG.info(verlauf.toString(temperaturen));
    }

    @Override
    public void newMaxOrMin(final TemperaturEvent event) {
        if (event.getPropertyName().equals("newMax")) {
            LOG.info("New max in verlauf: Old max: " + event.getOldValue() + ", New max: " + event.getNewValue());
        } else if (event.getPropertyName().equals("newMin")) {
            LOG.info("New min in verlauf: Old min: " + event.getOldValue() + ", New min: " + event.getNewValue());
        }
    }
}
