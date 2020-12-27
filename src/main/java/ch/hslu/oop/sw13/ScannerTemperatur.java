/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw13;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author boasm
 */
public class ScannerTemperatur {

    private static final Logger LOG = LogManager.getLogger(ScannerTemperatur.class);

    /**
     * Sets the temperature value in celsius with a ScannerTmperatur.
     *
     * @param verlauf
     * @return
     */
    public static final double setTempCWithScanner(TemperaturVerlauf verlauf) {
        String input;
        double value = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            LOG.info("Bitte Temperatur in °C eingeben ('exit' zum Beenden): ");
            input = scanner.next();
            if (!input.equals("exit")) {
                try {
                    value = Double.valueOf(input);
                    addTemperaturToSet(verlauf, value);
                    LOG.info("New Temperatur: " + input + "°C");
                } catch (NumberFormatException e) {
                    LOG.warn("Invalid input please enter a number!");
                } catch (IllegalArgumentException e) {
                    LOG.warn(e.getMessage());
                }
            } else {
            }
        } while (!input.equals("exit"));
        LOG.info("Programm beendet.");
        return value;
    }

    private static void addTemperaturToSet(TemperaturVerlauf verlauf, double temperaturCelsius) {
        Temperatur temperatur = Temperatur.createFromCelsius(temperaturCelsius);
        verlauf.add(temperatur);
        LOG.info(verlauf.toString());
    }
}
