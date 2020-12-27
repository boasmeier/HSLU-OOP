package ch.hslu.oop.sw06;

/**
 *
 * @author boasm
 */
public class mainClass {

    public static void main(String[] args) {
        //main  of Car
        Engine engine = new Engine();
        Light light = new Light();
        engine.switchOn();
        light.switchOn();
        System.out.println(light.isSwitchedOn());
        System.out.println(engine.isSwitchedOn());

        //main of Shape
        Rectangle rectangle = new Rectangle(10, 10, 5, 5);

        //Polymorphie!!!
        Shape shape1 = new Circle(10, 10, 90);
        Shape shape2 = new Rectangle(10, 10, 20, 20);

        shape1.move(5, 5);

        //For using getDiameter shape1 have to get castet into type Circle
        Circle circle = (Circle) shape1;
        int diameter = circle.getDiameter();
        double perimeter = shape1.getPerimeter();

        System.out.println("Perimeter: " + perimeter);

        Switchable switch1 = new Car();
        boolean carOn = switch1.isSwitchedOff();

        //Output
        System.out.println("Perimeter of Rectangle: " + rectangle.getPerimeter());
        System.out.println("Area of Rectangle: " + rectangle.getArea());
        System.out.println("Perimeter of Circle: " + circle.getPerimeter());
        System.out.println("Area of Circle: " + circle.getArea());

        //main of Element
        Quicksilver quicksilver = new Quicksilver(0);
        Plumbum plumbum = new Plumbum(1960);
        Nitrogen nitrogen = new Nitrogen(-270);
        System.out.println("Aggregatsstate of Quicksilver: " + quicksilver.calcAggregatsState() + " " + quicksilver.toString());
        System.out.println("Aggregatsstate of Plumbum: " + plumbum.calcAggregatsState());
        System.out.println("Aggregatsstate of Nitrogen: " + nitrogen.calcAggregatsState());

        //main of Line
        Point point1 = new Point(3, 3);
        Point point2 = new Point(5, 5);
        Point point3 = new Point(1, 1);
        Line line = new Line(point1, point2);
        point2.moveRelative(-1, -1);
        point1.moveRalative(point3);
        System.out.println(line.getStartPoint());
        System.out.println(line.getEndPoint());
        System.out.println(point1.getX() + " " + point1.getY());
        System.out.println(point2.getX() + " " + point2.getX());
    }
}
