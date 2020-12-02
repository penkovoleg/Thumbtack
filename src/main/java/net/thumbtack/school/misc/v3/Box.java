package net.thumbtack.school.misc.v3;

import net.thumbtack.school.colors.v3.Color;
import net.thumbtack.school.colors.v3.ColorException;
import net.thumbtack.school.iface.v3.Colored;
import net.thumbtack.school.iface.v3.HasArea;

import java.util.Objects;

public class Box implements Colored, HasArea {

    private Color color;
    private int area;

    public Box() throws ColorException{
        this(Color.RED, 10);
    }

    public Box(Color color, int area) throws ColorException{
        Color.colorEqualsNull(color);
        this.color = color;
        this.area = area;
    }

    public Box(String color, int area) throws ColorException{
        this(Color.colorFromString(color), area);
    }

    public Box(Color color) throws ColorException{
        Color.colorEqualsNull(color);
        this.color = color;
    }

    public Box(String color) throws ColorException{
        this(Color.colorFromString(color));
    }

    public void setArea(int area){
        this.area = area;
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
    public double getArea() {
        return area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Box box = (Box) o;
        return color == box.color &&
                area == box.area;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, area);
    }
}
