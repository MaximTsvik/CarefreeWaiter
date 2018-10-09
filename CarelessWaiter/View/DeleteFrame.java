package View;

import Controller.Controller;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;

import java.util.List;

public class DeleteFrame {

    private MainFrame mainFrame;
    private Controller controller;
    private TabPane tp;
    private JustClass justclass;
    private Button familyButton;
    private Button areaButton;
    private Button surnameButton;
    private Button perareaButton;


    public DeleteFrame(MainFrame mainFrame, Controller controller) {
        this.mainFrame = mainFrame;
        this.controller = controller;
    }

    public void start () {
        justclass = new JustClass();
        Group root = new Group();
        setTabPane();
        root.getChildren().addAll(tp);
        //setActionOnButtons();
        Scene scene = new Scene(root, 1560, 175);
        Stage stage = new Stage();
        stage.setTitle("Удаление");
        stage.setScene(scene);
        stage.showAndWait();
    }


    public void setTabPane() {
        tp = new TabPane();
        tp.setLayoutX(3);
        tp.setLayoutY(7);

       /* Tab tabFamily = new Tab("удаление по фамилии и кол-ву членов семьи");
        tabFamily.setContent(justclass.getRootFamily());
        familyButton = new Button("удаление");
        justclass.getRootFamily().getChildren().addAll(familyButton);


        Tab tabArea = new Tab("удаление по общей площади и кол-ву членов семьи");
        tabArea.setContent(justclass.getRootArea());
        areaButton = new Button("удаление");
        justclass.getRootArea().getChildren().addAll(areaButton);


        Tab tabSurname = new Tab("удаление по фамилии и общей площади");
        tabSurname.setContent(justclass.getRootSurname());
        surnameButton = new Button("удаление");
        justclass.getRootSurname().getChildren().addAll(surnameButton);

        Tab tabPrearea = new Tab( "удаление по площади на человека");
        tabPrearea.setContent(justclass.getRootPerarea());
        perareaButton = new Button("удаление");
        justclass.getRootPerarea().getChildren().addAll(perareaButton);

        tp.getTabs().addAll(tabFamily, tabArea, tabSurname, tabPrearea);

    }

  /*  public void setActionOnButtons() {
        familyButton.setOnAction(e -> {
            List<Student> resultOfSearch = controller.searchStudents(justclass.getStudentFamily(), "Family");
            controller.removeStudent(resultOfSearch);
            mainFrame.update();
            alertMessage(resultOfSearch);
        });

        areaButton.setOnAction(e -> {
            List<Student> resultOfSearch = controller.searchStudents(justclass.getStudentArea(), "Area");
            controller.removeStudent(resultOfSearch);
            mainFrame.update();
            alertMessage(resultOfSearch);
        });

        surnameButton.setOnAction(e -> {
            List<Student> resultOfSearch = controller.searchStudents(justclass.getStudentSurname(), "Surname");
            controller.removeStudent(resultOfSearch);
            mainFrame.update();
            alertMessage(resultOfSearch);
        });

        perareaButton.setOnAction(e -> {
            List<Student> resultOfSearch = controller.searchStudents(justclass.getStudentPerarea(), "Perarea");
            controller.removeStudent(resultOfSearch);
            mainFrame.update();
            alertMessage(resultOfSearch);
        });
    }

    public void alertMessage(List<Student> list) {
        if (list.size() != 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(list.size() + " студентов удалено");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Нет таких студентов!!");
            alert.showAndWait();
        }
    }*/
}}


