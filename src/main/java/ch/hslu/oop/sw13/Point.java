package ch.hslu.oop.sw13;

import java.util.Objects;

/**
 * Write a description of class Point here.
 *
 * @author Boas Meier
 * @version JDK 12.1 SW06
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

    /**
     *
     * @param point
     */
    public Point(Point point) {
        xKoordinate = point.getX();
        yKoordinate = point.getY();
    }

    /**
     *
     */
    public Point() {
        // initialise instance variables
        xKoordinate = 0;
        yKoordinate = 0;
        quadrant = 0;
    }

    /**
     *
     * @param point
     */
    public void moveRalative(Point point) {
        xKoordinate += point.getX();
        yKoordinate += point.getY();
    }

    /**
     *
     * @param x
     * @param y
     */
    public void moveRelative(int x, int y) {
        xKoordinate += x;
        yKoordinate += y;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param x
     */
    public void setX(int x) {
        xKoordinate = x;
    }

    /**
     *
     * @param x
     */
    public void setY(int x) {
        yKoordinate = x;
    }

    /**
     *
     * @return
     */
    public int getX() {
        return xKoordinate;
    }

    /**
     *
     * @return
     */
    public int getY() {
        return yKoordinate;
    }

    /**
     *
     * @return
     */
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

    /**
     *
     * @return
     */
    @Override
    public final int hashCode() {
        return Objects.hash(this.getX(), this.getY());
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Point{" + "xKoordinate=" + xKoordinate + ", yKoordinate=" + yKoordinate + ", quadrant=" + quadrant + '}';
    }

    /**
     *
     * @param object
     * @return
     */
    @Override
    public final boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Point)) {
            return false;
        }
        final Point other = (Point) object;
        return (other.getX() == this.getX()) && (other.getY() == this.getY());
    }

}
