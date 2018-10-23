package View;

import Controller.Controller;
import Model.Dish;
import javafx.collections.FXCollections;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.plaf.metal.MetalBorders;
import java.io.File;
import java.util.List;

public class Offer {

    private Form form;
   // private MainFrame mainFrame;
    private Controller controller;
    private Dish dish;

    public Offer(Controller controller) {
        this.controller = controller;
    }

    public void startoffer (int number) {
        Label label2 = new Label("Выбран столик: " + number);
        Label label1 = new Label("Вы вошли как: официант");
        Button button1 = new Button("Вернуться к выбору столика");

        Button load = new Button("Загрузка");
        GridPane vodkaPane = new GridPane();
        vodkaPane.setHgap(30);
        vodkaPane.setVgap(30);
        vodkaPane.setVisible(false);
        Button vodka = new Button("Водка");

        load.setOnAction( e -> {
            controller.getDishBase().clear();
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


        Button upload = new Button("Сохранить");
        upload.setOnAction(event -> {
            Stage stage = new Stage();
            FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialDirectory(new java.io.File("./"));
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML", "*.xml"));
            File file = fileChooser.showSaveDialog(stage);
            controller.toFile(file);
        });



        Button test = new Button("Меню");
        test.setOnAction(event -> {
            int columnIndex=0, rowIndex=0, i=0;
            for (Dish dish : controller.getDishBase()){

                if (dish.getCategory().equals("vodka")){
                    i++;
                    Button vodkaButton = new Button(dish.getName());
                    vodkaButton.setPrefSize(120,50);
                    vodkaPane.getChildren().addAll(vodkaButton);
                    vodkaPane.setConstraints(vodkaButton, columnIndex, rowIndex);
                    if (i % 4 == 0){ rowIndex++; columnIndex = 0; i=0; } else columnIndex++;
                }

            }
        });
        
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

        //водка
        /*Button svayak = new Button("Сваяк");
        Button finka = new Button("Finlandiya");
        Button absolut = new Button("Absolut");
        Button smirnoff = new Button("Smirnoff");*/

        //вискарь
        Button jameson = new Button("Jameson");
        Button jimBeam = new Button("JimBeam");
        Button jackDaniels = new Button("JackDaniels");
        Button grants = new Button("Grants");

        //пиво
        Button heineken = new Button("Heineken");
        Button bobrov = new Button("Бобров");
        Button zlatyBazant = new Button("ZlatyBazant");
        Button zhiguli = new Button("Жигули Барное");

        //коктейли
        Button longAilend = new Button("Лонг Айленд");
        Button b52 = new Button("Б-52");
        Button mohito = new Button("Мохито");
        Button pinaKolada = new Button("Пина Колада");

        //коньяк
        Button moldova5 = new Button("Молдова 5*");
        Button hennesey5 = new Button("Hennesey 5*");
        Button ararat5 = new Button("Арарат 5*");
        Button metaxa7 = new Button("Metaxa 7*");

        //текила
        Button joseCuervoGold = new Button("Jose Cuervo Gold");
        Button joseCuervoSelver = new Button("Jose Cuervo Silver");
        Button olmecaGold = new Button("Olmeca Gold");
        Button olmecaBlanco = new Button("Olmeca Blanco");

        //напитки
        Button cola = new Button("Кола");
        Button sprite = new Button("Спрайт");
        Button fanta = new Button("Фанта");
        Button shweppes = new Button("Швепс Биттер Лемон");

        //вода
        Button bonaquaYes = new Button("Бонаква ср/газ");
        Button bonaquaNo = new Button("Бонаква н/газ");
        Button borjomi = new Button("Боржоми");
        Button essentyki = new Button("Ессентуки");

        //горячие блюда
        Button newYork = new Button("Стейк New York");
        Button pork = new Button("Корейка-гриль");
        Button chikenGrill = new Button("Курица-гриль");
        Button salmon = new Button("Форель-гриль");
        Button porkShashlik = new Button("Шашлык из шеи");
        Button chikenShashlik = new Button("Шашлык из курицы");
        Button vegetables = new Button("Овощи-гриль");
        Button potatoes = new Button("Картофель по-домашнему");

        //холодные закуски
        Button vegetablesNar = new Button("Овощная нарезка");
        Button meatNar = new Button("Мясная нарезка");
        Button underVodka = new Button("Закуска под-водку");
        Button caprese = new Button("Капрезе");
        Button sirtaki = new Button("Сиртаки");
        Button lemon = new Button("Лимон");
        Button cheeseNar = new Button("Сырная палитра");
        Button soleniya = new Button("Ассорти из солений");

        //салаты
        Button cezar = new Button("Цезарь");
        Button greece = new Button("Греческий");
        Button olivie = new Button("Оливье");
        Button carrot = new Button("Морковь пикантная");

        //супы
        Button mushroomSoup = new Button("Крем-суп грибной");
        Button solyankaSoup = new Button("Солянка");
        Button schi = new Button("Щи");
        Button rossolnik = new Button("Россольник");

        //десерты
        Button fruitNar = new Button("Фруктовая палитра");
        Button iceCream = new Button("Мороженое");
        Button cheeseCake = new Button("Чизкейк");
        Button chocolateCake = new Button("Шоколадный торт");






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


        /*vodkaPane.getChildren().addAll(svayak, finka, absolut, smirnoff);
        vodkaPane.setConstraints(svayak, 0,0);
        vodkaPane.setConstraints(finka, 1,0);
        vodkaPane.setConstraints(absolut, 2,0);
        vodkaPane.setConstraints(smirnoff, 3,0);
        svayak.setPrefSize(120,50);
        finka.setPrefSize(120,50);
        absolut.setPrefSize(120,50);
        smirnoff.setPrefSize(120,50);
        vodkaPane.setHgap(30);
        vodkaPane.setVgap(30);
        vodkaPane.setVisible(false);*/

        GridPane whiskeyPane = new GridPane();
        whiskeyPane.getChildren().addAll(jameson, jackDaniels, jimBeam, grants);
        whiskeyPane.setConstraints(jameson, 0,0);
        whiskeyPane.setConstraints(jackDaniels, 1,0);
        whiskeyPane.setConstraints(jimBeam, 2,0);
        whiskeyPane.setConstraints(grants, 3,0);
        jameson.setPrefSize(120,50);
        jackDaniels.setPrefSize(120,50);
        jimBeam.setPrefSize(120,50);
        grants.setPrefSize(120,50);
        whiskeyPane.setHgap(30);
        whiskeyPane.setVgap(30);
        whiskeyPane.setVisible(false);

        GridPane beerPane = new GridPane();
        beerPane.getChildren().addAll(heineken, bobrov, zlatyBazant, zhiguli);
        beerPane.setConstraints(heineken, 0,0);
        beerPane.setConstraints(bobrov, 1,0);
        beerPane.setConstraints(zlatyBazant, 2,0);
        beerPane.setConstraints(zhiguli, 3,0);
        heineken.setPrefSize(120,50);
        bobrov.setPrefSize(120,50);
        zlatyBazant.setPrefSize(120,50);
        zhiguli.setPrefSize(120,50);
        beerPane.setHgap(30);
        beerPane.setVgap(30);
        beerPane.setVisible(false);

        GridPane coctailsPane = new GridPane();
        coctailsPane.getChildren().addAll(longAilend, b52, mohito, pinaKolada);
        coctailsPane.setConstraints(longAilend, 0,0);
        coctailsPane.setConstraints(b52, 1,0);
        coctailsPane.setConstraints(mohito, 2,0);
        coctailsPane.setConstraints(pinaKolada, 3,0);
        longAilend.setPrefSize(120,50);
        b52.setPrefSize(120,50);
        mohito.setPrefSize(120,50);
        pinaKolada.setPrefSize(120,50);
        coctailsPane.setHgap(30);
        coctailsPane.setVgap(30);
        coctailsPane.setVisible(false);

        GridPane cognagPane = new GridPane();
        cognagPane.getChildren().addAll(moldova5, metaxa7, hennesey5, ararat5);
        cognagPane.setConstraints(moldova5, 0,0);
        cognagPane.setConstraints(metaxa7, 1,0);
        cognagPane.setConstraints(hennesey5, 2,0);
        cognagPane.setConstraints(ararat5, 3,0);
        moldova5.setPrefSize(120,50);
        metaxa7.setPrefSize(120,50);
        hennesey5.setPrefSize(120,50);
        ararat5.setPrefSize(120,50);
        cognagPane.setHgap(30);
        cognagPane.setVgap(30);
        cognagPane.setVisible(false);

        GridPane tekilaPane = new GridPane();
        tekilaPane.getChildren().addAll(joseCuervoGold, joseCuervoSelver, olmecaBlanco, olmecaGold);
        tekilaPane.setConstraints(joseCuervoGold, 0,0);
        tekilaPane.setConstraints(joseCuervoSelver, 1,0);
        tekilaPane.setConstraints(olmecaBlanco, 2,0);
        tekilaPane.setConstraints(olmecaGold, 3,0);
        joseCuervoGold.setPrefSize(120,50);
        joseCuervoSelver.setPrefSize(120,50);
        olmecaBlanco.setPrefSize(120,50);
        olmecaGold.setPrefSize(120,50);
        tekilaPane.setHgap(30);
        tekilaPane.setVgap(30);
        tekilaPane.setVisible(false);

        GridPane drinksPane = new GridPane();
        drinksPane.getChildren().addAll(cola, sprite, fanta, shweppes);
        drinksPane.setConstraints(cola, 0,0);
        drinksPane.setConstraints(sprite, 1,0);
        drinksPane.setConstraints(fanta, 2,0);
        drinksPane.setConstraints(shweppes, 3,0);
        cola.setPrefSize(120,50);
        sprite.setPrefSize(120,50);
        fanta.setPrefSize(120,50);
        shweppes.setPrefSize(120,50);
        drinksPane.setHgap(30);
        drinksPane.setVgap(30);
        drinksPane.setVisible(false);

        GridPane waterPane = new GridPane();
        waterPane.getChildren().addAll(bonaquaNo, bonaquaYes, essentyki, borjomi);
        waterPane.setConstraints(bonaquaYes, 0,0);
        waterPane.setConstraints(bonaquaNo, 1,0);
        waterPane.setConstraints(borjomi, 2,0);
        waterPane.setConstraints(essentyki, 3,0);
        bonaquaYes.setPrefSize(120,50);
        bonaquaNo.setPrefSize(120,50);
        borjomi.setPrefSize(120,50);
        essentyki.setPrefSize(120,50);
        waterPane.setHgap(30);
        waterPane.setVgap(30);
        waterPane.setVisible(false);

        GridPane bar = new GridPane();
        bar.getChildren().addAll(vodka, whiskey, beer, coctails, cognag, tekila, drinks, water);
        bar.setConstraints(vodka, 0,0);
        bar.setConstraints(whiskey, 1,0);
        bar.setConstraints(beer, 2,0);
        bar.setConstraints(coctails, 3,0);
        bar.setConstraints(cognag, 0,1);
        bar.setConstraints(tekila, 1,1);
        bar.setConstraints(drinks, 2,1);
        bar.setConstraints(water, 3,1);
        bar.setVgap(30);
        bar.setHgap(30);
        bar.setVisible(true);

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

        form = new Form();
        Group Table = new Group();
        Table.getChildren().addAll(form.getDishTable());

        GridPane root1 = new GridPane();
        root1.getChildren().addAll(Table, label1,button1, label2,load,upload,test, bar, kitchen, barbutton, kitchenbutton, totheoffer, predchek, vodkaPane, whiskeyPane, waterPane, beerPane, drinksPane, tekilaPane, cognagPane, coctailsPane, back);
        root1.setPadding(new Insets(20, 20, 20, 100));
        root1.setVgap(25);
        root1.setHgap(25);
        root1.setConstraints(load,0,0);
        root1.setConstraints(test,4,4);
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
        root1.setConstraints(Table,0,2);
        root1.setValignment(label2, VPos.TOP);
        root1.setConstraints(predchek, 0,4);

        Scene scene = new Scene(root1, 1050, 600);
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
        cola.setOnAction(event -> {
            System.out.println();
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
        //svayak.setOnAction(event -> {
            /*AddFrame addFrame = new AddFrame(this.mainFrame, this.controller);
            AddFrame.sta
            /*Dish svayak1 = new Dish();
            svayak1.setName("Сваяк");
            svayak1.setCost(2.5);
            svayak1.setValue(0.05);
            controller.addDish(svayak1);
            form.clear();
            form.setList(controller.getDishBase());
            form.getDishTable().setItems(FXCollections.observableArrayList(controller.getDishBase()));*/
        //});
        kitchenbutton.setOnAction(e ->{
            bar.setVisible(false);
            kitchen.setVisible(true);
        });
        barbutton.setOnAction(e ->{
            bar.setVisible(true);
            kitchen.setVisible(false);
        });
        button1.setOnAction(e -> {
            stage.close();
        });
        stage.setTitle("Официант");
        stage.setScene(scene);

        totheoffer.setOnAction(e ->{
            FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialDirectory(new java.io.File("./"));
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML", "*.xml"));
            File file = fileChooser.showSaveDialog(stage);
            controller.toFile(file);
        });

        predchek.setOnAction(e ->{
            FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialDirectory(new java.io.File("./"));
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML", "*.xml"));
            File file = fileChooser.showSaveDialog(stage);
            controller.toFile(file);
        });

        stage.showAndWait();
    }

    public void update() {
        form.clear();
        form.setList(controller.getDishBase());
        form.getDishTable().setItems(FXCollections.observableArrayList(controller.getDishBase()));
    }

}
