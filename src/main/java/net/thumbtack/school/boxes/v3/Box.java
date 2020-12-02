package net.thumbtack.school.boxes.v3;

import net.thumbtack.school.figures.v3.Figure;
import net.thumbtack.school.iface.v3.HasArea;

public class Box<T extends Figure> implements HasArea {

    private T obj;

    public Box(T obj){
        this.obj = obj;
    }

    public T getContent(){
        return obj;
    }

    public void setContent(T obj){
        this.obj = obj;
    }

    @Override
    public double getArea() {
        return obj.getArea();
    }

    public boolean isAreaEqual(Box<? extends Figure> new_obj){
        return this.obj.getArea() == new_obj.getArea();
    }

    public static boolean isAreaEqual(Box<? extends Figure> firstObj, Box<? extends Figure> secondObj){
        return firstObj.getArea() == secondObj.getArea();
    }
}
