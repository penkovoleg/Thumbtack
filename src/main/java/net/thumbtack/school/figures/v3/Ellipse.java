package net.thumbtack.school.figures.v3;

import java.util.Objects;

public class Ellipse extends Figure {

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

    @Override
    public void moveTo(int x, int y){//11
        xCenter = x;
        yCenter = y;
    }

    @Override
    public void moveRel(int dx, int dy){//13
        xCenter += dx;
        yCenter += dy;
    }

    @Override
    public void resize(double ratio){//14
        xAxis = (int)(xAxis * ratio);
        yAxis = (int)(yAxis * ratio);
    }

    public void stretch(double xRatio, double yRatio){//15
        xAxis = (int)(xAxis * xRatio);
        yAxis = (int)(yAxis * yRatio);
    }

    @Override
    public double getArea(){//16
        return Math.PI * (xAxis / 2) * (yAxis / 2);
    }

    @Override
    public double getPerimeter(){//17
        return 2 * Math.PI * Math.sqrt((xAxis * xAxis + yAxis * yAxis) / 8.0);
    }

    @Override
    public boolean isInside(int x, int y){//18
        double a = xAxis / 2;
        double b = yAxis / 2;
        x -= xCenter;
        y -= yCenter;
        return ((x * x) / (a * a) + (y * y) / (b * b) <= 1.);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ellipse ellipse = (Ellipse) o;
        return xAxis == ellipse.xAxis &&
                yAxis == ellipse.yAxis &&
                xCenter == ellipse.xCenter &&
                yCenter == ellipse.yCenter;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xAxis, yAxis, xCenter, yCenter);
    }
}
