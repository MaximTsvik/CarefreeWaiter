package XML;

import Model.Dish;
import Model.DishBase;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

import java.util.ArrayList;
import java.util.List;

public class XMLSaxParser extends DefaultHandler {
    private Dish dish;
    private DishBase dishBase;
    private List<Dish> dishList;
    private String currentElement;
    private StringBuilder content;

    public XMLSaxParser() {
        dishList = new ArrayList<>();
        currentElement = "";
    }

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

        if (currentElement.equals("name")) {
            dish.setName(content.toString());
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
    public void setBase(DishBase dishBase) {
        this.dishBase = dishBase;
    }
}