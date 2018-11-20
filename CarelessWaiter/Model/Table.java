package Model;

import java.util.ArrayList;
import java.util.List;

public class Table {

    private int number;
    private boolean free;
    public List<Dish> dishBase;
    public List<Dish> resultOfOffer;

    public Table() {
        number = 0;
        free = true;
        dishBase = new ArrayList();
        resultOfOffer = new ArrayList<>();
    }

    public boolean isFree(){
        return free;
    }

    public int getNumber(){
        return number;
    }

    public void setNumber(int number){
        this.number = number;
    }

    public void setFree(boolean free){
        this.free = free;
    }
}
