package View;

import Controller.Controller;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static javafx.geometry.Orientation.*;
import static javax.swing.SwingConstants.VERTICAL;

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

        GridPane startovaya = new GridPane();
        Start start = new Start();
        start.startStart(startovaya);
        startovaya.setHgap(5);
        startovaya.setVgap(5);
        startovaya.setPadding(new Insets(30, 30, 30, 30));

       /* Button admin = new Button("Администратор");
        admin.setPrefSize(200,60);
        Button waiter = new Button("Официант");
        waiter.setPrefSize(200,60);
        Label  AdminOrWaiter = new Label("Выбери, кто ты, мразь: ");
        Stage stage1 = new Stage();*/

      /* ToolBar tb = new ToolBar();
        tb.cursorProperty();
        Button load = new Button("Загрузка");
        load.setOnAction( e -> {
            controller.getStudentBase().clear();
            Stage stage = new Stage();
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Открытие");
            fileChooser.setInitialDirectory(new java.io.File("./"));
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML", "*.xml"));
            File file = fileChooser.showOpenDialog(stage);
            controller.setFile(file);
            controller.fromFile();
            update();
        });
        Button save = new Button("Сохранение");
        save.setOnAction( e -> {
            Stage stage = new Stage();
            FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialDirectory(new java.io.File("./"));
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML", "*.xml"));
            File file = fileChooser.showSaveDialog(stage);

            controller.toFile(file);
        });
        Button add = new Button("Админ");
        add.setOnAction( e -> {
            AddFrame addFrame = new AddFrame(this, this.controller);
        });
        Button search = new Button("Офик");
        search.setOnAction( e -> {
            SearchFrame searchFrame = new SearchFrame(this, this.controller);
            searchFrame.start();
        });

        tb.getItems().addAll(load, save);
        tb.setOrientation(Orientation.HORIZONTAL);

        MenuBar menuBar = new MenuBar();
        Menu menuF = new Menu("Файл");
        MenuItem admin2 = new MenuItem("Админ");
       /* admin3.setOnAction(e -> {
            controller.getStudentBase().clear();
            Stage stage = new Stage();
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Открытие");
            fileChooser.setInitialDirectory(new java.io.File("./"));
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML", "*.xml"));
            File file = fileChooser.showOpenDialog(stage);
            controller.setFile(file);
            controller.fromFile();
            update();
        });
        MenuItem waiter2 = new MenuItem("Офик");
        waiter.setOnAction(e -> {
            Stage stage = new Stage();
            FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialDirectory(new java.io.File("./"));
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML", "*.xml"));
            File file = fileChooser.showSaveDialog(stage);

            controller.toFile(file);
        });
        menuF.getItems().addAll(admin2, waiter2);*/

        /*Menu menuT = new Menu();
        MenuItem menuAdd = new MenuItem("Официант");
        MenuItem menuSearch = new MenuItem("Админ");
        menuT.getItems().addAll(menuAdd, menuSearch);

        menuBar.getMenus().addAll(menuT);

        menuAdd.setOnAction(e -> {
            System.out.println("Добавилось ура!");
            AddFrame addFrame = new AddFrame(this, this.controller);
        });

        menuSearch.setOnAction(e -> {
            System.out.println("Нашлось ура!");
            SearchFrame searchFrame = new SearchFrame(this, this.controller);
            searchFrame.start();
        });

        form = new Form();
        form.setList(controller.getStudentBase());

        VBox menushka = new VBox();
        menushka.setPadding(new Insets(50, 100, 30, 10));
        menushka.setSpacing(20);

        HBox collectiveMemberBox = new HBox();
        collectiveMemberBox.setSpacing(20);
        collectiveMemberBox.getChildren().addAll(form.getPaneBox());
        menushka.getChildren().addAll(tb);*/

        Scene scene = new Scene(new Group(), 400, 150);
        ((Group)scene.getRoot()).getChildren().addAll(startovaya);
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
