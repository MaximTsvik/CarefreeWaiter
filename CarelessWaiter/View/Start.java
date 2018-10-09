package View;

import Controller.Controller;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Start {

    private MainFrame mainFrame;
    private Controller controller;
    private Label StartText = new Label("Ну и кто ты?");
    private Button admin = new Button("Администратор");
    private Button waiter = new Button("Официант");

    public void startStart(GridPane root){

        this.controller = controller;

        root.getChildren().addAll(StartText, admin, waiter);

        admin.setOnAction((event) -> {
                    AdminFrame adminFrame = new AdminFrame(this, this.controller);
                    adminFrame.start();
        });

        waiter.setOnAction((event) -> {
            WaiterFrame waiterFrame = new WaiterFrame(this.mainFrame, this.controller);
            waiterFrame.start();
        });

        root.setConstraints(StartText, 2, 0);
        root.setHalignment(StartText, HPos.CENTER);
        root.setConstraints(admin, 3, 1);
        root.setHalignment(admin, HPos.LEFT);
        root.setConstraints(waiter, 1, 1);
        root.setHalignment(waiter, HPos.RIGHT);

    }
}
