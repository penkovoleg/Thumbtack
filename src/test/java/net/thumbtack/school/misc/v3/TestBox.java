package net.thumbtack.school.misc.v3;

import net.thumbtack.school.colors.v3.Color;
import net.thumbtack.school.colors.v3.ColorErrorCode;
import net.thumbtack.school.colors.v3.ColorException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestBox {

    @Test
    public void testBox1() throws ColorException {
        Box box = new Box(Color.RED);
        assertEquals(Color.RED, box.getColor());
    }

    @Test
    public void testBox2() throws ColorException {
        Box box = new Box("RED");
        assertEquals(Color.RED, box.getColor());
    }

    @Test
    public void testBox3() throws ColorException {
        Box box = new Box(Color.GREEN, 20);
        assertEquals(Color.GREEN, box.getColor());
        assertEquals(20, box.getArea());
    }

    @Test
    public void testBox4() throws ColorException {
        Box box = new Box("BLUE", 20);
        assertEquals(Color.BLUE, box.getColor());
        assertEquals(20, box.getArea());
    }

    @Test
    public void testSetArea() throws ColorException{
        Box box = new Box();
        assertEquals(Color.RED, box.getColor());
        assertEquals(10, box.getArea());
        box.setColor(Color.GREEN);
        assertEquals(Color.GREEN, box.getColor());
        box.setArea(15);
        assertEquals(15, box.getArea());
    }

    @Test
    public void testEqualsBox() throws ColorException{
        Box box1 = new Box(Color.RED,10);
        Box box2 = new Box(Color.RED, 10);
        Box box3 = new Box(Color.GREEN, 20);
        assertEquals(box1, box2);
        assertNotEquals(box1, box3);
    }

    @Test
    @SuppressWarnings("unused")
    public void testSetWrongColor() {
        try {
            Box box = new Box("BLACK");
            fail();
        }
        catch (ColorException e){
            assertEquals(ColorErrorCode.WRONG_COLOR_STRING, e.getErrorCode());
        }

        try {
            Box box = new Box((String) null);
            fail();
        }
        catch (ColorException e){
            assertEquals(ColorErrorCode.NULL_COLOR, e.getErrorCode());
        }

        try {
            Box box = new Box((Color) null);
            fail();
        }
        catch (ColorException e){
            assertEquals(ColorErrorCode.NULL_COLOR, e.getErrorCode());
        }

        try {
            Box box = new Box("GREEN");
            box.setColor((String) null);
            fail();
        }
        catch (ColorException e){
            assertEquals(ColorErrorCode.NULL_COLOR, e.getErrorCode());
        }

        try {
            Box box = new Box("GREEN");
            box.setColor((Color) null);
            fail();
        }
        catch (ColorException e){
            assertEquals(ColorErrorCode.NULL_COLOR, e.getErrorCode());
        }
    }
}
