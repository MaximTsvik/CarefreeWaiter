package View;

import Controller.Controller;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.List;

public class AdminFrame {

    private MainFrame startovaya;
    private Start start;
    private Controller controller;

    public AdminFrame(Start start, Controller controller) {
        this.start = start;
        this.controller = controller;
    }

    public void start () {
        Label label1 = new Label("Вы вошли как: администратор");
        Label label2 = new Label("Активные столы: ");
        GridPane root = new GridPane();
        Button button1 = new Button("Вернуться назад");
        Button button2 = new Button("Дада, все верно");

        root.getChildren().addAll(label1,button1,button2, label2);
        root.setPadding(new Insets(50, 50, 40, 40));
        root.setVgap(40);
        root.setHgap(40);
        root.setConstraints(label1,0,0);
        root.setConstraints(button1,1,0);
        root.setConstraints(button2,2,0);
        root.setConstraints(label2,1,1);
        Scene scene = new Scene(root, 900, 600);
        Stage stage = new Stage();
        button1.setOnAction(e -> {
            stage.close();
            MainFrame mainFrame = new MainFrame(controller);
        });
        stage.setTitle("Администратор");
        stage.setScene(scene);
        stage.showAndWait();
    }

}
