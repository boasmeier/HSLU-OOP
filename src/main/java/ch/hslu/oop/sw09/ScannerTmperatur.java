/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw09;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author boasm
 */
public class ScannerTmperatur {

    private static final Logger LOG = LogManager.getLogger(ScannerTmperatur.class);

    /**
     * Sets the temperature value in celsius with a ScannerTmperatur.
     *
     * @return
     */
    public static final double setTempCWithScanner() {
        String input;
        double value = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            LOG.info("Bitte Temperatur in °C eingeben ('exit' zum Beenden): ");
            input = scanner.next();
            if (input.matches("-?\\d+")) {
                LOG.info("New Temperatur: " + input + "°C");
                value = Double.valueOf(input);
                try {
                    Temperatur.createFromCelsius(value);
                } catch (IllegalArgumentException e) {
                    LOG.error(e.getMessage());
                }
            } else if (!input.equals("exit")) {
                LOG.warn("Invalid input");
            }
            //float value = Float.valueOf(input);
        } while (!input.equals("exit"));
        LOG.info("Programm beendet.");
        return (value);
    }
}
