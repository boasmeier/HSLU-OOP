package ch.hslu.oop.sw06;

/**
 * Write a description of class Rectangle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rectangle extends Shape {

    // instance variables - replace the example below with your own
    private int width;
    private int height;

    /**
     * Constructor for objects of class Rectangle
     *
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public Rectangle(final int x, final int y, final int width, final int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param newWidth
     * @param newHeight
     */
    public void changeDimension(final int newWidth, final int newHeight) {
        this.width = newWidth;
        this.height = newHeight;
    }

    /**
     *
     * @return
     */
    public int getWidth() {
        return this.width;
    }

    /**
     *
     * @return
     */
    public int getHeight() {
        return this.height;
    }

    /**
     *
     * @return
     */
    @Override
    public double getPerimeter() {
        return (2 * this.width) + (2 * this.height);
    }

    /**
     *
     * @return
     */
    @Override
    public double getArea() {
        return (double) this.width * this.height;
    }
}
