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
        Label label2 = new Label("Выберите кол-во столиков:");
        Button button1 = new Button("Вернуться назад");

        GridPane root = new GridPane();
        root.setPadding(new Insets(20, 20, 20, 100));
        root.setVgap(25);
        root.setHgap(25);
        root.setConstraints(label1,0,0);
        root.setConstraints(button1,1,0);
        root.setConstraints(label2,0,1);

        Button load = new Button("Загрузка");
        load.setOnAction( e -> {
            controller.getDishBase().clear();
            controller.getTableBase().clear();
            Stage stage = new Stage();
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Открытие");
            fileChooser.setInitialDirectory(new java.io.File("./"));
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML", "*.xml"));
            File file = fileChooser.showOpenDialog(stage);
            controller.setFile(file);
            controller.fromFile();
            update();
        });

        TextField countField = new TextField();
        Button clac = new Button("клац");
        root.getChildren().addAll(label1,button1, label2, countField, clac, load);
        root.setConstraints(load,3,0);
        root.setConstraints(countField,1,1);
        root.setConstraints(clac,2,1);
        clac.setOnAction(event -> {
            int rowIndex = 2, columnIndex = 0;
            List<Table> tables = controller.getTableBase();
            for(Table table : tables){
                Button tableView = new Button();
               if(table.isFree()){ tableView.setText("free");}
               else {tableView.setText("free");}
                   tableView.setPrefSize(180,60);
                   root.getChildren().addAll(tableView);
                   root.setConstraints(tableView, columnIndex,rowIndex);
                   rowIndex++;
                   tableView.setOnAction(e -> {
                       Offer offer = new Offer(this.controller);
                       offer.startoffer(table.getNumber());
                   });}
        });

        Scene scene = new Scene(root, 900, 600);
        Stage stage = new Stage();

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


