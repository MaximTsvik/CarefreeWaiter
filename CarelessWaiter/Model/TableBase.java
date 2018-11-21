package Model;

import Controller.Controller;
import View.Form;
import View.MainFrame;
import XML.XMLSaxParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TableBase {

    private Controller controller;
    private List<Table> tableBase = new ArrayList();
    private File file;
    private Form form;

    public TableBase(Controller controller) {
        this.controller = controller;
    }

    public List<Table> getTableBase() {
        return tableBase;
    }

    public void add(Table table) {
        tableBase.add(table);
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public void fromFile() {
        setForm(form);
        SAXParserFactory factory = SAXParserFactory.newInstance();
        XMLSaxParser saxParser = new XMLSaxParser();
        saxParser.setTableBase(this);
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(file, saxParser);
            for (Table table : saxParser.getTableList()) {
                controller.addTable(table);
                System.out.println(table.getNumber());
                System.out.println(table.isFree());
            }
        } catch (SAXException | ParserConfigurationException | IOException ex){
        }}

}
