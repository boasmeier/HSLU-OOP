/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw10;

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
            } else {
                LOG.warn("Invalid input");
            }
        } while (!input.equals("exit"));
        LOG.info("Programm beendet.");
        return value;
    }
}
