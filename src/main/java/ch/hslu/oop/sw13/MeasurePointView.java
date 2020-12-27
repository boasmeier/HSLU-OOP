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
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Einfaches GUI auf Swing basierend.
 */
@SuppressWarnings("serial")
public class MeasurePointView extends JFrame implements ActionListener, WindowListener {

    // Declare and initialize Logger
    private static final Logger LOG = LogManager.getLogger(SwitchGuiSwingDemo.class);

    // Declare and initialize components
    private final JPanel panelLabel = new JPanel();
    private final JPanel panelFileChooser = new JPanel();
    private final JPanel panelProgressBar = new JPanel();
    private final JLabel labelState = new JLabel("Wait for file");
    private final JLabel labelCount = new JLabel("Count: 0");
    private final JLabel labelMaxima = new JLabel("Max: ");
    private final JLabel labelMinima = new JLabel("Min: ");
    private final JFileChooser fileChooser = new JFileChooser("Browse");
    private final JProgressBar progressBar = new JProgressBar();

    // Datastructure to store all the listeners.
    private final List<PropertyChangeListener> changeListeners = new ArrayList<>();

    /**
     * Konstruktor.
     *
     */
    public MeasurePointView() {
        super("Wetterstation File Reader");

        // Add EngineView as ActionListener for buttons
        this.addWindowListener(this);
        this.fileChooser.addActionListener(this);

        // Set Alignment of labels to center
        this.labelState.setHorizontalAlignment(JLabel.CENTER);
        this.labelState.setOpaque(true);
        this.labelCount.setHorizontalAlignment(JLabel.CENTER);
        this.labelCount.setOpaque(true);
        this.labelMaxima.setHorizontalAlignment(JLabel.CENTER);
        this.labelMaxima.setOpaque(true);
        this.labelMinima.setHorizontalAlignment(JLabel.CENTER);
        this.labelMinima.setOpaque(true);

        // Set layout of frame
        this.setLayout(new GridLayout(2, 1));

        // Set layout of panelLabel
        panelLabel.setLayout(new BorderLayout());
        panelLabel.add(labelMaxima, BorderLayout.NORTH);
        panelLabel.add(labelState, BorderLayout.CENTER);
        panelLabel.add(labelCount, BorderLayout.WEST);
        panelLabel.add(labelMinima, BorderLayout.SOUTH);

        // Set layout of panelFileChooser
        panelFileChooser.setLayout(new BorderLayout());
        panelFileChooser.add(fileChooser, BorderLayout.CENTER);
        panelFileChooser.add(panelProgressBar, BorderLayout.SOUTH);
        panelProgressBar.setLayout(new GridLayout(1, 1));
        panelProgressBar.add(progressBar);
        progressBar.setStringPainted(true);

        // Set default close operation
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Add panels to frame and set them visible
        this.pack();
        this.setSize(500, 800);
        this.setVisible(true);
        this.add(panelLabel);
        this.add(panelFileChooser);
        panelLabel.setVisible(true);
        panelFileChooser.setVisible(true);

        LOG.info("GUI-Frame aktiviert und sichtbar.");
    }

    /*
     * (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(final ActionEvent event) {
        if (event.getSource() == fileChooser) {
            final PropertyChangeEvent pcEvent = new PropertyChangeEvent(this, "fileIsAdded", "no File", fileChooser.getSelectedFile().getPath());
            firePropertyChangeEvent(pcEvent);
            labelState.setText("In progress...");
            labelState.setBackground(Color.YELLOW);
            LOG.info(fileChooser.getSelectedFile().getPath());
            LOG.info("ActionEvent von fileChooser empfangen und verarbeitet.");
            this.parsingDone();
        }
    }

    public final void displayMax(final double max) {
        labelMaxima.setText("Max: " + Double.toString(max));
    }

    public final void displayMin(final double min) {
        labelMinima.setText("Min: " + Double.toString(min));
    }

    public final void displayCount(final int count) {
        labelCount.setText("Count: " + Integer.toString(count));
    }

    public final void parsingDone() {
        labelState.setText("Finish (insert nex file)");
        labelState.setBackground(Color.GREEN);
    }

    public final void formatFailure() {
        JOptionPane.showMessageDialog(panelFileChooser, "This format can't be parsed!");
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
