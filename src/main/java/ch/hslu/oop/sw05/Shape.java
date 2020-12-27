package ch.hslu.oop.sw05;

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

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(10, 10, 20, 20);
        Circle circle = new Circle(10, 10, 4);
        System.out.println("Perimeter of Rectangle: " + rectangle.getPerimeter());
        System.out.println("Area of Rectangle: " + rectangle.getArea());
        System.out.println("Perimeter of Circle: " + circle.getPerimeter());
        System.out.println("Area of Circle: " + circle.getArea());
    }

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

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public abstract double getPerimeter();

    public abstract double getArea();
}
