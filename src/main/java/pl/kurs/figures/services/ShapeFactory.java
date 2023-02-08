package pl.kurs.figures.services;

import pl.kurs.figures.exceptions.InvalidInputException;
import pl.kurs.figures.models.*;

import java.util.*;

public class ShapeFactory implements IShapeFactory {

    private Map<Double, Circle> circleCache = new LinkedHashMap<>();
    private Map<Double, Square> squareCache = new LinkedHashMap<>();
    private Map<MultiKey, Rectangle> rectangleCache = new LinkedHashMap<>();


    @Override
    public Square createSquare(double sideLength) throws InvalidInputException {
        if (sideLength <= 0)
            throw new InvalidInputException("Wartosc nie moze byc mniejsza niz 0");
        if (squareCache.isEmpty() || !squareCache.containsKey(sideLength)) {
            Square newSquare = Square.getSquare(sideLength);
            squareCache.put(newSquare.getSideLength(), newSquare);
            return newSquare;
        } else
            return squareCache.get(sideLength);

    }

    @Override
    public Circle createCircle(double radius) throws InvalidInputException {
        if (radius <= 0)
            throw new InvalidInputException("Wartosc nie moze byc mniejsza niz 0");
        if (circleCache.isEmpty() || !circleCache.containsKey(radius)) {
            Circle newCircle = Circle.getCircle(radius);
            circleCache.put(newCircle.getRadius(), newCircle);
            return newCircle;
        } else
            return circleCache.get(radius);

    }

    @Override
    public Rectangle createRectangle(double width, double height) throws InvalidInputException {
        MultiKey keys = new MultiKey(width, height);
        if (width <= 0 || height <= 0)
            throw new InvalidInputException("Wartosci nie moga byc mniejsze niz 0");
        if (rectangleCache.isEmpty() || !rectangleCache.containsKey(keys)) {
            Rectangle newRectangle = Rectangle.getRectangle(width, height);
            rectangleCache.put(new MultiKey(newRectangle.getWidth(), newRectangle.getHeight()), newRectangle);
            return newRectangle;
        } else
            return rectangleCache.get(keys);
    }

}
