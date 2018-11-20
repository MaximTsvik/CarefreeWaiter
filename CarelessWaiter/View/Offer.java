package View;

import Controller.Controller;
import Model.Dish;
import Model.Table;
import javafx.collections.FXCollections;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Offer {

    private Form form;
    private Controller controller;

    public Offer(Controller controller) {
        this.controller = controller;
    }

    public void startoffer (Table table) {

        Label label2 = new Label("Выбран столик: " + table.getNumber());
        Label label1 = new Label("Вы вошли как: официант");
        Button button1 = new Button("Вернуться к выбору столика");
        form = new Form();
        Group Tablee = new Group();
        Tablee.getChildren().addAll(form.getDishTable());

        GridPane vodkaPane = new GridPane();
        vodkaPane.setHgap(30);
        vodkaPane.setVgap(30);
        vodkaPane.setVisible(false);

        GridPane whiskeyPane = new GridPane();
        whiskeyPane.setHgap(30);
        whiskeyPane.setVgap(30);
        whiskeyPane.setVisible(false);

        GridPane coctailsPane = new GridPane();
        coctailsPane.setHgap(30);
        coctailsPane.setVgap(30);
        coctailsPane.setVisible(false);

        GridPane beerPane = new GridPane();
        beerPane.setHgap(30);
        beerPane.setVgap(30);
        beerPane.setVisible(false);

        GridPane cognagPane = new GridPane();
        cognagPane.setHgap(30);
        cognagPane.setVgap(30);
        cognagPane.setVisible(false);

        GridPane tekilaPane = new GridPane();
        tekilaPane.setHgap(30);
        tekilaPane.setVgap(30);
        tekilaPane.setVisible(false);

        GridPane drinksPane = new GridPane();
        drinksPane.setHgap(30);
        drinksPane.setVgap(30);
        drinksPane.setVisible(false);

        GridPane waterPane = new GridPane();
        waterPane.setHgap(30);
        waterPane.setVgap(30);
        waterPane.setVisible(false);

        GridPane hotPane = new GridPane();
        hotPane.setHgap(30);
        hotPane.setVgap(30);
        hotPane.setVisible(false);

        GridPane coldPane = new GridPane();
        coldPane.setHgap(30);
        coldPane.setVgap(30);
        coldPane.setVisible(false);

        GridPane salatsPane = new GridPane();
        salatsPane.setHgap(30);
        salatsPane.setVgap(30);
        salatsPane.setVisible(false);

        GridPane soupsPane = new GridPane();
        soupsPane.setHgap(30);
        soupsPane.setVgap(30);
        soupsPane.setVisible(false);

        GridPane desertsPane = new GridPane();
        desertsPane.setHgap(30);
        desertsPane.setVgap(30);
        desertsPane.setVisible(false);

        Button vodka = new Button("Водка");
        Button whiskey = new Button("Виски");
        Button beer = new Button("Пиво");
        Button coctails = new Button("Коктейли");
        Button cognag = new Button("Коньяк");
        Button tekila = new Button("Текила");
        Button drinks = new Button("Напитки");
        Button water = new Button("Вода");
        Button hot = new Button("Горячие блюда");
        Button salats = new Button("Салаты");
        Button cold = new Button("Холодные закуски");
        Button soups = new Button("Супы");
        Button deserts = new Button("Десерты");
        Button back = new Button("Назад");

        Button barbutton = new Button("Бар");
        Button kitchenbutton = new Button("Кухня");

        Button predchek = new Button("Предчек");
        Button totheoffer = new Button("Отправить на заказ");

        vodka.setPrefSize(120,50);
        whiskey.setPrefSize(120,50);
        beer.setPrefSize(120,50);
        coctails.setPrefSize(120,50);
        cognag.setPrefSize(120,50);
        tekila.setPrefSize(120,50);
        drinks.setPrefSize(120,50);
        water.setPrefSize(120,50);
        barbutton.setPrefSize(180,50);
        kitchenbutton.setPrefSize(180,50);
        hot.setPrefSize(180,50);
        cold.setPrefSize(180,50);
        salats.setPrefSize(180,50);
        soups.setPrefSize(180,50);
        deserts.setPrefSize(180,50);
        totheoffer.setPrefSize(180,50);
        predchek.setPrefSize(180,50);

        GridPane bar = new GridPane();
        bar.setVgap(30);
        bar.setHgap(30);
        bar.setVisible(true);
        bar.getChildren().addAll(vodka, whiskey, beer, coctails, cognag, tekila, drinks, water);
        bar.setConstraints(vodka, 0,0);
        bar.setConstraints(whiskey, 1,0);
        bar.setConstraints(beer, 2,0);
        bar.setConstraints(coctails, 3,0);
        bar.setConstraints(cognag, 0,1);
        bar.setConstraints(tekila, 1,1);
        bar.setConstraints(drinks, 2,1);
        bar.setConstraints(water, 3,1);

        GridPane kitchen = new GridPane();
        kitchen.getChildren().addAll(hot, cold, salats, soups, deserts);
        kitchen.setConstraints(hot, 0,0);
        kitchen.setConstraints(cold, 1,0);
        kitchen.setConstraints(salats, 0,1);
        kitchen.setConstraints(soups, 1,1);
        kitchen.setConstraints(deserts, 2,0);
        kitchen.setVgap(30);
        kitchen.setHgap(30);
        kitchen.setVisible(false);

        Button upload = new Button("Сохранить");
        upload.setOnAction(event -> {
            Stage stage = new Stage();
            FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialDirectory(new java.io.File("./"));
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML", "*.xml"));
            File file = fileChooser.showSaveDialog(stage);
            controller.toFile(file);
        });

        List<Dish> resultOfOffer = new ArrayList<>();

        GridPane root1 = new GridPane();
        root1.getChildren().addAll(Tablee, label1,button1, label2,upload, bar, kitchen, barbutton, kitchenbutton, totheoffer, predchek, vodkaPane, whiskeyPane, waterPane, beerPane, drinksPane, tekilaPane, cognagPane, coctailsPane, hotPane, coldPane, desertsPane, soupsPane, salatsPane, back);
        root1.setPadding(new Insets(20, 20, 20, 100));
        root1.setVgap(25);
        root1.setHgap(25);
        root1.setConstraints(upload,3,4);
        root1.setConstraints(back,1,0);
        root1.setHalignment(back, HPos.RIGHT);
        root1.setConstraints(bar,1,2);
        root1.setConstraints(vodkaPane,1,2);
        root1.setConstraints(coctailsPane,1,2);
        root1.setConstraints(tekilaPane,1,2);
        root1.setConstraints(waterPane,1,2);
        root1.setConstraints(drinksPane,1,2);
        root1.setConstraints(cognagPane,1,2);
        root1.setConstraints(beerPane,1,2);
        root1.setConstraints(whiskeyPane,1,2);
        root1.setConstraints(kitchen,1,2);
        root1.setConstraints(barbutton, 1,2);
        root1.setConstraints(kitchenbutton, 1,2);
        root1.setValignment(barbutton, VPos.BOTTOM);
        root1.setValignment(kitchenbutton, VPos.BOTTOM);
        root1.setHalignment(barbutton, HPos.LEFT);
        root1.setHalignment(kitchenbutton, HPos.RIGHT);
        root1.setConstraints(totheoffer, 0,3);
        root1.setConstraints(label1,0,0);
        root1.setConstraints(button1,1,0);
        root1.setConstraints(label2,0,1);
        root1.setConstraints(Tablee,0,2);
        root1.setValignment(label2, VPos.TOP);
        root1.setConstraints(predchek, 0,4);
        root1.setConstraints(hotPane,1,2);
        root1.setConstraints(coldPane,1,2);
        root1.setConstraints(desertsPane,1,2);
        root1.setConstraints(soupsPane,1,2);
        root1.setConstraints(salatsPane,1,2);

        Scene scene = new Scene(root1, 1300, 650);
        Stage stage = new Stage();
        back.setOnAction(event -> {
            bar.setVisible(true);
            kitchen.setVisible(false);
            vodkaPane.setVisible(false);
            whiskeyPane.setVisible(false);
            beerPane.setVisible(false);
            coctailsPane.setVisible(false);
            cognagPane.setVisible(false);
            tekilaPane.setVisible(false);
            drinksPane.setVisible(false);
            waterPane.setVisible(false);
            hotPane.setVisible(false);
            coldPane.setVisible(false);
            salatsPane.setVisible(false);
            soupsPane.setVisible(false);
            desertsPane.setVisible(false);
        });
        whiskey.setOnAction(event -> {
            bar.setVisible(false);
            kitchen.setVisible(false);
            whiskeyPane.setVisible(true);
        });
        vodka.setOnAction(event -> {
            bar.setVisible(false);
            kitchen.setVisible(false);
            vodkaPane.setVisible(true);
        });
        beer.setOnAction(event -> {
            bar.setVisible(false);
            kitchen.setVisible(false);
            beerPane.setVisible(true);
        });
        coctails.setOnAction(event -> {
            bar.setVisible(false);
            kitchen.setVisible(false);
            coctailsPane.setVisible(true);
        });
        cognag.setOnAction(event -> {
            bar.setVisible(false);
            kitchen.setVisible(false);
            cognagPane.setVisible(true);
        });
        tekila.setOnAction(event -> {
            bar.setVisible(false);
            kitchen.setVisible(false);
            tekilaPane.setVisible(true);
        });
        drinks.setOnAction(event -> {
            bar.setVisible(false);
            kitchen.setVisible(false);
            drinksPane.setVisible(true);
        });
        water.setOnAction(event -> {
            bar.setVisible(false);
            kitchen.setVisible(false);
            waterPane.setVisible(true);
        });
        hot.setOnAction(event -> {
            bar.setVisible(false);
            kitchen.setVisible(false);
            hotPane.setVisible(true);
        });
        cold.setOnAction(event -> {
            bar.setVisible(false);
            kitchen.setVisible(false);
            coldPane.setVisible(true);
        });
        salats.setOnAction(event -> {
            bar.setVisible(false);
            kitchen.setVisible(false);
            salatsPane.setVisible(true);
        });
        deserts.setOnAction(event -> {
            bar.setVisible(false);
            kitchen.setVisible(false);
            desertsPane.setVisible(true);
        });
        soups.setOnAction(event -> {
            bar.setVisible(false);
            kitchen.setVisible(false);
            soupsPane.setVisible(true);
        });
        kitchenbutton.setOnAction(e ->{
            bar.setVisible(false);
            kitchen.setVisible(true);
        });
        barbutton.setOnAction(e ->{
            bar.setVisible(true);
            kitchen.setVisible(false);
        });
        button1.setOnAction(e -> {
            table.dishBase = new ArrayList<>();
            stage.close();
        });

        stage.setTitle("Официант");
        stage.setScene(scene);

        totheoffer.setOnAction(e ->{
            if (table.isFree()) table.setFree(false);
            FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialDirectory(new java.io.File("./"));
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML", "*.xml"));
            File file = fileChooser.showSaveDialog(stage);
            controller.toFile(file);
            stage.close();
        });

        predchek.setOnAction(e ->{
            FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialDirectory(new java.io.File("./"));
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML", "*.xml"));
            File file = fileChooser.showSaveDialog(stage);
            controller.toFile(file);
        });

        form.setList(table.dishBase);
        form.getDishTable().setItems(FXCollections.observableArrayList(table.dishBase));

        int columnIndex=0, rowIndex=0, i=0, v=0, w=0, d=0, ds=0, s=0, sp=0, wt=0, b=0, c=0, cc=0, cl=0, t=0, h=0;
        for (Dish dish : controller.getDishBase()){
            if (dish.getCategory().equals("vodka")){
                i++;
                Button vodkaButton = new Button(dish.getName());
                vodkaButton.setOnAction(actionEvent -> {
                    table.dishBase.add(dish);
                    resultOfOffer.add(dish);
                    form.setList(table.dishBase);
                    form.getDishTable().setItems(FXCollections.observableArrayList(table.dishBase));
                });
                vodkaButton.setPrefSize(120,50);
                vodkaPane.getChildren().addAll(vodkaButton);
                vodkaPane.setConstraints(vodkaButton, columnIndex, v);
                if (i % 4 == 0){ v++; columnIndex = 0; i=0; } else columnIndex++;
            }
            if (dish.getCategory().equals("whiskey")){
                i++;
                Button whiskeyButton = new Button(dish.getName());
                whiskeyButton.setPrefSize(120,50);
                whiskeyPane.getChildren().addAll(whiskeyButton);
                whiskeyPane.setConstraints(whiskeyButton, columnIndex, w);
                if (i % 4 == 0){ w++; columnIndex = 0; i=0; } else columnIndex++;
                whiskeyButton.setOnAction(event1 -> {
                    table.dishBase.add(dish);
                    resultOfOffer.add(dish);
                    form.setList(table.dishBase);
                    form.getDishTable().setItems(FXCollections.observableArrayList(table.dishBase));
                });
            }
            if (dish.getCategory().equals("beer")){
                i++;
                Button beerButton = new Button(dish.getName());
                beerButton.setPrefSize(120,50);
                beerPane.getChildren().addAll(beerButton);
                beerPane.setConstraints(beerButton, columnIndex, b);
                if (i % 4 == 0){ b++; columnIndex = 0; i=0; } else columnIndex++;
                beerButton.setOnAction(event1 -> {
                    table.dishBase.add(dish);
                    resultOfOffer.add(dish);
                    form.setList(table.dishBase);
                    form.getDishTable().setItems(FXCollections.observableArrayList(table.dishBase));
                });
            }
            if (dish.getCategory().equals("cognag")){
                i++;
                Button cognagButton = new Button(dish.getName());
                cognagButton.setPrefSize(120,50);
                cognagPane.getChildren().addAll(cognagButton);
                cognagPane.setConstraints(cognagButton, columnIndex, c);
                if (i % 4 == 0){ c++; columnIndex = 0; i=0; } else columnIndex++;
                cognagButton.setOnAction(event1 -> {
                    table.dishBase.add(dish);
                    resultOfOffer.add(dish);
                    form.setList(table.dishBase);
                    form.getDishTable().setItems(FXCollections.observableArrayList(table.dishBase));
                });
            }
            if (dish.getCategory().equals("tekila")){
                i++;
                Button tekilaButton = new Button(dish.getName());
                tekilaButton.setPrefSize(120,50);
                tekilaPane.getChildren().addAll(tekilaButton);
                tekilaPane.setConstraints(tekilaButton, columnIndex, t);
                if (i % 4 == 0){ t++; columnIndex = 0; i=0; } else columnIndex++;
                tekilaButton.setOnAction(event1 -> {
                    table.dishBase.add(dish);
                    resultOfOffer.add(dish);
                    form.setList(table.dishBase);
                    form.getDishTable().setItems(FXCollections.observableArrayList(table.dishBase));
                });
            }
            if (dish.getCategory().equals("coctails")){
                i++;
                Button coctailsButton = new Button(dish.getName());
                coctailsButton.setPrefSize(120,50);
                coctailsPane.getChildren().addAll(coctailsButton);
                coctailsPane.setConstraints(coctailsButton, columnIndex, cc);
                if (i % 4 == 0){ cc++; columnIndex = 0; i=0; } else columnIndex++;
                coctailsButton.setOnAction(event1 -> {
                    table.dishBase.add(dish);
                    resultOfOffer.add(dish);
                    form.setList(table.dishBase);
                    form.getDishTable().setItems(FXCollections.observableArrayList(table.dishBase));
                });
            }
            if (dish.getCategory().equals("drinks")){
                i++;
                Button drinksButton = new Button(dish.getName());
                drinksButton.setPrefSize(120,50);
                drinksPane.getChildren().addAll(drinksButton);
                drinksPane.setConstraints(drinksButton, columnIndex, d);
                if (i % 4 == 0){ d++; columnIndex = 0; i=0; } else columnIndex++;
                drinksButton.setOnAction(event1 -> {
                    table.dishBase.add(dish);
                    resultOfOffer.add(dish);
                    form.setList(table.dishBase);
                    form.getDishTable().setItems(FXCollections.observableArrayList(table.dishBase));
                });
            }
            if (dish.getCategory().equals("water")){
                i++;
                Button waterButton = new Button(dish.getName());
                waterButton.setPrefSize(120,50);
                waterPane.getChildren().addAll(waterButton);
                waterPane.setConstraints(waterButton, columnIndex, wt);
                if (i % 4 == 0){ wt++; columnIndex = 0; i=0; } else columnIndex++;
                waterButton.setOnAction(event1 -> {
                    table.dishBase.add(dish);
                    resultOfOffer.add(dish);
                    form.setList(table.dishBase);
                    form.getDishTable().setItems(FXCollections.observableArrayList(table.dishBase));
                });
            }
            if (dish.getCategory().equals("hot")){
                i++;
                Button hotButton = new Button(dish.getName());
                hotButton.setPrefSize(180,50);
                hotPane.getChildren().addAll(hotButton);
                hotPane.setConstraints(hotButton, columnIndex, h);
                if (i % 4 == 0){ h++; columnIndex = 0; i=0; } else columnIndex++;
                hotButton.setOnAction(event1 -> {
                    table.dishBase.add(dish);
                    resultOfOffer.add(dish);
                    form.setList(table.dishBase);
                    form.getDishTable().setItems(FXCollections.observableArrayList(table.dishBase));
                });
            }
            if (dish.getCategory().equals("cold")){
                i++;
                Button coldButton = new Button(dish.getName());
                coldButton.setPrefSize(180,50);
                coldPane.getChildren().addAll(coldButton);
                coldPane.setConstraints(coldButton, columnIndex, cl);
                if (i % 4 == 0){ cl++; columnIndex = 0; i=0; } else columnIndex++;
                coldButton.setOnAction(event1 -> {
                    table.dishBase.add(dish);
                    resultOfOffer.add(dish);
                    form.setList(table.dishBase);
                    form.getDishTable().setItems(FXCollections.observableArrayList(table.dishBase));
                });
            }
            if (dish.getCategory().equals("salats")){
                i++;
                Button salatsButton = new Button(dish.getName());
                salatsButton.setPrefSize(180,50);
                salatsPane.getChildren().addAll(salatsButton);
                salatsPane.setConstraints(salatsButton, columnIndex, s);
                if (i % 4 == 0){ s++; columnIndex = 0; i=0; } else columnIndex++;
                salatsButton.setOnAction(event1 -> {
                    table.dishBase.add(dish);
                    resultOfOffer.add(dish);
                    form.setList(table.dishBase);
                    form.getDishTable().setItems(FXCollections.observableArrayList(table.dishBase));
                });
            }
            if (dish.getCategory().equals("soups")){
                i++;
                Button soupsButton = new Button(dish.getName());
                soupsButton.setPrefSize(180,50);
                soupsPane.getChildren().addAll(soupsButton);
                soupsPane.setConstraints(soupsButton, columnIndex, sp);
                if (i % 4 == 0){ sp++; columnIndex = 0; i=0; } else columnIndex++;
                soupsButton.setOnAction(event1 -> {
                    table.dishBase.add(dish);
                    resultOfOffer.add(dish);
                    form.setList(table.dishBase);
                    form.getDishTable().setItems(FXCollections.observableArrayList(table.dishBase));
                });
            }
            if (dish.getCategory().equals("deserts")){
                i++;
                Button desertsButton = new Button(dish.getName());
                desertsButton.setPrefSize(180,50);
                desertsPane.getChildren().addAll(desertsButton);
                desertsPane.setConstraints(desertsButton, columnIndex, ds);
                if (i % 4 == 0){ ds++; columnIndex = 0; i=0; } else columnIndex++;
                desertsButton.setOnAction(event1 -> {
                    table.dishBase.add(dish);
                    resultOfOffer.add(dish);
                    form.setList(table.dishBase);
                    form.getDishTable().setItems(FXCollections.observableArrayList(table.dishBase));
                });
            }
        }

        stage.showAndWait();
    }

    public void update() {
        form.clear();
        form.setList(controller.getDishBase());
        form.getDishTable().setItems(FXCollections.observableArrayList(controller.getDishBase()));
    }

}
