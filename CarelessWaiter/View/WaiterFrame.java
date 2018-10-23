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
import javafx.stage.Stage;

import javax.swing.plaf.metal.MetalBorders;
import java.util.List;

import static java.lang.Integer.parseInt;

public class WaiterFrame {

    private MainFrame mainFrame;
    private Controller controller;

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

        TextField countField = new TextField();
        Button clac = new Button("клац");
        root.getChildren().addAll(label1,button1, label2, countField, clac);
        root.setConstraints(countField,1,1);
        root.setConstraints(clac,2,1);
        clac.setOnAction(event -> {
            //List<Table> tables = Controller.getAllTables();
            //for(Table table: tables){
            //   if(table.isFree(){
            //       Button tableView = new Button("free")
            //       tableView.setOnAction( new Listener(){
            //          oAction(Event e){
            //            table.display
            //   else {
            //        new Button("offered")
            int rowIndex = 2, columnIndex = 0;
            for (int i=1; i <= Integer.parseInt(countField.getText());  i++){ int number = i;
                Button table = new Button(" " + i + " ");
                table.setPrefSize(180,60);
                root.getChildren().addAll(table);
                root.setConstraints(table, columnIndex,rowIndex);
                if (i % 4 == 0){ rowIndex++; columnIndex = 0; } else columnIndex++;
                table.setOnAction(e -> {
                    Offer offer = new Offer(this.controller);
                    offer.startoffer(number);
                });
            }
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
}


