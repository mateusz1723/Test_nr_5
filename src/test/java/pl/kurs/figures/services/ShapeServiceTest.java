package pl.kurs.figures.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import pl.kurs.figures.exceptions.InvalidInputException;
import pl.kurs.figures.models.Circle;
import pl.kurs.figures.models.Shape;
import pl.kurs.figures.models.ShapeType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ShapeServiceTest {

    List<Shape> shapes;
    ShapeFactory shapeFactory;
    ShapeService shapeService;
    ObjectMapper objectMapper;

    @Before
    public void init() throws InvalidInputException {
        shapeFactory = new ShapeFactory();
        shapes = new ArrayList<>();
        shapes.add(shapeFactory.createCircle(10));
        shapes.add(shapeFactory.createCircle(12));
        shapes.add(shapeFactory.createCircle(16));
        shapes.add(shapeFactory.createSquare(10));
        shapes.add(shapeFactory.createSquare(20));
        shapes.add(shapeFactory.createSquare(14));
        shapes.add(shapeFactory.createRectangle(14, 15));
        shapes.add(shapeFactory.createRectangle(12, 12));
        shapes.add(shapeFactory.createRectangle(16, 13));
        shapeService = new ShapeService();
        objectMapper = new ObjectMapper();
    }

    @Test
    public void shouldReturnCircleWithRadius13() throws InvalidInputException {
        //when
        Shape shapeWithTheBiggestArea = shapeService.findShapeWithTheBiggestArea(shapes);
        //then
        assertEquals(shapes.get(2), shapeWithTheBiggestArea);

    }

    @Test
    public void shouldReturnOnTypeRectangleARectangleWithWidth14AndHeight15() throws InvalidInputException {
        //when
        Shape shapeWithTheBiggestPerimeterOnType = shapeService.findShapeWithTheBiggestPerimeterOnType(shapes, ShapeType.RECTANGLE);
        //then
        assertEquals(shapes.get(6), shapeWithTheBiggestPerimeterOnType);
    }

    @Test
    public void shouldReturnOnTypeSquareASquareWith20SideLength() throws InvalidInputException {
        //when
        Shape shapeWithTheBiggestPerimeterOnType = shapeService.findShapeWithTheBiggestPerimeterOnType(shapes, ShapeType.SQUARE);
        //then
        assertEquals(shapes.get(4), shapeWithTheBiggestPerimeterOnType);
    }

    @Test
    public void shouldReturnOnTypeCircleACircleWith16Radius() throws InvalidInputException {
        //when
        Shape shapeWithTheBiggestPerimeterOnType = shapeService.findShapeWithTheBiggestPerimeterOnType(shapes, ShapeType.CIRCLE);
        //then
        assertEquals(shapes.get(2), shapeWithTheBiggestPerimeterOnType);
    }


    @Test
    public void shouldExportListOfShapesToJson() throws InvalidInputException, IOException {
        //given
        shapeService.exportToJson(shapes, "src/test/resources/shapes.json");
        //when
        List list = objectMapper.readValue(new File("src/test/resources/shapes.json"), List.class);
        //then
        assertEquals(shapes.toString(), list.toString());

    }

    @Test
    public void shouldImportFileToListOfShapes() throws InvalidInputException, IOException {
        //given
        objectMapper.writeValue(new File("src/test/resources/shapes3.json"), shapes);
        //when
        List<Shape> shapes = shapeService.importFromJson("src/test/resources/shapes3.json");
        //then
        assertNotNull(shapes);

    }

    @Test
    public void shouldReturnInvalidInputExceptionWhileListIsNullInTheBiggestPerimeter(){
        //when
        Throwable e = assertThrows(InvalidInputException.class , () -> shapeService.findShapeWithTheBiggestPerimeterOnType(null,ShapeType.CIRCLE));
        //then
        assertEquals(e.getClass(), InvalidInputException.class);
        assertEquals(e.getMessage(), "Nie znaleziono figury");
    }

    @Test
    public void shouldReturnInvalidInputExceptionWhileTypeIsNullInTheBiggestPerimeter(){
        //when
        Throwable e = assertThrows(InvalidInputException.class , () -> shapeService.findShapeWithTheBiggestPerimeterOnType(shapes,null));
        //then
        assertEquals(e.getClass(), InvalidInputException.class);
        assertEquals(e.getMessage(), "Nie znaleziono figury");
    }

    @Test
    public void shouldReturnInvalidInputExceptionWhileListIsNullInTheBiggestArea(){
        //when
        Throwable e = assertThrows(InvalidInputException.class , () -> shapeService.findShapeWithTheBiggestArea(null));
        //then
        assertEquals(e.getClass(), InvalidInputException.class);
        assertEquals(e.getMessage(), "Nie znaleziono figury");
    }


    @Test
    public void shouldReturnMessageBrakPlikuOPodanejSciezceWhileImport(){
        //when
        Throwable e = assertThrows(InvalidInputException.class ,() -> shapeService.importFromJson(null));
        //then
        assertEquals(e.getClass(), InvalidInputException.class);
        assertEquals(e.getMessage(), "Brak pliku o podanej sciezce");
    }


    @Test
    public void shouldReturnMessageSciezkaNieMozeBycPustaWhileExport(){
        //when
        Throwable e = assertThrows(InvalidInputException.class ,() -> shapeService.exportToJson(shapes, null));
        //then
        assertEquals(e.getClass(), InvalidInputException.class);
        assertEquals(e.getMessage(), "Sciezka nie moze byc pusta");
    }

}