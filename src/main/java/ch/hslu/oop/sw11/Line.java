package ch.hslu.oop.sw11;

/**
 * Class which creates a Line in a 2D room.
 *
 * @author Boas Meier
 * @version SW03 JDK12
 */
public class Line extends Point {

    // instance variables - replace the example below with your own
    private int xKoordinate1;
    private int yKoordinate1;
    private int xKoordinate2;
    private int yKoordinate2;
    private String point1;
    private String point2;
    private byte quadrant;
    private Point startPoint;
    private Point endPoint;

    /**
     * Constructor for objects of class Line
     *
     */
    public Line() {
        startPoint = new Point();
        endPoint = new Point();
    }

    /**
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     */
    public Line(int x1, int y1, int x2, int y2) {
        // initialise instance variables
        xKoordinate1 = x1;
        yKoordinate1 = y1;
        xKoordinate2 = x2;
        yKoordinate2 = y2;
        quadrant = 0;
    }

    /**
     *
     * @param xStart
     * @param yStart
     * @param xEnd
     * @param yEnd
     */
    public Line(short xStart, short yStart, short xEnd, short yEnd) {
        // initialise instance variables
        startPoint = new Point(xStart, yStart);
        endPoint = new Point(xEnd, yEnd);
    }

    /**
     *
     * @param start
     * @param end
     */
    public Line(Point start, Point end) {
        startPoint = start;
        endPoint = end;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param x
     * @param y
     */
    public void setStartPoint(int x, int y) {
        startPoint.setX(x);
        startPoint.setY(y);
    }

    /**
     *
     * @param x
     * @param y
     */
    public void setEndPoint(int x, int y) {
        endPoint.setX(x);
        endPoint.setY(y);
    }

    /**
     *
     * @param start
     */
    public void setStartPoint(Point start) {
        startPoint = start;
    }

    /**
     *
     * @param end
     */
    public void setEndPoint(Point end) {
        endPoint = end;
    }

    /**
     *
     * @return
     */
    public Point getStartPoint() {
        return startPoint;
    }

    /**
     *
     * @return
     */
    public Point getEndPoint() {
        return endPoint;
    }

    /**
     *
     * @param x
     * @param y
     */
    public void setPoint1(int x, int y) {
        xKoordinate1 = x;
        yKoordinate1 = y;
    }

    /**
     *
     * @param x
     * @param y
     */
    public void setPoint2(int x, int y) {
        xKoordinate2 = x;
        yKoordinate2 = y;
    }

    /**
     *
     * @return
     */
    public String getPoint1() {
        point1 = "Koordinaten Punkt 1: x=" + xKoordinate1 + " y=" + yKoordinate1;
        return point1;
    }

    /**
     *
     * @return
     */
    public String getPoint2() {
        point2 = "Koordinaten Punkt 2: x=" + xKoordinate2 + " y=" + yKoordinate2;
        return point2;
    }

    /**
     *
     * @return
     */
    public int getX1() {
        return xKoordinate1;
    }

    /**
     *
     * @return
     */
    public int getX2() {
        return xKoordinate2;
    }

    /**
     *
     * @return
     */
    public int getY1() {
        return yKoordinate1;
    }

    /**
     *
     * @return
     */
    public int getY2() {
        return yKoordinate2;
    }

}
