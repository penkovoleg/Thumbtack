package net.thumbtack.school.misc.v3;

import net.thumbtack.school.colors.v3.Color;
import net.thumbtack.school.colors.v3.ColorException;
import net.thumbtack.school.iface.v3.Colored;
import net.thumbtack.school.iface.v3.Resizable;

import java.util.Objects;

public class Rocket implements Resizable, Colored{

    private Color color;
    private int length, width;

    public Rocket(int length, int width, Color color) throws ColorException{
        this.length = length;
        this.width = width;
        Color.colorEqualsNull(color);
        this.color = color;
    }

    public Rocket(int length, int width, String color) throws ColorException{
       this(length, width, Color.colorFromString(color));
    }

    public Rocket() throws ColorException{
        this(75, 15, Color.RED);
    }

    public Rocket(int length, int width) throws ColorException{
        this(length, width, Color.RED);
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
