package pl.kurs.figures.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import pl.kurs.figures.exceptions.InvalidInputException;
import pl.kurs.figures.models.Circle;
import pl.kurs.figures.models.Rectangle;
import pl.kurs.figures.models.Square;

import static org.junit.Assert.*;

public class ShapeFactoryTest {


    ShapeFactory shapeFactory;

    @Before
    public void init(){
        shapeFactory = new ShapeFactory();
    }


    @Test
    public void shouldReturnTrueWhileCircle1EqualsCircle2() throws InvalidInputException {
        Circle circle1 = shapeFactory.createCircle(10);
        Circle circle2 = shapeFactory.createCircle(10);

        assertTrue(circle1.equals(circle2));
    }

    @Test
    public void shouldReturnTrueWhileSquare1EqualsSquare2() throws InvalidInputException {
        Square square1 = shapeFactory.createSquare(10);
        Square square2 = shapeFactory.createSquare(10);

        assertTrue(square1.equals(square2));
    }


    @Test
    public void shouldReturnTrueWhileRectangle1EqualsRectangle2() throws InvalidInputException {
        Rectangle rectangle1 = shapeFactory.createRectangle(10, 15);
        Rectangle rectangle2 = shapeFactory.createRectangle(10, 15);

        assertTrue(rectangle1.equals(rectangle2));
    }



    @Test
    public void shouldReturnMessageWartoscNieMozeBycMniejszaNiz0WhileCreatingCircle(){
        //when
       Throwable e = assertThrows(InvalidInputException.class, () -> shapeFactory.createCircle(-2));

       assertEquals(e.getClass(), InvalidInputException.class);
       assertEquals(e.getMessage(), "Wartosc nie moze byc mniejsza niz 0");
    }

    @Test
    public void shouldReturnMessageWartoscNieMozeBycMniejszaNiz0WhileCreatingSquare(){
        //when
        Throwable e = assertThrows(InvalidInputException.class, () -> shapeFactory.createSquare(-2));

        assertEquals(e.getClass(), InvalidInputException.class);
        assertEquals(e.getMessage(), "Wartosc nie moze byc mniejsza niz 0");
    }

    @Test
    public void shouldReturnMessageWartoscNieMozeBycMniejszaNiz0WhileCreatingRectangleWithMinusHeight(){
        //when
        Throwable e = assertThrows(InvalidInputException.class, () -> shapeFactory.createRectangle(2, -15));

        assertEquals(e.getClass(), InvalidInputException.class);
        assertEquals(e.getMessage(), "Wartosci nie moga byc mniejsze niz 0");
    }

    @Test
    public void shouldReturnMessageWartoscNieMozeBycMniejszaNiz0WhileCreatingRectangleWithMinusWidth(){
        //when
        Throwable e = assertThrows(InvalidInputException.class, () -> shapeFactory.createRectangle(-2, 15));

        assertEquals(e.getClass(), InvalidInputException.class);
        assertEquals(e.getMessage(), "Wartosci nie moga byc mniejsze niz 0");
    }

    @Test
    public void shouldReturnMessageWartoscNieMozeBycMniejszaNiz0WhileCreatingRectangleWithMinusBothArguments(){
        //when
        Throwable e = assertThrows(InvalidInputException.class, () -> shapeFactory.createRectangle(-2, -15));

        assertEquals(e.getClass(), InvalidInputException.class);
        assertEquals(e.getMessage(), "Wartosci nie moga byc mniejsze niz 0");
    }
}