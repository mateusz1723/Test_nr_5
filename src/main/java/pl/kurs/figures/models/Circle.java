package pl.kurs.figures.models;

public final class Circle extends Shape {

    private final ShapeType shapeType = ShapeType.CIRCLE;
    private final double radius;

    private Circle(double radius) {
        this.radius = radius;
    }

    public static Circle getCircle(double radius){
        return new Circle(radius);
    }

    public ShapeType getShapeType() {
        return shapeType;
    }

    public double getRadius() {
        return radius;
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
