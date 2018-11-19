package View;

import Controller.Controller;
import Model.Table;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.List;

public class AdminFrame {

    private MainFrame mainFrame;
    private Controller controller;
    private Form form;

    public AdminFrame(MainFrame mainFrame, Controller controller) {
        this.mainFrame = mainFrame;
        this.controller = controller;
    }

    public void start () {
        Label label1 = new Label("Вы вошли как: администратор");
        Label label2 = new Label("Активные столы:");
        GridPane root = new GridPane();
        Button button1 = new Button("Вернуться назад");
        root.getChildren().addAll(label1,button1, label2);
        root.setPadding(new Insets(30, 50, 40, 40));
        root.setVgap(40);
        root.setHgap(40);
        root.setConstraints(label1,0,0);
        root.setConstraints(button1,1,0);
        root.setConstraints(label2,0,1);

        Button load = new Button("Загрузка меню и столов");
        root.getChildren().addAll(load);
        root.setConstraints(load,2,0);
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

        Scene scene = new Scene(root, 900, 600);
        Stage stage = new Stage();

        List<Table> tables = controller.getTableBase();
        int rowIndex = 2, columnIndex = 0;
        for(Table table : tables) {
            if (!table.isFree()) { Button tableView = new Button();
                tableView.setText("стол " + table.getNumber() + ": занят");
                root.getChildren().addAll(tableView);
                tableView.setPrefSize(180, 60);
                root.setConstraints(tableView, columnIndex, rowIndex);
                if ((table.getNumber()) % 4 == 0){ rowIndex++; columnIndex = 0; } else columnIndex++;
                tableView.setOnAction(e -> {
                    AdminTableFrame adminTableFrame = new AdminTableFrame(this.controller);
                    adminTableFrame.startAdminTableFrame(table);
                    stage.close();
                });
            }
        }

        button1.setOnAction(e -> {
            stage.close();
        });

        stage.setTitle("Администратор");
        stage.setScene(scene);
        stage.showAndWait();
    }

    public void update() {
        form.clear();
        form.setList(controller.getDishBase());
        form.getDishTable().setItems(FXCollections.observableArrayList(controller.getDishBase()));
    }
}