package pl.kurs.figures.models;

public final class Rectangle extends Shape {

    private final ShapeType shapeType = ShapeType.RECTANGLE;
    private final double width;
    private final double height;

    private Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public static Rectangle getRectangle(double width, double height){
        return new Rectangle(width, height);
    }

    public ShapeType getShapeType() {
        return shapeType;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "{" +
                "shapeType=" + shapeType +
                ", width=" + width +
                ", height=" + height +
                '}';
    }

    @Override
    public double calculatePerimeter() {
        return 2 * width + 2 * height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }
}
