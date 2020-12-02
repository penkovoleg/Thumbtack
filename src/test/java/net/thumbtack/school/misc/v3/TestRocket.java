package net.thumbtack.school.misc.v3;

import net.thumbtack.school.colors.v3.Color;
import net.thumbtack.school.colors.v3.ColorErrorCode;
import net.thumbtack.school.colors.v3.ColorException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestRocket {

    @Test
    public void testRocket1() throws ColorException {
        Rocket rocket = new Rocket();
        assertEquals(75, rocket.getLength());
        assertEquals(15, rocket.getWidth());
        assertEquals(Color.RED, rocket.getColor());
    }

    @Test
    public void testRocket2() throws ColorException{
        Rocket rocket = new Rocket(60, 10, Color.GREEN);
        assertEquals(60, rocket.getLength());
        assertEquals(10, rocket.getWidth());
        assertEquals(Color.GREEN, rocket.getColor());
    }

    @Test
    public void testRocket3() throws ColorException{
        Rocket rocket = new Rocket(70, 10);
        assertEquals(70, rocket.getLength());
        assertEquals(10, rocket.getWidth());
    }

    @Test
    public void testRocket4() throws ColorException{
        Rocket rocket = new Rocket(60, 10, "GREEN");
        assertEquals(60, rocket.getLength());
        assertEquals(10, rocket.getWidth());
        assertEquals(Color.GREEN, rocket.getColor());
    }

    @Test
    public void testSetLength() throws ColorException{
        Rocket rocket = new Rocket();
        assertEquals(75, rocket.getLength());
        rocket.setLength(80);
        assertEquals(80, rocket.getLength());
    }

    @Test
    public void testSetWidth() throws ColorException{
        Rocket rocket = new Rocket();
        assertEquals(15, rocket.getWidth());
        rocket.setWidth(20);
        assertEquals(20, rocket.getWidth());
    }

    @Test
    public void testSetColor() throws ColorException{
        Rocket rocket = new Rocket();
        assertEquals(Color.RED, rocket.getColor());
        rocket.setColor(Color.BLUE);
        assertEquals(Color.BLUE, rocket.getColor());
    }

    @Test
    public void testResizeRocket() throws ColorException{
        Rocket rocket = new Rocket(50, 10);
        rocket.resize(2);
        assertAll(
                () -> assertEquals(100, rocket.getLength()),
                () -> assertEquals(20, rocket.getWidth())
        );
    }

    @Test
    public void testEqualsRocket() throws ColorException{
        Rocket rocket1 = new Rocket(100, 15, Color.RED);
        Rocket rocket2 = new Rocket(70, 10, Color.RED);
        Rocket rocket3 = new Rocket(100, 15, Color.RED);
        assertEquals(rocket1, rocket3);
        assertNotEquals(rocket1, rocket2);
        assertNotEquals(rocket2, rocket3);
    }

    @Test
    @SuppressWarnings("unused")
    public void testSetWrongColor() {
        try {
            Rocket rocket = new Rocket(0,0,"BLACK");
            fail();
        }
        catch (ColorException e){
            assertEquals(ColorErrorCode.WRONG_COLOR_STRING, e.getErrorCode());
        }

        try {
            Rocket rocket = new Rocket(0,0,(String) null);
            fail();
        }
        catch (ColorException e){
            assertEquals(ColorErrorCode.NULL_COLOR, e.getErrorCode());
        }

        try {
            Rocket rocket = new Rocket(0,0,(Color) null);
            fail();
        }
        catch (ColorException e){
            assertEquals(ColorErrorCode.NULL_COLOR, e.getErrorCode());
        }

        try {
            Rocket rocket = new Rocket(0,0, "GREEN");
            rocket.setColor((String) null);
            fail();
        }
        catch (ColorException e){
            assertEquals(ColorErrorCode.NULL_COLOR, e.getErrorCode());
        }

        try {
            Rocket rocket = new Rocket(0,0,"GREEN");
            rocket.setColor((Color) null);
            fail();
        }
        catch (ColorException e){
            assertEquals(ColorErrorCode.NULL_COLOR, e.getErrorCode());
        }
    }
}
