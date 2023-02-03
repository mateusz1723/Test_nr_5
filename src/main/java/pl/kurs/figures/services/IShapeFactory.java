package pl.kurs.figures.services;

import pl.kurs.figures.exceptions.InvalidInputException;
import pl.kurs.figures.models.Circle;
import pl.kurs.figures.models.Rectangle;
import pl.kurs.figures.models.Square;

public interface IShapeFactory {

    Square createSquare(double sideLength) throws InvalidInputException;
    Circle createCircle(double radius) throws InvalidInputException;
    Rectangle createRectangle(double width, double height) throws InvalidInputException;
}
