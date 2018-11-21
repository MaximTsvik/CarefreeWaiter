package View;

import Model.Dish;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import java.util.List;

public class Form {

    private TableView<Dish> dishTable;
    private List<Dish> dishList;

    public Form() {

        dishTable = new TableView<>();

        TableColumn<Dish,String> dishName = new TableColumn<>("Имя");
        dishName.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getName()));
        dishName.setMinWidth(136);

        TableColumn<Dish,Double> dishValue = new TableColumn<>("Объем");
        dishValue.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getValue()));
        dishValue.setMinWidth(30);

        TableColumn<Dish,Double> dishCost = new TableColumn<>("Цена");
        dishCost.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getCost()));
        dishCost.setMinWidth(30);

        dishTable.setPrefSize(300,300);

        dishTable.getColumns().addAll(dishName, dishValue, dishCost);
    }

    public TableView<Dish> getDishTable() {
        return dishTable;
    }

    public void clear() {
        ObservableList<Dish> dishList = FXCollections.observableArrayList();
        dishTable.setItems(dishList);
    }

    public void setList(List<Dish> dishList)
    {
        this.dishList = dishList;
    }
}
