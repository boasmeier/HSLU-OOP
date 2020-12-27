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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Generates objects of class MeasurePoint from the WetterstationCsv-File.
 *
 * @author Boas Meier
 * @version JDK 12.0.2
 */
public class MeasurePoint {

    private static final Logger LOG = LogManager.getLogger(MeasurePoint.class);
    private LocalDateTime timestamp;
    private double temperaturCelsius;

    public MeasurePoint(String timestamp, String temperatur) {
        try {
            this.timestamp = getFormattedTimestamp(timestamp);
            this.temperaturCelsius = getFormattedTemperatur(temperatur);
        } catch (NumberFormatException e) {
            LOG.info("Illegal Argument!" + e.getMessage());
        }
    }

    private LocalDateTime getFormattedTimestamp(String timestamp) {
        this.timestamp = LocalDateTime.parse(timestamp, DateTimeFormatter.ofPattern("\"yyyy/MM/dd HH:mm:ss\""));
        return (this.timestamp);
    }

    private double getFormattedTemperatur(String temperatur) {
        this.temperaturCelsius = Double.valueOf(temperatur);
        return this.temperaturCelsius;
    }

    public final LocalDateTime getTimestamp() {
        return this.timestamp;
    }

    public final String getTimestampAsString() {
        return String.valueOf(this.timestamp);
    }

    public final double getTemperaturCelsius() {
        return this.temperaturCelsius;
    }

    @Override
    public String toString() {
        return "MeasurePoint{" + "timestamp=" + timestamp + ", temperaturCelsius=" + temperaturCelsius + '}';
    }

    public int compareToTemperatur(MeasurePoint other) {
        return Double.compare(this.getTemperaturCelsius(), other.getTemperaturCelsius());
    }

    public int compareToTime(MeasurePoint other) {
        return Double.compare(this.getTemperaturCelsius(), other.getTemperaturCelsius());
    }

}
