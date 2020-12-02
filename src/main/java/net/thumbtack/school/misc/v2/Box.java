package net.thumbtack.school.misc.v2;

import net.thumbtack.school.iface.v2.Colored;
import net.thumbtack.school.iface.v2.HasArea;

import java.util.Objects;

public class Box implements Colored, HasArea {

    private int color;
    private int area;

    public Box(){
        this(1, 10);
    }

    public Box(int color, int area){
        this.color = color;
        this.area = area;
    }

    public Box(int color){
        this.color = color;
    }

    public void setArea(int area){
        this.area = area;
    }

    @Override
    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public int getColor() {
        return color;
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
