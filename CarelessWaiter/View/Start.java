package View;

import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Start {

    private Label StartText = new Label("Ну и кто ты?");
    private Button admin = new Button("Администратор");
    private Button waiter = new Button("Официант");

    public void startStart(GridPane root){

        root.getChildren().addAll(StartText, admin, waiter);

        root.setConstraints(StartText, 2, 0);
        root.setHalignment(StartText, HPos.CENTER);
        root.setConstraints(admin, 3, 1);
        root.setHalignment(admin, HPos.LEFT);
        root.setConstraints(waiter, 1, 1);
        root.setHalignment(waiter, HPos.RIGHT);

    }
}
