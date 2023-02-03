package pl.kurs.figures.services;

import pl.kurs.figures.exceptions.InvalidInputException;
import pl.kurs.figures.models.Shape;
import pl.kurs.figures.models.ShapeType;

import java.io.IOException;
import java.util.List;

public interface IShapeService {

    Shape findShapeWithTheBiggestArea(List<Shape> shapes);
    Shape findShapeWithTheBiggestPerimeter(List<Shape> shapes, ShapeType shapeType);
    void exportToJson(List<Shape> shapes, String path) throws InvalidInputException, IOException;
    List<Shape> importFromJson(String path) throws InvalidInputException, IOException;

}
