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
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Form form;
    private Offer offer;
    private WaiterFrame waiterFrame;
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

    public void toFile(File file){
        dishBase.toFile(file);
    }

    public void fromFile(){
        dishBase.fromFile();
        tableBase.fromFile();
        offer.update();
        waiterFrame.update();
    }
    
    public void alertMessage(String text){
        mainFrame.alertMessage(text);
    }
}
