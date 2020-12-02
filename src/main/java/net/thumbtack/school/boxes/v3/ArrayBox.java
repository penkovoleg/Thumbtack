package net.thumbtack.school.boxes.v3;

import net.thumbtack.school.figures.v3.Figure;

public class ArrayBox<T extends Figure> {

    private T[] obj;

    public ArrayBox(T[] obj){
        this.obj = obj;
    }

    public T[] getContent(T[] obj){
        return obj;
    }

    public void setContent(T[] obj){
        this.obj = obj;
    }

    public T getElement(int i){
        return obj[i];
    }

    public void setElement(int i){
        this.obj[i] = obj[i];
    }

    public boolean isSameSize(ArrayBox<? extends Figure> newObj){
        return this.obj.length == newObj.obj.length;
    }
}
