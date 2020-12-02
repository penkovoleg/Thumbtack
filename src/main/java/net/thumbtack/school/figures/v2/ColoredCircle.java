package net.thumbtack.school.figures.v2;

import net.thumbtack.school.iface.v2.Colored;

import java.util.Objects;

public class ColoredCircle extends Circle implements Colored {

    private int color;

    public ColoredCircle(Point center, int radius, int color){//1
        this(center.getX(), center.getY(), radius, color);
    }

    public ColoredCircle(int xCenter, int yCenter, int radius, int color){//2
        super(xCenter, yCenter, radius);
        this.color = color;
    }

    public ColoredCircle(int radius, int color){//3
        this(0, 0, radius, color);
    }

    public ColoredCircle(int color){//4
        this(0, 0, 1, color);
    }

    public ColoredCircle(){//5
        this(0, 0, 1, 1);
    }

    public int getColor(){//10
        return color;
    }

    public void setColor(int color){//11
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ColoredCircle that = (ColoredCircle) o;
        return color == that.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color);
    }
}
