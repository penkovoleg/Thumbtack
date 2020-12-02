package net.thumbtack.school.figures.v2;

import java.util.Objects;

public class Rectangle extends Figure {

    private int xRight, xLeft, yTop, yBottom;

    public Rectangle(Point leftTop, Point rightBottom){//1
        this(leftTop.getX(), leftTop.getY(), rightBottom.getX(), rightBottom.getY());
    }

    public Rectangle(int xLeft, int yTop, int xRight, int yBottom) {//2
        this.xRight = xRight;
        this.xLeft = xLeft;
        this.yBottom = yBottom;
        this.yTop = yTop;
    }

    public Rectangle(int length, int width){//3
        this(0, -width, length,0);
    }

    public Rectangle(){//4
        this(0,-1,1,0);
    }

    public Point getTopLeft() {//5
        return new Point(xLeft, yTop);
    }

    public Point getBottomRight() {//6
        return new Point(xRight, yBottom);
    }

    public void setTopLeft(Point topLeft) {//7
        this.xLeft = topLeft.getX();
        this.yTop = topLeft.getY();
    }

    public void setBottomRight(Point bottomRight) {//8
        this.xRight = bottomRight.getX();
        this.yBottom = bottomRight.getY();
    }
    public int getLength() {//9
        return xRight - xLeft;
    }

    public int getWidth() {//10
        return yBottom - yTop;
    }

    @Override
    public void moveTo(int x, int y) {//11
        this.xRight = xRight - xLeft + x;
        this.yBottom = yBottom - yTop + y;
        this.xLeft = x;
        this.yTop = y;
    }

    @Override
    public void moveRel(int dx, int dy) {//13
        xLeft = xLeft + dx;
        yTop = yTop + dy;
        xRight = xRight + dx;
        yBottom = yBottom + dy;
    }

    @Override
    public void resize(double ratio) {//14
        this.xRight = xLeft + (int)(getLength() * ratio);
        this.yBottom = yTop + (int)(getWidth() * ratio);
    }

    public void stretch(double xRatio, double yRatio) {//15
        this.xRight = xLeft + (int)(getLength() * xRatio);
        this.yBottom = yTop + (int)(getWidth() * yRatio);
    }

    @Override
    public double getArea() {//16
        return getLength() * getWidth();
    }

    @Override
    public double getPerimeter() {//17
        return 2 * (getLength() + getWidth());
    }

    @Override
    public boolean isInside(int x, int y) {//18
        return x >= xLeft && x <= xRight && y >= yTop && y <= yBottom;
    }

    public boolean isIntersects(Rectangle rectangle) {
        if(((rectangle.xLeft >= xLeft && rectangle.xLeft <= xRight)
                || (rectangle.xRight >= xLeft && rectangle.xRight <= xRight))
                && ((rectangle.yTop >= yTop && rectangle.yTop <= yBottom)
                || (rectangle.yBottom >= yTop && rectangle.yBottom <= yBottom)))
        {
            return true;
        }
        if(((xLeft >= rectangle.xLeft && xRight <= rectangle.xRight)
                || (xRight>= rectangle.xLeft && xRight <= rectangle.xRight))
                && ((yTop >= rectangle.yTop && yBottom <= rectangle.yTop)
                || (yTop >= rectangle.yTop && yBottom <= rectangle.yBottom)))
        {
            return true;
        }
        return false;
    }

    public boolean isInside(Rectangle rectangle) {
        return ((rectangle.xLeft >= xLeft && rectangle.xLeft <= xRight)
                || (rectangle.xRight >= xLeft && rectangle.xRight <= xRight))
                && ((rectangle.yTop >= yTop && rectangle.yTop <= yBottom)
                || (rectangle.yBottom >= yTop && rectangle.yBottom <= yBottom));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return xRight == rectangle.xRight &&
                xLeft == rectangle.xLeft &&
                yTop == rectangle.yTop &&
                yBottom == rectangle.yBottom;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xRight, xLeft, yTop, yBottom);
    }
}
