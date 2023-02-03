package pl.kurs.figures.models;

public class Rectangle extends Shape {

    private static Rectangle INSTANCE;
    private ShapeType shapeType;
    private double width;
    private double height;

    private Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public static Rectangle getInstance(double h, double w) {
        if (INSTANCE == null || (INSTANCE.height != h && INSTANCE.width != w))
            INSTANCE = new Rectangle(w, h);

        return INSTANCE;
    }

    public ShapeType getShapeType() {
        return shapeType = ShapeType.RECTANGLE;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
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
