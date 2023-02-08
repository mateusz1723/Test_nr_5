package pl.kurs.figures.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import pl.kurs.figures.exceptions.InvalidInputException;
import pl.kurs.figures.models.Circle;
import pl.kurs.figures.models.Rectangle;
import pl.kurs.figures.models.Shape;
import pl.kurs.figures.models.Square;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ShapeFactoryTest {


    ShapeFactory shapeFactory;

    @Before
    public void init() {
        shapeFactory = new ShapeFactory();
    }


    @Test
    public void shouldReturnSameInstanceWhileCreatingCircleWithSameParameters() throws InvalidInputException {
        Circle circle1 = shapeFactory.createCircle(10);
        Circle circle2 = shapeFactory.createCircle(12);
        Circle circle3 = shapeFactory.createCircle(10);

        assertEquals(circle1, circle3);
        assertNotEquals(circle1, circle2);
    }

    @Test
    public void shouldReturnSameInstanceWhileCreatingSquareWithSameParameters() throws InvalidInputException {
        Square square1 = shapeFactory.createSquare(10);
        Square square2 = shapeFactory.createSquare(12);
        Square square3 = shapeFactory.createSquare(10);

        assertEquals(square1, square3);
        assertNotEquals(square1, square2);
    }


    @Test
    public void shouldReturnSameInstanceWhileCreatingRectangleWithSameParameters() throws InvalidInputException {
        Rectangle rectangle1 = shapeFactory.createRectangle(10, 15);
        Rectangle rectangle2 = shapeFactory.createRectangle(15, 14);
        Rectangle rectangle3 = shapeFactory.createRectangle(10, 15);

        assertEquals(rectangle1, rectangle3);
        assertNotEquals(rectangle1, rectangle2);
    }


    @Test
    public void shouldReturnMessageWartoscNieMozeBycMniejszaNiz0WhileCreatingCircle() {
        //when
        Throwable e = assertThrows(InvalidInputException.class, () -> shapeFactory.createCircle(-2));

        assertEquals(e.getClass(), InvalidInputException.class);
        assertEquals(e.getMessage(), "Wartosc nie moze byc mniejsza niz 0");
    }

    @Test
    public void shouldReturnMessageWartoscNieMozeBycMniejszaNiz0WhileCreatingSquare() {
        //when
        Throwable e = assertThrows(InvalidInputException.class, () -> shapeFactory.createSquare(-2));

        assertEquals(e.getClass(), InvalidInputException.class);
        assertEquals(e.getMessage(), "Wartosc nie moze byc mniejsza niz 0");
    }

    @Test
    public void shouldReturnMessageWartoscNieMozeBycMniejszaNiz0WhileCreatingRectangleWithMinusHeight() {
        //when
        Throwable e = assertThrows(InvalidInputException.class, () -> shapeFactory.createRectangle(2, -15));

        assertEquals(e.getClass(), InvalidInputException.class);
        assertEquals(e.getMessage(), "Wartosci nie moga byc mniejsze niz 0");
    }

    @Test
    public void shouldReturnMessageWartoscNieMozeBycMniejszaNiz0WhileCreatingRectangleWithMinusWidth() {
        //when
        Throwable e = assertThrows(InvalidInputException.class, () -> shapeFactory.createRectangle(-2, 15));

        assertEquals(e.getClass(), InvalidInputException.class);
        assertEquals(e.getMessage(), "Wartosci nie moga byc mniejsze niz 0");
    }

    @Test
    public void shouldReturnMessageWartoscNieMozeBycMniejszaNiz0WhileCreatingRectangleWithMinusBothArguments() {
        //when
        Throwable e = assertThrows(InvalidInputException.class, () -> shapeFactory.createRectangle(-2, -15));

        assertEquals(e.getClass(), InvalidInputException.class);
        assertEquals(e.getMessage(), "Wartosci nie moga byc mniejsze niz 0");
    }
}