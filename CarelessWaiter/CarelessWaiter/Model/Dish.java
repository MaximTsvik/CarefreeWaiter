package Model;

public class Dish {

    private String name;
    private String category;
    private double cost;
    private double value;

    public Dish() {
        name = "";
        category = "";
        cost = 0.0;
        value = 0.0;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
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

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public void clean() {
        name = "";
        category = "";
        cost = 0.0;
        value = 0.0;
    }
}
