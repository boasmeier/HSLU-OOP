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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * {Class description here}.
 *
 * @author Boas Meier
 * @version JDK 12.0.2
 */
public class EngineControl implements PropertyChangeListener {

    private static final Logger LOG = LogManager.getLogger(EngineControl.class);
    private final Engine engine;
    private final EngineView engineView;

    public EngineControl() {
        engine = new Engine();
        engine.addPropertyChangeListener(this::eventHandler);  //Lambda Expression (member reference) Parameter event wird der Methode mitgegeben.
        engineView = new EngineView();
        engineView.addPropertyChangeListener(this::propertyChange);
    }

    public void eventHandler(final PropertyChangeEvent event) {
        if (event.getSource() == this.engine) {
            //this.handleMotorEvent("Motor", event);
            LOG.info("Engine State changed from " + event.getOldValue() + " to " + event.getNewValue());
        }
    }

    /**
     * main-Methode.
     *
     * @param args nicht verwendet.
     */
    @SuppressWarnings("unused")
    public static void main(final String[] args) {
        new EngineControl();
        LOG.info("Applikation startet...");
    }

    @Override
    public void propertyChange(final PropertyChangeEvent event) {
        if (event.getPropertyName() == "offToOn") {
            engine.switchOn();
        }
        if (event.getPropertyName() == "onToOff") {
            engine.switchOff();
        }
    }

}
