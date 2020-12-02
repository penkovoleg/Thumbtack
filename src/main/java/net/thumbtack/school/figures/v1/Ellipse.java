package net.thumbtack.school.figures.v1;

import java.util.Objects;

public class Ellipse extends Point{

    private int xAxis, yAxis, xCenter, yCenter;

    public Ellipse(Point center, int xAxis, int yAxis){//1
        this(center.getX(), center.getY(), xAxis, yAxis);
    }

    public Ellipse(int xCenter, int yCenter, int xAxis, int yAxis){//2
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public Ellipse(int xAxis, int yAxis){//3
        this(0,0, xAxis, yAxis);
    }

    public Ellipse(){//4
        this(0,0,1,1);
    }

    public Point getCenter(){//5
        return new Point(xCenter, yCenter);
    }

    public int getXAxis(){//6
        return xAxis;
    }

    public int getYAxis(){//7
        return yAxis;
    }

    public void setXAxis(int xAxis){//8
        this.xAxis = xAxis;
    }

    public void setYAxis(int yAxis){//9
        this.yAxis = yAxis;
    }

    public void setCenter(Point center){//10
        xCenter = center.getX();
        yCenter = center.getY();
    }

    public void moveTo(int x, int y){//11
        xCenter = x;
        yCenter = y;
    }

    public void moveTo(Point point){//12
        moveTo(point.getX(), point.getY());
    }

    public void moveRel(int dx, int dy){//13
        xCenter += dx;
        yCenter += dy;
    }

    public void resize(double ratio){//14
        xAxis = (int)(xAxis * ratio);
        yAxis = (int)(yAxis * ratio);
    }

    public void stretch(double xRatio, double yRatio){//15
        xAxis = (int)(xAxis * xRatio);
        yAxis = (int)(yAxis * yRatio);
    }

    public double getArea(){//16
        return Math.PI * (xAxis / 2) * (yAxis / 2);
    }

    public double getPerimeter(){//17
        return 2 * Math.PI * Math.sqrt((xAxis * xAxis + yAxis * yAxis) / 8.0);
    }

    public boolean isInside(int x, int y){//18
        double a = xAxis / 2;
        double b = yAxis / 2;
        x -= xCenter;
        y -= yCenter;
        return ((x * x) / (a * a) + (y * y) / (b * b) <= 1.);
    }

    public boolean isInside(Point point){//19
        return isInside(point.getX(), point.getY());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Ellipse ellipse = (Ellipse) o;
        return xAxis == ellipse.xAxis &&
                yAxis == ellipse.yAxis &&
                xCenter == ellipse.xCenter &&
                yCenter == ellipse.yCenter;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), xAxis, yAxis, xCenter, yCenter);
    }
}
