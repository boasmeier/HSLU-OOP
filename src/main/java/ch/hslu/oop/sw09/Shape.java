package ch.hslu.oop.sw09;

/**
 * Write a description of class Shape here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Shape {

    // instance variables - replace the example below with your own
    private int x;
    private int y;

    /**
     * Constructor for objects of class Shape
     */
    public Shape() {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param x
     * @param y
     */
    protected Shape(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    /**
     *
     * @param newX
     * @param newY
     */
    public final void move(final int newX, final int newY) {
        this.x = newX;
        this.y = newY;
    }

    /**
     *
     * @return
     */
    public final int getX() {
        return this.x;
    }

    /**
     *
     * @return
     */
    public final int getY() {
        return this.y;
    }

    /**
     *
     * @return
     */
    public abstract double getPerimeter();

    /**
     *
     * @return
     */
    public abstract double getArea();
}
