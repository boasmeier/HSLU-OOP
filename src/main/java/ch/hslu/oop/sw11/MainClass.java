package ch.hslu.oop.sw11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Iterator;
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
        Set<MeasurePoint> measurePoints = new HashSet<>();
        MeasurePointVerlauf verlauf = new MeasurePointVerlauf();
        //Register main as a TemperaturEventListener
        verlauf.addTemperaturEventListener(main);

        readMeasurepointFromWetterstationTraceCsvFile("C:\\BoasMeier\\wetterstationTrace.csv", measurePoints, verlauf);
        LOG.warn(verlauf.getMeasurePointOfMax(measurePoints).toString());
        LOG.error(verlauf.getMeasurePointOfMin(measurePoints).toString());

        /*
        writeTemperaturVerlaufInTextFile("C:\\BoasMeier\\demo.txt", temperaturen);
        readTemperaturVerlaufInTextFile("C:\\BoasMeier\\demo.txt", temperaturen);

        if (new File("C:\\BoasMeier\\wetterstationTrace.csv").exists()) {
            LOG.info("file exists");
        } else {
            LOG.info("file don't exist");
        }
         */
 /*
        //Übung zu SW11
        //Write file demo.txt
        try (final DataOutputStream dos = new DataOutputStream(new FileOutputStream("C:\\BoasMeier\\demo.txt"))) {
            char index = 1;
            dos.writeChar(index);
            dos.writeDouble(addTemperatureToSet(verlauf, temperaturen).getTempC());
            dos.writeChar(index);
            dos.writeDouble(addTemperatureToSet(verlauf, temperaturen).getTempC());
            dos.writeChar(index);
            dos.writeDouble(addTemperatureToSet(verlauf, temperaturen).getTempC());


        } catch (IOException ioe) {
            LOG.error("Unable to write file demo.txt", ioe);
        }
        //Read file demo.txt
        try (DataInputStream dis = new DataInputStream(new FileInputStream("C:\\BoasMeier\\demo.txt"))) {
            final int value = dis.readInt();        //readByte = 0, readFloat = 1.7e-44
            LOG.info(value);
            final int value2 = dis.readInt();        //readByte = 0, readFloat = 1.7e-44
            LOG.info(value2);
            final int value3 = dis.readInt();        //readByte = 0, readFloat = 1.7e-44
            LOG.info(value3);
        } catch (IOException ioe) {
            LOG.error("Unable to read file demo.txt", ioe);
        } */
    }

    public static void writeTemperaturVerlaufInTextFile(final String file, Set<Temperatur> temperaturen) {
        try ( PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), Charset.forName("UTF-8"))));) {
            int index = 1;
            Iterator<Temperatur> iterator = temperaturen.iterator();
            while (iterator.hasNext()) {
                final Temperatur t = iterator.next();
                pw.println(index + " " + t.getTempC());
                index++;
            }
            pw.flush();
        } catch (IOException ioe) {
            LOG.error("Unable to write file demo.txt", ioe);
        }
    }

    public static void readTemperaturVerlaufInTextFile(final String file, Set<Temperatur> temperaturen) {
        if (new File("C:\\BoasMeier\\demo.txt").exists()) {
            try ( BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), Charset.forName("UTF-8")))) {
                String line;
                Iterator<Temperatur> iterator = temperaturen.iterator();
                while (iterator.hasNext()) {
                    final Temperatur t = iterator.next();
                    while ((line = br.readLine()) != null) {
                        LOG.info(line);
                    }
                }
            } catch (IOException ioe) {
                LOG.error("Unable to read file demo.txt", ioe);
            }
        }
    }

    public static void readWetterstationTraceCsvFile(final String file) {
        if (new File("C:\\BoasMeier\\wetterstationTrace.csv").exists()) {
            try ( BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), Charset.forName("UTF-8")))) {
                String line;
                while ((line = br.readLine()) != null) {
                    LOG.info(line);
                }
            } catch (IOException ioe) {
                LOG.error("Unable to read csv file");
            }
        }
    }

    public static void readMeasurepointFromWetterstationTraceCsvFile(final String file, Set<MeasurePoint> measurePoints, MeasurePointVerlauf verlauf) {
        if (new File("C:\\BoasMeier\\wetterstationTrace.csv").exists()) {
            try ( BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), Charset.forName("UTF-8")))) {
                String line;
                String lineSplitted[];
                LocalDateTime t;
                while ((line = br.readLine()) != null) {
                    lineSplitted = line.split(";");
                    MeasurePoint mp = new MeasurePoint(lineSplitted[1], lineSplitted[2]);
                    verlauf.add(mp, measurePoints);
                }
            } catch (IOException ioe) {
                LOG.error("Unable to read csv file");
            }
        }
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
