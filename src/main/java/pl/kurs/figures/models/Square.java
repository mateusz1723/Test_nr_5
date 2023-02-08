package pl.kurs.figures.models;

public final class Square extends Shape {

    private final ShapeType shapeType = ShapeType.SQUARE;
    private final double sideLength;

    private Square(double sideLength) {
        this.sideLength = sideLength;
    }

    public static Square getSquare(double sideLength) {
        return new Square(sideLength);
    }

    public ShapeType getShapeType() {
        return shapeType;
    }

    public double getSideLength() {
        return sideLength;
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
