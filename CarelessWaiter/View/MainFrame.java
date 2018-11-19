package View;

import Controller.Controller;
import javafx.collections.FXCollections;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainFrame {
    private Controller controller;
    private Form form;

    public MainFrame(Controller controller) {

        this.controller = controller;

        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(5);
        root.setVgap(5);
        root.setPadding(new Insets(50, 50, 40, 40));

        Label StartText = new Label("Ну и кто ты?");
        Button admin = new Button("Администратор");
        Button waiter = new Button("Официант");
        root.getChildren().addAll(StartText, admin, waiter);

        admin.setOnAction((event) -> {
            AdminFrame adminFrame = new AdminFrame(this, this.controller);
            adminFrame.start();
        });

        waiter.setOnAction((event) -> {
            WaiterFrame waiterFrame = new WaiterFrame(this, this.controller);
            waiterFrame.start();
        });

        root.setConstraints(StartText, 2, 0);
        root.setHalignment(StartText, HPos.CENTER);
        root.setConstraints(admin, 3, 1);
        root.setHalignment(admin, HPos.LEFT);
        root.setConstraints(waiter, 1, 1);
        root.setHalignment(waiter, HPos.RIGHT);

        GridPane StartPane = new GridPane();
        StartPane.getChildren().addAll(StartText, admin, waiter);
        StartPane.setHgap(5);
        StartPane.setVgap(5);
        StartPane.setPadding(new Insets(30, 30, 30, 30));

        Scene scene = new Scene(new Group(), 400, 150);
        ((Group)scene.getRoot()).getChildren().addAll(StartPane);
        Stage primaryStage = new Stage();

        primaryStage.setScene(scene);
        primaryStage.setTitle("CarelessWaiter");
        primaryStage.show();
    }

    public void update() {
        form.clear();
        form.setList(controller.getDishBase());
        form.getDishTable().setItems(FXCollections.observableArrayList(controller.getDishBase()));
    }

    public void alertMessage(String text) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(text);
        alert.showAndWait();
    }
}