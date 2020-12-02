package net.thumbtack.school.figures.v3;

import java.util.Objects;

public class Square extends Figure {

    private int xRight, xLeft, yTop, yBottom;

    public Square(Point topLeft, int size) {//1
        this.xLeft = topLeft.getX();
        this.yTop = topLeft.getY();
        this.xRight = topLeft.getX() + size;
        this.yBottom = topLeft.getY() + size;
    }

    public Square(int xLeft, int yTop, int size) {//2
        this.xLeft = xLeft;
        this.yTop = yTop;
        this.xRight = xLeft + size;
        this.yBottom = yTop + size;
    }

    public Square(int size) {//3
        this(0, -size, size);
    }

    public Square() {//4
        this(0,-1,1);
    }

    public Point getTopLeft() {//5
        return new Point(xLeft, yTop);
    }

    public Point getBottomRight() {//6
        return new Point(xRight, yBottom);
    }

    public void setTopLeft(Point topLeft) {//7
        this.xRight = xRight - xLeft + topLeft.getX();
        this.yBottom = yBottom - yTop + topLeft.getY();
        this.xLeft = topLeft.getX();
        this.yTop = topLeft.getY();
    }

    public short getLength() {//8
        return (short) (xRight - xLeft);
    }

    @Override
    public void moveTo(int x, int y){//9
        this.xRight = xRight - xLeft + x;
        this.yBottom = yBottom - yTop + y;
        this.xLeft = x;
        this.yTop = y;
    }

    @Override
    public void moveRel(int dx, int dy){//11
        xLeft = xLeft + dx;
        yTop = yTop + dy;
        xRight = xRight + dx;
        yBottom = yBottom + dy;
    }

    @Override
    public void resize(double ratio){//12
        this.xRight = xLeft + (int)((xRight - xLeft) * ratio);
        this.yBottom = yTop + (int)((yBottom - yTop) * ratio);
    }

    @Override
    public double getArea(){//13
        return getLength() * getLength();
    }

    @Override
    public double getPerimeter(){//14
        return 4 * getLength();
    }

    @Override
    public boolean isInside(int x, int y){//15
        return x >= xLeft && x <= xRight && y >= yTop && y <= yBottom;
    }

    public boolean isIntersects(Square square){//17
        if(((square.xLeft >= xLeft && square.xLeft <= xRight)
                || (square.xRight >= xLeft && square.xRight <= xRight))
                && ((square.yTop >= yTop && square.yTop <= yBottom)
                || (square.yBottom >= yTop && square.yBottom <= yBottom)))
        {
            return true;
        }
        if(((xLeft >= square.xLeft && xRight <= square.xRight)
                || (xRight>= square.xLeft && xRight <= square.xRight))
                && ((yTop >= square.yTop && yBottom <= square.yTop)
                || (yTop >= square.yTop && yBottom <= square.yBottom)))
        {
            return true;
        }
        return false;
    }

    public boolean isInside(Square square){//18
        return ((square.xLeft >= xLeft && square.xLeft <= xRight)
                || (square.xRight >= xLeft && square.xRight <= xRight))
                && ((square.yTop >= yTop && square.yTop <= yBottom)
                || (square.yBottom >= yTop && square.yBottom <= yBottom));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return xRight == square.xRight &&
                xLeft == square.xLeft &&
                yTop == square.yTop &&
                yBottom == square.yBottom;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xRight, xLeft, yTop, yBottom);
    }
}
