package net.thumbtack.school.misc.v3;

import net.thumbtack.school.colors.v3.Color;
import net.thumbtack.school.colors.v3.ColorException;
import net.thumbtack.school.iface.v3.Colored;

import java.util.Objects;

public class Apple implements Colored{

    private Color color;

    public Apple() {
        color = Color.RED;
    }

    public Apple(Color color) throws ColorException{
        Color.colorEqualsNull(color);
        this.color = color;
    }

    public Apple(String color) throws ColorException{
        this(Color.colorFromString(color));
    }

    @Override
    public void setColor(Color color) throws ColorException{
        Color.colorEqualsNull(color);
        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(String color) throws ColorException {
        setColor(Color.colorFromString(color));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apple apple = (Apple) o;
        return color == apple.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }
}
