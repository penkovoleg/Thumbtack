package net.thumbtack.school.figures.v1;

public class CircleFactory extends Circle{

    private static int count = 0;

    public static Circle createCircle(Point center, int radius) {
        count = count + 1;
        return new Circle(center.getX(), center.getY(), radius);
    }

    public static int getCircleCount() {
        return count;
    }

    public static void reset(){
        count = 0;
    }
}
