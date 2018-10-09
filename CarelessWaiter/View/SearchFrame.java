package View;

import Controller.Controller;
import javafx.collections.FXCollections;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.List;

public class SearchFrame {
    private MainFrame mainFrame;
    private Controller controller;
    private TabPane tp;
    private JustClass justclass;
    private Form familyForm;
    private Form areaForm;
    private Form surnameForm;
    private Form perareaForm;
    private Button familyButton;
    private Button areaButton;
    private Button surnameButton;
    private Button perareaButton;

    public SearchFrame(MainFrame mainFrame, Controller controller) {
        this.mainFrame = mainFrame;
        this.controller = controller;
    }

   /* public void start () {
        justclass = new JustClass();
        Group root = new Group();
        setTabPane();
        root.getChildren().addAll(getTabPane());
        setForm();
        setActionOnButtons();
        Scene scene = new Scene(root, 1600, 600);
        Stage stage = new Stage();
        stage.setTitle("Поиск студентов");
        stage.setScene(scene);
        stage.showAndWait();
    }*/

   /* public void setActionOnButtons () {

        familyButton.setOnAction(e -> {
            List<Student> resultOfSearch = controller.searchStudents(justclass.getStudentFamily(), "Family");
            familyForm.setList(resultOfSearch);
            familyForm.getStudentTable().setItems(FXCollections.observableArrayList(resultOfSearch));
            alertMessage(resultOfSearch);
        });


        areaButton.setOnAction(e -> {
            List<Student> resultOfSearch = controller.searchStudents(justclass.getStudentArea(), "Area");
            areaForm.setList(resultOfSearch);
            areaForm.getStudentTable().setItems(FXCollections.observableArrayList(resultOfSearch));
            alertMessage(resultOfSearch);
        });

        surnameButton.setOnAction(e -> {
            List<Student> resultOfSearch = controller.searchStudents(justclass.getStudentSurname(), "Surname");
            surnameForm.setList(resultOfSearch);
            surnameForm.getStudentTable().setItems(FXCollections.observableArrayList(resultOfSearch));
            alertMessage(resultOfSearch);
        });

        perareaButton.setOnAction(e -> {
            List<Student> resultOfSearch = controller.searchStudents(justclass.getStudentPerarea(), "Perarea");
            perareaForm.setList(resultOfSearch);
            perareaForm.getStudentTable().setItems(FXCollections.observableArrayList(resultOfSearch));
            alertMessage(resultOfSearch);
        });
    }

    public void alertMessage(List<Student> list) {
            if (list.size() != 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(list.size() + " студентов найдено");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Нет таких студентов!!");
            alert.showAndWait();
        }
    }

    public void setTabPane() {
        tp = new TabPane();
        tp.setLayoutX(3);
        tp.setLayoutY(7);

        Tab tabFamily = new Tab("поиск по фамилии и кол-ву членов семьи");
        tabFamily.setContent(justclass.getRootFamily());
        familyButton = new Button("поиск");
        justclass.getRootFamily().getChildren().addAll(familyButton);


        Tab tabArea = new Tab("поиск по общей площади и кол-ву членов семьи");
        tabArea.setContent(justclass.getRootArea());
        areaButton = new Button("поиск");
        justclass.getRootArea().getChildren().addAll(areaButton);


        Tab tabSurname = new Tab("поиск по фамилии и общей площади");
        tabSurname.setContent(justclass.getRootSurname());
        surnameButton = new Button("поиск");
        justclass.getRootSurname().getChildren().addAll(surnameButton);

        Tab tabPrearea = new Tab( "поиск по площади на человека");
        tabPrearea.setContent(justclass.getRootPerarea());
        perareaButton = new Button("поиск");
        justclass.getRootPerarea().getChildren().addAll(perareaButton);

        tp.getTabs().addAll(tabFamily, tabArea, tabSurname, tabPrearea);

    }

    public void setForm () {
        familyForm = new Form();
        justclass.getRootFamily().getChildren().add(familyForm.getPaneBox());

        areaForm = new Form();
        justclass.getRootArea().getChildren().add(areaForm.getPaneBox());

        surnameForm = new Form();
        justclass.getRootSurname().getChildren().add(surnameForm.getPaneBox());

        perareaForm = new Form();
        justclass.getRootPerarea().getChildren().add(perareaForm.getPaneBox());
    }

    public TabPane getTabPane() {
        return tp;
    }*/
}
