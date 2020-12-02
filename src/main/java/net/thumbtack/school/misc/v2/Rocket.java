package net.thumbtack.school.misc.v2;

import net.thumbtack.school.iface.v2.Colored;
import net.thumbtack.school.iface.v2.Resizable;

import java.util.Objects;

public class Rocket implements Resizable, Colored{

    private int color;
    private int length, width;

    public Rocket(int length, int width, int color){
        this.length = length;
        this.width = width;
        this.color = color;
    }

    public Rocket(){
        this(75, 15, 1);
    }

    public Rocket(int length, int width){
        this(length, width, 1);
    }

    public int getLength(){
        return length;
    }

    public void setLength(int length){
        this.length = length;
    }

    public int getWidth(){
        return width;
    }

    public void setWidth(int width){
        this.width = width;
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
    public void resize(double ratio) {
        length = length * (int)ratio;
        width = width * (int)ratio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rocket rocket = (Rocket) o;
        return color == rocket.color &&
                length == rocket.length &&
                width == rocket.width;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, length, width);
    }

}
