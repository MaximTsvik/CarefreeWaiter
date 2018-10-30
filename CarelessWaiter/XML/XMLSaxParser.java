package XML;

import Model.Dish;
import Model.DishBase;
import Model.Table;
import Model.TableBase;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

import java.util.ArrayList;
import java.util.List;

public class XMLSaxParser extends DefaultHandler {
    private Table table;
    private TableBase tableBase;
    private List<Table> tableList;
    private Dish dish;
    private DishBase dishBase;
    private List<Dish> dishList;
    private String currentElement;
    private StringBuilder content;

    public XMLSaxParser() {
        tableList = new ArrayList<>();
        dishList = new ArrayList<>();
        currentElement = "";
    }

    public List<Table> getTableList() { return tableList; }

    public List<Dish> getDishList() {
        return dishList;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Начинаем парсить");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Закончили парсить");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attr) {
        currentElement = qName;
        if (currentElement.equals("table")) {
            table = new Table();
            tableList.add(table);
            System.out.println("Новый table добавлен ура!");
        }
        if (currentElement.equals("dish")) {
            dish = new Dish();
            dishList.add(dish);
            System.out.println("Новый dish добавлен ура!");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        content = new StringBuilder(new String(ch, start, length));
    }

    @Override
    public void endElement(String uri, String localName, String qName) {

        if (currentElement.equals("number")) {
            table.setNumber(Integer.parseInt(content.toString()));
            return;
        }
        if (currentElement.equals("free")) {
            table.setFree(Boolean.parseBoolean(content.toString()));
        }
        if (currentElement.equals("name")) {
            dish.setName(content.toString());
            return;
        }
        if (currentElement.equals("category")) {
            dish.setCategory(content.toString());
            return;
        }
        if (currentElement.equals("cost")) {
            if(content.toString().contains("\t") || content.toString().contains("\n")) return;
            dish.setCost(Double.parseDouble(content.toString()));
            return;
        }
        if (currentElement.equals("value")) {
            if(content.toString().contains("\t") || content.toString().contains("\n")) return;
            dish.setValue(Double.parseDouble(content.toString()));
            return;
        }

    }

    public void setTableBase(TableBase tableBase) {this.tableBase = tableBase;}
    public void setBase(DishBase dishBase) {
        this.dishBase = dishBase;
    }
}