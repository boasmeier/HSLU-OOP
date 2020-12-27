package ch.hslu.oop.sw05;

/**
 * Write a description of class Point here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Point {

    // instance variables - replace the example below with your own
    private int xKoordinate;
    private int yKoordinate;
    private byte quadrant;

    /**
     * Constructor for objects of class Point
     *
     * @param x
     * @param y
     */
    public Point(int x, int y) {
        // initialise instance variables
        xKoordinate = x;
        yKoordinate = y;
        quadrant = 0;
    }

    public Point() {
        // initialise instance variables
        xKoordinate = 0;
        yKoordinate = 0;
        quadrant = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param x
     */
    public void setX(int x) {
        xKoordinate = x;
    }

    public void setY(int x) {
        yKoordinate = x;
    }

    public int getX() {
        return xKoordinate;
    }

    public int getY() {
        return yKoordinate;
    }

    public byte getQuadrant() {
        if (xKoordinate >= 1 && yKoordinate >= 1) {
            quadrant = 1;
        } else if (xKoordinate <= (-1) && yKoordinate >= 1) {
            quadrant = 2;
        } else if (xKoordinate <= (-1) && yKoordinate <= (-1)) {
            quadrant = 3;
        } else if (xKoordinate >= 1 && yKoordinate <= (-1)) {
            quadrant = 4;
        } else {
            quadrant = 0;
        }

        return quadrant;
    }
}
