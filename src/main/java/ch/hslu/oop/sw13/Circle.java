package ch.hslu.oop.sw13;

/**
 * Write a description of class Circle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public final class Circle extends Shape {

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
    public final void setDiameter(int newDiameter) {
        this.diameter = newDiameter;
    }

    /**
     *
     * @return
     */
    public final int getDiameter() {
        return diameter;
    }

    /**
     *
     * @return
     */
    @Override
    public final double getPerimeter() {
        return 2 * Math.PI * ((double) this.diameter / 2);
    }

    /**
     *
     * @return
     */
    @Override
    public final double getArea() {
        return Math.PI * Math.pow(this.diameter, 2.0);
    }
}
