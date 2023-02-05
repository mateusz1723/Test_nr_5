package pl.kurs.figures.models;

public class Circle extends Shape {

    private static Circle INSTANCE;
    private ShapeType shapeType = ShapeType.CIRCLE;
    private double radius;

    private Circle(double radius) {
        this.radius = radius;
    }

    public static Circle getInstance(double r) {
        if (INSTANCE == null || INSTANCE.radius != r)
            INSTANCE = new Circle(r);

        return INSTANCE;
    }

    public ShapeType getShapeType() {
        return shapeType;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "{" +
                "shapeType=" + shapeType +
                ", radius=" + radius +
                '}';
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
