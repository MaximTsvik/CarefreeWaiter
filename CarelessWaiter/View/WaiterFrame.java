package View;

import Controller.Controller;
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

public class WaiterFrame {

    private MainFrame mainFrame;
    private Controller controller;

    public WaiterFrame(MainFrame mainFrame, Controller controller) {
        this.mainFrame = mainFrame;
        this.controller = controller;
    }

    public void start () {

        Menu menu = new Menu();
        MenuItem menuitem1 = new MenuItem("Вы вошли как: официант");
        MenuItem menuitem2 = new MenuItem("Выход");
        MenuItem menuitem3 = new MenuItem("22.09.2018");
        menu.getItems().addAll(menuitem1,menuitem2,menuitem3);


        Label label2 = new Label("Выберите столик:");
        Label label1 = new Label("Вы вошли как: официант");
        Button button1 = new Button("Вернуться назад");
        Button button2 = new Button("Дада, все верно");
        Button table1 = new Button("1");
        Button table2 = new Button("2");
        Button table3 = new Button("3");
        Button table4 = new Button("4");
        Button table5 = new Button("5");
        Button table6 = new Button("6");
        Button table7 = new Button("7");
        Button table8 = new Button("8");
        Button table9 = new Button("9");
        Button table10 = new Button("10");
        Button table11 = new Button("11");
        Button table12 = new Button("12");
        table1.setPrefSize(120,60);
        table2.setPrefSize(120,60);
        table3.setPrefSize(60,60);
        table4.setPrefSize(120,60);
        table5.setPrefSize(120,60);
        table6.setPrefSize(60,60);
        table7.setPrefSize(180,60);
        table8.setPrefSize(60,60);
        table9.setPrefSize(120,60);
        table10.setPrefSize(120,60);
        table11.setPrefSize(60,60);
        table12.setPrefSize(120,60);


        GridPane root = new GridPane();

        root.getChildren().addAll(label1,button1,button2, label2, table1, table2, table3, table4, table5, table6, table7, table8, table9, table10, table11, table12);
        root.setPadding(new Insets(20, 20, 20, 100));
        root.setVgap(25);
        root.setHgap(25);
        root.setConstraints(label1,0,0);
        root.setConstraints(button1,1,0);
        root.setConstraints(button2,2,0);
        root.setConstraints(label2,0,1);

        root.setConstraints(table1,0,2);
        root.setConstraints(table2,1,2);
        root.setConstraints(table3,2,2);
        root.setHalignment(table3, HPos.CENTER);
        root.setConstraints(table4,3,2);
        root.setConstraints(table5,0,3);
        root.setConstraints(table6,1,3);
        root.setConstraints(table7,2,3);
        root.setConstraints(table8,3,3);
        root.setHalignment(table8, HPos.RIGHT);
        root.setConstraints(table9,0,4);
        root.setConstraints(table10,1,4);
        root.setConstraints(table11,2,4);
        root.setHalignment(table11, HPos.CENTER);
        root.setConstraints(table12,3,4);

        Scene scene = new Scene(root, 900, 600);
        Stage stage = new Stage();

        button1.setOnAction(e -> {
            stage.close();
            MainFrame mainFrame = new MainFrame(controller);
        });

        table1.setOnAction(e -> {
            Offer offer = new Offer(this.mainFrame, this.controller);
            offer.startoffer(1);
        });
        table2.setOnAction(e -> {
            Offer offer = new Offer(this.mainFrame, this.controller);
            offer.startoffer(2);
        });
        table3.setOnAction(e -> {
            Offer offer = new Offer(this.mainFrame, this.controller);
            offer.startoffer(3);
        });
        table4.setOnAction(e -> {
            Offer offer = new Offer(this.mainFrame, this.controller);
            offer.startoffer(4);
        });
        table5.setOnAction(e -> {
            Offer offer = new Offer(this.mainFrame, this.controller);
            offer.startoffer(5);
        });
        table6.setOnAction(e -> {
            Offer offer = new Offer(this.mainFrame, this.controller);
            offer.startoffer(6);
        });
        table7.setOnAction(e -> {
            Offer offer = new Offer(this.mainFrame, this.controller);
            offer.startoffer(7);
        });
        table8.setOnAction(e -> {
            Offer offer = new Offer(this.mainFrame, this.controller);
            offer.startoffer(8);
        });
        table9.setOnAction(e -> {
            Offer offer = new Offer(this.mainFrame, this.controller);
            offer.startoffer(9);
        });
        table10.setOnAction(e -> {
            Offer offer = new Offer(this.mainFrame, this.controller);
            offer.startoffer(10);
        });
        table11.setOnAction(e -> {
            Offer offer = new Offer(this.mainFrame, this.controller);
            offer.startoffer(11);
        });
        table12.setOnAction(e -> {

            Offer offer = new Offer(this.mainFrame, this.controller);
            offer.startoffer(12);
        });
        stage.setTitle("Официант");
        stage.setScene(scene);
        stage.showAndWait();
    }
}


