package View;

import Controller.Controller;
import Model.Table;
import javafx.collections.FXCollections;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.plaf.metal.MetalBorders;
import java.io.File;
import java.util.List;

import static java.lang.Integer.parseInt;

public class WaiterFrame {

    private MainFrame mainFrame;
    private Controller controller;
    private Form form;

    public WaiterFrame(MainFrame mainFrame, Controller controller) {
        this.mainFrame = mainFrame;
        this.controller = controller;
    }

    public void start () {

        Label label1 = new Label("Вы вошли как: официант");
        Button button1 = new Button("Вернуться назад");

        GridPane root = new GridPane();
        root.setPadding(new Insets(30, 50, 40, 40));
        root.setVgap(25);
        root.setHgap(25);
        root.setConstraints(label1,0,0);
        root.setConstraints(button1,1,0);

        Scene scene = new Scene(root, 950, 750);
        Stage stage = new Stage();

        Button load = new Button("Загрузка меню и столов");
        load.setOnAction( e -> {
            controller.getDishBase().clear();
            controller.getTableBase().clear();
           // Stage stage = new Stage();
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Открытие");
            fileChooser.setInitialDirectory(new java.io.File("./"));
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML", "*.xml"));
            File file = fileChooser.showOpenDialog(stage);
            controller.setFile(file);
            controller.fromFile();
            update();
        });

        Button clac = new Button("Показать столы");
        root.getChildren().addAll(label1,button1, clac, load);
        root.setConstraints(load,3,0);
        root.setConstraints(clac,2,0);
        clac.setOnAction(event -> {
            List<Table> tables = controller.getTableBase();
            int rowIndex = 2, columnIndex = 0;
            for(Table table : tables) {
                Button tableView = new Button();
                if (table.isFree()) {
                    tableView.setText("стол " + table.getNumber() + ": свободен");
                } else {
                    tableView.setText("стол " + table.getNumber() + ": занят");
                }
                root.getChildren().addAll(tableView);
                tableView.setPrefSize(180, 60);
                root.setConstraints(tableView, columnIndex, rowIndex);
                if ((table.getNumber()) % 4 == 0){ rowIndex++; columnIndex = 0; } else columnIndex++;
                   tableView.setOnAction(e -> {
                       Offer offer = new Offer(this.controller);
                       offer.startoffer(table);
                   });}
        });

        button1.setOnAction(e -> {
            stage.close();
            //MainFrame mainFrame = new MainFrame(controller);
        });

        stage.setTitle("Официант");
        stage.setScene(scene);
        stage.showAndWait();
    }

    public void update() {
        form.clear();
        form.setList(controller.getDishBase());
        form.getDishTable().setItems(FXCollections.observableArrayList(controller.getDishBase()));
    }
}


