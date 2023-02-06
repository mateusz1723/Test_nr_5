package pl.kurs.figures.services;

import pl.kurs.figures.exceptions.InvalidInputException;
import pl.kurs.figures.models.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ShapeFactory implements IShapeFactory {

    private List<Circle> circleCache = new ArrayList<>();
    private List<Square> squareCache = new ArrayList<>();
    private List<Rectangle> rectangleCache = new ArrayList<>();



    @Override
    public Square createSquare(double sideLength) throws InvalidInputException {
        if (sideLength <= 0)
            throw new InvalidInputException("Wartosc nie moze byc mniejsza niz 0");
        if (squareCache.isEmpty() || squareCache.stream().noneMatch(x -> x.getSideLength() == sideLength)) {
            Square newSquare = Square.getSquare(sideLength);
            squareCache.add(newSquare);
            return newSquare;
        } else
            return squareCache.stream().filter(x -> x.getSideLength() == sideLength).findFirst().orElseThrow();

    }

    @Override
    public Circle createCircle(double radius) throws InvalidInputException {
        if (radius <= 0)
            throw new InvalidInputException("Wartosc nie moze byc mniejsza niz 0");
        if (circleCache.isEmpty() || circleCache.stream().noneMatch(x -> x.getRadius() == radius)) {
            Circle newCircle = Circle.getCircle(radius);
            circleCache.add(newCircle);
            return newCircle;
        } else
            return circleCache.stream().filter(x -> x.getRadius() == radius).findFirst().orElseThrow();

    }

    @Override
    public Rectangle createRectangle(double width, double height) throws InvalidInputException {
        if (width <= 0 || height <= 0)
            throw new InvalidInputException("Wartosci nie moga byc mniejsze niz 0");
        if (rectangleCache.isEmpty() || rectangleCache.stream().noneMatch(x -> x.getWidth() == width && x.getHeight() == height)) {
            Rectangle newRectangle = Rectangle.getRectangle(width, height);
            rectangleCache.add(newRectangle);
            return newRectangle;
        } else
            return rectangleCache.stream().filter(x -> x.getWidth() == width && x.getHeight() == height).findFirst().orElseThrow();
    }

}
