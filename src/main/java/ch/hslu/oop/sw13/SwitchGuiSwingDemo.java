/*
 * Copyright 2019 Hochschule Luzern Informatik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.hslu.oop.sw13;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Einfaches GUI auf Swing basierend.
 */
@SuppressWarnings("serial")
public final class SwitchGuiSwingDemo extends JFrame implements ActionListener, WindowListener {

    private static final Logger LOG = LogManager.getLogger(SwitchGuiSwingDemo.class);

    private final JLabel labelState = new JLabel("The switch is OFF.");
    private final JButton buttonOn = new JButton("On");
    private final JButton buttonOff = new JButton("Off");

    /**
     * Konstruktor.
     */
    public SwitchGuiSwingDemo() {
        super("Switch");

        this.addWindowListener(this);
        this.buttonOn.addActionListener(this);
        this.buttonOff.addActionListener(this);
        this.labelState.setHorizontalAlignment(JLabel.CENTER);
        this.labelState.setOpaque(true);

        this.setLayout(new BorderLayout());
        this.add(buttonOn, BorderLayout.NORTH);
        this.add(labelState, BorderLayout.CENTER);
        this.add(buttonOff, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        LOG.info("GUI-Frame aktiviert und sichtbar.");
    }

    /*
     * (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(final ActionEvent event) {
        if (event.getSource() == buttonOn) {
            labelState.setText("The switch is ON.");
            labelState.setBackground(Color.GREEN);
            LOG.info("ActionEvent von ON-Button empfangen und verarbeitet.");
        }
        if (event.getSource() == buttonOff) {
            labelState.setText("The switch is OFF.");
            labelState.setBackground(Color.RED);
            LOG.info("ActionEvent von OFF-Button empfangen und verarbeitet.");
        }
    }

    /**
     * main-Methode.
     *
     * @param args nicht verwendet.
     */
    @SuppressWarnings("unused")
    public static void main(final String[] args) {
        LOG.info("Applikation startet...");
        new SwitchGuiSwingDemo();
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
