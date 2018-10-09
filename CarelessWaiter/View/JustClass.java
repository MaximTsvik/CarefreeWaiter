package View;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class JustClass {
    private TextField surnameFieldFamily1;
    private TextField surnameFieldFamily2;
    private TextField areaFieldFamily2;
    private TextField areaMinField;
    private TextField areaMaxField;
    private TextField areaMinField1;
    private TextField areaMaxField1;
    private TextField surnameFieldArea1;
    private TextField perareaField;
   // private Student searchStudent = new Student();
    private VBox rootFamily;
    private VBox rootArea;
    private VBox rootSurname;
    private VBox rootPerarea;

    public JustClass(){
        rootFamily = new VBox();
        GridPane familyBox = new GridPane();
        familyBox.setPadding(new Insets(15));
        familyBox.setVgap(15);
        familyBox.setHgap(15);

        Label surnameLabelFamily1 = new Label("Фамилия:");
        surnameFieldFamily1 = new TextField();
        surnameFieldFamily1.setPromptText("введите фамилию");
        familyBox.add(surnameLabelFamily1, 0, 0);
        familyBox.add(surnameFieldFamily1, 1, 0);

        Label surnameLabelFamily2 = new Label("Кол-во членов семьи:");
        surnameFieldFamily2 = new TextField();
        surnameFieldFamily2.setPromptText("введите число");
        familyBox.add(surnameLabelFamily2, 0, 1);
        familyBox.add(surnameFieldFamily2, 1, 1);

        rootFamily.getChildren().addAll(familyBox);





        rootArea = new VBox();
        GridPane areaBox = new GridPane();
        areaBox.setPadding(new Insets(15));
        areaBox.setVgap(15);
        areaBox.setHgap(15);

        Label areaLabelFamily2 = new Label("Кол-во членов семьи:");
        areaFieldFamily2 = new TextField();
        areaFieldFamily2.setPromptText("введите число");
        areaBox.add(areaLabelFamily2, 0, 0);
        areaBox.add(areaFieldFamily2, 1, 0);

        Label areaLabelFamily1 = new Label("Общая площадь:");
        areaMinField = new TextField();
        areaMinField.setPromptText("введите минимум");
        areaBox.add(areaMinField, 1, 1);
        areaMaxField = new TextField();
        areaMaxField.setPromptText("введите максимум");
        areaBox.add(areaMaxField, 2, 1);
        areaBox.add(areaLabelFamily1, 0, 1);

        rootArea.getChildren().addAll(areaBox);





        rootSurname = new VBox();
        GridPane surnameBox = new GridPane();
        surnameBox.setPadding(new Insets(15));
        surnameBox.setVgap(15);
        surnameBox.setHgap(15);

        Label surnameLabelArea1 = new Label("Фамилия: ");
        surnameFieldArea1 = new TextField();
        surnameFieldArea1.setPromptText("введите фамилию");
        surnameBox.add(surnameLabelArea1, 0, 0);
        surnameBox.add(surnameFieldArea1, 1, 0);


        Label surnameLabelArea2 = new Label("Общая площадь:");
        surnameBox.add(surnameLabelArea2, 0, 1);
        areaMinField1 = new TextField();
        areaMinField1.setPromptText("введите минимум");
        surnameBox.add(areaMinField1, 1, 1);
        areaMaxField1 = new TextField();
        areaMaxField1.setPromptText("введите максимум");
        surnameBox.add(areaMaxField1, 2, 1);

        rootSurname.getChildren().addAll(surnameBox);






        rootPerarea = new VBox();
        GridPane preareaBox = new GridPane();
        preareaBox.setPadding(new Insets(15));
        preareaBox.setVgap(15);
        preareaBox.setHgap(15);

        Label preareaLabel = new Label("Минимальная площадь на человека:");
        perareaField = new TextField();
        perareaField.setPromptText("введите площадь");
        preareaBox.add(preareaLabel, 0, 0);
        preareaBox.add(perareaField, 1, 0);

        rootPerarea.getChildren().addAll(preareaBox);

    }


    /*public Student getStudentFamily () {
        searchStudent.clean();
        searchStudent.setSurname(surnameFieldFamily1.getText());
        searchStudent.setFamily(Integer.valueOf(surnameFieldFamily2.getText()));
        return searchStudent;
    }

    public Student getStudentArea () {
        searchStudent.clean();
        searchStudent.setFamily(Integer.valueOf(areaFieldFamily2.getText()));
        searchStudent.setMinArea(Double.valueOf(areaMinField.getText()));
        searchStudent.setMaxArea(Double.valueOf(areaMaxField.getText()));
        return searchStudent;
    }

    public Student getStudentSurname () {
        searchStudent.clean();
        searchStudent.setMinArea(Double.valueOf(areaMinField1.getText()));
        searchStudent.setMaxArea(Double.valueOf(areaMaxField1.getText()));
        searchStudent.setSurname(surnameFieldArea1.getText());
        return searchStudent;
    }

    public Student getStudentPerarea () {
        searchStudent.clean();
        searchStudent.setPerarea(Double.valueOf(perareaField.getText()));
        return searchStudent;
    }

    public VBox getRootFamily() {
        return rootFamily;
    }

    public VBox getRootSurname() {
        return rootSurname;
    }

    public VBox getRootArea() {
        return rootArea;
    }

    public VBox getRootPerarea() {
        return rootPerarea;
    }

    public TextField getSurnameFieldFamily1() {
        return surnameFieldFamily1;
    }

    public TextField getSurnameFieldFamily2() {
        return surnameFieldFamily2;
    }

    public TextField getAreaFieldFamily2() {
        return areaFieldFamily2;
    }

    public TextField getAreaMinField() {
        return areaMinField;
    }

    public TextField getAreaMinField1() {
        return areaMinField1;
    }

    public TextField getAreaMaxField1() {
        return areaMaxField1;
    }

    public TextField getAreaMaxField() {
        return areaMaxField;
    }

    public TextField getSurnameFieldArea1() {
        return surnameFieldArea1;
    }

    public TextField getPerareaField() {
        return perareaField;
    }*/

}
