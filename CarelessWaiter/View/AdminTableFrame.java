package View;

import Controller.Controller;
import Model.Dish;
import Model.Table;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class AdminTableFrame {

    private Form form;
    private Controller controller;
    private Dish dish;
    private Table table;

    public AdminTableFrame(Controller controller) {
        this.controller = controller;
    }

    public void startAdminTableFrame (Table table) {
        Label label2 = new Label("Выбран столик: " + table.getNumber());
        Label label1 = new Label("Вы вошли как: администратор");
        Button button1 = new Button("Вернуться к выбору столика");
        Button button2 = new Button("Закрыть стол");
        form = new Form();
        Group Table = new Group();
        Table.getChildren().addAll(form.getDishTable());

        GridPane root1 = new GridPane();
        root1.getChildren().addAll(Table, label1,button1, label2, button2);
        root1.setPadding(new Insets(20, 20, 20, 100));
        root1.setVgap(25);
        root1.setHgap(25);
        root1.setConstraints(Table,0,2);
        root1.setConstraints(label1,0,0);
        root1.setConstraints(button1,1,0);
        root1.setConstraints(button2,0,3);
        root1.setConstraints(label2,0,1);

        Scene scene = new Scene(root1, 700, 650);
        Stage stage = new Stage();
        button1.setOnAction(e -> {
            stage.close();
        });
        button2.setOnAction(e -> {
            table.setFree(true);
            table.dishBase = new ArrayList<>();
            stage.close();
        });

        form.setList(table.dishBase);
        form.getDishTable().setItems(FXCollections.observableArrayList(table.dishBase));

        stage.setTitle(table.getNumber() + " стол");
        stage.setScene(scene);
        stage.showAndWait();

    }
}


