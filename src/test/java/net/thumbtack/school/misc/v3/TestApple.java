package net.thumbtack.school.misc.v3;

import net.thumbtack.school.colors.v3.Color;
import net.thumbtack.school.colors.v3.ColorErrorCode;
import net.thumbtack.school.colors.v3.ColorException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestApple {

    @Test
    public void testApple1() throws ColorException{
        Apple apple = new Apple(Color.RED);
        assertEquals(Color.RED, apple.getColor());
    }

    @Test
    public void testApple2() throws ColorException{
        Apple apple = new Apple("RED");
        assertEquals(Color.RED, apple.getColor());
    }

    @Test
    public void TestSetApple() throws ColorException {
        Apple apple = new Apple();
        assertEquals(Color.RED, apple.getColor());
        apple.setColor(Color.BLUE);
        assertNotEquals(Color.GREEN, apple.getColor());
    }

    @Test
    public void testEqualsApple() throws ColorException{
        Apple apple1 = new Apple(Color.BLUE);
        Apple apple2 = new Apple(Color.BLUE);
        Apple apple3 = new Apple(Color.RED);
        assertEquals(apple1, apple2);
        assertNotEquals(apple1, apple3);
    }

    @Test
    @SuppressWarnings("unused")
    public void testSetWrongColor() {
        try {
            Apple apple = new Apple("BLACK");
            fail();
        }
        catch (ColorException e){
            assertEquals(ColorErrorCode.WRONG_COLOR_STRING, e.getErrorCode());
        }
        try {
            Apple apple = new Apple((String) null);
            fail();
        }
        catch (ColorException e){
            assertEquals(ColorErrorCode.NULL_COLOR, e.getErrorCode());
        }
        try {
            Apple apple = new Apple((Color) null);
            fail();
        }
        catch (ColorException e){
            assertEquals(ColorErrorCode.NULL_COLOR, e.getErrorCode());
        }
        try {
            Apple apple = new Apple("GREEN");
            apple.setColor((String) null);
            fail();
        }
        catch (ColorException e){
            assertEquals(ColorErrorCode.NULL_COLOR, e.getErrorCode());
        }
        try {
            Apple apple = new Apple("GREEN");
            apple.setColor((Color) null);
            fail();
        }
        catch (ColorException e){
            assertEquals(ColorErrorCode.NULL_COLOR, e.getErrorCode());
        }
    }
}

