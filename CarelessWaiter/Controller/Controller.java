package Controller;

import Model.Dish;
import Model.DishBase;
import Model.Table;
import Model.TableBase;
import View.Form;
import View.MainFrame;
import View.Offer;
import View.WaiterFrame;

import java.io.File;
import java.util.List;

public class Controller {
    private MainFrame mainFrame;
    private DishBase dishBase;
    private TableBase tableBase;

    public Controller() {
        mainFrame = new MainFrame(this);
        dishBase = new DishBase(this);
        tableBase = new TableBase(this);
    }

    public List<Table> getTableBase(){
        return tableBase.getTableBase();
    }

    public void addDish(Dish dish) {
        dishBase.add(dish);
    }

    public void addTable(Table table) {
        tableBase.add(table);
    }

    public List<Dish> getDishBase() {
        return dishBase.getDishBase();
    }

    public void setFile(File file){
        dishBase.setFile(file);
        tableBase.setFile(file);
    }

    public void toFile1(File file, Table table){
        dishBase.toFile1(file, table);
    }

    public void toFile2(File file, Table table){
        dishBase.toFile2(file, table);
    }

    public void fromFile(){
        dishBase.fromFile();
        tableBase.fromFile();
    }
}
