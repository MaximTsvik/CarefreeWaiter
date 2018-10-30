package View;


import Model.Dish;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.util.ArrayList;
import java.util.List;

public class Form {

    private TableView<Dish> dishTable;
    private VBox paneBox;
    private List<Dish> dishList;

    public Form() {
       dishTable = new TableView<>();

        List<TableColumn> listOfColumns = new ArrayList<>();

        TableColumn<Dish,String> dishName = new TableColumn<>("Имя");
        dishName.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getName()));
        dishName.setMinWidth(136);

        TableColumn<Dish,Double> dishValue = new TableColumn<>("Объем");
        dishValue.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getValue()));
        dishValue.setMinWidth(30);

        TableColumn<Dish,Double> dishCost = new TableColumn<>("Цена");
        dishCost.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getCost()));
        dishCost.setMinWidth(30);

        dishTable.setPrefSize(300,300);

        dishTable.getColumns().addAll(dishName, dishValue, dishCost);

        //paneBox = new VBox(20);

        /*Label currentPageLabel = new Label("Текущая страница: "+ (currentPage+1));

        allPageLabel = new Label("Кол-во страниц: " + 0);
        allRecordsLabel = new Label();
        Label recordOnPages = new Label("Кол-во записей на странице: " + recordsOnPage);

        Button firstPage = new Button("Первая страница");
        firstPage.setOnAction(e-> {
            currentPage = 0;
            setCurrentPage(currentPage);
            currentPageLabel.setText("Текущая страница: "+ (currentPage+1));
        });

        Button previousPage = new Button("Предыдущая страница");
        previousPage.setOnAction(e -> {
            if(currentPage>0){
                currentPage--;
                setCurrentPage(currentPage);
                currentPageLabel.setText("Такущая страница: "+ (currentPage+1));
            }
        });

        Button nextPage = new Button("Следующая страница");
        nextPage.setOnAction(e -> {
            if(currentPage<(list.size()-1)/recordsOnPage){
                currentPage++;
                setCurrentPage(currentPage);
                currentPageLabel.setText("Текущая страница: "+ (currentPage+1));
            }
        });

        Button lastPage = new Button("Последняя страница");
        lastPage.setOnAction(e -> {
            currentPage=(list.size()-1)/recordsOnPage;
            setCurrentPage(currentPage);
            currentPageLabel.setText("Текущая страница: "+ (currentPage+1));
        });


        TextField recordOnPagesField = new TextField();
        recordOnPagesField.setPromptText("Кол-во записей на странице: ");
        Button enterRecord = new Button("OK");
        enterRecord.setOnAction(e -> {
            int records = Integer.parseInt(recordOnPagesField.getText());
            recordsOnPage=records;
            recordOnPages.setText("Кол-во записей на странице: " + recordsOnPage);
            currentPage=0;
            setCurrentPage(currentPage);
            currentPageLabel.setText("Текущая страница: "+(currentPage+1));
            recordOnPagesField.clear();
            allPageLabel.setText("Кол-во страниц: " + (int)Math.ceil((double)list.size()/recordsOnPage));

        });*/
        /*pageBox.getChildren().addAll(firstPage, previousPage, nextPage, lastPage, currentPageLabel, allPageLabel,
                allRecordsLabel, recordOnPages, recordOnPagesField, enterRecord);*/

    }

    /*public VBox getPaneBox() {
        return paneBox;
    }*/

    public TableView<Dish> getDishTable() {
        return dishTable;
    }

    public void clear() {
        ObservableList<Dish> dishList = FXCollections.observableArrayList();
        dishTable.setItems(dishList);
    }

    public void setList(List<Dish> dishList)
    {
        this.dishList = dishList;
    }

    public void addToList (List<Dish> dishList, Dish dish){
        this.dishList.add(dish);
    }

   /* public void setCurrentPage(int currentPage) {
        List<Student> page = new ArrayList<>();
        int numberOfRecords = recordsOnPage;
        if((list.size()-currentPage*recordsOnPage)<recordsOnPage) {
            numberOfRecords = this.list.size()-currentPage*recordsOnPage;
        }

        for (int stud=currentPage*recordsOnPage;stud<currentPage*recordsOnPage+numberOfRecords;stud++){
            page.add(this.list.get(stud));
        }
        clear();
        studentTable.setItems(FXCollections.observableArrayList(page));
    }*/
}
