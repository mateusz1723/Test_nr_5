package pl.kurs.figures.services;

import pl.kurs.figures.exceptions.InvalidInputException;
import pl.kurs.figures.models.Circle;
import pl.kurs.figures.models.Rectangle;
import pl.kurs.figures.models.Square;

public class ShapeFactory implements IShapeFactory {

    @Override
    public Square createSquare(double sideLength) throws InvalidInputException {
        if (sideLength <= 0)
            throw new InvalidInputException("Wartosc nie moze byc mniejsza niz 0");
        return Square.getInstance(sideLength);
    }

    @Override
    public Circle createCircle(double radius) throws InvalidInputException {
        if (radius <= 0)
            throw new InvalidInputException("Wartosc nie moze byc mniejsza niz 0");
        return Circle.getInstance(radius);
    }

    @Override
    public Rectangle createRectangle(double width, double height) throws InvalidInputException {
        if (width <= 0 || height <= 0)
            throw new InvalidInputException("Wartosci nie moga byc mniejsze niz 0");
        return Rectangle.getInstance(width, height);
    }

}
