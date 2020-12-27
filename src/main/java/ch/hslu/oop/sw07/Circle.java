package ch.hslu.oop.sw07;

/**
 * Write a description of class Circle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Circle extends Shape {

    // instance variables - replace the example below with your own
    private int diameter;

    /**
     * Constructor for objects of class Circle
     *
     * @param x
     * @param y
     * @param diameter
     */
    public Circle(final int x, final int y, final int diameter) {
        // initialise instance variables
        super(x, y);
        this.diameter = diameter;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param newDiameter
     */
    public void setDiameter(int newDiameter) {
        this.diameter = newDiameter;
    }

    public int getDiameter() {
        return diameter;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * ((double) this.diameter / 2);
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(this.diameter, 2.0);
    }
}
