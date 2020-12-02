package net.thumbtack.school.misc.v2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestBox {

    @Test
    public void testBox1(){
        Box box = new Box(1);
        assertEquals(1, box.getColor());
    }

    @Test
    public void testBox2(){
        Box box = new Box(2, 20);
        assertEquals(2, box.getColor());
        assertEquals(20, box.getArea());
    }

    @Test
    public void testSetArea(){
        Box box = new Box();
        assertEquals(1, box.getColor());
        assertEquals(10, box.getArea());
        box.setColor(2);
        assertEquals(2, box.getColor());
        box.setArea(15);
        assertEquals(15, box.getArea());
    }

    @Test
    public void testEqualsBox(){
        Box box1 = new Box(1,10);
        Box box2 = new Box(1, 10);
        Box box3 = new Box(2, 20);
        assertEquals(box1, box2);
        assertNotEquals(box1, box3);
    }
}
