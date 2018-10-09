package Model;

public class Dish {

    private String name;
    private double cost;
    private double value;

    public Dish() {
        name = "";
        cost = 0.0;
        value = 0.0;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public double getValue() {
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public void clean() {
        name = "";
        cost = 0.0;
        value = 0.0;
    }
}
