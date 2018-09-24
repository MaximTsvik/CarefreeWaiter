package View;

import Controller.Controller;
import Model.Student;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AddFrame {
    private MainFrame mainFrame;
    private Controller controller;

    public AddFrame(MainFrame mainFrame, Controller controller) {
        this.mainFrame = mainFrame;
        this.controller = controller;


        GridPane pane=new GridPane();
        pane.setPadding(new Insets(15));
        pane.setVgap(15);
        pane.setHgap(15);

        pane.add(new Label("Добавление нового студента: "),0,0);
        pane.add(new Label("Фамилия:"),0,1);
        pane.add(new Label("Имя:"),0,2);
        pane.add(new Label("Отчество:"),0,3);
        pane.add(new Label("Адрес: "),0,4);
        pane.add(new Label("Город:"), 0,5);
        pane.add(new Label("Улица:"), 0,6);
        pane.add(new Label("Дом:"), 0,7);
        pane.add(new Label("Кол-во членов семьи:"), 0,8);
        pane.add(new Label("Общая площадь:"), 0,9);
        pane.add(new Label("Площадь на человека:"), 0,10);

        TextField surnameField = new TextField();
        surnameField.setPromptText("введите фамилию");
        pane.add(surnameField,1,1);

        TextField nameField = new TextField();
        nameField.setPromptText("введите имя");
        pane.add(nameField,1,2);

        TextField fatherNameField = new TextField();
        fatherNameField.setPromptText("введите отчество");
        pane.add(fatherNameField,1,3);

        TextField cityField = new TextField();
        cityField.setPromptText("введите город");
        pane.add(cityField,1,5);

        TextField streetField = new TextField();
        streetField.setPromptText("введите улицу");
        pane.add(streetField,1,6);

        TextField houseField = new TextField();
        houseField.setPromptText("введите дом");
        pane.add(houseField,1,7);

        TextField familyField = new TextField();
        familyField.setPromptText("введите число");
        pane.add(familyField,1,8);

        TextField areaField = new TextField();
        areaField.setPromptText("введите площадь");
        pane.add(areaField,1,9);

        TextField perareaField = new TextField();
        perareaField.setPromptText("введите площадь");
        pane.add(perareaField,1,10);

        Button addStudentButton=new Button("Добавить");
        addStudentButton.setOnAction(e -> {
            Student student = new Student();
            student.setFullName(surnameField.getText(),nameField.getText(),fatherNameField.getText());
            student.setFullAdress(cityField.getText(), streetField.getText(), houseField.getText());
            student.setFamily(Integer.valueOf(familyField.getText()));
            student.setArea(Double.valueOf(areaField.getText()));
            student.setPerarea(Double.valueOf(perareaField.getText()));

            controller.addStudent(student);

            surnameField.clear();
            nameField.clear();
            fatherNameField.clear();
            cityField.clear();
            streetField.clear();
            houseField.clear();
            familyField.clear();
            areaField.clear();
            perareaField.clear();

            mainFrame.update();
        });


        pane.add(addStudentButton,1,11);

        Scene scene = new Scene(pane);

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Добавление нового студента");

        stage.show();
    }
}