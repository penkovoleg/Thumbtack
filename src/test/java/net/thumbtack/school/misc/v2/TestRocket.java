package net.thumbtack.school.misc.v2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestRocket {

    @Test
    public void testRocket1(){
        Rocket rocket = new Rocket();
        assertEquals(75, rocket.getLength());
        assertEquals(15, rocket.getWidth());
        assertEquals(1, rocket.getColor());
    }

    @Test
    public void testRocket2(){
        Rocket rocket = new Rocket(60, 10, 2);
        assertEquals(60, rocket.getLength());
        assertEquals(10, rocket.getWidth());
        assertEquals(2, rocket.getColor());
    }

    @Test
    public void testRocket3(){
        Rocket rocket = new Rocket(70, 10);
        assertEquals(70, rocket.getLength());
        assertEquals(10, rocket.getWidth());
    }

    @Test
    public void testSetLength(){
        Rocket rocket = new Rocket();
        assertEquals(75, rocket.getLength());
        rocket.setLength(80);
        assertEquals(80, rocket.getLength());
    }

    @Test
    public void testSetWidth(){
        Rocket rocket = new Rocket();
        assertEquals(15, rocket.getWidth());
        rocket.setWidth(20);
        assertEquals(20, rocket.getWidth());
    }

    @Test
    public void testSetColor(){
        Rocket rocket = new Rocket();
        assertEquals(1, rocket.getColor());
        rocket.setColor(2);
        assertEquals(2, rocket.getColor());
    }

    @Test
    public void testResizeRocket(){
        Rocket rocket = new Rocket(50, 10);
        rocket.resize(2);
        assertAll(
                () -> assertEquals(100, rocket.getLength()),
                () -> assertEquals(20, rocket.getWidth())
        );
    }

    @Test
    public void testEqualsRocket(){
        Rocket rocket1 = new Rocket(100, 15, 1);
        Rocket rocket2 = new Rocket(70, 10, 1);
        Rocket rocket3 = new Rocket(100, 15, 1);
        assertEquals(rocket1, rocket3);
        assertNotEquals(rocket1, rocket2);
        assertNotEquals(rocket2, rocket3);
    }
}
