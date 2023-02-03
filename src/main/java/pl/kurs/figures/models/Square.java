package pl.kurs.figures.models;

public class Square extends Shape {

    private static Square INSTANCE;
    private ShapeType shapeType;
    private double sideLength;

    private Square(double sideLength) {
        this.sideLength = sideLength;
    }

    public static Square getInstance(double sl) {
        if (INSTANCE == null || INSTANCE.sideLength != sl)
            INSTANCE = new Square(sl);

        return INSTANCE;
    }

    public ShapeType getShapeType() {
        return shapeType = ShapeType.SQUARE;
    }

    public double getSideLength() {
        return sideLength;
    }

    @Override
    public String toString() {
        return "Square{" +
                "shapeType=" + shapeType +
                ", sideLength=" + sideLength +
                '}';
    }

    @Override
    public double calculatePerimeter() {
        return 4 * sideLength;
    }

    @Override
    public double calculateArea() {
        return sideLength * sideLength;
    }

}
