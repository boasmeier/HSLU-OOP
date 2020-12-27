package ch.hslu.oop.sw12;

/**
 * Write a description of class Demo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Demo {

    // instance variables - replace the example below with your own
    private int x;
    private int y;
    private final int a;
    private final int b;
    private float c;

    /**
     * Constructor for objects of class Demo
     */
    public Demo() {
        // initialise instance variables
        a = 0;
        b = 0;
        x = 1;
        y = 0;
        c = 0.9f;
    }

    /**
     *
     * @param height
     * @param with
     */
    public void printBox(int height, int with) {
        for (x = 1; x <= height; x++) {
            for (y = 1; y <= with; y++) {
                if (x == 1 || x == height || y == 1 || y == with) {
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    /**
     *
     */
    public void iterativeAddition() {
        while (c <= 0.999975f) {
            c += 0.000025f;
            x++;
        }
        System.out.println(c + " Anzahl Durchläufe: " + x);
    }

    /**
     *
     */
    public void iterativeAdditionFor() {
        for (x = 0; x <= 3999; x++) {
            c += 0.000025f;
        }
        System.out.println(c);
    }

    /**
     *
     */
    public void oneToTenWhile() {
        while (x <= 10) {
            System.out.println(x);
            x++;
        }
    }

    /**
     *
     */
    public void oneToTenDoWhile() {
        do {
            System.out.println(x);
            x++;
        } while (x <= 10);
    }

    /**
     *
     */
    public void oneToTenFor() {
        for (x = 1; x <= 10; x++) {
            System.out.println(x);
        }
    }

    /**
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    public int max1(final int a, final int b, final int c) {
        if (a >= b) {
            if (a >= c) {
                return a;
            } else {
                return c;
            }
        } else if (b >= c) {
            return b;
        } else {
            return c;
        }
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public int max(final int a, final int b) {
        if (a >= b) {
            return a;
        } else {
            return b;
        }
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public int min(final int a, final int b) {
        if (a >= b) {
            return b;
        } else {
            return a;
        }
    }
}
