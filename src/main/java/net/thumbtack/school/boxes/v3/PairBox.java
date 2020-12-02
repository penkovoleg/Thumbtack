package net.thumbtack.school.boxes.v3;

import net.thumbtack.school.figures.v3.Figure;
import net.thumbtack.school.iface.v3.HasArea;

public class PairBox<First extends Figure, Second extends Figure> implements HasArea {

    private First first;
    private Second second;

    public PairBox(First first, Second second){
        this.first = first;
        this.second = second;
    }

    public First getContentFirst(){
        return this.first;
    }

    public Second getContentSecond(){
        return this.second;
    }

    public void setContentFirst(First first){
        this.first = first;
    }

    public void setContentSecond(Second second){
        this.second = second;
    }

    @Override
    public double getArea() {
        return first.getArea() + second.getArea();
    }

    public boolean isAreaEqual(PairBox<? extends Figure, ? extends Figure> pairBox){
        return pairBox.getArea() == this.getArea();
    }

    public static boolean isAreaEqual(PairBox<? extends Figure, ? extends Figure> firstPairBox,
                                      PairBox<? extends Figure, ? extends Figure> secondPairBox){
        return firstPairBox.getArea() == secondPairBox.getArea();
    }
}
