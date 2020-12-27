/*
 * Copyright (C) 2019 Hochschule Luzern - Informatik
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package ch.hslu.oop.sw13;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * {Class description here}.
 *
 * @author Boas Meier
 * @version JDK 12.0.2
 */
public class MeasurePointControl implements PropertyChangeListener {

    // Declare and initialize Logger
    private static final Logger LOG = LogManager.getLogger(EngineControl.class);

    // Declare attributes
    private final MeasurePointView measurePointView;
    private final MeasurePointVerlauf verlauf;
    private int fileSize = 0;

    // Declare and Initialize private String attributes
    private final String file = "C:\\BoasMeier\\wetterstationTrace.csv";

    public MeasurePointControl() {
        // Initialize attributes
        measurePointView = new MeasurePointView();  // Create MeasurePointView
        measurePointView.addPropertyChangeListener(this::propertyChange);
        verlauf = new MeasurePointVerlauf();
        verlauf.addTemperaturEventListener(this::newMaxOrMin);  // Register this MeasurePointControl as a TemperaturEventListener
    }

    /**
     * main-Methode.
     *
     * @param args nicht verwendet.
     */
    @SuppressWarnings("unused")
    public static void main(final String[] args) {
        new MeasurePointControl();
        LOG.info("Applikation startet...");
    }

    public void readMeasurepointFromWetterstationTraceCsvFile(final String file, MeasurePointVerlauf verlauf) {
        if (new File(file).exists()) {
            try ( BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), Charset.forName("UTF-8")))) {
                String line;
                String lineSplitted[];
                LocalDateTime t;
                try {
                    while ((line = br.readLine()) != null) {
                        lineSplitted = line.split(";");
                        MeasurePointFormatCheck.formatCheck(lineSplitted[1], lineSplitted[2]);
                        MeasurePoint mp = new MeasurePoint(lineSplitted[1], lineSplitted[2]);
                        verlauf.add(mp);
                    }
                } catch (NumberFormatException e) {
                    LOG.info("This file-format can't be parsed!");
                    measurePointView.formatFailure();
                } catch (IllegalArgumentException e) {
                    LOG.info(e.getMessage());
                    measurePointView.formatFailure();
                }
            } catch (IOException ioe) {
                LOG.error("Unable to read csv file");
            }
        }
    }

    public void newMaxOrMin(final TemperaturEvent event) {
        if (event.getPropertyName().equals("newMax")) {
            LOG.info("New max in verlauf: Old max: " + event.getOldValue() + ", New max: " + event.getNewValue());
        } else if (event.getPropertyName().equals("newMin")) {
            LOG.info("New min in verlauf: Old min: " + event.getOldValue() + ", New min: " + event.getNewValue());
        }
    }

    @Override
    public void propertyChange(final PropertyChangeEvent event) {
        readMeasurepointFromWetterstationTraceCsvFile((String) event.getNewValue(), verlauf);
        measurePointView.displayMax(verlauf.getMax());
        measurePointView.displayMin(verlauf.getMin());
        measurePointView.displayCount(verlauf.getCount());
    }
}
