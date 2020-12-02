package net.thumbtack.school.misc.v2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestApple {

    @Test
    public void testApple() {
        Apple apple = new Apple(1);
        assertEquals(1, apple.getColor());
    }

    @Test
    public void setApple() {
        Apple apple = new Apple();
        assertEquals(2, apple.getColor());
        apple.setColor(3);
        assertNotEquals(1, apple.getColor());
    }

    @Test
    public void testEqualsApple() {
        Apple apple1 = new Apple(1);
        Apple apple2 = new Apple(1);
        Apple apple3 = new Apple(3);
        assertEquals(apple1, apple2);
        assertNotEquals(apple1, apple3);
    }
}

