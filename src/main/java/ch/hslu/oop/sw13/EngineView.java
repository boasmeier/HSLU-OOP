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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * {Class description here}.
 *
 * @author Boas Meier
 * @version JDK 12.0.2
 */
@SuppressWarnings("serial")
public class EngineView extends JFrame implements ActionListener, WindowListener {

    // Declare and initialize Logger
    private static final Logger LOG = LogManager.getLogger(EngineView.class);

    // Declare and initialize private attributes
    private int rpm = 2000;
    private int dysfunctionCounter = 0;

    // Declare and initialize components
    private final JPanel panelLabel = new JPanel();
    private final JPanel panelRPM = new JPanel();
    private final JLabel labelState = new JLabel("The engine is OFF.");
    private final JLabel labelRPM = new JLabel(Integer.toString(rpm));
    private final JButton buttonOn = new JButton("On");
    private final JButton buttonOff = new JButton("Off");
    private final JButton buttonReset = new JButton("Reset");
    private final JButton buttonRPMUp = new JButton("Up");
    private final JButton buttonRPMDown = new JButton("Down");

    // Datastructure to store all the listeners.
    private final List<PropertyChangeListener> changeListeners = new ArrayList<>();

    public EngineView() {
        super("Switch");

        // Add EngineView as ActionListener for buttons
        this.addWindowListener(this);
        this.buttonOn.addActionListener(this);
        this.buttonOff.addActionListener(this);
        this.buttonReset.addActionListener(this);
        this.buttonRPMUp.addActionListener(this);
        this.buttonRPMDown.addActionListener(this);

        // Set Alignment of labels to center
        this.labelState.setHorizontalAlignment(JLabel.CENTER);
        this.labelRPM.setHorizontalAlignment(JLabel.CENTER);
        this.labelState.setOpaque(true);
        this.labelRPM.setOpaque(true);

        // Set layout of frame
        this.setLayout(new GridLayout(2, 2));

        // Set layout of panelLabel
        panelLabel.setLayout(new BorderLayout());
        panelLabel.add(buttonOn, BorderLayout.NORTH);
        panelLabel.add(labelState, BorderLayout.CENTER);
        panelLabel.add(buttonOff, BorderLayout.SOUTH);

        // Set layout of panelRPM
        panelRPM.setLayout(new BorderLayout());
        panelRPM.add(buttonRPMUp, BorderLayout.WEST);
        panelRPM.add(labelRPM, BorderLayout.CENTER);
        panelRPM.add(buttonRPMDown, BorderLayout.EAST);

        // Initialise GUI to start state
        buttonOff.setEnabled(false);
        buttonOn.setEnabled(true);
        labelState.setBackground(Color.RED);
        labelRPM.setBackground(Color.LIGHT_GRAY);
        labelRPM.setText("0");
        buttonRPMUp.setEnabled(false);
        buttonRPMDown.setEnabled(false);

        // Add panels to frame and set them visible
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.add(panelLabel);
        this.add(panelRPM);
        panelLabel.setVisible(true);
        panelRPM.setVisible(true);

        LOG.info("GUI-Frame aktiviert und sichtbar.");
    }

    @Override
    public void actionPerformed(final ActionEvent event) {
        if (event.getSource() == buttonOn) {
            setStateEngineOn();
        }
        if (event.getSource() == buttonOff) {
            setStateEngineOff();
        }
        if (event.getSource() == buttonReset) {
            setStateEngineOff();
        }
        if (event.getSource() == buttonRPMUp) {
            increaseRPM();
        }
        if (event.getSource() == buttonRPMDown) {
            decreaseRPM();
        }
    }

    private void setStateDysfunction() {
        labelState.setText("Dysfunction on Engine!");
        labelRPM.setText("0");
        labelRPM.setBackground(Color.LIGHT_GRAY);
        labelState.setBackground(Color.ORANGE);
        buttonOff.setEnabled(false);
        buttonOn.setEnabled(false);
        buttonRPMUp.setEnabled(false);
        buttonRPMDown.setEnabled(false);
        panelLabel.add(buttonReset, BorderLayout.WEST);
        buttonReset.setEnabled(true);
    }

    private void setStateEngineOn() {
        dysfunctionCounter++;
        final PropertyChangeEvent pcEvent = new PropertyChangeEvent(this, "offToOn", "OFF", "ON");
        this.firePropertyChangeEvent(pcEvent);
        buttonOn.setEnabled(false);
        buttonOff.setEnabled(true);
        buttonRPMUp.setEnabled(true);
        buttonRPMDown.setEnabled(true);
        labelState.setText("The engine is ON.");
        labelState.setBackground(Color.GREEN);
        labelRPM.setText(Integer.toString(rpm));
        LOG.info("ActionEvent von ON-Button empfangen und verarbeitet.");
        if (dysfunctionCounter == 3) {
            setStateDysfunction();
            dysfunctionCounter = 0;
        }
    }

    private void setStateEngineOff() {
        final PropertyChangeEvent pcEvent = new PropertyChangeEvent(this, "onToOff", "ON", "OFF");
        this.firePropertyChangeEvent(pcEvent);
        buttonOff.setEnabled(false);
        buttonOn.setEnabled(true);
        buttonRPMUp.setEnabled(false);
        buttonRPMDown.setEnabled(false);
        buttonReset.setEnabled(false);
        labelState.setText("The engine is OFF.");
        labelState.setBackground(Color.RED);
        labelRPM.setText("0");
        LOG.info("ActionEvent von OFF-Button empfangen und verarbeitet.");
        rpm = 2000;
    }

    private void increaseRPM() {
        rpm += 200;
        labelRPM.setText(Integer.toString(rpm));
        if (rpm >= 3400) {
            labelRPM.setBackground(Color.YELLOW);
        }
        if (rpm >= 4000) {
            setStateDysfunction();
        }
    }

    private void decreaseRPM() {
        rpm -= 200;
        labelRPM.setText(Integer.toString(rpm));
        if (rpm <= 3200) {
            labelRPM.setBackground(Color.LIGHT_GRAY);
        }
        if (rpm <= 0) {
            setStateEngineOff();
        }
    }

    /**
     *
     * Informs all PropertyChangeListeners about PropertyChangeEvent.
     *
     * @param pcEvent PropertyChangeEvent.
     */
    private void firePropertyChangeEvent(final PropertyChangeEvent pcEvent) {
        for (final PropertyChangeListener listener : this.changeListeners) {
            listener.propertyChange(pcEvent);
        }
    }

    /**
     * Register a PropertyChangeListener.
     *
     * @param listener PropertyChangeListener.
     */
    public void addPropertyChangeListener(final PropertyChangeListener listener) {
        if (!listener.equals(null)) {
            this.changeListeners.add(listener);
        } else {
            throw new NullPointerException("Listener mustn't be null");
        }
    }

    /**
     * Deregister a PropertyChangeListener.
     *
     * @param listener PropertyChangeListener.
     */
    public void removePropertyChangeListener(final ActionListener listener) {
        if (!listener.equals(null)) {
            this.changeListeners.remove(listener);
        } else {
            throw new NullPointerException("Listener mustn't be null");
        }
    }

    @Override
    public void windowOpened(WindowEvent arg0) {
        // nothing to do
    }

    @Override
    public void windowClosing(WindowEvent arg0) {
        LOG.info("Applikation terminiert...");
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent arg0) {
        // nothing to do
    }

    @Override
    public void windowIconified(WindowEvent arg0) {
        // nothing to do
    }

    @Override
    public void windowDeiconified(WindowEvent arg0) {
        // nothing to do
    }

    @Override
    public void windowActivated(WindowEvent arg0) {
        // nothing to do
    }

    @Override
    public void windowDeactivated(WindowEvent arg0) {
        // nothing to do
    }
}
