package net.thumbtack.school.figures.v1;

import java.util.Objects;

public class Circle {

    private int xCenter, yCenter, radius;

    public Circle(Point center, int radius) {//1
        this(center.getX(), center.getY(), radius);
    }

    public Circle(int xCenter, int yCenter, int radius) {//2
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.radius = radius;
    }

    public Circle(int radius) {//3
        this(0,0, radius);
    }

    public Circle() {//4
        this(0,0,1);
    }

    public Point getCenter() {//5
        return new Point(xCenter, yCenter);
    }

    public int getRadius() {//6
        return radius;
    }

    public void setCenter(Point center){//7
        this.xCenter = center.getX();
        this.yCenter = center.getY();
    }

    public void setRadius(int radius){//8
        this.radius = radius;
    }

    public void moveTo(int x, int y){//9
        xCenter = x;
        yCenter = y;
    }

    public void moveTo(Point point){//10
        moveTo(point.getX(), point.getY());
    }

    public void moveRel(int dx, int dy){//11
        xCenter += dx;
        yCenter += dy;
    }

    public void resize(double ratio){//12
        radius = (int)(radius * ratio);
    }

    public double getArea(){//13
        return Math.PI * radius * radius;
    }

    public double getPerimeter(){//14
        return 2 * Math.PI * radius;
    }

    public boolean isInside(int x, int y)
    {
        return radius >= Math.pow(Math.pow(x - xCenter, 2) + Math.pow(y - yCenter, 2), 0.5);
    }

    public boolean isInside(Point point)
    {
        return isInside(point.getX(), point.getY());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return xCenter == circle.xCenter &&
                yCenter == circle.yCenter &&
                radius == circle.radius;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCenter, yCenter, radius);
    }
}
