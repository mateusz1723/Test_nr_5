package pl.kurs.figures.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.kurs.figures.exceptions.InvalidInputException;
import pl.kurs.figures.models.Shape;
import pl.kurs.figures.models.ShapeType;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class ShapeService implements IShapeService {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Shape findShapeWithTheBiggestArea(List<Shape> shapes) throws InvalidInputException {
        return Optional.ofNullable(shapes)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparingDouble(x -> x.calculateArea()))
                .orElseThrow(() -> new InvalidInputException("Nie znaleziono figury"));

    }

    @Override
    public Shape findShapeWithTheBiggestPerimeterOnType(List<Shape> shapes, ShapeType type) throws InvalidInputException {
        if (type == null)
            throw new InvalidInputException("Nie znaleziono figury");


        return Optional.ofNullable(shapes)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(x -> x.getShapeType().getName().equals(type.getName()))
                .max(Comparator.comparingDouble(x -> x.calculatePerimeter()))
                .orElseThrow(() -> new InvalidInputException("Nie znaleziono figury"));

    }

    @Override
    public void exportToJson(List<Shape> shapes, String path) throws InvalidInputException, IOException {
        List<Shape> list = Optional.ofNullable(shapes)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        if (path == null)
            throw new InvalidInputException("Sciezka nie moze byc pusta");

        objectMapper.writeValue(new File(path), list);

    }

    @Override
    public List<Shape> importFromJson(String path) throws InvalidInputException, IOException {
        if (path == null)
            throw new InvalidInputException("Brak pliku o podanej sciezce");

        return objectMapper.readValue(new File(path), List.class);
    }
}
