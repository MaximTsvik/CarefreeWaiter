package View;

import Controller.Controller;
import Model.Dish;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AddFrame {
    private MainFrame mainFrame;
    private Controller controller;

    public void AddFrame(MainFrame mainFrame, Controller controller) {
        this.mainFrame = mainFrame;
        this.controller = controller;
    }

    public void startAdd(){
        Dish svayak1 = new Dish();
        svayak1.setName("Svayak");
        svayak1.setValue(0.05);
        svayak1.setCost(2.5);
        controller.addDish(svayak1);
        mainFrame.update();
    }
}