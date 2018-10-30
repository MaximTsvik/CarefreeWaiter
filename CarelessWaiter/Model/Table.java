package Model;

public class Table {

    private int number;
    private boolean free;

    public Table() {
        number = 0;
        free = true;
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
