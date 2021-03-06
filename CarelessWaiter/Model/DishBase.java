package Model;

import Controller.Controller;
import View.Form;
import View.MainFrame;
import XML.XMLDomParser;
import XML.XMLSaxParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DishBase {
    private Controller controller;
    private List<Dish> dishBase = new ArrayList();
    private File file;

    public DishBase(Controller controller) {
        this.controller = controller;
    }

    public void add(Dish dish) {
        dishBase.add(dish);
    }

    public List<Dish> getDishBase() {
        return dishBase;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void toFile1(File file, Table table) {
        XMLDomParser domParser = new XMLDomParser();
        domParser.write1(file, table);
    }

    public void toFile2(File file, Table table) {
        XMLDomParser domParser = new XMLDomParser();
        domParser.write2(file, table);
    }

    public void fromFile() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        XMLSaxParser saxParser = new XMLSaxParser();
        saxParser.setBase(this);
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(file, saxParser);
            for (Dish dish : saxParser.getDishList()) {
                controller.addDish(dish);
                System.out.println(dish.getName());
                System.out.println(dish.getCost());
                System.out.println(dish.getValue());
                System.out.println(dish.getCategory());

            }
        } catch (SAXException | ParserConfigurationException | IOException ex) { }
    }
    }